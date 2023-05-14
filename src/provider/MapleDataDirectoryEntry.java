package provider;

import java.util.*;

public class MapleDataDirectoryEntry extends MapleDataEntry
{
  private final List<MapleDataDirectoryEntry> subdirs = new ArrayList<>();
  
  private final List<MapleDataFileEntry> files = new ArrayList<>();
  
  private final Map<String, MapleDataEntry> entries = new HashMap<>();
  
  public MapleDataDirectoryEntry(String name, int size, int checksum, MapleDataEntity parent)
  {
    super(name, size, checksum, parent);
  }
  
  public MapleDataDirectoryEntry()
  {
    super(null, 0, 0, null);
  }
  
  public void addDirectory(MapleDataDirectoryEntry dir)
  {
    this.subdirs.add(dir);
    this.entries.put(dir.getName(), dir);
  }
  
  public void addFile(MapleDataFileEntry fileEntry)
  {
    this.files.add(fileEntry);
    this.entries.put(fileEntry.getName(), fileEntry);
  }
  
  public List<MapleDataDirectoryEntry> getSubdirectories()
  {
    return Collections.unmodifiableList(this.subdirs);
  }
  
  public List<MapleDataFileEntry> getFiles()
  {
    return Collections.unmodifiableList(this.files);
  }
  
  public MapleDataEntry getEntry(String name)
  {
    return this.entries.get(name);
  }
}
