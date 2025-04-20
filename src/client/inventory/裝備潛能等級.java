package client.inventory;

public enum 裝備潛能等級
{
  沒有潛能((byte) 0), 特殊未鑑定((byte) 1), 稀有未鑑定((byte) 2), 罕見未鑑定((byte) 3), 傳說未鑑定((byte) 4), 特殊((byte) 17), 稀有((byte) 18), 罕見((byte) 19), 傳說((byte) 20), 主潛能特殊未鑑定附加潛能未鑑定((byte) 33), 主潛能稀有未鑑定附加潛能未鑑定((byte) 34), 主潛能罕見未鑑定附加潛能未鑑定((byte) 35), 主潛能傳說未鑑定附加潛能未鑑定((byte) 36), 主潛能特殊附加潛能未鑑定((byte) 49), 主潛能稀有附加潛能未鑑定((byte) 50), 主潛能罕見附加潛能未鑑定((byte) 51), 主潛能傳說附加潛能未鑑定((byte) 52);

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
