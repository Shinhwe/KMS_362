package server.shops;

import constants.GameConstants;
import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MapleShopFactory
{
  private static final MapleShopFactory instance = new MapleShopFactory();
  private final Map<Integer, MapleShop> shops = new HashMap<>();
  private final Map<Integer, MapleShop> npcShops = new HashMap<>();

  public static MapleShopFactory getInstance ()
  {
    return instance;
  }

  private void loadShopitem (MapleShop shop)
  {
    Connection con = null;
    try
    {
      con = DatabaseConnection.getConnection();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM shopitems WHERE shopid = ? ORDER BY position ASC");
      ps.setInt(1, shop.getId());
      ResultSet rs = ps.executeQuery();
      int i = 1;
      ArrayList<Integer> rechargeableItemList = MapleShop.getRechargeableItemList();

      while (rs.next())
      {
        int itemId = rs.getInt("itemid");
        int shopItemId = rs.getInt("shopitemid");
        int price = rs.getInt("price");
        int priceQuantity = rs.getInt("pricequantity");
        int tab = rs.getInt("Tab");
        int quantity = rs.getInt("quantity");
        int period = rs.getInt("period");
        int itemRate = rs.getInt("itemrate");
        int buyQuantity = rs.getInt("buyquantity");
        int rechargeMonth = rs.getInt("rechargemonth");
        int rechargeDay = rs.getInt("rechargeday");
        int resetDay = rs.getInt("resetday");
        int recharge = rs.getInt("recharge");
        int rechargeCount = rs.getInt("rechargecount");

        if (GameConstants.isThrowingStar(itemId) || GameConstants.isBullet(itemId))
        {
          MapleShopItem starItem = new MapleShopItem(shopItemId, (short) 1, itemId, price, priceQuantity, (byte) tab, quantity, period, i, itemRate, buyQuantity, rechargeMonth, rechargeDay, resetDay, recharge, rechargeCount);
          shop.addItem(starItem);

          if (rechargeableItemList.contains(Integer.valueOf(starItem.getItemId())))
          {
            rechargeableItemList.remove(Integer.valueOf(starItem.getItemId()));
          }
        }
        else if (GameConstants.isBowArrow(itemId) || GameConstants.isCrossbowArrow(itemId))
        {
          shop.addItem(new MapleShopItem(shopItemId, (short) 30000, itemId, price, priceQuantity, (byte) tab, quantity, period, i, itemRate, buyQuantity, rechargeMonth, rechargeDay, resetDay, recharge, rechargeCount));
        }
        else
        {
          shop.addItem(new MapleShopItem(shopItemId, (short) 1000, itemId, price, priceQuantity, (byte) tab, quantity, period, i, itemRate, buyQuantity, rechargeMonth, rechargeDay, resetDay, recharge, rechargeCount));
        }
        i++;
      }

      i = 1;
      for (Integer recharge : rechargeableItemList)
      {
        shop.addItem(new MapleShopItem(0, (short) 1000, recharge.intValue(), 0L, 0, (byte) 0, 0, 0, i, 0, 0, 0, 0, 0, 0, 0));
        i++;
      }

      rs.close();
      ps.close();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (con != null)
      {
        try
        {
          con.close();
        }
        catch (SQLException ex)
        {
          Logger.getLogger(MapleShop.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

  public void loadShop ()
  {
    Connection con = null;
    try
    {
      con = DatabaseConnection.getConnection();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM shops ORDER BY shopid DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next())
      {
        int shopId = rs.getInt("shopid");
        MapleShop shop = new MapleShop(shopId, rs.getInt("npcid"), rs.getInt("coinKey"), rs.getString("shopString"), rs.getString("saleString"), rs.getInt("rechargeshop"));
        loadShopitem(shop);
        npcShops.put(shop.getNpcId(), shop);
        shops.put(shopId, shop);
      }
      rs.close();
      ps.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (con != null)
      {
        try
        {
          con.close();
        }
        catch (SQLException ex)
        {
          Logger.getLogger(MapleShop.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

  public MapleShop getShop (int shopId)
  {
    if (this.shops.containsKey(Integer.valueOf(shopId)))
    {
      return this.shops.get(Integer.valueOf(shopId));
    }
    return null;
  }

  public MapleShop getShopForNPC (int npcId)
  {
    if (this.npcShops.containsKey(Integer.valueOf(npcId)))
    {
      return this.npcShops.get(Integer.valueOf(npcId));
    }
    return null;
  }
}
