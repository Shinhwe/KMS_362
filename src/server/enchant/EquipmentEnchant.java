package server.enchant;

import client.MapleClient;
import client.inventory.*;
import constants.GameConstants;
import constants.ServerConstants;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.Randomizer;
import tools.Pair;
import tools.data.LittleEndianAccessor;
import tools.packet.CWvsContext;

import java.util.ArrayList;
import java.util.Calendar;
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
  
  public static void checkEquipmentStats(MapleClient c, Equip equip)
  {
    boolean changed = false;
    if (equip == null)
    {
      return;
    }
    Equip item = (Equip) MapleItemInformationProvider.getInstance().getEquipById(equip.getItemId(), false);
    if (MapleItemInformationProvider.getInstance().getName(equip.getItemId()).startsWith("제네시스"))
    {
      item.setEnchantWatk((short) 0);
      item.setEnchantMatk((short) 0);
      item.setEnchantStr((short) 0);
      item.setEnchantDex((short) 0);
      item.setEnchantInt((short) 0);
      item.setEnchantLuk((short) 0);
      item.setEnchantWdef((short) 0);
      item.setEnchantMdef((short) 0);
      item.setEnchantHp((short) 0);
      item.setEnchantMp((short) 0);
      item.setEnchantAcc((short) 0);
      item.setEnchantAvoid((short) 0);
      return;
    }
    if ((equip.getEquipmentType() & 0x1700) == 5888)
    {
      return;
    }
    item.setStr(equip.getStr());
    item.setDex(equip.getDex());
    item.setInt(equip.getInt());
    item.setLuk(equip.getLuk());
    item.setHp(equip.getHp());
    item.setMp(equip.getMp());
    item.setWatk(equip.getWatk());
    item.setMatk(equip.getMatk());
    item.setWdef(equip.getWdef());
    item.setMdef(equip.getMdef());
    item.setAcc(equip.getAcc());
    item.setAvoid(equip.getAvoid());
    item.setFire(equip.getFire());
    int max = equip.getEnhance();
    while (item.getEnhance() < max)
    {
      StarForceStats statz = starForceStats(item);
      item.setEnchantBuff((short) 0);
      item.setEnhance((byte) (item.getEnhance() + 1));
      for (Pair<EnchantFlag, Integer> stat : statz.getStats())
      {
        if (EnchantFlag.Watk.check(stat.left.getValue()))
        {
          item.setEnchantWatk((short) (item.getEnchantWatk() + stat.right.intValue()));
        }
        if (EnchantFlag.Matk.check(stat.left.getValue()))
        {
          item.setEnchantMatk((short) (item.getEnchantMatk() + stat.right.intValue()));
        }
        if (EnchantFlag.Str.check(stat.left.getValue()))
        {
          item.setEnchantStr((short) (item.getEnchantStr() + stat.right.intValue()));
        }
        if (EnchantFlag.Dex.check(stat.left.getValue()))
        {
          item.setEnchantDex((short) (item.getEnchantDex() + stat.right.intValue()));
        }
        if (EnchantFlag.Int.check(stat.left.getValue()))
        {
          item.setEnchantInt((short) (item.getEnchantInt() + stat.right.intValue()));
        }
        if (EnchantFlag.Luk.check(stat.left.getValue()))
        {
          item.setEnchantLuk((short) (item.getEnchantLuk() + stat.right.intValue()));
        }
        if (EnchantFlag.Wdef.check(stat.left.getValue()))
        {
          item.setEnchantWdef((short) (item.getEnchantWdef() + stat.right.intValue()));
        }
        if (EnchantFlag.Mdef.check(stat.left.getValue()))
        {
          item.setEnchantMdef((short) (item.getEnchantMdef() + stat.right.intValue()));
        }
        if (EnchantFlag.Hp.check(stat.left.getValue()))
        {
          item.setEnchantHp((short) (item.getEnchantHp() + stat.right.intValue()));
        }
        if (EnchantFlag.Mp.check(stat.left.getValue()))
        {
          item.setEnchantMp((short) (item.getEnchantMp() + stat.right.intValue()));
        }
        if (EnchantFlag.Acc.check(stat.left.getValue()))
        {
          item.setEnchantAcc((short) (item.getEnchantAcc() + stat.right.intValue()));
        }
        if (EnchantFlag.Avoid.check(stat.left.getValue()))
        {
          item.setEnchantAvoid((short) (item.getEnchantAvoid() + stat.right.intValue()));
        }
      }
    }
    if (equip.getEnchantStr() != item.getEnchantStr())
    {
      changed = true;
      equip.setEnchantStr(item.getEnchantStr());
    }
    if (equip.getEnchantDex() != item.getEnchantDex())
    {
      changed = true;
      equip.setEnchantDex(item.getEnchantDex());
    }
    if (equip.getEnchantInt() != item.getEnchantInt())
    {
      changed = true;
      equip.setEnchantInt(item.getEnchantInt());
    }
    if (equip.getEnchantLuk() != item.getEnchantLuk())
    {
      changed = true;
      equip.setEnchantLuk(item.getEnchantLuk());
    }
    if (equip.getEnchantHp() != item.getEnchantHp())
    {
      changed = true;
      equip.setEnchantHp(item.getEnchantHp());
    }
    if (equip.getEnchantMp() != item.getEnchantMp())
    {
      changed = true;
      equip.setEnchantMp(item.getEnchantMp());
    }
    if (equip.getEnchantWatk() != item.getEnchantWatk())
    {
      changed = true;
      equip.setEnchantWatk(item.getEnchantWatk());
    }
    if (equip.getEnchantMatk() != item.getEnchantMatk())
    {
      changed = true;
      equip.setEnchantMatk(item.getEnchantMatk());
    }
    if (equip.getEnchantWdef() != item.getEnchantWdef())
    {
      changed = true;
      equip.setEnchantWdef(item.getEnchantWdef());
    }
    if (equip.getEnchantMdef() != item.getEnchantMdef())
    {
      changed = true;
      equip.setEnchantMdef(item.getEnchantMdef());
    }
    if (equip.getEnchantAcc() != item.getEnchantAcc())
    {
      changed = true;
      equip.setEnchantAcc(item.getEnchantAcc());
    }
    if (equip.getEnchantAvoid() != item.getEnchantAvoid())
    {
      changed = true;
      equip.setEnchantAvoid(item.getEnchantAvoid());
    }
    if (!changed || c != null) ;
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
  
  public static int addExtra(int enhance)
  {
    int extra = 0;
    if (enhance < 5)
    {
      for (int i = 0; i < enhance; i++)
      {
        extra += i + 1;
      }
    }
    else if (enhance < 10)
    {
      for (int i = 0; i < enhance - 5; i++)
      {
        extra++;
      }
    }
    else if (enhance < 15)
    {
      for (int i = 0; i < enhance - 10; i++)
      {
        extra += 2;
      }
    }
    return extra;
  }
  
  public static StarForceStats starForceStats(Equip item)
  {
    // TODO: Visible DEF +5% is not yet implemented
    MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
    int reqLevel = ii.getReqLevel(item.getItemId());
    List<Pair<EnchantFlag, Integer>> stats = new ArrayList<>();
    MapleWeaponType weaponType = GameConstants.getWeaponType(item.getItemId());
    int currentStar = item.getEnhance();
    int nextStar = currentStar + 1;
    byte equipLevel = item.getReqLevel();
    
    if ((ii.isSuperial(item.getItemId())).right.booleanValue())
    {
      // check https://strategywiki.org/wiki/MapleStory/Spell_Trace_and_Star_Force#Superior_Items
      
      // TODO: every star should add Visible DEF +5%
      if (currentStar < 5)
      {
        if (equipLevel == 80)
        {
          // Heliseum
          int[] statusArr = new int[]{2, 3, 5};
          stats.add(new Pair<>(EnchantFlag.Str, statusArr[currentStar]));
          stats.add(new Pair<>(EnchantFlag.Dex, statusArr[currentStar]));
          stats.add(new Pair<>(EnchantFlag.Int, statusArr[currentStar]));
          stats.add(new Pair<>(EnchantFlag.Luk, statusArr[currentStar]));
        }
        else if (equipLevel == 110)
        {
          // Nova
          int[] statusArr = new int[]{9, 10, 12, 15, 19};
          stats.add(new Pair<>(EnchantFlag.Str, statusArr[currentStar]));
          stats.add(new Pair<>(EnchantFlag.Dex, statusArr[currentStar]));
          stats.add(new Pair<>(EnchantFlag.Int, statusArr[currentStar]));
          stats.add(new Pair<>(EnchantFlag.Luk, statusArr[currentStar]));
        }
        else if (equipLevel >= 150)
        {
          // Tyrant and MindPendent
          int[] statusArr = new int[]{19, 20, 22, 25, 29};
          stats.add(new Pair<>(EnchantFlag.Str, statusArr[currentStar]));
          stats.add(new Pair<>(EnchantFlag.Dex, statusArr[currentStar]));
          stats.add(new Pair<>(EnchantFlag.Int, statusArr[currentStar]));
          stats.add(new Pair<>(EnchantFlag.Luk, statusArr[currentStar]));
        }
      }
      else
      {
        // Heliseum only 3 star
        if (equipLevel == 110)
        {
          // Nova 10 star
          int[] statusArr = new int[]{5, 6, 7, 9, 10};
          stats.add(new Pair<>(EnchantFlag.Watk, statusArr[currentStar]));
          stats.add(new Pair<>(EnchantFlag.Matk, statusArr[currentStar]));
        }
        else if (equipLevel == 110)
        {
          // Tyrant and MindPendent 15 star
          int[] statusArr = new int[]{9, 10, 11, 12, 13, 15, 17, 19, 21, 23};
          stats.add(new Pair<>(EnchantFlag.Watk, statusArr[currentStar]));
          stats.add(new Pair<>(EnchantFlag.Matk, statusArr[currentStar]));
        }
      }
    }
    else
    {
      // check https://strategywiki.org/wiki/MapleStory/Spell_Trace_and_Star_Force#Normal_Equip
      if (currentStar < 5)
      {
        stats.add(new Pair<>(EnchantFlag.Str, Integer.valueOf(2)));
        stats.add(new Pair<>(EnchantFlag.Dex, Integer.valueOf(2)));
        stats.add(new Pair<>(EnchantFlag.Int, Integer.valueOf(2)));
        stats.add(new Pair<>(EnchantFlag.Luk, Integer.valueOf(2)));
        
        if (GameConstants.isGlove(item.getItemId()) && currentStar == 4)
        {
          stats.add(new Pair<>(EnchantFlag.Watk, Integer.valueOf(1)));
          stats.add(new Pair<>(EnchantFlag.Matk, Integer.valueOf(1)));
        }
        
        if(GameConstants.isCategoryA(item.getItemId())) {
        
        }
      }
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
    Pair<Integer, Integer> per;
    List<EquipmentScroll> ess;
    boolean bool1;
    int success;
    EquipmentScroll es;
    Equip equip2;
    int destroy, percent;
    Pair<Integer, Integer> pair1;
    int meso, i, down;
    Equip equip3;
    int j;
    StarForceStats stats;
    long l;
    int despoer;
    double rate;
    int result;
    MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
    byte type = slea.readByte();
    if (Calendar.getInstance().get(7) == 5)
    {
      ServerConstants.starForceSalePercent = 10;
    }
    else
    {
      ServerConstants.starForceSalePercent = 0;
    }
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
//                if (c.getPlayer().isGM())
//                    i = 1;
        if (c.getPlayer().haveItem(4001832, es.getJuhun()))
        {
          c.getPlayer().removeItem(4001832, -es.getJuhun());
        }
        else
        {
          return;
        }
        equip3 = (Equip) item.copy();
        if (i > 0)
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
              for (int k = 0; k < equip3.getEnhance(); k++)
              {
                StarForceStats starForceStats = starForceStats(item);
                item.setEnhance((byte) (item.getEnhance() + 1));
                if (equip1 != null)
                {
                  equip1.setEnhance((byte) (equip1.getEnhance() + 1));
                }
                for (Pair<EnchantFlag, Integer> stat : starForceStats.getStats())
                {
                  if (EnchantFlag.Watk.check(stat.left.getValue()))
                  {
                    item.setEnchantWatk((short) (item.getEnchantWatk() + stat.right.intValue()));
                    if (equip1 != null)
                    {
                      equip1.setEnchantWatk((short) (equip1.getEnchantWatk() + stat.right.intValue()));
                    }
                  }
                  if (EnchantFlag.Matk.check(stat.left.getValue()))
                  {
                    item.setEnchantMatk((short) (item.getEnchantMatk() + stat.right.intValue()));
                    if (equip1 != null)
                    {
                      equip1.setEnchantMatk((short) (equip1.getEnchantMatk() + stat.right.intValue()));
                    }
                  }
                  if (EnchantFlag.Str.check(stat.left.getValue()))
                  {
                    item.setEnchantStr((short) (item.getEnchantStr() + stat.right.intValue()));
                    if (equip1 != null)
                    {
                      equip1.setEnchantStr((short) (equip1.getEnchantStr() + stat.right.intValue()));
                    }
                  }
                  if (EnchantFlag.Dex.check(stat.left.getValue()))
                  {
                    item.setEnchantDex((short) (item.getEnchantDex() + stat.right.intValue()));
                    if (equip1 != null)
                    {
                      equip1.setEnchantDex((short) (equip1.getEnchantDex() + stat.right.intValue()));
                    }
                  }
                  if (EnchantFlag.Int.check(stat.left.getValue()))
                  {
                    item.setEnchantInt((short) (item.getEnchantInt() + stat.right.intValue()));
                    if (equip1 != null)
                    {
                      equip1.setEnchantInt((short) (equip1.getEnchantInt() + stat.right.intValue()));
                    }
                  }
                  if (EnchantFlag.Luk.check(stat.left.getValue()))
                  {
                    item.setEnchantLuk((short) (item.getEnchantLuk() + stat.right.intValue()));
                    if (equip1 != null)
                    {
                      equip1.setEnchantLuk((short) (equip1.getEnchantLuk() + stat.right.intValue()));
                    }
                  }
                  if (EnchantFlag.Wdef.check(stat.left.getValue()))
                  {
                    item.setEnchantWdef((short) (item.getEnchantWdef() + stat.right.intValue()));
                    if (equip1 != null)
                    {
                      equip1.setEnchantWdef((short) (equip1.getEnchantWdef() + stat.right.intValue()));
                    }
                  }
                  if (EnchantFlag.Mdef.check(stat.left.getValue()))
                  {
                    item.setEnchantMdef((short) (item.getEnchantMdef() + stat.right.intValue()));
                    if (equip1 != null)
                    {
                      equip1.setEnchantMdef((short) (equip1.getEnchantMdef() + stat.right.intValue()));
                    }
                  }
                  if (EnchantFlag.Hp.check(stat.left.getValue()))
                  {
                    item.setEnchantHp((short) (item.getEnchantHp() + stat.right.intValue()));
                    if (equip1 != null)
                    {
                      equip1.setEnchantHp((short) (equip1.getEnchantHp() + stat.right.intValue()));
                    }
                  }
                  if (EnchantFlag.Mp.check(stat.left.getValue()))
                  {
                    item.setEnchantMp((short) (item.getEnchantMp() + stat.right.intValue()));
                    if (equip1 != null)
                    {
                      equip1.setEnchantMp((short) (equip1.getEnchantMp() + stat.right.intValue()));
                    }
                  }
                  if (EnchantFlag.Acc.check(stat.left.getValue()))
                  {
                    item.setEnchantAcc((short) (item.getEnchantAcc() + stat.right.intValue()));
                    if (equip1 != null)
                    {
                      equip1.setEnchantAcc((short) (equip1.getEnchantAcc() + stat.right.intValue()));
                    }
                  }
                  if (EnchantFlag.Avoid.check(stat.left.getValue()))
                  {
                    item.setEnchantAvoid((short) (item.getEnchantAvoid() + stat.right.intValue()));
                    if (equip1 != null)
                    {
                      equip1.setEnchantAvoid((short) (equip1.getEnchantAvoid() + stat.right.intValue()));
                    }
                  }
                }
              }
            }
          }
          else if (scrollType(es.getName()) == 5)
          {
            item.setUpgradeSlots((byte) (item.getUpgradeSlots() + 1));
            if (equip1 != null)
            {
              equip1.setUpgradeSlots((byte) (equip1.getUpgradeSlots() + 1));
            }
            c.getSession().writeAndFlush(CWvsContext.equipmentEnchantResult(50, item, null, null, null));
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
        checkEquipmentStats(c, item);
        if (equip1 != null)
        {
          checkEquipmentStats(c, equip1);
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
        bool1 = (c.getPlayer()).shield;
        equip2 = (Equip) item.copy();
        pair1 = starForcePercent(item);
        i = pair1.left.intValue();
        j = pair1.right.intValue();
        l = StarForceMeso(item);
        rate = (100 - ServerConstants.starForceSalePercent) / 100.0D;
        l = (long) (l * rate);
        if (l < 0L)
        {
          l &= 0xFFFFFFFFL;
        }
        if (catchStar == 1)
        {
          i += 45;
        }
        if (bool1)
        {
          j = 0;
        }
        if (c.getPlayer().isGM())
        {
          i = 1000;
        }
        if (item.getEnhance() < 22)
        {
          if (c.getPlayer().haveItem(4310021))
          {
            c.getPlayer().gainItem(4310021, (short) -1, false, 0L, "");
            i += 100;
          }
          else if (c.getPlayer().haveItem(4310019))
          {
            c.getPlayer().gainItem(4310019, (short) -1, false, 0L, "");
            i += 50;
          }
        }
        if (i >= 1000)
        {
          i = 1000;
        }
        if (c.getPlayer().getMeso() < l)
        {
          c.getPlayer().dropMessage(1, "메소가 부족합니다.");
          return;
        }
        c.getPlayer().gainMeso(-l, false);
        if (bool1)
        {
          c.getPlayer().gainMeso(-l, false);
        }
        if ((item.getEnchantBuff() & 0x20) != 0)
        {
          i = 1000;
          j = 0;
        }
        if (Randomizer.nextInt(1000) < i)
        {
          StarForceStats starForceStats = starForceStats(item);
          item.setEnhance((byte) (item.getEnhance() + 1));
          if (item2 != null)
          {
            item2.setEnhance((byte) (item2.getEnhance() + 1));
          }
          result = 1;
          for (Pair<EnchantFlag, Integer> stat : starForceStats.getStats())
          {
            if (EnchantFlag.Watk.check(stat.left.getValue()))
            {
              item.setEnchantWatk((short) (item.getEnchantWatk() + stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantWatk((short) (item2.getEnchantWatk() + stat.right.intValue()));
              }
            }
            if (EnchantFlag.Matk.check(stat.left.getValue()))
            {
              item.setEnchantMatk((short) (item.getEnchantMatk() + stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantMatk((short) (item2.getEnchantMatk() + stat.right.intValue()));
              }
            }
            if (EnchantFlag.Str.check(stat.left.getValue()))
            {
              item.setEnchantStr((short) (item.getEnchantStr() + stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantStr((short) (item2.getEnchantStr() + stat.right.intValue()));
              }
            }
            if (EnchantFlag.Dex.check(stat.left.getValue()))
            {
              item.setEnchantDex((short) (item.getEnchantDex() + stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantDex((short) (item2.getEnchantDex() + stat.right.intValue()));
              }
            }
            if (EnchantFlag.Int.check(stat.left.getValue()))
            {
              item.setEnchantInt((short) (item.getEnchantInt() + stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantInt((short) (item2.getEnchantInt() + stat.right.intValue()));
              }
            }
            if (EnchantFlag.Luk.check(stat.left.getValue()))
            {
              item.setEnchantLuk((short) (item.getEnchantLuk() + stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantLuk((short) (item2.getEnchantLuk() + stat.right.intValue()));
              }
            }
            if (EnchantFlag.Wdef.check(stat.left.getValue()))
            {
              item.setEnchantWdef((short) (item.getEnchantWdef() + stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantWdef((short) (item2.getEnchantWdef() + stat.right.intValue()));
              }
            }
            if (EnchantFlag.Mdef.check(stat.left.getValue()))
            {
              item.setEnchantMdef((short) (item.getEnchantMdef() + stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantMdef((short) (item2.getEnchantMdef() + stat.right.intValue()));
              }
            }
            if (EnchantFlag.Hp.check(stat.left.getValue()))
            {
              item.setEnchantHp((short) (item.getEnchantHp() + stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantHp((short) (item2.getEnchantHp() + stat.right.intValue()));
              }
            }
            if (EnchantFlag.Mp.check(stat.left.getValue()))
            {
              item.setEnchantMp((short) (item.getEnchantMp() + stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantMp((short) (item2.getEnchantMp() + stat.right.intValue()));
              }
            }
            if (EnchantFlag.Acc.check(stat.left.getValue()))
            {
              item.setEnchantAcc((short) (item.getEnchantAcc() + stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantAcc((short) (item2.getEnchantAcc() + stat.right.intValue()));
              }
            }
            if (EnchantFlag.Avoid.check(stat.left.getValue()))
            {
              item.setEnchantAvoid((short) (item.getEnchantAvoid() + stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantAvoid((short) (item2.getEnchantAvoid() + stat.right.intValue()));
              }
            }
          }
          if ((item.getEnchantBuff() & 0x20) != 0)
          {
            item.setEnchantBuff((short) (item.getEnchantBuff() - 32));
            if (item2 != null && (item2.getEnchantBuff() & 0x20) != 0)
            {
              item2.setEnchantBuff((short) (item2.getEnchantBuff() - 32));
            }
          }
          if ((item.getEnchantBuff() & 0x10) != 0)
          {
            item.setEnchantBuff((short) (item.getEnchantBuff() - 16));
            if (item2 != null && (item2.getEnchantBuff() & 0x10) != 0)
            {
              item2.setEnchantBuff((short) (item2.getEnchantBuff() - 16));
            }
          }
          checkEquipmentStats(c, item);
          if (item2 != null)
          {
            checkEquipmentStats(c, item2);
          }
        }
        else if (Randomizer.nextInt(1000) < j)
        {
          result = 2;
          while (item.getEnhance() > ((ii.isSuperial(item.getItemId())).right.booleanValue() ? 0 : 12))
          {
            item.setEnhance((byte) (item.getEnhance() - 1));
            if (item2 != null)
            {
              item2.setEnhance((byte) (item2.getEnhance() - 1));
            }
            StarForceStats starForceStats = starForceStats(item);
            for (Pair<EnchantFlag, Integer> stat : starForceStats.getStats())
            {
              if (EnchantFlag.Watk.check(stat.left.getValue()))
              {
                item.setEnchantWatk((short) (item.getEnchantWatk() - stat.right.intValue()));
                if (item2 != null)
                {
                  item2.setEnchantWatk((short) (item2.getEnchantWatk() - stat.right.intValue()));
                }
              }
              if (EnchantFlag.Matk.check(stat.left.getValue()))
              {
                item.setEnchantMatk((short) (item.getEnchantMatk() - stat.right.intValue()));
                if (item2 != null)
                {
                  item2.setEnchantMatk((short) (item2.getEnchantMatk() - stat.right.intValue()));
                }
              }
              if (EnchantFlag.Str.check(stat.left.getValue()))
              {
                item.setEnchantStr((short) (item.getEnchantStr() - stat.right.intValue()));
                if (item2 != null)
                {
                  item2.setEnchantStr((short) (item2.getEnchantStr() - stat.right.intValue()));
                }
              }
              if (EnchantFlag.Dex.check(stat.left.getValue()))
              {
                item.setEnchantDex((short) (item.getEnchantDex() - stat.right.intValue()));
                if (item2 != null)
                {
                  item2.setEnchantDex((short) (item2.getEnchantDex() - stat.right.intValue()));
                }
              }
              if (EnchantFlag.Int.check(stat.left.getValue()))
              {
                item.setEnchantInt((short) (item.getEnchantInt() - stat.right.intValue()));
                if (item2 != null)
                {
                  item2.setEnchantInt((short) (item2.getEnchantInt() - stat.right.intValue()));
                }
              }
              if (EnchantFlag.Luk.check(stat.left.getValue()))
              {
                item.setEnchantLuk((short) (item.getEnchantLuk() - stat.right.intValue()));
                if (item2 != null)
                {
                  item2.setEnchantLuk((short) (item2.getEnchantLuk() - stat.right.intValue()));
                }
              }
              if (EnchantFlag.Wdef.check(stat.left.getValue()))
              {
                item.setEnchantWdef((short) (item.getEnchantWdef() - stat.right.intValue()));
                if (item2 != null)
                {
                  item2.setEnchantWdef((short) (item2.getEnchantWdef() - stat.right.intValue()));
                }
              }
              if (EnchantFlag.Mdef.check(stat.left.getValue()))
              {
                item.setEnchantMdef((short) (item.getEnchantMdef() - stat.right.intValue()));
                if (item2 != null)
                {
                  item2.setEnchantMdef((short) (item2.getEnchantMdef() - stat.right.intValue()));
                }
              }
              if (EnchantFlag.Hp.check(stat.left.getValue()))
              {
                item.setEnchantHp((short) (item.getEnchantHp() - stat.right.intValue()));
                if (item2 != null)
                {
                  item2.setEnchantHp((short) (item2.getEnchantHp() - stat.right.intValue()));
                }
              }
              if (EnchantFlag.Mp.check(stat.left.getValue()))
              {
                item.setEnchantMp((short) (item.getEnchantMp() - stat.right.intValue()));
                if (item2 != null)
                {
                  item2.setEnchantMp((short) (item2.getEnchantMp() - stat.right.intValue()));
                }
              }
              if (EnchantFlag.Acc.check(stat.left.getValue()))
              {
                item.setEnchantAcc((short) (item.getEnchantAcc() - stat.right.intValue()));
                if (item2 != null)
                {
                  item2.setEnchantAcc((short) (item2.getEnchantAcc() - stat.right.intValue()));
                }
              }
              if (EnchantFlag.Avoid.check(stat.left.getValue()))
              {
                item.setEnchantAvoid((short) (item.getEnchantAvoid() - stat.right.intValue()));
                if (item2 != null)
                {
                  item2.setEnchantAvoid((short) (item2.getEnchantAvoid() - stat.right.intValue()));
                }
              }
            }
          }
          item.setEnchantBuff((short) 136);
          if (item2 != null)
          {
            item2.setEnchantBuff((short) 136);
          }
          checkEquipmentStats(c, item);
          if (item2 != null)
          {
            checkEquipmentStats(c, item2);
          }
        }
        else if (((ii.isSuperial(item.getItemId())).right.booleanValue() || item.getEnhance() > 10) && item.getEnhance() % 5 != 0)
        {
          result = 0;
          item.setEnhance((byte) (item.getEnhance() - 1));
          if (item2 != null)
          {
            item2.setEnhance((byte) (item2.getEnhance() - 1));
          }
          StarForceStats starForceStats = starForceStats(item);
          for (Pair<EnchantFlag, Integer> stat : starForceStats.getStats())
          {
            if (EnchantFlag.Watk.check(stat.left.getValue()))
            {
              item.setEnchantWatk((short) (item.getEnchantWatk() - stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantWatk((short) (item2.getEnchantWatk() - stat.right.intValue()));
              }
            }
            if (EnchantFlag.Matk.check(stat.left.getValue()))
            {
              item.setEnchantMatk((short) (item.getEnchantMatk() - stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantMatk((short) (item2.getEnchantMatk() - stat.right.intValue()));
              }
            }
            if (EnchantFlag.Str.check(stat.left.getValue()))
            {
              item.setEnchantStr((short) (item.getEnchantStr() - stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantStr((short) (item2.getEnchantStr() - stat.right.intValue()));
              }
            }
            if (EnchantFlag.Dex.check(stat.left.getValue()))
            {
              item.setEnchantDex((short) (item.getEnchantDex() - stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantDex((short) (item2.getEnchantDex() - stat.right.intValue()));
              }
            }
            if (EnchantFlag.Int.check(stat.left.getValue()))
            {
              item.setEnchantInt((short) (item.getEnchantInt() - stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantInt((short) (item2.getEnchantInt() - stat.right.intValue()));
              }
            }
            if (EnchantFlag.Luk.check(stat.left.getValue()))
            {
              item.setEnchantLuk((short) (item.getEnchantLuk() - stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantLuk((short) (item2.getEnchantLuk() - stat.right.intValue()));
              }
            }
            if (EnchantFlag.Wdef.check(stat.left.getValue()))
            {
              item.setEnchantWdef((short) (item.getEnchantWdef() - stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantWdef((short) (item2.getEnchantWdef() - stat.right.intValue()));
              }
            }
            if (EnchantFlag.Mdef.check(stat.left.getValue()))
            {
              item.setEnchantMdef((short) (item.getEnchantMdef() - stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantMdef((short) (item2.getEnchantMdef() - stat.right.intValue()));
              }
            }
            if (EnchantFlag.Hp.check(stat.left.getValue()))
            {
              item.setEnchantHp((short) (item.getEnchantHp() - stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantHp((short) (item2.getEnchantHp() - stat.right.intValue()));
              }
            }
            if (EnchantFlag.Mp.check(stat.left.getValue()))
            {
              item.setEnchantMp((short) (item.getEnchantMp() - stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantMp((short) (item2.getEnchantMp() - stat.right.intValue()));
              }
            }
            if (EnchantFlag.Acc.check(stat.left.getValue()))
            {
              item.setEnchantAcc((short) (item.getEnchantAcc() - stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantAcc((short) (item2.getEnchantAcc() - stat.right.intValue()));
              }
            }
            if (EnchantFlag.Avoid.check(stat.left.getValue()))
            {
              item.setEnchantAvoid((short) (item.getEnchantAvoid() - stat.right.intValue()));
              if (item2 != null)
              {
                item2.setEnchantAvoid((short) (item2.getEnchantAvoid() - stat.right.intValue()));
              }
            }
          }
          checkEquipmentStats(c, item);
          if (item2 != null)
          {
            checkEquipmentStats(c, item2);
          }
          if ((item.getEnchantBuff() & 0x10) != 0)
          {
            item.setEnchantBuff((short) (item.getEnchantBuff() + 32));
          }
          else
          {
            item.setEnchantBuff((short) (item.getEnchantBuff() + 16));
          }
          if (item2 != null)
          {
            if ((item2.getEnchantBuff() & 0x10) != 0)
            {
              item2.setEnchantBuff((short) (item2.getEnchantBuff() + 32));
            }
            else
            {
              item2.setEnchantBuff((short) (item2.getEnchantBuff() + 16));
            }
          }
        }
        else
        {
          result = 3;
        }
        if (item.getEnchantBuff() >= 136 && item.getPosition() < 0)
        {
          MapleInventoryManipulator.unequip(c, item.getPosition(), c.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), MapleInventoryType.EQUIP);
          if (item2 != null)
          {
            MapleInventoryManipulator.unequip(c, item2.getPosition(), c.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), MapleInventoryType.EQUIP);
            Item zw = MapleInventoryManipulator.addId_Item(c, 1572000, (short) 1, "", null, -1L, "", false);
            if (zw != null)
            {
              MapleInventoryManipulator.equip(c, zw.getPosition(), (short) -11, MapleInventoryType.EQUIP);
            }
            Item zw2 = MapleInventoryManipulator.addId_Item(c, 1562000, (short) 1, "", null, -1L, "", false);
            if (zw2 != null)
            {
              MapleInventoryManipulator.equip(c, zw2.getPosition(), (short) -10, MapleInventoryType.EQUIP);
            }
          }
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
        c.getSession().writeAndFlush(CWvsContext.equipmentEnchantResult(type, item, null, null, null));
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
        per = starForcePercent(item);
        success = per.left.intValue();
        destroy = per.right.intValue();
        meso = (int) StarForceMeso(item);
        if (shield)
        {
          meso *= 2;
        }
        if (item.getEnhance() < 22)
        {
          if (c.getPlayer().haveItem(4310021))
          {
            success += 100;
            c.getPlayer().dropMessage(-1, "[안내] 스타포스 10% 확률 업 티켓 효과로 성공 확률이 증가 하였습니다.");
            c.getPlayer().dropMessage(5, "[안내] 스타포스 10% 확률 업 티켓 효과로 성공 확률이 증가 하였습니다.");
          }
          else if (c.getPlayer().haveItem(4310019))
          {
            success += 50;
            c.getPlayer().dropMessage(-1, "[안내] 스타포스 5% 확률 업 티켓 효과로 성공 확률이 증가 하였습니다.");
            c.getPlayer().dropMessage(5, "[안내] 스타포스 5% 확률 업 티켓 효과로 성공 확률이 증가 하였습니다.");
          }
        }
        if (success >= 1000)
        {
          success = 1000;
        }
        down = 1000 - success - destroy;
        stats = starForceStats(item);
        if ((!(ii.isSuperial(item.getItemId())).right.booleanValue() && item.getEnhance() <= 10) || item.getEnhance() % 5 == 0)
        {
          down = 0;
        }
        if ((item.getEnchantBuff() & 0x20) != 0)
        {
          success = 1000;
          down = 0;
          destroy = 0;
        }
        if (c.getPlayer().getInventory(MapleInventoryType.EQUIP).getNumFreeSlot() < (GameConstants.isZeroWeapon(item.getItemId()) ? 2 : 1))
        {
          c.getPlayer().dropMessage(1, "장비 창에 " + (GameConstants.isZeroWeapon(item.getItemId()) ? 2 : 1) + "칸 이상의 공간이 필요합니다.");
          return;
        }
        despoer = 0;
        if (item.getEnhance() >= 12)
        {
          switch (item.getEnhance())
          {
            case 12:
              despoer = 10;
              break;
            case 13:
            case 14:
              despoer = 20;
              break;
            case 15:
            case 16:
            case 17:
              despoer = 30;
              break;
            case 18:
            case 19:
              despoer = 40;
              break;
            case 20:
            case 21:
              despoer = 100;
              break;
            case 22:
              despoer = 200;
              break;
            case 23:
              despoer = 300;
              break;
            case 24:
              despoer = 400;
              break;
          }
        }
        if ((ii.isSuperial(item.getItemId())).right.booleanValue())
        {
          switch (item.getEnhance())
          {
            case 5:
              despoer = 30;
              break;
            case 6:
              despoer = 50;
              break;
            case 7:
              despoer = 70;
              break;
            case 8:
              despoer = 100;
              break;
            case 9:
              despoer = 150;
              break;
            case 10:
              despoer = 200;
              break;
            case 11:
              despoer = 251;
              break;
            case 12:
            case 13:
              despoer = 500;
              break;
            case 14:
              despoer = 500;
              break;
          }
        }
        c.getSession().writeAndFlush(CWvsContext.equipmentEnchantResult(type, item, null, null, stats, down, despoer, success, meso));
        break;
      case 53:
        c.getSession().writeAndFlush(CWvsContext.equipmentEnchantResult(53, null, null, null, null, -1525457920));
        break;
    }
  }
  
  public static Pair<Integer, Integer> starForcePercent(Equip item)
  {
    MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
    boolean superial = (ii.isSuperial(item.getItemId())).right.booleanValue();
    Pair<Integer, Integer> percent = new Pair<>(Integer.valueOf(0), Integer.valueOf(0));
    switch (item.getEnhance())
    {
      case 0:
        percent.left = Integer.valueOf(superial ? 500 : 950);
        break;
      case 1:
        percent.left = Integer.valueOf(superial ? 500 : 900);
        break;
      case 2:
        percent.left = Integer.valueOf(superial ? 450 : 850);
        break;
      case 3:
        percent.left = Integer.valueOf(superial ? 400 : 850);
        break;
      case 4:
        percent.left = Integer.valueOf(superial ? 400 : 800);
        break;
      case 5:
        percent.left = Integer.valueOf(superial ? 400 : 750);
        percent.right = Integer.valueOf(superial ? 18 : 0);
        break;
      case 6:
        percent.left = Integer.valueOf(superial ? 400 : 700);
        percent.right = Integer.valueOf(superial ? 30 : 0);
        break;
      case 7:
        percent.left = Integer.valueOf(superial ? 400 : 650);
        percent.right = Integer.valueOf(superial ? 42 : 0);
        break;
      case 8:
        percent.left = Integer.valueOf(superial ? 400 : 600);
        percent.right = Integer.valueOf(superial ? 60 : 0);
        break;
      case 9:
        percent.left = Integer.valueOf(superial ? 370 : 550);
        percent.right = Integer.valueOf(superial ? 95 : 0);
        break;
      case 10:
        percent.left = Integer.valueOf(superial ? 350 : 500);
        percent.right = Integer.valueOf(superial ? 130 : 0);
        break;
      case 11:
        percent.left = Integer.valueOf(superial ? 350 : 450);
        percent.right = Integer.valueOf(superial ? 163 : 0);
        break;
      case 12:
        percent.left = Integer.valueOf(superial ? 30 : 400);
        percent.right = Integer.valueOf(superial ? 485 : 6);
        break;
      case 13:
        percent.left = Integer.valueOf(superial ? 20 : 350);
        percent.right = Integer.valueOf(superial ? 490 : 13);
        break;
      case 14:
        percent.left = Integer.valueOf(superial ? 10 : 300);
        percent.right = Integer.valueOf(superial ? 495 : 14);
        break;
      case 15:
        percent.left = Integer.valueOf(300);
        percent.right = Integer.valueOf(21);
        break;
      case 16:
        percent.left = Integer.valueOf(300);
        percent.right = Integer.valueOf(21);
        break;
      case 17:
        percent.left = Integer.valueOf(300);
        percent.right = Integer.valueOf(21);
        break;
      case 18:
        percent.left = Integer.valueOf(300);
        percent.right = Integer.valueOf(21);
        break;
      case 19:
        percent.left = Integer.valueOf(300);
        percent.right = Integer.valueOf(21);
        break;
      case 20:
        percent.left = Integer.valueOf(300);
        percent.right = Integer.valueOf(70);
        break;
      case 21:
        percent.left = Integer.valueOf(300);
        percent.right = Integer.valueOf(70);
        break;
      case 22:
        percent.left = Integer.valueOf(30);
        percent.right = Integer.valueOf(194);
        break;
      case 23:
        percent.left = Integer.valueOf(20);
        percent.right = Integer.valueOf(294);
        break;
      case 24:
        percent.left = Integer.valueOf(10);
        percent.right = Integer.valueOf(999);
        break;
    }
    return percent;
  }
  
  public static long StarForceMeso(Equip item)
  {
    long base = 0L;
    MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
    Integer ReqLevel = ii.getEquipStats(item.getItemId()).get("reqLevel");
    
    int equipLevel = ReqLevel != null ? ReqLevel.intValue() : 1;
    
    int enhance = item.getEnhance();
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
      int nextStart = enhance + 1;
      
      if (enhance < 10)
      {
        return 100 * Math.round(Math.pow(equipLevel, 3) * nextStart / 2500 + 10);
      }
      else
      {
        double v = Math.pow(equipLevel, 3) * Math.pow(nextStart, 3);
        if (enhance < 15)
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
