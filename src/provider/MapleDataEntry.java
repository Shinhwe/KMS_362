package provider;

public class MapleDataEntry implements MapleDataEntity
{
  private final String name;
  
  private final int size;
  
  private final int checksum;
  private final MapleDataEntity parent;
  private int offset;
  
  public MapleDataEntry(String name, int size, int checksum, MapleDataEntity parent)
  {
    this.name = name;
    this.size = size;
    this.checksum = checksum;
    this.parent = parent;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public int getChecksum()
  {
    return this.checksum;
  }
  
  public int getOffset()
  {
    return this.offset;
  }
  
  public MapleDataEntity getParent()
  {
    return this.parent;
  }
}
