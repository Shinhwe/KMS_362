package server.polofritto;

import client.MapleClient;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;

import java.awt.*;

public class MapleRandomPortal extends MapleMapObject
{
  public static final int MAP_PORTAL = 2;
  
  public static final int DOOR_PORTAL = 6;
  
  private boolean polo;
  
  private int type;
  
  private int mapId;
  
  private int charId;
  
  private Point pos;

  private long baseExp;
  
  public MapleRandomPortal(int type, Point pos, int mapId, int charId, boolean isPolo, long baseExp)
  {
    this.type = type;
    this.pos = pos;
    this.mapId = mapId;
    this.charId = charId;
    this.polo = isPolo;
    this.baseExp = baseExp;
  }
  
  public MapleMapObjectType getType()
  {
    return MapleMapObjectType.RANDOM_PORTAL;
  }
  
  public void sendSpawnData(MapleClient client)
  {
  }
  
  public void sendDestroyData(MapleClient client)
  {
  }
  
  public int getPortalType()
  {
    return this.type;
  }
  
  public void setPortalType(int type)
  {
    this.type = type;
  }
  
  public Point getPos()
  {
    return this.pos;
  }
  
  public void setPos(Point pos)
  {
    this.pos = pos;
  }
  
  public int getMapId()
  {
    return this.mapId;
  }
  
  public void setMapId(int mapId)
  {
    this.mapId = mapId;
  }
  
  public int getCharId()
  {
    return this.charId;
  }
  
  public void setCharId(int charId)
  {
    this.charId = charId;
  }
  
  public boolean ispolo()
  {
    return this.polo;
  }
  
  public void setpolo(boolean polo)
  {
    this.polo = polo;
  }

  public long getBaseExp ()
  {
    return baseExp;
  }

  public void setBaseExp (long baseExp)
  {
    this.baseExp = baseExp;
  }
}
