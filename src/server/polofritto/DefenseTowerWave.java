/*
 * Decompiled with CFR 0.150.
 */
package server.polofritto;

import client.MapleClient;
import server.Timer;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MonsterListener;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import tools.packet.CField;
import tools.packet.CWvsContext;
import tools.packet.SLFCGPacket;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

public class DefenseTowerWave
{
  private int wave;
  private int life;
  private ScheduledFuture<?> sc;
  private List<List<Integer>> waveData = new ArrayList<List<Integer>>();
  private int status = 0;

  public DefenseTowerWave (int wave, int life)
  {
    this.wave = wave;
    this.life = life;
  }

  public int getWave ()
  {
    return this.wave;
  }

  public void setWave (int wave)
  {
    this.wave = wave;
  }

  public int getLife ()
  {
    return this.life;
  }

  public void setLife (int life)
  {
    this.life = life;
  }

  public void updateDefenseWave (MapleClient c)
  {
    c.getSession().writeAndFlush(SLFCGPacket.setTowerDefenseWave(this.wave));
  }

  public void updateDefenseLife (MapleClient c)
  {
    c.getSession().writeAndFlush(SLFCGPacket.setTowerDefenseLife(this.life));
  }

  public void updateNewWave (final MapleClient c)
  {
    c.getSession().writeAndFlush(CField.environmentChange("defense/count", 16));
    Timer.EventTimer.getInstance().schedule(new Runnable()
    {

      @Override public void run ()
      {
        c.getSession().writeAndFlush(CField.environmentChange("defense/wave/" + DefenseTowerWave.this.wave, 16));

        c.getSession().writeAndFlush(CField.environmentChange("killing/first/start", 16));

        if (c.getPlayer().getMapId() == 993000100)
        {
          List<Integer> list = DefenseTowerWave.this.waveData.get(DefenseTowerWave.this.wave - 1);

          for (int i = 0; i < list.size(); i += 1)
          {
            final int monsterId = list.get(i);
            int index = i;
            Timer.EventTimer.getInstance().schedule(new Runnable()
            {
              @Override public void run ()
              {
                if (c.getPlayer().getMapId() == 993000100)
                {
                  MapleMonster monster = MapleLifeFactory.getMonster(monsterId);

                  MapleMonster monster2 = MapleLifeFactory.getMonster(monsterId);

                  long baseExp = Long.parseLong(c.getPlayer().getV("poloFrittoBaseExp"));

                  monster.setExp(baseExp * 850);

                  monster2.setExp(baseExp * 850);

                  monster.addListener(new MonsterListener()
                  {
                    @Override public void monsterKilled ()
                    {
                      DefenseTowerWave.this.checkFinish(c);

                      monster.removeListener();
                    }
                  });

                  monster2.addListener(new MonsterListener()
                  {
                    @Override public void monsterKilled ()
                    {
                      DefenseTowerWave.this.checkFinish(c);

                      monster2.removeListener();
                    }
                  });

                  monster.setStance(5); // 朝向左邊
                  c.getPlayer().getMap().spawnMonsterOnGroundBelow(monster, new Point(453, 167));

                  monster2.setStance(4); // 朝向右邊
                  c.getPlayer().getMap().spawnMonsterOnGroundBelow(monster2, new Point(-703, -195));

                  if (index == list.size() - 1)
                  {
                    status = 1;
                  }
                }
              }
            }, 1000L * (i + 1));
          }
        }
      }
    }, 3000L);
  }

  public void checkFinish (final MapleClient c)
  {
    if (status != 1)
    {
      return;
    }


    if (this.life == 0)
    {
      status = 0;

      if (this.sc != null)
      {
        this.sc.cancel(false);
      }

      c.getSession().writeAndFlush(CField.environmentChange("killing/fail", 16));

      Timer.EventTimer.getInstance().schedule(new Runnable()
      {
        @Override public void run ()
        {
          if (c != null && c.getPlayer() != null && c.getPlayer().getMapId() == 993000100)
          {
            c.getPlayer().warp(993000600);
          }
        }
      }, 3000L);
    }
    else if (c != null && c.getPlayer() != null && c.getPlayer().getMap() != null && c.getPlayer().getMap().getNumMonsters() == 0)
    {
      if (DefenseTowerWave.this.wave < DefenseTowerWave.this.waveData.size() && c.getPlayer().getMapId() == 993000100)
      {
        DefenseTowerWave.this.wave++;

        c.getSession().writeAndFlush(CWvsContext.getTopMsg("WAVE를 막아냈습니다. 다음 WAVE를 준비해주세요."));

        status = 0;

        Timer.EventTimer.getInstance().schedule(new Runnable()
        {
          @Override public void run ()
          {
            DefenseTowerWave.this.updateDefenseWave(c);
            DefenseTowerWave.this.updateNewWave(c);
          }
        }, 3000L);
      }
      else
      {
        if (DefenseTowerWave.this.sc != null)
        {
          DefenseTowerWave.this.sc.cancel(true);
        }

        c.getSession().writeAndFlush(CField.environmentChange("killing/clear", 16));
        Timer.EventTimer.getInstance().schedule(new Runnable()
        {

          @Override public void run ()
          {
            if (c != null && c.getPlayer() != null && c.getPlayer().getMapId() == 993000100)
            {
              c.getPlayer().warp(993000600);
            }
          }
        }, 3000L);
      }
    }
  }


  public void insertWaveData ()
  {
    ArrayList<Integer> waves = new ArrayList<Integer>();
    waves.add(9831000);
    waves.add(9831000);
    waves.add(9831001);
    waves.add(9831001);
    waves.add(9831000);
    waves.add(9831001);
    waves.add(9831002);
    waves.add(9831002);
    waves.add(9831000);
    waves.add(9831001);
    waves.add(9831000);
    waves.add(9831001);
    this.waveData.add(waves);
    ArrayList<Integer> waves2 = new ArrayList<Integer>();
    waves2.add(9831003);
    waves2.add(9831003);
    waves2.add(9831004);
    waves2.add(9831004);
    waves2.add(9831003);
    waves2.add(9831004);
    waves2.add(9831005);
    waves2.add(9831005);
    waves2.add(9831003);
    waves2.add(9831004);
    waves2.add(9831003);
    waves2.add(9831004);
    this.waveData.add(waves2);
    ArrayList<Integer> waves3 = new ArrayList<Integer>();
    waves3.add(9831006);
    waves3.add(9831006);
    waves3.add(9831007);
    waves3.add(9831007);
    waves3.add(9831006);
    waves3.add(9831007);
    waves3.add(9831009);
    waves3.add(9831010);
    waves3.add(9831006);
    waves3.add(9831007);
    waves3.add(9831006);
    waves3.add(9831007);
    this.waveData.add(waves3);
    ArrayList<Integer> waves4 = new ArrayList<Integer>();
    waves3.add(9831012);
    waves3.add(9831013);
    waves3.add(9831012);
    waves3.add(9831013);
    waves3.add(9831012);
    waves3.add(9831013);
    waves3.add(9831014);
    waves3.add(9831014);
    waves3.add(9831012);
    waves3.add(9831012);
    waves3.add(9831013);
    waves3.add(9831013);
    this.waveData.add(waves4);
  }

  public void attacked (MapleClient c, int monsterObjectId)
  {

    MapleMapObject monster = c.getPlayer().getMap().getMapObject(monsterObjectId, MapleMapObjectType.MONSTER);

    if (monster != null)
    {
      c.getPlayer().getMap().removeMonster((MapleMonster) monster);
    }

    if (this.life == 0)
    {
      return;
    }

    this.life -= 1;

    this.updateDefenseLife(c);
  }

  public void start (final MapleClient c)
  {
    this.insertWaveData();
    this.updateDefenseWave(c);
    this.updateDefenseLife(c);
    c.getSession().writeAndFlush(CField.startMapEffect("놈들이 겁도 없이 마을을 습격하는군! 모조리 해치워라!", 5120159, true));
    c.getSession().writeAndFlush(CField.getClock(300));
    this.updateNewWave(c);
    this.sc = Timer.EventTimer.getInstance().schedule(new Runnable()
    {
      @Override public void run ()
      {
        status = 0;

        if (c.getPlayer().getMapId() == 993000100)
        {
          c.getPlayer().warp(993000600);
        }

        if (DefenseTowerWave.this.sc != null)
        {
          DefenseTowerWave.this.sc.cancel(true);
        }
      }
    }, 300 * 1000L);
  }

  public List<List<Integer>> getWaveData ()
  {
    return this.waveData;
  }

  public void setWaveData (List<List<Integer>> waveData)
  {
    this.waveData = waveData;
  }

  public ScheduledFuture<?> getSc ()
  {
    return this.sc;
  }

  public void setSc (ScheduledFuture<?> sc)
  {
    this.sc = sc;
  }
}

