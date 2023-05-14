package server.field.skill;

import client.MapleClient;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import tools.packet.CField;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

public class MapleOrb extends MapleMapObject
{
  private final int cid;
  
  private final int type;
  
  private final int skillId;
  
  private final int attackCount;
  
  private final int subTime;
  
  private final int duration;
  
  private final int delay;
  
  private final int unk1;
  
  private final int unk2;
  
  private final int facing;
  
  private final int unk3;
  
  private final Point pos;
  
  public MapleOrb(int cid, int type, int skillId, int attackCount, int subTime, int duration, int delay, int unk1, int unk2, Point pos, int facing, int unk3)
  {
    this.cid = cid;
    this.type = type;
    this.skillId = skillId;
    this.attackCount = attackCount;
    this.subTime = subTime;
    this.duration = duration;
    this.delay = delay;
    this.unk1 = unk1;
    this.unk2 = unk2;
    this.pos = pos;
    this.facing = facing;
    this.unk3 = unk3;
  }
  
  public MapleMapObjectType getType()
  {
    return MapleMapObjectType.ORB;
  }
  
  public void sendSpawnData(MapleClient client)
  {
    client.getSession().writeAndFlush(CField.spawnOrb(this.cid, Collections.singletonList(this)));
  }
  
  public void sendDestroyData(MapleClient client)
  {
    client.getSession().writeAndFlush(CField.removeOrb(this.cid, Collections.singletonList(this)));
  }
  
  public int getPlayerId()
  {
    return this.cid;
  }
  
  public int getOrbType()
  {
    return this.type;
  }
  
  public int getSkillId()
  {
    return this.skillId;
  }
  
  public int getAttackCount()
  {
    return this.attackCount;
  }
  
  public int getSubTime()
  {
    return this.subTime;
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  public int getDelay()
  {
    return this.delay;
  }
  
  public int getUnk1()
  {
    return this.unk1;
  }
  
  public int getUnk2()
  {
    return this.unk2;
  }
  
  public Point getPos()
  {
    return this.pos;
  }
  
  public int getFacing()
  {
    return this.facing;
  }
  
  public int getUnk3()
  {
    return this.unk3;
  }
}
