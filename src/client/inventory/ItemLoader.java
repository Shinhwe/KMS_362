package client.inventory;

import client.MapleClient;
import constants.GameConstants;
import database.DatabaseConnection;
import server.MapleItemInformationProvider;
import server.maps.BossReward;
import tools.Pair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum ItemLoader
{
  INVENTORY("inventoryitems", "inventoryequipment", 0, "characterid"), STORAGE("inventoryitems", "inventoryequipment", 1, "accountid"), CASHSHOP("csitems", "csequipment", 2, "accountid"), HIRED_MERCHANT("hiredmerchitems", "hiredmerchequipment", 5, "packageid"), DUEY("dueyitems", "dueyequipment", 6, "packageid");

  private final int value;

  private final String table;

  private final String table_equip;


  private final String arg;

  ItemLoader (String table, String table_equip, int value, String arg)
  {
    this.table = table;
    this.table_equip = table_equip;
    this.value = value;
    this.arg = arg;
  }

  public static boolean isCanMadeItem (Equip equip)
  {
    MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
    if (ii.getName(equip.getItemId()) == null)
    {
      return true;
    }
    if (ii.getName(equip.getItemId()).startsWith("제네시스"))
    {
      return true;
    }
    if (equip.getFlame() > 0L && (GameConstants.isRing(equip.getItemId()) || equip.getItemId() / 1000 == 1092 || equip.getItemId() / 1000 == 1342 || equip.getItemId() / 1000 == 1713 || equip.getItemId() / 1000 == 1712 || equip.getItemId() / 1000 == 1152 || equip.getItemId() / 1000 == 1143 || equip.getItemId() / 1000 == 1672 || GameConstants.isSecondaryWeapon(equip.getItemId()) || equip.getItemId() / 1000 == 1190 || equip.getItemId() / 1000 == 1182 || equip.getItemId() / 1000 == 1662 || equip.getItemId() / 1000 == 1802))
    {
      equip.setFlame(0L);
    }

    if (equip.getArcLevel() > 20)
    {
      equip.setArcLevel(20);
    }
    // if (equip.getArcPower() > 220)
    // {
    //   equip.setArcPower(220);
    // }
    if ((GameConstants.isArcaneSymbol(equip.getItemId()) || GameConstants.isAuthenticSymbol(equip.getItemId()) || equip.getItemId() / 1000 == 1162) && equip.getItemId() != 1162002 && equip.getState() > 0)
    {
      equip.setState((byte) 0);
      equip.setLines((byte) 0);
      equip.setPotential1(0);
      equip.setPotential2(0);
      equip.setPotential3(0);
      equip.setPotential4(0);
      equip.setPotential5(0);
      equip.setPotential6(0);
    }
    if (equip.getItemId() == 1672077)
    {
      int wonflag = equip.getFlag();
      int flag = equip.getFlag();
      if (ItemFlag.RETURN_SCROLL.check(flag))
      {
        flag -= ItemFlag.RETURN_SCROLL.getValue();
      }
      if (ItemFlag.PROTECT_SHIELD.check(flag))
      {
        flag -= ItemFlag.PROTECT_SHIELD.getValue();
      }
      if (ItemFlag.SAFETY_SHIELD.check(flag))
      {
        flag -= ItemFlag.SAFETY_SHIELD.getValue();
      }
      if (ItemFlag.RECOVERY_SHIELD.check(flag))
      {
        flag -= ItemFlag.RECOVERY_SHIELD.getValue();
      }
      if (flag == 16)
      {
        equip.setFlag(0);
      }
      if (flag == 24)
      {
        equip.setFlag(8);
      }
      if (ItemFlag.RETURN_SCROLL.check(wonflag))
      {
        equip.setFlag(equip.getFlag() | ItemFlag.RETURN_SCROLL.getValue());
      }
      if (ItemFlag.PROTECT_SHIELD.check(wonflag))
      {
        equip.setFlag(equip.getFlag() | ItemFlag.PROTECT_SHIELD.getValue());
      }
      if (ItemFlag.SAFETY_SHIELD.check(wonflag))
      {
        equip.setFlag(equip.getFlag() | ItemFlag.SAFETY_SHIELD.getValue());
      }
      if (ItemFlag.RECOVERY_SHIELD.check(wonflag))
      {
        equip.setFlag(equip.getFlag() | ItemFlag.RECOVERY_SHIELD.getValue());
      }
    }
    if (equip.getItemId() == 1162002 && equip.getKarmaCount() > 0)
    {
      equip.setKarmaCount((byte) -1);
    }
    if (equip.getItemId() == 1182285 || equip.getItemId() == 1122430 || ii.getEquipStats(equip.getItemId()).get("undecomposable") != null || ii.getEquipStats(equip.getItemId()).get("unsyntesizable") != null)
    {
      return true;
    }

    if (equip.getItemId() == 1672082)
    {
      equip.setPotential1(60011);
      equip.setPotential2(60010);
    }
    if (equip.getItemId() == 1672083)
    {
      equip.setState((byte) 20);
      equip.setLines((byte) 3);
      equip.setPotential1(40601);
      equip.setPotential2(30291);
      equip.setPotential3(42061);
      equip.setPotential4(42060);
      equip.setPotential5(42060);
      equip.setStarForceLevel((byte) 15);
      equip.calcStarForceStats();
    }
    if (equip.getItemId() == 1672085 || equip.getItemId() == 1672086)
    {
      equip.setState((byte) 20);
      equip.setLines((byte) 2);
      equip.setPotential1(40601);
      equip.setPotential2(30291);
      equip.setStarForceLevel((byte) 15);
      equip.calcStarForceStats();
    }
    return true;
  }

  public int getValue ()
  {
    return this.value;
  }

  public Map<Long, Item> loadItems (boolean login, int id, MapleInventoryType type) throws SQLException
  {
    Map<Long, Item> items = new LinkedHashMap<>();
    StringBuilder query = new StringBuilder();
    query.append("SELECT * FROM `");
    if (this.value <= 1)
    {
      switch (type.getType())
      {
        case 2:
          query.append("inventoryitemsuse");
          break;
        case 3:
          query.append("inventoryitemssetup");
          break;
        case 4:
          query.append("inventoryitemsetc");
          break;
        case 5:
          query.append("inventoryitemscash");
          break;
        case 6:
          query.append("inventoryitemscody");
          break;
        default:
          query.append("inventoryitems");
          break;
      }
    }
    else
    {
      query.append(this.table);
    }
    query.append("` LEFT JOIN `");
    if (this.value <= 1 && type.getType() == 6)
    {
      query.append("inventoryequipmentcody");
    }
    else
    {
      query.append(this.table_equip);
    }
    query.append("` USING (`inventoryitemid`) WHERE `type` = ?");
    query.append(" AND `");
    query.append(this.arg);
    query.append("` = ?");
    if (login)
    {
      query.append(" AND `inventorytype` = ");
      query.append(MapleInventoryType.EQUIPPED.getType());
    }
    Connection con = DatabaseConnection.getConnection();
    try (PreparedStatement ps = con.prepareStatement(query.toString()))
    {
      ps.setInt(1, this.value);
      ps.setInt(2, id);
      try (ResultSet rs = ps.executeQuery())
      {
        MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
        while (rs.next())
        {
          int itemId = rs.getInt("itemid");

          if (!ii.itemExists(itemId))
          {
            continue;
          }
          if (rs.getInt("itemid") / 1000000 == 1)
          {
            short position = rs.getShort("position");

            long uniqueId = rs.getLong("uniqueid");

            int flag = rs.getInt("flag");

            EquipTemplate template = MapleItemInformationProvider.getInstance().getTempateByItemId(itemId);

            Equip equip = new Equip(template, position, flag, uniqueId);

            if (!login)
            {
              byte enchantLevel = rs.getByte("enchantLevel");

              byte totalUpgradeSlots = rs.getByte("upgradeslots");

              byte hammerCount = rs.getByte("ViciousHammer");

              equip.setSuccessUpgradeSlots(enchantLevel);

              equip.setExtraUpgradeSlots(hammerCount);

              equip.setFailUpgradeSlots((byte) (template.getUpgradeSlots() + hammerCount - enchantLevel - totalUpgradeSlots));

              equip.setQuantity((short) 1);

              equip.setInventoryId(rs.getLong("inventoryitemid"));

              equip.setOwner(rs.getString("owner"));

              equip.setExpiration(rs.getLong("expiredate"));

              int reqLevel = rs.getInt("reqLevel");

              if (reqLevel > 0)
              {
                equip.setEnchantReductReqLevel((byte) (template.getReqLevel() - reqLevel));
              }

              if (equip.getItemId() >= 1113098 && equip.getItemId() <= 1113128)
              {
                equip.setItemLevel(enchantLevel);
                equip.setEnchantLevel((byte) 0);
              }
              else
              {
                equip.setItemLevel((byte) 0);
                equip.setEnchantLevel(enchantLevel);
              }
              equip.setEnchantStr(rs.getShort("str"));
              equip.setEnchantDex(rs.getShort("dex"));
              equip.setEnchantInt(rs.getShort("int"));
              equip.setEnchantLuk(rs.getShort("luk"));
              equip.setEnchantHp(rs.getShort("hp"));
              equip.setEnchantMp(rs.getShort("mp"));
              equip.setEnchantWatk(rs.getShort("watk"));
              equip.setEnchantMatk(rs.getShort("matk"));
              equip.setEnchantWdef(rs.getShort("wdef"));
              equip.setEnchantMdef(rs.getShort("mdef"));
              equip.setEnchantAccuracy(rs.getShort("accuracy"));
              equip.setEnchantAvoid(rs.getShort("avoid"));
              equip.setEnchantCraft(rs.getShort("craft"));
              equip.setEnchantMovementSpeed(rs.getShort("movementSpeed"));
              equip.setEnchantJump(rs.getShort("jump"));
              equip.setViciousHammer(rs.getByte("ViciousHammer"));
              equip.setItemEXP(rs.getInt("itemEXP"));
              equip.setGMLog(rs.getString("GM_Log"));
              equip.setDurability(rs.getInt("durability"));
              equip.setStarForceLevel(rs.getByte("starForceLevel"));
              equip.setState(rs.getByte("state"));
              equip.setLines(rs.getByte("line"));
              equip.setPotential1(rs.getInt("potential1"));
              equip.setPotential2(rs.getInt("potential2"));
              equip.setPotential3(rs.getInt("potential3"));
              equip.setPotential4(rs.getInt("potential4"));
              equip.setPotential5(rs.getInt("potential5"));
              equip.setPotential6(rs.getInt("potential6"));
              equip.setGiftFrom(rs.getString("sender"));
              equip.setIncSkill(rs.getInt("incSkill"));
              equip.setCharmEXP(rs.getShort("charmEXP"));
              if (equip.getCharmEXP() < 0)
              {
                equip.setCharmEXP(template.getCharmEXP());
              }
              if (equip.getUniqueId() > -1L)
              {
                if (GameConstants.isEffectRing(rs.getInt("itemid")))
                {
                  MapleRing ring = MapleRing.loadFromDb(equip.getUniqueId(), type.equals(MapleInventoryType.EQUIPPED));
                  if (ring != null)
                  {
                    equip.setRing(ring);
                  }
                }
                else if (equip.getItemId() / 10000 == 166)
                {
                  MapleAndroid ring = MapleAndroid.loadFromDb(equip.getItemId(), equip.getUniqueId());
                  if (ring != null)
                  {
                    equip.setAndroid(ring);
                  }
                }
              }
              equip.setEnchantBuff(rs.getShort("enchantbuff"));
              equip.setYggdrasilWisdom(rs.getByte("yggdrasilWisdom"));
              equip.setFinalStrike((rs.getByte("finalStrike") > 0));
              equip.setEnchantBossDamage(rs.getByte("bossDamage"));
              equip.setEnchantIgnorePDR(rs.getByte("ignorePDR"));
              equip.setEnchantDamage(rs.getByte("totalDamage"));
              equip.setEnchantAllStat(rs.getByte("allStat"));
              equip.setKarmaCount(rs.getByte("karmaCount"));
              equip.setSoulEnchanter(rs.getShort("soulenchanter"));
              equip.setSoulName(rs.getShort("soulname"));
              equip.setSoulPotential(rs.getShort("soulpotential"));
              equip.setSoulSkill(rs.getInt("soulskill"));
              equip.setFlame((rs.getLong("flame") < 0L) ? 0L : rs.getLong("flame"));
              equip.setArcPower(rs.getInt("arcPower"));
              equip.setArcExp(rs.getInt("arcExp"));
              equip.setArcLevel(rs.getInt("arcLevel"));
              equip.setArcStr(rs.getInt("arcStr"));
              equip.setArcDex(rs.getInt("arcDex"));
              equip.setArcInt(rs.getInt("arcInt"));
              equip.setArcLuk(rs.getInt("arcLuk"));
              equip.setArcHp(rs.getInt("arcHp"));
              equip.setAuthenticPower(rs.getInt("authenticPower"));
              equip.setAuthenticExp(rs.getInt("authenticExp"));
              equip.setAuthenticLevel(rs.getInt("authenticLevel"));
              equip.setAuthenticStr(rs.getInt("authenticStr"));
              equip.setAuthenticDex(rs.getInt("authenticDex"));
              equip.setAuthenticInt(rs.getInt("authenticInt"));
              equip.setAuthenticLuk(rs.getInt("authenticLuk"));
              equip.setAuthenticHp(rs.getInt("authenticHp"));
              equip.setEquipmentType(rs.getInt("equipmenttype"));
              equip.setMoru(rs.getInt("moru"));
              equip.setOptionExpiration(rs.getLong("optionexpiration"));
              equip.setCoption1(rs.getInt("coption1"));
              equip.setCoption2(rs.getInt("coption2"));
              equip.setCoption3(rs.getInt("coption3"));
            }

            equip.calcStarForceStats();

            equip.calcFlameStats();

            Item item1 = equip.copy();
            if (isCanMadeItem((Equip) item1))
            {
              items.put(Long.valueOf(rs.getLong("inventoryitemid")), item1);
            }
            continue;
          }
          Item item = new Item(rs.getInt("itemid"), rs.getShort("position"), rs.getShort("quantity"), rs.getInt("flag"), rs.getLong("uniqueid"));
          item.setOwner(rs.getString("owner"));
          item.setInventoryId(rs.getLong("inventoryitemid"));
          item.setExpiration(rs.getLong("expiredate"));
          item.setGMLog(rs.getString("GM_Log"));
          item.setGiftFrom(rs.getString("sender"));
          item.setMarriageId(rs.getInt("marriageId"));
          if (GameConstants.isPet(item.getItemId()))
          {
            if (item.getUniqueId() > -1L)
            {
              MaplePet pet = MaplePet.loadFromDb(item.getItemId(), item.getUniqueId(), item.getPosition());
              if (pet != null)
              {
                item.setPet(pet);
              }
            }
            else
            {
              item.setPet(MaplePet.createPet(item.getItemId(), MapleInventoryIdentifier.getInstance()));
            }
          }
          if (item.getItemId() == 4001886)
          {
            item.setReward(new BossReward(rs.getInt("objectid"), rs.getInt("mobid"), rs.getInt("partyid"), rs.getInt("price")));
          }
          Item item_ = item.copy();
          items.put(Long.valueOf(rs.getLong("inventoryitemid")), item_);
        }
        rs.close();
        ps.close();
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (con != null)
      {
        con.close();
      }
    }
    return items;
  }

  public void saveItems (List<Item> items, int id, MapleInventoryType type, boolean dc)
  {
    try
    {
      Connection con = DatabaseConnection.getConnection();
      saveItems(items, con, id, type, dc);
      con.close();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  public void saveItems (List<Item> items, Connection con, int id, MapleInventoryType type, boolean dc)
  {
    StringBuilder query = new StringBuilder();
    query.append("DELETE FROM `");
    if (this.value <= 1)
    {
      switch (type.getType())
      {
        case 2:
          query.append("inventoryitemsuse");
          break;
        case 3:
          query.append("inventoryitemssetup");
          break;
        case 4:
          query.append("inventoryitemsetc");
          break;
        case 5:
          query.append("inventoryitemscash");
          break;
        case 6:
          query.append("inventoryitemscody");
          break;
        default:
          query.append("inventoryitems");
          break;
      }
    }
    else
    {
      query.append(this.table);
    }
    query.append("`WHERE `type` = ?");
    query.append(" AND `").append(this.arg);
    query.append("` = ?");
    try
    {
      PreparedStatement pse, ps = con.prepareStatement(query.toString());
      ps.setInt(1, this.value);
      ps.setInt(2, id);
      ps.executeUpdate();
      ps.close();
      if (items == null)
      {
        return;
      }
      StringBuilder query_2 = new StringBuilder("INSERT INTO `");
      if (this.value <= 1)
      {
        switch (type.getType())
        {
          case 2:
            query_2.append("inventoryitemsuse");
            break;
          case 3:
            query_2.append("inventoryitemssetup");
            break;
          case 4:
            query_2.append("inventoryitemsetc");
            break;
          case 5:
            query_2.append("inventoryitemscash");
            break;
          case 6:
            query_2.append("inventoryitemscody");
            break;
          default:
            query_2.append("inventoryitems");
            break;
        }
      }
      else
      {
        query_2.append(this.table);
      }
      query_2.append("` (");
      query_2.append(this.arg);
      query_2.append(", itemid, inventorytype, position, quantity, owner, GM_Log, uniqueid, expiredate, flag, `type`, sender, marriageId");
      query_2.append(", price, partyid, mobid, objectid");
      query_2.append(") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
      query_2.append(", ?, ?, ?, ?");
      query_2.append(")");
      ps = con.prepareStatement(query_2.toString(), 1);
      if (this.value <= 1 && type.getType() == 6)
      {
        pse = con.prepareStatement("INSERT INTO inventoryequipmentcody VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
      }
      else
      {
        pse = con.prepareStatement("INSERT INTO " + this.table_equip + " VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
      }
      Iterator<Item> iter = items.iterator();
      while (iter.hasNext())
      {
        Item item = iter.next();
        ps.setInt(1, id);
        ps.setInt(2, item.getItemId());
        ps.setInt(3, GameConstants.getInventoryType(item.getItemId()).getType());
        ps.setInt(4, item.getPosition());
        ps.setInt(5, item.getQuantity());
        ps.setString(6, item.getOwner());
        ps.setString(7, item.getGMLog());
        if (item.getPet() != null)
        {
          ps.setLong(8, Math.max(item.getUniqueId(), item.getPet().getUniqueId()));
        }
        else
        {
          ps.setLong(8, item.getUniqueId());
        }
        ps.setLong(9, item.getExpiration());
        if (item.getFlag() < 0)
        {
          ps.setInt(10, (MapleItemInformationProvider.getInstance().getItemInformation(item.getItemId())).flag);
        }
        else
        {
          ps.setInt(10, item.getFlag());
        }
        ps.setByte(11, (byte) this.value);
        ps.setString(12, item.getGiftFrom());
        ps.setInt(13, item.getMarriageId());
        if (item.getReward() != null)
        {
          ps.setInt(14, item.getReward().getPrice());
          ps.setInt(15, item.getReward().getPartyId());
          ps.setInt(16, item.getReward().getMobId());
          ps.setInt(17, item.getReward().getObjectId());
        }
        else
        {
          ps.setInt(14, 0);
          ps.setInt(15, 0);
          ps.setInt(16, 0);
          ps.setInt(17, 0);
        }
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (!rs.next())
        {
          rs.close();
          continue;
        }
        long iid = rs.getLong(1);
        rs.close();
        if (dc)
        {
          item.setInventoryId(iid);
        }
        if (item.getItemId() / 1000000 == 1)
        {
          Equip equip = (Equip) item;
          if (equip == null)
          {
            continue;
          }
          if (!isCanMadeItem(equip))
          {
            continue;
          }
          pse.setLong(1, iid);
          pse.setInt(2, (equip.getTotalUpgradeSlots() <= 0) ? 0 : equip.getTotalUpgradeSlots());
          if (equip.getItemId() >= 1113098 && equip.getItemId() <= 1113128)
          {
            pse.setInt(3, equip.getItemLevel());
          }
          else
          {
            pse.setInt(3, equip.getEnchantLevel());
          }
          pse.setInt(4, equip.getEnchantStr());
          pse.setInt(5, equip.getEnchantDex());
          pse.setInt(6, equip.getEnchantInt());
          pse.setInt(7, equip.getEnchantLuk());
          pse.setInt(8, equip.getArcPower());
          pse.setInt(9, equip.getArcExp());
          pse.setInt(10, equip.getArcLevel());
          pse.setInt(11, equip.getArcStr());
          pse.setInt(12, equip.getArcDex());
          pse.setInt(13, equip.getArcInt());
          pse.setInt(14, equip.getArcLuk());
          pse.setInt(15, equip.getArcHp());
          pse.setInt(16, equip.getAuthenticPower());
          pse.setInt(17, equip.getAuthenticExp());
          pse.setInt(18, equip.getAuthenticLevel());
          pse.setInt(19, equip.getAuthenticStr());
          pse.setInt(20, equip.getAuthenticDex());
          pse.setInt(21, equip.getAuthenticInt());
          pse.setInt(22, equip.getAuthenticLuk());
          pse.setInt(23, equip.getAuthenticHp());
          pse.setInt(24, equip.getEnchantHp());
          pse.setInt(25, equip.getEnchantMp());
          pse.setInt(26, equip.getEnchantWatk());
          pse.setInt(27, equip.getEnchantMatk());
          pse.setInt(28, equip.getEnchantWdef());
          pse.setInt(29, equip.getEnchantMdef());
          pse.setInt(30, equip.getEnchantAccuracy());
          pse.setInt(31, equip.getEnchantAvoid());
          pse.setInt(32, equip.getEnchantCraft());
          pse.setInt(33, equip.getEnchantMovementSpeed());
          pse.setInt(34, equip.getEnchantJump());
          pse.setInt(35, equip.getViciousHammer());
          pse.setInt(36, equip.getItemEXP());
          pse.setInt(37, equip.getDurability());
          pse.setByte(38, equip.getStarForceLevel());
          pse.setByte(39, equip.getState());
          pse.setByte(40, equip.getLines());
          pse.setInt(41, equip.getPotential1());
          pse.setInt(42, equip.getPotential2());
          pse.setInt(43, equip.getPotential3());
          pse.setInt(44, equip.getPotential4());
          pse.setInt(45, equip.getPotential5());
          pse.setInt(46, equip.getPotential6());
          pse.setInt(47, equip.getIncSkill());
          pse.setShort(48, equip.getCharmEXP());
          pse.setShort(49, (short) 0);
          pse.setShort(50, equip.getEnchantBuff());
          pse.setByte(51, (byte) (equip.getTemplate().getReqLevel() - equip.getTotalReductReqLevel()));
          pse.setByte(52, equip.getYggdrasilWisdom());
          pse.setByte(53, (byte) (equip.getFinalStrike() ? 1 : 0));
          pse.setShort(54, equip.getEnchantBossDamage());
          pse.setShort(55, equip.getEnchantIgnorePDR());
          pse.setByte(56, equip.getEnchantDamage());
          pse.setByte(57, equip.getEnchantAllStat());
          pse.setByte(58, equip.getKarmaCount());
          pse.setShort(59, equip.getSoulName());
          pse.setShort(60, equip.getSoulEnchanter());
          pse.setShort(61, equip.getSoulPotential());
          pse.setInt(62, equip.getSoulSkill());
          pse.setLong(63, equip.getFlame());
          pse.setInt(64, equip.getEquipmentType());
          pse.setInt(65, equip.getMoru());
          pse.setInt(66, (int) 0);
          pse.setLong(67, equip.getOptionExpiration());
          pse.setInt(68, equip.getCoption1());
          pse.setInt(69, equip.getCoption2());
          pse.setInt(70, equip.getCoption3());
          pse.executeUpdate();
          if (equip.getItemId() / 10000 == 166 && equip.getAndroid() != null)
          {
            equip.getAndroid().saveToDb();
          }
        }
      }
      ps.close();
      pse.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void saveItems (List<Pair<Item, MapleInventoryType>> items, int id)
  {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try
    {
      con = DatabaseConnection.getConnection();
      saveCSItems(items, con, id, null);
      con.close();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        if (ps != null)
        {
          ps.close();
        }
        if (rs != null)
        {
          rs.close();
        }
        if (con != null)
        {
          con.close();
        }
      }
      catch (Exception exception)
      {
      }
    }
  }

  public void saveCSItems (List<Pair<Item, MapleInventoryType>> items, Connection con, int id, MapleClient c) throws SQLException
  {
    StringBuilder query = new StringBuilder();
    query.append("DELETE FROM `");
    query.append(this.table);
    query.append("`WHERE `type` = ?");
    query.append(" AND `").append(this.arg);
    query.append("` = ?");
    try
    {
      PreparedStatement ps = con.prepareStatement(query.toString());
      ps.setInt(1, this.value);
      ps.setInt(2, id);
      ps.executeUpdate();
      query = new StringBuilder();
      query.append("SELECT `inventoryitemid`, `type`, `characterid` FROM `");
      query.append(this.table);
      query.append("` WHERE `type` = ? AND `");
      query.append(this.arg);
      query.append("` = ?");
      ps = con.prepareStatement(query.toString());
      ps.setInt(1, this.value);
      ps.setInt(2, id);
      ps.close();
      if (items == null)
      {
        return;
      }
      String query_2 = "INSERT INTO `" + this.table + "` (" + this.arg + ", itemid, inventorytype, position, quantity, owner, GM_Log, uniqueid, expiredate, flag, `type`, sender, marriageId" + ", price, partyid, mobid, objectid" + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?" + ", ?, ?, ?, ?" + ")";
      ps = con.prepareStatement(query_2, 1);
      PreparedStatement pse = con.prepareStatement("INSERT INTO " + this.table_equip + " VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
      Iterator<Pair<Item, MapleInventoryType>> iter = items.iterator();
      while (iter.hasNext())
      {
        Pair<Item, MapleInventoryType> pair = iter.next();
        Item item = pair.getLeft();
        MapleInventoryType mit = pair.getRight();
        if (item.getPosition() == -55)
        {
          continue;
        }
        if (item != null)
        {
          ps.setInt(1, id);
          ps.setInt(2, item.getItemId());
          ps.setInt(3, (mit == null) ? 0 : mit.getType());
          ps.setInt(4, item.getPosition());
          ps.setInt(5, item.getQuantity());
          ps.setString(6, item.getOwner());
          ps.setString(7, item.getGMLog());
          if (item.getPet() != null)
          {
            ps.setLong(8, Math.max(item.getUniqueId(), item.getPet().getUniqueId()));
          }
          else
          {
            ps.setLong(8, item.getUniqueId());
          }
          ps.setLong(9, item.getExpiration());
          if (item.getFlag() < 0)
          {
            ps.setInt(10, (MapleItemInformationProvider.getInstance().getItemInformation(item.getItemId())).flag);
          }
          else
          {
            ps.setInt(10, item.getFlag());
          }
          ps.setByte(11, (byte) this.value);
          ps.setString(12, item.getGiftFrom());
          ps.setInt(13, item.getMarriageId());
          if (item.getReward() != null)
          {
            ps.setInt(14, item.getReward().getPrice());
            ps.setInt(15, item.getReward().getPartyId());
            ps.setInt(16, item.getReward().getMobId());
            ps.setInt(17, item.getReward().getObjectId());
          }
          else
          {
            ps.setInt(14, 0);
            ps.setInt(15, 0);
            ps.setInt(16, 0);
            ps.setInt(17, 0);
          }
          ps.executeUpdate();
          ResultSet rs = ps.getGeneratedKeys();
          if (!rs.next())
          {
            rs.close();
            continue;
          }
          long iid = rs.getLong(1);
          rs.close();
          if (item.getInventoryId() == 0L)
          {
            item.setInventoryId(iid);
          }
          else
          {
            item.setInventoryId(item.getInventoryId());
          }
          if (mit.equals(MapleInventoryType.EQUIP) || mit.equals(MapleInventoryType.EQUIPPED) || mit.equals(MapleInventoryType.CODY))
          {
            Equip equip = (Equip) item;
            if (!isCanMadeItem(equip))
            {
              continue;
            }
            pse.setLong(1, iid);
            pse.setInt(2, equip.getTotalUpgradeSlots());
            if (equip.getItemId() >= 1113098 && equip.getItemId() <= 1113128)
            {
              pse.setInt(3, equip.getItemLevel());
            }
            else
            {
              pse.setInt(3, equip.getEnchantLevel());
            }
            pse.setInt(4, equip.getEnchantStr());
            pse.setInt(5, equip.getEnchantDex());
            pse.setInt(6, equip.getEnchantInt());
            pse.setInt(7, equip.getEnchantLuk());
            pse.setInt(8, equip.getArcPower());
            pse.setInt(9, equip.getArcExp());
            pse.setInt(10, equip.getArcLevel());
            pse.setInt(11, equip.getArcStr());
            pse.setInt(12, equip.getArcDex());
            pse.setInt(13, equip.getArcInt());
            pse.setInt(14, equip.getArcLuk());
            pse.setInt(15, equip.getArcHp());
            pse.setInt(16, equip.getAuthenticPower());
            pse.setInt(17, equip.getAuthenticExp());
            pse.setInt(18, equip.getAuthenticLevel());
            pse.setInt(19, equip.getAuthenticStr());
            pse.setInt(20, equip.getAuthenticDex());
            pse.setInt(21, equip.getAuthenticInt());
            pse.setInt(22, equip.getAuthenticLuk());
            pse.setInt(23, equip.getAuthenticHp());
            pse.setInt(24, equip.getEnchantHp());
            pse.setInt(25, equip.getEnchantMp());
            pse.setInt(26, equip.getEnchantWatk());
            pse.setInt(27, equip.getEnchantMatk());
            pse.setInt(28, equip.getEnchantWdef());
            pse.setInt(29, equip.getEnchantMdef());
            pse.setInt(30, equip.getEnchantAccuracy());
            pse.setInt(31, equip.getEnchantAvoid());
            pse.setInt(32, equip.getEnchantCraft());
            pse.setInt(33, equip.getEnchantMovementSpeed());
            pse.setInt(34, equip.getEnchantJump());
            pse.setInt(35, equip.getViciousHammer());
            pse.setInt(36, equip.getItemEXP());
            pse.setInt(37, equip.getDurability());
            pse.setByte(38, equip.getStarForceLevel());
            pse.setByte(39, equip.getState());
            pse.setByte(40, equip.getLines());
            pse.setInt(41, equip.getPotential1());
            pse.setInt(42, equip.getPotential2());
            pse.setInt(43, equip.getPotential3());
            pse.setInt(44, equip.getPotential4());
            pse.setInt(45, equip.getPotential5());
            pse.setInt(46, equip.getPotential6());
            pse.setInt(47, equip.getIncSkill());
            pse.setShort(48, equip.getCharmEXP());
            pse.setShort(49, (short) 0);
            pse.setShort(50, equip.getEnchantBuff());
            pse.setByte(51, (byte) (equip.getTemplate().getReqLevel() - equip.getTotalReductReqLevel()));
            pse.setByte(52, equip.getYggdrasilWisdom());
            pse.setByte(53, (byte) (equip.getFinalStrike() ? 1 : 0));
            pse.setShort(54, equip.getEnchantBossDamage());
            pse.setShort(55, equip.getEnchantIgnorePDR());
            pse.setByte(56, equip.getEnchantDamage());
            pse.setByte(57, equip.getEnchantAllStat());
            pse.setByte(58, equip.getKarmaCount());
            pse.setShort(59, equip.getSoulName());
            pse.setShort(60, equip.getSoulEnchanter());
            pse.setShort(61, equip.getSoulPotential());
            pse.setInt(62, equip.getSoulSkill());
            pse.setLong(63, equip.getFlame());
            pse.setInt(64, equip.getEquipmentType());
            pse.setInt(65, equip.getMoru());
            pse.setInt(66, (int) 0);
            pse.setLong(67, equip.getOptionExpiration());
            pse.setInt(68, equip.getCoption1());
            pse.setInt(69, equip.getCoption2());
            pse.setInt(70, equip.getCoption3());
            pse.executeUpdate();
            if (equip.getItemId() / 10000 == 166 && equip.getAndroid() != null)
            {
              equip.getAndroid().saveToDb();
            }
          }
        }
      }
      pse.close();
      ps.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public Map<Long, Pair<Item, MapleInventoryType>> loadCSItems (boolean login, int id) throws SQLException
  {
    Map<Long, Pair<Item, MapleInventoryType>> items = new LinkedHashMap<>();
    StringBuilder query = new StringBuilder();
    query.append("SELECT * FROM `");
    query.append(this.table);
    query.append("` LEFT JOIN `");
    query.append(this.table_equip);
    query.append("` USING " + ((getValue() != 7) ? "(`inventoryitemid`)" : "(`auctionid`)") + ((getValue() != 7) ? " WHERE `type` = ?" : ""));
    if (getValue() != 7)
    {
      query.append(" AND `");
      query.append(this.arg);
      query.append("` = ?");
    }
    else
    {
      query.append("ORDER BY startdate ASC");
    }
    if (login)
    {
      query.append(" AND `inventorytype` = ");
      query.append(MapleInventoryType.EQUIPPED.getType());
    }
    Connection con = DatabaseConnection.getConnection();
    try (PreparedStatement ps = con.prepareStatement(query.toString()))
    {
      if (getValue() != 7)
      {
        ps.setInt(1, this.value);
        ps.setInt(2, id);
      }
      try (ResultSet rs = ps.executeQuery())
      {
        MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
        while (rs.next())
        {
          if (!ii.itemExists(rs.getInt("itemid")))
          {
            continue;
          }
          MapleInventoryType mit = MapleInventoryType.getByType(rs.getByte("inventorytype"));
          if (mit.equals(MapleInventoryType.EQUIP) || mit.equals(MapleInventoryType.EQUIPPED) || mit.equals(MapleInventoryType.CODY))
          {
            int itemId = rs.getInt("itemid");

            short position = rs.getShort("position");

            long uniqueId = rs.getLong("uniqueid");

            int flag = rs.getInt("flag");

            EquipTemplate template = MapleItemInformationProvider.getInstance().getTempateByItemId(itemId);

            Equip equip = new Equip(template, position, flag, uniqueId);

            if (!login && equip.getPosition() != -55)
            {

              byte enchantLevel = rs.getByte("enchantLevel");

              byte totalUpgradeSlots = rs.getByte("upgradeslots");

              byte hammerCount = rs.getByte("ViciousHammer");

              equip.setSuccessUpgradeSlots(enchantLevel);

              equip.setExtraUpgradeSlots(hammerCount);

              equip.setFailUpgradeSlots((byte) (template.getUpgradeSlots() + hammerCount - enchantLevel - totalUpgradeSlots));

              equip.setQuantity((short) 1);

              equip.setInventoryId(rs.getLong("inventoryitemid"));

              equip.setOwner(rs.getString("owner"));

              equip.setExpiration(rs.getLong("expiredate"));

              int reqLevel = rs.getInt("reqLevel");

              if (reqLevel > 0)
              {
                equip.setEnchantReductReqLevel((byte) (template.getReqLevel() - reqLevel));
              }

              if (equip.getItemId() >= 1113098 && equip.getItemId() <= 1113128)
              {
                equip.setItemLevel(enchantLevel);
                equip.setEnchantLevel((byte) 0);
              }
              else
              {
                equip.setItemLevel((byte) 0);
                equip.setEnchantLevel(enchantLevel);
              }
              equip.setEnchantStr(rs.getShort("str"));
              equip.setEnchantDex(rs.getShort("dex"));
              equip.setEnchantInt(rs.getShort("int"));
              equip.setEnchantLuk(rs.getShort("luk"));
              equip.setEnchantHp(rs.getShort("hp"));
              equip.setEnchantMp(rs.getShort("mp"));
              equip.setEnchantWatk(rs.getShort("watk"));
              equip.setEnchantMatk(rs.getShort("matk"));
              equip.setEnchantWdef(rs.getShort("wdef"));
              equip.setEnchantMdef(rs.getShort("mdef"));
              equip.setEnchantAccuracy(rs.getShort("accuracy"));
              equip.setEnchantAvoid(rs.getShort("avoid"));
              equip.setEnchantCraft(rs.getShort("craft"));
              equip.setEnchantMovementSpeed(rs.getShort("movementSpeed"));
              equip.setEnchantJump(rs.getShort("jump"));
              equip.setViciousHammer(rs.getByte("ViciousHammer"));
              equip.setItemEXP(rs.getInt("itemEXP"));
              equip.setGMLog(rs.getString("GM_Log"));
              equip.setDurability(rs.getInt("durability"));
              equip.setStarForceLevel(rs.getByte("starForceLevel"));
              equip.setState(rs.getByte("state"));
              equip.setLines(rs.getByte("line"));
              equip.setPotential1(rs.getInt("potential1"));
              equip.setPotential2(rs.getInt("potential2"));
              equip.setPotential3(rs.getInt("potential3"));
              equip.setPotential4(rs.getInt("potential4"));
              equip.setPotential5(rs.getInt("potential5"));
              equip.setPotential6(rs.getInt("potential6"));
              equip.setGiftFrom(rs.getString("sender"));
              equip.setIncSkill(rs.getInt("incSkill"));
              equip.setCharmEXP(rs.getShort("charmEXP"));
              if (equip.getCharmEXP() < 0)
              {
                equip.setCharmEXP(template.getCharmEXP());
              }
              if (equip.getUniqueId() > -1L)
              {
                if (GameConstants.isEffectRing(rs.getInt("itemid")))
                {
                  MapleRing ring = MapleRing.loadFromDb(equip.getUniqueId(), mit.equals(MapleInventoryType.EQUIPPED));
                  if (ring != null)
                  {
                    equip.setRing(ring);
                  }
                }
                else if (equip.getItemId() / 10000 == 166)
                {
                  MapleAndroid ring = MapleAndroid.loadFromDb(equip.getItemId(), equip.getUniqueId());
                  if (ring != null)
                  {
                    equip.setAndroid(ring);
                  }
                }
              }
              equip.setEnchantBuff(rs.getShort("enchantbuff"));
              equip.setYggdrasilWisdom(rs.getByte("yggdrasilWisdom"));
              equip.setFinalStrike((rs.getByte("finalStrike") > 0));
              equip.setEnchantBossDamage(rs.getByte("bossDamage"));
              equip.setEnchantIgnorePDR(rs.getByte("ignorePDR"));
              equip.setEnchantDamage(rs.getByte("totalDamage"));
              equip.setEnchantAllStat(rs.getByte("allStat"));
              equip.setKarmaCount(rs.getByte("karmaCount"));
              equip.setSoulEnchanter(rs.getShort("soulenchanter"));
              equip.setSoulName(rs.getShort("soulname"));
              equip.setSoulPotential(rs.getShort("soulpotential"));
              equip.setSoulSkill(rs.getInt("soulskill"));
              equip.setFlame((rs.getLong("flame") < 0L) ? 0L : rs.getLong("flame"));
              equip.setArcPower(rs.getInt("arcPower"));
              equip.setArcExp(rs.getInt("arcExp"));
              equip.setArcLevel(rs.getInt("arcLevel"));
              equip.setArcStr(rs.getInt("arcStr"));
              equip.setArcDex(rs.getInt("arcDex"));
              equip.setArcInt(rs.getInt("arcInt"));
              equip.setArcLuk(rs.getInt("arcLuk"));
              equip.setArcHp(rs.getInt("arcHp"));
              equip.setAuthenticPower(rs.getInt("authenticPower"));
              equip.setAuthenticExp(rs.getInt("authenticExp"));
              equip.setAuthenticLevel(rs.getInt("authenticLevel"));
              equip.setAuthenticStr(rs.getInt("authenticStr"));
              equip.setAuthenticDex(rs.getInt("authenticDex"));
              equip.setAuthenticInt(rs.getInt("authenticInt"));
              equip.setAuthenticLuk(rs.getInt("authenticLuk"));
              equip.setAuthenticHp(rs.getInt("authenticHp"));
              equip.setEquipmentType(rs.getInt("equipmenttype"));
              equip.setMoru(rs.getInt("moru"));
              equip.setOptionExpiration(rs.getLong("optionexpiration"));
              equip.setCoption1(rs.getInt("coption1"));
              equip.setCoption2(rs.getInt("coption2"));
              equip.setCoption3(rs.getInt("coption3"));
            }

            equip.calcStarForceStats();

            equip.calcFlameStats();

            Item item1 = equip.copy();

            if (isCanMadeItem((Equip) item1))
            {
              items.put(Long.valueOf(rs.getLong("inventoryitemid")), new Pair<>(item1, mit));
            }
            continue;
          }

          Item item = new Item(rs.getInt("itemid"), rs.getShort("position"), rs.getShort("quantity"), rs.getInt("flag"), rs.getLong("uniqueid"));
          item.setOwner(rs.getString("owner"));
          item.setInventoryId(rs.getLong("inventoryitemid"));
          item.setExpiration(rs.getLong("expiredate"));
          item.setGMLog(rs.getString("GM_Log"));
          item.setGiftFrom(rs.getString("sender"));
          item.setMarriageId(rs.getInt("marriageId"));
          if (GameConstants.isPet(item.getItemId()))
          {
            if (item.getUniqueId() > -1L)
            {
              MaplePet pet = MaplePet.loadFromDb(item.getItemId(), item.getUniqueId(), item.getPosition());
              if (pet != null)
              {
                item.setPet(pet);
              }
            }
            else
            {
              item.setPet(MaplePet.createPet(item.getItemId(), MapleInventoryIdentifier.getInstance()));
            }
          }
          /*  994 */
          if (item.getItemId() == 4001886)
          {
            /*  995 */
            item.setReward(new BossReward(rs.getInt("objectid"), rs.getInt("mobid"), rs.getInt("partyid"), rs.getInt("price")));
          }
          /*  997 */
          Item item_ = item.copy();
          /*  998 */
          items.put(Long.valueOf(rs.getLong("inventoryitemid")), new Pair(item_, mit));
        }
        ps.close();
        rs.close();
      }
    }
    catch (SQLException e


    )
    {
      e.printStackTrace();
    }
    finally
    {
      if (con != null)
      {
        con.close();
      }
    }
    return items;
  }
}
