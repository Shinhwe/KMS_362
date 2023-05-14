package server.events;

import java.awt.*;

public class MapleBattleGroundMobInfo
{
  private final int oid;
  
  private final int cid;
  
  private final int skillid;
  
  private final int unk1;
  
  private final int unk2;
  
  private final int unk3;
  
  private final int unk4;
  
  private final int damage;
  
  private final Point pos1;
  
  private final Point pos2;
  
  private boolean cri = false;
  
  public MapleBattleGroundMobInfo(int oid, int cid, int skillid, int damage, int unk1, int unk2, int unk3, int unk4, Point pos1, Point pos2)
  {
    this.oid = oid;
    this.cid = cid;
    this.skillid = skillid;
    this.damage = damage;
    this.unk1 = unk1;
    this.unk2 = unk2;
    this.unk3 = unk3;
    this.unk4 = unk4;
    this.pos1 = pos1;
    this.pos2 = pos2;
  }
  
  public int getOid()
  {
    return this.oid;
  }
  
  public int getCid()
  {
    return this.cid;
  }
  
  public int getSkillid()
  {
    return this.skillid;
  }
  
  public int getDamage()
  {
    return this.damage;
  }
  
  public int getUnk1()
  {
    return this.unk1;
  }
  
  public int getUnk2()
  {
    return this.unk2;
  }
  
  public int getUnk3()
  {
    return this.unk3;
  }
  
  public int getUnk4()
  {
    return this.unk4;
  }
  
  public Point getPos1()
  {
    return this.pos1;
  }
  
  public Point getPos2()
  {
    return this.pos1;
  }
  
  public boolean getCritiCal()
  {
    return this.cri;
  }
  
  public void setCritiCal(boolean cri)
  {
    this.cri = cri;
  }
}
