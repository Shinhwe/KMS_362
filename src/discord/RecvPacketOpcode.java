package discord;

public enum RecvPacketOpcode
{
  NULLPACKET(0),
  RqBasicInfo(1),
  RqPlayerList(2),
  RqGiveGM(3),
  Megaphone(4),
  RqWorldNotice(6);
  
  private int code = -2;
  
  RecvPacketOpcode(int code)
  {
    this.code = code;
  }
  
  public final int getValue()
  {
    return this.code;
  }
}
