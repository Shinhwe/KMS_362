package server;

public class QuickMoveEntry
{
  private final int id;
  
  private final int icon;
  
  private final int level;
  
  private final int type;
  
  private final String desc;
  
  public QuickMoveEntry(int type, int id, int icon, int level, String desc)
  {
    this.type = type;
    this.id = id;
    this.icon = icon;
    this.level = level;
    this.desc = desc;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getIcon()
  {
    return this.icon;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
}
