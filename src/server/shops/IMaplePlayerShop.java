package server.shops;

import client.MapleCharacter;
import client.MapleClient;
import tools.Pair;

import java.util.List;

public interface IMaplePlayerShop
{
  byte HIRED_MERCHANT = 1;
  
  byte PLAYER_SHOP = 2;
  
  byte OMOK = 3;
  
  byte MATCH_CARD = 4;
  
  byte MARRIAGE = 8;
  
  String getOwnerName();
  
  String getDescription();
  
  List<Pair<Byte, MapleCharacter>> getVisitors();
  
  List<MaplePlayerShopItem> getItems();
  
  boolean isOpen();
  
  void setOpen(boolean paramBoolean);
  
  boolean removeItem(int paramInt);
  
  boolean isOwner(MapleCharacter paramMapleCharacter);
  
  byte getShopType();
  
  byte getVisitorSlot(MapleCharacter paramMapleCharacter);
  
  byte getFreeSlot();
  
  int getItemId();
  
  long getMeso();
  
  void setMeso(long paramLong);
  
  int getOwnerId();
  
  int getOwnerAccId();
  
  void addItem(MaplePlayerShopItem paramMaplePlayerShopItem);
  
  void removeFromSlot(int paramInt);
  
  void broadcastToVisitors(byte[] paramArrayOfbyte);
  
  void addVisitor(MapleCharacter paramMapleCharacter);
  
  void removeVisitor(MapleCharacter paramMapleCharacter);
  
  void removeAllVisitors(int paramInt1, int paramInt2);
  
  void buy(MapleClient paramMapleClient, int paramInt, short paramShort);
  
  void closeShop(boolean paramBoolean1, boolean paramBoolean2);
  
  String getPassword();
  
  int getMaxSize();
  
  int getSize();
  
  int getGameType();
  
  void update();
  
  boolean isAvailable();
  
  void setAvailable(boolean paramBoolean);
  
  List<AbstractPlayerStore.BoughtItem> getBoughtItems();
  
  String getMemberNames();
}
