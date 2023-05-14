package server.control;

import client.MapleCharacter;
import constants.GameConstants;
import handling.channel.ChannelServer;
import tools.CurrentTime1;

import java.util.Calendar;
import java.util.Iterator;

public class MapleEtcControl implements Runnable
{
  
  public long lastClearDropTime = 0, lastResetTimerTime = 0;
  public int date;
  public long lastCoreTime = 0;
  
  public MapleEtcControl()
  {
    lastClearDropTime = System.currentTimeMillis();
    date = CurrentTime1.요일();
    System.out.println("[Loading Completed] Start EtcControl");
  }
  
  
  @Override
  public void run()
  {
    long time = System.currentTimeMillis();
    
    
    Iterator<ChannelServer> channels = ChannelServer.getAllInstances().iterator();
    while (channels.hasNext())
    {
      ChannelServer cs = channels.next();
      Iterator<MapleCharacter> chrs = cs.getPlayerStorage().getAllCharacters().values().iterator();
      while (chrs.hasNext())
      {
        
        MapleCharacter chr = chrs.next();
        
        
        if (chr.getMapId() == 261020700 || chr.getMapId() == 261010103)
        {
          chr.setKeyValue(124, "ppp", String.valueOf(chr.getKeyValue(124, "ppp") + 1000));
          if (chr.getKeyValue(123, "pp") <= 0)
          {
            chr.warp(100000000);
            chr.dropMessage(5, "피로도가 없어 마을로 돌아갑니다.");
          }
          else
          {
            if (chr.getKeyValue(124, "ppp") > 60000)
            {
              chr.setKeyValue(123, "pp", String.valueOf(chr.getKeyValue(123, "pp") - 2));
              chr.setKeyValue(124, "ppp", "0");
              if (chr.getKeyValue(123, "pp") < 0)
              {
                chr.setKeyValue(123, "pp", String.valueOf(0));
              }
              chr.dropMessage(5, "피로도가 감소합니다. 남은 피로도 : " + chr.getKeyValue(123, "pp"));
            }
          }
        }
        
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.HOUR_OF_DAY) == 0 && cal.get(Calendar.MINUTE) < 1)
        {
          chr.setKeyValue(125, "date", String.valueOf(GameConstants.getCurrentDate_NoTime()));
          int pirodo = 0;
          switch (1)
          {
            case 1:
            {
              pirodo = 100;
              break;
            }
            case 2:
            {
              pirodo = 70;
              break;
            }
            case 3:
            {
              pirodo = 90;
              break;
            }
            case 4:
            {
              pirodo = 110;
              break;
            }
            case 5:
            {
              pirodo = 130;
              break;
            }
            case 6:
            {
              pirodo = 150;
              break;
            }
            case 7:
            {
              pirodo = 170;
              break;
            }
            case 8:
            {
              pirodo = 200;
              break;
            }
          }
          chr.setKeyValue(123, "pp", String.valueOf(pirodo));
          //  chr.dropMessage(5, "자정이지나 피로도가 초기화 되었습니다.");
        }
        
      }
    }
  }
}
