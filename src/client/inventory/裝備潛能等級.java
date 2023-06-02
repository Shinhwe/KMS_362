package client.inventory;

public enum 裝備潛能等級
{
  沒有潛能((byte) 0), 特殊未鑑定((byte) 1), 稀有未鑑定((byte) 2), 罕見未鑑定((byte) 3), 傳說未鑑定((byte) 4), 特殊((byte) 17), 稀有((byte) 18), 罕見((byte) 19), 傳說((byte) 20);

  private final byte 潛能等級的值;

  裝備潛能等級 (byte 潛能等級)
  {
    this.潛能等級的值 = 潛能等級;
  }

  public byte 獲取潛能等級的值 ()
  {
    return 潛能等級的值;
  }
}
