package server.enchant;

import client.MapleClient;
import client.inventory.Equip;
import client.inventory.ItemFlag;
import client.inventory.MapleInventoryType;
import client.inventory.MapleWeaponType;
import constants.GameConstants;
import constants.ServerConstants;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.Randomizer;
import tools.Pair;
import tools.data.LittleEndianAccessor;
import tools.packet.CWvsContext;

import java.util.ArrayList;
import java.util.List;

public class EquipmentEnchant
{
  public static int[] usejuhun = new int[4];
  
  public static int scrollType(String name)
  {
    if (name.contains("100%"))
    {
      return 0;
    }
    if (name.contains("回真卷軸"))
    {
      return 4;
    }
    if (name.contains("純白的卷軸"))
    {
      return 5;
    }
    if (name.contains("70%"))
    {
      return 1;
    }
    if (name.contains("30%"))
    {
      return 2;
    }
    if (name.contains("10%"))
    {
      return 3;
    }
    return 0;
  }
  
  public static boolean isMagicWeapon(MapleWeaponType type)
  {
    switch (type)
    {
      case ESPLIMITER:
      case STAFF:
      case WAND:
      case PLANE:
      case MAGICGUNTLET:
        return true;
    }
    return false;
  }
  
  public static List<EquipmentScroll> equipmentScrolls(Equip equip)
  {
    List<EquipmentScroll> ess = new ArrayList<>();
    MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
    MapleWeaponType weaponType = GameConstants.getWeaponType(equip.getItemId());
    List<Pair<EnchantFlag, Integer>> stats = new ArrayList<>();
    if (equip.getUpgradeSlots() > 0)
    {
      if (GameConstants.isWeapon(equip.getItemId()))
      {
        if (!isMagicWeapon(weaponType))
        {
          stats.add(new Pair<>(EnchantFlag.Watk, 5));
          stats.add(new Pair<>(EnchantFlag.Str, 5));
          stats.add(new Pair<>(EnchantFlag.Dex, 5));
          stats.add(new Pair<>(EnchantFlag.Int, 5));
          stats.add(new Pair<>(EnchantFlag.Luk, 5));
          stats.add(new Pair<>(EnchantFlag.Hp, 100));
          stats.add(new Pair<>(EnchantFlag.Mp, 100));
          ess.add(new EquipmentScroll("100% 攻擊力卷軸", 35, stats));
          stats.clear();
          
          stats.add(new Pair<>(EnchantFlag.Watk, 8));
          stats.add(new Pair<>(EnchantFlag.Str, 8));
          stats.add(new Pair<>(EnchantFlag.Dex, 8));
          stats.add(new Pair<>(EnchantFlag.Int, 8));
          stats.add(new Pair<>(EnchantFlag.Luk, 8));
          stats.add(new Pair<>(EnchantFlag.Hp, 160));
          stats.add(new Pair<>(EnchantFlag.Mp, 160));
          ess.add(new EquipmentScroll("70% 攻擊力卷軸", 2500, stats));
          stats.clear();
          
          stats.add(new Pair<>(EnchantFlag.Watk, 11));
          stats.add(new Pair<>(EnchantFlag.Str, 11));
          stats.add(new Pair<>(EnchantFlag.Dex, 11));
          stats.add(new Pair<>(EnchantFlag.Int, 11));
          stats.add(new Pair<>(EnchantFlag.Luk, 11));
          stats.add(new Pair<>(EnchantFlag.Hp, 220));
          stats.add(new Pair<>(EnchantFlag.Mp, 220));
          ess.add(new EquipmentScroll("30% 攻擊力卷軸", 5000, stats));
          stats.clear();
          
          stats.add(new Pair<>(EnchantFlag.Watk, 15));
          stats.add(new Pair<>(EnchantFlag.Str, 15));
          stats.add(new Pair<>(EnchantFlag.Dex, 15));
          stats.add(new Pair<>(EnchantFlag.Int, 15));
          stats.add(new Pair<>(EnchantFlag.Luk, 15));
          stats.add(new Pair<>(EnchantFlag.Hp, 300));
          stats.add(new Pair<>(EnchantFlag.Mp, 300));
          ess.add(new EquipmentScroll("10% 攻擊力卷軸", 10000, stats));
          stats.clear();
        }
        else
        {
          stats.add(new Pair<>(EnchantFlag.Matk, 5));
          stats.add(new Pair<>(EnchantFlag.Str, 5));
          stats.add(new Pair<>(EnchantFlag.Dex, 5));
          stats.add(new Pair<>(EnchantFlag.Int, 5));
          stats.add(new Pair<>(EnchantFlag.Luk, 5));
          stats.add(new Pair<>(EnchantFlag.Hp, 100));
          stats.add(new Pair<>(EnchantFlag.Mp, 100));
          ess.add(new EquipmentScroll("100% 魔法攻擊力卷軸", 35, stats));
          stats.clear();
          
          stats.add(new Pair<>(EnchantFlag.Matk, 8));
          stats.add(new Pair<>(EnchantFlag.Str, 8));
          stats.add(new Pair<>(EnchantFlag.Dex, 8));
          stats.add(new Pair<>(EnchantFlag.Int, 8));
          stats.add(new Pair<>(EnchantFlag.Luk, 8));
          stats.add(new Pair<>(EnchantFlag.Hp, 160));
          stats.add(new Pair<>(EnchantFlag.Mp, 160));
          ess.add(new EquipmentScroll("70% 魔法攻擊力卷軸", 2500, stats));
          stats.clear();
          
          stats.add(new Pair<>(EnchantFlag.Matk, 11));
          stats.add(new Pair<>(EnchantFlag.Str, 11));
          stats.add(new Pair<>(EnchantFlag.Dex, 11));
          stats.add(new Pair<>(EnchantFlag.Int, 11));
          stats.add(new Pair<>(EnchantFlag.Luk, 11));
          stats.add(new Pair<>(EnchantFlag.Hp, 220));
          stats.add(new Pair<>(EnchantFlag.Mp, 220));
          ess.add(new EquipmentScroll("30% 魔法攻擊力卷軸", 5000, stats));
          stats.clear();
          
          stats.add(new Pair<>(EnchantFlag.Matk, 15));
          stats.add(new Pair<>(EnchantFlag.Str, 15));
          stats.add(new Pair<>(EnchantFlag.Dex, 15));
          stats.add(new Pair<>(EnchantFlag.Int, 15));
          stats.add(new Pair<>(EnchantFlag.Luk, 15));
          stats.add(new Pair<>(EnchantFlag.Hp, 300));
          stats.add(new Pair<>(EnchantFlag.Mp, 300));
          ess.add(new EquipmentScroll("10% 魔法攻擊力卷軸", 10000, stats));
          stats.clear();
        }
      }
      else
      {
        stats.add(new Pair<>(EnchantFlag.Watk, 2));
        stats.add(new Pair<>(EnchantFlag.Str, 2));
        stats.add(new Pair<>(EnchantFlag.Dex, 2));
        stats.add(new Pair<>(EnchantFlag.Int, 2));
        stats.add(new Pair<>(EnchantFlag.Luk, 2));
        stats.add(new Pair<>(EnchantFlag.Hp, 100));
        stats.add(new Pair<>(EnchantFlag.Mp, 100));
        stats.add(new Pair<>(EnchantFlag.Wdef, 4));
        stats.add(new Pair<>(EnchantFlag.Mdef, 4));
        ess.add(new EquipmentScroll("100% 攻擊力卷軸", 35, stats));
        stats.clear();
        
        stats.add(new Pair<>(EnchantFlag.Watk, 4));
        stats.add(new Pair<>(EnchantFlag.Str, 4));
        stats.add(new Pair<>(EnchantFlag.Dex, 4));
        stats.add(new Pair<>(EnchantFlag.Int, 4));
        stats.add(new Pair<>(EnchantFlag.Luk, 4));
        stats.add(new Pair<>(EnchantFlag.Hp, 200));
        stats.add(new Pair<>(EnchantFlag.Mp, 200));
        stats.add(new Pair<>(EnchantFlag.Wdef, 8));
        stats.add(new Pair<>(EnchantFlag.Mdef, 8));
        ess.add(new EquipmentScroll("70% 攻擊力卷軸", 2500, stats));
        stats.clear();
        
        stats.add(new Pair<>(EnchantFlag.Watk, 6));
        stats.add(new Pair<>(EnchantFlag.Str, 6));
        stats.add(new Pair<>(EnchantFlag.Dex, 6));
        stats.add(new Pair<>(EnchantFlag.Int, 6));
        stats.add(new Pair<>(EnchantFlag.Luk, 6));
        stats.add(new Pair<>(EnchantFlag.Hp, 300));
        stats.add(new Pair<>(EnchantFlag.Mp, 300));
        stats.add(new Pair<>(EnchantFlag.Wdef, 12));
        stats.add(new Pair<>(EnchantFlag.Mdef, 12));
        ess.add(new EquipmentScroll("30% 攻擊力卷軸", 5000, stats));
        stats.clear();
        
        stats.add(new Pair<>(EnchantFlag.Watk, 8));
        stats.add(new Pair<>(EnchantFlag.Str, 8));
        stats.add(new Pair<>(EnchantFlag.Dex, 8));
        stats.add(new Pair<>(EnchantFlag.Int, 8));
        stats.add(new Pair<>(EnchantFlag.Luk, 8));
        stats.add(new Pair<>(EnchantFlag.Hp, 400));
        stats.add(new Pair<>(EnchantFlag.Mp, 400));
        stats.add(new Pair<>(EnchantFlag.Wdef, 16));
        stats.add(new Pair<>(EnchantFlag.Mdef, 16));
        ess.add(new EquipmentScroll("10% 攻擊力卷軸", 10000, stats));
        stats.clear();
        
        stats.add(new Pair<>(EnchantFlag.Matk, 2));
        stats.add(new Pair<>(EnchantFlag.Str, 2));
        stats.add(new Pair<>(EnchantFlag.Dex, 2));
        stats.add(new Pair<>(EnchantFlag.Int, 2));
        stats.add(new Pair<>(EnchantFlag.Luk, 2));
        stats.add(new Pair<>(EnchantFlag.Hp, 100));
        stats.add(new Pair<>(EnchantFlag.Mp, 100));
        stats.add(new Pair<>(EnchantFlag.Wdef, 4));
        stats.add(new Pair<>(EnchantFlag.Mdef, 4));
        ess.add(new EquipmentScroll("100% 魔法攻擊力卷軸", 35, stats));
        stats.clear();
        
        stats.add(new Pair<>(EnchantFlag.Matk, 4));
        stats.add(new Pair<>(EnchantFlag.Str, 4));
        stats.add(new Pair<>(EnchantFlag.Dex, 4));
        stats.add(new Pair<>(EnchantFlag.Int, 4));
        stats.add(new Pair<>(EnchantFlag.Luk, 4));
        stats.add(new Pair<>(EnchantFlag.Hp, 200));
        stats.add(new Pair<>(EnchantFlag.Mp, 200));
        stats.add(new Pair<>(EnchantFlag.Wdef, 8));
        stats.add(new Pair<>(EnchantFlag.Mdef, 8));
        ess.add(new EquipmentScroll("70% 魔法攻擊力卷軸", 2500, stats));
        stats.clear();
        
        stats.add(new Pair<>(EnchantFlag.Matk, 6));
        stats.add(new Pair<>(EnchantFlag.Str, 6));
        stats.add(new Pair<>(EnchantFlag.Dex, 6));
        stats.add(new Pair<>(EnchantFlag.Int, 6));
        stats.add(new Pair<>(EnchantFlag.Luk, 6));
        stats.add(new Pair<>(EnchantFlag.Hp, 300));
        stats.add(new Pair<>(EnchantFlag.Mp, 300));
        stats.add(new Pair<>(EnchantFlag.Wdef, 12));
        stats.add(new Pair<>(EnchantFlag.Mdef, 12));
        ess.add(new EquipmentScroll("30% 魔法攻擊力卷軸", 5000, stats));
        stats.clear();
        
        stats.add(new Pair<>(EnchantFlag.Matk, 8));
        stats.add(new Pair<>(EnchantFlag.Str, 8));
        stats.add(new Pair<>(EnchantFlag.Dex, 8));
        stats.add(new Pair<>(EnchantFlag.Int, 8));
        stats.add(new Pair<>(EnchantFlag.Luk, 8));
        stats.add(new Pair<>(EnchantFlag.Hp, 400));
        stats.add(new Pair<>(EnchantFlag.Mp, 400));
        stats.add(new Pair<>(EnchantFlag.Wdef, 16));
        stats.add(new Pair<>(EnchantFlag.Mdef, 16));
        ess.add(new EquipmentScroll("10% 魔法攻擊力卷軸", 10000, stats));
        stats.clear();
      }
      ess.add(new EquipmentScroll("回真卷軸 50%", 5000, stats));
      ess.add(new EquipmentScroll("亞克回真卷軸 50%", 10000, stats));
      if (equip.getViciousHammer() == 0)
      {
        if (equip.getUpgradeSlots() < ii.getSlots(equip.getItemId()))
        {
          ess.add(new EquipmentScroll("純白的卷軸 10%", 3000, stats));
        }
      }
      else if (equip.getUpgradeSlots() < ii.getSlots(equip.getItemId()) + 1)
      {
        ess.add(new EquipmentScroll("純白的卷軸 10%", 3000, stats));
      }
    }
    return ess;
  }
  
  
  
  
  public static StarForceStats calcStarForceStat(Equip item)
  {
    // TODO: Visible DEF +5% is not yet implemented
    MapleItemInformationProvider itemInfo = MapleItemInformationProvider.getInstance();
    
    int reqLevel = itemInfo.getReqLevel(item.getItemId());
    
    List<Pair<EnchantFlag, Integer>> stats = new ArrayList<>();
    
    MapleWeaponType weaponType = GameConstants.getWeaponType(item.getItemId());
    
    int starForceLevel = item.getStarForceLevel();
    
    int equipLevel = item.getReqLevel();
    
    boolean isSuperial = GameConstants.isSuperior(item.getItemId());
    
    int incAllStat = 0;
    
    int incWAtk = 0;
    
    int incMAtk = 0;
    
    int incDef = 0;
    
    int incHp = 0;
    
    int incMp = 0;
    
    int incAcc = 0;
    
    int incAvoid = 0;
    
    int currentDef = item.getTotalWdef();
    
    int currentWatk = item.getTotalWatk();
    
    int currentMatk = item.getTotalMatk();
    
    int itemId = item.getItemId();
    
    for (int currentStarForceLevel = 1; currentStarForceLevel <= starForceLevel; currentStarForceLevel++)
    {
      if (isSuperial)
      {
        // check https://strategywiki.org/wiki/MapleStory/Spell_Trace_and_Star_Force#Superior_Items
        currentDef = (int)Math.ceil(currentDef * 1.05);

        // TODO: every star should add Visible DEF +5%
        if (currentStarForceLevel < 5)
        {
          if (equipLevel == 80)
          {
            // Heliseum
            int[] statusArr = new int[]{ 2, 3, 5 };
            
            incAllStat += statusArr[currentStarForceLevel];

          }
          else if (equipLevel == 110)
          {
            // Nova
            int[] statusArr = new int[]{ 9, 10, 12, 15, 19 };
            
            incAllStat += statusArr[currentStarForceLevel];
          }
          else if (equipLevel >= 150)
          {
            // Tyrant and MindPendent
            int[] statusArr = new int[]{ 19, 20, 22, 25, 29 };
            
            incAllStat += statusArr[currentStarForceLevel];
          }
        }
        else
        {
          // Heliseum only 3 star
          if (equipLevel == 110)
          {
            // Nova 10 star
            int[] statusArr = new int[]{ 5, 6, 7, 9, 10 };
            incWAtk += statusArr[currentStarForceLevel];
            incMAtk += statusArr[currentStarForceLevel];
          }
          else if (equipLevel == 110)
          {
            // Tyrant and MindPendent 15 star
            int[] statusArr = new int[]{ 9, 10, 11, 12, 13, 15, 17, 19, 21, 23 };
            incWAtk += statusArr[currentStarForceLevel];
            incMAtk += statusArr[currentStarForceLevel];
          }
        }
      }
      else if (currentStarForceLevel < 16)
      {
        // check https://strategywiki.org/wiki/MapleStory/Spell_Trace_and_Star_Force#Normal_Equip
        if (GameConstants.isCategoryA(itemId))
        {
          if (currentStarForceLevel < 4)
          {
            incHp += 5;
          } else if (currentStarForceLevel < 6) {
            incHp += 10;
          } else if (currentStarForceLevel < 8) {
            incHp += 15;
          } else if (currentStarForceLevel < 10) {
            incHp += 20;
          } else {
            incHp += 25;
          }
        }
        
        if (GameConstants.isWeapon(itemId))
        {
  
            currentWatk = (int) Math.ceil(currentWatk * 1.02);
            
            currentMatk = (int) Math.ceil(currentMatk * 1.02);
            
            if (currentStarForceLevel < 4)
            {
              incMp += 5;
            }
            else if (currentStarForceLevel < 6)
            {
              incMp += 10;
            }
            else if (currentStarForceLevel < 8)
            {
              incMp += 15;
            }
            else if (currentStarForceLevel < 10)
            {
              incMp += 20;
            }
            else
            {
              incMp += 25;
            }
          
        }
        
        if (GameConstants.isShoe(itemId))
        {
          if (currentStarForceLevel < 11)
          {
            incAcc += 1;
            
            incAvoid += 1;
          } else {
            incAcc += 2;
            
            incAvoid += 2;
          }
        }
        
        if (GameConstants.isWeapon(itemId) == false)
        {
          currentDef = (int)Math.ceil(currentDef * 1.05);
        }
        
        if (GameConstants.isGlove(itemId) )
        {
          
          if (currentStarForceLevel == 5 || currentStarForceLevel == 7 || currentStarForceLevel == 9 || currentStarForceLevel == 11 || currentStarForceLevel > 12)
          {
            incWAtk += 1;
            incMAtk += 1;
          }
        }

        if (currentStarForceLevel < 5)
        {
          incAllStat += 2;
        } else if (currentStarForceLevel < 16){
          incAllStat += 3 ;
        }
      } else {
        if (GameConstants.isWeapon(itemId) == false)
        {
          currentDef = (int)Math.ceil(currentDef * 1.05);
        }
        
        // TODO: 16星以上加的属性和攻击力
        if (reqLevel < 140) {
          // 130级装备
        } else if (reqLevel < 150){
          // 140级装备
        } else if(reqLevel < 160) {
          // 150级装备
        } else if(reqLevel < 200) {
          // 160级装备
        } else if (reqLevel < 249) {
          // 200级装备
        } else if( reqLevel>=249) {
          // 250级装备
        }
      }
    }
    
    incDef = currentDef - item.getTotalWdef();
    
    incWAtk = currentWatk - item.getTotalWatk();
    
    incMAtk = currentMatk - item.getTotalMatk();
    
    if(incDef > 0)
    {
      stats.add(new Pair<>(EnchantFlag.Mdef, Integer.valueOf(incDef)));
      
      stats.add(new Pair<>(EnchantFlag.Wdef, Integer.valueOf(incDef)));
    }
    
    if(incWAtk > 0)
    {
      stats.add(new Pair<>(EnchantFlag.Watk, Integer.valueOf(incWAtk)));
    }
    
    if (incMAtk > 0)
    {
      stats.add(new Pair<>(EnchantFlag.Matk, Integer.valueOf(incMAtk)));
    }
    
    if (incAllStat > 0)
    {
      stats.add(new Pair<>(EnchantFlag.Str, Integer.valueOf(incAllStat)));
      stats.add(new Pair<>(EnchantFlag.Dex, Integer.valueOf(incAllStat)));
      stats.add(new Pair<>(EnchantFlag.Int, Integer.valueOf(incAllStat)));
      stats.add(new Pair<>(EnchantFlag.Luk, Integer.valueOf(incAllStat)));
    }
    
    if (incHp > 0)
    {
      stats.add(new Pair<>(EnchantFlag.Hp, Integer.valueOf(incHp)));
    }
    
    if (incMp > 0)
    {
      stats.add(new Pair<>(EnchantFlag.Mp, Integer.valueOf(incMp)));
    }
    
    if (incAcc > 0)
    {
      stats.add(new Pair<>(EnchantFlag.Acc, Integer.valueOf(incAcc)));
    }
    
    if (incAvoid > 0)
    {
      stats.add(new Pair<>(EnchantFlag.Avoid, Integer.valueOf(incAvoid)));
    }
    
    return new StarForceStats(stats);
  }
  
  public static void handleEnchant(LittleEndianAccessor slea, MapleClient c)
  {
    Equip item;
    short pos;
    int index;
    Equip item2, trace;
    boolean shield;
    Equip equip1;
    byte catchStar;
    Equip ordinary;
    List<EquipmentScroll> ess;
    EquipmentScroll es;
    Equip equip2;
    int percent;
    int i, down;
    Equip equip3;
    StarForceStats stats;
    
    
    int result;
    
    MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
    
    byte type = slea.readByte();
    
    switch (type)
    {
      case 0:
        slea.skip(4);
        pos = slea.readShort();
        index = slea.readInt();
        if (pos > 0)
        {
          item = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(pos);
        }
        else
        {
          item = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem(pos);
        }
        equip1 = null;
        if (GameConstants.isZeroWeapon(item.getItemId()))
        {
          equip1 = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short) ((pos == -11) ? -10 : -11));
        }
        ess = equipmentScrolls(item);
        if (ess.size() <= index)
        {
          return;
        }
        es = ess.get(index);
        i = 0;
        
        percent = Integer.parseInt(es.getName().replaceAll("[\\D]*", ""));
        
        if (ServerConstants.feverTime)
        {
          if (es.getName().startsWith("純白的卷軸"))
          {
            percent += 5;
          }
          else if (es.getName().startsWith("回真卷軸") || es.getName().startsWith("亞克回真卷軸"))
          {
            percent += 20;
          }
          else
          {
            percent += 10;
          }
        }
        
        if (percent > 100)
        {
          percent = 100;
        }
        
        if (percent < 0)
        {
          percent = 0;
        }
        
        if (Randomizer.nextInt(100) < percent)
        {
          i = 1;
        }
        if (c.getPlayer().isGM())
        {
          i = 1;
        }
        if (c.getPlayer().haveItem(4001832, es.getJuhun()))
        {
          c.getPlayer().removeItem(4001832, -es.getJuhun());
        }
        else
        {
          return;
        }
        equip3 = (Equip) item.copy();
        if (i == 1)
        {
          if (scrollType(es.getName()) == 4)
          {
            Equip origin = (Equip) MapleItemInformationProvider.getInstance().getEquipById(item.getItemId(), false);
            int reqLevel = MapleItemInformationProvider.getInstance().getReqLevel(item.getItemId());
            int ordinaryPad = (origin.getWatk() > 0) ? origin.getWatk() : origin.getMatk();
            int ordinaryMad = (origin.getMatk() > 0) ? origin.getMatk() : origin.getWatk();
            origin.setState(equip3.getState());
            origin.setPotential1(equip3.getPotential1());
            origin.setPotential2(equip3.getPotential2());
            origin.setPotential3(equip3.getPotential3());
            origin.setPotential4(equip3.getPotential4());
            origin.setPotential5(equip3.getPotential5());
            origin.setPotential6(equip3.getPotential6());
            origin.setSoulEnchanter(equip3.getSoulEnchanter());
            origin.setSoulName(equip3.getSoulName());
            origin.setSoulPotential(equip3.getSoulPotential());
            origin.setSoulSkill(equip3.getSoulSkill());
            origin.setFire(equip3.getFire());
            origin.setKarmaCount(equip3.getKarmaCount());
            item.set(origin);
            if (equip1 != null)
            {
              equip1.set(origin);
            }
            int[] rebirth = new int[4];
            String fire = String.valueOf(item.getFire());
            if (fire.length() == 12)
            {
              rebirth[0] = Integer.parseInt(fire.substring(0, 3));
              rebirth[1] = Integer.parseInt(fire.substring(3, 6));
              rebirth[2] = Integer.parseInt(fire.substring(6, 9));
              rebirth[3] = Integer.parseInt(fire.substring(9));
            }
            else if (fire.length() == 11)
            {
              rebirth[0] = Integer.parseInt(fire.substring(0, 2));
              rebirth[1] = Integer.parseInt(fire.substring(2, 5));
              rebirth[2] = Integer.parseInt(fire.substring(5, 8));
              rebirth[3] = Integer.parseInt(fire.substring(8));
            }
            else if (fire.length() == 10)
            {
              rebirth[0] = Integer.parseInt(fire.substring(0, 1));
              rebirth[1] = Integer.parseInt(fire.substring(1, 4));
              rebirth[2] = Integer.parseInt(fire.substring(4, 7));
              rebirth[3] = Integer.parseInt(fire.substring(7));
            }
            if (fire.length() >= 10)
            {
              for (int k = 0; k < 4; k++)
              {
                int randomOption = rebirth[k] / 10;
                int randomValue = rebirth[k] - rebirth[k] / 10 * 10;
                item.setFireOption(randomOption, reqLevel, randomValue, ordinaryPad, ordinaryMad);
                if (equip1 != null)
                {
                  equip1.setFireOption(randomOption, reqLevel, randomValue, ordinaryPad, ordinaryMad);
                }
              }
            }
            item.setEquipmentType(4352);
            if (es.getName().contains("亞克回真卷軸"))
            {
              item.setStarForceLevel((byte) 0);
              
              item.starForceStats = calcStarForceStat(item);
            }
          }
          else if (scrollType(es.getName()) == 5)
          {
            item.setUpgradeSlots((byte) (item.getUpgradeSlots() + 1));
            if (equip1 != null)
            {
              equip1.setUpgradeSlots((byte) (equip1.getUpgradeSlots() + 1));
            }
            c.getSession().writeAndFlush(CWvsContext.equipmentEnchantResult(50, item, null, null, null, 0));
          }
          else
          {
            item.setLevel((byte) (item.getLevel() + 1));
            if (equip1 != null)
            {
              equip1.setLevel((byte) (equip1.getLevel() + 1));
            }
            if (EnchantFlag.Watk.check(es.getFlag()))
            {
              item.setWatk((short) (item.getWatk() + (es.getFlag(EnchantFlag.Watk)).right.intValue()));
              if (equip1 != null)
              {
                equip1.setWatk((short) (equip1.getWatk() + (es.getFlag(EnchantFlag.Watk)).right.intValue()));
              }
            }
            if (EnchantFlag.Matk.check(es.getFlag()))
            {
              item.setMatk((short) (item.getMatk() + (es.getFlag(EnchantFlag.Matk)).right.intValue()));
              if (equip1 != null)
              {
                equip1.setMatk((short) (equip1.getMatk() + (es.getFlag(EnchantFlag.Matk)).right.intValue()));
              }
            }
            if (EnchantFlag.Str.check(es.getFlag()))
            {
              item.setStr((short) (item.getStr() + (es.getFlag(EnchantFlag.Str)).right.intValue()));
              if (equip1 != null)
              {
                equip1.setStr((short) (equip1.getStr() + (es.getFlag(EnchantFlag.Str)).right.intValue()));
              }
            }
            if (EnchantFlag.Dex.check(es.getFlag()))
            {
              item.setDex((short) (item.getDex() + (es.getFlag(EnchantFlag.Dex)).right.intValue()));
              if (equip1 != null)
              {
                equip1.setDex((short) (equip1.getDex() + (es.getFlag(EnchantFlag.Dex)).right.intValue()));
              }
            }
            if (EnchantFlag.Int.check(es.getFlag()))
            {
              item.setInt((short) (item.getInt() + (es.getFlag(EnchantFlag.Int)).right.intValue()));
              if (equip1 != null)
              {
                equip1.setInt((short) (equip1.getInt() + (es.getFlag(EnchantFlag.Int)).right.intValue()));
              }
            }
            if (EnchantFlag.Luk.check(es.getFlag()))
            {
              item.setLuk((short) (item.getLuk() + (es.getFlag(EnchantFlag.Luk)).right.intValue()));
              if (equip1 != null)
              {
                equip1.setLuk((short) (equip1.getLuk() + (es.getFlag(EnchantFlag.Luk)).right.intValue()));
              }
            }
            if (EnchantFlag.Wdef.check(es.getFlag()))
            {
              item.setWdef((short) (item.getWdef() + (es.getFlag(EnchantFlag.Wdef)).right.intValue()));
              if (equip1 != null)
              {
                equip1.setWdef((short) (equip1.getWdef() + (es.getFlag(EnchantFlag.Wdef)).right.intValue()));
              }
            }
            if (EnchantFlag.Mdef.check(es.getFlag()))
            {
              item.setMdef((short) (item.getMdef() + (es.getFlag(EnchantFlag.Mdef)).right.intValue()));
              if (equip1 != null)
              {
                equip1.setMdef((short) (equip1.getMdef() + (es.getFlag(EnchantFlag.Mdef)).right.intValue()));
              }
            }
            if (EnchantFlag.Hp.check(es.getFlag()))
            {
              item.setHp((short) (item.getHp() + (es.getFlag(EnchantFlag.Hp)).right.intValue()));
              if (equip1 != null)
              {
                equip1.setHp((short) (equip1.getHp() + (es.getFlag(EnchantFlag.Hp)).right.intValue()));
              }
            }
            if (EnchantFlag.Mp.check(es.getFlag()))
            {
              item.setMp((short) (item.getMp() + (es.getFlag(EnchantFlag.Mp)).right.intValue()));
              if (equip1 != null)
              {
                equip1.setMp((short) (equip1.getMp() + (es.getFlag(EnchantFlag.Mp)).right.intValue()));
              }
            }
            if (EnchantFlag.Acc.check(es.getFlag()))
            {
              item.setAcc((short) (item.getAcc() + (es.getFlag(EnchantFlag.Acc)).right.intValue()));
              if (equip1 != null)
              {
                equip1.setAcc((short) (equip1.getAcc() + (es.getFlag(EnchantFlag.Acc)).right.intValue()));
              }
            }
            if (EnchantFlag.Avoid.check(es.getFlag()))
            {
              item.setAvoid((short) (item.getAvoid() + (es.getFlag(EnchantFlag.Avoid)).right.intValue()));
              if (equip1 != null)
              {
                equip1.setAvoid((short) (equip1.getAvoid() + (es.getFlag(EnchantFlag.Avoid)).right.intValue()));
              }
            }
            if (!GameConstants.isWeapon(item.getItemId()) && item.getItemId() / 10000 != 108 && item.getLevel() == 4)
            {
              if (ii.getReqJob(item.getItemId()) == 2)
              {
                item.addMatk((short) 1);
                if (equip1 != null)
                {
                  equip1.addMatk((short) 1);
                }
              }
              else
              {
                item.addWatk((short) 1);
                if (equip1 != null)
                {
                  equip1.addWatk((short) 1);
                }
              }
            }
          }
        }
        if (scrollType(es.getName()) <= 3)
        {
          boolean safety = false;
          if (ItemFlag.SAFETY_SHIELD.check(item.getFlag()))
          {
            item.setFlag(item.getFlag() - ItemFlag.SAFETY_SHIELD.getValue());
            if (equip1 != null)
            {
              equip1.setFlag(equip1.getFlag() - ItemFlag.SAFETY_SHIELD.getValue());
            }
            safety = true;
          }
          if (!safety || i > 0)
          {
            item.setUpgradeSlots((byte) (item.getUpgradeSlots() - 1));
            if (equip1 != null)
            {
              equip1.setUpgradeSlots((byte) (equip1.getUpgradeSlots() - 1));
            }
          }
          else
          {
            c.getPlayer().dropMessage(5, "세이프티 실드의 효과로 업그레이드 횟수가 차감되지 않았습니다.");
          }
        }
        
        c.getSession().writeAndFlush(CWvsContext.equipmentEnchantResult(100, equip3, item, es, null, i));
        
        c.getSession().writeAndFlush(CWvsContext.InventoryPacket.updateInventoryItem(false, MapleInventoryType.EQUIP, item));
        if (equip1 != null)
        {
          c.getSession().writeAndFlush(CWvsContext.InventoryPacket.updateInventoryItem(false, MapleInventoryType.EQUIP, equip1));
        }
        break;
      case 1:
        slea.skip(4);
        pos = slea.readShort();
        if (pos > 0)
        {
          item = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(pos);
        }
        else
        {
          item = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem(pos);
        }
        item2 = null;
        if (GameConstants.isZeroWeapon(item.getItemId()))
        {
          item2 = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short) ((pos == -11) ? -10 : -11));
        }
        catchStar = slea.readByte();
        if (catchStar == 1)
        {
          slea.skip(4);
        }
        
        slea.readInt();
        
        slea.readInt();
        
        boolean isStarShield = (c.getPlayer()).shield;
        
        equip2 = (Equip) item.copy();
        
        int chance = starForcePercent(item);
        
        long mesoCost = calcStarForceMeso(item);
        
        if (catchStar == 1)
        {
          chance += 50;
        }
        
        int downChance = 1000 - chance;
        
        byte currentStarForceLevel = item.getStarForceLevel();
        
        if (isStarShield || currentStarForceLevel < 16 || currentStarForceLevel != 20)
        {
          downChance = 0;
        }
//        if (c.getPlayer().isGM())
//        {
//          i = 1000;
//        }
        
        if (chance >= 1000)
        {
          chance = 1000;
        }
        
        if (c.getPlayer().getMeso() < mesoCost)
        {
          c.getPlayer().dropMessage(1, "메소가 부족합니다.");
          return;
        }
        
        if (isStarShield)
        {
          mesoCost *= 2;
        }
        
        
        c.getPlayer().gainMeso(mesoCost * -1, false);
        
        if (Randomizer.nextInt(1000) <= chance)
        {
          result = 1;
          
          item.setStarForceLevel((byte) (currentStarForceLevel + 1));
          
          item.starForceStats = calcStarForceStat(item);
          
          if (item2 != null)
          {
            item2.setStarForceLevel((byte) (currentStarForceLevel + 1));
            
            item.starForceStats = calcStarForceStat(item2);
          }
        }
        else if (Randomizer.nextInt(1000) <= downChance)
        {
          result = 2;
          
          item.setStarForceLevel((byte) (item.getStarForceLevel() - 1));
          
          item.starForceStats = calcStarForceStat(item);
          
          if (item2 != null)
          {
            item2.setStarForceLevel((byte) (item2.getStarForceLevel() * 1));
            
            item.starForceStats = calcStarForceStat(item2);
          }
        }
        else
        {
          result = 3;
        }
        
        (c.getPlayer()).shield = false;
        
        c.getSession().writeAndFlush(CWvsContext.equipmentEnchantResult(101, equip2, item, null, null, result));
        
        c.getSession().writeAndFlush(CWvsContext.InventoryPacket.updateInventoryItem(false, MapleInventoryType.EQUIP, item));
        
        if (item2 != null)
        {
          c.getSession().writeAndFlush(CWvsContext.InventoryPacket.updateInventoryItem(false, MapleInventoryType.EQUIP, item2));
        }
        
        break;
      case 2:
        slea.skip(4);
        pos = slea.readShort();
        if (pos > 0)
        {
          item = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(pos);
        }
        else
        {
          item = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem(pos);
        }
        pos = slea.readShort();
        if (pos > 0)
        {
          trace = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(pos);
        }
        else
        {
          trace = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem(pos);
        }
        ordinary = (Equip) trace.copy();
        trace.setEnchantBuff((short) 0);
        MapleInventoryManipulator.removeFromSlot(c, MapleInventoryType.EQUIP, item.getPosition(), (short) 1, false);
        c.getSession().writeAndFlush(CWvsContext.equipmentEnchantResult(101, ordinary, trace, null, null, 1));
        c.getSession().writeAndFlush(CWvsContext.InventoryPacket.updateInventoryItem(false, MapleInventoryType.EQUIP, trace));
        if (GameConstants.isZeroWeapon(trace.getItemId()))
        {
          if (GameConstants.isAlphaWeapon(trace.getItemId()))
          {
            MapleInventoryManipulator.equip(c, trace.getPosition(), (short) -11, MapleInventoryType.EQUIP);
            break;
          }
          if (GameConstants.isBetaWeapon(trace.getItemId()))
          {
            MapleInventoryManipulator.equip(c, trace.getPosition(), (short) -10, MapleInventoryType.EQUIP);
          }
        }
        break;
      case 50:
        pos = slea.readShort();
        if (pos > 0)
        {
          item = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(pos);
        }
        else
        {
          item = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem(pos);
        }
        c.getSession().writeAndFlush(CWvsContext.equipmentEnchantResult(type, item, null, null, null, 0));
        break;
      case 52:
        pos = (short) slea.readInt();
        if (pos > 0)
        {
          item = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(pos);
        }
        else
        {
          item = (Equip) c.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem(pos);
        }
        shield = (slea.readByte() == 1);
        
        (c.getPlayer()).shield = shield;
        
        chance = starForcePercent(item);
        
        mesoCost = calcStarForceMeso(item);
        
        if (shield)
        {
          mesoCost *= 2;
        }
        
        if (chance >= 1000)
        {
          chance = 1000;
        }
        
        down = 1000 - chance;
        
        stats = calcStarForceStat(item);
        
        
        if (c.getPlayer().getInventory(MapleInventoryType.EQUIP).getNumFreeSlot() < (GameConstants.isZeroWeapon(item.getItemId()) ? 2 : 1))
        {
          c.getPlayer().dropMessage(1, "장비 창에 " + (GameConstants.isZeroWeapon(item.getItemId()) ? 2 : 1) + "칸 이상의 공간이 필요합니다.");
          return;
        }
        
        c.getSession().writeAndFlush(CWvsContext.equipmentEnchantResult(type, item, null, null, stats,0, mesoCost, chance, down, 0));
        break;
      case 53:
        c.getSession().writeAndFlush(CWvsContext.equipmentEnchantResult(53, null, null, null, null, -1525457920));
        break;
    }
  }
  
  public static int starForcePercent(Equip item)
  {
    // check https://strategywiki.org/wiki/MapleStory/Spell_Trace_and_Star_Force#Star_Limit
    // 概率魔改一下, 让强化到 25 星成为可能, 同时去除失败炸装备的设定, 官服就受够了这点了!
    // 1 到 16失败保持! 16 到 20失败减 1 星, 20 到 21 失败保持! 21 到 25 失败减 1 星
    // 抓到星星加 5% 成功率, 不是官方的1.05倍! 多少星都加 5%
    // 暴君强化几率恒定 15% 失败不炸!
    MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
    
    boolean superial = (ii.isSuperial(item.getItemId())).right.booleanValue();
    
    switch (item.getStarForceLevel())
    {
      case 0:
        return (superial ? 150 : 950);
      case 1:
        return (superial ? 150 : 900);
      case 2:
        return (superial ? 150 : 850);
      case 3:
        return (superial ? 150 : 850);
      case 4:
        return (superial ? 150 : 800);
      case 5:
        return (superial ? 150 : 750);
      case 6:
        return (superial ? 150 : 700);
      case 7:
        return (superial ? 150 : 650);
      case 8:
        return (superial ? 150 : 600);
      case 9:
        return (superial ? 150 : 550);
      case 10:
        return (superial ? 150 : 500);
      case 11:
        return (superial ? 150 : 450);
      case 12:
        return (superial ? 150 : 400);
      case 13:
        return (superial ? 150 : 350);
      case 14:
        return (superial ? 150 : 300);
      case 15:
        return (300);
      case 16:
        return (300);
      case 17:
        return (300);
      case 18:
        return (300);
      case 19:
        return (300);
      case 20:
        return (300);
      case 21:
        return (300);
      case 22:
        return (300);
      case 23:
        return (300);
      case 24:
        return (300);
    }
    return 0;
  }
  
  public static long calcStarForceMeso(Equip item)
  {

    MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
    Integer ReqLevel = ii.getEquipStats(item.getItemId()).get("reqLevel");
    
    int equipLevel = ReqLevel != null ? ReqLevel.intValue() : 1;
    
    int starForceLevel = item.getStarForceLevel();
    if ((ii.isSuperial(item.getItemId())).right.booleanValue())
    {
      switch ((ii.isSuperial(item.getItemId())).left)
      {
        case "Helisium":
          return 5956600;
        case "Nova":
          return 18507900;
        case "Tyrant":
          return 55832200;
      }
    }
    else
    {
      // check https://strategywiki.org/wiki/MapleStory/Spell_Trace_and_Star_Force#Star_Force_Enhancement
      int nextstarForceLevel = starForceLevel + 1;
      
      if (starForceLevel < 10)
      {
        return 100 * Math.round(Math.pow(equipLevel, 3) * nextstarForceLevel / 2500 + 10);
      }
      else
      {
        double v = Math.pow(equipLevel, 3) * Math.pow(nextstarForceLevel, 3);
        if (starForceLevel < 15)
        {
          return 100 * Math.round(v / 40000 + 10);
        }
        else
        {
          return 100 * Math.round(v / 20000 + 10);
        }
      }
      
    }
    return 0L;
  }
  
  private static void setJuhun(int level, boolean weapon)
  {
    switch (level / 10)
    {
      case 1:
        usejuhun[0] = 2;
        usejuhun[1] = 3;
        usejuhun[2] = 4;
        usejuhun[3] = 5;
        break;
      case 2:
        usejuhun[0] = 3;
        usejuhun[1] = 4;
        usejuhun[2] = 5;
        usejuhun[3] = 6;
        break;
      case 3:
        usejuhun[0] = 5;
        usejuhun[1] = 7;
        usejuhun[2] = 8;
        usejuhun[3] = 10;
        break;
      case 4:
        usejuhun[0] = 6;
        usejuhun[1] = 8;
        usejuhun[2] = 10;
        usejuhun[3] = 12;
        break;
      case 5:
        usejuhun[0] = 8;
        usejuhun[1] = 10;
        usejuhun[2] = 12;
        usejuhun[3] = 14;
        break;
      case 6:
        usejuhun[0] = 9;
        usejuhun[1] = 12;
        usejuhun[2] = 14;
        usejuhun[3] = 17;
        break;
      case 7:
        usejuhun[0] = 11;
        usejuhun[1] = 14;
        usejuhun[2] = 17;
        usejuhun[3] = 20;
        break;
      case 8:
        usejuhun[0] = 23;
        usejuhun[1] = 30;
        usejuhun[2] = 36;
        usejuhun[3] = 43;
        break;
      case 9:
        usejuhun[0] = 29;
        usejuhun[1] = 38;
        usejuhun[2] = 46;
        usejuhun[3] = 55;
        break;
      case 10:
        usejuhun[0] = 36;
        usejuhun[1] = 47;
        usejuhun[2] = 56;
        usejuhun[3] = 67;
        break;
      case 11:
        usejuhun[0] = 43;
        usejuhun[1] = 56;
        usejuhun[2] = 67;
        usejuhun[3] = 80;
        break;
      case 12:
        if (!weapon)
        {
          usejuhun[0] = 95;
          usejuhun[1] = 120;
          usejuhun[2] = 145;
          break;
        }
        usejuhun[0] = 155;
        usejuhun[1] = 200;
        usejuhun[2] = 240;
        usejuhun[3] = 290;
        break;
      case 13:
        if (!weapon)
        {
          usejuhun[0] = 120;
          usejuhun[1] = 155;
          usejuhun[2] = 190;
          break;
        }
        usejuhun[0] = 200;
        usejuhun[1] = 260;
        usejuhun[2] = 310;
        usejuhun[3] = 370;
        break;
      case 14:
        if (!weapon)
        {
          usejuhun[0] = 150;
          usejuhun[1] = 195;
          usejuhun[2] = 230;
          break;
        }
        usejuhun[0] = 240;
        usejuhun[1] = 320;
        usejuhun[2] = 380;
        usejuhun[3] = 460;
        break;
      case 15:
      case 16:
      case 20:
        if (!weapon)
        {
          usejuhun[0] = 185;
          usejuhun[1] = 240;
          usejuhun[2] = 290;
          break;
        }
        usejuhun[0] = 280;
        usejuhun[1] = 380;
        usejuhun[2] = 450;
        usejuhun[3] = 570;
        break;
    }
  }
}
