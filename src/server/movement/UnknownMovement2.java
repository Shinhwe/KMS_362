package server.movement;

import tools.data.MaplePacketLittleEndianWriter;

import java.awt.*;

public class UnknownMovement2 extends AbstractLifeMovement
{

  private Point pixelsPerSecond;
  private short xOffset;

  public UnknownMovement2 (int type, Point position, int duration, int newstate, byte unk)
  {
    super(type, position, duration, newstate, (short) 0, unk);
  }

  public void setPixelsPerSecond (Point wobble)
  {
    this.pixelsPerSecond = wobble;
  }

  public void setXOffset (short xOffset)
  {
    this.xOffset = xOffset;
  }

  @Override public void serialize (MaplePacketLittleEndianWriter packet)
  {
    // System.out.println("UnknownMovement2");
    packet.write(getType());
    packet.writePos(getPosition());
    packet.writePos(pixelsPerSecond);
    packet.writeShort(xOffset);
    packet.write(getNewstate());
    packet.writeShort(getDuration());
    packet.write(getUnk());
  }
}