package server.movement;

import java.awt.*;

public interface LifeMovement extends LifeMovementFragment
{
  Point getPosition();
  
  int getNewstate();
  
  int getDuration();
  
  int getType();
  
  short getFootHolds();
}
