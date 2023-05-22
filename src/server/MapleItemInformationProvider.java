package server;

import client.MapleCharacter;
import client.StructPotentialItem;
import client.inventory.*;
import constants.GameConstants;
import database.DatabaseConnection;
import provider.*;
import tools.Pair;
import tools.Triple;

import java.awt.*;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

public class MapleItemInformationProvider
{
  
  private static final MapleItemInformationProvider instance = new MapleItemInformationProvider();
  
  protected final MapleDataProvider chrData = MapleDataProviderFactory.getDataProvider(new File(System.getProperty("wz") + "/Character.wz"));
  
  protected final MapleDataProvider etcData = MapleDataProviderFactory.getDataProvider(new File(System.getProperty("wz") + "/Etc.wz"));
  
  protected final MapleDataProvider itemData = MapleDataProviderFactory.getDataProvider(new File(System.getProperty("wz") + "/Item.wz"));
  
  protected final MapleDataProvider stringData = MapleDataProviderFactory.getDataProvider(new File(System.getProperty("wz") + "/String.wz"));
  
  protected final Map<Integer, ItemInformation> dataCache = new HashMap<>();
  
  protected final Map<String, List<Triple<String, Point, Point>>> afterImage = new HashMap<>();
  
  protected final Map<Integer, List<StructPotentialItem>> potentialCache = new HashMap<>();
  
  protected final Map<Integer, SecondaryStatEffect> itemEffects = new HashMap<>();
  
  protected final Map<Integer, SecondaryStatEffect> itemEffectsEx = new HashMap<>();
  
  protected final Map<Integer, Integer> mobIds = new HashMap<>();
  
  protected final Map<Integer, Pair<Integer, Integer>> potLife = new HashMap<>();
  
  protected final Map<Integer, Triple<Pair<List<Integer>, List<Integer>>, List<Integer>, Integer>> androids = new HashMap<>();
  
  protected final Map<Integer, Triple<Integer, List<Integer>, List<Integer>>> monsterBookSets = new HashMap<>();
  
  protected final Map<Integer, StructSetItem> setItems = new HashMap<>();
  
  protected final List<Pair<Integer, String>> itemNameCache = new ArrayList<>();
  
  protected final Map<Integer, Integer> scrollUpgradeSlotUse = new HashMap<>();
  
  protected final Map<Integer, Integer> cursedCache = new HashMap<>();
  
  protected final Map<Integer, Integer> successCache = new HashMap<>();
  
  protected final Map<Integer, List<Triple<Boolean, Integer, Integer>>> potentialOpCache = new HashMap<>();
  private ItemInformation tmpInfo = null;
  
  public static final MapleItemInformationProvider getInstance()
  {
    return instance;
  }
  
  private static int getEquipLevel(int level)
  {
    int stat = 0;
    if (level >= 0 && level <= 50)
    {
      stat = 1;
    }
    else if (level >= 51 && level <= 100)
    {
      stat = 2;
    }
    else
    {
      stat = 3;
    }
    return stat;
  }
  
  public EquipTemplate getTempateByItemId(int itemId)
  {
    return dataCache.get(itemId).template;
  }
  
  public void runEtc()
  {
    if (!this.setItems.isEmpty() || !this.potentialCache.isEmpty())
    {
      return;
    }
    MapleData setsData = this.etcData.getData("SetItemInfo.img");
    for (MapleData dat : setsData)
    {
      StructSetItem itemz = new StructSetItem();
      itemz.setItemID = Integer.parseInt(dat.getName());
      itemz.completeCount = (byte) MapleDataTool.getIntConvert("completeCount", dat, 0);
      itemz.jokerPossible = (MapleDataTool.getIntConvert("jokerPossible", dat, 0) > 0);
      itemz.zeroWeaponJokerPossible = (MapleDataTool.getIntConvert("zeroWeaponJokerPossible", dat, 0) > 0);
      for (MapleData level : dat.getChildByPath("ItemID"))
      {
        if (level.getType() != MapleDataType.INT)
        {
          for (MapleData leve : level)
          {
            if (!leve.getName().equals("representName") && !leve.getName().equals("typeName"))
            {
              itemz.itemIDs.add(Integer.valueOf(MapleDataTool.getInt(leve)));
            }
          }
          continue;
        }
        itemz.itemIDs.add(Integer.valueOf(MapleDataTool.getInt(level)));
      }
      for (MapleData level : dat.getChildByPath("Effect"))
      {
        StructSetItem.SetItem itez = new StructSetItem.SetItem();
        itez.incPDD = MapleDataTool.getIntConvert("incPDD", level, 0);
        itez.incMDD = MapleDataTool.getIntConvert("incMDD", level, 0);
        itez.incSTR = MapleDataTool.getIntConvert("incSTR", level, 0);
        itez.incDEX = MapleDataTool.getIntConvert("incDEX", level, 0);
        itez.incINT = MapleDataTool.getIntConvert("incINT", level, 0);
        itez.incLUK = MapleDataTool.getIntConvert("incLUK", level, 0);
        itez.incACC = MapleDataTool.getIntConvert("incACC", level, 0);
        itez.incPAD = MapleDataTool.getIntConvert("incPAD", level, 0);
        itez.incMAD = MapleDataTool.getIntConvert("incMAD", level, 0);
        itez.incSpeed = MapleDataTool.getIntConvert("incSpeed", level, 0);
        itez.incMHP = MapleDataTool.getIntConvert("incMHP", level, 0);
        itez.incMMP = MapleDataTool.getIntConvert("incMMP", level, 0);
        itez.incMHPr = MapleDataTool.getIntConvert("incMHPr", level, 0);
        itez.incMMPr = MapleDataTool.getIntConvert("incMMPr", level, 0);
        itez.incAllStat = MapleDataTool.getIntConvert("incAllStat", level, 0);
        itez.option1 = MapleDataTool.getIntConvert("Option/1/option", level, 0);
        itez.option2 = MapleDataTool.getIntConvert("Option/2/option", level, 0);
        itez.option1Level = MapleDataTool.getIntConvert("Option/1/level", level, 0);
        itez.option2Level = MapleDataTool.getIntConvert("Option/2/level", level, 0);
        if (level.getChildByPath("activeSkill") != null)
        {
          for (MapleData skill : level.getChildByPath("activeSkill"))
          {
            itez.activeSkills.put(Integer.valueOf(MapleDataTool.getIntConvert("id", skill, 0)), Byte.valueOf((byte) MapleDataTool.getIntConvert("level", skill, 0)));
          }
        }
        itemz.items.put(Integer.valueOf(Integer.parseInt(level.getName())), itez);
      }
      this.setItems.put(Integer.valueOf(itemz.setItemID), itemz);
    }
    MapleDataDirectoryEntry e = (MapleDataDirectoryEntry) this.etcData.getRoot().getEntry("Android");
    for (MapleDataEntry d : e.getFiles())
    {
      MapleData iz = this.etcData.getData("Android/" + d.getName());
      int gender = 0;
      List<Integer> hair = new ArrayList<>(), face = new ArrayList<>(), skin = new ArrayList<>();
      for (MapleData ds : iz.getChildByPath("costume/hair"))
      {
        hair.add(Integer.valueOf(MapleDataTool.getInt(ds, 30000)));
      }
      for (MapleData ds : iz.getChildByPath("costume/face"))
      {
        face.add(Integer.valueOf(MapleDataTool.getInt(ds, 20000)));
      }
      for (MapleData ds : iz.getChildByPath("costume/skin"))
      {
        skin.add(Integer.valueOf(MapleDataTool.getInt(ds, 0)));
      }
      for (MapleData ds : iz.getChildByPath("info"))
      {
        if (ds.getName().equals("gender"))
        {
          gender = MapleDataTool.getInt(ds, 0);
        }
      }
      this.androids.put(Integer.valueOf(Integer.parseInt(d.getName().substring(0, 4))), new Triple<>(new Pair<>(hair, face), skin, Integer.valueOf(gender)));
    }
    MapleData lifesData = this.etcData.getData("ItemPotLifeInfo.img");
    for (MapleData d : lifesData)
    {
      if (d.getChildByPath("info") != null && MapleDataTool.getInt("type", d.getChildByPath("info"), 0) == 1)
      {
        this.potLife.put(Integer.valueOf(MapleDataTool.getInt("counsumeItem", d.getChildByPath("info"), 0)), new Pair<>(Integer.valueOf(Integer.parseInt(d.getName())), Integer.valueOf(d.getChildByPath("level").getChildren().size())));
      }
    }
    List<Triple<String, Point, Point>> thePointK = new ArrayList<>();
    List<Triple<String, Point, Point>> thePointA = new ArrayList<>();
    MapleDataDirectoryEntry a = (MapleDataDirectoryEntry) this.chrData.getRoot().getEntry("Afterimage");
    for (MapleDataEntry b : a.getFiles())
    {
      MapleData iz = this.chrData.getData("Afterimage/" + b.getName());
      List<Triple<String, Point, Point>> thePoint = new ArrayList<>();
      Map<String, Pair<Point, Point>> dummy = new HashMap<>();
      for (MapleData i : iz)
      {
        for (MapleData xD : i)
        {
          if (xD.getName().contains("prone") || xD.getName().contains("double") || xD.getName().contains("triple"))
          {
            continue;
          }
          if ((b.getName().contains("bow") || b.getName().contains("Bow")) && !xD.getName().contains("shoot"))
          {
            continue;
          }
          if ((b.getName().contains("gun") || b.getName().contains("cannon")) && !xD.getName().contains("shot"))
          {
            continue;
          }
          if (dummy.containsKey(xD.getName()))
          {
            if (xD.getChildByPath("lt") != null)
            {
              Point point1 = (Point) xD.getChildByPath("lt").getData();
              Point ourLt = dummy.get(xD.getName()).left;
              if (point1.x < ourLt.x)
              {
                ourLt.x = point1.x;
              }
              if (point1.y < ourLt.y)
              {
                ourLt.y = point1.y;
              }
            }
            if (xD.getChildByPath("rb") != null)
            {
              Point point1 = (Point) xD.getChildByPath("rb").getData();
              Point ourRb = dummy.get(xD.getName()).right;
              if (point1.x > ourRb.x)
              {
                ourRb.x = point1.x;
              }
              if (point1.y > ourRb.y)
              {
                ourRb.y = point1.y;
              }
            }
            continue;
          }
          Point lt = null, rb = null;
          if (xD.getChildByPath("lt") != null)
          {
            lt = (Point) xD.getChildByPath("lt").getData();
          }
          if (xD.getChildByPath("rb") != null)
          {
            rb = (Point) xD.getChildByPath("rb").getData();
          }
          dummy.put(xD.getName(), new Pair<>(lt, rb));
        }
      }
      for (Map.Entry<String, Pair<Point, Point>> ez : dummy.entrySet())
      {
        if (ez.getKey().length() > 2 && ez.getKey().charAt(ez.getKey().length() - 2) == 'D')
        {
          thePointK.add(new Triple<>(ez.getKey(), ez.getValue().left, ez.getValue().right));
          continue;
        }
        if (ez.getKey().contains("PoleArm"))
        {
          thePointA.add(new Triple<>(ez.getKey(), ez.getValue().left, ez.getValue().right));
          continue;
        }
        thePoint.add(new Triple<>(ez.getKey(), ez.getValue().left, ez.getValue().right));
      }
      this.afterImage.put(b.getName().substring(0, b.getName().length() - 4), thePoint);
    }
    this.afterImage.put("katara", thePointK);
    this.afterImage.put("aran", thePointA);
  }
  
  public void runItems()
  {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try
    {
      con = DatabaseConnection.getConnection();
      ps = con.prepareStatement("SELECT * FROM wz_itemdata");
      rs = ps.executeQuery();
      while (rs.next())
      {
        initItemInformation(rs);
      }
      rs.close();
      ps.close();
      ps = con.prepareStatement("SELECT * FROM wz_itemequipdata ORDER BY itemid");
      rs = ps.executeQuery();
      while (rs.next())
      {
        initItemEquipData(rs);
      }
      rs.close();
      ps.close();
      ps = con.prepareStatement("SELECT * FROM wz_itemadddata ORDER BY itemid");
      rs = ps.executeQuery();
      while (rs.next())
      {
        initItemAddData(rs);
      }
      rs.close();
      ps.close();
      ps = con.prepareStatement("SELECT * FROM wz_itemrewarddata ORDER BY itemid");
      rs = ps.executeQuery();
      while (rs.next())
      {
        initItemRewardData(rs);
      }
      rs.close();
      ps.close();
      for (Map.Entry<Integer, ItemInformation> entry : this.dataCache.entrySet())
      {
        if (GameConstants.getInventoryType(entry.getKey().intValue()) == MapleInventoryType.EQUIP || GameConstants.getInventoryType(entry.getKey().intValue()) == MapleInventoryType.CODY)
        {
          finalizeEquipData(entry.getValue());
        }
      }
      cachePotentialItems();
      cachePotentialOption();
      con.close();
    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
    }
    finally
    {
      try
      {
        if (con != null)
        {
          con.close();
        }
        if (ps != null)
        {
          ps.close();
        }
        if (rs != null)
        {
          rs.close();
        }
      }
      catch (SQLException se)
      {
        se.printStackTrace();
      }
    }
  }
  
  public final int getPotentialOptionID(int level, boolean additional, int itemtype)
  {
    List<Integer> potentials = new ArrayList<>();
    int i = 0;
    while (potentials.size() <= 0 || potentials.isEmpty())
    {
      potentials = new ArrayList<>();
      potentialSet(potentials, level, additional, itemtype);
      if (i++ == 10)
      {
        break;
      }
    }
    if (potentials.size() <= 0 || potentials.isEmpty())
    {
      System.out.println(level + "레벨 " + itemtype + "타입 아이템의 잠재능력 리스트 0개 -_- / 에디셔널 여부 : " + additional);
    }
    return potentials.get(Randomizer.nextInt(potentials.size())).intValue();
  }
  
  private void potentialSet(List<Integer> potentials, int level, boolean additional, int itemtype)
  {
    if (isWeaponPotential(itemtype))
    {
      addPotential(potentials, this.potentialOpCache.get(Integer.valueOf(10)), level, additional, itemtype);
    }
    else
    {
      addPotential(potentials, this.potentialOpCache.get(Integer.valueOf(11)), level, additional, itemtype);
    }
    if (!isWeaponPotential(itemtype))
    {
      if (isAccessoryPotential(itemtype))
      {
        addPotential(potentials, this.potentialOpCache.get(Integer.valueOf(40)), level, additional, itemtype);
      }
      else if (additional)
      {
        addPotential(potentials, this.potentialOpCache.get(Integer.valueOf(20)), level, additional, itemtype);
      }
    }
    if (itemtype / 10 == 100)
    {
      addPotential(potentials, this.potentialOpCache.get(Integer.valueOf(51)), level, additional, itemtype);
    }
    if (itemtype / 10 == 104)
    {
      addPotential(potentials, this.potentialOpCache.get(Integer.valueOf(52)), level, additional, itemtype);
    }
    if (itemtype / 10 == 106)
    {
      addPotential(potentials, this.potentialOpCache.get(Integer.valueOf(53)), level, additional, itemtype);
    }
    if (itemtype / 10 == 107)
    {
      addPotential(potentials, this.potentialOpCache.get(Integer.valueOf(55)), level, additional, itemtype);
    }
    if (itemtype / 10 == 108)
    {
      addPotential(potentials, this.potentialOpCache.get(Integer.valueOf(54)), level, additional, itemtype);
    }
    addPotential(potentials, this.potentialOpCache.get(Integer.valueOf(-1)), level, additional, itemtype);
  }
  
  private void addPotential(List<Integer> potentials, List<Triple<Boolean, Integer, Integer>> list, int level, boolean additional, int itemtype)
  {
    for (Triple<Boolean, Integer, Integer> potential : list)
    {
      if (additional)
      {
        if (!potential.left.booleanValue())
        {
          continue;
        }
        if ((itemtype == 1190 || itemtype == 1191) && potential.right.intValue() % 1000 >= 601 && potential.right.intValue() % 1000 <= 604)
        {
          continue;
        }
        if (potential.right.intValue() % 1000 < 40)
        {
          continue;
        }
        if (level != potential.right.intValue() / 10000)
        {
          continue;
        }
        potentials.add(potential.right);
        continue;
      }
      if (potential.left.booleanValue())
      {
        continue;
      }
      if ((itemtype == 1190 || itemtype == 1191) && potential.right.intValue() % 1000 >= 601 && potential.right.intValue() % 1000 <= 604)
      {
        continue;
      }
      if (potential.right.intValue() % 1000 < 40)
      {
        continue;
      }
      if (level != potential.right.intValue() / 10000)
      {
        continue;
      }
      potentials.add(potential.right);
    }
  }
  
  private boolean isWeaponPotential(int itemtype)
  {
    return (GameConstants.isWeapon(itemtype * 1000) || itemtype == 1098 || itemtype == 1092 || itemtype == 1099 || itemtype == 1190 || itemtype == 1191);
  }
  
  private boolean isAccessoryPotential(int itemtype)
  {
    return ((itemtype >= 1112 && itemtype <= 1115) || itemtype == 1122 || itemtype == 1012 || itemtype == 1022 || itemtype == 1032);
  }
  
  public final List<StructPotentialItem> getPotentialInfo(int potId)
  {
    return this.potentialCache.get(Integer.valueOf(potId));
  }
  
  public void cachePotentialOption()
  {
    MapleData potsData = this.itemData.getData("ItemOption.img");
    for (MapleData data : potsData)
    {
      int potentialID = Integer.parseInt(data.getName());
      int type = MapleDataTool.getInt("info/optionType", data, -1);
      int reqLevel = MapleDataTool.getInt("info/reqLevel", data, 0);
      switch (potentialID)
      {
        case 32052:
        case 32054:
        case 32058:
        case 32059:
        case 32060:
        case 32061:
        case 32062:
        case 32071:
        case 32087:
        case 32116:
        case 40081:
        case 42052:
        case 42054:
        case 42058:
        case 42063:
        case 42064:
        case 42065:
        case 42066:
        case 42071:
        case 42087:
        case 42116:
        case 42291:
        case 42601:
        case 42650:
        case 42656:
        case 42661:
          continue;
      }
      boolean additional = (potentialID % 10000 / 1000 == 2);
      if (this.potentialOpCache.get(Integer.valueOf(type)) == null)
      {
        List<Triple<Boolean, Integer, Integer>> potentialIds = new ArrayList<>();
        potentialIds.add(new Triple<>(Boolean.valueOf(additional), Integer.valueOf(reqLevel), Integer.valueOf(potentialID)));
        this.potentialOpCache.put(Integer.valueOf(type), potentialIds);
        continue;
      }
      this.potentialOpCache.get(Integer.valueOf(type)).add(new Triple<>(Boolean.valueOf(additional), Integer.valueOf(reqLevel), Integer.valueOf(potentialID)));
    }
  }
  
  public void cachePotentialItems()
  {
    MapleData potsData = this.itemData.getData("ItemOption.img");
    for (MapleData data : potsData)
    {
      List<StructPotentialItem> items = new LinkedList<>();
      for (MapleData level : data.getChildByPath("level"))
      {
        StructPotentialItem item = new StructPotentialItem();
        item.optionType = MapleDataTool.getIntConvert("info/optionType", data, 0);
        item.reqLevel = MapleDataTool.getIntConvert("info/reqLevel", data, 0);
        item.weight = MapleDataTool.getIntConvert("info/weight", data, 0);
        item.string = MapleDataTool.getString("info/string", level, "");
        item.face = MapleDataTool.getString("face", level, "");
        item.boss = (MapleDataTool.getIntConvert("boss", level, 0) > 0);
        item.potentialID = Integer.parseInt(data.getName());
        item.attackType = (short) MapleDataTool.getIntConvert("attackType", level, 0);
        item.incMHP = (short) MapleDataTool.getIntConvert("incMHP", level, 0);
        item.incMMP = (short) MapleDataTool.getIntConvert("incMMP", level, 0);
        item.incSTR = (byte) MapleDataTool.getIntConvert("incSTR", level, 0);
        item.incDEX = (byte) MapleDataTool.getIntConvert("incDEX", level, 0);
        item.incINT = (byte) MapleDataTool.getIntConvert("incINT", level, 0);
        item.incLUK = (byte) MapleDataTool.getIntConvert("incLUK", level, 0);
        item.incACC = (byte) MapleDataTool.getIntConvert("incACC", level, 0);
        item.incEVA = (byte) MapleDataTool.getIntConvert("incEVA", level, 0);
        item.incSpeed = (byte) MapleDataTool.getIntConvert("incSpeed", level, 0);
        item.incJump = (byte) MapleDataTool.getIntConvert("incJump", level, 0);
        item.incPAD = (byte) MapleDataTool.getIntConvert("incPAD", level, 0);
        item.incMAD = (byte) MapleDataTool.getIntConvert("incMAD", level, 0);
        item.incPDD = (byte) MapleDataTool.getIntConvert("incPDD", level, 0);
        item.incMDD = (byte) MapleDataTool.getIntConvert("incMDD", level, 0);
        item.prop = (byte) MapleDataTool.getIntConvert("prop", level, 0);
        item.time = (byte) MapleDataTool.getIntConvert("time", level, 0);
        item.incSTRr = (byte) MapleDataTool.getIntConvert("incSTRr", level, 0);
        item.incDEXr = (byte) MapleDataTool.getIntConvert("incDEXr", level, 0);
        item.incINTr = (byte) MapleDataTool.getIntConvert("incINTr", level, 0);
        item.incLUKr = (byte) MapleDataTool.getIntConvert("incLUKr", level, 0);
        item.incMHPr = (byte) MapleDataTool.getIntConvert("incMHPr", level, 0);
        item.incMMPr = (byte) MapleDataTool.getIntConvert("incMMPr", level, 0);
        item.incACCr = (byte) MapleDataTool.getIntConvert("incACCr", level, 0);
        item.incEVAr = (byte) MapleDataTool.getIntConvert("incEVAr", level, 0);
        item.incPADr = (byte) MapleDataTool.getIntConvert("incPADr", level, 0);
        item.incMADr = (byte) MapleDataTool.getIntConvert("incMADr", level, 0);
        item.incPDDr = (byte) MapleDataTool.getIntConvert("incPDDr", level, 0);
        item.incMDDr = (byte) MapleDataTool.getIntConvert("incMDDr", level, 0);
        item.incCr = (byte) MapleDataTool.getIntConvert("incCr", level, 0);
        item.incDAMr = (byte) MapleDataTool.getIntConvert("incDAMr", level, 0);
        item.RecoveryHP = (byte) MapleDataTool.getIntConvert("RecoveryHP", level, 0);
        item.RecoveryMP = (byte) MapleDataTool.getIntConvert("RecoveryMP", level, 0);
        item.HP = (byte) MapleDataTool.getIntConvert("HP", level, 0);
        item.MP = (byte) MapleDataTool.getIntConvert("MP", level, 0);
        item.level = (byte) MapleDataTool.getIntConvert("level", level, 0);
        item.ignoreTargetDEF = (byte) MapleDataTool.getIntConvert("ignoreTargetDEF", level, 0);
        item.ignoreDAM = (byte) MapleDataTool.getIntConvert("ignoreDAM", level, 0);
        item.DAMreflect = (byte) MapleDataTool.getIntConvert("DAMreflect", level, 0);
        item.mpconReduce = (byte) MapleDataTool.getIntConvert("mpconReduce", level, 0);
        item.mpRestore = (byte) MapleDataTool.getIntConvert("mpRestore", level, 0);
        item.incMesoProp = (byte) MapleDataTool.getIntConvert("incMesoProp", level, 0);
        item.incRewardProp = (byte) MapleDataTool.getIntConvert("incRewardProp", level, 0);
        item.incAllskill = (byte) MapleDataTool.getIntConvert("incAllskill", level, 0);
        item.ignoreDAMr = (byte) MapleDataTool.getIntConvert("ignoreDAMr", level, 0);
        item.RecoveryUP = (byte) MapleDataTool.getIntConvert("RecoveryUP", level, 0);
        item.reduceCooltime = (byte) MapleDataTool.getIntConvert("reduceCooltime", level, 0);
        switch (item.potentialID)
        {
          case 31001:
          case 31002:
          case 31003:
          case 31004:
            item.skillID = item.potentialID - 23001;
            break;
          case 41005:
          case 41006:
          case 41007:
            item.skillID = item.potentialID - 33001;
            break;
          default:
            item.skillID = 0;
            break;
        }
        items.add(item);
      }
      this.potentialCache.put(Integer.valueOf(Integer.parseInt(data.getName())), items);
    }
  }
  
  public final Collection<Integer> getMonsterBookList()
  {
    return this.mobIds.values();
  }
  
  public final Map<Integer, Integer> getMonsterBook()
  {
    return this.mobIds;
  }
  
  public final Pair<Integer, Integer> getPot(int f)
  {
    return this.potLife.get(Integer.valueOf(f));
  }
  
  public final List<Pair<Integer, String>> getAllEquips()
  {
    List<Pair<Integer, String>> itemPairs = new ArrayList<>();
    MapleData itemsData = this.stringData.getData("Eqp.img").getChildByPath("Eqp");
    for (MapleData eqpType : itemsData.getChildren())
    {
      for (MapleData itemFolder : eqpType.getChildren())
      {
        itemPairs.add(new Pair<>(Integer.valueOf(Integer.parseInt(itemFolder.getName())), MapleDataTool.getString("name", itemFolder, "NO-NAME")));
      }
    }
    return itemPairs;
  }
  
  public final List<Pair<Integer, String>> getAllItems()
  {
    if (!this.itemNameCache.isEmpty())
    {
      return this.itemNameCache;
    }
    List<Pair<Integer, String>> itemPairs = new ArrayList<>();
    MapleData itemsData = this.stringData.getData("Cash.img");
    for (MapleData itemFolder : itemsData.getChildren())
    {
      itemPairs.add(new Pair<>(Integer.valueOf(Integer.parseInt(itemFolder.getName())), MapleDataTool.getString("name", itemFolder, "NO-NAME")));
    }
    itemsData = this.stringData.getData("Consume.img");
    for (MapleData itemFolder : itemsData.getChildren())
    {
      itemPairs.add(new Pair<>(Integer.valueOf(Integer.parseInt(itemFolder.getName())), MapleDataTool.getString("name", itemFolder, "NO-NAME")));
    }
    itemsData = this.stringData.getData("Eqp.img").getChildByPath("Eqp");
    for (MapleData eqpType : itemsData.getChildren())
    {
      for (MapleData itemFolder : eqpType.getChildren())
      {
        itemPairs.add(new Pair<>(Integer.valueOf(Integer.parseInt(itemFolder.getName())), MapleDataTool.getString("name", itemFolder, "NO-NAME")));
      }
    }
    itemsData = this.stringData.getData("Etc.img").getChildByPath("Etc");
    for (MapleData itemFolder : itemsData.getChildren())
    {
      itemPairs.add(new Pair<>(Integer.valueOf(Integer.parseInt(itemFolder.getName())), MapleDataTool.getString("name", itemFolder, "NO-NAME")));
    }
    itemsData = this.stringData.getData("Ins.img");
    for (MapleData itemFolder : itemsData.getChildren())
    {
      itemPairs.add(new Pair<>(Integer.valueOf(Integer.parseInt(itemFolder.getName())), MapleDataTool.getString("name", itemFolder, "NO-NAME")));
    }
    itemsData = this.stringData.getData("Pet.img");
    for (MapleData itemFolder : itemsData.getChildren())
    {
      itemPairs.add(new Pair<>(Integer.valueOf(Integer.parseInt(itemFolder.getName())), MapleDataTool.getString("name", itemFolder, "NO-NAME")));
    }
    return itemPairs;
  }
  
  public final Triple<Pair<List<Integer>, List<Integer>>, List<Integer>, Integer> getAndroidInfo(int i)
  {
    return this.androids.get(Integer.valueOf(i));
  }
  
  public final Triple<Integer, List<Integer>, List<Integer>> getMonsterBookInfo(int i)
  {
    return this.monsterBookSets.get(Integer.valueOf(i));
  }
  
  public final Map<Integer, Triple<Integer, List<Integer>, List<Integer>>> getAllMonsterBookInfo()
  {
    return this.monsterBookSets;
  }
  
  protected final MapleData getItemData(int itemId)
  {
    MapleData ret = null;
    String idStr = "0" + itemId;
    MapleDataDirectoryEntry root = this.itemData.getRoot();
    for (MapleDataDirectoryEntry topDir : root.getSubdirectories())
    {
      for (MapleDataFileEntry iFile : topDir.getFiles())
      {
        if (iFile.getName().equals(idStr.substring(0, 4) + ".img"))
        {
          ret = this.itemData.getData(topDir.getName() + "/" + iFile.getName());
          if (ret == null)
          {
            return null;
          }
          ret = ret.getChildByPath(idStr);
          return ret;
        }
        if (iFile.getName().equals(idStr.substring(1) + ".img"))
        {
          return this.itemData.getData(topDir.getName() + "/" + iFile.getName());
        }
      }
    }
    root = this.chrData.getRoot();
    for (MapleDataDirectoryEntry topDir : root.getSubdirectories())
    {
      for (MapleDataFileEntry iFile : topDir.getFiles())
      {
        if (iFile.getName().equals(idStr + ".img"))
        {
          return this.chrData.getData(topDir.getName() + "/" + iFile.getName());
        }
      }
    }
    return ret;
  }
  
  public Integer getItemIdByMob(int mobId)
  {
    return this.mobIds.get(Integer.valueOf(mobId));
  }
  
  public Integer getSetId(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return null;
    }
    return Integer.valueOf(i.cardSet);
  }
  
  public final short getSlotMax(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return 0;
    }
    return i.slotMax;
  }
  
  public final int getUpgradeScrollUseSlot(int itemid)
  {
    if (this.scrollUpgradeSlotUse.containsKey(Integer.valueOf(itemid)))
    {
      return this.scrollUpgradeSlotUse.get(Integer.valueOf(itemid)).intValue();
    }
    int useslot = MapleDataTool.getIntConvert("info/tuc", getItemData(itemid), 1);
    this.scrollUpgradeSlotUse.put(Integer.valueOf(itemid), Integer.valueOf(useslot));
    return this.scrollUpgradeSlotUse.get(Integer.valueOf(itemid)).intValue();
  }
  
  public final int getWholePrice(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return 0;
    }
    return i.wholePrice;
  }
  
  public final double getPrice(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return -1.0D;
    }
    return i.price;
  }
  
  protected int rand(int min, int max)
  {
    return Math.abs(Randomizer.rand(min, max));
  }
  
  public Equip levelUpEquip(Equip equip, Map<String, Integer> sta)
  {
    Equip nEquip = (Equip) equip.copy();
    try
    {
      for (Map.Entry<String, Integer> stat : sta.entrySet())
      {
        if (stat.getKey().equals("STRMin"))
        {
          nEquip.setEnchantStr((short) (nEquip.getEnchantStr() + rand(stat.getValue().intValue(), sta.get("STRMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("DEXMin"))
        {
          nEquip.setEnchantDex((short) (nEquip.getEnchantDex() + rand(stat.getValue().intValue(), sta.get("DEXMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("INTMin"))
        {
          nEquip.setEnchantInt((short) (nEquip.getEnchantInt() + rand(stat.getValue().intValue(), sta.get("INTMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("LUKMin"))
        {
          nEquip.setEnchantLuk((short) (nEquip.getEnchantLuk() + rand(stat.getValue().intValue(), sta.get("LUKMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("PADMin"))
        {
          nEquip.setEnchantWatk((short) (nEquip.getEnchantWatk() + rand(stat.getValue().intValue(), sta.get("PADMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("PDDMin"))
        {
          nEquip.setEnchantWdef((short) (nEquip.getEnchantWdef() + rand(stat.getValue().intValue(), sta.get("PDDMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("MADMin"))
        {
          nEquip.setEnchantMatk((short) (nEquip.getEnchantMatk() + rand(stat.getValue().intValue(), sta.get("MADMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("MDDMin"))
        {
          nEquip.setEnchantMdef((short) (nEquip.getEnchantMdef() + rand(stat.getValue().intValue(), sta.get("MDDMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("ACCMin"))
        {
          nEquip.setEnchantAccuracy((short) (nEquip.getEnchantAccuracy() + rand(stat.getValue().intValue(), sta.get("ACCMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("EVAMin"))
        {
          nEquip.setEnchantAvoid((short) (nEquip.getEnchantAvoid() + rand(stat.getValue().intValue(), sta.get("EVAMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("SpeedMin"))
        {
          nEquip.setEnchantMovementSpeed((short) (nEquip.getEnchantMovementSpeed() + rand(stat.getValue().intValue(), sta.get("SpeedMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("JumpMin"))
        {
          nEquip.setEnchantJump((short) (nEquip.getEnchantJump() + rand(stat.getValue().intValue(), sta.get("JumpMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("MHPMin"))
        {
          nEquip.setEnchantHp((short) (nEquip.getEnchantHp() + rand(stat.getValue().intValue(), sta.get("MHPMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("MMPMin"))
        {
          nEquip.setEnchantMp((short) (nEquip.getEnchantMp() + rand(stat.getValue().intValue(), sta.get("MMPMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("MaxHPMin"))
        {
          nEquip.setEnchantHp((short) (nEquip.getEnchantHp() + rand(stat.getValue().intValue(), sta.get("MaxHPMax").intValue())));
          continue;
        }
        if (stat.getKey().equals("MaxMPMin"))
        {
          nEquip.setEnchantMp((short) (nEquip.getEnchantMp() + rand(stat.getValue().intValue(), sta.get("MaxMPMax").intValue())));
        }
      }
    }
    catch (NullPointerException e)
    {
      e.printStackTrace();
    }
    return nEquip;
  }
  
  public final List<Triple<String, String, String>> getEquipAdditions(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return null;
    }
    return i.equipAdditions;
  }
  
  public final String getEquipAddReqs(int itemId, String key, String sub)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return null;
    }
    for (Triple<String, String, String> data : i.equipAdditions)
    {
      if (data.getLeft().equals("key") && data.getMid().equals("con:" + sub))
      {
        return data.getRight();
      }
    }
    return null;
  }
  
  public final Map<Integer, Map<String, Integer>> getEquipIncrements(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return null;
    }
    return i.equipIncs;
  }
  
  public final List<Integer> getEquipSkills(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return null;
    }
    return i.incSkill;
  }
  
  public final boolean canEquip(Map<String, Integer> stats, int itemid, int level, int job, int fame, int str, int dex, int luk, int int_, int supremacy)
  {
    if (str >= (stats.containsKey("reqSTR") ? stats.get("reqSTR").intValue() : 0) && dex >= (stats.containsKey("reqDEX") ? stats.get("reqDEX").intValue() : 0) && luk >= (stats.containsKey("reqLUK") ? stats.get("reqLUK").intValue() : 0) && int_ >= (stats.containsKey("reqINT") ? stats.get("reqINT").intValue() : 0))
    {
      Integer fameReq = stats.get("reqPOP");
      return fameReq == null || fame >= fameReq.intValue();
    }
    return GameConstants.isDemonAvenger(job);
  }
  
  public final Map<String, Integer> getEquipStats(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return null;
    }
    return i.equipStats;
  }
  
  public final int getReqLevel(int itemId)
  {
    if (getEquipStats(itemId) == null || !getEquipStats(itemId).containsKey("reqLevel"))
    {
      return 0;
    }
    return getEquipStats(itemId).get("reqLevel").intValue();
  }
  
  public final int getReqJob(int itemId)
  {
    if (getEquipStats(itemId) == null || !getEquipStats(itemId).containsKey("reqJob"))
    {
      return 0;
    }
    return getEquipStats(itemId).get("reqJob").intValue();
  }
  
  public final int getSlots(int itemId)
  {
    if (getEquipStats(itemId) == null || !getEquipStats(itemId).containsKey("tuc"))
    {
      return 0;
    }
    return getEquipStats(itemId).get("tuc").intValue();
  }
  
  public final Integer getSetItemID(int itemId)
  {
    if (getEquipStats(itemId) == null || !getEquipStats(itemId).containsKey("setItemID"))
    {
      return Integer.valueOf(0);
    }
    return getEquipStats(itemId).get("setItemID");
  }
  
  public final boolean isOnlyEquip(int itemId)
  {
    if (getEquipStats(itemId) == null || !getEquipStats(itemId).containsKey("onlyEquip"))
    {
      return false;
    }
    return (getEquipStats(itemId).get("onlyEquip").intValue() > 0);
  }
  
  public final StructSetItem getSetItem(int setItemId)
  {
    return this.setItems.get(Integer.valueOf(setItemId));
  }
  
  public final int getCursed(int itemId, MapleCharacter player)
  {
    return getCursed(itemId, player, null);
  }
  
  public final int getCursed(int itemId, MapleCharacter player, Item equip)
  {
    // TODO: 从WZ中获取诅咒几率
    return 0;
  }
  
  public final List<Integer> getScrollReqs(int itemId)
  {
    List<Integer> ret = new ArrayList<>();
    MapleData data = getItemData(itemId).getChildByPath("req");
    if (data == null)
    {
      return ret;
    }
    for (MapleData req : data.getChildren())
    {
      ret.add(Integer.valueOf(MapleDataTool.getInt(req)));
    }
    return ret;
  }
  
  public final Item scrollEquipWithId(Item equip, Item scrollId, boolean ws, MapleCharacter chr)
  {
    if (equip.getType() == 1)
    {
      // TODO 各种卷轴, 之前的逻辑太多了, 有很多用不上的, 直接重写
    }
    return equip;
  }
  
  public final int getSuccess(int itemId, MapleCharacter player, Item equip)
  {
    // TODO: 从wz中获取卷轴成功率
    if (player.getGMLevel() > 0)
    {
      return 100;
    }
    
    return 100;
  }
  
  public final Equip generateEquipById(int equipId, long ringId)
  {
    ItemInformation i = getItemInformation(equipId);
    if (i == null)
    {
      return null;
    }
    Equip equip = new Equip(i.template, (short) 0, 0, -1L);
    equip.setUniqueId(ringId);
    if (!isCash(equipId))
    {
      boolean isBossItem = GameConstants.isBossItem(equipId);
      long flame = equip.calcNewFlame(2048716);
      equip.setFlame(flame);
      equip.calcFlameStats();
      if (ItemFlag.UNTRADEABLE.check(equip.getFlag()) && equip.getKarmaCount() < 0 && (isKarmaEnabled(equipId) || isPKarmaEnabled(equipId)))
      {
        equip.setKarmaCount((byte) 10);
      }
    }
    return equip;
  }
  
  public final SecondaryStatEffect getItemEffect(int itemId)
  {
    SecondaryStatEffect ret = this.itemEffects.get(Integer.valueOf(itemId));
    if (ret == null)
    {
      MapleData item = getItemData(itemId);
      if (item == null || item.getChildByPath("spec") == null)
      {
        return null;
      }
      ret = SecondaryStatEffect.loadItemEffectFromData(item.getChildByPath("spec"), itemId);
      this.itemEffects.put(Integer.valueOf(itemId), ret);
    }
    return ret;
  }
  
  public final SecondaryStatEffect getItemEffectEX(int itemId)
  {
    SecondaryStatEffect ret = this.itemEffectsEx.get(Integer.valueOf(itemId));
    if (ret == null)
    {
      MapleData item = getItemData(itemId);
      if (item == null || item.getChildByPath("specEx") == null)
      {
        return null;
      }
      ret = SecondaryStatEffect.loadItemEffectFromData(item.getChildByPath("specEx"), itemId);
      this.itemEffectsEx.put(Integer.valueOf(itemId), ret);
    }
    return ret;
  }
  
  public final int getCreateId(int id)
  {
    ItemInformation i = getItemInformation(id);
    if (i == null)
    {
      return 0;
    }
    return i.create;
  }
  
  public final int getCardMobId(int id)
  {
    ItemInformation i = getItemInformation(id);
    if (i == null)
    {
      return 0;
    }
    return i.monsterBook;
  }
  
  public final int getBagType(int id)
  {
    ItemInformation i = getItemInformation(id);
    if (i == null)
    {
      return 0;
    }
    return i.flag & 0xF;
  }
  
  public final int getWatkForProjectile(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null || i.equipStats == null || i.equipStats.get("incPAD") == null)
    {
      return 0;
    }
    return i.equipStats.get("incPAD").intValue();
  }
  
  public final boolean canScroll(int scrollid, int itemid)
  {
    return (scrollid / 100 % 100 == itemid / 10000 % 100);
  }
  
  public final String getName(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return null;
    }
    return i.name;
  }
  
  public final String getDesc(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return null;
    }
    return i.desc;
  }
  
  public final String getMsg(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return null;
    }
    return i.msg;
  }
  
  public final short getItemMakeLevel(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return 0;
    }
    return i.itemMakeLevel;
  }
  
  public final boolean isDropRestricted(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return false;
    }
    return (((i.flag & 0x200) != 0 || (i.flag & 0x400) != 0 || GameConstants.isDropRestricted(itemId)) && (itemId == 3012000 || itemId == 3012015 || itemId / 10000 != 301) && itemId != 2041200 && itemId != 5640000 && itemId != 4170023 && itemId != 2040124 && itemId != 2040125 && itemId != 2040126 && itemId != 2040211 && itemId != 2040212 && itemId != 2040227 && itemId != 2040228 && itemId != 2040229 && itemId != 2040230 && itemId != 1002926 && itemId != 1002906 && itemId != 1002927);
  }
  
  public final boolean isPickupRestricted(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return false;
    }
    return (((i.flag & 0x80) != 0 || GameConstants.isPickupRestricted(itemId)) && itemId != 4001168 && itemId != 4031306 && itemId != 4031307);
  }
  
  public final boolean isAccountShared(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return false;
    }
    return ((i.flag & 0x100) != 0);
  }
  
  public final int getStateChangeItem(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return 0;
    }
    return i.stateChange;
  }
  
  public final int getMeso(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return 0;
    }
    return i.meso;
  }
  
  public final boolean isShareTagEnabled(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return false;
    }
    return ((i.flag & 0x800) != 0);
  }
  
  public final boolean isKarmaEnabled(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return false;
    }
    return (i.karmaEnabled == 1);
  }
  
  public final boolean isPKarmaEnabled(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return false;
    }
    return (i.karmaEnabled == 2);
  }
  
  public final boolean isPickupBlocked(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return false;
    }
    return ((i.flag & 0x40) != 0);
  }
  
  public final boolean isLogoutExpire(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return false;
    }
    return ((i.flag & 0x20) != 0);
  }
  
  public final boolean cantSell(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return false;
    }
    return ((i.flag & 0x10) != 0);
  }
  
  public final Pair<Integer, List<StructRewardItem>> getRewardItem(int itemid)
  {
    ItemInformation i = getItemInformation(itemid);
    if (i == null)
    {
      return null;
    }
    return new Pair<>(Integer.valueOf(i.totalprob), i.rewardItems);
  }
  
  public final boolean isMobHP(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return false;
    }
    return ((i.flag & 0x1000) != 0);
  }
  
  public final boolean isQuestItem(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return false;
    }
    return ((i.flag & 0x200) != 0 && itemId / 10000 != 301);
  }
  
  public final Pair<Integer, List<Integer>> questItemInfo(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return null;
    }
    return new Pair<>(Integer.valueOf(i.questId), i.questItems);
  }
  
  public final Pair<Integer, String> replaceItemInfo(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return null;
    }
    return new Pair<>(Integer.valueOf(i.replaceItem), i.replaceMsg);
  }
  
  public final List<Triple<String, Point, Point>> getAfterImage(String after)
  {
    return this.afterImage.get(after);
  }
  
  public final String getAfterImage(int itemId)
  {
    ItemInformation i = getItemInformation(itemId);
    if (i == null)
    {
      return null;
    }
    return i.afterImage;
  }
  
  public final boolean isJokerToSetItem(int itemId)
  {
    if (getEquipStats(itemId) == null)
    {
      return false;
    }
    return getEquipStats(itemId).containsKey("jokerToSetItem");
  }
  
  public final boolean itemExists(int itemId)
  {
    if (GameConstants.getInventoryType(itemId) == MapleInventoryType.UNDEFINED)
    {
      return false;
    }
    return (getItemInformation(itemId) != null);
  }
  
  public final boolean isCash(int itemId)
  {
    return getEquipStats(itemId) != null && getEquipStats(itemId).get("cash") != null;
  }
  
  public final ItemInformation getItemInformation(int itemId)
  {
    if (itemId <= 0)
    {
      return null;
    }
    return this.dataCache.get(Integer.valueOf(itemId));
  }
  
  public void initItemRewardData(ResultSet sqlRewardData) throws SQLException
  {
    int itemID = sqlRewardData.getInt("itemid");
    if (this.tmpInfo == null || this.tmpInfo.itemId != itemID)
    {
      if (!this.dataCache.containsKey(Integer.valueOf(itemID)))
      {
        System.out.println("[initItemRewardData] Tried to load an item while this is not in the cache: " + itemID);
        return;
      }
      this.tmpInfo = this.dataCache.get(Integer.valueOf(itemID));
    }
    if (this.tmpInfo.rewardItems == null)
    {
      this.tmpInfo.rewardItems = new ArrayList<>();
    }
    StructRewardItem add = new StructRewardItem();
    add.itemid = sqlRewardData.getInt("item");
    add.period = ((add.itemid == 1122017) ? Math.max(sqlRewardData.getInt("period"), 7200) : sqlRewardData.getInt("period"));
    add.prob = sqlRewardData.getInt("prob");
    add.quantity = sqlRewardData.getShort("quantity");
    add.worldmsg = (sqlRewardData.getString("worldMsg").length() <= 0) ? null : sqlRewardData.getString("worldMsg");
    add.effect = sqlRewardData.getString("effect");
    this.tmpInfo.rewardItems.add(add);
  }
  
  public void initItemAddData(ResultSet sqlAddData) throws SQLException
  {
    int itemID = sqlAddData.getInt("itemid");
    if (this.tmpInfo == null || this.tmpInfo.itemId != itemID)
    {
      if (!this.dataCache.containsKey(Integer.valueOf(itemID)))
      {
        System.out.println("[initItemAddData] Tried to load an item while this is not in the cache: " + itemID);
        return;
      }
      this.tmpInfo = this.dataCache.get(Integer.valueOf(itemID));
    }
    if (this.tmpInfo.equipAdditions == null)
    {
      this.tmpInfo.equipAdditions = new LinkedList<>();
    }
    while (sqlAddData.next())
    {
      this.tmpInfo.equipAdditions.add(new Triple<>(sqlAddData.getString("key"), sqlAddData.getString("subKey"), sqlAddData.getString("value")));
    }
  }
  
  public void initItemEquipData(ResultSet sqlEquipData) throws SQLException
  {
    Integer itemID = Integer.valueOf(sqlEquipData.getString("itemid"));
    if (this.tmpInfo == null || this.tmpInfo.itemId != itemID)
    {
      if (!this.dataCache.containsKey(Integer.valueOf(itemID)))
      {
        System.out.println("[initItemEquipData] Tried to load an item while this is not in the cache: " + itemID);
        return;
      }
      this.tmpInfo = this.dataCache.get(Integer.valueOf(itemID));
    }
    if (this.tmpInfo.equipStats == null)
    {
      this.tmpInfo.equipStats = new HashMap<>();
    }
    
    Integer itemLevel = Integer.valueOf(sqlEquipData.getString("itemLevel"));
    
    String key = sqlEquipData.getString("key");
    
    String value = sqlEquipData.getString("value");
    
    
    if (key.equalsIgnoreCase("islot"))
    {
      this.tmpInfo.islot = value;
    }
    else if (key.equalsIgnoreCase("vslot"))
    {
      this.tmpInfo.vslot = value;
    }
    else if (key.equalsIgnoreCase("bossReward"))
    {
      this.tmpInfo.isBossItem = Integer.valueOf(value) == 1 ? true : false;
    }
    else if (key.equalsIgnoreCase("isShield"))
    {
      this.tmpInfo.isShield = Integer.valueOf(value) == 1 ? true : false;
    }
    else if (key.equalsIgnoreCase("isWeapon"))
    {
      this.tmpInfo.isWeapon = Integer.valueOf(value) == 1 ? true : false;
    }
    else if (itemLevel == -1)
    {
      this.tmpInfo.equipStats.put(key, Integer.valueOf(value));
    }
    else
    {
      if (key.equalsIgnoreCase("android"))
      {
        this.tmpInfo.isAndroid = true;
      }
      
      if (this.tmpInfo.equipIncs == null)
      {
        this.tmpInfo.equipIncs = new HashMap<>();
      }
      Map<String, Integer> toAdd = this.tmpInfo.equipIncs.get(itemLevel);
      if (toAdd == null)
      {
        toAdd = new HashMap<>();
        this.tmpInfo.equipIncs.put(itemLevel, toAdd);
      }
      toAdd.put(key, Integer.valueOf(value));
    }
  }
  
  public void finalizeEquipData(ItemInformation item)
  {
    int itemId = item.itemId;
    
    if (item.equipStats == null)
    {
      item.equipStats = new HashMap<>();
    }
    
    item.template = new EquipTemplate(itemId);
    
    if (item.equipStats.size() > 0)
    {
      for (Map.Entry<String, Integer> stat : item.equipStats.entrySet())
      {
        String key = stat.getKey();
        if (key.equals("STR"))
        {
          item.template.setStr(stat.getValue().shortValue());
        }
        else if (key.equals("DEX"))
        {
          item.template.setDex(stat.getValue().shortValue());
        }
        else if (key.equals("INT"))
        {
          item.template.setInt(stat.getValue().shortValue());
        }
        else if (key.equals("LUK"))
        {
          item.template.setLuk(stat.getValue().shortValue());
        }
        else if (key.equals("PAD"))
        {
          item.template.setWatk(stat.getValue().shortValue());
        }
        else if (key.equals("PDD"))
        {
          item.template.setWdef(stat.getValue().shortValue());
        }
        else if (key.equals("MAD"))
        {
          item.template.setMatk(stat.getValue().shortValue());
        }
        else if (key.equals("MDD"))
        {
          item.template.setMdef(stat.getValue().shortValue());
        }
        else if (key.equals("ACC"))
        {
          item.template.setAccuracy(stat.getValue().shortValue());
        }
        else if (key.equals("EVA"))
        {
          item.template.setAvoid(stat.getValue().shortValue());
        }
        else if (key.equals("Speed"))
        {
          item.template.setMoveMentSpeed(stat.getValue().shortValue());
        }
        else if (key.equals("Jump"))
        {
          item.template.setJump(stat.getValue().shortValue());
        }
        else if (key.equals("MHP"))
        {
          item.template.setHp(stat.getValue().shortValue());
        }
        else if (key.equals("MMP"))
        {
          item.template.setMp(stat.getValue().shortValue());
        }
        else if (key.equals("tuc"))
        {
          item.template.setUpgradeSlots(stat.getValue().byteValue());
        }
        else if (key.equals("Craft"))
        {
          item.template.setCraft(stat.getValue().shortValue());
        }
        else if (key.equals("durability"))
        {
          item.template.setDurability(stat.getValue().intValue());
        }
        else if (key.equals("charmEXP"))
        {
          item.template.setCharmEXP(stat.getValue().shortValue());
        }
        else if (key.equals("PVPDamage"))
        {
          item.template.setPVPDamage(stat.getValue().shortValue());
        }
        else if (key.equals("bdR"))
        {
          item.template.setBossDamage(stat.getValue().shortValue());
        }
        else if (key.equals("imdR"))
        {
          item.template.setIgnorePDR(stat.getValue().shortValue());
        }
        else if (key.equals("attackSpeed"))
        {
          item.template.setAttackSpeed(stat.getValue().intValue());
        }
        else if (key.equals("allStat"))
        {
          item.template.setAllStat((short) stat.getValue().intValue());
        }
        else if (key.equals("reqLevel"))
        {
          item.template.setReqLevel((byte) stat.getValue().intValue());
        }
      }
    }
  }
  
  public void initItemInformation(ResultSet sqlItemData) throws SQLException
  {
    ItemInformation ret = new ItemInformation();
    int itemId = sqlItemData.getInt("itemid");
    ret.itemId = itemId;
    ret.slotMax = (GameConstants.getSlotMax(itemId) > 0) ? GameConstants.getSlotMax(itemId) : sqlItemData.getShort("slotMax");
    ret.price = Double.parseDouble(sqlItemData.getString("price"));
    ret.wholePrice = sqlItemData.getInt("wholePrice");
    ret.stateChange = sqlItemData.getInt("stateChange");
    ret.name = sqlItemData.getString("name");
    ret.desc = sqlItemData.getString("desc");
    ret.msg = sqlItemData.getString("msg");
    ret.flag = sqlItemData.getInt("flags");
    ret.karmaEnabled = sqlItemData.getByte("karma");
    ret.meso = sqlItemData.getInt("meso");
    ret.monsterBook = sqlItemData.getInt("monsterBook");
    ret.itemMakeLevel = sqlItemData.getShort("itemMakeLevel");
    ret.questId = sqlItemData.getInt("questId");
    ret.create = sqlItemData.getInt("create");
    ret.replaceItem = sqlItemData.getInt("replaceId");
    ret.replaceMsg = sqlItemData.getString("replaceMsg");
    ret.afterImage = sqlItemData.getString("afterImage");
    ret.chairType = sqlItemData.getString("chairType");
    ret.nickSkill = sqlItemData.getInt("nickSkill");
    ret.cardSet = 0;
    if (ret.monsterBook > 0 && itemId / 10000 == 238)
    {
      this.mobIds.put(Integer.valueOf(ret.monsterBook), Integer.valueOf(itemId));
      for (Map.Entry<Integer, Triple<Integer, List<Integer>, List<Integer>>> set : this.monsterBookSets.entrySet())
      {
        if (set.getValue().mid.contains(Integer.valueOf(itemId)))
        {
          ret.cardSet = set.getKey().intValue();
          break;
        }
      }
    }
    String scrollRq = sqlItemData.getString("scrollReqs");
    if (scrollRq.length() > 0)
    {
      ret.scrollReqs = new ArrayList<>();
      String[] scroll = scrollRq.split(",");
      for (String s : scroll)
      {
        if (s.length() > 1)
        {
          ret.scrollReqs.add(Integer.valueOf(Integer.parseInt(s)));
        }
      }
    }
    String consumeItem = sqlItemData.getString("consumeItem");
    if (consumeItem.length() > 0)
    {
      ret.questItems = new ArrayList<>();
      String[] scroll = scrollRq.split(",");
      for (String s : scroll)
      {
        if (s.length() > 1)
        {
          ret.questItems.add(Integer.valueOf(Integer.parseInt(s)));
        }
      }
    }
    ret.totalprob = sqlItemData.getInt("totalprob");
    String incRq = sqlItemData.getString("incSkill");
    if (incRq.length() > 0)
    {
      ret.incSkill = new ArrayList<>();
      String[] scroll = incRq.split(",");
      for (String s : scroll)
      {
        if (s.length() > 1)
        {
          ret.incSkill.add(Integer.valueOf(Integer.parseInt(s)));
        }
      }
    }
    this.dataCache.put(Integer.valueOf(itemId), ret);
  }
  
  public final Equip randomizeStats(Equip equip)
  {
    equip.setEnchantStr(getRandStat(equip.getEnchantStr(), 5));
    equip.setEnchantDex(getRandStat(equip.getEnchantDex(), 5));
    equip.setEnchantInt(getRandStat(equip.getEnchantInt(), 5));
    equip.setEnchantLuk(getRandStat(equip.getEnchantLuk(), 5));
    equip.setEnchantMatk(getRandStat(equip.getEnchantMatk(), 5));
    equip.setEnchantWatk(getRandStat(equip.getEnchantWatk(), 5));
    equip.setEnchantAccuracy(getRandStat(equip.getEnchantAccuracy(), 5));
    equip.setEnchantAvoid(getRandStat(equip.getEnchantAvoid(), 5));
    equip.setEnchantJump(getRandStat(equip.getEnchantJump(), 5));
    equip.setEnchantCraft(getRandStat(equip.getEnchantCraft(), 5));
    equip.setEnchantMovementSpeed(getRandStat(equip.getEnchantMovementSpeed(), 5));
    equip.setEnchantWdef(getRandStat(equip.getEnchantWdef(), 10));
    equip.setEnchantMdef(getRandStat(equip.getEnchantMdef(), 10));
    equip.setEnchantHp(getRandStat(equip.getEnchantHp(), 10));
    equip.setEnchantMp(getRandStat(equip.getEnchantMp(), 10));
    return equip;
  }
  
  protected final short getRandStat(short defaultValue, int maxRange)
  {
    if (defaultValue == 0)
    {
      return 0;
    }
    int lMaxRange = (int) Math.min(Math.ceil(defaultValue * 0.1D), maxRange);
    return (short) (defaultValue - lMaxRange + Randomizer.nextInt(lMaxRange * 2 + 1));
  }
}
