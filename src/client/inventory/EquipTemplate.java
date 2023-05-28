package client.inventory;

public class EquipTemplate
{
  public EquipTemplate(int itemId)
  {
    this.itemId = itemId;
  }
  private int itemId = 0;
  
  private short str = 0;
  
  private short dex = 0;
  
  private short _int = 0;
  
  private short luk = 0;
  
  private short watk = 0;
  
  private short matk = 0;

  private int attackSpeed = 0;
  
  private short moveMentSpeed = 0;
  
  private short jump = 0;
  
  private short bossDamage = 0;
  
  private short damage = 0;
  
  private short hp = 0;
  
  private short mp = 0;
  
  private short wdef = 0;
  
  private short mdef = 0;
  
  private short accuracy = 0;
  
  private short avoid = 0;
  
  private byte upgradeSlots = 0;
  
  private short craft = 0;
  
  private int durability = -1;
  
  private short charmEXP = 0;
  
  private short reqLevel = 0;
  
  private short allStat = 0;
  
  private short PVPDamage = 0;
  
  private short ignorePDR = 0;
  
  public short getStr()
  {
    return str;
  }
  
  public void setStr(short str)
  {
    this.str = str;
  }
  
  public short getDex()
  {
    return dex;
  }
  
  public void setDex(short dex)
  {
    this.dex = dex;
  }
  
  public short getInt()
  {
    return _int;
  }
  
  public void setInt(short _int)
  {
    this._int = _int;
  }
  
  public short getLuk()
  {
    return luk;
  }
  
  public void setLuk(short luk)
  {
    this.luk = luk;
  }
  
  public int getAttackSpeed()
  {
    return attackSpeed;
  }
  
  public void setAttackSpeed(int attackSpeed)
  {
    this.attackSpeed = attackSpeed;
  }
  
  public short getMoveMentSpeed()
  {
    return moveMentSpeed;
  }
  
  public void setMoveMentSpeed(short moveMentSpeed)
  {
    this.moveMentSpeed = moveMentSpeed;
  }
  
  public short getJump()
  {
    return jump;
  }
  
  public void setJump(short jump)
  {
    this.jump = jump;
  }
  
  public short getBossDamage()
  {
    return bossDamage;
  }
  
  public void setBossDamage(short bossDamage)
  {
    this.bossDamage = bossDamage;
  }
  
  public short getDamage()
  {
    return damage;
  }
  
  public void setDamage(short damage)
  {
    this.damage = damage;
  }
  
  public short getWatk()
  {
    return watk;
  }
  
  public void setWatk(short watk)
  {
    this.watk = watk;
  }
  
  public short getMatk()
  {
    return matk;
  }
  
  public void setMatk(short matk)
  {
    this.matk = matk;
  }
  
  public short getHp()
  {
    return hp;
  }
  
  public void setHp(short hp)
  {
    this.hp = hp;
  }
  
  public short getMp()
  {
    return mp;
  }
  
  public void setMp(short mp)
  {
    this.mp = mp;
  }
  
  public short getWdef()
  {
    return wdef;
  }
  
  public void setWdef(short wdef)
  {
    this.wdef = wdef;
  }
  
  public short getMdef()
  {
    return mdef;
  }
  
  public void setMdef(short mdef)
  {
    this.mdef = mdef;
  }
  
  public short getAccuracy()
  {
    return accuracy;
  }
  
  public void setAccuracy(short accuracy)
  {
    this.accuracy = accuracy;
  }
  
  public short getAvoid()
  {
    return avoid;
  }
  
  public void setAvoid(short avoid)
  {
    this.avoid = avoid;
  }
  
  public byte getUpgradeSlots()
  {
    return upgradeSlots;
  }
  
  public void setUpgradeSlots(byte upgradeSlots)
  {
    this.upgradeSlots = upgradeSlots;
  }
  
  public short getCraft()
  {
    return craft;
  }
  
  public void setCraft(short craft)
  {
    this.craft = craft;
  }
  
  public int getItemId()
  {
    return itemId;
  }
  
  public int getDurability()
  {
    return durability;
  }
  
  public void setDurability(int durability)
  {
    this.durability = durability;
  }
  
  public short getCharmEXP()
  {
    return charmEXP;
  }
  
  public void setCharmEXP(short charmEXP)
  {
    this.charmEXP = charmEXP;
  }
  
  public short getPVPDamage()
  {
    return PVPDamage;
  }
  
  public void setPVPDamage(short PVPDamage)
  {
    this.PVPDamage = PVPDamage;
  }
  
  public short getIgnorePDR()
  {
    return ignorePDR;
  }
  
  public void setIgnorePDR(short ignorePDR)
  {
    this.ignorePDR = ignorePDR;
  }
  
  public short getAllStat()
  {
    return allStat;
  }
  
  public void setAllStat(short allStat)
  {
    this.allStat = allStat;
  }
  
  public short getReqLevel()
  {
    return reqLevel;
  }
  
  public void setReqLevel(short reqLevel)
  {
    this.reqLevel = reqLevel;
  }
}
