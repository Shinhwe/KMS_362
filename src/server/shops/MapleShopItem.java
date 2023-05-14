package server.shops;

public class MapleShopItem
{
  private final int id;
  
  private final short buyable;
  
  private final int itemId;
  
  private final long price;
  
  private final int pricequantity;
  
  private final byte tab;
  
  private final int quantity;
  
  private final int period;
  
  private final int position;
  private final int buyquantity;
  private final int rechargemonth;
  private final int recharge;
  private final int rechargeday;
  private final int rechargecount;
  private int itemRate;
  private int resetday;
  
  public MapleShopItem(int id, short buyable, int itemId, long price, int pricequantity, byte tab, int quantity, int period, int position, int itemRate, int buyquantity, int rechargemonth, int rechargeday, int resetday, int recharge, int rechargecount)
  {
    this.id = id;
    this.buyable = buyable;
    this.itemId = itemId;
    this.price = price;
    this.pricequantity = pricequantity;
    this.tab = tab;
    this.quantity = quantity;
    this.period = period;
    this.position = position;
    this.itemRate = itemRate;
    this.buyquantity = buyquantity;
    this.rechargemonth = rechargemonth;
    this.rechargeday = rechargeday;
    this.resetday = resetday;
    this.recharge = recharge;
    this.rechargecount = rechargecount;
  }
  
  public int getShopItemId()
  {
    return this.id;
  }
  
  public int getPriceQuantity()
  {
    return this.pricequantity;
  }
  
  public int getBuyQuantity()
  {
    return this.buyquantity;
  }
  
  public byte getTab()
  {
    return this.tab;
  }
  
  public int getQuantity()
  {
    return this.quantity;
  }
  
  public int getPeriod()
  {
    return this.period;
  }
  
  public short getBuyable()
  {
    return this.buyable;
  }
  
  public int getItemId()
  {
    return this.itemId;
  }
  
  public long getPrice()
  {
    return this.price;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public int getItemRate()
  {
    return this.itemRate;
  }
  
  public void setItemRate(int itemRate)
  {
    this.itemRate = itemRate;
  }
  
  public int getReChargeMonth()
  {
    return this.rechargemonth;
  }
  
  public int getReChargeDay()
  {
    return this.rechargeday;
  }
  
  public int getReCharge()
  {
    return this.recharge;
  }
  
  public int getReChargeCount()
  {
    return this.rechargecount;
  }
  
  public int getResetday()
  {
    return this.resetday;
  }
  
  public void setResetday(int resetday)
  {
    this.resetday = resetday;
  }
}
