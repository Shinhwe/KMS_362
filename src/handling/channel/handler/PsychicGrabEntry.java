package handling.channel.handler;

import java.awt.*;

public class PsychicGrabEntry
{
  private final long mobhp;
  
  private final long mobmaxhp;
  
  private final int a;
  
  private final int b;
  
  private final int mobid;
  
  private final int unk2;
  
  private final short secondsize;
  
  private final byte firstsize;
  
  private final byte unk;
  
  private final Rectangle rect;
  
  public PsychicGrabEntry(byte firstsize, int a, int b, int mobid, short secondsize, long mobhp, long mobmaxhp, byte unk, Rectangle rect, int unk2)
  {
    this.firstsize = firstsize;
    this.a = a;
    this.b = b;
    this.mobid = mobid;
    this.secondsize = secondsize;
    this.mobhp = mobhp;
    this.mobmaxhp = mobmaxhp;
    this.unk = unk;
    this.rect = rect;
    this.unk2 = unk2;
  }
  
  public byte getFirstSize()
  {
    return this.firstsize;
  }
  
  public byte getUnk()
  {
    return this.unk;
  }
  
  public int getUnk2()
  {
    return this.unk2;
  }
  
  public short getSecondSize()
  {
    return this.secondsize;
  }
  
  public int getA()
  {
    return this.a;
  }
  
  public int getB()
  {
    return this.b;
  }
  
  public int getMobId()
  {
    return this.mobid;
  }
  
  public Rectangle getRect()
  {
    return this.rect;
  }
  
  public long getMobHp()
  {
    return this.mobhp;
  }
  
  public long getMobMaxHp()
  {
    return this.mobmaxhp;
  }
}
