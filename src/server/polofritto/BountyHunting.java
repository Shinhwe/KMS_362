package server.polofritto;

import client.MapleClient;
import server.Randomizer;
import server.Timer;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MonsterListener;
import tools.packet.CField;
import tools.packet.SLFCGPacket;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

public class BountyHunting
{
  private int stage;

  private int status = 0;

  private ScheduledFuture<?> sc;

  private List<List<Integer>> waveData = new ArrayList<>();

  public BountyHunting (int stage)
  {
    this.stage = stage;
  }

  public int getStage ()
  {
    return this.stage;
  }

  public void setStage (int wave)
  {
    this.stage = wave;
  }

  public void updateDefenseWave (MapleClient c)
  {
    c.getSession().writeAndFlush(SLFCGPacket.setBountyHuntingStage(this.stage));
  }

  public void updateNewWave (final MapleClient c)
  {
    c.getSession().writeAndFlush(CField.environmentChange("defense/count", 16));
    Timer.EventTimer.getInstance().schedule(new Runnable()
    {
      public void run ()
      {
        if (c.getPlayer().getMapId() == 993000000)
        {
          c.getSession().writeAndFlush(CField.environmentChange("defense/wave/" + BountyHunting.this.stage, 16));

          c.getSession().writeAndFlush(CField.environmentChange("killing/first/start", 16));

          for (Iterator<Integer> iterator = ((List) BountyHunting.this.waveData.get(BountyHunting.this.stage - 1)).iterator(); iterator.hasNext(); )
          {
            int wave = iterator.next().intValue();

            MapleMonster monster1 = MapleLifeFactory.getMonster(wave);

            MapleMonster monster2 = MapleLifeFactory.getMonster(wave);

            long baseExp = Long.parseLong(c.getPlayer().getV("poloFrittoBaseExp"));

            monster1.setExp(baseExp * 800);

            monster2.setExp(baseExp * 800);
            monster1.addListener(new MonsterListener()
            {
              @Override public void monsterKilled ()
              {
                BountyHunting.this.checkFinish(c);

                monster1.removeListener();
              }
            });

            monster2.addListener(new MonsterListener()
            {
              @Override public void monsterKilled ()
              {
                BountyHunting.this.checkFinish(c);

                monster2.removeListener();
              }
            });

            c.getPlayer().getMap().spawnMonsterOnGroundBelow(monster1, new Point(Randomizer.rand(500, 700) * -1, 126));

            c.getPlayer().getMap().spawnMonsterOnGroundBelow(monster2, new Point(Randomizer.rand(500, 700), 126));
          }

          status = 1;
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
    if (c != null && c.getPlayer() != null && c.getPlayer().getMap() != null && c.getPlayer().getMap().getNumMonsters() == 0)
    {
      int mapId = c.getPlayer().getMap().getId();

      if (this.stage < 5 && mapId == 993000000)
      {
        this.stage++;
        this.updateDefenseWave(c);
        this.updateNewWave(c);
      }
      else
      {
        if (BountyHunting.this.sc != null)
        {
          BountyHunting.this.sc.cancel(true);
        }

        c.getSession().writeAndFlush(CField.environmentChange("killing/clear", 16));

        status = 0;
        Timer.EventTimer.getInstance().schedule(new Runnable()
        {
          public void run ()
          {
            if (c != null && c.getPlayer() != null && c.getPlayer().getMapId() == 993000000)
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
    List<Integer> waves = new ArrayList<>();
    waves.add(Integer.valueOf(9830000));
    waves.add(Integer.valueOf(9830000));
    waves.add(Integer.valueOf(9830000));
    waves.add(Integer.valueOf(9830000));
    waves.add(Integer.valueOf(9830000));
    waves.add(Integer.valueOf(9830001));
    waves.add(Integer.valueOf(9830001));
    waves.add(Integer.valueOf(9830000));
    waves.add(Integer.valueOf(9830000));
    waves.add(Integer.valueOf(9830000));
    waves.add(Integer.valueOf(9830000));
    waves.add(Integer.valueOf(9830000));
    this.waveData.add(waves);
    List<Integer> waves2 = new ArrayList<>();
    waves2.add(Integer.valueOf(9830002));
    waves2.add(Integer.valueOf(9830002));
    waves2.add(Integer.valueOf(9830002));
    waves2.add(Integer.valueOf(9830002));
    waves2.add(Integer.valueOf(9830002));
    waves2.add(Integer.valueOf(9830004));
    waves2.add(Integer.valueOf(9830004));
    waves2.add(Integer.valueOf(9830003));
    waves2.add(Integer.valueOf(9830003));
    waves2.add(Integer.valueOf(9830003));
    waves2.add(Integer.valueOf(9830003));
    waves2.add(Integer.valueOf(9830003));
    this.waveData.add(waves2);
    List<Integer> waves3 = new ArrayList<>();
    waves3.add(Integer.valueOf(9830005));
    waves3.add(Integer.valueOf(9830005));
    waves3.add(Integer.valueOf(9830005));
    waves3.add(Integer.valueOf(9830005));
    waves3.add(Integer.valueOf(9830005));
    waves3.add(Integer.valueOf(9830006));
    waves3.add(Integer.valueOf(9830006));
    waves3.add(Integer.valueOf(9830007));
    waves3.add(Integer.valueOf(9830007));
    waves3.add(Integer.valueOf(9830007));
    waves3.add(Integer.valueOf(9830007));
    waves3.add(Integer.valueOf(9830007));
    waves3.add(Integer.valueOf(9830008));
    this.waveData.add(waves3);
    List<Integer> waves4 = new ArrayList<>();
    waves4.add(Integer.valueOf(9830009));
    waves4.add(Integer.valueOf(9830009));
    waves4.add(Integer.valueOf(9830009));
    waves4.add(Integer.valueOf(9830009));
    waves4.add(Integer.valueOf(9830009));
    waves4.add(Integer.valueOf(9830010));
    waves4.add(Integer.valueOf(9830010));
    waves4.add(Integer.valueOf(9830010));
    waves4.add(Integer.valueOf(9830010));
    waves4.add(Integer.valueOf(9830010));
    waves4.add(Integer.valueOf(9830011));
    waves4.add(Integer.valueOf(9830011));
    waves4.add(Integer.valueOf(9830011));
    waves4.add(Integer.valueOf(9830011));
    waves4.add(Integer.valueOf(9830011));
    waves4.add(Integer.valueOf(9830012));
    waves4.add(Integer.valueOf(9830012));
    waves4.add(Integer.valueOf(9830012));
    waves4.add(Integer.valueOf(9830012));
    waves4.add(Integer.valueOf(9830012));
    waves4.add(Integer.valueOf(9830013));
    this.waveData.add(waves4);
    List<Integer> waves5 = new ArrayList<>();
    waves5.add(Integer.valueOf(9830014));
    waves5.add(Integer.valueOf(9830014));
    waves5.add(Integer.valueOf(9830014));
    waves5.add(Integer.valueOf(9830014));
    waves5.add(Integer.valueOf(9830014));
    waves5.add(Integer.valueOf(9830015));
    waves5.add(Integer.valueOf(9830015));
    waves5.add(Integer.valueOf(9830015));
    waves5.add(Integer.valueOf(9830015));
    waves5.add(Integer.valueOf(9830015));
    waves5.add(Integer.valueOf(9830016));
    waves5.add(Integer.valueOf(9830016));
    waves5.add(Integer.valueOf(9830016));
    waves5.add(Integer.valueOf(9830016));
    waves5.add(Integer.valueOf(9830016));
    waves5.add(Integer.valueOf(9830017));
    waves5.add(Integer.valueOf(9830017));
    waves5.add(Integer.valueOf(9830017));
    waves5.add(Integer.valueOf(9830017));
    waves5.add(Integer.valueOf(9830017));
    waves5.add(Integer.valueOf(9830018));
    this.waveData.add(waves5);
  }

  public void start (final MapleClient c)
  {
    insertWaveData();
    updateDefenseWave(c);
    c.getSession().writeAndFlush(CField.startMapEffect("놈들이 사방에서 몰려오는군! 녀석들을 처치하면 막대한 경험치를 얻을 수 있다!", 5120159, true));
    c.getSession().writeAndFlush(CField.getClock(180));
    updateNewWave(c);
    this.sc = Timer.EventTimer.getInstance().schedule(new Runnable()
    {
      public void run ()
      {
        status = 0;

        if (c.getPlayer().getMapId() == 993000000)
        {
          c.getPlayer().warp(993000600);
        }

        if (BountyHunting.this.sc != null)
        {
          BountyHunting.this.sc.cancel(true);
        }
      }
    }, 180000L);
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
