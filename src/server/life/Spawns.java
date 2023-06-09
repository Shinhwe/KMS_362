package server.life;

import server.maps.MapleMap;

import java.awt.*;

public abstract class Spawns
{
  public abstract MapleMonsterStats getMonster();
  
  public abstract byte getCarnivalTeam();
  
  public abstract boolean shouldSpawn(long paramLong);
  
  public abstract int getCarnivalId();
  
  public abstract MapleMonster spawnMonster(MapleMap paramMapleMap);
  
  public abstract int getMobTime();
  
  public abstract Point getPosition();
  
  public abstract int getF();
  
  public abstract int getFh();
}
