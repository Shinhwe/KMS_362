package server;

import client.inventory.EquipTemplate;
import tools.Triple;

import java.util.List;
import java.util.Map;

public class ItemInformation
{
  public List<Integer> scrollReqs = null;

  public List<Integer> questItems = null;

  public List<Integer> incSkill = null;

  public short slotMax;

  public short itemMakeLevel;

  public EquipTemplate template = null;

  public Map<String, Integer> equipStats;

  public double price = 0.0D;

  public int itemId;

  public int wholePrice;

  public int monsterBook;

  public int stateChange;

  public int meso;

  public int questId;

  public int totalprob;

  public int replaceItem;

  public int mob;

  public String vslot = "";

  public String islot = "";

  public boolean isShield = false;

  public boolean isBossItem = false;

  public int fixedPotential = 0;

  public int fixedPotentialOption1 = 0;

  public int fixedPotentialOption1Level = 0;

  public int fixedPotentialOption2 = 0;

  public int fixedPotentialOption2Level = 0;

  public int fixedPotentialOption3 = 0;

  public int fixedPotentialOption3Level = 0;

  // 主武器副武器都算Weapon, 需要根据islot进行二次判断
  // 服务器的islot是Si或者WpSi
  // 但是Emblem的islot也是Si, 所以需要这个字段来判断是不是Emblem
  public boolean isWeapon = false;

  public boolean isAndroid = false;

  public int cardSet;

  public int create;

  public int flag;

  public int nickSkill;

  public String name;

  public String desc;

  public String msg;

  public String replaceMsg;

  public String afterImage;

  public String chairType;

  public byte karmaEnabled;

  public List<StructRewardItem> rewardItems = null;

  public List<Triple<String, String, String>> equipAdditions = null;

  public Map<Integer, Map<String, Integer>> equipIncs = null;


  public int forceUpgrade = 0;

  public int success = 0;

  public int noSuperior = 0;

  public int noCursed = 0;

  public int reqEquipLevelMin = 0;

  public int reqEquipLevelMax = 0;

  public int timeLimited = 0;

  public int cursed = 0;
}
