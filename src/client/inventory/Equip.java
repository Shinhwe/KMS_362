package client.inventory;

import constants.GameConstants;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.enchant.EnchantFlag;
import server.enchant.EquipmentEnchant;
import server.enchant.EquipmentScroll;
import server.enchant.StarForceStats;
import tools.CalcTools;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Equip extends Item implements Serializable
{
  public static final int ARMOR_RATIO = 350000;
  public static final int WEAPON_RATIO = 700000;
  public StarForceStats starForceStats = new StarForceStats(new ArrayList<>());
  private 裝備潛能等級 潛能等級 = 裝備潛能等級.沒有潛能;
  private 裝備潛能等級 附加潛能等級 = 裝備潛能等級.沒有潛能;
  private byte 未鑑定潛能條數 = 0;
  private byte extraUpgradeSlots = 0;
  private byte successUpgradeSlots = 0;
  private byte failUpgradeSlots = 0;
  private byte enchantLevel = 0;
  private byte vicioushammer = 0;
  private int itemLevel = 0;

  private short charmEXP = 0;

  private EquipTemplate template;


  private int itemEXP = 0;
  private byte starForceLevel = 0;
  private byte yggdrasilWisdom = 0;
  private byte karmaCount = (byte) -1;

  private short soulname = 0;
  private short soulenchanter = 0;
  private short soulpotential = 0;
  private short enchantBuff = 0;
  private short enchantStr = 0;
  private short enchantDex = 0;
  private short enchantInt = 0;
  private short enchantLuk = 0;
  private short enchantHp = 0;
  private short enchantMp = 0;
  private short enchantWdef = 0;
  private short enchantMdef = 0;
  private byte enchantBossDamage = 0;
  private byte enchantDamage = 0;

  private short enchantCraft = 0;

  private byte enchantAllStat = 0;

  private byte enchantIgnorePDR = 0;
  private short enchantAccuracy = 0;
  private short enchantAvoid = 0;
  private short enchantWatk = 0;
  private short enchantMatk = 0;
  private short enchantJump = 0;

  private byte enchantReductReqLevel = 0;

  private short enchantMovementSpeed = 0;
  private short flameStr = 0;
  private short flameDex = 0;
  private short flameInt = 0;
  private short flameLuk = 0;
  private short flameWatk = 0;
  private short flameMatk = 0;
  private short flameHp = 0;
  private short flameMp = 0;
  private short flameMovementSpeed = 0;
  private short flameJump = 0;
  private short flameDamage = 0;
  private short flameBossDamage = 0;
  private short flameAllStat = 0;
  private byte flameReductReqLevel = 0;
  private short flameDef = 0;
  private short starForceStr = 0;
  private short starForceDex = 0;
  private short starForceInt = 0;
  private short starForceLuk = 0;
  private short starForceHp = 0;
  private short starForceMp = 0;
  private short starForceWdef = 0;
  private short starForceMdef = 0;
  private short starForceAccuracy = 0;
  private short starForceAvoid = 0;
  private short starForceWatk = 0;
  private short starForceMatk = 0;
  private short starForceJump = 0;
  private short starForceMovementSpeed = 0;

  private int arcPower;

  private int arcExp = 0;
  private int arcLevel = 0;

  private int arcStr = 0;

  private int arcDex = 0;

  private int arcInt = 0;

  private int arcLuk = 0;

  private int arcHp = 0;

  private int authenticLevel = 0;

  private int authenticPower = 0;

  private int authenticExp = 0;
  private int authenticStr = 0;

  private int authenticDex = 0;
  private int authenticInt = 0;
  private int authenticLuk = 0;

  private int authenticHp = 0;
  private int durability = -1;
  private int incSkill = -1;
  private int potential1 = 0;
  private int potential2 = 0;
  private int potential3 = 0;
  private int potential4 = 0;
  private int potential5 = 0;
  private int potential6 = 0;
  private int soulskill = 0;
  private int moru = 0;
  private int equipmentType = 4352;
  private int Coption1 = 0;
  private int Coption2 = 0;
  private int Coption3 = 0;
  private long flame = 0L;
  private long optionexpiration = 0L;
  private boolean finalStrike = false;

  private EquipmentScroll showScrollOption;
  private List<EquipStat> stats = new LinkedList<EquipStat>();
  private List<EquipSpecialStat> specialStats = new LinkedList<EquipSpecialStat>();

  public Equip (EquipTemplate template, short position, int flag, long uniqueid)
  {
    super(template.getItemId(), position, (short) 1, flag, uniqueid);
    this.template = template;
    charmEXP = template.getCharmEXP();
    durability = template.getDurability();
  }

  public static Equip calculateEquipStats (Equip eq)
  {
    eq.getStats().clear();

    eq.getSpecialStats().clear();

    eq.calcFlameStats();

    eq.calcStarForceStats();

    if (eq.getTotalUpgradeSlots() > 0)
    {
      eq.getStats().add(EquipStat.SLOTS);
    }
    if (eq.getEnchantLevel() > 0)
    {
      eq.getStats().add(EquipStat.ENCHANTLEVEL);
    }
    if (eq.getTotalStr() > 0)
    {
      eq.getStats().add(EquipStat.STR);
    }
    if (eq.getTotalDex() > 0)
    {
      eq.getStats().add(EquipStat.DEX);
    }
    if (eq.getTotalInt() > 0)
    {
      eq.getStats().add(EquipStat.INT);
    }
    if (eq.getTotalLuk() > 0)
    {
      eq.getStats().add(EquipStat.LUK);
    }
    if (eq.getTotalHp() > 0)
    {
      eq.getStats().add(EquipStat.MHP);
    }
    if (eq.getTotalMp() > 0)
    {
      eq.getStats().add(EquipStat.MMP);
    }
    if (eq.getTotalWatk() > 0)
    {
      eq.getStats().add(EquipStat.WATK);
    }
    if (eq.getTotalMatk() > 0)
    {
      eq.getStats().add(EquipStat.MATK);
    }
    if (eq.getTotalWdef() > 0)
    {
      eq.getStats().add(EquipStat.WDEF);
    }
    if (eq.getTotalCraft() > 0)
    {
      eq.getStats().add(EquipStat.CRAFT);
    }
    if (eq.getTotalMovementSpeed() > 0)
    {
      eq.getStats().add(EquipStat.MOVEMENTSPEED);
    }
    if (eq.getTotalJump() > 0)
    {
      eq.getStats().add(EquipStat.JUMP);
    }
    if (eq.getFlag() != 0)
    {
      eq.getStats().add(EquipStat.FLAG);
    }
    if (eq.getIncSkill() > 0)
    {
      eq.getStats().add(EquipStat.INC_SKILL);
    }
    if (eq.getEquipLevel() > 0)
    {
      eq.getStats().add(EquipStat.ITEM_LEVEL);
    }
    if (eq.getItemEXP() > 0)
    {
      eq.getStats().add(EquipStat.ITEM_EXP);
    }
    if (eq.getDurability() > -1)
    {
      eq.getStats().add(EquipStat.DURABILITY);
    }
    if (eq.getViciousHammer() > 0)
    {
      eq.getStats().add(EquipStat.VICIOUS_HAMMER);
    }
    if (eq.getTemplate().getPVPDamage() > 0)
    {
      eq.getStats().add(EquipStat.PVP_DAMAGE);
    }
    if (eq.getEnchantBuff() > 0)
    {
      eq.getStats().add(EquipStat.ENHANCT_BUFF);
    }
    if (eq.getTotalReductReqLevel() > 0)
    {
      eq.getStats().add(EquipStat.DOWNLEVEL);
    }
    // else
    // {
    //   eq.getStats().add(EquipStat.REQUIRED_LEVEL);
    // }
    if (eq.getYggdrasilWisdom() > 0)
    {
      eq.getStats().add(EquipStat.YGGDRASIL_WISDOM);
    }
    if (eq.getFinalStrike())
    {
      eq.getStats().add(EquipStat.FINAL_STRIKE);
    }
    if (eq.getTemplate().getBossDamage() > 0)
    {
      eq.getStats().add(EquipStat.IndieBdr);
    }
    if (eq.getTemplate().getIgnorePDR() > 0)
    {
      eq.getStats().add(EquipStat.IGNORE_PDR);
    }
    if (eq.getTotalDamage() > 0)
    {
      eq.getSpecialStats().add(EquipSpecialStat.TOTAL_DAMAGE);
    }
    if (eq.getTotalAllStat() > 0)
    {
      eq.getSpecialStats().add(EquipSpecialStat.ALL_STAT);
    }
    if (eq.getFlame() >= -1L)
    {
      eq.getSpecialStats().add(EquipSpecialStat.KARMA_COUNT);
    }
    if (eq.getFlame() > 0L)
    {
      eq.getSpecialStats().add(EquipSpecialStat.FLAME);
    }
    if (eq.getEquipmentType() > 0)
    {
      eq.getSpecialStats().add(EquipSpecialStat.EQUIPMENT_TYPE);
    }
    return (Equip) eq.copy();
  }

  public void set (Equip set)
  {
    this.template = set.template;
    this.arcPower = set.arcPower;
    this.arcLevel = set.arcLevel;
    this.arcExp = set.arcExp;
    this.arcDex = set.arcDex;
    this.arcStr = set.arcStr;
    this.arcInt = set.arcInt;
    this.arcLuk = set.arcLuk;
    this.arcHp = set.arcHp;
    this.authenticStr = set.authenticStr;
    this.authenticDex = set.authenticDex;
    this.authenticInt = set.authenticInt;
    this.authenticLuk = set.authenticLuk;
    this.authenticHp = set.authenticHp;
    this.starForceLevel = set.starForceLevel;
    this.enchantLevel = set.enchantLevel;
    this.durability = set.durability;
    this.vicioushammer = set.vicioushammer;
    this.extraUpgradeSlots = set.extraUpgradeSlots;
    this.successUpgradeSlots = set.successUpgradeSlots;
    this.failUpgradeSlots = set.failUpgradeSlots;
    this.potential1 = set.potential1;
    this.potential2 = set.potential2;
    this.potential3 = set.potential3;
    this.potential4 = set.potential4;
    this.potential5 = set.potential5;
    this.potential6 = set.potential6;
    this.incSkill = set.incSkill;
    this.enchantBuff = set.enchantBuff;
    this.itemLevel = set.itemLevel;
    this.itemEXP = set.itemEXP;
    this.charmEXP = set.charmEXP;
    this.durability = set.durability;
    this.yggdrasilWisdom = set.yggdrasilWisdom;
    this.finalStrike = set.finalStrike;
    this.karmaCount = set.karmaCount;
    this.soulname = set.soulname;
    this.soulenchanter = set.soulenchanter;
    this.soulpotential = set.soulpotential;
    this.soulskill = set.soulskill;
    this.stats = set.stats;
    this.specialStats = set.specialStats;
    this.潛能等級 = set.潛能等級;
    this.附加潛能等級 = set.附加潛能等級;
    this.未鑑定潛能條數 = set.未鑑定潛能條數;
    this.flame = set.flame;
    this.moru = set.moru;
    this.enchantStr = set.enchantStr;
    this.enchantDex = set.enchantDex;
    this.enchantInt = set.enchantInt;
    this.enchantLuk = set.enchantLuk;
    this.enchantCraft = set.enchantCraft;
    this.enchantHp = set.enchantHp;
    this.enchantMp = set.enchantMp;
    this.enchantReductReqLevel = set.enchantReductReqLevel;
    this.enchantAccuracy = set.enchantAccuracy;
    this.enchantAvoid = set.enchantAvoid;
    this.enchantWatk = set.enchantWatk;
    this.enchantMatk = set.enchantMatk;
    this.enchantWdef = set.enchantWdef;
    this.enchantMdef = set.enchantMdef;
    this.enchantBossDamage = set.enchantBossDamage;
    this.enchantDamage = set.enchantDamage;
    this.enchantIgnorePDR = set.enchantIgnorePDR;
    this.enchantAllStat = set.enchantAllStat;
    this.enchantMovementSpeed = set.enchantMovementSpeed;
    this.enchantJump = set.enchantJump;
    this.optionexpiration = set.optionexpiration;
    this.Coption1 = set.Coption1;
    this.Coption2 = set.Coption2;
    this.Coption3 = set.Coption3;
    this.starForceStats = set.starForceStats;
    this.starForceStr = set.starForceStr;
    this.starForceDex = set.starForceDex;
    this.starForceInt = set.starForceInt;
    this.starForceLuk = set.starForceLuk;
    this.starForceWatk = set.starForceWatk;
    this.starForceMatk = set.starForceMatk;
    this.starForceWdef = set.starForceWdef;
    this.starForceMdef = set.starForceMdef;
    this.starForceAccuracy = set.starForceAccuracy;
    this.starForceAvoid = set.starForceAvoid;
    this.starForceMovementSpeed = set.starForceMovementSpeed;
    this.starForceJump = set.starForceJump;
    this.starForceHp = set.starForceHp;
    this.starForceMp = set.starForceMp;
    this.flameStr = set.flameStr;
    this.flameDex = set.flameDex;
    this.flameInt = set.flameInt;
    this.flameLuk = set.flameLuk;
    this.flameWatk = set.flameWatk;
    this.flameMatk = set.flameMatk;
    this.flameHp = set.flameHp;
    this.flameMp = set.flameMp;
    this.flameMovementSpeed = set.flameMovementSpeed;
    this.flameJump = set.flameJump;
    this.flameDamage = set.flameDamage;
    this.flameBossDamage = set.flameBossDamage;
    this.flameAllStat = set.flameAllStat;
    this.flameReductReqLevel = set.flameReductReqLevel;
    this.flameDef = set.flameDef;
  }

  @Override public Item copy ()
  {
    Equip ret = new Equip(this.getTemplate(), this.getPosition(), this.getFlag(), this.getUniqueId());
    ret.arcPower = this.arcPower;
    ret.arcLevel = this.arcLevel;
    ret.arcExp = this.arcExp;
    ret.arcDex = this.arcDex;
    ret.arcStr = this.arcStr;
    ret.arcInt = this.arcInt;
    ret.arcLuk = this.arcLuk;
    ret.arcHp = this.arcHp;
    this.authenticStr = this.authenticStr;
    this.authenticDex = this.authenticDex;
    this.authenticInt = this.authenticInt;
    this.authenticLuk = this.authenticLuk;
    this.authenticHp = this.authenticHp;
    ret.starForceLevel = this.starForceLevel;
    ret.enchantLevel = this.enchantLevel;
    ret.durability = this.durability;
    ret.vicioushammer = this.vicioushammer;
    ret.extraUpgradeSlots = this.extraUpgradeSlots;
    ret.successUpgradeSlots = this.successUpgradeSlots;
    ret.failUpgradeSlots = this.failUpgradeSlots;
    ret.potential1 = this.potential1;
    ret.potential2 = this.potential2;
    ret.potential3 = this.potential3;
    ret.potential4 = this.potential4;
    ret.potential5 = this.potential5;
    ret.potential6 = this.potential6;
    ret.incSkill = this.incSkill;
    ret.enchantBuff = this.enchantBuff;
    ret.itemLevel = this.itemLevel;
    ret.itemEXP = this.itemEXP;
    ret.charmEXP = this.charmEXP;
    ret.durability = this.durability;
    ret.yggdrasilWisdom = this.yggdrasilWisdom;
    ret.finalStrike = this.finalStrike;
    ret.karmaCount = this.karmaCount;
    ret.soulname = this.soulname;
    ret.soulenchanter = this.soulenchanter;
    ret.soulpotential = this.soulpotential;
    ret.setInventoryId(this.getInventoryId());
    ret.setGiftFrom(this.getGiftFrom());
    ret.setOwner(this.getOwner());
    ret.setQuantity(this.getQuantity());
    ret.setExpiration(this.getExpiration());
    ret.stats = this.stats;
    ret.specialStats = this.specialStats;
    ret.潛能等級 = this.潛能等級;
    ret.附加潛能等級 = this.附加潛能等級;
    ret.未鑑定潛能條數 = this.未鑑定潛能條數;
    ret.flame = this.flame;
    ret.soulskill = this.soulskill;
    ret.equipmentType = this.equipmentType;
    ret.moru = this.moru;
    ret.enchantStr = this.enchantStr;
    ret.enchantDex = this.enchantDex;
    ret.enchantInt = this.enchantInt;
    ret.enchantLuk = this.enchantLuk;
    ret.enchantHp = this.enchantHp;
    ret.enchantMp = this.enchantMp;
    ret.enchantReductReqLevel = this.enchantReductReqLevel;
    ret.enchantAccuracy = this.enchantAccuracy;
    ret.enchantAvoid = this.enchantAvoid;
    ret.enchantWatk = this.enchantWatk;
    ret.enchantMatk = this.enchantMatk;
    ret.enchantWdef = this.enchantWdef;
    ret.enchantMdef = this.enchantMdef;
    ret.enchantCraft = this.enchantCraft;
    ret.enchantBossDamage = this.enchantBossDamage;
    ret.enchantDamage = this.enchantDamage;
    ret.enchantIgnorePDR = this.enchantIgnorePDR;
    ret.enchantAllStat = this.enchantAllStat;
    ret.enchantMovementSpeed = this.enchantMovementSpeed;
    ret.enchantJump = this.enchantJump;
    ret.optionexpiration = this.optionexpiration;
    ret.Coption1 = this.Coption1;
    ret.Coption2 = this.Coption2;
    ret.Coption3 = this.Coption3;
    ret.starForceStats = this.starForceStats;
    ret.starForceStr = this.starForceStr;
    ret.starForceDex = this.starForceDex;
    ret.starForceInt = this.starForceInt;
    ret.starForceLuk = this.starForceLuk;
    ret.starForceWatk = this.starForceWatk;
    ret.starForceMatk = this.starForceMatk;
    ret.starForceWdef = this.starForceWdef;
    ret.starForceMdef = this.starForceMdef;
    ret.starForceAccuracy = this.starForceAccuracy;
    ret.starForceAvoid = this.starForceAvoid;
    ret.starForceMovementSpeed = this.starForceMovementSpeed;
    ret.starForceJump = this.starForceJump;
    ret.starForceHp = this.starForceHp;
    ret.starForceMp = this.starForceMp;
    ret.flameStr = this.flameStr;
    ret.flameDex = this.flameDex;
    ret.flameInt = this.flameInt;
    ret.flameLuk = this.flameLuk;
    ret.flameWatk = this.flameWatk;
    ret.flameMatk = this.flameMatk;
    ret.flameHp = this.flameHp;
    ret.flameMp = this.flameMp;
    ret.flameMovementSpeed = this.flameMovementSpeed;
    ret.flameJump = this.flameJump;
    ret.flameDamage = this.flameDamage;
    ret.flameBossDamage = this.flameBossDamage;
    ret.flameAllStat = this.flameAllStat;
    ret.flameReductReqLevel = this.flameReductReqLevel;
    ret.flameDef = this.flameDef;
    return ret;
  }


  @Override public byte getType ()
  {
    return 1;
  }

  public byte getTotalUpgradeSlots ()
  {
    return (byte) (this.template.getUpgradeSlots() + this.extraUpgradeSlots - this.failUpgradeSlots - this.successUpgradeSlots);
  }


  //  public void setUpgradeSlots (byte upgradeSlots)
  //  {
  //    this.upgradeSlots = upgradeSlots;
  //  }

  public byte getExtraUpgradeSlots ()
  {
    return extraUpgradeSlots;
  }

  public void setExtraUpgradeSlots (byte extraUpgradeSlots)
  {
    this.extraUpgradeSlots = extraUpgradeSlots;
  }

  public byte getFailUpgradeSlots ()
  {
    return failUpgradeSlots;
  }

  public void setFailUpgradeSlots (byte failUpgradeSlots)
  {
    this.failUpgradeSlots = failUpgradeSlots > 0 ? failUpgradeSlots : 0;
  }

  public byte getSuccessUpgradeSlots ()
  {
    return successUpgradeSlots;
  }

  public void setSuccessUpgradeSlots (byte successUpgradeSlots)
  {
    this.successUpgradeSlots = successUpgradeSlots;
  }


  public int getArcPower ()
  {
    return this.arcPower;
  }

  public void setArcPower (int arcPower)
  {
    if (arcPower < 0)
    {
      arcPower = 0;
    }
    this.arcPower = arcPower;
  }


  public short getTotalCraft ()
  {
    return (short) (this.template.getCraft() + this.enchantCraft);
  }


  public short getTotalMovementSpeed ()
  {
    return (short) (this.template.getMoveMentSpeed() + enchantMovementSpeed + flameMovementSpeed + starForceMovementSpeed);
  }


  public short getTotalJump ()
  {
    return (short) (this.template.getJump() + enchantJump + flameJump + starForceJump);
  }


  public byte getEnchantLevel ()
  {
    return this.enchantLevel;
  }

  public void setEnchantLevel (byte enchantLevel)
  {
    this.enchantLevel = enchantLevel;
  }

  public byte getViciousHammer ()
  {
    return this.vicioushammer;
  }

  public void setViciousHammer (byte ham)
  {
    this.vicioushammer = ham;
  }


  public int getItemEXP ()
  {
    return this.itemEXP;
  }

  public void setItemEXP (int itemEXP)
  {
    if (itemEXP < 0)
    {
      itemEXP = 0;
    }
    this.itemEXP = itemEXP;
  }

  public int getEquipExp ()
  {
    if (this.itemEXP <= 0)
    {
      return 0;
    }
    if (GameConstants.isWeapon(this.getItemId()))
    {
      return this.itemEXP / 700000;
    }
    return this.itemEXP / 350000;
  }

  public int getEquipExpForLevel ()
  {
    if (this.getEquipExp() <= 0)
    {
      return 0;
    }
    int expz = this.getEquipExp();
    for (int i = 0; i <= GameConstants.getMaxLevel(this.getItemId()) && expz >= GameConstants.getExpForLevel(i, this.getItemId()); expz -= GameConstants.getExpForLevel(i, this.getItemId()), ++i)
    {
    }
    return expz;
  }

  public int getExpPercentage ()
  {
    if (this.getEquipLevel() < 0 || this.getEquipLevel() > GameConstants.getMaxLevel(this.getItemId()) || GameConstants.getExpForLevel(this.getEquipLevel(), this.getItemId()) <= 0)
    {
      return 0;
    }
    return this.getEquipExpForLevel() * 100 / GameConstants.getExpForLevel(this.getEquipLevel(), this.getItemId());
  }

  public int getEquipLevel ()
  {
    if (GameConstants.getMaxLevel(this.getItemId()) <= 0)
    {
      return 0;
    }
    if (this.getEquipExp() <= 0)
    {
      return 0;
    }
    int levelz = 0;
    int expz = this.getEquipExp();
    for (int i = 0; i <= GameConstants.getMaxLevel(this.getItemId()) && expz >= GameConstants.getExpForLevel(i, this.getItemId()); expz -= GameConstants.getExpForLevel(i, this.getItemId()), ++i)
    {
      ++levelz;
    }
    return levelz;
  }

  public void setItemLevel (int itemLevel)
  {
    this.itemLevel = itemLevel;
  }

  public int getItemLevel ()
  {
    return this.itemLevel;
  }

  @Override public void setQuantity (short quantity)
  {
    // 设置数量无效, 但是父类提供了这个方法, 这里覆写掉
    super.setQuantity((short) 1);
  }

  public void setDurability (int durability)
  {
    this.durability = durability;
  }

  public int getDurability ()
  {
    return this.durability;
  }


  public byte getStarForceLevel ()
  {
    return this.starForceLevel;
  }

  public void setStarForceLevel (byte en)
  {
    this.starForceLevel = en;
  }

  public int getPotential1 ()
  {
    return this.potential1;
  }

  public void setPotential1 (int en)
  {
    this.potential1 = en;
  }

  public int getPotential2 ()
  {
    return this.potential2;
  }

  public void setPotential2 (int en)
  {
    this.potential2 = en;
  }

  public int getPotential3 ()
  {
    return this.potential3;
  }

  public void setPotential3 (int en)
  {
    this.potential3 = en;
  }

  public int getPotential4 ()
  {
    return this.potential4;
  }

  public void setPotential4 (int en)
  {
    this.potential4 = en;
  }

  public int getPotential5 ()
  {
    return this.potential5;
  }

  public void setPotential5 (int en)
  {
    this.potential5 = en;
  }

  public int getPotential6 ()
  {
    return this.potential6;
  }

  public void setPotential6 (int en)
  {
    this.potential6 = en;
  }

  public void setPotentialLevel (byte potentialLevel)
  {
    switch (potentialLevel)
    {
      case 1:
        潛能等級 = 裝備潛能等級.特殊未鑑定;
        break;
      case 2:
        潛能等級 = 裝備潛能等級.稀有未鑑定;
        break;
      case 3:
        潛能等級 = 裝備潛能等級.罕見未鑑定;
        break;
      case 4:
        潛能等級 = 裝備潛能等級.傳說未鑑定;
        break;
      case 17:
        潛能等級 = 裝備潛能等級.特殊;
        break;
      case 18:
        潛能等級 = 裝備潛能等級.稀有;
        break;
      case 19:
        潛能等級 = 裝備潛能等級.罕見;
        break;
      case 20:
        潛能等級 = 裝備潛能等級.傳說;
        break;
      default:
        潛能等級 = 裝備潛能等級.沒有潛能;
        break;
    }
  }

  public 裝備潛能等級 獲取潛能等級 ()
  {
    return this.潛能等級;
  }

  public void 設置潛能等級 (裝備潛能等級 潛能等級)
  {
    this.潛能等級 = 潛能等級;
  }

  public byte 獲取未鑑定潛能條數 ()
  {
    return this.未鑑定潛能條數;
  }

  public void 設置未鑑定潛能條數 (byte 未鑑定潛能條數)
  {
    this.未鑑定潛能條數 = 未鑑定潛能條數;
  }

  public boolean 是否未鑑定 ()
  {
    return 潛能等級.獲取潛能等級的值() > 0 && 潛能等級.獲取潛能等級的值() < 5;
  }

  public void setAdditionalPotentialLevel (byte additionalPotentialLevel)
  {
    switch (additionalPotentialLevel)
    {
      case 1:
        附加潛能等級 = 裝備潛能等級.特殊未鑑定;
        break;
      case 2:
        附加潛能等級 = 裝備潛能等級.稀有未鑑定;
        break;
      case 3:
        附加潛能等級 = 裝備潛能等級.罕見未鑑定;
        break;
      case 4:
        附加潛能等級 = 裝備潛能等級.傳說未鑑定;
        break;
      case 17:
        附加潛能等級 = 裝備潛能等級.特殊;
        break;
      case 18:
        附加潛能等級 = 裝備潛能等級.稀有;
        break;
      case 19:
        附加潛能等級 = 裝備潛能等級.罕見;
        break;
      case 20:
        附加潛能等級 = 裝備潛能等級.傳說;
        break;
      default:
        附加潛能等級 = 裝備潛能等級.沒有潛能;
        break;
    }
  }

  public 裝備潛能等級 獲取鑑定之後的裝備潛能 ()
  {
    switch (潛能等級)
    {
      case 特殊未鑑定:
        return 裝備潛能等級.特殊;
      case 稀有未鑑定:
        return 裝備潛能等級.稀有;
      case 罕見未鑑定:
        return 裝備潛能等級.罕見;
      case 傳說未鑑定:
        return 裝備潛能等級.傳說;
    }
    return 裝備潛能等級.沒有潛能;
  }

  public void resetPotential ()
  {
    int rank = Randomizer.nextInt(100) < 4 ? (Randomizer.nextInt(100) < 4 ? -19 : -18) : -17;
    this.setPotential1(rank);
    this.setPotential2(Randomizer.nextInt(10) == 0 ? rank : 0);
    this.setPotential3(0);
    this.setPotential4(0);
    this.setPotential5(0);
  }


  public long getFlame ()
  {
    return this.flame;
  }

  public void setFlame (long flame)
  {
    this.flame = flame;
  }


  public short getFlameStr ()
  {
    return flameStr;
  }

  public void setFlameStr (short flameStr)
  {
    this.flameStr = flameStr;
  }

  public short getFlameDex ()
  {
    return flameDex;
  }

  public void setFlameDex (short flameDex)
  {
    this.flameDex = flameDex;
  }

  public short getFlameInt ()
  {
    return flameInt;
  }

  public void setFlameInt (short flameInt)
  {
    this.flameInt = flameInt;
  }

  public short getFlameLuk ()
  {
    return flameLuk;
  }

  public void setFlameLuk (short flameLuk)
  {
    this.flameLuk = flameLuk;
  }

  public short getFlameWatk ()
  {
    return flameWatk;
  }

  public void setFlameWatk (short flameWatk)
  {
    this.flameWatk = flameWatk;
  }

  public short getFlameMatk ()
  {
    return flameMatk;
  }

  public void setFlameMatk (short flameMatk)
  {
    this.flameMatk = flameMatk;
  }

  public short getFlameHp ()
  {
    return flameHp;
  }

  public void setFlameHp (short flameHp)
  {
    this.flameHp = flameHp;
  }

  public short getFlameMp ()
  {
    return flameMp;
  }

  public void setFlameMp (short flameMp)
  {
    this.flameMp = flameMp;
  }


  public short getFlameJump ()
  {
    return flameJump;
  }

  public void setFlameJump (short flameJump)
  {
    this.flameJump = flameJump;
  }

  public short getFlameDamage ()
  {
    return flameDamage;
  }

  public void setFlameDamage (short flameDamage)
  {
    this.flameDamage = flameDamage;
  }

  public short getFlameBossDamage ()
  {
    return flameBossDamage;
  }

  public void setFlameBossDamage (short flameBossDamage)
  {
    this.flameBossDamage = flameBossDamage;
  }

  public short getFlameAllStat ()
  {
    return flameAllStat;
  }

  public void setFlameAllStat (short flameAllStat)
  {
    this.flameAllStat = flameAllStat;
  }

  public byte getTotalReductReqLevel ()
  {
    return (byte) Math.min(template.getReqLevel(), enchantReductReqLevel + flameReductReqLevel);
  }

  public byte getFlameReductReqLevel ()
  {
    return flameReductReqLevel;
  }

  public void setFlameReductReqLevel (byte flameReductReqLevel)
  {
    this.flameReductReqLevel = flameReductReqLevel;
  }

  public short getFlameDef ()
  {
    return flameDef;
  }

  public void setFlameDef (short flameDef)
  {
    this.flameDef = flameDef;
  }

  public int getIncSkill ()
  {
    return this.incSkill;
  }

  public void setIncSkill (int inc)
  {
    this.incSkill = inc;
  }


  public short getEnchantBuff ()
  {
    return this.enchantBuff;
  }

  public void setEnchantBuff (short enchantBuff)
  {
    this.enchantBuff = enchantBuff;
  }

  //  public void setReqLevel (byte reqLevel)
  //  {
  //    this.reqLevel = reqLevel;
  //  }

  public byte getYggdrasilWisdom ()
  {
    return this.yggdrasilWisdom;
  }

  public void setYggdrasilWisdom (byte yggdrasilWisdom)
  {
    this.yggdrasilWisdom = yggdrasilWisdom;
  }

  public boolean getFinalStrike ()
  {
    return this.finalStrike;
  }

  public void setFinalStrike (boolean finalStrike)
  {
    this.finalStrike = finalStrike;
  }

  public byte getEnchantDamage ()
  {
    return this.enchantDamage;
  }

  public void setEnchantDamage (byte enchantDamage)
  {
    this.enchantDamage = enchantDamage;
  }

  public byte getEnchantAllStat ()
  {
    return this.enchantAllStat;
  }

  public void setEnchantAllStat (byte enchantAllStat)
  {
    this.enchantAllStat = enchantAllStat;
  }

  public byte getTotalBossDamage ()
  {
    return (byte) (this.template.getBossDamage() + enchantBossDamage + flameBossDamage);
  }

  //  public void setBossDamage (short bossDamage)
  //  {
  //    this.bossDamage = bossDamage;
  //  }

  public short getTotalIgnorePDR ()
  {
    return (short) (this.template.getIgnorePDR() + enchantIgnorePDR);
  }

  //  public void setIgnorePDR (short ignorePDR)
  //  {
  //    this.ignorePDR = ignorePDR;
  //  }

  public byte getTotalDamage ()
  {
    return (byte) (this.template.getDamage() + enchantDamage + flameDamage);
  }

  //  public void setTotalDamage (byte totalDamage)
  //  {
  //    this.totalDamage = totalDamage;
  //  }

  public byte getTotalAllStat ()
  {
    return (byte) (this.template.getAllStat() + enchantAllStat + flameAllStat);
  }

  //  public void setAllStat (byte allStat)
  //  {
  //    this.allStat = allStat;
  //  }

  public byte getKarmaCount ()
  {
    return this.karmaCount;
  }

  public void setKarmaCount (byte karmaCount)
  {
    this.karmaCount = karmaCount;
  }

  public short getSoulName ()
  {
    return this.soulname;
  }

  public void setSoulName (short soulname)
  {
    this.soulname = soulname;
  }

  public short getSoulEnchanter ()
  {
    return this.soulenchanter;
  }

  public void setSoulEnchanter (short soulenchanter)
  {
    this.soulenchanter = soulenchanter;
  }

  public short getSoulPotential ()
  {
    return this.soulpotential;
  }

  public void setSoulPotential (short soulpotential)
  {
    this.soulpotential = soulpotential;
  }

  public int getSoulSkill ()
  {
    return this.soulskill;
  }

  public void setSoulSkill (int skillid)
  {
    this.soulskill = skillid;
  }

  public List<EquipStat> getStats ()
  {
    return this.stats;
  }

  public List<EquipSpecialStat> getSpecialStats ()
  {
    return this.specialStats;
  }

  public int getArcExp ()
  {
    return this.arcExp;
  }

  public void setArcExp (int exp)
  {
    this.arcExp = exp;
  }

  public int getArcLevel ()
  {
    return this.arcLevel;
  }

  public void setArcLevel (int lv)
  {
    this.arcLevel = lv;
  }

  public void resetEnchantScroll ()
  {
    this.enchantMovementSpeed = 0;
    this.enchantJump = 0;
    this.enchantLevel = 0;
    this.successUpgradeSlots = 0;
    this.failUpgradeSlots = 0;
    this.extraUpgradeSlots = 0;
    this.enchantHp = 0;
    this.enchantMp = 0;
    this.enchantAccuracy = 0;
    this.enchantAvoid = 0;
    this.enchantStr = 0;
    this.enchantDex = 0;
    this.enchantInt = 0;
    this.enchantLuk = 0;
    this.enchantWatk = 0;
    this.enchantMatk = 0;
    this.enchantWdef = 0;
    this.enchantMdef = 0;
    this.enchantBossDamage = 0;
    this.enchantDamage = 0;
    this.enchantIgnorePDR = 0;
    this.enchantAllStat = 0;
  }

  public void calcFlameStats ()
  {
    if (this.getFlame() == 0L)
    {
      return;
    }

    this.resetFlame();


    int flameOption1 = (int) (flame % 1000L / 10L);

    int flameValue1 = (int) (flame % 10L / 1L);

    int flameOption2 = (int) (flame % 1000000L / 10000L);

    int flameValue2 = (int) (flame % 10000L / 1000L);

    int flameOption3 = (int) (flame % 1000000000L / 10000000L);

    int flameValue3 = (int) (int) (flame % 10000000L / 1000000L);

    int flameOption4 = (int) (flame % 1000000000000L / 10000000000L);

    int flameValue4 = (int) (int) (flame % 10000000000L / 1000000000L);

    int[] flameOptionList = new int[] { flameOption1, flameOption2, flameOption3, flameOption4 };

    int[] flameValueList = new int[] { flameValue1, flameValue2, flameValue3, flameValue4 };

    short reqLevel = this.template.getReqLevel();

    short incStr = 0;

    short incDex = 0;

    short incInt = 0;

    short incLuk = 0;

    short incWatk = 0;

    short incMatk = 0;

    short incMp = 0;

    short incHp = 0;

    short incBossDamage = 0;

    short incDamage = 0;

    short incAllStat = 0;

    short incDef = 0;

    short incSpeed = 0;

    short incJump = 0;

    short baseMatk = getTemplate().getMatk() > 0 ? getTemplate().getMatk() : getTemplate().getWatk();

    short baseWatk = getTemplate().getWatk();

    byte reductReqLevel = 0;

    for (int i = 0; i < 4; ++i)
    {
      int flameOption = flameOptionList[i];

      int flameValue = flameValueList[i];

      if (flameValue == 0)
      {
        continue;
      }

      switch (flameOption)
      {
        case 0:
        {
          incStr += (short) ((reqLevel / 20 + 1) * flameValue);
          continue;
        }
        case 1:
        {
          incDex += (short) ((reqLevel / 20 + 1) * flameValue);
          continue;
        }
        case 2:
        {
          incInt += (short) ((reqLevel / 20 + 1) * flameValue);
          continue;
        }
        case 3:
        {
          incLuk += (short) ((reqLevel / 20 + 1) * flameValue);
          continue;
        }
        case 4:
        {
          incStr += (short) ((reqLevel / 40 + 1) * flameValue);
          incDex += (short) ((reqLevel / 40 + 1) * flameValue);
          continue;
        }
        case 5:
        {
          incStr += (short) ((reqLevel / 40 + 1) * flameValue);
          incInt += (short) ((reqLevel / 40 + 1) * flameValue);
          continue;
        }
        case 6:
        {
          incStr += (short) ((reqLevel / 40 + 1) * flameValue);
          incLuk += (short) ((reqLevel / 40 + 1) * flameValue);
          continue;
        }
        case 7:
        {
          incDex += (short) ((reqLevel / 40 + 1) * flameValue);
          incInt += (short) ((reqLevel / 40 + 1) * flameValue);
          continue;
        }
        case 8:
        {
          incDex += (short) ((reqLevel / 40 + 1) * flameValue);
          incLuk += (short) ((reqLevel / 40 + 1) * flameValue);
          continue;
        }
        case 9:
        {
          incInt += (short) ((reqLevel / 40 + 1) * flameValue);
          incLuk += (short) ((reqLevel / 40 + 1) * flameValue);
          continue;
        }
        case 10:
        {
          incHp += (short) (reqLevel / 10 * 10 * 3 * flameValue);
          continue;
        }
        case 11:
        {
          incMp += (short) (reqLevel / 10 * 10 * 3 * flameValue);
          continue;
        }
        case 13:
        {
          incDef += (short) ((reqLevel / 20 + 1) * flameValue);
          continue;
        }
        case 17:
        {
          if (GameConstants.isWeapon(this.getItemId()))
          {
            double 武器攻擊力百分比 = CalcTools.計算武器火花攻擊力(getItemId(), reqLevel, flameValue);

            incWatk = (short) (Math.floor(baseWatk * 武器攻擊力百分比 / 100) + 1);
          }
          else
          {
            incWatk += (short) flameValue;
          }
          continue;
        }
        case 18:
        {
          if (GameConstants.isWeapon(this.getItemId()))
          {
            double 武器攻擊力百分比 = CalcTools.計算武器火花攻擊力(getItemId(), reqLevel, flameValue);

            incMatk = (short) (Math.floor(baseMatk * 武器攻擊力百分比 / 100) + 1);
          }
          else
          {
            incMatk += (short) flameValue;
          }
          continue;
        }
        case 19:
        {
          incSpeed += (short) flameValue;
          continue;
        }
        case 20:
        {
          incJump += (short) flameValue;
          continue;
        }
        case 21:
        {
          incBossDamage += (short) (flameValue * 2);
          continue;
        }
        case 22:
        {
          reductReqLevel = (byte) (flameValue * 5);
          continue;
        }
        case 23:
        {
          incDamage += (short) flameValue;
          continue;
        }
        case 24:
        {
          incAllStat += (short) flameValue;
        }
      }
    }

    this.flameStr = incStr;

    this.flameDex = incDex;

    this.flameInt = incInt;

    this.flameLuk = incLuk;

    this.flameWatk = incWatk;

    this.flameMatk = incMatk;

    this.flameDef = incDef;

    this.flameAllStat = incAllStat;

    this.flameBossDamage = incBossDamage;

    this.flameDamage = incDamage;

    this.flameJump = incJump;

    this.flameMovementSpeed = incSpeed;

    this.flameReductReqLevel = reductReqLevel;

    this.flameHp = incHp;

    this.flameMp = incMp;

  }

  public void resetFlame ()
  {
    this.flameStr = 0;
    this.flameDex = 0;
    this.flameInt = 0;
    this.flameLuk = 0;
    this.flameWatk = 0;
    this.flameMatk = 0;
    this.flameHp = 0;
    this.flameMp = 0;
    this.flameMovementSpeed = 0;
    this.flameDamage = 0;
    this.flameBossDamage = 0;
    this.flameAllStat = 0;
    this.flameReductReqLevel = 0;
    this.flameJump = 0;
  }

  public long calcNewFlame (int scrollId)
  {
    if (GameConstants.isRing(getItemId()) || GameConstants.isShield(getItemId()) || GameConstants.isShoulder(getItemId()) || GameConstants.isMedal(getItemId()) || GameConstants.isEmblem(getItemId()) || GameConstants.isBadge(getItemId()) || GameConstants.isAndroid(getItemId()) || GameConstants.isAndroidHeart(getItemId()) || GameConstants.isSecondaryWeapon(getItemId()))
    {
      return 0L;
    }

    boolean isBossItem = GameConstants.isBossItem(getItemId());

    System.out.println("物品Id" + this.getItemId() + "开始砸火花啦, 是BOSS物品吗? " + isBossItem);

    System.out.println("使用的火花Id = " + scrollId);

    // check https://strategywiki.org/wiki/MapleStory/Bonus_Stats

    // 条件有点多, 简化一下, 普通装备1到5级, boss装备4到8级, 用强力火花的BOSS装备可以达到5到9级和7到12级(魔改)
    // 保持最大最小值差距是4, 简化了概率计算
    int minValue = 1;

    int maxValue = 5;

    // 普通装备不总是 4 条火花的, 概率也不是等分的
    // 参照wiki, 进行一部分的简化 40 40 15 5
    //  5% 很少? 官服只有4%!

    int chance = Randomizer.nextInt(100);

    System.out.println("计算火花条数的Chance =  " + chance);

    int numberOfLines = 1;

    if (chance > 95)
    {
      numberOfLines = 4;
    }
    else if (chance > 80)
    {
      numberOfLines = 3;
    }
    else if (chance > 40)
    {
      numberOfLines = 2;
    }

    // 但是BOSS物品肯定是4条, 再别说了, BOSS装备就是强力
    if (isBossItem)
    {
      numberOfLines = 4;

      minValue = 3;

      maxValue = 6;
    }

    if (MapleItemInformationProvider.getInstance().getName(scrollId) != null)
    {
      if (MapleItemInformationProvider.getInstance().getName(scrollId).contains("강력한 환생의"))
      {
        if (isBossItem)
        {
          minValue = 3;
          maxValue = 6;
        }
        else
        {
          minValue = 1;
          maxValue = 4;
        }
      }
      if (MapleItemInformationProvider.getInstance().getName(scrollId).contains("영원한 환생의") || MapleItemInformationProvider.getInstance().getName(scrollId).contains("검은 환생의"))
      {
        if (isBossItem)
        {
          minValue = 6;
          maxValue = 9;
        }
        else
        {
          minValue = 2;
          maxValue = 5;
        }
      }
    }

    System.out.println("经过一顿夏姬八计算 numberOfLines = " + numberOfLines + "; minValue = " + minValue + "; maxValue = " + maxValue);


    MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();

    if ((ii.isKarmaEnabled(this.getItemId()) || ii.isPKarmaEnabled(this.getItemId())) && this.getKarmaCount() < 0)
    {
      this.setKarmaCount((byte) 10);
    }
    long[] flameResultList = new long[] { 10L, 10L, 10L, 10L };

    int[] flameOptionList = new int[] { 1, 1, 1, 1 };

    for (int i = 0; i < 4; ++i)
    {
      int randomOption = 0;

      int randomValue = 0;

      if (numberOfLines > i)
      {
        randomOption = Randomizer.nextInt(25);

        while (flameOptionList[0] == randomOption || flameOptionList[1] == randomOption || flameOptionList[2] == randomOption || flameOptionList[3] == randomOption || randomOption == 12 || randomOption == 14 || randomOption == 15 || randomOption == 16 || !GameConstants.isWeapon(this.getItemId()) && (randomOption == 21 || randomOption == 23))
        {
          randomOption = Randomizer.nextInt(25);
        }

        flameOptionList[i] = randomOption;

        randomValue = minValue;


        // 最大最小值差4, 概率分布
        // 普通装备 40 40 10 15 5
        // BOSS装备 10 20 30 30 10
        // 5% 很少? 官服只有 1%!

        chance = Randomizer.nextInt(100);

        if (isBossItem)
        {
          if (chance > 90)
          {
            randomValue = maxValue;
          }
          else if (chance > 70)
          {
            randomValue = maxValue - 1;
          }
          else if (chance > 40)
          {
            randomValue = maxValue - 2;
          }
          else if (chance > 10)
          {
            randomValue = maxValue - 3;
          }
        }
        else
        {
          if (chance > 95)
          {
            randomValue = maxValue;
          }
          else if (chance > 90)
          {
            randomValue = maxValue - 1;
          }
          else if (chance > 80)
          {
            randomValue = maxValue - 2;
          }
          else if (chance > 40)
          {
            randomValue = maxValue - 3;
          }
        }

        System.out.println("当前随机第 " + i + " 条火花! randomValue = " + randomValue + "; chance = " + chance + "; randomOption = " + randomOption);

        flameResultList[i] = randomOption * 10L + randomValue;
      }

      for (int j = 0; j < i; ++j)
      {
        int n = i;
        flameResultList[n] = flameResultList[n] * 1000L;
      }
    }

    long flame = flameResultList[0] + flameResultList[1] + flameResultList[2] + flameResultList[3];

    // 不会更新火花, 只是计算出结果
    return flame;
  }

  public long calcZeroNewFlame (int scrollId)
  {
    if (GameConstants.isRing(this.getItemId()) || this.getItemId() / 1000 == 1092 || this.getItemId() / 1000 == 1342 || this.getItemId() / 1000 == 1713 || this.getItemId() / 1000 == 1712 || this.getItemId() / 1000 == 1152 || this.getItemId() / 1000 == 1142 || this.getItemId() / 1000 == 1143 || this.getItemId() / 1000 == 1672 || GameConstants.isSecondaryWeapon(this.getItemId()) || this.getItemId() / 1000 == 1190 || this.getItemId() / 1000 == 1191 || this.getItemId() / 1000 == 1182 || this.getItemId() / 1000 == 1662 || this.getItemId() / 1000 == 1802)
    {
      return 0L;
    }


    // 再别说了, 神之子的武器就是BOSS武器, 别问, 问就是我的怜悯
    int minValue = 4;

    int maxValue = 8;

    int numberOfLines = 4;

    if (MapleItemInformationProvider.getInstance().getName(scrollId) != null)
    {
      if (MapleItemInformationProvider.getInstance().getName(scrollId).contains("강력한 환생의"))
      {
        minValue = 5;
        maxValue = 9;
      }
      if (MapleItemInformationProvider.getInstance().getName(scrollId).contains("강력한 환생의") || MapleItemInformationProvider.getInstance().getName(scrollId).contains("검은 환생의"))
      {
        minValue = 8;
        maxValue = 12;
      }
    }

    long[] rebirth = new long[] { -1L, -1L, -1L, -1L };

    int[] rebirthOptions = new int[] { -1, -1, -1, -1 };


    for (int i = 0; i < 4; ++i)
    {
      int randomOption = 1;

      int randomValue = 0;

      if (numberOfLines > i)
      {
        randomOption = Randomizer.nextInt(25);

        while (rebirthOptions[0] == randomOption || rebirthOptions[1] == randomOption || rebirthOptions[2] == randomOption || rebirthOptions[3] == randomOption || randomOption == 12 || randomOption == 14 || randomOption == 15 || randomOption == 16 || !GameConstants.isWeapon(this.getItemId()) && (randomOption == 21 || randomOption == 23))
        {
          randomOption = Randomizer.nextInt(25);
        }

        rebirthOptions[i] = randomOption;

        randomValue = minValue;


        // 最大最小值差4, 概率分布
        // 普通装备 40 40 10 5 5
        // BOSS装备 8 32 32 20 8
        // 5% 很少? 官服只有 1%!

        int chance = Randomizer.nextInt(100);


        if (chance > 92)
        {
          randomValue = maxValue;
        }
        else if (chance > 72)
        {
          randomValue = maxValue - 1;
        }
        else if (chance > 40)
        {
          randomValue = maxValue - 2;
        }
        else if (chance > 8)
        {
          randomValue = maxValue - 3;
        }

        System.out.println("当前随机第 " + i + " 条火花! randomValue = " + randomValue + "; chance = " + chance + "; randomOption = " + randomOption);
      }

      rebirth[i] = randomOption * 10L + randomValue;

      for (int j = 0; j < i; ++j)
      {
        int n = i;
        rebirth[n] = rebirth[n] * 1000L;
      }

    }

    long flame = rebirth[0] + rebirth[1] + rebirth[2] + rebirth[3];

    return flame;
  }

  public int getMoru ()
  {
    return this.moru;
  }

  public void setMoru (int moru)
  {
    this.moru = moru;
  }

  public void 亞克回真 ()
  {
    this.setStarForceLevel((byte) 0);
    this.calcStarForceStats();
  }

  public void 普通回真 ()
  {
    this.亞克回真();
    this.resetFlame();
    this.resetEnchantScroll();
  }

  public void 完美回真 ()
  {
    this.普通回真();
    this.设置装备后不可交易();
  }

  public void 设置装备后不可交易 ()
  {
    setFlag(0);
  }

  public int getEquipmentType ()
  {
    return this.equipmentType;
  }

  public void setEquipmentType (int equipmentType)
  {
    this.equipmentType = equipmentType;
  }

  public short getEnchantBossDamage ()
  {
    return enchantBossDamage;
  }


  public void setEnchantBossDamage (byte enchantBossDamage)
  {
    this.enchantBossDamage = enchantBossDamage;
  }

  public short getEnchantIgnorePDR ()
  {
    return enchantIgnorePDR;
  }


  public void setEnchantIgnorePDR (byte enchantIgnorePDR)
  {
    this.enchantIgnorePDR = enchantIgnorePDR;
  }

  public short getEnchantStr ()
  {
    return this.enchantStr;
  }

  public short getStarForceStr ()
  {
    return starForceStr;
  }

  public void setStarForceStr (short starForceStr)
  {
    this.starForceStr = starForceStr;
  }

  public short getStarForceDex ()
  {
    return starForceDex;
  }

  public void setStarForceDex (short starForceDex)
  {
    this.starForceDex = starForceDex;
  }

  public short getStarForceInt ()
  {
    return starForceInt;
  }

  public void setStarForceInt (short starForceInt)
  {
    this.starForceInt = starForceInt;
  }

  public short getStarForceLuk ()
  {
    return starForceLuk;
  }

  public void setStarForceLuk (short starForceLuk)
  {
    this.starForceLuk = starForceLuk;
  }

  public short getStarForceHp ()
  {
    return starForceHp;
  }

  public void setStarForceHp (short starForceHp)
  {
    this.starForceHp = starForceHp;
  }

  public short getStarForceMp ()
  {
    return starForceMp;
  }

  public void setStarForceMp (short starForceMp)
  {
    this.starForceMp = starForceMp;
  }

  public short getStarForceWdef ()
  {
    return starForceWdef;
  }

  public void setStarForceWdef (short starForceWdef)
  {
    this.starForceWdef = starForceWdef;
  }

  public short getStarForceMdef ()
  {
    return starForceMdef;
  }

  public void setStarForceMdef (short starForceMdef)
  {
    this.starForceMdef = starForceMdef;
  }

  public short getStarForceAccuracy ()
  {
    return starForceAccuracy;
  }

  public void setStarForceAccuracy (short starForceAccuracy)
  {
    this.starForceAccuracy = starForceAccuracy;
  }

  public short getStarForceAvoid ()
  {
    return starForceAvoid;
  }

  public void setStarForceAvoid (short starForceAvoid)
  {
    this.starForceAvoid = starForceAvoid;
  }

  public short getStarForceWatk ()
  {
    return starForceWatk;
  }

  public void setStarForceWatk (short starForceWatk)
  {
    this.starForceWatk = starForceWatk;
  }

  public short getStarForceMatk ()
  {
    return starForceMatk;
  }

  public void setStarForceMatk (short starForceMatk)
  {
    this.starForceMatk = starForceMatk;
  }

  public void resetStarForceStats ()
  {
    this.starForceAvoid = 0;

    this.starForceAccuracy = 0;

    this.starForceMdef = 0;

    this.starForceWdef = 0;

    this.starForceMatk = 0;

    this.starForceWatk = 0;

    this.starForceStr = 0;

    this.starForceDex = 0;

    this.starForceInt = 0;

    this.starForceLuk = 0;

    this.starForceHp = 0;

    this.starForceMp = 0;

    this.starForceMovementSpeed = 0;

    this.starForceJump = 0;
  }

  public void calcStarForceStats ()
  {
    this.resetStarForceStats();

    StarForceStats starForceStats = EquipmentEnchant.calcStarForceStats(this);

    this.starForceStats = starForceStats;

    if (starForceStats.getFlag(EnchantFlag.Str) != null)
    {
      setStarForceStr(starForceStats.getFlag(EnchantFlag.Str).right.shortValue());
    }

    if (starForceStats.getFlag(EnchantFlag.Dex) != null)
    {
      setStarForceDex(starForceStats.getFlag(EnchantFlag.Dex).right.shortValue());
    }

    if (starForceStats.getFlag(EnchantFlag.Int) != null)
    {
      setStarForceInt(starForceStats.getFlag(EnchantFlag.Int).right.shortValue());
    }

    if (starForceStats.getFlag(EnchantFlag.Luk) != null)
    {
      setStarForceLuk(starForceStats.getFlag(EnchantFlag.Luk).right.shortValue());
    }

    if (starForceStats.getFlag(EnchantFlag.Watk) != null)
    {
      setStarForceWatk(starForceStats.getFlag(EnchantFlag.Watk).right.shortValue());
    }

    if (starForceStats.getFlag(EnchantFlag.Matk) != null)
    {
      setStarForceMatk(starForceStats.getFlag(EnchantFlag.Matk).right.shortValue());
    }

    if (starForceStats.getFlag(EnchantFlag.Wdef) != null)
    {
      setStarForceWdef(starForceStats.getFlag(EnchantFlag.Wdef).right.shortValue());
    }

    if (starForceStats.getFlag(EnchantFlag.Mdef) != null)
    {
      setStarForceMdef(starForceStats.getFlag(EnchantFlag.Mdef).right.shortValue());
    }

    if (starForceStats.getFlag(EnchantFlag.Hp) != null)
    {
      setStarForceHp(starForceStats.getFlag(EnchantFlag.Hp).right.shortValue());
    }

    if (starForceStats.getFlag(EnchantFlag.Mp) != null)
    {
      setStarForceMp(starForceStats.getFlag(EnchantFlag.Mp).right.shortValue());
    }

    if (starForceStats.getFlag(EnchantFlag.Acc) != null)
    {
      setStarForceAccuracy(starForceStats.getFlag(EnchantFlag.Acc).right.shortValue());
    }

    if (starForceStats.getFlag(EnchantFlag.Avoid) != null)
    {
      setStarForceAvoid(starForceStats.getFlag(EnchantFlag.Avoid).right.shortValue());
    }
  }

  public short getEnchantJump ()
  {
    return enchantJump;
  }

  public void setEnchantJump (short enchantJump)
  {
    this.enchantJump = enchantJump;
  }

  public void setEnchantStr (short enchantStr)
  {
    this.enchantStr = enchantStr;
  }

  public short getEnchantDex ()
  {
    return this.enchantDex;
  }

  public void setEnchantDex (short enchantDex)
  {
    this.enchantDex = enchantDex;
  }

  public short getEnchantInt ()
  {
    return this.enchantInt;
  }

  public void setEnchantInt (short enchantInt)
  {
    this.enchantInt = enchantInt;
  }

  public short getEnchantLuk ()
  {
    return this.enchantLuk;
  }

  public void setEnchantLuk (short enchantLuk)
  {
    this.enchantLuk = enchantLuk;
  }

  public short getEnchantHp ()
  {
    return this.enchantHp;
  }

  public void setEnchantHp (short enchantHp)
  {
    this.enchantHp = enchantHp;
  }

  public short getEnchantMp ()
  {
    return this.enchantMp;
  }

  public void setEnchantMp (short enchantMp)
  {
    this.enchantMp = enchantMp;
  }

  public short getEnchantAccuracy ()
  {
    return this.enchantAccuracy;
  }

  public void setEnchantAccuracy (short enchantAccuracy)
  {
    this.enchantAccuracy = enchantAccuracy;
  }

  public short getEnchantAvoid ()
  {
    return this.enchantAvoid;
  }

  public void setEnchantAvoid (short enchantAvoid)
  {
    this.enchantAvoid = enchantAvoid;
  }

  public short getEnchantWatk ()
  {
    return this.enchantWatk;
  }

  public void setEnchantWatk (short enchantWatk)
  {
    this.enchantWatk = enchantWatk;
  }

  public short getEnchantMatk ()
  {
    return this.enchantMatk;
  }

  public void setEnchantMatk (short enchantMatk)
  {
    this.enchantMatk = enchantMatk;
  }

  public short getTotalStr ()
  {
    return (short) (this.getTemplate().getStr() + enchantStr + starForceStr + flameStr + authenticStr);
  }

  public short getTotalDex ()
  {
    return (short) (this.getTemplate().getDex() + enchantDex + starForceDex + flameDex + arcDex + authenticDex);
  }

  public short getTotalInt ()
  {
    return (short) (this.getTemplate().getInt() + enchantInt + starForceInt + flameInt + arcInt + authenticInt);
  }

  public short getTotalLuk ()
  {
    return (short) (this.getTemplate().getLuk() + enchantLuk + starForceLuk + flameLuk + arcLuk + authenticLuk);
  }

  public short getTotalHp ()
  {
    return (short) (this.getTemplate().getHp() + enchantHp + starForceHp + flameHp + arcHp + authenticHp);
  }

  public short getTotalMp ()
  {
    return (short) (this.getTemplate().getMp() + enchantMp + starForceMp + flameMp);
  }

  public short getTotalAccuracy ()
  {
    return (short) (this.getTemplate().getAccuracy() + enchantAccuracy + starForceAccuracy);
  }

  public short getTotalAvoid ()
  {
    return (short) (this.getTemplate().getAvoid() + enchantAvoid + starForceAvoid);
  }

  public short getTotalWatk ()
  {
    return (short) (this.getTemplate().getWatk() + enchantWatk + starForceWatk + flameWatk);
  }

  public short getTotalMatk ()
  {
    return (short) (this.getTemplate().getMatk() + enchantMatk + starForceMatk + flameMatk);
  }

  public short getTotalWdef ()
  {
    return (short) (this.getTemplate().getWdef() + enchantWdef + starForceWdef + flameDef);
  }

  public short getTotalMdef ()
  {
    return (short) (this.getTemplate().getMdef() + enchantMdef + starForceMdef + flameDef);
  }

  public short getEnchantWdef ()
  {
    return this.enchantWdef;
  }

  public void setEnchantWdef (short enchantWdef)
  {
    this.enchantWdef = enchantWdef;
  }

  public short getEnchantMdef ()
  {
    return this.enchantMdef;
  }

  public void setEnchantMdef (short enchantMdef)
  {
    this.enchantMdef = enchantMdef;
  }

  public long getOptionExpiration ()
  {
    return this.optionexpiration;
  }

  public void setOptionExpiration (long a)
  {
    this.optionexpiration = a;
  }

  public int getCoption1 ()
  {
    return this.Coption1;
  }

  public void setCoption1 (int a)
  {
    this.Coption1 = a;
  }

  public int getCoption2 ()
  {
    return this.Coption2;
  }

  public void setCoption2 (int a)
  {
    this.Coption2 = a;
  }

  public int getCoption3 ()
  {
    return this.Coption3;
  }

  public void setCoption3 (int a)
  {
    this.Coption3 = a;
  }

  public EquipmentScroll getShowScrollOption ()
  {
    return showScrollOption;
  }

  public void setShowScrollOption (EquipmentScroll showScrollOption)
  {
    this.showScrollOption = showScrollOption;
  }

  public short getStarForceMovementSpeed ()
  {
    return starForceMovementSpeed;
  }

  public void setStarForceMovementSpeed (short starForceMovementSpeed)
  {
    this.starForceMovementSpeed = starForceMovementSpeed;
  }

  public short getFlameMovementSpeed ()
  {
    return flameMovementSpeed;
  }

  public void setFlameMovementSpeed (short flameMovementSpeed)
  {
    this.flameMovementSpeed = flameMovementSpeed;
  }

  public short getEnchantMovementSpeed ()
  {
    return enchantMovementSpeed;
  }

  public void setEnchantMovementSpeed (short enchantMovementSpeed)
  {
    this.enchantMovementSpeed = enchantMovementSpeed;
  }

  public short getStarForceJump ()
  {
    return starForceJump;
  }

  public void setStarForceJump (short starForceJump)
  {
    this.starForceJump = starForceJump;
  }

  public short getEnchantCraft ()
  {
    return enchantCraft;
  }

  public void setEnchantCraft (short enchantCraft)
  {
    this.enchantCraft = enchantCraft;
  }

  public int getArcStr ()
  {
    return arcStr;
  }

  public void setArcStr (int arcStr)
  {
    this.arcStr = arcStr;
  }

  public int getArcDex ()
  {
    return arcDex;
  }

  public void setArcDex (int arcDex)
  {
    this.arcDex = arcDex;
  }

  public int getArcInt ()
  {
    return arcInt;
  }

  public void setArcInt (int arcInt)
  {
    this.arcInt = arcInt;
  }

  public int getArcLuk ()
  {
    return arcLuk;
  }

  public void setArcLuk (int arcLuk)
  {
    this.arcLuk = arcLuk;
  }

  public int getArcHp ()
  {
    return arcHp;
  }

  public void setArcHp (int arcHp)
  {
    this.arcHp = arcHp;
  }

  public int getAuthenticStr ()
  {
    return authenticStr;
  }

  public void setAuthenticStr (int authenticStr)
  {
    this.authenticStr = authenticStr;
  }

  public int getAuthenticDex ()
  {
    return authenticDex;
  }

  public void setAuthenticDex (int authenticDex)
  {
    this.authenticDex = authenticDex;
  }

  public int getAuthenticInt ()
  {
    return authenticInt;
  }

  public void setAuthenticInt (int authenticInt)
  {
    this.authenticInt = authenticInt;
  }

  public int getAuthenticLuk ()
  {
    return authenticLuk;
  }

  public void setAuthenticLuk (int authenticLuk)
  {
    this.authenticLuk = authenticLuk;
  }

  public int getAuthenticHp ()
  {
    return authenticHp;
  }

  public void setAuthenticHp (int authenticHp)
  {
    this.authenticHp = authenticHp;
  }

  public EquipTemplate getTemplate ()
  {
    return template;
  }

  public void setTemplate (EquipTemplate template)
  {
    this.template = template;
  }

  public short getCharmEXP ()
  {
    return charmEXP;
  }

  public void setCharmEXP (short charmEXP)
  {
    this.charmEXP = charmEXP;
  }

  public byte getEnchantReductReqLevel ()
  {
    return enchantReductReqLevel;
  }

  public void setEnchantReductReqLevel (byte enchantReductReqLevel)
  {
    this.enchantReductReqLevel = enchantReductReqLevel;
  }

  public int getAuthenticLevel ()
  {
    return authenticLevel;
  }

  public void setAuthenticLevel (int authenticLevel)
  {
    this.authenticLevel = authenticLevel;
  }

  public int getAuthenticPower ()
  {
    return authenticPower;
  }

  public void setAuthenticPower (int authenticPower)
  {
    this.authenticPower = authenticPower;
  }

  public int getAuthenticExp ()
  {
    return authenticExp;
  }

  public void setAuthenticExp (int authenticExp)
  {
    this.authenticExp = authenticExp;
  }

  public 裝備潛能等級 獲取附加潛能等級 ()
  {
    return 附加潛能等級;
  }

  public void 設置附加潛能等級 (裝備潛能等級 附加潛能等級)
  {
    this.附加潛能等級 = 附加潛能等級;
  }

  public void 設置附加潛能等級 (byte state)
  {
    switch (state)
    {
      case 1:
        潛能等級 = 裝備潛能等級.特殊未鑑定;
        break;
      case 2:
        潛能等級 = 裝備潛能等級.稀有未鑑定;
        break;
      case 3:
        潛能等級 = 裝備潛能等級.罕見未鑑定;
        break;
      case 4:
        潛能等級 = 裝備潛能等級.傳說未鑑定;
        break;
      case 17:
        潛能等級 = 裝備潛能等級.特殊;
        break;
      case 18:
        潛能等級 = 裝備潛能等級.稀有;
        break;
      case 19:
        潛能等級 = 裝備潛能等級.罕見;
        break;
      case 20:
        潛能等級 = 裝備潛能等級.傳說;
        break;
      default:
        潛能等級 = 裝備潛能等級.沒有潛能;
        break;
    }
  }


  public enum ScrollResult
  {
    SUCCESS, FAIL, CURSE

  }
}

