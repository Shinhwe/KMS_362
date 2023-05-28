package server.shops;

public class MapleShopItem
{
  private int id;

  private short buyable;

  private int itemId;

  private long price;

  private int priceQuantity;

  private byte tab;

  private int quantity;

  private int period;

  private int position;
  private int buyQuantity;
  private int rechargeMonth;
  private int recharge;
  private int rechargeDay;
  private int rechargeCount;
  private int itemRate;
  private int resetDay;

  public MapleShopItem (int id, short buyable, int itemId, long price, int priceQuantity, byte tab, int quantity, int period, int position, int itemRate, int buyQuantity, int rechargeMonth, int rechargeDay, int resetDay, int recharge,
                        int rechargeCount)
  {
    this.id = id;
    this.buyable = buyable;
    this.itemId = itemId;
    this.price = price;
    this.priceQuantity = priceQuantity;
    this.tab = tab;
    this.quantity = quantity;
    this.period = period;
    this.position = position;
    this.itemRate = itemRate;
    this.buyQuantity = buyQuantity;
    this.rechargeMonth = rechargeMonth;
    this.rechargeDay = rechargeDay;
    this.resetDay = resetDay;
    this.recharge = recharge;
    this.rechargeCount = rechargeCount;
  }

  public int getShopItemId ()
  {
    return this.id;
  }

  public int getPriceQuantity ()
  {
    return this.priceQuantity;
  }

  public int getBuyQuantity ()
  {
    return this.buyQuantity;
  }

  public byte getTab ()
  {
    return this.tab;
  }

  public int getQuantity ()
  {
    return this.quantity;
  }

  public int getPeriod ()
  {
    return this.period;
  }

  public short getBuyable ()
  {
    return this.buyable;
  }

  public int getItemId ()
  {
    return this.itemId;
  }

  public long getPrice ()
  {
    return this.price;
  }

  public int getPosition ()
  {
    return this.position;
  }

  public int getItemRate ()
  {
    return this.itemRate;
  }

  public void setItemRate (int itemRate)
  {
    this.itemRate = itemRate;
  }

  public int getReChargeMonth ()
  {
    return this.rechargeMonth;
  }

  public int getReChargeDay ()
  {
    return this.rechargeDay;
  }

  public int getReCharge ()
  {
    return this.recharge;
  }

  public int getReChargeCount ()
  {
    return this.rechargeCount;
  }

  public int getResetDay ()
  {
    return this.resetDay;
  }

  public void setResetDay (int resetday)
  {
    this.resetDay = resetday;
  }

  public void setRechargeMonth (int rechargeMonth)
  {
    this.rechargeMonth = rechargeMonth;
  }

  public void setRechargeDay (int rechargeDay)
  {
    this.rechargeDay = rechargeDay;
  }
}
