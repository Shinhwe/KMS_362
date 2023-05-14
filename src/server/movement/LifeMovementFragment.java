package server.movement;

import tools.data.MaplePacketLittleEndianWriter;

import java.awt.*;

public interface LifeMovementFragment
{
  void serialize(MaplePacketLittleEndianWriter paramMaplePacketLittleEndianWriter);
  
  Point getPosition();
}
