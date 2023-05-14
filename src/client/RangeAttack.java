package client;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RangeAttack
{
  private final List<Integer> list = new ArrayList<Integer>();
  private final Point position;
  private final short type;
  private final int skillId;
  private final int delay;
  private final int attackCount;
  
  public RangeAttack(int skillId, Point position, int type, int delay, int attackCount)
  {
    this.skillId = skillId;
    this.position = position;
    this.type = (short) type;
    this.delay = delay;
    this.attackCount = attackCount;
  }
  
  public Point getPosition()
  {
    return this.position;
  }
  
  public short getType()
  {
    return this.type;
  }
  
  public int getSkillId()
  {
    return this.skillId;
  }
  
  public int getDelay()
  {
    return this.delay;
  }
  
  public int getAttackCount()
  {
    return this.attackCount;
  }
  
  public List<Integer> getList()
  {
    return this.list;
  }
}

