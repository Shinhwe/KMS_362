package client.messages.commands;

import client.MapleClient;
import constants.ServerConstants;

public abstract class CommandExecute
{
  public abstract int execute(MapleClient paramMapleClient, String[] paramArrayOfString);
  
  public ServerConstants.CommandType getType()
  {
    return ServerConstants.CommandType.NORMAL;
  }
  
  enum ReturnValue
  {
    DONT_LOG, LOG
  }
  
  public static abstract class TradeExecute extends CommandExecute
  {
    public ServerConstants.CommandType getType()
    {
      return ServerConstants.CommandType.TRADE;
    }
  }
}
