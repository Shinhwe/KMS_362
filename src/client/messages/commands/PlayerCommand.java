package client.messages.commands;

import client.MapleClient;
import constants.GameConstants;
import constants.KoreaCalendar;
import constants.ServerConstants;
import tools.packet.CField;
import tools.packet.CWvsContext;

public class PlayerCommand
{
  public static ServerConstants.PlayerGMRank getPlayerLevelRequired ()
  {
    return ServerConstants.PlayerGMRank.NORMAL;
  }

  public static class check extends CommandExecute
  {
    public int execute (MapleClient c, String[] splitted)
    {
      c.getPlayer().dropMessage(6, "當前物品掉落率: " + c.getPlayer().getDropRate() + "%");
      c.getPlayer().dropMessage(6, "當前楓幣掉落率: " + (int)(c.getPlayer().getMesoDropChance() / 10000.0D) + "%");
      c.getPlayer().dropMessage(6, "當前楓幣倍率: " + c.getPlayer().getMesoRate() + "%");
      c.getPlayer().dropMessage(6, "當前經驗倍率: " + c.getPlayer().getExpRate() + "%");
      c.getPlayer().dropMessage(6, "當前力量: " + c.getPlayer().getTotalStr() + "(" + c.getPlayer().getStrPercent() + ")");
      c.getPlayer().dropMessage(6, "當前敏捷: " + c.getPlayer().getTotalDex() + "(" + c.getPlayer().getDexPercent() + ")");
      c.getPlayer().dropMessage(6, "當前智力: " + c.getPlayer().getTotalInt() + "(" + c.getPlayer().getIntPercent() + ")");
      c.getPlayer().dropMessage(6, "當前運氣: " + c.getPlayer().getTotalLuk() + "(" + c.getPlayer().getLukPercent() + ")");
      c.getPlayer().dropMessage(6, "當前攻擊力百分比: " + c.getPlayer().getPAtkPercent());
      c.getPlayer().dropMessage(6, "當前魔力百分比: " + c.getPlayer().getMAtkPercent());
      c.getPlayer().dropMessage(6, "當前延遲: " + c.getLatency());
      return 1;
    }
  }

  // 方便測試每天重置每日簽到用的命令, 測試完了記得刪除
  public static class resetDaily extends CommandExecute
  {
    public int execute (MapleClient c, String[] splitted)
    {
      KoreaCalendar kc = new KoreaCalendar();
      int 已簽到天數 = Integer.parseInt(c.getKeyValue("dailyGiftDay", "0"));
      int 今天日期 = GameConstants.getCurrentDate_NoTime();
      if (kc.getDayt() == 1)
      {
        已簽到天數 = 0;
        c.setKeyValue("dailyGiftDay", "0");
      }
      c.setKeyValue("dailyGiftComplete", "0");
      c.send(CWvsContext.updateDailyGift("count=0;day=" + 已簽到天數 + ";date=" + 今天日期));
      c.send(CField.dailyGift(c.getPlayer(), 1, 0));
      c.getPlayer().updateInfoQuest(16700, "count=0;date=" + 今天日期);
      c.getPlayer().setIsDailyGiftTooltipPacketSend(false);
      return 1;
    }
  }
}
