package server.life;

import database.DatabaseConnection;
import tools.packet.BossRewardMeso;
import tools.packet.BossRewardMesoItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapleMonsterDropDataProvider
{
  private static final MapleMonsterDropDataProvider instance = new MapleMonsterDropDataProvider();

  private final Map<Integer, ArrayList<MonsterDropEntry>> drops = new HashMap<>();

  private final ArrayList<MonsterDropEntry> globalDrops = new ArrayList<>();

  public static MapleMonsterDropDataProvider getInstance ()
  {
    return instance;
  }

  public void loadAllData ()
  {
    globalDrops.clear();
    drops.clear();
    globalDrops.add(new MonsterDropEntry(0, 500000, 0, 0, 0));
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = null;
    Integer monsterId;
    try
    {
      con = DatabaseConnection.getConnection();
      ps = con.prepareStatement("SELECT * FROM drop_data WHERE chance > 0 ORDER BY monsterId ASC");
      rs = ps.executeQuery();
      while (rs.next())
      {
        monsterId = Integer.valueOf(rs.getInt("monsterId"));
        if (drops.containsKey(monsterId) == false)
        {
          drops.put(monsterId, new ArrayList<>());
        }
        drops.get(monsterId).add(new MonsterDropEntry(rs.getInt("itemid"), rs.getInt("chance"), rs.getInt("minimum_quantity"), rs.getInt("maximum_quantity"), rs.getInt("questid"), rs.getInt("private")));
      }
      ps.close();
      rs.close();
      ps = con.prepareStatement("SELECT * FROM drop_data_global WHERE chance > 0");
      rs = ps.executeQuery();
      while (rs.next())
      {
        globalDrops.add(new MonsterDropEntry(rs.getInt("itemid"), rs.getInt("chance"), rs.getInt("minimum_quantity"), rs.getInt("maximum_quantity"), rs.getInt("questid"), rs.getInt("private"), rs.getInt("minLevel"), rs.getInt("maxLevel")));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        if (ps != null)
        {
          ps.close();
        }
        if (rs != null)
        {
          rs.close();
        }
        if (con != null)
        {
          con.close();
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }

    this.加載強烈的魔力結晶掉落數據();

    this.加載奧術河全局掉落數據();
  }

  public void 加載奧術河全局掉落數據 ()
  {
    this.加載消逝的旅途全局掉落數據();
    this.加載反轉城市全局掉落數據();
    this.加載啾啾艾爾蘭全局掉落數據();
    this.加載嚼嚼艾爾蘭全局掉落數據();
    this.加載拉契爾恩全局掉落數據();
    this.加載阿爾卡娜全局掉落數據();
    this.加載魔菈斯全局掉落數據();
    this.加載艾斯佩拉全局掉落數據();
    this.加載賽拉斯全局掉落數據();
    this.加載月之橋全局掉落數據();
    this.加載苦痛迷宮全局掉落數據();
    this.加載利曼全局掉落數據();
  }


  public void 加載消逝的旅途全局掉落數據 ()
  {
    int[] monsterList = new int[] {
        8641000, 8641001, 8641002, 8641003, 8641013, 8641004, 8641005, 8641006, 8641014, 8641007, 8641008, 8641009, 8641015,
        };

    for (int monsterId : monsterList)
    {
      if (drops.containsKey(monsterId) == false)
      {
        drops.put(monsterId, new ArrayList<>());
      }
      drops.get(monsterId).add(new MonsterDropEntry(2435719, 20000, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(1712001, 4300, 1, 1, 0, 0));
    }
  }

  public void 加載反轉城市全局掉落數據 ()
  {
    int[] monsterList = new int[] {
        8641051, 8641052, 8641053, 8641054, 8641066, 8641067, 8641055, 8641056, 8641068, 8641069, 8641070, 8641071, 8641057, 8641058
    };

    for (int monsterId : monsterList)
    {
      if (drops.containsKey(monsterId) == false)
      {
        drops.put(monsterId, new ArrayList<>());
      }
      drops.get(monsterId).add(new MonsterDropEntry(2435719, 20000, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(1712001, 6400, 1, 1, 0, 0));
    }
  }

  public void 加載啾啾艾爾蘭全局掉落數據 ()
  {
    int[] monsterList = new int[] {
        8642000, 8642001, 8642002, 8642003, 8642004, 8642005, 8642006, 8642007, 8642008, 8642009, 8642010, 8642011, 8642012, 8642013, 8642014, 8642015,
        };

    for (int monsterId : monsterList)
    {
      if (drops.containsKey(monsterId) == false)
      {
        drops.put(monsterId, new ArrayList<>());
      }
      drops.get(monsterId).add(new MonsterDropEntry(2435719, 20000, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(1712002, 4300, 1, 1, 0, 0));
    }
  }

  public void 加載嚼嚼艾爾蘭全局掉落數據 ()
  {
    int[] monsterList = new int[] {
        8642050, 8642051, 8642052, 8642053, 8642054, 8642055, 8642060, 8642061, 8642062, 8642063, 8642064, 8642065,
        };

    for (int monsterId : monsterList)
    {
      if (drops.containsKey(monsterId) == false)
      {
        drops.put(monsterId, new ArrayList<>());
      }
      drops.get(monsterId).add(new MonsterDropEntry(2435719, 20000, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(1712002, 6400, 1, 1, 0, 0));
    }
  }

  public void 加載拉契爾恩全局掉落數據 ()
  {
    int[] monsterList = new int[] {
        8643000, 8643001, 8643002, 8643003, 8643004, 8643005, 8643006, 8643007, 8643008, 8643009, 8643010, 8643011, 8643012
    };

    for (int monsterId : monsterList)
    {
      if (drops.containsKey(monsterId) == false)
      {
        drops.put(monsterId, new ArrayList<>());
      }

      drops.get(monsterId).add(new MonsterDropEntry(4001878, 200, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(2435719, 40000, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(1712003, 4300, 1, 1, 0, 0));
    }
  }

  public void 加載阿爾卡娜全局掉落數據 ()
  {
    int[] monsterList = new int[] {
        8644000, 8644001, 8644002, 8644003, 8644004, 8644005, 8644006, 8644007, 8644008, 8644009, 8644010,
        };

    for (int monsterId : monsterList)
    {
      if (drops.containsKey(monsterId) == false)
      {
        drops.put(monsterId, new ArrayList<>());
      }
      drops.get(monsterId).add(new MonsterDropEntry(4001878, 200, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(2435719, 50000, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(1712004, 4300, 1, 1, 0, 0));
    }
  }

  public void 加載魔菈斯全局掉落數據 ()
  {
    int[] monsterList = new int[] {
        8644400, 8644401, 8644402, 8644403, 8644404, 8644405, 8644406, 8644407, 8644408, 8644409, 8644410, 8644411, 8644412,
        };

    for (int monsterId : monsterList)
    {
      if (drops.containsKey(monsterId) == false)
      {
        drops.put(monsterId, new ArrayList<>());
      }
      drops.get(monsterId).add(new MonsterDropEntry(4001878, 200, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(2435719, 20000, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(1712005, 6400, 1, 1, 0, 0));
    }
  }

  public void 加載艾斯佩拉全局掉落數據 ()
  {
    int[] monsterList = new int[] {
        8644500, 8644501, 8644502, 8644503, 8644504, 8644505, 8644506, 8644507, 8644508, 8644509,
        };

    for (int monsterId : monsterList)
    {
      if (drops.containsKey(monsterId) == false)
      {
        drops.put(monsterId, new ArrayList<>());
      }
      drops.get(monsterId).add(new MonsterDropEntry(4001889, 200, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(2435719, 20000, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(1712006, 4300, 1, 1, 0, 0));
    }
  }

  public void 加載賽拉斯全局掉落數據 ()
  {
    int[] monsterList = new int[] {
        8642100, 8642101, 8642102, 8642103, 8642104, 8642105, 8642106
    };

    for (int monsterId : monsterList)
    {
      if (drops.containsKey(monsterId) == false)
      {
        drops.put(monsterId, new ArrayList<>());
      }
      drops.get(monsterId).add(new MonsterDropEntry(4001889, 200, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(2435719, 20000, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(1712006, 6400, 1, 1, 0, 0));
    }
  }


  public void 加載月之橋全局掉落數據 ()
  {
    int[] monsterList = new int[] {
        8644614, 8644615, 8644616, 8644617, 8644618, 8644619
    };

    for (int monsterId : monsterList)
    {
      if (drops.containsKey(monsterId) == false)
      {
        drops.put(monsterId, new ArrayList<>());
      }
      drops.get(monsterId).add(new MonsterDropEntry(4001889, 200, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(4001889, 200, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(2435719, 20000, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(2437750, 4300, 1, 1, 0, 0));
    }
  }

  public void 加載苦痛迷宮全局掉落數據 ()
  {
    int[] monsterList = new int[] {
        8644700, 8644701, 8644702, 8644703, 8644704, 8644705, 8644706, 8644707, 8644708, 8644709, 8644710, 8644711, 8644712, 8644719,
        };

    for (int monsterId : monsterList)
    {
      if (drops.containsKey(monsterId) == false)
      {
        drops.put(monsterId, new ArrayList<>());
      }
      drops.get(monsterId).add(new MonsterDropEntry(4001889, 200, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(4001889, 200, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(2435719, 20000, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(2437880, 4300, 1, 1, 0, 0));
    }
  }

  public void 加載利曼全局掉落數據 ()
  {
    int[] monsterList = new int[] {
        8645010,
        8645011,
        8645012,
        8645022,
        8645023,
    };

    for (int monsterId : monsterList)
    {
      if (drops.containsKey(monsterId) == false)
      {
        drops.put(monsterId, new ArrayList<>());
      }
      drops.get(monsterId).add(new MonsterDropEntry(4001889, 200, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(4001889, 200, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(2435719, 20000, 1, 1, 0, 0));
      drops.get(monsterId).add(new MonsterDropEntry(2437760, 4300, 1, 1, 0, 0));
    }
  }


  public void 加載強烈的魔力結晶掉落數據 ()
  {
    ArrayList<BossRewardMesoItem> bossRewardMesoList = BossRewardMeso.getBossRewardMesoList();

    for (BossRewardMesoItem item : bossRewardMesoList)
    {
      int bossId = item.bossId;

      if (drops.containsKey(bossId) == false)
      {
        drops.put(bossId, new ArrayList<>());
      }
      drops.get(bossId).add(new MonsterDropEntry(4001886, 1000000, 1, 1, 0, 1));
    }
  }

  public List<MonsterDropEntry> getAllDropListByMonster (MapleMonster monster)
  {
    ArrayList<MonsterDropEntry> dropList = new ArrayList<>();

    dropList.addAll(globalDrops.stream().filter(item -> monster.getStats().getLevel() >= item.minLevel && monster.getStats().getLevel() <= item.maxLevel).toList());

    if (this.drops.containsKey(Integer.valueOf(monster.getId())))
    {
      dropList.addAll(this.drops.get(Integer.valueOf(monster.getId())));
    }

    return dropList;
  }


  public List<MonsterDropEntry> getPublicDropListByMonster (MapleMonster monster)
  {
    ArrayList<MonsterDropEntry> dropList = new ArrayList<>();


    if (this.drops.containsKey(Integer.valueOf(monster.getId())))
    {
      dropList.addAll(this.drops.get(Integer.valueOf(monster.getId())).stream().filter(item -> item.privated != 1).toList());
    }


    if (monster.getStats().isBoss() == false && monster.isEliteBoss() == false && monster.isEliteMonster() == false)
    {
      // 精英怪内容对掉落有单独设置, 不参与全局掉落
      // BOSS怪不参与全局掉落
      dropList.addAll(globalDrops.stream().filter(item -> monster.getStats().getLevel() >= item.minLevel && monster.getStats().getLevel() <= item.maxLevel && item.privated != 1).toList());
    }

    return dropList;
  }

  public List<MonsterDropEntry> getPrivateDropListByMonster (MapleMonster monster)
  {
    ArrayList<MonsterDropEntry> dropList = new ArrayList<>();

    if (this.drops.containsKey(Integer.valueOf(monster.getId())))
    {
      dropList.addAll(this.drops.get(Integer.valueOf(monster.getId())).stream().filter(item -> item.privated == 1).toList());
    }

    if (monster.isEliteBoss() == false && monster.isEliteMonster() == false)
    {
      // 精英怪内容对掉落有单独设置, 不参与全局掉落
      dropList.addAll(globalDrops.stream().filter(item -> monster.getStats().getLevel() >= item.minLevel && monster.getStats().getLevel() <= item.maxLevel && item.privated == 1).toList());
    }

    return dropList;
  }
}
