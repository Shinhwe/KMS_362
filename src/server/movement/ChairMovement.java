package server.movement;

import tools.data.MaplePacketLittleEndianWriter;

import java.awt.*;

public class ChairMovement extends AbstractLifeMovement
{
  private int unk;
  
  public ChairMovement(int type, Point position, int duration, int newstate, short unk, byte unk2)
  {
    super(type, position, duration, newstate, unk, unk2);
  }
  
  public void serialize(MaplePacketLittleEndianWriter packet)
  {
    packet.write(getType());
    packet.writePos(getPosition());
    packet.writeShort(getFootHolds());
    packet.writeInt(this.unk);
    packet.write(getNewstate());
    packet.writeShort(getDuration());
    packet.write(getUnk());
  }
  
  public void setUnk(int unk)
  {
    this.unk = unk;
  }
}
