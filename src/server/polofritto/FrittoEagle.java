package server.polofritto;

import client.MapleClient;
import server.Randomizer;
import server.Timer;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import tools.packet.CField;
import tools.packet.SLFCGPacket;

import java.awt.*;
import java.util.concurrent.ScheduledFuture;

public class FrittoEagle
{
  private ScheduledFuture<?> sc;


  private int score;

  private int bullet;

  public FrittoEagle (int score, int bullet)
  {
    this.score = score;
    this.bullet = bullet;
  }

  public void createGun (MapleClient c)
  {
    c.getSession().writeAndFlush(SLFCGPacket.createGun());
    c.getSession().writeAndFlush(SLFCGPacket.setGun());
    c.getSession().writeAndFlush(SLFCGPacket.setAmmo(this.bullet));
  }

  public void checkFinish (MapleClient c)
  {
    if (FrittoEagle.this.sc != null)
    {
      FrittoEagle.this.sc.cancel(false);
    }

    boolean isFinish = false;

    if (FrittoEagle.this.score == 1000)
    {
      isFinish = true;

    }
    else if (c.getPlayer().getMap().getAllMonster().stream().anyMatch(item -> item != null && item.isAlive() && item.getId() != 9833003) == false)
    {
      isFinish = true;
    }
    else if (this.bullet == 0)
    {
      isFinish = true;
    }

    if (isFinish)
    {
      c.getSession().writeAndFlush(SLFCGPacket.SetIngameDirectionMode(false, true, false, false));
      c.getSession().writeAndFlush(SLFCGPacket.InGameDirectionEvent("", 10, 0));
      c.getPlayer().getMap().killAllMonsters(false);
      c.getPlayer().warp(993000601);
    }
  }

  public void addScore (MapleMonster monster, MapleClient c)
  {
    int be = this.score;
    switch (monster.getId())
    {
      case 9833000:
        this.score += 50;
        break;
      case 9833001:
        this.score += 100;
        break;
      case 9833002:
        this.score += 200;
        break;
      case 9833003:
        this.score -= 50;
        break;
    }
    c.getPlayer().setKeyValue(15141, "point", String.valueOf(this.score));
    c.getSession().writeAndFlush(SLFCGPacket.deadOnFPSMode(monster.getObjectId(), this.score - be));
    this.checkFinish(c);
  }

  public void updateNewWave (final MapleClient c)
  {
    c.getSession().writeAndFlush(CField.environmentChange("killing/first/start", 16));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833000), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833000), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833000), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833000), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833000), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833000), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833001), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833001), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833001), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833002), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833002), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833003), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833003), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833003), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
    c.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9833003), new Point(Randomizer.nextInt(500), Randomizer.nextInt(500)));
  }

  public void shootResult (MapleClient c)
  {
    this.bullet -= 1;

    if (this.bullet > 0)
    {
      c.getSession().writeAndFlush(SLFCGPacket.attackRes());
    }

    this.checkFinish(c);
  }

  public void start (final MapleClient c)
  {
    createGun(c);
    c.getPlayer().setKeyValue(15141, "point", "0");
    c.getSession().writeAndFlush(SLFCGPacket.SetIngameDirectionMode(true, false, false, false));
    c.getSession().writeAndFlush(SLFCGPacket.InGameDirectionEvent("", 10, 1));
    c.getSession().writeAndFlush(CField.environmentChange("PoloFritto/msg1", 20));
    c.getSession().writeAndFlush(CField.startMapEffect("독수리를 침착하게 한 마리씩 잡도록 해! 아참, 대머리 독수리는 아무 쓸모 없으니 잡지마!", 5120160, true));
    c.getSession().writeAndFlush(SLFCGPacket.milliTimer(30000));
    updateNewWave(c);
    this.sc = Timer.EventTimer.getInstance().schedule(new Runnable()
    {
      public void run ()
      {
        if (c.getPlayer().getMapId() == 993000200)
        {
          c.getSession().writeAndFlush(SLFCGPacket.SetIngameDirectionMode(false, true, false, false));
          c.getSession().writeAndFlush(SLFCGPacket.InGameDirectionEvent("", 10, 0));
          c.getPlayer().warp(993000601);
        }
      }
    }, 30000L);
  }

  public ScheduledFuture<?> getSc ()
  {
    return this.sc;
  }

  public void setSc (ScheduledFuture<?> sc)
  {
    this.sc = sc;
  }

  public int getScore ()
  {
    return this.score;
  }

  public void setScore (int score)
  {
    this.score = score;
  }

  public int getBullet ()
  {
    return this.bullet;
  }

  public void setBullet (int bullet)
  {
    this.bullet = bullet;
  }
}
