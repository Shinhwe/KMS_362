package server.polofritto;

import client.MapleCharacter;
import client.MapleClient;
import handling.channel.ChannelServer;
import server.Timer;
import server.life.MapleLifeFactory;
import server.maps.MapleMap;
import server.maps.MapleMapFactory;
import tools.packet.CField;

import java.awt.*;
import java.util.concurrent.ScheduledFuture;

public class FlameWolf
{
  private ScheduledFuture<?> sc;

  public FlameWolf ()
  {

  }

  public void doLeave (MapleCharacter chr)
  {
    if (this.sc != null)
    {
      this.sc.cancel(true);
    }

    chr.setFlameWolf(null);

    if (chr.getQuestStatus(16407) == 1)
    {
      chr.forceCompleteQuest(16407);
    }

    if (chr.getMapId() == 993000500)
    {
      chr.warp(993000600);
    }
  }

  public void killed (MapleCharacter chr)
  {
    chr.getPlayer().setIsFlameWolfKiller(true);

    for (MapleCharacter chr1 : chr.getMap().getAllChracater())
    {
      if (chr1.getMapId() == 993000500 && chr1.getFlameWolf() != null)
      {
        chr1.getFlameWolf().doLeave(chr1);
      }
    }
  }

  public void doDamage (MapleCharacter chr, long damage)
  {
    chr.setFlameWolfDamage(chr.getFlameWolfDamage() + damage);
    chr.setFlameWolfAttackCount(chr.getFlameWolfAttackCount() + 1);
    chr.dropMessageGM(5, "total damage : " + chr.getFlameWolfDamage());
  }

  public void start (MapleClient c)
  {
    final MapleMapFactory mapFactory = ChannelServer.getInstance(c.getChannel()).getMapFactory();

    final MapleMap map = mapFactory.getMap(993000500);

    if (map.getAllMonster().size() == 0)
    {
      map.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9101078), new Point(25, 353));
    }

    c.getPlayer().setFlameWolfDamage(0L);

    c.getPlayer().setIsFlameWolfKiller(false);

    c.getSession().writeAndFlush(CField.startMapEffect("불꽃늑대를 처치할 용사가 늘었군. 어서 녀석을 공격해! 머무를 수 있는 시간은 30초 뿐이야!", 5120159, true));

    c.getSession().writeAndFlush(CField.getClock(30));

    sc = Timer.MapTimer.getInstance().schedule(() ->
    {
      FlameWolf.this.doLeave(c.getPlayer());
    }, 30000L);
  }
}
