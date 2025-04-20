/*     */
package handling.auction;
/*     */
/*     */

import client.inventory.*;
import constants.GameConstants;
import constants.ServerType;
import database.DatabaseConnection;
import handling.channel.PlayerStorage;
import handling.netty.MapleNettyDecoder;
import handling.netty.MapleNettyEncoder;
import handling.netty.MapleNettyHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.mina.core.service.IoAcceptor;
import server.MapleItemInformationProvider;
import server.ServerProperties;
import server.maps.BossReward;
import tools.FileoutputUtil;

import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ public class AuctionServer
    /*     */
{
  /*  58 */   private static final int PORT = Integer.parseInt(ServerProperties.getProperty("ports.auction"));
  /*  62 */   private static final Map<Integer, AuctionItem> items = new ConcurrentHashMap<>();
  /*     */   private static String ip;
  /*     */   private static InetSocketAddress InetSocketadd;
  /*     */   private static IoAcceptor acceptor;
  /*     */   private static PlayerStorage players;
  /*     */   private static boolean finishedShutdown = false;
  /*     */
  /*     */   private static ServerBootstrap bootstrap;
  
  /*     */
  /*     */
  public static final void run_startup_configurations()
  {
    /*  67 */
    players = new PlayerStorage();
    /*  68 */
    ip = ServerProperties.getProperty("world.host") + ":" + PORT;
    /*     */
    /*  70 */
    NioEventLoopGroup nioEventLoopGroup1 = new NioEventLoopGroup();
    /*  71 */
    NioEventLoopGroup nioEventLoopGroup2 = new NioEventLoopGroup();
    /*     */
    /*     */
    try
    {
      /*  74 */
      bootstrap = new ServerBootstrap();
      /*  75 */
      bootstrap.group(nioEventLoopGroup1, nioEventLoopGroup2)
/*  76 */.channel(NioServerSocketChannel.class)
/*  77 */.childHandler(new ChannelInitializer<SocketChannel>()
          /*     */
      {
        /*     */
        public void initChannel(SocketChannel ch) throws Exception
        {
          /*  80 */
          ch.pipeline().addLast("decoder", new MapleNettyDecoder());
          /*  81 */
          ch.pipeline().addLast("encoder", new MapleNettyEncoder());
          /*  82 */
          ch.pipeline().addLast("handler", new MapleNettyHandler(ServerType.CASHSHOP, -1));
          /*     */
        }
        /*  85 */
      }).option(ChannelOption.SO_BACKLOG, Integer.valueOf(128))
/*  86 */.childOption(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(true));
      /*  87 */
      ChannelFuture f = bootstrap.bind(PORT).sync();
      /*  88 */
      loadItems();
      /*  93 */
      System.out.println("[알림] 경매장 서버가 " + PORT + " 포트를 성공적으로 개방하였습니다.");
      /*  94 */
    }
    catch (InterruptedException e)
    {
      /*  95 */
      System.err.println("[오류] 경매장 서버가 " + PORT + " 포트를 개방하는데 실패했습니다.");
      /*     */
    }
    /*     */
  }
  
  /*     */
  /*     */
  public static final String getIP()
  {
    /* 100 */
    return ip;
    /*     */
  }
  
  /*     */
  /*     */
  public static final PlayerStorage getPlayerStorage()
  {
    /* 104 */
    return players;
    /*     */
  }
  
  /*     */
  /*     */
  public static final void shutdown()
  {
    /* 108 */
    if (finishedShutdown)
    {
      /*     */
      return;
      /*     */
    }
    /* 111 */
    System.out.println("Saving all connected clients (Auction)...");
    /* 112 */
    players.disconnectAll();
    /* 113 */
    System.out.println("Shutting down Auction...");
    /* 114 */
    finishedShutdown = true;
    /*     */
  }
  
  /*     */
  /*     */
  public static boolean isShutdown()
  {
    /* 118 */
    return finishedShutdown;
    /*     */
  }
  
  /*     */
  /*     */
  /*     */
  public static void addInventoryItem(Connection con, List<Item> items)
  {
    /*     */
    try
    {
      /* 124 */
      String[] columns = {"inventoryitems", "inventoryitemsuse", "inventoryitemssetup", "inventoryitemsetc", "inventoryitemscash", "inventoryitemscody"};
      /*     */
      /* 126 */
      for (String column : columns)
      {
        /* 127 */
        /* 128 */
        String query = "DELETE FROM `" +
            /* 129 */
            column +
            /* 130 */
            "`WHERE `type` = 7";
        /* 131 */
        PreparedStatement ps = con.prepareStatement(query);
        /* 132 */
        ps.executeUpdate();
        /* 133 */
        ps.close();
        /*     */
      }
      /* 135 */
      if (items == null)
      {
        /*     */
        return;
        /*     */
      }
      /* 138 */
      Iterator<Item> iter = items.iterator();
      /*     */
      /* 140 */
      while (iter.hasNext())
      {
        /* 141 */
        PreparedStatement pse;
        Item item = iter.next();
        /*     */
        /* 143 */
        if (item == null)
        {
          /*     */
          continue;
          /*     */
        }
        /*     */
        /* 147 */
        StringBuilder query_2 = new StringBuilder("INSERT INTO `");
        /* 148 */
        switch (GameConstants.getInventoryType(item.getItemId()).getType())
        {
          /*     */
          case 2:
            /* 150 */
            query_2.append("inventoryitemsuse");
            /*     */
            break;
          /*     */
          case 3:
            /* 153 */
            query_2.append("inventoryitemssetup");
            /*     */
            break;
          /*     */
          case 4:
            /* 156 */
            query_2.append("inventoryitemsetc");
            /*     */
            break;
          /*     */
          case 5:
            /* 159 */
            query_2.append("inventoryitemscash");
            /*     */
            break;
          /*     */
          case 6:
            /* 162 */
            query_2.append("inventoryitemscody");
            /*     */
            break;
          /*     */
          default:
            /* 165 */
            query_2.append("inventoryitems");
            /*     */
            break;
          /*     */
        }
        /* 168 */
        query_2.append("` (");
        /* 169 */
        query_2.append("characterid, itemid, inventorytype, position, quantity, owner, GM_Log, uniqueid, expiredate, flag, `type`, sender, marriageId");
        /* 170 */
        query_2.append(", price, partyid, mobid, objectid");
        /* 171 */
        query_2.append(") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
        /* 172 */
        query_2.append(", ?, ?, ?, ?, ?");
        /* 173 */
        query_2.append(")");
        /* 174 */
        PreparedStatement ps = con.prepareStatement(query_2.toString(), 1);
        /*     */
        /* 176 */
        if (GameConstants.getInventoryType(item.getItemId()).getType() == 6)
        {
          /* 177 */
          pse = con.prepareStatement("INSERT INTO `inventoryequipmentcody` VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
          /*     */
        }
        else
        {
          /* 179 */
          pse = con.prepareStatement("INSERT INTO `inventoryequipment` VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
          /*     */
        }
        /* 181 */
        ps.setInt(1, -1);
        /* 182 */
        ps.setInt(2, item.getItemId());
        /* 183 */
        ps.setInt(3, GameConstants.getInventoryType(item.getItemId()).getType());
        /* 184 */
        ps.setInt(4, item.getPosition());
        /* 185 */
        ps.setInt(5, item.getQuantity());
        /* 186 */
        ps.setString(6, item.getOwner());
        /* 187 */
        ps.setString(7, item.getGMLog());
        /* 188 */
        if (item.getPet() != null)
        {
          /*     */
          /* 190 */
          ps.setLong(8, Math.max(item.getUniqueId(), item.getPet().getUniqueId()));
          /*     */
        }
        else
        {
          /* 192 */
          ps.setLong(8, item.getUniqueId());
          /*     */
        }
        /* 194 */
        ps.setLong(9, item.getExpiration());
        /* 195 */
        if (item.getFlag() < 0)
        {
          /* 196 */
          ps.setInt(10, (MapleItemInformationProvider.getInstance().getItemInformation(item.getItemId())).flag);
          /*     */
        }
        else
        {
          /* 198 */
          ps.setInt(10, item.getFlag());
          /*     */
        }
        /* 200 */
        ps.setByte(11, (byte) 7);
        /* 201 */
        ps.setString(12, item.getGiftFrom());
        /* 202 */
        ps.setInt(13, item.getMarriageId());
        /* 203 */
        if (item.getReward() != null)
        {
          /* 204 */
          ps.setInt(14, item.getReward().getPrice());
          /* 205 */
          ps.setInt(15, item.getReward().getPartyId());
          /* 206 */
          ps.setInt(16, item.getReward().getMobId());
          /* 207 */
          ps.setInt(17, item.getReward().getObjectId());
          /*     */
        }
        else
        {
          /* 209 */
          ps.setInt(14, 0);
          /* 210 */
          ps.setInt(15, 0);
          /* 211 */
          ps.setInt(16, 0);
          /* 212 */
          ps.setInt(17, 0);
          /*     */
        }
        /* 214 */
        ps.executeUpdate();
        /*     */
        /* 216 */
        ResultSet rs = ps.getGeneratedKeys();
        /*     */
        /* 218 */
        if (!rs.next())
        {
          /* 219 */
          rs.close();
          /*     */
          continue;
          /*     */
        }
        /* 222 */
        long iid = rs.getLong(1);
        /* 223 */
        rs.close();
        /*     */
        /* 225 */
        item.setInventoryId(iid);
        /*     */
        /* 227 */
        if (item.getItemId() / 1000000 == 1)
        {
          /*     */
          /* 229 */
          Equip equip = (Equip) item;
          /*     */
          /* 231 */
          pse.setLong(1, iid);
          /* 232 */
          pse.setInt(2, equip.getTotalUpgradeSlots());
          /* 233 */
          if (equip.getItemId() >= 1113098 && equip.getItemId() <= 1113128)
          {
            /* 234 */
            pse.setInt(3, equip.getItemLevel());
            /*     */
          }
          else
          {
            /* 236 */
            pse.setInt(3, equip.getEnchantLevel());
            /*     */
          }
          /* 238 */
          pse.setInt(4, equip.getEnchantStr());
          /* 239 */
          pse.setInt(5, equip.getEnchantDex());
          /* 240 */
          pse.setInt(6, equip.getEnchantInt());
          /* 241 */
          pse.setInt(7, equip.getEnchantLuk());
          /* 242 */
          pse.setInt(8, equip.getArcPower());
          /* 243 */
          pse.setInt(9, equip.getArcExp());
          /* 244 */
          pse.setInt(10, equip.getArcLevel());
          /* 245 */
          pse.setInt(11, equip.getEnchantHp());
          /* 246 */
          pse.setInt(12, equip.getEnchantMp());
          /* 247 */
          pse.setInt(13, equip.getEnchantWatk());
          /* 248 */
          pse.setInt(14, equip.getEnchantMatk());
          /* 249 */
          pse.setInt(15, equip.getEnchantWdef());
          /* 250 */
          pse.setInt(16, equip.getEnchantMdef());
          /* 251 */
          pse.setInt(17, equip.getEnchantAccuracy());
          /* 252 */
          pse.setInt(18, equip.getEnchantAvoid());
          /* 253 */
          pse.setInt(19, equip.getEnchantCraft());
          /* 254 */
          pse.setInt(20, equip.getEnchantMovementSpeed());
          /* 255 */
          pse.setInt(21, equip.getEnchantJump());
          /* 256 */
          pse.setInt(22, equip.getViciousHammer());
          /* 257 */
          pse.setInt(23, equip.getItemEXP());
          /* 258 */
          pse.setInt(24, equip.getDurability());
          /* 259 */
          pse.setByte(25, equip.getStarForceLevel());
          /* 260 */
          pse.setByte(26, equip.獲取潛能等級().獲取潛能等級的值());
          /* 261 */
          pse.setByte(27, (byte) 0);
          /* 262 */
          pse.setInt(28, equip.獲取第一條主潛能());
          /* 263 */
          pse.setInt(29, equip.獲取第二條主潛能());
          /* 264 */
          pse.setInt(30, equip.獲取第三條主潛能());
          /* 265 */
          pse.setInt(31, equip.獲取第一條附加潛能());
          /* 266 */
          pse.setInt(32, equip.獲取第二條附加潛能());
          /* 267 */
          pse.setInt(33, equip.獲取第三條附加潛能());
          /* 268 */
          pse.setInt(34, equip.getIncSkill());
          /* 269 */
          pse.setShort(35, equip.getCharmEXP());
          /* 270 */
          pse.setShort(36, (byte) 0);
          /* 271 */
          pse.setShort(37, equip.getEnchantBuff());
          /* 272 */
          pse.setByte(38, (byte) 0);
          /* 273 */
          pse.setByte(39, equip.getYggdrasilWisdom());
          /* 274 */
          pse.setByte(40, (byte) (equip.getFinalStrike() ? 1 : 0));
          /* 275 */
          pse.setShort(41, equip.getEnchantBossDamage());
          /* 276 */
          pse.setShort(42, equip.getEnchantIgnorePDR());
          /* 277 */
          pse.setByte(43, equip.getTotalDamage());
          /* 278 */
          pse.setByte(44, equip.getTotalAllStat());
          /* 279 */
          pse.setByte(45, equip.getKarmaCount());
          /* 280 */
          pse.setShort(46, equip.getSoulName());
          /* 281 */
          pse.setShort(47, equip.getSoulEnchanter());
          /* 282 */
          pse.setShort(48, equip.getSoulPotential());
          /* 283 */
          pse.setInt(49, equip.getSoulSkill());
          /* 284 */
          pse.setLong(50, equip.getFlame());
          /* 285 */
          pse.setInt(51, equip.getEquipmentType());
          /* 286 */
          pse.setInt(52, equip.getMoru());
          /* 287 */
          pse.setInt(53, equip.getTemplate().getAttackSpeed());
          /* 288 */
          pse.setLong(54, equip.getOptionExpiration());
          /* 289 */
          pse.setInt(55, equip.getCoption1());
          /* 290 */
          pse.setInt(56, equip.getCoption2());
          /* 291 */
          pse.setInt(57, equip.getCoption3());
          /* 292 */
          pse.executeUpdate();
          /* 293 */
          if (equip.getItemId() / 10000 == 166 &&
              /* 294 */             equip.getAndroid() != null)
          {
            /* 295 */
            equip.getAndroid().saveToDb();
            /*     */
          }
          /*     */
          /*     */
          /* 299 */
          /*     */
        }
        /* 319 */
        ps.close();
        /* 320 */
        pse.close();
        /*     */
      }
      /* 322 */
    }
    catch (Exception e)
    {
      /* 323 */
      e.printStackTrace();
      /*     */
    }
    /*     */
  }
  
  /*     */
  /*     */
  public static void addNewItem(AuctionItem item)
  {
    /* 328 */
    Connection con = null;
    /* 329 */
    PreparedStatement ps = null;
    /* 330 */
    ResultSet rs = null;
    /*     */
    try
    {
      /* 332 */
      con = DatabaseConnection.getConnection();
      /*     */
      /* 334 */
      ps = con.prepareStatement("INSERT INTO `auctionitems` (`auctiontype`, `accountid`, `characterid`, `state`, `worldid`, `biduserid`,`price`, `directprice`, `enddate`, `registerdate`, `name`, `inventoryitemid`, `auctionitemid`, `bidusername`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 1);
      /* 335 */
      ps.setInt(1, item.getAuctionType());
      /* 336 */
      ps.setInt(2, item.getAccountId());
      /* 337 */
      ps.setInt(3, item.getCharacterId());
      /* 338 */
      ps.setInt(4, item.getState());
      /* 339 */
      ps.setInt(5, item.getWorldId());
      /* 340 */
      ps.setInt(6, item.getBidUserId());
      /* 341 */
      ps.setLong(7, item.getPrice());
      /* 342 */
      ps.setLong(8, item.getDirectPrice());
      /* 343 */
      ps.setLong(9, item.getEndDate());
      /* 344 */
      ps.setLong(10, item.getRegisterDate());
      /* 345 */
      ps.setString(11, item.getName());
      /* 346 */
      ps.setLong(12, item.getItem().getInventoryId());
      /* 347 */
      ps.setInt(13, item.getAuctionId());
      /* 348 */
      ps.setString(14, (item.getBidUserName() == null) ? "없음" : item.getBidUserName());
      /* 349 */
      ps.executeUpdate();
      /*     */
      /* 351 */
      ps.close();
      /*     */
      /* 353 */
      AuctionHistory history = item.getHistory();
      /*     */
      /* 355 */
      if (history != null)
      {
        /* 356 */
        ps = con.prepareStatement("INSERT INTO `auctionhistories` (`auctionid`, `accountid`, `characterid`, `itemid`, `state`, `price`, `buytime`, `deposit`, `quantity`, `worldid`, `biduserid`, `bidusername`, `id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 1);
        /* 357 */
        ps.setInt(1, history.getAuctionId());
        /* 358 */
        ps.setInt(2, history.getAccountId());
        /* 359 */
        ps.setInt(3, history.getCharacterId());
        /* 360 */
        ps.setInt(4, history.getItemId());
        /* 361 */
        ps.setInt(5, history.getState());
        /* 362 */
        ps.setLong(6, history.getPrice());
        /* 363 */
        ps.setLong(7, history.getBuyTime());
        /* 364 */
        ps.setInt(8, history.getDeposit());
        /* 365 */
        ps.setInt(9, history.getQuantity());
        /* 366 */
        ps.setInt(10, history.getWorldId());
        /* 367 */
        ps.setInt(11, history.getBidUserId());
        /* 368 */
        ps.setString(12, (history.getBidUserName() == null) ? "없음" : history.getBidUserName());
        /* 369 */
        ps.setLong(13, history.getId());
        /* 370 */
        ps.executeUpdate();
        /*     */
        /* 372 */
        ps.close();
        /*     */
      }
      /* 374 */
    }
    catch (SQLException e)
    {
      /* 375 */
      e.printStackTrace();
      /*     */
    }
    finally
    {
      /*     */
      try
      {
        /* 378 */
        if (con != null)
        {
          /* 379 */
          con.close();
          /*     */
        }
        /* 381 */
        if (ps != null)
        {
          /* 382 */
          ps.close();
          /*     */
        }
        /* 384 */
        if (rs != null)
        {
          /* 385 */
          rs.close();
          /*     */
        }
        /* 387 */
      }
      catch (SQLException se)
      {
        /* 388 */
        se.printStackTrace();
        /*     */
      }
      /*     */
    }
    /*     */
  }
  
  /*     */
  /*     */
  public static void saveItems()
  {
    /* 394 */
    Connection con = null;
    /* 395 */
    PreparedStatement ps = null;
    /* 396 */
    ResultSet rs = null;
    /*     */
    try
    {
      /* 398 */
      con = DatabaseConnection.getConnection();
      /*     */
      /* 400 */
      System.out.println("Saving Auctions...");
      /* 401 */
      con.setTransactionIsolation(1);
      /* 402 */
      con.setAutoCommit(false);
      /*     */
      /* 404 */
      ps = con.prepareStatement("DELETE FROM auctionitems");
      /* 405 */
      ps.executeUpdate();
      /* 406 */
      ps.close();
      /*     */
      /* 408 */
      ps = con.prepareStatement("DELETE FROM auctionhistories");
      /* 409 */
      ps.executeUpdate();
      /* 410 */
      ps.close();
      /*     */
      /* 412 */
      List<Item> itemz = new ArrayList<>();
      /* 413 */
      for (AuctionItem item : items.values())
      {
        /* 414 */
        itemz.add(item.getItem());
        /*     */
      }
      /*     */
      /* 417 */
      addInventoryItem(con, itemz);
      /*     */
      /* 419 */
      con.commit();
      /*     */
      /* 421 */
      for (AuctionItem item : items.values())
      {
        /* 422 */
        addNewItem(item);
        /*     */
      }
      /*     */
    }
    /* 425 */
    catch (SQLException e)
    {
      /* 426 */
      e.printStackTrace();
      /*     */
      try
      {
        /* 428 */
        con.rollback();
        /* 429 */
      }
      catch (Exception ex)
      {
        /* 430 */
        ex.printStackTrace();
        /*     */
      }
      /*     */
    }
    finally
    {
      /*     */
      try
      {
        /* 434 */
        if (con != null)
        {
          /* 435 */
          con.setTransactionIsolation(4);
          /* 436 */
          con.setAutoCommit(true);
          /* 437 */
          con.close();
          /*     */
        }
        /* 439 */
        if (ps != null)
        {
          /* 440 */
          ps.close();
          /*     */
        }
        /* 442 */
        if (rs != null)
        {
          /* 443 */
          rs.close();
          /*     */
        }
        /* 445 */
      }
      catch (SQLException e)
      {
        /* 446 */
        FileoutputUtil.outputFileError("Log_Packet_Except.rtf", e);
        /* 447 */
        e.printStackTrace();
        /*     */
      }
      /*     */
    }
    /*     */
  }
  
  /*     */
  /*     */
  public static void loadItems()
  {
    /* 453 */
    int count = 0;
    /* 454 */
    System.out.println("경매장 아이템 데이터를 로딩합니다.");
    /* 455 */
    Connection con = null;
    /* 456 */
    PreparedStatement ps = null, ps1 = null, ps2 = null;
    /* 457 */
    ResultSet rs = null, rs1 = null, rs2 = null;
    /*     */
    /* 459 */
    String[] columns = {"inventoryitems", "inventoryitemsuse", "inventoryitemssetup", "inventoryitemsetc", "inventoryitemscash", "inventoryitemscody"};
    /*     */
    /*     */
    try
    {
      /* 462 */
      con = DatabaseConnection.getConnection();
      /*     */
      /* 464 */
      ps = con.prepareStatement("SELECT * FROM `auctionitems` WHERE `state` < 7");
      /* 465 */
      rs = ps.executeQuery();
      /*     */
      /* 467 */
      while (rs.next())
      {
        /* 468 */
        AuctionItem aItem = new AuctionItem();
        /* 469 */
        aItem.setAuctionId(rs.getInt("auctionitemid"));
        /* 470 */
        aItem.setAuctionType(rs.getInt("auctiontype"));
        /* 471 */
        aItem.setAccountId(rs.getInt("accountid"));
        /* 472 */
        aItem.setCharacterId(rs.getInt("characterid"));
        /* 473 */
        aItem.setState(rs.getInt("state"));
        /* 474 */
        aItem.setWorldId(rs.getInt("worldid"));
        /* 475 */
        aItem.setBidUserId(rs.getInt("biduserid"));
        /* 476 */
        aItem.setNexonOid(rs.getInt("nexonoid"));
        /* 477 */
        aItem.setDeposit(rs.getInt("deposit"));
        /* 478 */
        aItem.setsStype(rs.getInt("sstype"));
        /* 479 */
        aItem.setBidWorld(rs.getInt("bidworld"));
        /* 480 */
        aItem.setPrice(rs.getLong("price"));
        /* 481 */
        aItem.setSecondPrice(rs.getLong("secondprice"));
        /* 482 */
        aItem.setDirectPrice(rs.getLong("directprice"));
        /* 483 */
        aItem.setEndDate(rs.getLong("enddate"));
        /* 484 */
        aItem.setRegisterDate(rs.getLong("registerdate"));
        /* 485 */
        aItem.setName(rs.getString("name"));
        /* 486 */
        aItem.setBidUserName(rs.getString("bidusername"));
        /*     */
        /* 488 */
        long inventoryItemId = rs.getLong("inventoryitemid");
        /*     */
        /* 490 */
        for (String column : columns)
        {
          /* 491 */
          StringBuilder query = new StringBuilder();
          /* 492 */
          query.append("SELECT * FROM `");
          /* 493 */
          query.append(column);
          /* 494 */
          query.append("` LEFT JOIN `");
          /* 495 */
          if (column.equals("inventoryitemscody"))
          {
            /* 496 */
            query.append("inventoryequipmentcody");
            /*     */
          }
          else
          {
            /* 498 */
            query.append("inventoryequipment");
            /*     */
          }
          /* 500 */
          query.append("` USING (`inventoryitemid`) WHERE `type` = 7 AND `inventoryitemid` = ?");
          /* 501 */
          ps1 = con.prepareStatement(query.toString());
          /* 502 */
          ps1.setLong(1, inventoryItemId);
          /*     */
          /* 504 */
          rs1 = ps1.executeQuery();
          /* 505 */
          if (rs1.next())
          {
            /* 506 */
            MapleItemInformationProvider ii = MapleItemInformationProvider.getInstance();
            /* 507 */
            Item item_ = null;
            /*     */
            /* 509 */
            if (!ii.itemExists(rs1.getInt("itemid")))
            {
              /*     */
              continue;
              /*     */
            }
            /* 512 */
            if (rs1.getInt("itemid") / 1000000 == 1)
            {
              EquipTemplate template = MapleItemInformationProvider.getInstance().getTempateByItemId(rs1.getInt("itemid"));
              /* 513 */
              Equip equip = new Equip(template, rs1.getShort("position"), rs1.getInt("uniqueid"), rs1.getInt("flag"));
              /* 514 */
              equip.setQuantity((short) 1);
              
              byte enchantLevel = rs1.getByte("enchantLevel");
              
              byte totalUpgradeSlots = rs1.getByte("upgradeslots");
              
              byte hammerCount =  rs1.getByte("ViciousHammer");
              
              equip.setSuccessUpgradeSlots(enchantLevel);
              
              equip.setExtraUpgradeSlots(hammerCount);
              
              equip.setFailUpgradeSlots((byte)(template.getUpgradeSlots() + hammerCount - enchantLevel - totalUpgradeSlots));

              /* 515 */
              equip.setInventoryId(rs1.getLong("inventoryitemid"));
              /* 516 */
              equip.setOwner(rs1.getString("owner"));
              /* 517 */
              equip.setExpiration(rs1.getLong("expiredate"));
              /* 518 */
              /* 519 */
              equip.setEnchantLevel(enchantLevel);
              /* 520 */
              equip.setEnchantStr(rs1.getShort("str"));
              /* 521 */
              equip.setEnchantDex(rs1.getShort("dex"));
              /* 522 */
              equip.setEnchantInt(rs1.getShort("int"));
              /* 523 */
              equip.setEnchantLuk(rs1.getShort("luk"));
              /* 524 */
              equip.setEnchantHp(rs1.getShort("hp"));
              /* 525 */
              equip.setEnchantMp(rs1.getShort("mp"));
              /* 526 */
              equip.setEnchantWatk(rs1.getShort("watk"));
              /* 527 */
              equip.setEnchantMatk(rs1.getShort("matk"));
              /* 528 */
              equip.setEnchantWdef(rs1.getShort("wdef"));
              /* 529 */
              equip.setEnchantMdef(rs1.getShort("mdef"));
              /* 530 */
              equip.setEnchantAccuracy(rs1.getShort("acc"));
              /* 531 */
              equip.setEnchantAvoid(rs1.getShort("avoid"));
              /* 532 */
              equip.setEnchantCraft(rs1.getShort("craft"));
              /* 533 */
              equip.setEnchantMovementSpeed(rs1.getShort("movementSpeed"));
              /* 534 */
              equip.setEnchantJump(rs1.getShort("jump"));
              /* 535 */
              equip.setViciousHammer(hammerCount);
              /* 536 */
              equip.setItemEXP(rs1.getInt("itemEXP"));
              /* 537 */
              equip.setGMLog(rs1.getString("GM_Log"));
              /* 538 */
              equip.setDurability(rs1.getInt("durability"));
              /* 539 */
              equip.setStarForceLevel(rs1.getByte("starForceLevel"));
              /* 540 */
              equip.設置潛能等級(rs1.getByte("state"));
              /* 541 */
              equip.設置未鑑定潛能條數(rs1.getByte("potentialLine"));

              equip.設置未鑑定潛能條數(rs1.getByte("additionalPotentialLine"));
              /* 542 */
              equip.設置第一條主潛能(rs1.getInt("potential1"));
              /* 543 */
              equip.設置第二條主潛能(rs1.getInt("potential2"));
              /* 544 */
              equip.設置第三條主潛能(rs1.getInt("potential3"));
              /* 545 */
              equip.設置第一條附加潛能(rs1.getInt("potential4"));
              /* 546 */
              equip.設置第二條附加潛能(rs1.getInt("potential5"));
              /* 547 */
              equip.設置第三條附加潛能(rs1.getInt("potential6"));
              /* 548 */
              equip.setGiftFrom(rs1.getString("sender"));
              /* 549 */
              equip.setIncSkill(rs1.getInt("incSkill"));
              /* 551 */
              equip.setCharmEXP(rs1.getShort("charmEXP"));
              /* 552 */
              if (equip.getCharmEXP() < 0)
              {
                /* 553 */
                equip.setCharmEXP(template.getCharmEXP());
                /*     */
              }
              /* 555 */
              if (equip.getUniqueId() > -1L)
              {
                /* 556 */
                if (GameConstants.isEffectRing(rs1.getInt("itemid")))
                {
                  /* 557 */
                  MapleRing ring = MapleRing.loadFromDb(equip.getUniqueId(), false);
                  /* 558 */
                  if (ring != null)
                  {
                    /* 559 */
                    equip.setRing(ring);
                    /*     */
                  }
                  /* 561 */
                }
                else if (equip.getItemId() / 10000 == 166)
                {
                  /* 562 */
                  MapleAndroid ring = MapleAndroid.loadFromDb(equip.getItemId(), equip.getUniqueId());
                  /* 563 */
                  if (ring != null)
                  {
                    /* 564 */
                    equip.setAndroid(ring);
                    /*     */
                  }
                  /*     */
                }
                /*     */
              }
              
              equip.calcStarForceStats();
              /* 568 */
              equip.setEnchantBuff(rs1.getShort("enchantbuff"));
              /* 570 */
              equip.setYggdrasilWisdom(rs1.getByte("yggdrasilWisdom"));
              /* 571 */
              equip.setFinalStrike((rs1.getByte("finalStrike") > 0));
              /* 572 */
              equip.setEnchantBossDamage(rs1.getByte("bossDamage"));
              /* 573 */
              equip.setEnchantIgnorePDR(rs1.getByte("ignorePDR"));
              /* 574 */
              equip.setEnchantDamage(rs1.getByte("totalDamage"));
              /* 575 */
              equip.setEnchantAllStat(rs1.getByte("allStat"));
              /* 576 */
              equip.setKarmaCount(rs1.getByte("karmaCount"));
              /* 577 */
              equip.setSoulEnchanter(rs1.getShort("soulenchanter"));
              /* 578 */
              equip.setSoulName(rs1.getShort("soulname"));
              /* 579 */
              equip.setSoulPotential(rs1.getShort("soulpotential"));
              /* 580 */
              equip.setSoulSkill(rs1.getInt("soulskill"));
              /* 581 */
              equip.setFlame((rs1.getLong("fire") < 0L) ? 0L : rs1.getLong("fire"));
              /* 582 */
              equip.setArcPower(rs1.getInt("arc"));
              /* 583 */
              equip.setArcExp(rs1.getInt("arcexp"));
              /* 584 */
              equip.setArcLevel(rs1.getInt("arclevel"));
              /* 585 */
              equip.setEquipmentType(rs1.getInt("equipmenttype"));
              /* 586 */
              equip.setMoru(rs1.getInt("moru"));
              /* 587 */
              /* 588 */
              equip.setOptionExpiration(rs1.getLong("optionexpiration"));
              /* 589 */
              equip.setCoption1(rs1.getInt("coption1"));
              /* 590 */
              equip.setCoption2(rs1.getInt("coption2"));
              /* 591 */
              equip.setCoption3(rs1.getInt("coption3"));
              /*     */
              /* 593 */
              /* 614 */
              item_ = equip.copy();
              /*     */
            }
            else
            {
              /* 616 */
              Item item = new Item(rs1.getInt("itemid"), rs1.getShort("position"), rs1.getShort("quantity"), rs1.getInt("flag"), rs1.getInt("uniqueid"));
              /* 617 */
              item.setOwner(rs1.getString("owner"));
              /* 618 */
              item.setInventoryId(rs1.getLong("inventoryitemid"));
              /* 619 */
              item.setExpiration(rs1.getLong("expiredate"));
              /* 620 */
              item.setGMLog(rs1.getString("GM_Log"));
              /* 621 */
              item.setGiftFrom(rs1.getString("sender"));
              /* 622 */
              item.setMarriageId(rs1.getInt("marriageId"));
              /* 623 */
              if (GameConstants.isPet(item.getItemId()))
              {
                /* 624 */
                if (item.getUniqueId() > -1L)
                {
                  /* 625 */
                  MaplePet pet = MaplePet.loadFromDb(item.getItemId(), item.getUniqueId(), item.getPosition());
                  /* 626 */
                  if (pet != null)
                  {
                    /* 627 */
                    item.setPet(pet);
                    /*     */
                  }
                  /*     */
                }
                else
                {
                  /*     */
                  /* 631 */
                  item.setPet(MaplePet.createPet(item.getItemId(), MapleInventoryIdentifier.getInstance()));
                  /*     */
                }
                /*     */
              }
              /* 634 */
              if (item.getItemId() == 4001886)
              {
                /* 635 */
                item.setReward(new BossReward(rs1.getInt("objectid"), rs1.getInt("mobid"), rs1.getInt("partyid"), rs1.getInt("price")));
                /*     */
              }
              /* 637 */
              item_ = item.copy();
              /*     */
            }
            /*     */
            /* 640 */
            if (item_ != null)
            {
              /* 641 */
              aItem.setItem(item_);
              /*     */
              /* 643 */
              ps2 = con.prepareStatement("SELECT * FROM `auctionhistories` WHERE `auctionid` = ?");
              /* 644 */
              ps2.setInt(1, aItem.getAuctionId());
              /*     */
              /* 646 */
              rs2 = ps2.executeQuery();
              /* 647 */
              if (rs2.next())
              {
                /* 648 */
                AuctionHistory history = new AuctionHistory();
                /* 649 */
                history.setId(rs2.getLong("id"));
                /* 650 */
                history.setAuctionId(rs2.getInt("auctionid"));
                /* 651 */
                history.setAccountId(rs2.getInt("accountid"));
                /* 652 */
                history.setCharacterId(rs2.getInt("characterid"));
                /* 653 */
                history.setItemId(rs2.getInt("itemid"));
                /* 654 */
                history.setState(rs2.getInt("state"));
                /* 655 */
                history.setPrice(rs2.getLong("price"));
                /* 656 */
                history.setBuyTime(rs2.getLong("buytime"));
                /* 657 */
                history.setDeposit(rs2.getInt("deposit"));
                /* 658 */
                history.setQuantity(rs2.getInt("quantity"));
                /* 659 */
                history.setWorldId(rs2.getInt("worldid"));
                /* 660 */
                history.setBidUserId(rs2.getInt("biduserid"));
                /* 661 */
                history.setBidUserName(rs2.getString("bidusername"));
                /*     */
                /* 663 */
                aItem.setHistory(history);
                /* 664 */
                rs2.close();
                /* 665 */
                ps2.close();
                /*     */
              }
              /*     */
              /* 668 */
              items.put(Integer.valueOf(aItem.getAuctionId()), aItem);
              /* 669 */
              count++;
              /*     */
            }
            /*     */
          }
          /*     */
          /* 673 */
          rs1.close();
          /* 674 */
          ps1.close();
          continue;
          /*     */
        }
        /*     */
      }
      /* 677 */
      ps.close();
      /* 678 */
      rs.close();
      /*     */
    }
    /* 680 */
    catch (SQLException sqlE)
    {
      /* 681 */
      sqlE.printStackTrace();
      /*     */
    }
    finally
    {
      /* 683 */
      if (con != null)
      {
        /*     */
        try
        {
          /* 685 */
          con.close();
          /* 686 */
        }
        catch (SQLException e)
        {
          /*     */
          /* 688 */
          e.printStackTrace();
          /*     */
        }
        /*     */
      }
      /* 691 */
      if (ps != null)
      {
        /*     */
        try
        {
          /* 693 */
          ps.close();
          /* 694 */
        }
        catch (SQLException e)
        {
          /*     */
          /* 696 */
          e.printStackTrace();
          /*     */
        }
        /*     */
      }
      /* 699 */
      if (ps1 != null)
      {
        /*     */
        try
        {
          /* 701 */
          ps1.close();
          /* 702 */
        }
        catch (SQLException e)
        {
          /*     */
          /* 704 */
          e.printStackTrace();
          /*     */
        }
        /*     */
      }
      /* 707 */
      if (ps2 != null)
      {
        /*     */
        try
        {
          /* 709 */
          ps2.close();
          /* 710 */
        }
        catch (SQLException e)
        {
          /*     */
          /* 712 */
          e.printStackTrace();
          /*     */
        }
        /*     */
      }
      /* 715 */
      if (rs != null)
      {
        /*     */
        try
        {
          /* 717 */
          rs.close();
          /* 718 */
        }
        catch (SQLException e)
        {
          /*     */
          /* 720 */
          e.printStackTrace();
          /*     */
        }
        /*     */
      }
      /* 723 */
      if (rs1 != null)
      {
        /*     */
        try
        {
          /* 725 */
          rs1.close();
          /* 726 */
        }
        catch (SQLException e)
        {
          /*     */
          /* 728 */
          e.printStackTrace();
          /*     */
        }
        /*     */
      }
      /* 731 */
      if (rs2 != null)
      {
        /*     */
        try
        {
          /* 733 */
          rs2.close();
          /* 734 */
        }
        catch (SQLException e)
        {
          /*     */
          /* 736 */
          e.printStackTrace();
          /*     */
        }
        /*     */
      }
      /*     */
    }
    /*     */
    /* 741 */
    System.out.println("경매장 아이템 " + count + "개가 로딩되었습니다.");
    /*     */
  }
  
  /*     */
  /*     */
  public static Map<Integer, AuctionItem> getItems()
  {
    /* 745 */
    return items;
    /*     */
  }
  /*     */
}


/* Location:              C:\Users\Phellos\Desktop\크루엘라\Ozoh디컴.jar!\handling\auction\AuctionServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
