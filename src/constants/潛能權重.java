package constants;

public class 潛能權重
{
  private int 潛能id;

  private int 權重;

  public 潛能權重 (int 潛能id, int 權重)
  {
    this.潛能id = 潛能id;
    this.權重 = 權重;
  }

  public int 獲取潛能id ()
  {
    return 潛能id;
  }

  public void 設置潛能id (int 潛能id)
  {
    this.潛能id = 潛能id;
  }

  public int 獲取權重 ()
  {
    return 權重;
  }

  public void 設置權重 (int 權重)
  {
    this.權重 = 權重;
  }
}
