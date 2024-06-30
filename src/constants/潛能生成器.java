package constants;

import client.inventory.Equip;
import server.MapleItemInformationProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 潛能生成器
{
  private static final ArrayList<Integer> 添加技能潛能列表 = new ArrayList<>(Arrays.asList(31001, 31002, 31003, 31004, 41005, 41006, 41007));

  private static final ArrayList<Integer> 無視防禦力潛能列表 = new ArrayList<>(Arrays.asList(10291, 20291, 30291, 40292, 40291));

  private static final ArrayList<Integer> BOSS傷害潛能列表 = new ArrayList<>(Arrays.asList(30602, 40601, 40602, 40603));

  private static final ArrayList<Integer> 掉落率潛能列表 = new ArrayList<>(Arrays.asList(40650));

  private static final ArrayList<Integer> 楓幣數量潛能列表 = new ArrayList<>(Arrays.asList(40656));

  private static final ArrayList<Integer> 無視防禦力附加潛能列表 = new ArrayList<>(Arrays.asList(22801, 32291, 42292));

  private static final ArrayList<Integer> BOSS傷害附加潛能列表 = new ArrayList<>(Arrays.asList(32601, 42601));

  private static final ArrayList<Integer> 掉落率附加潛能列表 = new ArrayList<>(Arrays.asList(42650));

  private static final ArrayList<Integer> 楓幣數量附加潛能列表 = new ArrayList<>(Arrays.asList(42656));

  public static MapleItemInformationProvider itemInformationProvider = MapleItemInformationProvider.getInstance();

  public static HashMap<Integer, ArrayList<權重>> 頭盔潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 上衣潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 套服潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 下衣潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 鞋子潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 手套潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 披風潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 心臟潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 護肩潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 腰帶潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 戒指潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 耳環潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 吊墜潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 眼飾潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 臉飾潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 武器潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 副手武器潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 徽章潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 頭盔附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 上衣附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 套服附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 下衣附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 鞋子附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 手套附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 披風附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 心臟附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 護肩附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 腰帶附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 戒指附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 耳環附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 吊墜附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 眼飾附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 臉飾附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 武器附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 副手武器附加潛能權重Map = new HashMap<>();

  public static HashMap<Integer, ArrayList<權重>> 徽章附加潛能權重Map = new HashMap<>();

  public static int 生成潛能 (int 物品Id, int 潛能等級)
  {
    if (潛能等級 < 1 || 潛能等級 > 4)
    {
      return 0;
    }

    if (!GameConstants.isEquip(物品Id))
    {
      return 0;
    }

    if (GameConstants.isHat(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(頭盔潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isTop(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(上衣潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isBottom(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(下衣潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isOverall(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(套服潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isGlove(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(手套潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isShoe(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(鞋子潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isBelt(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(腰帶潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isCape(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(披風潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isShoulder(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(護肩潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isAndroidHeart(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(心臟潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isPendant(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(吊墜潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isRing(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(戒指潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isEarring(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(耳環潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isEyeAccessory(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(眼飾潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isFaceAccessory(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(臉飾潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isWeapon(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(武器潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isSecondaryWeapon(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(副手武器潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isEmblem(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(徽章潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    return 0;
  }

  public static int 生成附加潛能 (int 物品Id, int 潛能等級)
  {
    if (潛能等級 < 1 || 潛能等級 > 4)
    {
      return 0;
    }

    if (!GameConstants.isEquip(物品Id))
    {
      return 0;
    }

    if (GameConstants.isHat(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(頭盔附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isTop(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(上衣附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isBottom(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(下衣附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isOverall(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(套服附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isGlove(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(手套附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isShoe(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(鞋子附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isBelt(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(腰帶附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isCape(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(披風附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isShoulder(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(護肩附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isAndroidHeart(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(心臟附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isPendant(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(吊墜附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isRing(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(戒指附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isEarring(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(耳環附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isEyeAccessory(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(眼飾附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isFaceAccessory(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(臉飾附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isWeapon(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(武器附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isSecondaryWeapon(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(副手武器附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    else if (GameConstants.isEmblem(物品Id))
    {
      權重 計算結果 = 權重算法.計算權重(徽章附加潛能權重Map.get(潛能等級));
      return 計算結果.獲取值();
    }
    return 0;
  }

  private static void 加載頭盔潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 600));
    等級1潛能權重.add(new 權重(10002, 600));
    等級1潛能權重.add(new 權重(10003, 600));
    等級1潛能權重.add(new 權重(10004, 600));
    等級1潛能權重.add(new 權重(10005, 1000));
    等級1潛能權重.add(new 權重(10006, 1000));
    等級1潛能權重.add(new 權重(10013, 800));
    等級1潛能權重.add(new 權重(10041, 600));
    等級1潛能權重.add(new 權重(10042, 600));
    等級1潛能權重.add(new 權重(10043, 600));
    等級1潛能權重.add(new 權重(10044, 600));
    等級1潛能權重.add(new 權重(10045, 600));
    等級1潛能權重.add(new 權重(10046, 600));
    等級1潛能權重.add(new 權重(10053, 800));
    等級1潛能權重.add(new 權重(10081, 400));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(31002, 635));
    等級3潛能權重.add(new 權重(30041, 794));
    等級3潛能權重.add(new 權重(30042, 794));
    等級3潛能權重.add(new 權重(30043, 794));
    等級3潛能權重.add(new 權重(30044, 794));
    等級3潛能權重.add(new 權重(30045, 952));
    等級3潛能權重.add(new 權重(30046, 952));
    等級3潛能權重.add(new 權重(30053, 1587));
    等級3潛能權重.add(new 權重(30086, 635));
    等級3潛能權重.add(new 權重(30356, 635));
    等級3潛能權重.add(new 權重(30357, 635));
    等級3潛能權重.add(new 權重(30551, 794));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40556, 566));
    等級4潛能權重.add(new 權重(40557, 377));
    等級4潛能權重.add(new 權重(41006, 566));
    等級4潛能權重.add(new 權重(40041, 755));
    等級4潛能權重.add(new 權重(40042, 755));
    等級4潛能權重.add(new 權重(40043, 755));
    等級4潛能權重.add(new 權重(40044, 755));
    等級4潛能權重.add(new 權重(40045, 755));
    等級4潛能權重.add(new 權重(40046, 755));
    等級4潛能權重.add(new 權重(40053, 1887));
    等級4潛能權重.add(new 權重(40086, 566));
    等級4潛能權重.add(new 權重(40356, 755));
    等級4潛能權重.add(new 權重(40357, 755));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));


    頭盔潛能權重Map.put(1, 等級1潛能權重);

    頭盔潛能權重Map.put(2, 等級2潛能權重);

    頭盔潛能權重Map.put(3, 等級3潛能權重);

    頭盔潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 頭盔潛能權重Map.keySet())
    {
      for (權重 權重數據 : 頭盔潛能權重Map.get(key))
      {
        System.out.println("加載頭盔的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載上衣潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 600));
    等級1潛能權重.add(new 權重(10002, 600));
    等級1潛能權重.add(new 權重(10003, 600));
    等級1潛能權重.add(new 權重(10004, 600));
    等級1潛能權重.add(new 權重(10005, 1000));
    等級1潛能權重.add(new 權重(10006, 1000));
    等級1潛能權重.add(new 權重(10013, 800));
    等級1潛能權重.add(new 權重(10041, 600));
    等級1潛能權重.add(new 權重(10042, 600));
    等級1潛能權重.add(new 權重(10043, 600));
    等級1潛能權重.add(new 權重(10044, 600));
    等級1潛能權重.add(new 權重(10045, 600));
    等級1潛能權重.add(new 權重(10046, 600));
    等級1潛能權重.add(new 權重(10053, 800));
    等級1潛能權重.add(new 權重(10081, 400));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20366, 625));
    等級2潛能權重.add(new 權重(20396, 625));
    等級2潛能權重.add(new 權重(20041, 1042));
    等級2潛能權重.add(new 權重(20042, 1042));
    等級2潛能權重.add(new 權重(20043, 1042));
    等級2潛能權重.add(new 權重(20044, 1042));
    等級2潛能權重.add(new 權重(20045, 1458));
    等級2潛能權重.add(new 權重(20046, 1458));
    等級2潛能權重.add(new 權重(20053, 1250));
    等級2潛能權重.add(new 權重(20086, 417));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30366, 548));
    等級3潛能權重.add(new 權重(30371, 548));
    等級3潛能權重.add(new 權重(30376, 548));
    等級3潛能權重.add(new 權重(30377, 274));
    等級3潛能權重.add(new 權重(30041, 685));
    等級3潛能權重.add(new 權重(30042, 685));
    等級3潛能權重.add(new 權重(30043, 685));
    等級3潛能權重.add(new 權重(30044, 685));
    等級3潛能權重.add(new 權重(30045, 822));
    等級3潛能權重.add(new 權重(30046, 822));
    等級3潛能權重.add(new 權重(30053, 1370));
    等級3潛能權重.add(new 權重(30086, 548));
    等級3潛能權重.add(new 權重(30356, 548));
    等級3潛能權重.add(new 權重(30357, 548));
    等級3潛能權重.add(new 權重(30551, 685));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40366, 588));
    等級4潛能權重.add(new 權重(40371, 588));
    等級4潛能權重.add(new 權重(40041, 784));
    等級4潛能權重.add(new 權重(40042, 784));
    等級4潛能權重.add(new 權重(40043, 784));
    等級4潛能權重.add(new 權重(40044, 784));
    等級4潛能權重.add(new 權重(40045, 784));
    等級4潛能權重.add(new 權重(40046, 784));
    等級4潛能權重.add(new 權重(40053, 1961));
    等級4潛能權重.add(new 權重(40086, 588));
    等級4潛能權重.add(new 權重(40356, 784));
    等級4潛能權重.add(new 權重(40357, 784));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    上衣潛能權重Map.put(1, 等級1潛能權重);

    上衣潛能權重Map.put(2, 等級2潛能權重);

    上衣潛能權重Map.put(3, 等級3潛能權重);

    上衣潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 上衣潛能權重Map.keySet())
    {
      for (權重 權重數據 : 上衣潛能權重Map.get(key))
      {
        System.out.println("加載上衣的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載下衣潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 600));
    等級1潛能權重.add(new 權重(10002, 600));
    等級1潛能權重.add(new 權重(10003, 600));
    等級1潛能權重.add(new 權重(10004, 600));
    等級1潛能權重.add(new 權重(10005, 1000));
    等級1潛能權重.add(new 權重(10006, 1000));
    等級1潛能權重.add(new 權重(10013, 800));
    等級1潛能權重.add(new 權重(10041, 600));
    等級1潛能權重.add(new 權重(10042, 600));
    等級1潛能權重.add(new 權重(10043, 600));
    等級1潛能權重.add(new 權重(10044, 600));
    等級1潛能權重.add(new 權重(10045, 600));
    等級1潛能權重.add(new 權重(10046, 600));
    等級1潛能權重.add(new 權重(10053, 800));
    等級1潛能權重.add(new 權重(10081, 400));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(31004, 635));
    等級3潛能權重.add(new 權重(30041, 794));
    等級3潛能權重.add(new 權重(30042, 794));
    等級3潛能權重.add(new 權重(30043, 794));
    等級3潛能權重.add(new 權重(30044, 794));
    等級3潛能權重.add(new 權重(30045, 952));
    等級3潛能權重.add(new 權重(30046, 952));
    等級3潛能權重.add(new 權重(30053, 1270));
    等級3潛能權重.add(new 權重(30086, 635));
    等級3潛能權重.add(new 權重(30356, 794));
    等級3潛能權重.add(new 權重(30357, 794));
    等級3潛能權重.add(new 權重(30551, 794));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40041, 889));
    等級4潛能權重.add(new 權重(40042, 889));
    等級4潛能權重.add(new 權重(40043, 889));
    等級4潛能權重.add(new 權重(40044, 889));
    等級4潛能權重.add(new 權重(40045, 889));
    等級4潛能權重.add(new 權重(40046, 889));
    等級4潛能權重.add(new 權重(40053, 2222));
    等級4潛能權重.add(new 權重(40086, 667));
    等級4潛能權重.add(new 權重(40356, 889));
    等級4潛能權重.add(new 權重(40357, 889));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    下衣潛能權重Map.put(1, 等級1潛能權重);

    下衣潛能權重Map.put(2, 等級2潛能權重);

    下衣潛能權重Map.put(3, 等級3潛能權重);

    下衣潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 下衣潛能權重Map.keySet())
    {
      for (權重 權重數據 : 下衣潛能權重Map.get(key))
      {
        System.out.println("加載下衣的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載套服潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 600));
    等級1潛能權重.add(new 權重(10002, 600));
    等級1潛能權重.add(new 權重(10003, 600));
    等級1潛能權重.add(new 權重(10004, 600));
    等級1潛能權重.add(new 權重(10005, 1000));
    等級1潛能權重.add(new 權重(10006, 1000));
    等級1潛能權重.add(new 權重(10013, 800));
    等級1潛能權重.add(new 權重(10041, 600));
    等級1潛能權重.add(new 權重(10042, 600));
    等級1潛能權重.add(new 權重(10043, 600));
    等級1潛能權重.add(new 權重(10044, 600));
    等級1潛能權重.add(new 權重(10045, 600));
    等級1潛能權重.add(new 權重(10046, 600));
    等級1潛能權重.add(new 權重(10053, 800));
    等級1潛能權重.add(new 權重(10081, 400));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20366, 625));
    等級2潛能權重.add(new 權重(20396, 625));
    等級2潛能權重.add(new 權重(20041, 1042));
    等級2潛能權重.add(new 權重(20042, 1042));
    等級2潛能權重.add(new 權重(20043, 1042));
    等級2潛能權重.add(new 權重(20044, 1042));
    等級2潛能權重.add(new 權重(20045, 1458));
    等級2潛能權重.add(new 權重(20046, 1458));
    等級2潛能權重.add(new 權重(20053, 1250));
    等級2潛能權重.add(new 權重(20086, 417));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30366, 548));
    等級3潛能權重.add(new 權重(30371, 548));
    等級3潛能權重.add(new 權重(30376, 548));
    等級3潛能權重.add(new 權重(30377, 274));
    等級3潛能權重.add(new 權重(30041, 685));
    等級3潛能權重.add(new 權重(30042, 685));
    等級3潛能權重.add(new 權重(30043, 685));
    等級3潛能權重.add(new 權重(30044, 685));
    等級3潛能權重.add(new 權重(30045, 822));
    等級3潛能權重.add(new 權重(30046, 822));
    等級3潛能權重.add(new 權重(30053, 1370));
    等級3潛能權重.add(new 權重(30086, 548));
    等級3潛能權重.add(new 權重(30356, 548));
    等級3潛能權重.add(new 權重(30357, 548));
    等級3潛能權重.add(new 權重(30551, 685));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40366, 588));
    等級4潛能權重.add(new 權重(40371, 588));
    等級4潛能權重.add(new 權重(40041, 784));
    等級4潛能權重.add(new 權重(40042, 784));
    等級4潛能權重.add(new 權重(40043, 784));
    等級4潛能權重.add(new 權重(40044, 784));
    等級4潛能權重.add(new 權重(40045, 784));
    等級4潛能權重.add(new 權重(40046, 784));
    等級4潛能權重.add(new 權重(40053, 1961));
    等級4潛能權重.add(new 權重(40086, 588));
    等級4潛能權重.add(new 權重(40356, 784));
    等級4潛能權重.add(new 權重(40357, 784));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));


    套服潛能權重Map.put(1, 等級1潛能權重);

    套服潛能權重Map.put(2, 等級2潛能權重);

    套服潛能權重Map.put(3, 等級3潛能權重);

    套服潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 套服潛能權重Map.keySet())
    {
      for (權重 權重數據 : 套服潛能權重Map.get(key))
      {
        System.out.println("加載套服的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載鞋子潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10009, 370));
    等級1潛能權重.add(new 權重(10010, 370));
    等級1潛能權重.add(new 權重(10001, 556));
    等級1潛能權重.add(new 權重(10002, 556));
    等級1潛能權重.add(new 權重(10003, 556));
    等級1潛能權重.add(new 權重(10004, 556));
    等級1潛能權重.add(new 權重(10005, 925));
    等級1潛能權重.add(new 權重(10006, 925));
    等級1潛能權重.add(new 權重(10013, 740));
    等級1潛能權重.add(new 權重(10041, 556));
    等級1潛能權重.add(new 權重(10042, 556));
    等級1潛能權重.add(new 權重(10043, 556));
    等級1潛能權重.add(new 權重(10044, 556));
    等級1潛能權重.add(new 權重(10045, 556));
    等級1潛能權重.add(new 權重(10046, 556));
    等級1潛能權重.add(new 權重(10053, 740));
    等級1潛能權重.add(new 權重(10081, 370));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(31001, 635));
    等級3潛能權重.add(new 權重(30041, 794));
    等級3潛能權重.add(new 權重(30042, 794));
    等級3潛能權重.add(new 權重(30043, 794));
    等級3潛能權重.add(new 權重(30044, 794));
    等級3潛能權重.add(new 權重(30045, 952));
    等級3潛能權重.add(new 權重(30046, 952));
    等級3潛能權重.add(new 權重(30053, 1587));
    等級3潛能權重.add(new 權重(30086, 635));
    等級3潛能權重.add(new 權重(30356, 635));
    等級3潛能權重.add(new 權重(30357, 635));
    等級3潛能權重.add(new 權重(30551, 794));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(41005, 625));
    等級4潛能權重.add(new 權重(40041, 833));
    等級4潛能權重.add(new 權重(40042, 833));
    等級4潛能權重.add(new 權重(40043, 833));
    等級4潛能權重.add(new 權重(40044, 833));
    等級4潛能權重.add(new 權重(40045, 833));
    等級4潛能權重.add(new 權重(40046, 833));
    等級4潛能權重.add(new 權重(40053, 2083));
    等級4潛能權重.add(new 權重(40086, 625));
    等級4潛能權重.add(new 權重(40356, 833));
    等級4潛能權重.add(new 權重(40357, 833));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    鞋子潛能權重Map.put(1, 等級1潛能權重);

    鞋子潛能權重Map.put(2, 等級2潛能權重);

    鞋子潛能權重Map.put(3, 等級3潛能權重);

    鞋子潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 鞋子潛能權重Map.keySet())
    {
      for (權重 權重數據 : 鞋子潛能權重Map.get(key))
      {
        System.out.println("加載鞋子的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載手套潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10009, 370));
    等級1潛能權重.add(new 權重(10010, 370));
    等級1潛能權重.add(new 權重(10001, 556));
    等級1潛能權重.add(new 權重(10002, 556));
    等級1潛能權重.add(new 權重(10003, 556));
    等級1潛能權重.add(new 權重(10004, 556));
    等級1潛能權重.add(new 權重(10005, 925));
    等級1潛能權重.add(new 權重(10006, 925));
    等級1潛能權重.add(new 權重(10013, 740));
    等級1潛能權重.add(new 權重(10041, 556));
    等級1潛能權重.add(new 權重(10042, 556));
    等級1潛能權重.add(new 權重(10043, 556));
    等級1潛能權重.add(new 權重(10044, 556));
    等級1潛能權重.add(new 權重(10045, 556));
    等級1潛能權重.add(new 權重(10046, 556));
    等級1潛能權重.add(new 權重(10053, 740));
    等級1潛能權重.add(new 權重(10081, 370));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20401, 625));
    等級2潛能權重.add(new 權重(20406, 625));
    等級2潛能權重.add(new 權重(20041, 1042));
    等級2潛能權重.add(new 權重(20042, 1042));
    等級2潛能權重.add(new 權重(20043, 1042));
    等級2潛能權重.add(new 權重(20044, 1042));
    等級2潛能權重.add(new 權重(20045, 1458));
    等級2潛能權重.add(new 權重(20046, 1458));
    等級2潛能權重.add(new 權重(20053, 1250));
    等級2潛能權重.add(new 權重(20086, 417));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();


    等級3潛能權重.add(new 權重(30091, 149));
    等級3潛能權重.add(new 權重(30092, 149));
    等級3潛能權重.add(new 權重(30093, 149));
    等級3潛能權重.add(new 權重(30094, 149));
    等級3潛能權重.add(new 權重(31003, 597));
    等級3潛能權重.add(new 權重(30041, 746));
    等級3潛能權重.add(new 權重(30042, 746));
    等級3潛能權重.add(new 權重(30043, 746));
    等級3潛能權重.add(new 權重(30044, 746));
    等級3潛能權重.add(new 權重(30045, 896));
    等級3潛能權重.add(new 權重(30046, 896));
    等級3潛能權重.add(new 權重(30053, 1493));
    等級3潛能權重.add(new 權重(30086, 597));
    等級3潛能權重.add(new 權重(30356, 597));
    等級3潛能權重.add(new 權重(30357, 597));
    等級3潛能權重.add(new 權重(30551, 746));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40057, 769));
    等級4潛能權重.add(new 權重(41007, 577));
    等級4潛能權重.add(new 權重(40041, 769));
    等級4潛能權重.add(new 權重(40042, 769));
    等級4潛能權重.add(new 權重(40043, 769));
    等級4潛能權重.add(new 權重(40044, 769));
    等級4潛能權重.add(new 權重(40045, 769));
    等級4潛能權重.add(new 權重(40046, 769));
    等級4潛能權重.add(new 權重(40053, 1923));
    等級4潛能權重.add(new 權重(40086, 577));
    等級4潛能權重.add(new 權重(40356, 769));
    等級4潛能權重.add(new 權重(40357, 769));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    手套潛能權重Map.put(1, 等級1潛能權重);

    手套潛能權重Map.put(2, 等級2潛能權重);

    手套潛能權重Map.put(3, 等級3潛能權重);

    手套潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 手套潛能權重Map.keySet())
    {
      for (權重 權重數據 : 手套潛能權重Map.get(key))
      {
        System.out.println("加載手套的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載披風潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10009, 370));
    等級1潛能權重.add(new 權重(10010, 370));
    等級1潛能權重.add(new 權重(10001, 556));
    等級1潛能權重.add(new 權重(10002, 556));
    等級1潛能權重.add(new 權重(10003, 556));
    等級1潛能權重.add(new 權重(10004, 556));
    等級1潛能權重.add(new 權重(10005, 925));
    等級1潛能權重.add(new 權重(10006, 925));
    等級1潛能權重.add(new 權重(10013, 740));
    等級1潛能權重.add(new 權重(10041, 556));
    等級1潛能權重.add(new 權重(10042, 556));
    等級1潛能權重.add(new 權重(10043, 556));
    等級1潛能權重.add(new 權重(10044, 556));
    等級1潛能權重.add(new 權重(10045, 556));
    等級1潛能權重.add(new 權重(10046, 556));
    等級1潛能權重.add(new 權重(10053, 740));
    等級1潛能權重.add(new 權重(10081, 370));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30041, 847));
    等級3潛能權重.add(new 權重(30042, 847));
    等級3潛能權重.add(new 權重(30043, 847));
    等級3潛能權重.add(new 權重(30044, 847));
    等級3潛能權重.add(new 權重(30045, 1017));
    等級3潛能權重.add(new 權重(30046, 1017));
    等級3潛能權重.add(new 權重(30053, 1695));
    等級3潛能權重.add(new 權重(30086, 678));
    等級3潛能權重.add(new 權重(30356, 678));
    等級3潛能權重.add(new 權重(30357, 678));
    等級3潛能權重.add(new 權重(30551, 847));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40041, 889));
    等級4潛能權重.add(new 權重(40042, 889));
    等級4潛能權重.add(new 權重(40043, 889));
    等級4潛能權重.add(new 權重(40044, 889));
    等級4潛能權重.add(new 權重(40045, 889));
    等級4潛能權重.add(new 權重(40046, 889));
    等級4潛能權重.add(new 權重(40053, 2222));
    等級4潛能權重.add(new 權重(40086, 667));
    等級4潛能權重.add(new 權重(40356, 889));
    等級4潛能權重.add(new 權重(40357, 889));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    披風潛能權重Map.put(1, 等級1潛能權重);

    披風潛能權重Map.put(2, 等級2潛能權重);

    披風潛能權重Map.put(3, 等級3潛能權重);

    披風潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 披風潛能權重Map.keySet())
    {
      for (權重 權重數據 : 披風潛能權重Map.get(key))
      {
        System.out.println("加載披風的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載心臟潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10009, 370));
    等級1潛能權重.add(new 權重(10010, 370));
    等級1潛能權重.add(new 權重(10001, 556));
    等級1潛能權重.add(new 權重(10002, 556));
    等級1潛能權重.add(new 權重(10003, 556));
    等級1潛能權重.add(new 權重(10004, 556));
    等級1潛能權重.add(new 權重(10005, 925));
    等級1潛能權重.add(new 權重(10006, 925));
    等級1潛能權重.add(new 權重(10013, 740));
    等級1潛能權重.add(new 權重(10041, 556));
    等級1潛能權重.add(new 權重(10042, 556));
    等級1潛能權重.add(new 權重(10043, 556));
    等級1潛能權重.add(new 權重(10044, 556));
    等級1潛能權重.add(new 權重(10045, 556));
    等級1潛能權重.add(new 權重(10046, 556));
    等級1潛能權重.add(new 權重(10053, 740));
    等級1潛能權重.add(new 權重(10081, 370));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30041, 847));
    等級3潛能權重.add(new 權重(30042, 847));
    等級3潛能權重.add(new 權重(30043, 847));
    等級3潛能權重.add(new 權重(30044, 847));
    等級3潛能權重.add(new 權重(30045, 1017));
    等級3潛能權重.add(new 權重(30046, 1017));
    等級3潛能權重.add(new 權重(30053, 1695));
    等級3潛能權重.add(new 權重(30086, 678));
    等級3潛能權重.add(new 權重(30356, 678));
    等級3潛能權重.add(new 權重(30357, 678));
    等級3潛能權重.add(new 權重(30551, 847));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40041, 889));
    等級4潛能權重.add(new 權重(40042, 889));
    等級4潛能權重.add(new 權重(40043, 889));
    等級4潛能權重.add(new 權重(40044, 889));
    等級4潛能權重.add(new 權重(40045, 889));
    等級4潛能權重.add(new 權重(40046, 889));
    等級4潛能權重.add(new 權重(40053, 2222));
    等級4潛能權重.add(new 權重(40086, 667));
    等級4潛能權重.add(new 權重(40356, 889));
    等級4潛能權重.add(new 權重(40357, 889));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    心臟潛能權重Map.put(1, 等級1潛能權重);

    心臟潛能權重Map.put(2, 等級2潛能權重);

    心臟潛能權重Map.put(3, 等級3潛能權重);

    心臟潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 心臟潛能權重Map.keySet())
    {
      for (權重 權重數據 : 心臟潛能權重Map.get(key))
      {
        System.out.println("加載心臟的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載護肩潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10009, 370));
    等級1潛能權重.add(new 權重(10010, 370));
    等級1潛能權重.add(new 權重(10001, 556));
    等級1潛能權重.add(new 權重(10002, 556));
    等級1潛能權重.add(new 權重(10003, 556));
    等級1潛能權重.add(new 權重(10004, 556));
    等級1潛能權重.add(new 權重(10005, 925));
    等級1潛能權重.add(new 權重(10006, 925));
    等級1潛能權重.add(new 權重(10013, 740));
    等級1潛能權重.add(new 權重(10041, 556));
    等級1潛能權重.add(new 權重(10042, 556));
    等級1潛能權重.add(new 權重(10043, 556));
    等級1潛能權重.add(new 權重(10044, 556));
    等級1潛能權重.add(new 權重(10045, 556));
    等級1潛能權重.add(new 權重(10046, 556));
    等級1潛能權重.add(new 權重(10053, 740));
    等級1潛能權重.add(new 權重(10081, 370));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30041, 847));
    等級3潛能權重.add(new 權重(30042, 847));
    等級3潛能權重.add(new 權重(30043, 847));
    等級3潛能權重.add(new 權重(30044, 847));
    等級3潛能權重.add(new 權重(30045, 1017));
    等級3潛能權重.add(new 權重(30046, 1017));
    等級3潛能權重.add(new 權重(30053, 1695));
    等級3潛能權重.add(new 權重(30086, 678));
    等級3潛能權重.add(new 權重(30356, 678));
    等級3潛能權重.add(new 權重(30357, 678));
    等級3潛能權重.add(new 權重(30551, 847));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40041, 889));
    等級4潛能權重.add(new 權重(40042, 889));
    等級4潛能權重.add(new 權重(40043, 889));
    等級4潛能權重.add(new 權重(40044, 889));
    等級4潛能權重.add(new 權重(40045, 889));
    等級4潛能權重.add(new 權重(40046, 889));
    等級4潛能權重.add(new 權重(40053, 2222));
    等級4潛能權重.add(new 權重(40086, 667));
    等級4潛能權重.add(new 權重(40356, 889));
    等級4潛能權重.add(new 權重(40357, 889));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    護肩潛能權重Map.put(1, 等級1潛能權重);

    護肩潛能權重Map.put(2, 等級2潛能權重);

    護肩潛能權重Map.put(3, 等級3潛能權重);

    護肩潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 護肩潛能權重Map.keySet())
    {
      for (權重 權重數據 : 護肩潛能權重Map.get(key))
      {
        System.out.println("加載護肩的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載腰帶潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10009, 370));
    等級1潛能權重.add(new 權重(10010, 370));
    等級1潛能權重.add(new 權重(10001, 556));
    等級1潛能權重.add(new 權重(10002, 556));
    等級1潛能權重.add(new 權重(10003, 556));
    等級1潛能權重.add(new 權重(10004, 556));
    等級1潛能權重.add(new 權重(10005, 925));
    等級1潛能權重.add(new 權重(10006, 925));
    等級1潛能權重.add(new 權重(10013, 740));
    等級1潛能權重.add(new 權重(10041, 556));
    等級1潛能權重.add(new 權重(10042, 556));
    等級1潛能權重.add(new 權重(10043, 556));
    等級1潛能權重.add(new 權重(10044, 556));
    等級1潛能權重.add(new 權重(10045, 556));
    等級1潛能權重.add(new 權重(10046, 556));
    等級1潛能權重.add(new 權重(10053, 740));
    等級1潛能權重.add(new 權重(10081, 370));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30041, 847));
    等級3潛能權重.add(new 權重(30042, 847));
    等級3潛能權重.add(new 權重(30043, 847));
    等級3潛能權重.add(new 權重(30044, 847));
    等級3潛能權重.add(new 權重(30045, 1017));
    等級3潛能權重.add(new 權重(30046, 1017));
    等級3潛能權重.add(new 權重(30053, 1695));
    等級3潛能權重.add(new 權重(30086, 678));
    等級3潛能權重.add(new 權重(30356, 678));
    等級3潛能權重.add(new 權重(30357, 678));
    等級3潛能權重.add(new 權重(30551, 847));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40041, 889));
    等級4潛能權重.add(new 權重(40042, 889));
    等級4潛能權重.add(new 權重(40043, 889));
    等級4潛能權重.add(new 權重(40044, 889));
    等級4潛能權重.add(new 權重(40045, 889));
    等級4潛能權重.add(new 權重(40046, 889));
    等級4潛能權重.add(new 權重(40053, 2222));
    等級4潛能權重.add(new 權重(40086, 667));
    等級4潛能權重.add(new 權重(40356, 889));
    等級4潛能權重.add(new 權重(40357, 889));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    腰帶潛能權重Map.put(1, 等級1潛能權重);

    腰帶潛能權重Map.put(2, 等級2潛能權重);

    腰帶潛能權重Map.put(3, 等級3潛能權重);

    腰帶潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 腰帶潛能權重Map.keySet())
    {
      for (權重 權重數據 : 腰帶潛能權重Map.get(key))
      {
        System.out.println("加載腰帶的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載戒指潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 600));
    等級1潛能權重.add(new 權重(10002, 600));
    等級1潛能權重.add(new 權重(10003, 600));
    等級1潛能權重.add(new 權重(10004, 600));
    等級1潛能權重.add(new 權重(10005, 1000));
    等級1潛能權重.add(new 權重(10006, 1000));
    等級1潛能權重.add(new 權重(10013, 800));
    等級1潛能權重.add(new 權重(10041, 600));
    等級1潛能權重.add(new 權重(10042, 600));
    等級1潛能權重.add(new 權重(10043, 600));
    等級1潛能權重.add(new 權重(10044, 600));
    等級1潛能權重.add(new 權重(10045, 600));
    等級1潛能權重.add(new 權重(10046, 600));
    等級1潛能權重.add(new 權重(10053, 800));
    等級1潛能權重.add(new 權重(10081, 400));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30041, 980));
    等級3潛能權重.add(new 權重(30042, 980));
    等級3潛能權重.add(new 權重(30043, 980));
    等級3潛能權重.add(new 權重(30044, 980));
    等級3潛能權重.add(new 權重(30045, 1176));
    等級3潛能權重.add(new 權重(30046, 1176));
    等級3潛能權重.add(new 權重(30053, 1961));
    等級3潛能權重.add(new 權重(30086, 784));
    等級3潛能權重.add(new 權重(30551, 980));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40041, 784));
    等級4潛能權重.add(new 權重(40042, 784));
    等級4潛能權重.add(new 權重(40043, 784));
    等級4潛能權重.add(new 權重(40044, 784));
    等級4潛能權重.add(new 權重(40045, 784));
    等級4潛能權重.add(new 權重(40046, 784));
    等級4潛能權重.add(new 權重(40053, 1961));
    等級4潛能權重.add(new 權重(40086, 588));
    等級4潛能權重.add(new 權重(40501, 784));
    等級4潛能權重.add(new 權重(40502, 784));
    等級4潛能權重.add(new 權重(40650, 588));
    等級4潛能權重.add(new 權重(40656, 588));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    戒指潛能權重Map.put(1, 等級1潛能權重);

    戒指潛能權重Map.put(2, 等級2潛能權重);

    戒指潛能權重Map.put(3, 等級3潛能權重);

    戒指潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 戒指潛能權重Map.keySet())
    {
      for (權重 權重數據 : 戒指潛能權重Map.get(key))
      {
        System.out.println("加載戒指的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載耳環潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 600));
    等級1潛能權重.add(new 權重(10002, 600));
    等級1潛能權重.add(new 權重(10003, 600));
    等級1潛能權重.add(new 權重(10004, 600));
    等級1潛能權重.add(new 權重(10005, 1000));
    等級1潛能權重.add(new 權重(10006, 1000));
    等級1潛能權重.add(new 權重(10013, 800));
    等級1潛能權重.add(new 權重(10041, 600));
    等級1潛能權重.add(new 權重(10042, 600));
    等級1潛能權重.add(new 權重(10043, 600));
    等級1潛能權重.add(new 權重(10044, 600));
    等級1潛能權重.add(new 權重(10045, 600));
    等級1潛能權重.add(new 權重(10046, 600));
    等級1潛能權重.add(new 權重(10053, 800));
    等級1潛能權重.add(new 權重(10081, 400));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30041, 980));
    等級3潛能權重.add(new 權重(30042, 980));
    等級3潛能權重.add(new 權重(30043, 980));
    等級3潛能權重.add(new 權重(30044, 980));
    等級3潛能權重.add(new 權重(30045, 1176));
    等級3潛能權重.add(new 權重(30046, 1176));
    等級3潛能權重.add(new 權重(30053, 1961));
    等級3潛能權重.add(new 權重(30086, 784));
    等級3潛能權重.add(new 權重(30551, 980));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40041, 784));
    等級4潛能權重.add(new 權重(40042, 784));
    等級4潛能權重.add(new 權重(40043, 784));
    等級4潛能權重.add(new 權重(40044, 784));
    等級4潛能權重.add(new 權重(40045, 784));
    等級4潛能權重.add(new 權重(40046, 784));
    等級4潛能權重.add(new 權重(40053, 1961));
    等級4潛能權重.add(new 權重(40086, 588));
    等級4潛能權重.add(new 權重(40501, 784));
    等級4潛能權重.add(new 權重(40502, 784));
    等級4潛能權重.add(new 權重(40650, 588));
    等級4潛能權重.add(new 權重(40656, 588));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    耳環潛能權重Map.put(1, 等級1潛能權重);

    耳環潛能權重Map.put(2, 等級2潛能權重);

    耳環潛能權重Map.put(3, 等級3潛能權重);

    耳環潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 耳環潛能權重Map.keySet())
    {
      for (權重 權重數據 : 耳環潛能權重Map.get(key))
      {
        System.out.println("加載耳環的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載吊墜潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 600));
    等級1潛能權重.add(new 權重(10002, 600));
    等級1潛能權重.add(new 權重(10003, 600));
    等級1潛能權重.add(new 權重(10004, 600));
    等級1潛能權重.add(new 權重(10005, 1000));
    等級1潛能權重.add(new 權重(10006, 1000));
    等級1潛能權重.add(new 權重(10013, 800));
    等級1潛能權重.add(new 權重(10041, 600));
    等級1潛能權重.add(new 權重(10042, 600));
    等級1潛能權重.add(new 權重(10043, 600));
    等級1潛能權重.add(new 權重(10044, 600));
    等級1潛能權重.add(new 權重(10045, 600));
    等級1潛能權重.add(new 權重(10046, 600));
    等級1潛能權重.add(new 權重(10053, 800));
    等級1潛能權重.add(new 權重(10081, 400));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30041, 980));
    等級3潛能權重.add(new 權重(30042, 980));
    等級3潛能權重.add(new 權重(30043, 980));
    等級3潛能權重.add(new 權重(30044, 980));
    等級3潛能權重.add(new 權重(30045, 1176));
    等級3潛能權重.add(new 權重(30046, 1176));
    等級3潛能權重.add(new 權重(30053, 1961));
    等級3潛能權重.add(new 權重(30086, 784));
    等級3潛能權重.add(new 權重(30551, 980));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40041, 784));
    等級4潛能權重.add(new 權重(40042, 784));
    等級4潛能權重.add(new 權重(40043, 784));
    等級4潛能權重.add(new 權重(40044, 784));
    等級4潛能權重.add(new 權重(40045, 784));
    等級4潛能權重.add(new 權重(40046, 784));
    等級4潛能權重.add(new 權重(40053, 1961));
    等級4潛能權重.add(new 權重(40086, 588));
    等級4潛能權重.add(new 權重(40501, 784));
    等級4潛能權重.add(new 權重(40502, 784));
    等級4潛能權重.add(new 權重(40650, 588));
    等級4潛能權重.add(new 權重(40656, 588));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    吊墜潛能權重Map.put(1, 等級1潛能權重);

    吊墜潛能權重Map.put(2, 等級2潛能權重);

    吊墜潛能權重Map.put(3, 等級3潛能權重);

    吊墜潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 吊墜潛能權重Map.keySet())
    {
      for (權重 權重數據 : 吊墜潛能權重Map.get(key))
      {
        System.out.println("加載吊墜的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載眼飾潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 600));
    等級1潛能權重.add(new 權重(10002, 600));
    等級1潛能權重.add(new 權重(10003, 600));
    等級1潛能權重.add(new 權重(10004, 600));
    等級1潛能權重.add(new 權重(10005, 1000));
    等級1潛能權重.add(new 權重(10006, 1000));
    等級1潛能權重.add(new 權重(10013, 800));
    等級1潛能權重.add(new 權重(10041, 600));
    等級1潛能權重.add(new 權重(10042, 600));
    等級1潛能權重.add(new 權重(10043, 600));
    等級1潛能權重.add(new 權重(10044, 600));
    等級1潛能權重.add(new 權重(10045, 600));
    等級1潛能權重.add(new 權重(10046, 600));
    等級1潛能權重.add(new 權重(10053, 800));
    等級1潛能權重.add(new 權重(10081, 400));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30041, 980));
    等級3潛能權重.add(new 權重(30042, 980));
    等級3潛能權重.add(new 權重(30043, 980));
    等級3潛能權重.add(new 權重(30044, 980));
    等級3潛能權重.add(new 權重(30045, 1176));
    等級3潛能權重.add(new 權重(30046, 1176));
    等級3潛能權重.add(new 權重(30053, 1961));
    等級3潛能權重.add(new 權重(30086, 784));
    等級3潛能權重.add(new 權重(30551, 980));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40041, 784));
    等級4潛能權重.add(new 權重(40042, 784));
    等級4潛能權重.add(new 權重(40043, 784));
    等級4潛能權重.add(new 權重(40044, 784));
    等級4潛能權重.add(new 權重(40045, 784));
    等級4潛能權重.add(new 權重(40046, 784));
    等級4潛能權重.add(new 權重(40053, 1961));
    等級4潛能權重.add(new 權重(40086, 588));
    等級4潛能權重.add(new 權重(40501, 784));
    等級4潛能權重.add(new 權重(40502, 784));
    等級4潛能權重.add(new 權重(40650, 588));
    等級4潛能權重.add(new 權重(40656, 588));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    眼飾潛能權重Map.put(1, 等級1潛能權重);

    眼飾潛能權重Map.put(2, 等級2潛能權重);

    眼飾潛能權重Map.put(3, 等級3潛能權重);

    眼飾潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 眼飾潛能權重Map.keySet())
    {
      for (權重 權重數據 : 眼飾潛能權重Map.get(key))
      {
        System.out.println("加載眼飾的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載臉飾潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 600));
    等級1潛能權重.add(new 權重(10002, 600));
    等級1潛能權重.add(new 權重(10003, 600));
    等級1潛能權重.add(new 權重(10004, 600));
    等級1潛能權重.add(new 權重(10005, 1000));
    等級1潛能權重.add(new 權重(10006, 1000));
    等級1潛能權重.add(new 權重(10013, 800));
    等級1潛能權重.add(new 權重(10041, 600));
    等級1潛能權重.add(new 權重(10042, 600));
    等級1潛能權重.add(new 權重(10043, 600));
    等級1潛能權重.add(new 權重(10044, 600));
    等級1潛能權重.add(new 權重(10045, 600));
    等級1潛能權重.add(new 權重(10046, 600));
    等級1潛能權重.add(new 權重(10053, 800));
    等級1潛能權重.add(new 權重(10081, 400));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30041, 980));
    等級3潛能權重.add(new 權重(30042, 980));
    等級3潛能權重.add(new 權重(30043, 980));
    等級3潛能權重.add(new 權重(30044, 980));
    等級3潛能權重.add(new 權重(30045, 1176));
    等級3潛能權重.add(new 權重(30046, 1176));
    等級3潛能權重.add(new 權重(30053, 1961));
    等級3潛能權重.add(new 權重(30086, 784));
    等級3潛能權重.add(new 權重(30551, 980));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40041, 784));
    等級4潛能權重.add(new 權重(40042, 784));
    等級4潛能權重.add(new 權重(40043, 784));
    等級4潛能權重.add(new 權重(40044, 784));
    等級4潛能權重.add(new 權重(40045, 784));
    等級4潛能權重.add(new 權重(40046, 784));
    等級4潛能權重.add(new 權重(40053, 1961));
    等級4潛能權重.add(new 權重(40086, 588));
    等級4潛能權重.add(new 權重(40501, 784));
    等級4潛能權重.add(new 權重(40502, 784));
    等級4潛能權重.add(new 權重(40650, 588));
    等級4潛能權重.add(new 權重(40656, 588));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));

    臉飾潛能權重Map.put(1, 等級1潛能權重);

    臉飾潛能權重Map.put(2, 等級2潛能權重);

    臉飾潛能權重Map.put(3, 等級3潛能權重);

    臉飾潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 臉飾潛能權重Map.keySet())
    {
      for (權重 權重數據 : 臉飾潛能權重Map.get(key))
      {
        System.out.println("加載臉飾的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載武器潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 625));
    等級1潛能權重.add(new 權重(10002, 625));
    等級1潛能權重.add(new 權重(10003, 625));
    等級1潛能權重.add(new 權重(10004, 625));
    等級1潛能權重.add(new 權重(10005, 1250));
    等級1潛能權重.add(new 權重(10006, 417));
    等級1潛能權重.add(new 權重(10011, 417));
    等級1潛能權重.add(new 權重(10012, 625));
    等級1潛能權重.add(new 權重(10041, 625));
    等級1潛能權重.add(new 權重(10042, 625));
    等級1潛能權重.add(new 權重(10043, 625));
    等級1潛能權重.add(new 權重(10044, 208));
    等級1潛能權重.add(new 權重(10051, 208));
    等級1潛能權重.add(new 權重(10052, 208));
    等級1潛能權重.add(new 權重(10070, 208));
    等級1潛能權重.add(new 權重(10081, 417));
    等級1潛能權重.add(new 權重(10207, 208));
    等級1潛能權重.add(new 權重(10221, 208));
    等級1潛能權重.add(new 權重(10226, 208));
    等級1潛能權重.add(new 權重(10231, 208));
    等級1潛能權重.add(new 權重(10236, 208));
    等級1潛能權重.add(new 權重(10241, 208));
    等級1潛能權重.add(new 權重(10246, 208));
    等級1潛能權重.add(new 權重(10291, 208));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20051, 400));
    等級2潛能權重.add(new 權重(20052, 400));
    等級2潛能權重.add(new 權重(20055, 400));
    等級2潛能權重.add(new 權重(20070, 400));
    等級2潛能權重.add(new 權重(20202, 400));
    等級2潛能權重.add(new 權重(20207, 400));
    等級2潛能權重.add(new 權重(20291, 400));
    等級2潛能權重.add(new 權重(20041, 1000));
    等級2潛能權重.add(new 權重(20042, 1000));
    等級2潛能權重.add(new 權重(20043, 1000));
    等級2潛能權重.add(new 權重(20044, 1000));
    等級2潛能權重.add(new 權重(20045, 1400));
    等級2潛能權重.add(new 權重(20046, 1400));
    等級2潛能權重.add(new 權重(20086, 400));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30051, 652));
    等級3潛能權重.add(new 權重(30052, 652));
    等級3潛能權重.add(new 權重(30070, 652));
    等級3潛能權重.add(new 權重(30291, 870));
    等級3潛能權重.add(new 權重(30602, 652));
    等級3潛能權重.add(new 權重(30055, 1087));
    等級3潛能權重.add(new 權重(30041, 1087));
    等級3潛能權重.add(new 權重(30042, 1087));
    等級3潛能權重.add(new 權重(30043, 1087));
    等級3潛能權重.add(new 權重(30044, 1087));
    等級3潛能權重.add(new 權重(30086, 1087));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40051, 444));
    等級4潛能權重.add(new 權重(40052, 444));
    等級4潛能權重.add(new 權重(40070, 444));
    等級4潛能權重.add(new 權重(40291, 667));
    等級4潛能權重.add(new 權重(40292, 667));
    // 等級4潛能權重.add(new 權重(40601, 0));
    等級4潛能權重.add(new 權重(40602, 889));
    等級4潛能權重.add(new 權重(40603, 444));
    等級4潛能權重.add(new 權重(40055, 444));
    等級4潛能權重.add(new 權重(40091, 667));
    等級4潛能權重.add(new 權重(40092, 667));
    等級4潛能權重.add(new 權重(40041, 889));
    等級4潛能權重.add(new 權重(40042, 889));
    等級4潛能權重.add(new 權重(40043, 889));
    等級4潛能權重.add(new 權重(40044, 889));
    等級4潛能權重.add(new 權重(40086, 667));

    武器潛能權重Map.put(1, 等級1潛能權重);

    武器潛能權重Map.put(2, 等級2潛能權重);

    武器潛能權重Map.put(3, 等級3潛能權重);

    武器潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 武器潛能權重Map.keySet())
    {
      for (權重 權重數據 : 武器潛能權重Map.get(key))
      {
        System.out.println("加載武器的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載副手武器潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 625));
    等級1潛能權重.add(new 權重(10002, 625));
    等級1潛能權重.add(new 權重(10003, 625));
    等級1潛能權重.add(new 權重(10004, 625));
    等級1潛能權重.add(new 權重(10005, 1250));
    等級1潛能權重.add(new 權重(10006, 417));
    等級1潛能權重.add(new 權重(10011, 417));
    等級1潛能權重.add(new 權重(10012, 625));
    等級1潛能權重.add(new 權重(10041, 625));
    等級1潛能權重.add(new 權重(10042, 625));
    等級1潛能權重.add(new 權重(10043, 625));
    等級1潛能權重.add(new 權重(10044, 208));
    等級1潛能權重.add(new 權重(10051, 208));
    等級1潛能權重.add(new 權重(10052, 208));
    等級1潛能權重.add(new 權重(10070, 208));
    等級1潛能權重.add(new 權重(10081, 417));
    等級1潛能權重.add(new 權重(10207, 208));
    等級1潛能權重.add(new 權重(10221, 208));
    等級1潛能權重.add(new 權重(10226, 208));
    等級1潛能權重.add(new 權重(10231, 208));
    等級1潛能權重.add(new 權重(10236, 208));
    等級1潛能權重.add(new 權重(10241, 208));
    等級1潛能權重.add(new 權重(10246, 208));
    等級1潛能權重.add(new 權重(10291, 208));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20051, 400));
    等級2潛能權重.add(new 權重(20052, 400));
    等級2潛能權重.add(new 權重(20055, 400));
    等級2潛能權重.add(new 權重(20070, 400));
    等級2潛能權重.add(new 權重(20202, 400));
    等級2潛能權重.add(new 權重(20207, 400));
    等級2潛能權重.add(new 權重(20291, 400));
    等級2潛能權重.add(new 權重(20041, 1000));
    等級2潛能權重.add(new 權重(20042, 1000));
    等級2潛能權重.add(new 權重(20043, 1000));
    等級2潛能權重.add(new 權重(20044, 1000));
    等級2潛能權重.add(new 權重(20045, 1400));
    等級2潛能權重.add(new 權重(20046, 1400));
    等級2潛能權重.add(new 權重(20086, 400));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30051, 652));
    等級3潛能權重.add(new 權重(30052, 652));
    等級3潛能權重.add(new 權重(30070, 652));
    等級3潛能權重.add(new 權重(30291, 870));
    等級3潛能權重.add(new 權重(30602, 652));
    等級3潛能權重.add(new 權重(30055, 1087));
    等級3潛能權重.add(new 權重(30041, 1087));
    等級3潛能權重.add(new 權重(30042, 1087));
    等級3潛能權重.add(new 權重(30043, 1087));
    等級3潛能權重.add(new 權重(30044, 1087));
    等級3潛能權重.add(new 權重(30086, 1087));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40051, 444));
    等級4潛能權重.add(new 權重(40052, 444));
    等級4潛能權重.add(new 權重(40070, 444));
    等級4潛能權重.add(new 權重(40291, 667));
    等級4潛能權重.add(new 權重(40292, 667));
    // 等級4潛能權重.add(new 權重(40601, 0));
    等級4潛能權重.add(new 權重(40602, 889));
    等級4潛能權重.add(new 權重(40603, 444));
    等級4潛能權重.add(new 權重(40055, 444));
    等級4潛能權重.add(new 權重(40091, 667));
    等級4潛能權重.add(new 權重(40092, 667));
    等級4潛能權重.add(new 權重(40041, 889));
    等級4潛能權重.add(new 權重(40042, 889));
    等級4潛能權重.add(new 權重(40043, 889));
    等級4潛能權重.add(new 權重(40044, 889));
    等級4潛能權重.add(new 權重(40086, 667));

    副手武器潛能權重Map.put(1, 等級1潛能權重);

    副手武器潛能權重Map.put(2, 等級2潛能權重);

    副手武器潛能權重Map.put(3, 等級3潛能權重);

    副手武器潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 副手武器潛能權重Map.keySet())
    {
      for (權重 權重數據 : 副手武器潛能權重Map.get(key))
      {
        System.out.println("加載副手武器的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載徽章潛能權重 ()
  {
    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 625));
    等級1潛能權重.add(new 權重(10002, 625));
    等級1潛能權重.add(new 權重(10003, 625));
    等級1潛能權重.add(new 權重(10004, 625));
    等級1潛能權重.add(new 權重(10005, 1250));
    等級1潛能權重.add(new 權重(10006, 417));
    等級1潛能權重.add(new 權重(10011, 417));
    等級1潛能權重.add(new 權重(10012, 625));
    等級1潛能權重.add(new 權重(10041, 625));
    等級1潛能權重.add(new 權重(10042, 625));
    等級1潛能權重.add(new 權重(10043, 625));
    等級1潛能權重.add(new 權重(10044, 208));
    等級1潛能權重.add(new 權重(10051, 208));
    等級1潛能權重.add(new 權重(10052, 208));
    等級1潛能權重.add(new 權重(10070, 208));
    等級1潛能權重.add(new 權重(10081, 417));
    等級1潛能權重.add(new 權重(10207, 208));
    等級1潛能權重.add(new 權重(10221, 208));
    等級1潛能權重.add(new 權重(10226, 208));
    等級1潛能權重.add(new 權重(10231, 208));
    等級1潛能權重.add(new 權重(10236, 208));
    等級1潛能權重.add(new 權重(10241, 208));
    等級1潛能權重.add(new 權重(10246, 208));
    等級1潛能權重.add(new 權重(10291, 208));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20051, 400));
    等級2潛能權重.add(new 權重(20052, 400));
    等級2潛能權重.add(new 權重(20055, 400));
    等級2潛能權重.add(new 權重(20070, 400));
    等級2潛能權重.add(new 權重(20202, 400));
    等級2潛能權重.add(new 權重(20207, 400));
    等級2潛能權重.add(new 權重(20291, 400));
    等級2潛能權重.add(new 權重(20041, 1000));
    等級2潛能權重.add(new 權重(20042, 1000));
    等級2潛能權重.add(new 權重(20043, 1000));
    等級2潛能權重.add(new 權重(20044, 1000));
    等級2潛能權重.add(new 權重(20045, 1400));
    等級2潛能權重.add(new 權重(20046, 1400));
    等級2潛能權重.add(new 權重(20086, 400));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(30051, 698));
    等級3潛能權重.add(new 權重(30052, 698));
    等級3潛能權重.add(new 權重(30070, 698));
    等級3潛能權重.add(new 權重(30291, 930));
    等級3潛能權重.add(new 權重(30055, 1163));
    等級3潛能權重.add(new 權重(30041, 1163));
    等級3潛能權重.add(new 權重(30042, 1163));
    等級3潛能權重.add(new 權重(30043, 1163));
    等級3潛能權重.add(new 權重(30044, 1163));
    等級3潛能權重.add(new 權重(30086, 1163));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();


    等級4潛能權重.add(new 權重(40051, 513));
    等級4潛能權重.add(new 權重(40052, 513));
    等級4潛能權重.add(new 權重(40070, 513));
    等級4潛能權重.add(new 權重(40291, 769));
    等級4潛能權重.add(new 權重(40292, 769));
    等級4潛能權重.add(new 權重(40055, 513));
    等級4潛能權重.add(new 權重(40091, 769));
    等級4潛能權重.add(new 權重(40092, 769));
    等級4潛能權重.add(new 權重(40041, 1026));
    等級4潛能權重.add(new 權重(40042, 1026));
    等級4潛能權重.add(new 權重(40043, 1026));
    等級4潛能權重.add(new 權重(40044, 1026));
    等級4潛能權重.add(new 權重(40086, 769));

    徽章潛能權重Map.put(1, 等級1潛能權重);

    徽章潛能權重Map.put(2, 等級2潛能權重);

    徽章潛能權重Map.put(3, 等級3潛能權重);

    徽章潛能權重Map.put(4, 等級4潛能權重);

    for (Integer key : 徽章潛能權重Map.keySet())
    {
      for (權重 權重數據 : 徽章潛能權重Map.get(key))
      {
        System.out.println("加載徽章的潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 潛能數據檢查 ()
  {
    for (Integer key : 頭盔潛能權重Map.keySet())
    {
      for (權重 權重數據 : 頭盔潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查頭盔潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 上衣潛能權重Map.keySet())
    {
      for (權重 權重數據 : 上衣潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查上衣潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 下衣潛能權重Map.keySet())
    {
      for (權重 權重數據 : 下衣潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查下衣潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 套服潛能權重Map.keySet())
    {
      for (權重 權重數據 : 套服潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查套服潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 手套潛能權重Map.keySet())
    {
      for (權重 權重數據 : 手套潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查手套潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 披風潛能權重Map.keySet())
    {
      for (權重 權重數據 : 披風潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查披風潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 鞋子潛能權重Map.keySet())
    {
      for (權重 權重數據 : 鞋子潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查鞋子潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 護肩潛能權重Map.keySet())
    {
      for (權重 權重數據 : 護肩潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查護肩潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 腰帶潛能權重Map.keySet())
    {
      for (權重 權重數據 : 腰帶潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查腰帶潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 戒指潛能權重Map.keySet())
    {
      for (權重 權重數據 : 戒指潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查戒指潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 耳環潛能權重Map.keySet())
    {
      for (權重 權重數據 : 耳環潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查耳環潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 心臟潛能權重Map.keySet())
    {
      for (權重 權重數據 : 心臟潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查心臟潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 眼飾潛能權重Map.keySet())
    {
      for (權重 權重數據 : 眼飾潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查眼飾潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 臉飾潛能權重Map.keySet())
    {
      for (權重 權重數據 : 臉飾潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查臉飾潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 武器潛能權重Map.keySet())
    {
      for (權重 權重數據 : 武器潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查武器潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 副手武器潛能權重Map.keySet())
    {
      for (權重 權重數據 : 副手武器潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查副手武器潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 徽章潛能權重Map.keySet())
    {
      for (權重 權重數據 : 徽章潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查徽章潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 吊墜潛能權重Map.keySet())
    {
      for (權重 權重數據 : 吊墜潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id >= key * 10000 + 2000)
        {
          System.out.println("檢查吊墜潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }
  }

  public static void 加載裝備潛能權重 ()
  {
    加載頭盔潛能權重();
    加載上衣潛能權重();
    加載套服潛能權重();
    加載下衣潛能權重();
    加載鞋子潛能權重();
    加載手套潛能權重();
    加載披風潛能權重();
    加載護肩潛能權重();
    加載腰帶潛能權重();
    加載戒指潛能權重();
    加載耳環潛能權重();
    加載吊墜潛能權重();
    加載眼飾潛能權重();
    加載臉飾潛能權重();
    加載心臟潛能權重();
    加載武器潛能權重();
    加載副手武器潛能權重();
    加載徽章潛能權重();
    潛能數據檢查();
  }

  private static void 加載頭盔附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32116, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42001, 455));
    等級4附加潛能權重.add(new 權重(42002, 455));
    等級4附加潛能權重.add(new 權重(42003, 455));
    等級4附加潛能權重.add(new 權重(42004, 455));
    等級4附加潛能權重.add(new 權重(42005, 455));
    等級4附加潛能權重.add(new 權重(42006, 455));
    等級4附加潛能權重.add(new 權重(42011, 303));
    等級4附加潛能權重.add(new 權重(42012, 303));
    等級4附加潛能權重.add(new 權重(42013, 455));
    等級4附加潛能權重.add(new 權重(42041, 303));
    等級4附加潛能權重.add(new 權重(42042, 303));
    等級4附加潛能權重.add(new 權重(42043, 303));
    等級4附加潛能權重.add(new 權重(42044, 303));
    等級4附加潛能權重.add(new 權重(42045, 455));
    等級4附加潛能權重.add(new 權重(42046, 455));
    等級4附加潛能權重.add(new 權重(42055, 455));
    等級4附加潛能權重.add(new 權重(42062, 303));
    等級4附加潛能權重.add(new 權重(42086, 303));
    等級4附加潛能權重.add(new 權重(42091, 303));
    等級4附加潛能權重.add(new 權重(42092, 303));
    等級4附加潛能權重.add(new 權重(42093, 303));
    等級4附加潛能權重.add(new 權重(42094, 303));
    等級4附加潛能權重.add(new 權重(42551, 455));
    等級4附加潛能權重.add(new 權重(42556, 455));
    等級4附加潛能權重.add(new 權重(42650, 455));
    等級4附加潛能權重.add(new 權重(42656, 455));
    等級3附加潛能權重.add(new 權重(32116, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));


    頭盔附加潛能權重Map.put(1, 等級1附加潛能權重);

    頭盔附加潛能權重Map.put(2, 等級2附加潛能權重);

    頭盔附加潛能權重Map.put(3, 等級3附加潛能權重);

    頭盔附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 頭盔附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 頭盔附加潛能權重Map.get(key))
      {
        System.out.println("加載頭盔的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載手套附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42001, 462));
    等級4附加潛能權重.add(new 權重(42002, 462));
    等級4附加潛能權重.add(new 權重(42003, 462));
    等級4附加潛能權重.add(new 權重(42004, 462));
    等級4附加潛能權重.add(new 權重(42005, 462));
    等級4附加潛能權重.add(new 權重(42006, 462));
    等級4附加潛能權重.add(new 權重(42011, 308));
    等級4附加潛能權重.add(new 權重(42012, 308));
    等級4附加潛能權重.add(new 權重(42013, 462));
    等級4附加潛能權重.add(new 權重(42041, 308));
    等級4附加潛能權重.add(new 權重(42042, 308));
    等級4附加潛能權重.add(new 權重(42043, 308));
    等級4附加潛能權重.add(new 權重(42044, 308));
    等級4附加潛能權重.add(new 權重(42045, 462));
    等級4附加潛能權重.add(new 權重(42046, 462));
    等級4附加潛能權重.add(new 權重(42055, 462));
    等級4附加潛能權重.add(new 權重(42061, 308));
    等級4附加潛能權重.add(new 權重(42062, 308));
    等級4附加潛能權重.add(new 權重(42086, 308));
    等級4附加潛能權重.add(new 權重(42091, 308));
    等級4附加潛能權重.add(new 權重(42092, 308));
    等級4附加潛能權重.add(new 權重(42093, 308));
    等級4附加潛能權重.add(new 權重(42094, 308));
    等級4附加潛能權重.add(new 權重(42551, 462));
    等級4附加潛能權重.add(new 權重(42650, 462));
    等級4附加潛能權重.add(new 權重(42656, 462));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    手套附加潛能權重Map.put(1, 等級1附加潛能權重);

    手套附加潛能權重Map.put(2, 等級2附加潛能權重);

    手套附加潛能權重Map.put(3, 等級3附加潛能權重);

    手套附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 手套附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 手套附加潛能權重Map.get(key))
      {
        System.out.println("加載手套的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載上衣附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42001, 476));
    等級4附加潛能權重.add(new 權重(42002, 476));
    等級4附加潛能權重.add(new 權重(42003, 476));
    等級4附加潛能權重.add(new 權重(42004, 476));
    等級4附加潛能權重.add(new 權重(42005, 476));
    等級4附加潛能權重.add(new 權重(42006, 476));
    等級4附加潛能權重.add(new 權重(42011, 317));
    等級4附加潛能權重.add(new 權重(42012, 317));
    等級4附加潛能權重.add(new 權重(42013, 476));
    等級4附加潛能權重.add(new 權重(42041, 317));
    等級4附加潛能權重.add(new 權重(42042, 317));
    等級4附加潛能權重.add(new 權重(42043, 317));
    等級4附加潛能權重.add(new 權重(42044, 317));
    等級4附加潛能權重.add(new 權重(42045, 476));
    等級4附加潛能權重.add(new 權重(42046, 476));
    等級4附加潛能權重.add(new 權重(42055, 476));
    等級4附加潛能權重.add(new 權重(42062, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42091, 317));
    等級4附加潛能權重.add(new 權重(42092, 317));
    等級4附加潛能權重.add(new 權重(42093, 317));
    等級4附加潛能權重.add(new 權重(42094, 476));
    等級4附加潛能權重.add(new 權重(42650, 476));
    等級4附加潛能權重.add(new 權重(42656, 476));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    上衣附加潛能權重Map.put(1, 等級1附加潛能權重);

    上衣附加潛能權重Map.put(2, 等級2附加潛能權重);

    上衣附加潛能權重Map.put(3, 等級3附加潛能權重);

    上衣附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 上衣附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 上衣附加潛能權重Map.get(key))
      {
        System.out.println("加載上衣的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載下衣附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42001, 476));
    等級4附加潛能權重.add(new 權重(42002, 476));
    等級4附加潛能權重.add(new 權重(42003, 476));
    等級4附加潛能權重.add(new 權重(42004, 476));
    等級4附加潛能權重.add(new 權重(42005, 476));
    等級4附加潛能權重.add(new 權重(42006, 476));
    等級4附加潛能權重.add(new 權重(42011, 317));
    等級4附加潛能權重.add(new 權重(42012, 317));
    等級4附加潛能權重.add(new 權重(42013, 476));
    等級4附加潛能權重.add(new 權重(42041, 317));
    等級4附加潛能權重.add(new 權重(42042, 317));
    等級4附加潛能權重.add(new 權重(42043, 317));
    等級4附加潛能權重.add(new 權重(42044, 317));
    等級4附加潛能權重.add(new 權重(42045, 476));
    等級4附加潛能權重.add(new 權重(42046, 476));
    等級4附加潛能權重.add(new 權重(42055, 476));
    等級4附加潛能權重.add(new 權重(42062, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42091, 317));
    等級4附加潛能權重.add(new 權重(42092, 317));
    等級4附加潛能權重.add(new 權重(42093, 317));
    等級4附加潛能權重.add(new 權重(42094, 476));
    等級4附加潛能權重.add(new 權重(42650, 476));
    等級4附加潛能權重.add(new 權重(42656, 476));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    下衣附加潛能權重Map.put(1, 等級1附加潛能權重);

    下衣附加潛能權重Map.put(2, 等級2附加潛能權重);

    下衣附加潛能權重Map.put(3, 等級3附加潛能權重);

    下衣附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 下衣附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 下衣附加潛能權重Map.get(key))
      {
        System.out.println("加載下衣的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載套服附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42001, 476));
    等級4附加潛能權重.add(new 權重(42002, 476));
    等級4附加潛能權重.add(new 權重(42003, 476));
    等級4附加潛能權重.add(new 權重(42004, 476));
    等級4附加潛能權重.add(new 權重(42005, 476));
    等級4附加潛能權重.add(new 權重(42006, 476));
    等級4附加潛能權重.add(new 權重(42011, 317));
    等級4附加潛能權重.add(new 權重(42012, 317));
    等級4附加潛能權重.add(new 權重(42013, 476));
    等級4附加潛能權重.add(new 權重(42041, 317));
    等級4附加潛能權重.add(new 權重(42042, 317));
    等級4附加潛能權重.add(new 權重(42043, 317));
    等級4附加潛能權重.add(new 權重(42044, 317));
    等級4附加潛能權重.add(new 權重(42045, 476));
    等級4附加潛能權重.add(new 權重(42046, 476));
    等級4附加潛能權重.add(new 權重(42055, 476));
    等級4附加潛能權重.add(new 權重(42062, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42091, 317));
    等級4附加潛能權重.add(new 權重(42092, 317));
    等級4附加潛能權重.add(new 權重(42093, 317));
    等級4附加潛能權重.add(new 權重(42094, 476));
    等級4附加潛能權重.add(new 權重(42650, 476));
    等級4附加潛能權重.add(new 權重(42656, 476));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    套服附加潛能權重Map.put(1, 等級1附加潛能權重);

    套服附加潛能權重Map.put(2, 等級2附加潛能權重);

    套服附加潛能權重Map.put(3, 等級3附加潛能權重);

    套服附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 套服附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 套服附加潛能權重Map.get(key))
      {
        System.out.println("加載套服的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載披風附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42001, 476));
    等級4附加潛能權重.add(new 權重(42002, 476));
    等級4附加潛能權重.add(new 權重(42003, 476));
    等級4附加潛能權重.add(new 權重(42004, 476));
    等級4附加潛能權重.add(new 權重(42005, 476));
    等級4附加潛能權重.add(new 權重(42006, 476));
    等級4附加潛能權重.add(new 權重(42011, 317));
    等級4附加潛能權重.add(new 權重(42012, 317));
    等級4附加潛能權重.add(new 權重(42013, 476));
    等級4附加潛能權重.add(new 權重(42041, 317));
    等級4附加潛能權重.add(new 權重(42042, 317));
    等級4附加潛能權重.add(new 權重(42043, 317));
    等級4附加潛能權重.add(new 權重(42044, 317));
    等級4附加潛能權重.add(new 權重(42045, 476));
    等級4附加潛能權重.add(new 權重(42046, 476));
    等級4附加潛能權重.add(new 權重(42055, 476));
    等級4附加潛能權重.add(new 權重(42062, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42091, 317));
    等級4附加潛能權重.add(new 權重(42092, 317));
    等級4附加潛能權重.add(new 權重(42093, 317));
    等級4附加潛能權重.add(new 權重(42094, 476));
    等級4附加潛能權重.add(new 權重(42650, 476));
    等級4附加潛能權重.add(new 權重(42656, 476));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    披風附加潛能權重Map.put(1, 等級1附加潛能權重);

    披風附加潛能權重Map.put(2, 等級2附加潛能權重);

    披風附加潛能權重Map.put(3, 等級3附加潛能權重);

    披風附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 披風附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 披風附加潛能權重Map.get(key))
      {
        System.out.println("加載披風的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載腰帶附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42001, 476));
    等級4附加潛能權重.add(new 權重(42002, 476));
    等級4附加潛能權重.add(new 權重(42003, 476));
    等級4附加潛能權重.add(new 權重(42004, 476));
    等級4附加潛能權重.add(new 權重(42005, 476));
    等級4附加潛能權重.add(new 權重(42006, 476));
    等級4附加潛能權重.add(new 權重(42011, 317));
    等級4附加潛能權重.add(new 權重(42012, 317));
    等級4附加潛能權重.add(new 權重(42013, 476));
    等級4附加潛能權重.add(new 權重(42041, 317));
    等級4附加潛能權重.add(new 權重(42042, 317));
    等級4附加潛能權重.add(new 權重(42043, 317));
    等級4附加潛能權重.add(new 權重(42044, 317));
    等級4附加潛能權重.add(new 權重(42045, 476));
    等級4附加潛能權重.add(new 權重(42046, 476));
    等級4附加潛能權重.add(new 權重(42055, 476));
    等級4附加潛能權重.add(new 權重(42062, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42091, 317));
    等級4附加潛能權重.add(new 權重(42092, 317));
    等級4附加潛能權重.add(new 權重(42093, 317));
    等級4附加潛能權重.add(new 權重(42094, 476));
    等級4附加潛能權重.add(new 權重(42650, 476));
    等級4附加潛能權重.add(new 權重(42656, 476));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    腰帶附加潛能權重Map.put(1, 等級1附加潛能權重);

    腰帶附加潛能權重Map.put(2, 等級2附加潛能權重);

    腰帶附加潛能權重Map.put(3, 等級3附加潛能權重);

    腰帶附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 腰帶附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 腰帶附加潛能權重Map.get(key))
      {
        System.out.println("加載腰帶的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載心臟附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42001, 476));
    等級4附加潛能權重.add(new 權重(42002, 476));
    等級4附加潛能權重.add(new 權重(42003, 476));
    等級4附加潛能權重.add(new 權重(42004, 476));
    等級4附加潛能權重.add(new 權重(42005, 476));
    等級4附加潛能權重.add(new 權重(42006, 476));
    等級4附加潛能權重.add(new 權重(42011, 317));
    等級4附加潛能權重.add(new 權重(42012, 317));
    等級4附加潛能權重.add(new 權重(42013, 476));
    等級4附加潛能權重.add(new 權重(42041, 317));
    等級4附加潛能權重.add(new 權重(42042, 317));
    等級4附加潛能權重.add(new 權重(42043, 317));
    等級4附加潛能權重.add(new 權重(42044, 317));
    等級4附加潛能權重.add(new 權重(42045, 476));
    等級4附加潛能權重.add(new 權重(42046, 476));
    等級4附加潛能權重.add(new 權重(42055, 476));
    等級4附加潛能權重.add(new 權重(42062, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42091, 317));
    等級4附加潛能權重.add(new 權重(42092, 317));
    等級4附加潛能權重.add(new 權重(42093, 317));
    等級4附加潛能權重.add(new 權重(42094, 476));
    等級4附加潛能權重.add(new 權重(42650, 476));
    等級4附加潛能權重.add(new 權重(42656, 476));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    心臟附加潛能權重Map.put(1, 等級1附加潛能權重);

    心臟附加潛能權重Map.put(2, 等級2附加潛能權重);

    心臟附加潛能權重Map.put(3, 等級3附加潛能權重);

    心臟附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 心臟附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 心臟附加潛能權重Map.get(key))
      {
        System.out.println("加載心臟的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載護肩附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42001, 476));
    等級4附加潛能權重.add(new 權重(42002, 476));
    等級4附加潛能權重.add(new 權重(42003, 476));
    等級4附加潛能權重.add(new 權重(42004, 476));
    等級4附加潛能權重.add(new 權重(42005, 476));
    等級4附加潛能權重.add(new 權重(42006, 476));
    等級4附加潛能權重.add(new 權重(42011, 317));
    等級4附加潛能權重.add(new 權重(42012, 317));
    等級4附加潛能權重.add(new 權重(42013, 476));
    等級4附加潛能權重.add(new 權重(42041, 317));
    等級4附加潛能權重.add(new 權重(42042, 317));
    等級4附加潛能權重.add(new 權重(42043, 317));
    等級4附加潛能權重.add(new 權重(42044, 317));
    等級4附加潛能權重.add(new 權重(42045, 476));
    等級4附加潛能權重.add(new 權重(42046, 476));
    等級4附加潛能權重.add(new 權重(42055, 476));
    等級4附加潛能權重.add(new 權重(42062, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42091, 317));
    等級4附加潛能權重.add(new 權重(42092, 317));
    等級4附加潛能權重.add(new 權重(42093, 317));
    等級4附加潛能權重.add(new 權重(42094, 476));
    等級4附加潛能權重.add(new 權重(42650, 476));
    等級4附加潛能權重.add(new 權重(42656, 476));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    護肩附加潛能權重Map.put(1, 等級1附加潛能權重);

    護肩附加潛能權重Map.put(2, 等級2附加潛能權重);

    護肩附加潛能權重Map.put(3, 等級3附加潛能權重);

    護肩附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 護肩附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 護肩附加潛能權重Map.get(key))
      {
        System.out.println("加載護肩的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載鞋子附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42001, 476));
    等級4附加潛能權重.add(new 權重(42002, 476));
    等級4附加潛能權重.add(new 權重(42003, 476));
    等級4附加潛能權重.add(new 權重(42004, 476));
    等級4附加潛能權重.add(new 權重(42005, 476));
    等級4附加潛能權重.add(new 權重(42006, 476));
    等級4附加潛能權重.add(new 權重(42011, 317));
    等級4附加潛能權重.add(new 權重(42012, 317));
    等級4附加潛能權重.add(new 權重(42013, 476));
    等級4附加潛能權重.add(new 權重(42041, 317));
    等級4附加潛能權重.add(new 權重(42042, 317));
    等級4附加潛能權重.add(new 權重(42043, 317));
    等級4附加潛能權重.add(new 權重(42044, 317));
    等級4附加潛能權重.add(new 權重(42045, 476));
    等級4附加潛能權重.add(new 權重(42046, 476));
    等級4附加潛能權重.add(new 權重(42055, 476));
    等級4附加潛能權重.add(new 權重(42062, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42086, 317));
    等級4附加潛能權重.add(new 權重(42091, 317));
    等級4附加潛能權重.add(new 權重(42092, 317));
    等級4附加潛能權重.add(new 權重(42093, 317));
    等級4附加潛能權重.add(new 權重(42094, 476));
    等級4附加潛能權重.add(new 權重(42650, 476));
    等級4附加潛能權重.add(new 權重(42656, 476));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    鞋子附加潛能權重Map.put(1, 等級1附加潛能權重);

    鞋子附加潛能權重Map.put(2, 等級2附加潛能權重);

    鞋子附加潛能權重Map.put(3, 等級3附加潛能權重);

    鞋子附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 鞋子附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 鞋子附加潛能權重Map.get(key))
      {
        System.out.println("加載鞋子的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載戒指附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();


    等級4附加潛能權重.add(new 權重(42001, 469));
    等級4附加潛能權重.add(new 權重(42002, 469));
    等級4附加潛能權重.add(new 權重(42003, 469));
    等級4附加潛能權重.add(new 權重(42004, 469));
    等級4附加潛能權重.add(new 權重(42005, 469));
    等級4附加潛能權重.add(new 權重(42006, 469));
    等級4附加潛能權重.add(new 權重(42011, 313));
    等級4附加潛能權重.add(new 權重(42012, 313));
    等級4附加潛能權重.add(new 權重(42013, 469));
    等級4附加潛能權重.add(new 權重(42041, 313));
    等級4附加潛能權重.add(new 權重(42042, 313));
    等級4附加潛能權重.add(new 權重(42043, 313));
    等級4附加潛能權重.add(new 權重(42044, 313));
    等級4附加潛能權重.add(new 權重(42045, 469));
    等級4附加潛能權重.add(new 權重(42046, 469));
    等級4附加潛能權重.add(new 權重(42055, 469));
    等級4附加潛能權重.add(new 權重(42086, 313));
    等級4附加潛能權重.add(new 權重(42091, 313));
    等級4附加潛能權重.add(new 權重(42092, 313));
    等級4附加潛能權重.add(new 權重(42093, 313));
    等級4附加潛能權重.add(new 權重(42094, 313));
    等級4附加潛能權重.add(new 權重(42501, 469));
    等級4附加潛能權重.add(new 權重(42094, 469));
    等級4附加潛能權重.add(new 權重(42650, 469));
    等級4附加潛能權重.add(new 權重(42656, 469));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    戒指附加潛能權重Map.put(1, 等級1附加潛能權重);

    戒指附加潛能權重Map.put(2, 等級2附加潛能權重);

    戒指附加潛能權重Map.put(3, 等級3附加潛能權重);

    戒指附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 戒指附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 戒指附加潛能權重Map.get(key))
      {
        System.out.println("加載戒指的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載耳環附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();


    等級4附加潛能權重.add(new 權重(42001, 469));
    等級4附加潛能權重.add(new 權重(42002, 469));
    等級4附加潛能權重.add(new 權重(42003, 469));
    等級4附加潛能權重.add(new 權重(42004, 469));
    等級4附加潛能權重.add(new 權重(42005, 469));
    等級4附加潛能權重.add(new 權重(42006, 469));
    等級4附加潛能權重.add(new 權重(42011, 313));
    等級4附加潛能權重.add(new 權重(42012, 313));
    等級4附加潛能權重.add(new 權重(42013, 469));
    等級4附加潛能權重.add(new 權重(42041, 313));
    等級4附加潛能權重.add(new 權重(42042, 313));
    等級4附加潛能權重.add(new 權重(42043, 313));
    等級4附加潛能權重.add(new 權重(42044, 313));
    等級4附加潛能權重.add(new 權重(42045, 469));
    等級4附加潛能權重.add(new 權重(42046, 469));
    等級4附加潛能權重.add(new 權重(42055, 469));
    等級4附加潛能權重.add(new 權重(42086, 313));
    等級4附加潛能權重.add(new 權重(42091, 313));
    等級4附加潛能權重.add(new 權重(42092, 313));
    等級4附加潛能權重.add(new 權重(42093, 313));
    等級4附加潛能權重.add(new 權重(42094, 313));
    等級4附加潛能權重.add(new 權重(42501, 469));
    等級4附加潛能權重.add(new 權重(42094, 469));
    等級4附加潛能權重.add(new 權重(42650, 469));
    等級4附加潛能權重.add(new 權重(42656, 469));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    耳環附加潛能權重Map.put(1, 等級1附加潛能權重);

    耳環附加潛能權重Map.put(2, 等級2附加潛能權重);

    耳環附加潛能權重Map.put(3, 等級3附加潛能權重);

    耳環附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 耳環附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 耳環附加潛能權重Map.get(key))
      {
        System.out.println("加載耳環的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載吊墜附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();


    等級4附加潛能權重.add(new 權重(42001, 469));
    等級4附加潛能權重.add(new 權重(42002, 469));
    等級4附加潛能權重.add(new 權重(42003, 469));
    等級4附加潛能權重.add(new 權重(42004, 469));
    等級4附加潛能權重.add(new 權重(42005, 469));
    等級4附加潛能權重.add(new 權重(42006, 469));
    等級4附加潛能權重.add(new 權重(42011, 313));
    等級4附加潛能權重.add(new 權重(42012, 313));
    等級4附加潛能權重.add(new 權重(42013, 469));
    等級4附加潛能權重.add(new 權重(42041, 313));
    等級4附加潛能權重.add(new 權重(42042, 313));
    等級4附加潛能權重.add(new 權重(42043, 313));
    等級4附加潛能權重.add(new 權重(42044, 313));
    等級4附加潛能權重.add(new 權重(42045, 469));
    等級4附加潛能權重.add(new 權重(42046, 469));
    等級4附加潛能權重.add(new 權重(42055, 469));
    等級4附加潛能權重.add(new 權重(42086, 313));
    等級4附加潛能權重.add(new 權重(42091, 313));
    等級4附加潛能權重.add(new 權重(42092, 313));
    等級4附加潛能權重.add(new 權重(42093, 313));
    等級4附加潛能權重.add(new 權重(42094, 313));
    等級4附加潛能權重.add(new 權重(42501, 469));
    等級4附加潛能權重.add(new 權重(42094, 469));
    等級4附加潛能權重.add(new 權重(42650, 469));
    等級4附加潛能權重.add(new 權重(42656, 469));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    吊墜附加潛能權重Map.put(1, 等級1附加潛能權重);

    吊墜附加潛能權重Map.put(2, 等級2附加潛能權重);

    吊墜附加潛能權重Map.put(3, 等級3附加潛能權重);

    吊墜附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 吊墜附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 吊墜附加潛能權重Map.get(key))
      {
        System.out.println("加載吊墜的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載眼飾附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();


    等級4附加潛能權重.add(new 權重(42001, 469));
    等級4附加潛能權重.add(new 權重(42002, 469));
    等級4附加潛能權重.add(new 權重(42003, 469));
    等級4附加潛能權重.add(new 權重(42004, 469));
    等級4附加潛能權重.add(new 權重(42005, 469));
    等級4附加潛能權重.add(new 權重(42006, 469));
    等級4附加潛能權重.add(new 權重(42011, 313));
    等級4附加潛能權重.add(new 權重(42012, 313));
    等級4附加潛能權重.add(new 權重(42013, 469));
    等級4附加潛能權重.add(new 權重(42041, 313));
    等級4附加潛能權重.add(new 權重(42042, 313));
    等級4附加潛能權重.add(new 權重(42043, 313));
    等級4附加潛能權重.add(new 權重(42044, 313));
    等級4附加潛能權重.add(new 權重(42045, 469));
    等級4附加潛能權重.add(new 權重(42046, 469));
    等級4附加潛能權重.add(new 權重(42055, 469));
    等級4附加潛能權重.add(new 權重(42086, 313));
    等級4附加潛能權重.add(new 權重(42091, 313));
    等級4附加潛能權重.add(new 權重(42092, 313));
    等級4附加潛能權重.add(new 權重(42093, 313));
    等級4附加潛能權重.add(new 權重(42094, 313));
    等級4附加潛能權重.add(new 權重(42501, 469));
    等級4附加潛能權重.add(new 權重(42094, 469));
    等級4附加潛能權重.add(new 權重(42650, 469));
    等級4附加潛能權重.add(new 權重(42656, 469));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    眼飾附加潛能權重Map.put(1, 等級1附加潛能權重);

    眼飾附加潛能權重Map.put(2, 等級2附加潛能權重);

    眼飾附加潛能權重Map.put(3, 等級3附加潛能權重);

    眼飾附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 眼飾附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 眼飾附加潛能權重Map.get(key))
      {
        System.out.println("加載眼飾的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載臉飾附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12001, 638));
    等級1附加潛能權重.add(new 權重(12002, 638));
    等級1附加潛能權重.add(new 權重(12003, 638));
    等級1附加潛能權重.add(new 權重(12004, 638));
    等級1附加潛能權重.add(new 權重(12005, 638));
    等級1附加潛能權重.add(new 權重(12006, 638));
    等級1附加潛能權重.add(new 權重(12009, 638));
    等級1附加潛能權重.add(new 權重(12010, 638));
    等級1附加潛能權重.add(new 權重(12011, 426));
    等級1附加潛能權重.add(new 權重(12012, 426));
    等級1附加潛能權重.add(new 權重(12013, 638));
    等級1附加潛能權重.add(new 權重(12041, 426));
    等級1附加潛能權重.add(new 權重(12042, 426));
    等級1附加潛能權重.add(new 權重(12043, 426));
    等級1附加潛能權重.add(new 權重(12044, 426));
    等級1附加潛能權重.add(new 權重(12045, 426));
    等級1附加潛能權重.add(new 權重(12046, 426));
    等級1附加潛能權重.add(new 權重(12053, 426));
    等級1附加潛能權重.add(new 權重(12081, 426));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22001, 600));
    等級2附加潛能權重.add(new 權重(22002, 600));
    等級2附加潛能權重.add(new 權重(22003, 600));
    等級2附加潛能權重.add(new 權重(22004, 600));
    等級2附加潛能權重.add(new 權重(22005, 600));
    等級2附加潛能權重.add(new 權重(22006, 600));
    等級2附加潛能權重.add(new 權重(22009, 600));
    等級2附加潛能權重.add(new 權重(22010, 600));
    等級2附加潛能權重.add(new 權重(22011, 400));
    等級2附加潛能權重.add(new 權重(22012, 400));
    等級2附加潛能權重.add(new 權重(22013, 600));
    等級2附加潛能權重.add(new 權重(22041, 400));
    等級2附加潛能權重.add(new 權重(22042, 400));
    等級2附加潛能權重.add(new 權重(22043, 400));
    等級2附加潛能權重.add(new 權重(22044, 400));
    等級2附加潛能權重.add(new 權重(22045, 600));
    等級2附加潛能權重.add(new 權重(22046, 600));
    等級2附加潛能權重.add(new 權重(22053, 600));
    等級2附加潛能權重.add(new 權重(22086, 400));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32001, 545));
    等級3附加潛能權重.add(new 權重(32002, 545));
    等級3附加潛能權重.add(new 權重(32003, 545));
    等級3附加潛能權重.add(new 權重(32004, 545));
    等級3附加潛能權重.add(new 權重(32005, 545));
    等級3附加潛能權重.add(new 權重(32006, 545));
    等級3附加潛能權重.add(new 權重(32011, 364));
    等級3附加潛能權重.add(new 權重(32012, 364));
    等級3附加潛能權重.add(new 權重(32013, 545));
    等級3附加潛能權重.add(new 權重(32041, 364));
    等級3附加潛能權重.add(new 權重(32042, 364));
    等級3附加潛能權重.add(new 權重(32043, 364));
    等級3附加潛能權重.add(new 權重(32044, 364));
    等級3附加潛能權重.add(new 權重(32045, 545));
    等級3附加潛能權重.add(new 權重(32046, 545));
    等級3附加潛能權重.add(new 權重(32055, 545));
    等級3附加潛能權重.add(new 權重(32086, 364));
    等級3附加潛能權重.add(new 權重(32551, 545));
    等級3附加潛能權重.add(new 權重(32091, 364));
    等級3附加潛能權重.add(new 權重(32092, 364));
    等級3附加潛能權重.add(new 權重(32093, 364));
    等級3附加潛能權重.add(new 權重(32094, 364));
    等級3附加潛能權重.add(new 權重(32111, 789));
    等級3附加潛能權重.add(new 權重(32116, 789));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();


    等級4附加潛能權重.add(new 權重(42001, 469));
    等級4附加潛能權重.add(new 權重(42002, 469));
    等級4附加潛能權重.add(new 權重(42003, 469));
    等級4附加潛能權重.add(new 權重(42004, 469));
    等級4附加潛能權重.add(new 權重(42005, 469));
    等級4附加潛能權重.add(new 權重(42006, 469));
    等級4附加潛能權重.add(new 權重(42011, 313));
    等級4附加潛能權重.add(new 權重(42012, 313));
    等級4附加潛能權重.add(new 權重(42013, 469));
    等級4附加潛能權重.add(new 權重(42041, 313));
    等級4附加潛能權重.add(new 權重(42042, 313));
    等級4附加潛能權重.add(new 權重(42043, 313));
    等級4附加潛能權重.add(new 權重(42044, 313));
    等級4附加潛能權重.add(new 權重(42045, 469));
    等級4附加潛能權重.add(new 權重(42046, 469));
    等級4附加潛能權重.add(new 權重(42055, 469));
    等級4附加潛能權重.add(new 權重(42086, 313));
    等級4附加潛能權重.add(new 權重(42091, 313));
    等級4附加潛能權重.add(new 權重(42092, 313));
    等級4附加潛能權重.add(new 權重(42093, 313));
    等級4附加潛能權重.add(new 權重(42094, 313));
    等級4附加潛能權重.add(new 權重(42501, 469));
    等級4附加潛能權重.add(new 權重(42094, 469));
    等級4附加潛能權重.add(new 權重(42650, 469));
    等級4附加潛能權重.add(new 權重(42656, 469));
    等級4附加潛能權重.add(new 權重(42106, 789));
    等級4附加潛能權重.add(new 權重(42111, 789));
    等級4附加潛能權重.add(new 權重(42116, 789));


    臉飾附加潛能權重Map.put(1, 等級1附加潛能權重);

    臉飾附加潛能權重Map.put(2, 等級2附加潛能權重);

    臉飾附加潛能權重Map.put(3, 等級3附加潛能權重);

    臉飾附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 臉飾附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 臉飾附加潛能權重Map.get(key))
      {
        System.out.println("加載臉飾的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載武器附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12005, 588));
    等級1附加潛能權重.add(new 權重(12006, 588));
    等級1附加潛能權重.add(new 權重(12009, 588));
    等級1附加潛能權重.add(new 權重(12010, 588));
    等級1附加潛能權重.add(new 權重(12013, 588));
    等級1附加潛能權重.add(new 權重(12015, 588));
    等級1附加潛能權重.add(new 權重(12016, 588));
    等級1附加潛能權重.add(new 權重(12017, 588));
    等級1附加潛能權重.add(new 權重(12018, 588));
    等級1附加潛能權重.add(new 權重(12019, 392));
    等級1附加潛能權重.add(new 權重(12020, 392));
    等級1附加潛能權重.add(new 權重(12045, 392));
    等級1附加潛能權重.add(new 權重(12046, 392));
    等級1附加潛能權重.add(new 權重(12047, 392));
    等級1附加潛能權重.add(new 權重(12048, 392));
    等級1附加潛能權重.add(new 權重(12049, 392));
    等級1附加潛能權重.add(new 權重(12050, 392));
    等級1附加潛能權重.add(new 權重(12051, 196));
    等級1附加潛能權重.add(new 權重(12052, 196));
    等級1附加潛能權重.add(new 權重(12055, 392));
    等級1附加潛能權重.add(new 權重(12070, 196));
    等級1附加潛能權重.add(new 權重(12082, 588));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22045, 882));
    等級2附加潛能權重.add(new 權重(22046, 882));
    等級2附加潛能權重.add(new 權重(22051, 588));
    等級2附加潛能權重.add(new 權重(22052, 588));
    等級2附加潛能權重.add(new 權重(22055, 294));
    等級2附加潛能權重.add(new 權重(22041, 882));
    等級2附加潛能權重.add(new 權重(22042, 882));
    等級2附加潛能權重.add(new 權重(22043, 882));
    等級2附加潛能權重.add(new 權重(22044, 882));
    等級2附加潛能權重.add(new 權重(22070, 294));
    等級2附加潛能權重.add(new 權重(22087, 588));
    等級2附加潛能權重.add(new 權重(22201, 882));
    等級2附加潛能權重.add(new 權重(22206, 882));
    等級2附加潛能權重.add(new 權重(22801, 588));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32045, 698));
    等級3附加潛能權重.add(new 權重(32046, 698));
    等級3附加潛能權重.add(new 權重(32051, 465));
    等級3附加潛能權重.add(new 權重(32053, 465));
    等級3附加潛能權重.add(new 權重(32057, 465));
    等級3附加潛能權重.add(new 權重(32041, 698));
    等級3附加潛能權重.add(new 權重(32042, 698));
    等級3附加潛能權重.add(new 權重(32043, 698));
    等級3附加潛能權重.add(new 權重(32044, 698));
    等級3附加潛能權重.add(new 權重(32070, 233));
    等級3附加潛能權重.add(new 權重(32087, 465));
    等級3附加潛能權重.add(new 權重(32291, 233));
    等級3附加潛能權重.add(new 權重(32601, 233));
    等級3附加潛能權重.add(new 權重(32201, 698));
    等級3附加潛能權重.add(new 權重(32206, 698));
    等級3附加潛能權重.add(new 權重(32091, 465));
    等級3附加潛能權重.add(new 權重(32092, 465));
    等級3附加潛能權重.add(new 權重(32093, 465));
    等級3附加潛能權重.add(new 權重(32094, 465));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42045, 769));
    等級4附加潛能權重.add(new 權重(42046, 769));
    等級4附加潛能權重.add(new 權重(42051, 513));
    等級4附加潛能權重.add(new 權重(42053, 513));
    等級4附加潛能權重.add(new 權重(42057, 513));
    等級4附加潛能權重.add(new 權重(42041, 769));
    等級4附加潛能權重.add(new 權重(42042, 769));
    等級4附加潛能權重.add(new 權重(42043, 769));
    等級4附加潛能權重.add(new 權重(42044, 769));
    等級4附加潛能權重.add(new 權重(42070, 256));
    等級4附加潛能權重.add(new 權重(42087, 513));
    等級4附加潛能權重.add(new 權重(42292, 256));
    等級4附加潛能權重.add(new 權重(42601, 256));
    等級4附加潛能權重.add(new 權重(42091, 513));
    等級4附加潛能權重.add(new 權重(42092, 513));
    等級4附加潛能權重.add(new 權重(42093, 513));
    等級4附加潛能權重.add(new 權重(42094, 513));
    等級4附加潛能權重.add(new 權重(42095, 256));
    等級4附加潛能權重.add(new 權重(42096, 256));


    武器附加潛能權重Map.put(1, 等級1附加潛能權重);

    武器附加潛能權重Map.put(2, 等級2附加潛能權重);

    武器附加潛能權重Map.put(3, 等級3附加潛能權重);

    武器附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 武器附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 武器附加潛能權重Map.get(key))
      {
        System.out.println("加載武器的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載副手武器附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12005, 588));
    等級1附加潛能權重.add(new 權重(12006, 588));
    等級1附加潛能權重.add(new 權重(12009, 588));
    等級1附加潛能權重.add(new 權重(12010, 588));
    等級1附加潛能權重.add(new 權重(12013, 588));
    等級1附加潛能權重.add(new 權重(12015, 588));
    等級1附加潛能權重.add(new 權重(12016, 588));
    等級1附加潛能權重.add(new 權重(12017, 588));
    等級1附加潛能權重.add(new 權重(12018, 588));
    等級1附加潛能權重.add(new 權重(12019, 392));
    等級1附加潛能權重.add(new 權重(12020, 392));
    等級1附加潛能權重.add(new 權重(12045, 392));
    等級1附加潛能權重.add(new 權重(12046, 392));
    等級1附加潛能權重.add(new 權重(12047, 392));
    等級1附加潛能權重.add(new 權重(12048, 392));
    等級1附加潛能權重.add(new 權重(12049, 392));
    等級1附加潛能權重.add(new 權重(12050, 392));
    等級1附加潛能權重.add(new 權重(12051, 196));
    等級1附加潛能權重.add(new 權重(12052, 196));
    等級1附加潛能權重.add(new 權重(12055, 392));
    等級1附加潛能權重.add(new 權重(12070, 196));
    等級1附加潛能權重.add(new 權重(12082, 588));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22045, 882));
    等級2附加潛能權重.add(new 權重(22046, 882));
    等級2附加潛能權重.add(new 權重(22051, 588));
    等級2附加潛能權重.add(new 權重(22052, 588));
    等級2附加潛能權重.add(new 權重(22055, 294));
    等級2附加潛能權重.add(new 權重(22041, 882));
    等級2附加潛能權重.add(new 權重(22042, 882));
    等級2附加潛能權重.add(new 權重(22043, 882));
    等級2附加潛能權重.add(new 權重(22044, 882));
    等級2附加潛能權重.add(new 權重(22070, 294));
    等級2附加潛能權重.add(new 權重(22087, 588));
    等級2附加潛能權重.add(new 權重(22201, 882));
    等級2附加潛能權重.add(new 權重(22206, 882));
    等級2附加潛能權重.add(new 權重(22801, 588));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32045, 698));
    等級3附加潛能權重.add(new 權重(32046, 698));
    等級3附加潛能權重.add(new 權重(32051, 465));
    等級3附加潛能權重.add(new 權重(32053, 465));
    等級3附加潛能權重.add(new 權重(32057, 465));
    等級3附加潛能權重.add(new 權重(32041, 698));
    等級3附加潛能權重.add(new 權重(32042, 698));
    等級3附加潛能權重.add(new 權重(32043, 698));
    等級3附加潛能權重.add(new 權重(32044, 698));
    等級3附加潛能權重.add(new 權重(32070, 233));
    等級3附加潛能權重.add(new 權重(32087, 465));
    等級3附加潛能權重.add(new 權重(32291, 233));
    等級3附加潛能權重.add(new 權重(32601, 233));
    等級3附加潛能權重.add(new 權重(32201, 698));
    等級3附加潛能權重.add(new 權重(32206, 698));
    等級3附加潛能權重.add(new 權重(32091, 465));
    等級3附加潛能權重.add(new 權重(32092, 465));
    等級3附加潛能權重.add(new 權重(32093, 465));
    等級3附加潛能權重.add(new 權重(32094, 465));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42045, 732));
    等級4附加潛能權重.add(new 權重(42046, 732));
    等級4附加潛能權重.add(new 權重(42051, 488));
    等級4附加潛能權重.add(new 權重(42053, 488));
    等級4附加潛能權重.add(new 權重(42057, 488));
    等級4附加潛能權重.add(new 權重(42062, 488));
    等級4附加潛能權重.add(new 權重(42041, 732));
    等級4附加潛能權重.add(new 權重(42042, 732));
    等級4附加潛能權重.add(new 權重(42043, 732));
    等級4附加潛能權重.add(new 權重(42044, 732));
    等級4附加潛能權重.add(new 權重(42070, 244));
    等級4附加潛能權重.add(new 權重(42087, 488));
    等級4附加潛能權重.add(new 權重(42292, 244));
    等級4附加潛能權重.add(new 權重(42601, 244));
    等級4附加潛能權重.add(new 權重(42091, 488));
    等級4附加潛能權重.add(new 權重(42092, 488));
    等級4附加潛能權重.add(new 權重(42093, 488));
    等級4附加潛能權重.add(new 權重(42094, 488));
    等級4附加潛能權重.add(new 權重(42095, 244));
    等級4附加潛能權重.add(new 權重(42096, 244));


    副手武器附加潛能權重Map.put(1, 等級1附加潛能權重);

    副手武器附加潛能權重Map.put(2, 等級2附加潛能權重);

    副手武器附加潛能權重Map.put(3, 等級3附加潛能權重);

    副手武器附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 副手武器附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 副手武器附加潛能權重Map.get(key))
      {
        System.out.println("加載副手武器的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  private static void 加載徽章附加潛能權重 ()
  {
    ArrayList<權重> 等級1附加潛能權重 = new ArrayList<>();

    等級1附加潛能權重.add(new 權重(12005, 588));
    等級1附加潛能權重.add(new 權重(12006, 588));
    等級1附加潛能權重.add(new 權重(12009, 588));
    等級1附加潛能權重.add(new 權重(12010, 588));
    等級1附加潛能權重.add(new 權重(12013, 588));
    等級1附加潛能權重.add(new 權重(12015, 588));
    等級1附加潛能權重.add(new 權重(12016, 588));
    等級1附加潛能權重.add(new 權重(12017, 588));
    等級1附加潛能權重.add(new 權重(12018, 588));
    等級1附加潛能權重.add(new 權重(12019, 392));
    等級1附加潛能權重.add(new 權重(12020, 392));
    等級1附加潛能權重.add(new 權重(12045, 392));
    等級1附加潛能權重.add(new 權重(12046, 392));
    等級1附加潛能權重.add(new 權重(12047, 392));
    等級1附加潛能權重.add(new 權重(12048, 392));
    等級1附加潛能權重.add(new 權重(12049, 392));
    等級1附加潛能權重.add(new 權重(12050, 392));
    等級1附加潛能權重.add(new 權重(12051, 196));
    等級1附加潛能權重.add(new 權重(12052, 196));
    等級1附加潛能權重.add(new 權重(12055, 392));
    等級1附加潛能權重.add(new 權重(12070, 196));
    等級1附加潛能權重.add(new 權重(12082, 588));

    ArrayList<權重> 等級2附加潛能權重 = new ArrayList<>();

    等級2附加潛能權重.add(new 權重(22045, 882));
    等級2附加潛能權重.add(new 權重(22046, 882));
    等級2附加潛能權重.add(new 權重(22051, 588));
    等級2附加潛能權重.add(new 權重(22052, 588));
    等級2附加潛能權重.add(new 權重(22055, 294));
    等級2附加潛能權重.add(new 權重(22041, 882));
    等級2附加潛能權重.add(new 權重(22042, 882));
    等級2附加潛能權重.add(new 權重(22043, 882));
    等級2附加潛能權重.add(new 權重(22044, 882));
    等級2附加潛能權重.add(new 權重(22070, 294));
    等級2附加潛能權重.add(new 權重(22087, 588));
    等級2附加潛能權重.add(new 權重(22201, 882));
    等級2附加潛能權重.add(new 權重(22206, 882));
    等級2附加潛能權重.add(new 權重(22801, 588));

    ArrayList<權重> 等級3附加潛能權重 = new ArrayList<>();

    等級3附加潛能權重.add(new 權重(32045, 714));
    等級3附加潛能權重.add(new 權重(32046, 714));
    等級3附加潛能權重.add(new 權重(32051, 476));
    等級3附加潛能權重.add(new 權重(32053, 476));
    等級3附加潛能權重.add(new 權重(32057, 476));
    等級3附加潛能權重.add(new 權重(32041, 714));
    等級3附加潛能權重.add(new 權重(32042, 714));
    等級3附加潛能權重.add(new 權重(32043, 714));
    等級3附加潛能權重.add(new 權重(32044, 714));
    等級3附加潛能權重.add(new 權重(32070, 238));
    等級3附加潛能權重.add(new 權重(32087, 476));
    等級3附加潛能權重.add(new 權重(32291, 238));
    等級3附加潛能權重.add(new 權重(32201, 714));
    等級3附加潛能權重.add(new 權重(32206, 714));
    等級3附加潛能權重.add(new 權重(32091, 476));
    等級3附加潛能權重.add(new 權重(32092, 476));
    等級3附加潛能權重.add(new 權重(32093, 476));
    等級3附加潛能權重.add(new 權重(32094, 476));

    ArrayList<權重> 等級4附加潛能權重 = new ArrayList<>();

    等級4附加潛能權重.add(new 權重(42045, 789));
    等級4附加潛能權重.add(new 權重(42046, 789));
    等級4附加潛能權重.add(new 權重(42051, 526));
    等級4附加潛能權重.add(new 權重(42053, 526));
    等級4附加潛能權重.add(new 權重(42057, 526));
    等級4附加潛能權重.add(new 權重(42041, 789));
    等級4附加潛能權重.add(new 權重(42042, 789));
    等級4附加潛能權重.add(new 權重(42043, 789));
    等級4附加潛能權重.add(new 權重(42044, 789));
    等級4附加潛能權重.add(new 權重(42070, 263));
    等級4附加潛能權重.add(new 權重(42087, 526));
    等級4附加潛能權重.add(new 權重(42292, 263));
    等級4附加潛能權重.add(new 權重(42091, 526));
    等級4附加潛能權重.add(new 權重(42092, 526));
    等級4附加潛能權重.add(new 權重(42093, 526));
    等級4附加潛能權重.add(new 權重(42094, 526));
    等級4附加潛能權重.add(new 權重(42095, 263));
    等級4附加潛能權重.add(new 權重(42096, 263));


    徽章附加潛能權重Map.put(1, 等級1附加潛能權重);

    徽章附加潛能權重Map.put(2, 等級2附加潛能權重);

    徽章附加潛能權重Map.put(3, 等級3附加潛能權重);

    徽章附加潛能權重Map.put(4, 等級4附加潛能權重);

    for (Integer key : 徽章附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 徽章附加潛能權重Map.get(key))
      {
        System.out.println("加載徽章的附加潛能權重緩存數據! 潛能id = " + 權重數據.獲取值() + "; 潛能權重 = " + 權重數據.獲取權重() + "; 潛能名稱 = " + itemInformationProvider.獲取潛能名稱(權重數據.獲取值()));
      }
    }
  }

  public static void 加載裝備附加潛能權重 ()
  {
    加載頭盔附加潛能權重();
    加載上衣附加潛能權重();
    加載套服附加潛能權重();
    加載下衣附加潛能權重();
    加載鞋子附加潛能權重();
    加載手套附加潛能權重();
    加載披風附加潛能權重();
    加載護肩附加潛能權重();
    加載腰帶附加潛能權重();
    加載戒指附加潛能權重();
    加載耳環附加潛能權重();
    加載吊墜附加潛能權重();
    加載眼飾附加潛能權重();
    加載臉飾附加潛能權重();
    加載心臟附加潛能權重();
    加載武器附加潛能權重();
    加載副手武器附加潛能權重();
    加載徽章附加潛能權重();
    附加潛能數據檢查();
  }

  private static void 附加潛能數據檢查 ()
  {
    for (Integer key : 頭盔附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 頭盔附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查頭盔附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 上衣附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 上衣附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查上衣附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 下衣附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 下衣附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查下衣附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 套服附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 套服附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查套服附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 手套附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 手套附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查手套附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 披風附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 披風附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查披風附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 鞋子附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 鞋子附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查鞋子附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 護肩附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 護肩附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查護肩附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 腰帶附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 腰帶附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查腰帶附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 戒指附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 戒指附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查戒指附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 耳環附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 耳環附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查耳環附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 心臟附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 心臟附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查心臟附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 眼飾附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 眼飾附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查眼飾附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 臉飾附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 臉飾附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查臉飾附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 武器附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 武器附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查武器附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 副手武器附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 副手武器附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查副手武器附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 徽章附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 徽章附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查徽章附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }

    for (Integer key : 吊墜附加潛能權重Map.keySet())
    {
      for (權重 權重數據 : 吊墜附加潛能權重Map.get(key))
      {
        int 潛能id = 權重數據.獲取值();
        if (潛能id <= key * 10000 || 潛能id >= (key + 1) * 10000 || 潛能id <= key * 10000 + 2000)
        {
          System.out.println("檢查吊墜附加潛能權重時發現錯誤的潛能id, 潛能id = " + 潛能id + "; 潛能等級 = " + key);
        }
      }
    }
  }

  public static boolean 檢查裝備潛能2是否合法 (Equip 需要檢查的裝備)
  {
    int 潛能1Id = 需要檢查的裝備.getPotential1();

    int 潛能2Id = 需要檢查的裝備.getPotential2();

    int count = 0;

    if (添加技能潛能列表.contains(潛能1Id))
    {
      count += 1;
    }

    if (添加技能潛能列表.contains(潛能2Id))
    {
      count += 1;
    }

    if (count > 1)
    {
      return false;
    }

    return true;
  }

  public static boolean 檢查裝備潛能3是否合法 (Equip 需要檢查的裝備)
  {
    int 潛能1Id = 需要檢查的裝備.getPotential1();

    int 潛能2Id = 需要檢查的裝備.getPotential2();

    int 潛能3Id = 需要檢查的裝備.getPotential3();


    int count = 0;

    if (添加技能潛能列表.contains(潛能1Id))
    {
      count += 1;
    }

    if (添加技能潛能列表.contains(潛能2Id))
    {
      count += 1;
    }

    if (添加技能潛能列表.contains(潛能3Id))
    {
      count += 1;
    }

    if (count > 1)
    {
      return false;
    }

    count = 0;

    if (無視防禦力潛能列表.contains(潛能1Id))
    {
      count += 1;
    }

    if (無視防禦力潛能列表.contains(潛能2Id))
    {
      count += 1;
    }

    if (無視防禦力潛能列表.contains(潛能3Id))
    {
      count += 1;
    }

    if (count > 2)
    {
      return false;
    }

    count = 0;

    if (BOSS傷害潛能列表.contains(潛能1Id))
    {
      count += 1;
    }

    if (BOSS傷害潛能列表.contains(潛能2Id))
    {
      count += 1;
    }

    if (BOSS傷害潛能列表.contains(潛能3Id))
    {
      count += 1;
    }

    if (count > 2)
    {
      return false;
    }

    count = 0;

    if (掉落率潛能列表.contains(潛能1Id))
    {
      count += 1;
    }

    if (掉落率潛能列表.contains(潛能2Id))
    {
      count += 1;
    }

    if (掉落率潛能列表.contains(潛能3Id))
    {
      count += 1;
    }

    if (count > 2)
    {
      return false;
    }

    count = 0;

    if (楓幣數量潛能列表.contains(潛能1Id))
    {
      count += 1;
    }

    if (楓幣數量潛能列表.contains(潛能2Id))
    {
      count += 1;
    }

    if (楓幣數量潛能列表.contains(潛能3Id))
    {
      count += 1;
    }

    if (count > 2)
    {
      return false;
    }

    return true;
  }

  public static boolean 是添加技能的潛能 (int 潛能Id)
  {
    return 添加技能潛能列表.contains(潛能Id);
  }
}
