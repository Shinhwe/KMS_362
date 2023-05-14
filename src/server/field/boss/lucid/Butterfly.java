package server.field.boss.lucid;

import provider.MapleData;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Butterfly
{
  private static List<Point> BUTTERFLY_POS1;
  
  private static List<Point> BUTTERFLY_POS2;
  
  public final int type;
  
  public final Point pos;
  
  public Butterfly(int type, boolean isFirstPhase, int index)
  {
    this(type, getPosition(isFirstPhase, index));
  }
  
  public Butterfly(int type, Point pos)
  {
    this.type = type;
    this.pos = pos;
  }
  
  public static void load()
  {
    BUTTERFLY_POS1 = new ArrayList<>();
    BUTTERFLY_POS2 = new ArrayList<>();
    try
    {
      MapleData butterflyData = MapleDataProviderFactory.getDataProvider(new File(System.getProperty("wz") + "/Etc.wz")).getData("BossLucid.img").getChildByPath("Butterfly");
      for (MapleData d : butterflyData.getChildByPath("phase1_pos"))
      {
        BUTTERFLY_POS1.add(MapleDataTool.getPoint("pos", d));
      }
      for (MapleData d : butterflyData.getChildByPath("phase2_pos"))
      {
        BUTTERFLY_POS2.add(MapleDataTool.getPoint("pos", d));
      }
    }
    catch (NullPointerException e)
    {
      System.err.println("[Butterfly] " + System.getProperty("wz") + "/Etc.wz/BossLucid.img/Butterfly is not found.");
    }
  }
  
  public static Point getPosition(boolean isFirstPhase, int index)
  {
    if (isFirstPhase && index < BUTTERFLY_POS1.size())
    {
      return BUTTERFLY_POS1.get(index);
    }
    if (index < BUTTERFLY_POS2.size())
    {
      return BUTTERFLY_POS2.get(index);
    }
    return new Point(0, 0);
  }
  
  public enum Mode
  {
    ADD(0),
    MOVE(1),
    ATTACK(2),
    ERASE(3);
    
    public final int code;
    
    Mode(int code)
    {
      this.code = code;
    }
  }
}
