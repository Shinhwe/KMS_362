package client.inventory;

import client.MapleCharacter;
import constants.GameConstants;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.enchant.EnchantFlag;
import server.enchant.EquipmentEnchant;
import server.enchant.EquipmentScroll;
import server.enchant.StarForceStats;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Equip extends Item implements Serializable
{
  public static final int ARMOR_RATIO = 350000;
  public static final int WEAPON_RATIO = 700000;
  public StarForceStats starForceStats = new StarForceStats(new ArrayList<>());
  private byte state = 0;
  private byte lines = 0;
  private byte extraUpgradeSlots = 0;
  private byte upgradeSlots = 0;
  private byte successUpgradeSlots = 0;
  private byte failUpgradeSlots = 0;
  private byte enchantLevel = 0;
  private byte vicioushammer = 0;
  private byte starForceLevel = 0;
  private byte reqLevel = 0;
  private byte yggdrasilWisdom = 0;
  private byte totalDamage = 0;
  private byte allStat = 0;
  private byte karmaCount = (byte) -1;
  private short str = 0;
  private short dex = 0;
  private short _int = 0;
  private short luk = 0;
  private short arc = 0;
  private short hp = 0;
  private short mp = 0;
  private short watk = 0;
  private short matk = 0;
  private short wdef = 0;
  private short mdef = 0;
  private short acc = 0;
  private short avoid = 0;
  private short hands = 0;
  private short speed = 0;
  private short jump = 0;
  private short charmExp = 0;
  private short pvpDamage = 0;
  private short bossDamage = 0;
  private short ignorePDR = 0;
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
  private short enchantAcc = 0;
  private short enchantAvoid = 0;
  private short enchantWatk = 0;
  private short enchantMatk = 0;
  private short enchantJump = 0;
  private short flameStr = 0;
  private short flameDex = 0;
  private short flameInt = 0;
  private short flameLuk = 0;
  private short flameWatk = 0;
  private short flameMatk = 0;
  private short flameHp = 0;
  private short flameMp = 0;
  private short flameSpeed = 0;
  private short flameJump = 0;
  private short flameDamage = 0;
  private short flameBossDamage = 0;
  private short flameAllStat = 0;
  private short flameReductReqLevel = 0;
  
  private short flameDef = 0;
  private short starForceStr = 0;
  private short starForceDex = 0;
  private short starForceInt = 0;
  private short starForceLuk = 0;
  private short starForceHp = 0;
  private short starForceMp = 0;
  private short starForceWdef = 0;
  private short starForceMdef = 0;
  private short starForceAcc = 0;
  private short starForceAvoid = 0;
  private short starForceWatk = 0;
  private short starForceMatk = 0;
  private int arcexp = 0;
  private int arclevel = 0;
  
  private int arcStr = 0;
  
  private int arcDex = 0;
  
  private int arcInt = 0;
  
  private int arcLuk = 0;
  
  private int arcHp = 0;
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
  private int attackSpeed = 0;
  private int Coption1 = 0;
  private int Coption2 = 0;
  private int Coption3 = 0;
  private long flame = 0L;
  private long optionexpiration = 0L;
  private boolean finalStrike = false;
  
  private EquipmentScroll showScrollOption;
  private List<EquipStat> stats = new LinkedList<EquipStat>();
  private List<EquipSpecialStat> specialStats = new LinkedList<EquipSpecialStat>();

  public Equip (int id, short position, int flag)
  {
    super(id, position, (short) 1, flag);
  }

  public Equip (int id, short position, long uniqueid, int flag)
  {
    super(id, position, (short) 1, flag, uniqueid);
  }

  public static Equip calculateEquipStats (Equip eq)
  {

    eq.getStats().clear();

    eq.getSpecialStats().clear();

    if (eq.getUpgradeSlots() > 0)
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
    if (eq.getHands() > 0)
    {
      eq.getStats().add(EquipStat.HANDS);
    }
    if (eq.getSpeed() > 0)
    {
      eq.getStats().add(EquipStat.SPEED);
    }
    if (eq.getJump() > 0)
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
    if (eq.getDurability() > -1)
    {
      eq.getStats().add(EquipStat.DURABILITY);
    }
    if (eq.getViciousHammer() > 0)
    {
      eq.getStats().add(EquipStat.VICIOUS_HAMMER);
    }
    if (eq.getPVPDamage() > 0)
    {
      eq.getStats().add(EquipStat.PVP_DAMAGE);
    }
    if (eq.getEnchantBuff() > 0)
    {
      eq.getStats().add(EquipStat.ENHANCT_BUFF);
    }
    if (eq.getReqLevel() > 0)
    {
      eq.getStats().add(EquipStat.REQUIRED_LEVEL);
    }
    else if (eq.getReqLevel() < 0)
    {
      eq.getStats().add(EquipStat.DOWNLEVEL);
    }
    if (eq.getYggdrasilWisdom() > 0)
    {
      eq.getStats().add(EquipStat.YGGDRASIL_WISDOM);
    }
    if (eq.getFinalStrike())
    {
      eq.getStats().add(EquipStat.FINAL_STRIKE);
    }
    if (eq.getBossDamage() > 0)
    {
      eq.getStats().add(EquipStat.IndieBdr);
    }
    if (eq.getIgnorePDR() > 0)
    {
      eq.getStats().add(EquipStat.IGNORE_PDR);
    }
    if (eq.getTotalDamage() > 0)
    {
      eq.getSpecialStats().add(EquipSpecialStat.TOTAL_DAMAGE);
    }
    if (eq.getAllStat() > 0)
    {
      eq.getSpecialStats().add(EquipSpecialStat.ALL_STAT);
    }
    if (eq.getFlame() >= -1L)
    {
      eq.getSpecialStats().add(EquipSpecialStat.KARMA_COUNT);
    }
    if (eq.getFlame() > 0L)
    {
      eq.getSpecialStats().add(EquipSpecialStat.REBIRTH_FIRE);
    }
    if (eq.getEquipmentType() > 0)
    {
      eq.getSpecialStats().add(EquipSpecialStat.EQUIPMENT_TYPE);
    }

    eq.calcStarForceStats();
    
    eq.calcFlameStats();

    return (Equip) eq.copy();
  }

  public void set (Equip set)
  {
    this.str = set.str;
    this.dex = set.dex;
    this._int = set._int;
    this.luk = set.luk;
    this.arc = set.arc;
    this.arclevel = set.arclevel;
    this.arcexp = set.arcexp;
    this.hp = set.hp;
    this.mp = set.mp;
    this.matk = set.matk;
    this.mdef = set.mdef;
    this.watk = set.watk;
    this.wdef = set.wdef;
    this.acc = set.acc;
    this.avoid = set.avoid;
    this.hands = set.hands;
    this.speed = set.speed;
    this.jump = set.jump;
    this.starForceLevel = set.starForceLevel;
    this.upgradeSlots = set.upgradeSlots;
    this.enchantLevel = set.enchantLevel;
    this.durability = set.durability;
    this.vicioushammer = set.vicioushammer;
    this.potential1 = set.potential1;
    this.potential2 = set.potential2;
    this.potential3 = set.potential3;
    this.potential4 = set.potential4;
    this.potential5 = set.potential5;
    this.potential6 = set.potential6;
    this.charmExp = set.charmExp;
    this.pvpDamage = set.pvpDamage;
    this.incSkill = set.incSkill;
    this.enchantBuff = set.enchantBuff;
    this.reqLevel = set.reqLevel;
    this.yggdrasilWisdom = set.yggdrasilWisdom;
    this.finalStrike = set.finalStrike;
    this.bossDamage = set.bossDamage;
    this.ignorePDR = set.ignorePDR;
    this.totalDamage = set.totalDamage;
    this.allStat = set.allStat;
    this.karmaCount = set.karmaCount;
    this.soulname = set.soulname;
    this.soulenchanter = set.soulenchanter;
    this.soulpotential = set.soulpotential;
    this.soulskill = set.soulskill;
    this.stats = set.stats;
    this.specialStats = set.specialStats;
    this.state = set.state;
    this.lines = set.lines;
    this.flame = set.flame;
    this.moru = set.moru;
    this.enchantStr = set.enchantStr;
    this.enchantDex = set.enchantDex;
    this.enchantInt = set.enchantInt;
    this.enchantLuk = set.enchantLuk;
    this.enchantHp = set.enchantHp;
    this.enchantMp = set.enchantMp;
    this.enchantAcc = set.enchantAcc;
    this.enchantAvoid = set.enchantAvoid;
    this.enchantWatk = set.enchantWatk;
    this.enchantMatk = set.enchantMatk;
    this.enchantWdef = set.enchantWdef;
    this.enchantMdef = set.enchantMdef;
    this.attackSpeed = set.attackSpeed;
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
    this.starForceAcc = set.starForceAcc;
    this.starForceAvoid = set.starForceAvoid;
    
    this.flameStr = set.flameStr;
    this.flameDex = set.flameDex;
    this.flameInt = set.flameInt;
    this.flameLuk = set.flameLuk;
    this.flameWatk = set.flameWatk;
    this.flameMatk = set.flameMatk;
    this.flameHp = set.flameHp;
    this.flameMp = set.flameMp;
    this.flameSpeed = set.flameMp;
    this.flameJump = set.flameJump;
    this.flameDamage = set.flameDamage;
    this.flameBossDamage = set.flameBossDamage;
    this.flameAllStat = set.flameAllStat;
    this.flameReductReqLevel = set.flameReductReqLevel;
    this.flameDef = set.flameDef;
  }

  @Override
  public Item copy ()
  {
    Equip ret = new Equip(this.getItemId(), this.getPosition(), this.getUniqueId(), this.getFlag());
    ret.str = this.str;
    ret.dex = this.dex;
    ret._int = this._int;
    ret.luk = this.luk;
    ret.arc = this.arc;
    ret.arcexp = this.arcexp;
    ret.arclevel = this.arclevel;
    ret.hp = this.hp;
    ret.mp = this.mp;
    ret.matk = this.matk;
    ret.mdef = this.mdef;
    ret.watk = this.watk;
    ret.wdef = this.wdef;
    ret.acc = this.acc;
    ret.avoid = this.avoid;
    ret.hands = this.hands;
    ret.speed = this.speed;
    ret.jump = this.jump;
    ret.starForceLevel = this.starForceLevel;
    ret.upgradeSlots = this.upgradeSlots;
    ret.enchantLevel = this.enchantLevel;
    ret.durability = this.durability;
    ret.vicioushammer = this.vicioushammer;
    ret.potential1 = this.potential1;
    ret.potential2 = this.potential2;
    ret.potential3 = this.potential3;
    ret.potential4 = this.potential4;
    ret.potential5 = this.potential5;
    ret.potential6 = this.potential6;
    ret.charmExp = this.charmExp;
    ret.pvpDamage = this.pvpDamage;
    ret.incSkill = this.incSkill;
    ret.enchantBuff = this.enchantBuff;
    ret.reqLevel = this.reqLevel;
    ret.yggdrasilWisdom = this.yggdrasilWisdom;
    ret.finalStrike = this.finalStrike;
    ret.bossDamage = this.bossDamage;
    ret.ignorePDR = this.ignorePDR;
    ret.totalDamage = this.totalDamage;
    ret.allStat = this.allStat;
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
    ret.state = this.state;
    ret.lines = this.lines;
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
    ret.enchantAcc = this.enchantAcc;
    ret.enchantAvoid = this.enchantAvoid;
    ret.enchantWatk = this.enchantWatk;
    ret.enchantMatk = this.enchantMatk;
    ret.enchantWdef = this.enchantWdef;
    ret.enchantMdef = this.enchantMdef;
    ret.attackSpeed = this.attackSpeed;
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
    ret.starForceAcc = this.starForceAcc;
    ret.starForceAvoid = this.starForceAvoid;
    
    
    ret.flameStr = this.flameStr;
    ret.flameDex = this.flameDex;
    ret.flameInt = this.flameInt;
    ret.flameLuk = this.flameLuk;
    ret.flameWatk = this.flameWatk;
    ret.flameMatk = this.flameMatk;
    ret.flameHp = this.flameHp;
    ret.flameMp = this.flameMp;
    ret.flameSpeed = this.flameMp;
    ret.flameJump = this.flameJump;
    ret.flameDamage = this.flameDamage;
    ret.flameBossDamage = this.flameBossDamage;
    ret.flameAllStat = this.flameAllStat;
    ret.flameReductReqLevel = this.flameReductReqLevel;
    ret.flameDef = this.flameDef;
    return ret;
  }

  @Override
  public byte getType ()
  {
    return 1;
  }

  public byte getUpgradeSlots ()
  {
    return (byte)(this.upgradeSlots + this.extraUpgradeSlots - this.failUpgradeSlots - this.successUpgradeSlots);
  }

//  public void setUpgradeSlots (byte upgradeSlots)
//  {
//    this.upgradeSlots = upgradeSlots;
//  }
  
  public byte getExtraUpgradeSlots()
  {
    return extraUpgradeSlots;
  }
  
  public void setExtraUpgradeSlots(byte extraUpgradeSlots)
  {
    this.extraUpgradeSlots = extraUpgradeSlots;
  }
  
  public byte getFailUpgradeSlots()
  {
    return failUpgradeSlots;
  }
  
  public void setFailUpgradeSlots(byte failUpgradeSlots)
  {
    this.failUpgradeSlots = failUpgradeSlots;
  }
  
  public byte getSuccessUpgradeSlots()
  {
    return successUpgradeSlots;
  }
  
  public void setSuccessUpgradeSlots(byte successUpgradeSlots)
  {
    this.successUpgradeSlots = successUpgradeSlots;
  }
  

  public short getStr ()
  {
    return this.str;
  }

//  public void setStr (short str)
//  {
//    if (str < 0)
//    {
//      str = 0;
//    }
//    this.str = str;
//  }

  public short getDex ()
  {
    return this.dex;
  }

//  public void setDex (short dex)
//  {
//    if (dex < 0)
//    {
//      dex = 0;
//    }
//    this.dex = dex;
//  }

  public short getInt ()
  {
    return this._int;
  }

//  public void setInt (short _int)
//  {
//    if (_int < 0)
//    {
//      _int = 0;
//    }
//    this._int = _int;
//  }

  public short getLuk ()
  {
    return this.luk;
  }

//  public void setLuk (short luk)
//  {
//    if (luk < 0)
//    {
//      luk = 0;
//    }
//    this.luk = luk;
//  }

  public short getArc ()
  {
    return this.arc;
  }

  public void setArc (short arc)
  {
    if (arc < 0)
    {
      arc = 0;
    }
    this.arc = arc;
  }

  public short getHp ()
  {
    return this.hp;
  }

//  public void setHp (short hp)
//  {
//    if (hp < 0)
//    {
//      hp = 0;
//    }
//    this.hp = hp;
//  }

  public short getMp ()
  {
    return this.mp;
  }

//  public void setMp (short mp)
//  {
//    if (mp < 0)
//    {
//      mp = 0;
//    }
//    this.mp = mp;
//  }

  public short getWatk ()
  {
    return this.watk;
  }

//  public void setWatk (short watk)
//  {
//    if (watk < 0)
//    {
//      watk = 0;
//    }
//    this.watk = watk;
//  }

  public short getMatk ()
  {
    return this.matk;
  }

//  public void setMatk (short matk)
//  {
//    if (matk < 0)
//    {
//      matk = 0;
//    }
//    this.matk = matk;
//  }

  public short getWdef ()
  {
    return this.wdef;
  }

//  public void setWdef (short wdef)
//  {
//    if (wdef < 0)
//    {
//      wdef = 0;
//    }
//    this.wdef = wdef;
//  }

  public short getMdef ()
  {
    return this.mdef;
  }

//  public void setMdef (short mdef)
//  {
//    if (mdef < 0)
//    {
//      mdef = 0;
//    }
//    this.mdef = mdef;
//  }

  public short getAcc ()
  {
    return this.acc;
  }

//  public void setAcc (short acc)
//  {
//    if (acc < 0)
//    {
//      acc = 0;
//    }
//    this.acc = acc;
//  }

  public short getAvoid ()
  {
    return this.avoid;
  }

//  public void setAvoid (short avoid)
//  {
//    if (avoid < 0)
//    {
//      avoid = 0;
//    }
//    this.avoid = avoid;
//  }

  public short getHands ()
  {
    return this.hands;
  }

//  public void setHands (short hands)
//  {
//    if (hands < 0)
//    {
//      hands = 0;
//    }
//    this.hands = hands;
//  }

  public short getSpeed ()
  {
    return (short) (this.speed + getFlameJump());
  }

//  public void setSpeed (short speed)
//  {
//    if (speed < 0)
//    {
//      speed = 0;
//    }
//    this.speed = speed;
//  }

  public short getJump ()
  {
    return (short) (this.jump + getFlameJump());
  }

//  public void setJump (short speed)
//  {
//    if (speed < 0)
//    {
//      speed = 0;
//    }
//    this.jump = speed;
//  }

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


  
  
  @Override
  public void setQuantity (short quantity)
  {
    // 设置数量无效, 但是父类提供了这个方法, 这里覆写掉
  }

  public int getDurability ()
  {
    return this.durability;
  }

  public void setDurability (int dur)
  {
    this.durability = dur;
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

  public byte getState ()
  {
    return this.state;
  }

  public void setState (byte state)
  {
    this.state = state;
  }

  public byte getLines ()
  {
    return this.lines;
  }

  public void setLines (byte lines)
  {
    this.lines = lines;
  }

  public void resetPotential_Fuse (boolean half, int potentialState)
  {
    potentialState = -potentialState;
    if (Randomizer.nextInt(100) < 4)
    {
      potentialState -= Randomizer.nextInt(100) < 4 ? 2 : 1;
    }
    this.setPotential1(potentialState);
    this.setPotential2(Randomizer.nextInt(half ? 5 : 10) == 0 ? potentialState : 0);
    this.setPotential3(0);
    this.setPotential4(0);
    this.setPotential5(0);
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

  public void renewPotential ()
  {
    int epic = 7;
    int unique = 5;
    if (this.getState() == 17 && Randomizer.nextInt(100) <= epic)
    {
      this.setState((byte) 2);
      return;
    }
    if (this.getState() == 18 && Randomizer.nextInt(100) <= unique)
    {
      this.setState((byte) 3);
      return;
    }
    if (this.getState() == 19 && Randomizer.nextInt(100) <= 2)
    {
      this.setState((byte) 4);
      return;
    }
    this.setState((byte) (this.getState() - 16));
  }

  public long getFlame ()
  {
    return this.flame;
  }

  public void setFlame (long flame)
  {
    this.flame = flame;
  }
  
  
  
  public short getFlameStr()
  {
    return flameStr;
  }
  
  public void setFlameStr(short flameStr)
  {
    this.flameStr = flameStr;
  }
  
  public short getFlameDex()
  {
    return flameDex;
  }
  
  public void setFlameDex(short flameDex)
  {
    this.flameDex = flameDex;
  }
  
  public short getFlameInt()
  {
    return flameInt;
  }
  
  public void setFlameInt(short flameInt)
  {
    this.flameInt = flameInt;
  }
  
  public short getFlameLuk()
  {
    return flameLuk;
  }
  
  public void setFlameLuk(short flameLuk)
  {
    this.flameLuk = flameLuk;
  }
  
  public short getFlameWatk()
  {
    return flameWatk;
  }
  
  public void setFlameWatk(short flameWatk)
  {
    this.flameWatk = flameWatk;
  }
  
  public short getFlameMatk()
  {
    return flameMatk;
  }
  
  public void setFlameMatk(short flameMatk)
  {
    this.flameMatk = flameMatk;
  }
  
  public short getFlameHp()
  {
    return flameHp;
  }
  
  public void setFlameHp(short flameHp)
  {
    this.flameHp = flameHp;
  }
  
  public short getFlameMp()
  {
    return flameMp;
  }
  
  public void setFlameMp(short flameMp)
  {
    this.flameMp = flameMp;
  }
  
  public short getFlameSpeed()
  {
    return flameSpeed;
  }
  
  public void setFlameSpeed(short flameSpeed)
  {
    this.flameSpeed = flameSpeed;
  }
  
  public short getFlameJump()
  {
    return flameJump;
  }
  
  public void setFlameJump(short flameJump)
  {
    this.flameJump = flameJump;
  }
  
  public short getFlameDamage()
  {
    return flameDamage;
  }
  
  public void setFlameDamage(short flameDamage)
  {
    this.flameDamage = flameDamage;
  }
  
  public short getFlameBossDamage()
  {
    return flameBossDamage;
  }
  
  public void setFlameBossDamage(short flameBossDamage)
  {
    this.flameBossDamage = flameBossDamage;
  }
  
  public short getFlameAllStat()
  {
    return flameAllStat;
  }
  
  public void setFlameAllStat(short flameAllStat)
  {
    this.flameAllStat = flameAllStat;
  }
  
  
  public short getFlameReductReqLevel()
  {
    return flameReductReqLevel;
  }
  
  public void setFlameReductReqLevel(short flameReductReqLevel)
  {
    this.flameReductReqLevel = flameReductReqLevel;
  }
  
  public short getFlameDef()
  {
    return flameDef;
  }
  
  public void setFlameDef(short flameDef)
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

  public short getCharmEXP ()
  {
    return this.charmExp;
  }

  public void setCharmEXP (short s)
  {
    this.charmExp = s;
  }

  public short getPVPDamage ()
  {
    return this.pvpDamage;
  }

  public void setPVPDamage (short p)
  {
    this.pvpDamage = p;
  }

  public short getEnchantBuff ()
  {
    return this.enchantBuff;
  }

  public void setEnchantBuff (short enchantBuff)
  {
    this.enchantBuff = enchantBuff;
  }

  public byte getReqLevel ()
  {
    return this.reqLevel;
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

  public short getBossDamage ()
  {
    return (byte)(this.bossDamage + this.getFlameBossDamage());
  }

//  public void setBossDamage (short bossDamage)
//  {
//    this.bossDamage = bossDamage;
//  }
  
  public short getIgnorePDR ()
  {
    return this.ignorePDR;
  }

//  public void setIgnorePDR (short ignorePDR)
//  {
//    this.ignorePDR = ignorePDR;
//  }

  public byte getTotalDamage ()
  {
    return (byte)(this.totalDamage + this.getFlameDamage());
  }

//  public void setTotalDamage (byte totalDamage)
//  {
//    this.totalDamage = totalDamage;
//  }

  public byte getAllStat ()
  {
    return (byte)(this.allStat + this.getAllStat());
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

  public int getArcEXP ()
  {
    return this.arcexp;
  }

  public void setArcEXP (int exp)
  {
    this.arcexp = exp;
  }

  public int getArcLevel ()
  {
    return this.arclevel;
  }

  public void setArcLevel (int lv)
  {
    this.arclevel = lv;
  }

  public void calcFlameStats ()
  {
    if (this.getFlame() == 0L)
    {
      return;
    }
    
    this.resetFlame();
    
    int[] rebirth = new int[4];
    
    String fire = String.valueOf(this.getFlame());
    
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
    else
    {
      return;
    }
    
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
    
    short reductReqLevel = 0;

    for (int i = 0; i < 4; ++i)
    {
      int randomOption = rebirth[i] / 10;
      
      int randomValue = rebirth[i] - rebirth[i] / 10 * 10;

      if (randomValue == 0) {
        continue;
      }
      
      switch (randomOption)
      {
        case 0:
        {
          incStr += (short) ((reqLevel / 20 + 1) * randomValue);
          continue;
        }
        case 1:
        {
          incDex += (short) ((reqLevel / 20 + 1) * randomValue);
          continue ;
        }
        case 2:
        {
          incInt += (short) ((reqLevel / 20 + 1) * randomValue);
          continue;
        }
        case 3:
        {
          incLuk += (short) ((reqLevel / 20 + 1) * randomValue);
          continue;
        }
        case 4:
        {
          incStr += (short) ((reqLevel / 40 + 1) * randomValue);
          incDex += (short) ((reqLevel / 40 + 1) * randomValue);
          continue;
        }
        case 5:
        {
          incStr += (short) ((reqLevel / 40 + 1) * randomValue);
          incInt += (short) ((reqLevel / 40 + 1) * randomValue);
          continue;
        }
        case 6:
        {
          incStr += (short) ((reqLevel / 40 + 1) * randomValue);
          incLuk += (short) ((reqLevel / 40 + 1) * randomValue);
          continue;
        }
        case 7:
        {
          incDex +=(short) ((reqLevel / 40 + 1) * randomValue);
          incInt +=(short) ((reqLevel / 40 + 1) * randomValue);
          continue;
        }
        case 8:
        {
          incDex +=(short) ((reqLevel / 40 + 1) * randomValue);
          incLuk +=(short) ((reqLevel / 40 + 1) * randomValue);
          continue;
        }
        case 9:
        {
          incInt +=(short) ((reqLevel / 40 + 1) * randomValue);
          incLuk +=(short) ((reqLevel / 40 + 1) * randomValue);
          continue;
        }
        case 10:
        {
          incHp += (short) (reqLevel / 10 * 10 * 3 * randomValue);
          continue;
        }
        case 11:
        {
          incMp += (short) (reqLevel / 10 * 10 * 3 * randomValue);
          continue;
        }
        case 13:
        {
          incDef += (short) ((reqLevel / 20 + 1) * randomValue);
          continue;
        }
        case 17:
        {
          if (GameConstants.isWeapon(this.getItemId()))
          {
            switch (randomValue)
            {
              case 3:
              {
                if (reqLevel <= 150)
                {
                  incWatk+=(short) (this.watk * 1200 / 10000 + 1);
                  continue;
                }
                if (reqLevel <= 160)
                {
                  incWatk+=(short) (this.watk * 1500 / 10000 + 1);
                  continue;
                }
                incWatk+=(short) (this.watk * 1800 / 10000 + 1);
                continue;
              }
              case 4:
              {
                if (reqLevel <= 150)
                {
                  incWatk+=(short) (this.watk * 1760 / 10000 + 1);
                  continue;
                }
                if (reqLevel <= 160)
                {
                  incWatk+=(short) (this.watk * 2200 / 10000 + 1);
                  continue;
                }
                incWatk+=(short) (this.watk * 2640 / 10000 + 1);
                continue;
              }
              case 5:
              {
                if (reqLevel <= 150)
                {
                  incWatk+=(short) (this.watk * 2420 / 10000 + 1);
                  continue;
                }
                if (reqLevel <= 160)
                {
                  incWatk+=(short) (this.watk * 3025 / 10000 + 1);
                  continue;
                }
                incWatk+=(short) (this.watk * 3630 / 10000 + 1);
                continue;
              }
              case 6:
              {
                if (reqLevel <= 150)
                {
                  incWatk+=(short) (this.watk * 3200 / 10000 + 1);
                  continue;
                }
                if (reqLevel <= 160)
                {
                  incWatk+=(short) (this.watk * 4000 / 10000 + 1);
                  continue;
                }
                incWatk+=(short) (this.watk * 4800 / 10000 + 1);
                continue;
              }
              case 7:
              {
                if (reqLevel <= 150)
                {
                  incWatk+=(short) (this.watk * 4100 / 10000 + 1);
                  continue;
                }
                if (reqLevel <= 160)
                {
                  incWatk+=(short) (this.watk * 5125 / 10000 + 1);
                  continue;
                }
                incWatk+=(short) (this.watk * 6150 / 10000 + 1);
              }
            }
            continue;
          }
          
          incWatk+=(short) randomValue;
          
          continue;
        }
        case 18:
        {
          if (GameConstants.isWeapon(this.getItemId()))
          {
            switch (randomValue)
            {
              case 3:
              {
                if (reqLevel <= 150)
                {
                  incMatk +=(short) (this.matk * 1200 / 10000 + 1);
                  continue;
                }
                if (reqLevel <= 160)
                {
                  incMatk +=(short) (this.matk * 1500 / 10000 + 1);
                  continue;
                }
                incMatk +=(short) (this.matk * 1800 / 10000 + 1);
                continue;
              }
              case 4:
              {
                if (reqLevel <= 150)
                {
                  incMatk +=(short) (this.matk * 1760 / 10000 + 1);
                  continue;
                }
                if (reqLevel <= 160)
                {
                  incMatk +=(short) (this.matk * 2200 / 10000 + 1);
                  continue;
                }
                incMatk +=(short) (this.matk * 2640 / 10000 + 1);
                continue;
              }
              case 5:
              {
                if (reqLevel <= 150)
                {
                  incMatk +=(short) (this.matk * 2420 / 10000 + 1);
                  continue;
                }
                if (reqLevel <= 160)
                {
                  incMatk +=(short) (this.matk * 3025 / 10000 + 1);
                  continue;
                }
                incMatk +=(short) (this.matk * 3630 / 10000 + 1);
                continue;
              }
              case 6:
              {
                if (reqLevel <= 150)
                {
                  incMatk +=(short) (this.matk * 3200 / 10000 + 1);
                  continue;
                }
                if (reqLevel <= 160)
                {
                  incMatk +=(short) (this.matk * 4000 / 10000 + 1);
                  continue;
                }
                incMatk +=(short) (this.matk * 4800 / 10000 + 1);
                continue;
              }
              case 7:
              {
                if (reqLevel <= 150)
                {
                  incMatk +=(short) (this.matk * 4100 / 10000 + 1);
                  continue;
                }
                if (reqLevel <= 160)
                {
                  incMatk +=(short) (this.matk * 5125 / 10000 + 1);
                  continue;
                }
                incMatk +=(short) (this.matk * 6150 / 10000 + 1);
              }
            }
            continue;
          }
          incMatk += (short) randomValue;
          continue;
        }
        case 19:
        {
          incSpeed += (short) randomValue;
          continue;
        }
        case 20:
        {
          incJump += (short) randomValue;
          continue;
        }
        case 21:
        {
          incBossDamage += (short)(randomValue * 2);
          continue;
        }
        case 22:
        {
          reductReqLevel += randomValue;
          continue;
        }
        case 23:
        {
          incDamage += (short) randomValue;
          continue;
        }
        case 24:
        {
          incAllStat += (short) randomValue;
        }
      }
    }
  }

  public void resetFlame ()
  {
    this.flame = 0;
    this.flameStr = 0;
    this.flameDex = 0;
    this.flameInt = 0;
    this.flameLuk = 0;
    this.flameWatk = 0;
    this.flameMatk = 0;
    this.flameHp = 0;
    this.flameMp = 0;
    this.flameSpeed = 0;
    this.flameJump = 0;
    this.flameDamage = 0;
    this.flameBossDamage = 0;
    this.flameAllStat = 0;
    this.flameReductReqLevel = 0;
  }

  public long calcNewFlame ( int scrollId )
  {
    if (GameConstants.isRing(this.getItemId()) || this.getItemId() / 1000 == 1092 || this.getItemId() / 1000 == 1342 || this.getItemId() / 1000 == 1713 || this.getItemId() / 1000 == 1712 || this.getItemId() / 1000 == 1152 || this.getItemId() / 1000 == 1142 || this.getItemId() / 1000 == 1143 || this.getItemId() / 1000 == 1672 || GameConstants.isSecondaryWeapon(this.getItemId()) || this.getItemId() / 1000 == 1190 || this.getItemId() / 1000 == 1191 || this.getItemId() / 1000 == 1182 || this.getItemId() / 1000 == 1662 || this.getItemId() / 1000 == 1802)
    {
      return 0L;
    }
    
    boolean isBossItem = GameConstants.isBossItem(getItemId());

    System.out.println("开始砸火花啦, 是BOSS物品吗? " + isBossItem);

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

      minValue = 4;

      maxValue = 8;
    }

    if (MapleItemInformationProvider.getInstance().getName(scrollId) != null)
    {
      if (MapleItemInformationProvider.getInstance().getName(scrollId).contains("강력한 환생의"))
      {
        if (isBossItem)
        {
          minValue = 5;
          maxValue = 9;
        }
        else
        {
          minValue = 2;
          maxValue = 6;
        }
      }
      if (MapleItemInformationProvider.getInstance().getName(scrollId).contains("영원한 환생의") || MapleItemInformationProvider.getInstance().getName(scrollId).contains("검은 환생의"))
      {
        if (isBossItem)
        {
          minValue = 8;
          maxValue = 12;
        }
        else
        {
          minValue = 3;
          maxValue = 7;
        }
      }
    }

    System.out.println("经过一顿夏姬八计算 numberOfLines = " + numberOfLines + "; minValue = " + minValue + "; maxValue = " + maxValue);

    Equip ordinary = (Equip) MapleItemInformationProvider.getInstance().getEquipById(this.getItemId(), false);

    short ordinaryPad = ordinary.watk > 0 ? ordinary.watk : ordinary.matk;

    short ordinaryMad = ordinary.matk > 0 ? ordinary.matk : ordinary.watk;

    MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();

    if ((ii.isKarmaEnabled(this.getItemId()) || ii.isPKarmaEnabled(this.getItemId())) && this.getKarmaCount() < 0)
    {
      this.setKarmaCount((byte) 10);
    }
    long[] rebirth = new long[] { -1L, -1L, -1L, -1L };
    
    int[] rebirthOptions = new int[] { -1, -1, -1, -1 };


    for (int i = 0; i < 4; ++i)
    {
      int randomOption = 0;
      
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
        
        chance = Randomizer.nextInt(100);
        
        if (isBossItem)
        {
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
      }

      rebirth[i] = randomOption * 10L + randomValue;

      for (int j = 0; j < i; ++j)
      {
        int n = i;
        rebirth[n] = rebirth[n] * 1000L;
      }

    }
    
    long flame = rebirth[0] + rebirth[1] + rebirth[2] + rebirth[3];
    
    // 不会更新火花, 只是计算出结果
    return flame;
  }

  public void setZeroRebirth (MapleCharacter chr, int scrollId)
  {
    if (GameConstants.isRing(this.getItemId()) || this.getItemId() / 1000 == 1092 || this.getItemId() / 1000 == 1342 || this.getItemId() / 1000 == 1713 || this.getItemId() / 1000 == 1712 || this.getItemId() / 1000 == 1152 || this.getItemId() / 1000 == 1142 || this.getItemId() / 1000 == 1143 || this.getItemId() / 1000 == 1672 || GameConstants.isSecondaryWeapon(this.getItemId()) || this.getItemId() / 1000 == 1190 || this.getItemId() / 1000 == 1191 || this.getItemId() / 1000 == 1182 || this.getItemId() / 1000 == 1662 || this.getItemId() / 1000 == 1802)
    {
      return;
    }

    Equip nEquip2 = (Equip) chr.getInventory(MapleInventoryType.EQUIPPED).getItem((short) -11);

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
      int randomOption = 0;
      
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
    

      setFlame(flame);
      
      calcFlameStats();
      
      nEquip2.setFlame(flame);
    
      calcFlameStats();

  }

  public int getMoru ()
  {
    return this.moru;
  }

  public void setMoru (int moru)
  {
    this.moru = moru;
  }
  

  public int getEquipmentType ()
  {
    return this.equipmentType;
  }

  public void setEquipmentType (int equipmentType)
  {
    this.equipmentType = equipmentType;
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

  public short getStarForceAcc ()
  {
    return starForceAcc;
  }

  public void setStarForceAcc (short starForceAcc)
  {
    this.starForceAcc = starForceAcc;
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

  public void resetStarForceStats()
  {
    this.starForceAvoid = 0;
    
    this.starForceAcc = 0;
    
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
      setStarForceAcc(starForceStats.getFlag(EnchantFlag.Acc).right.shortValue());
    }

    if (starForceStats.getFlag(EnchantFlag.Avoid) != null)
    {
      setStarForceAvoid(starForceStats.getFlag(EnchantFlag.Avoid).right.shortValue());
    }
  }
  
  public short getEnchantJump()
  {
    return enchantJump;
  }
  
  public void setEnchantJump(short enchantJump)
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

  public short getEnchantAcc ()
  {
    return this.enchantAcc;
  }

  public void setEnchantAcc (short enchantAcc)
  {
    this.enchantAcc = enchantAcc;
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
    return (short) (this.str + this.enchantStr + this.getStarForceStr() + getFlameStr());
  }

  public short getTotalDex ()
  {
    return (short) (this.dex + this.enchantDex + this.getStarForceDex() + getFlameDex());
  }

  public short getTotalInt ()
  {
    return (short) (this._int + this.enchantInt + this.getStarForceInt() + getFlameInt());
  }

  public short getTotalLuk ()
  {
    return (short) (this.luk + this.enchantLuk + this.getStarForceLuk()+ getFlameLuk());
  }

  public short getTotalHp ()
  {
    return (short) (this.hp + this.enchantHp + this.getStarForceHp()+ getFlameHp());
  }

  public short getTotalMp ()
  {
    return (short) (this.mp + this.enchantMp + this.getStarForceMp()+ getFlameMp());
  }

  public short getTotalAcc ()
  {
    return (short) (this.acc + this.enchantAcc + this.getStarForceAcc());
  }

  public short getTotalAvoid ()
  {
    return (short) (this.avoid + this.enchantAvoid + this.getStarForceAvoid());
  }

  public short getTotalWatk ()
  {
    return (short) (this.watk + this.enchantWatk + this.getStarForceWatk()+ getFlameWatk());
  }

  public short getTotalMatk ()
  {
    return (short) (this.matk + this.enchantMatk + this.getStarForceMatk()+ getFlameMatk());
  }

  public short getTotalWdef ()
  {
    return (short) (this.wdef + this.enchantWdef + this.getStarForceWdef() + getFlameDef());
  }

  public short getTotalMdef ()
  {
    return (short) (this.mdef + this.enchantMdef + this.getStarForceMdef() + getFlameDef());
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

  public int getAttackSpeed ()
  {
    return this.attackSpeed;
  }

  public void setAttackSpeed (int attackSpeed)
  {
    this.attackSpeed = attackSpeed;
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
  
  public EquipmentScroll getShowScrollOption()
  {
    return showScrollOption;
  }
  
  public void setShowScrollOption(EquipmentScroll showScrollOption)
  {
    this.showScrollOption = showScrollOption;
  }
  
  
  public enum ScrollResult
  {
    SUCCESS, FAIL, CURSE

  }
}

