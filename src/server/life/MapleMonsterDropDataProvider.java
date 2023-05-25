package server.life;

import database.DatabaseConnection;

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
      ps = con.prepareStatement("SELECT * FROM drop_data WHERE chance > 0");
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
  }

  public List<MonsterDropEntry> getDropListByMonster (MapleMonster monster)
  {
    ArrayList<MonsterDropEntry> dropList = new ArrayList<>();

    dropList.addAll(globalDrops.stream().filter(item -> monster.getStats().getLevel() >= item.minLevel && monster.getStats().getLevel() <= item.maxLevel).toList());

    if (this.drops.containsKey(Integer.valueOf(monster.getId())))
    {
      dropList.addAll(this.drops.get(Integer.valueOf(monster.getId())));
    }

    return dropList;
  }
}