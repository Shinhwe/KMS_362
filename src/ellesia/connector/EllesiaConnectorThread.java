package ellesia.connector;

import constants.ServerConstants;
import scripting.NPCConversationManager;

import java.util.Collection;

public class EllesiaConnectorThread extends Thread
{
  
  public EllesiaConnectorThread()
  {
  }
  
  @Override
  public void run()
  {
    if (ServerConstants.ConnectorSetting)
    {
      Collection<EllesiaClient> clients = EllesiaConnectorServer.getInstance().getClients();
      for (EllesiaClient client : clients)
      {
        if (!client.getId().equalsIgnoreCase(""))
        {
          if (System.currentTimeMillis() - client.getLastPing() > 5000)
          {
            client.closeSession();
            EllesiaWalker.setAlive(client.getId(), false);
            String data = "아이디 : " + client.getId() + " 아이피 : " + client.getIP() + " 서스펜드 시도\r\n";
            NPCConversationManager.writeLog("Log/Ellesia/Heartbeat.log", data, true);
          }
        }
      }
    }
  }
}