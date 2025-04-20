package server.life;

import server.MapleItemInformationProvider;

public class MonsterDropEntry
{
  public int itemId;
  
  public int chance;
  
  public int Minimum;
  
  public int Maximum;
  
  public int questid;
  
  public int privated;

  public int minLevel = 0;

  public int maxLevel = 0;
  
  public MonsterDropEntry(int itemId, int chance, int Minimum, int Maximum, int questid)
  {
    this.itemId = itemId;
    this.chance = chance;
    this.questid = questid;
    this.Minimum = Minimum;
    this.Maximum = Maximum;
    this.privated = 0;
    this.minLevel = 0;
    this.maxLevel = 999;
  }
  
  public MonsterDropEntry(int itemId, int chance, int Minimum, int Maximum, int questid, int privated)
  {
    this.itemId = itemId;
    this.chance = chance;
    this.questid = questid;
    this.Minimum = Minimum;
    this.Maximum = Maximum;
    this.privated = privated;
    this.minLevel = 0;
    this.maxLevel = 999;
  }

  public MonsterDropEntry(int itemId, int chance, int Minimum, int Maximum, int questid, int privated, int minLevel, int maxLevel)
  {
    this.itemId = itemId;
    this.chance = chance;
    this.questid = questid;
    this.Minimum = Minimum;
    this.Maximum = Maximum;
    this.privated = privated;
    this.minLevel = minLevel;
    this.maxLevel = maxLevel;
  }
  
  public String getItemName ()
  {
    if (this.itemId == 0)
    {
      return "楓幣";
    }
    return MapleItemInformationProvider.getInstance().getName(this.itemId);
  }
}
