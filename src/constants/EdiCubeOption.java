package constants;

import server.Randomizer;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class EdiCubeOption
{
  public static int getEdiCubePotentialId(int itemid, int grade, int num, int... args)
  {
    Map<Integer, Integer> list = new LinkedHashMap<>();
    int potentialid = 0;
    int type = itemid / 1000;
    if (GameConstants.isWeapon(itemid))
    {
      type = 1300;
    }
    else if (GameConstants.isHat(itemid))
    {
      type = 1301;
    }
    else if (GameConstants.isShield(itemid) && type != 1099)
    {
      type = 1302;
    }
    else if (GameConstants.isSecondaryWeapon(itemid) && type != 1352)
    {
      type = 1303;
    }
    else if (GameConstants.isCape(itemid) || GameConstants.isOverall(itemid) || type == 1132 || type == 1152 || (type >= 1070 && type <= 1073) || (type >= 1040 && type <= 1042) || (type >= 1061 && type <= 1063))
    {
      type = 1304;
    }
    else if (type == 1190 || type == 1191)
    {
      type = 1305;
    }
    else if (type >= 1080 && type <= 1082)
    {
      type = 1306;
    }
    else if (type == 1099 || type == 1352)
    {
      type = 1307;
    }
    else if (type == 1672)
    {
      type = 1308;
    }
    else
    {
      type = 1309;
    }
    if (grade == 1)
    {//레전드리
      list = getRareOption(type, num);
    }
    else if (grade == 2)
    {
      list = getEpicOption(type, num);
    }
    else if (grade == 3)
    {
      list = getUniqueOption(type, num);
    }
    else if (grade == 4)
    {
      list = getLegendaryOption(type, num);
    }
    if (!list.isEmpty())
    {
      while (potentialid == 0)
      {
        int potentialidt = getWeightedRandom(list);
        if (potentialidt != 0)
        {
          potentialid = potentialidt;
          if (num == 3 &&
              !GameConstants.getPotentialCheck(potentialid, args[0], args[1]))
          {
            potentialid = 0;
            continue;
          }
          break;
        }
      }
    }
    else
    {
      potentialid = 1;
    }
    for (Map.Entry<Integer, Integer> l : list.entrySet())
    {
      if (l.getKey().intValue() == potentialid)
      {
        double a = l.getValue().intValue();
        double r = a / 10000.0D;
        DecimalFormat form = new DecimalFormat("#.#####");
        break;
      }
    }
    return potentialid;
  }
  
  public static int getUnlimitedEdiCubePotentialId(int itemid, int grade, int num, int... args)
  {
    Map<Integer, Integer> list = new LinkedHashMap<>();
    int potentialid = 0;
    int type = itemid / 1000;
    if (GameConstants.isWeapon(itemid))
    {
      type = 1300;
    }
    else if (GameConstants.isHat(itemid))
    {
      type = 1301;
    }
    else if (GameConstants.isShield(itemid) && type != 1099)
    {
      type = 1302;
    }
    else if (GameConstants.isSecondaryWeapon(itemid) && type != 1352)
    {
      type = 1303;
    }
    else if (GameConstants.isCape(itemid) || GameConstants.isOverall(itemid) || type == 1132 || type == 1152 || (type >= 1070 && type <= 1073) || (type >= 1040 && type <= 1042) || (type >= 1061 && type <= 1063))
    {
      type = 1304;
    }
    else if (type == 1190 || type == 1191)
    {
      type = 1305;
    }
    else if (type >= 1080 && type <= 1082)
    {
      type = 1306;
    }
    else if (type == 1099 || type == 1352)
    {
      type = 1307;
    }
    else if (type == 1672)
    {
      type = 1308;
    }
    else
    {
      type = 1309;
    }
    if (grade == 4)
    {
      list = getUnlimitedLegendaryOption(type, num);
    }
    else
    {
      return 1;
    }
    if (!list.isEmpty())
    {
      while (potentialid == 0)
      {
        int potentialidt = getWeightedRandom(list);
        if (potentialidt != 0)
        {
          potentialid = potentialidt;
          if (num == 3 &&
              !GameConstants.getPotentialCheck(potentialid, args[0], args[1]))
          {
            potentialid = 0;
            continue;
          }
          break;
        }
      }
    }
    else
    {
      potentialid = 1;
    }
    for (Map.Entry<Integer, Integer> l : list.entrySet())
    {
      if (l.getKey().intValue() == potentialid)
      {
        double a = l.getValue().intValue();
        double r = a / 10000.0D;
        DecimalFormat form = new DecimalFormat("#.#####");
        break;
      }
    }
    return potentialid;
  }
  
  public static Map<Integer, Integer> getRareOption(int type, int num)
  {
    Map<Integer, Integer> list = new HashMap<>();
    switch (type)
    {
      case 1300:
        if (num == 1)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(58824));
          list.put(Integer.valueOf(12006), Integer.valueOf(58824));
          list.put(Integer.valueOf(12009), Integer.valueOf(58824));
          list.put(Integer.valueOf(12010), Integer.valueOf(58824));
          list.put(Integer.valueOf(12013), Integer.valueOf(58824));
          list.put(Integer.valueOf(12015), Integer.valueOf(58824));
          list.put(Integer.valueOf(12016), Integer.valueOf(58824));
          list.put(Integer.valueOf(12017), Integer.valueOf(58824));
          list.put(Integer.valueOf(12018), Integer.valueOf(58824));
          list.put(Integer.valueOf(12019), Integer.valueOf(39216));
          list.put(Integer.valueOf(12020), Integer.valueOf(39216));
          list.put(Integer.valueOf(12045), Integer.valueOf(39216));
          list.put(Integer.valueOf(12046), Integer.valueOf(39216));
          list.put(Integer.valueOf(12047), Integer.valueOf(39216));
          list.put(Integer.valueOf(12048), Integer.valueOf(39216));
          list.put(Integer.valueOf(12049), Integer.valueOf(39216));
          list.put(Integer.valueOf(12050), Integer.valueOf(39216));
          list.put(Integer.valueOf(12051), Integer.valueOf(19608));
          list.put(Integer.valueOf(12052), Integer.valueOf(19608));
          list.put(Integer.valueOf(12055), Integer.valueOf(39216));
          list.put(Integer.valueOf(12070), Integer.valueOf(19608));
          list.put(Integer.valueOf(12052), Integer.valueOf(58824));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(12005), Integer.valueOf(1153));
          list.put(Integer.valueOf(12006), Integer.valueOf(1153));
          list.put(Integer.valueOf(12009), Integer.valueOf(1153));
          list.put(Integer.valueOf(12010), Integer.valueOf(1153));
          list.put(Integer.valueOf(12013), Integer.valueOf(1153));
          list.put(Integer.valueOf(12015), Integer.valueOf(1153));
          list.put(Integer.valueOf(12016), Integer.valueOf(1153));
          list.put(Integer.valueOf(12017), Integer.valueOf(1153));
          list.put(Integer.valueOf(12018), Integer.valueOf(1153));
          list.put(Integer.valueOf(12019), Integer.valueOf(769));
          list.put(Integer.valueOf(12020), Integer.valueOf(769));
          list.put(Integer.valueOf(12045), Integer.valueOf(769));
          list.put(Integer.valueOf(12046), Integer.valueOf(769));
          list.put(Integer.valueOf(12047), Integer.valueOf(769));
          list.put(Integer.valueOf(12048), Integer.valueOf(769));
          list.put(Integer.valueOf(12049), Integer.valueOf(769));
          list.put(Integer.valueOf(12050), Integer.valueOf(769));
          list.put(Integer.valueOf(12051), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(384));
          list.put(Integer.valueOf(12055), Integer.valueOf(769));
          list.put(Integer.valueOf(12070), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(1153));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(12005), Integer.valueOf(1153));
          list.put(Integer.valueOf(12006), Integer.valueOf(1153));
          list.put(Integer.valueOf(12009), Integer.valueOf(1153));
          list.put(Integer.valueOf(12010), Integer.valueOf(1153));
          list.put(Integer.valueOf(12013), Integer.valueOf(1153));
          list.put(Integer.valueOf(12015), Integer.valueOf(1153));
          list.put(Integer.valueOf(12016), Integer.valueOf(1153));
          list.put(Integer.valueOf(12017), Integer.valueOf(1153));
          list.put(Integer.valueOf(12018), Integer.valueOf(1153));
          list.put(Integer.valueOf(12019), Integer.valueOf(769));
          list.put(Integer.valueOf(12020), Integer.valueOf(769));
          list.put(Integer.valueOf(12045), Integer.valueOf(769));
          list.put(Integer.valueOf(12046), Integer.valueOf(769));
          list.put(Integer.valueOf(12047), Integer.valueOf(769));
          list.put(Integer.valueOf(12048), Integer.valueOf(769));
          list.put(Integer.valueOf(12049), Integer.valueOf(769));
          list.put(Integer.valueOf(12050), Integer.valueOf(769));
          list.put(Integer.valueOf(12051), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(384));
          list.put(Integer.valueOf(12055), Integer.valueOf(769));
          list.put(Integer.valueOf(12070), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(1153));
          break;
        }
      case 1301:
        if (num == 1)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(63830));
          list.put(Integer.valueOf(12002), Integer.valueOf(63830));
          list.put(Integer.valueOf(12003), Integer.valueOf(63830));
          list.put(Integer.valueOf(12004), Integer.valueOf(63830));
          list.put(Integer.valueOf(12005), Integer.valueOf(63830));
          list.put(Integer.valueOf(12006), Integer.valueOf(63830));
          list.put(Integer.valueOf(12009), Integer.valueOf(63830));
          list.put(Integer.valueOf(12010), Integer.valueOf(63830));
          list.put(Integer.valueOf(12011), Integer.valueOf(42553));
          list.put(Integer.valueOf(12012), Integer.valueOf(42553));
          list.put(Integer.valueOf(12013), Integer.valueOf(63830));
          list.put(Integer.valueOf(12041), Integer.valueOf(42553));
          list.put(Integer.valueOf(12042), Integer.valueOf(42553));
          list.put(Integer.valueOf(12043), Integer.valueOf(42553));
          list.put(Integer.valueOf(12044), Integer.valueOf(42553));
          list.put(Integer.valueOf(12045), Integer.valueOf(42553));
          list.put(Integer.valueOf(12046), Integer.valueOf(42553));
          list.put(Integer.valueOf(12054), Integer.valueOf(42553));
          list.put(Integer.valueOf(12081), Integer.valueOf(42553));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(12001), Integer.valueOf(1252));
          list.put(Integer.valueOf(12002), Integer.valueOf(1252));
          list.put(Integer.valueOf(12003), Integer.valueOf(1252));
          list.put(Integer.valueOf(12004), Integer.valueOf(1252));
          list.put(Integer.valueOf(12005), Integer.valueOf(1252));
          list.put(Integer.valueOf(12006), Integer.valueOf(1252));
          list.put(Integer.valueOf(12009), Integer.valueOf(1252));
          list.put(Integer.valueOf(12010), Integer.valueOf(1252));
          list.put(Integer.valueOf(12011), Integer.valueOf(834));
          list.put(Integer.valueOf(12012), Integer.valueOf(834));
          list.put(Integer.valueOf(12013), Integer.valueOf(1252));
          list.put(Integer.valueOf(12041), Integer.valueOf(834));
          list.put(Integer.valueOf(12042), Integer.valueOf(834));
          list.put(Integer.valueOf(12043), Integer.valueOf(834));
          list.put(Integer.valueOf(12044), Integer.valueOf(834));
          list.put(Integer.valueOf(12045), Integer.valueOf(834));
          list.put(Integer.valueOf(12046), Integer.valueOf(834));
          list.put(Integer.valueOf(12054), Integer.valueOf(834));
          list.put(Integer.valueOf(12081), Integer.valueOf(834));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(12001), Integer.valueOf(1252));
          list.put(Integer.valueOf(12002), Integer.valueOf(1252));
          list.put(Integer.valueOf(12003), Integer.valueOf(1252));
          list.put(Integer.valueOf(12004), Integer.valueOf(1252));
          list.put(Integer.valueOf(12005), Integer.valueOf(1252));
          list.put(Integer.valueOf(12006), Integer.valueOf(1252));
          list.put(Integer.valueOf(12009), Integer.valueOf(1252));
          list.put(Integer.valueOf(12010), Integer.valueOf(1252));
          list.put(Integer.valueOf(12011), Integer.valueOf(834));
          list.put(Integer.valueOf(12012), Integer.valueOf(834));
          list.put(Integer.valueOf(12013), Integer.valueOf(1252));
          list.put(Integer.valueOf(12041), Integer.valueOf(834));
          list.put(Integer.valueOf(12042), Integer.valueOf(834));
          list.put(Integer.valueOf(12043), Integer.valueOf(834));
          list.put(Integer.valueOf(12044), Integer.valueOf(834));
          list.put(Integer.valueOf(12045), Integer.valueOf(834));
          list.put(Integer.valueOf(12046), Integer.valueOf(834));
          list.put(Integer.valueOf(12054), Integer.valueOf(834));
          list.put(Integer.valueOf(12081), Integer.valueOf(834));
          break;
        }
      case 1302:
        if (num == 1)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(58824));
          list.put(Integer.valueOf(12006), Integer.valueOf(58824));
          list.put(Integer.valueOf(12009), Integer.valueOf(58824));
          list.put(Integer.valueOf(12010), Integer.valueOf(58824));
          list.put(Integer.valueOf(12013), Integer.valueOf(58824));
          list.put(Integer.valueOf(12015), Integer.valueOf(58824));
          list.put(Integer.valueOf(12016), Integer.valueOf(58824));
          list.put(Integer.valueOf(12017), Integer.valueOf(58824));
          list.put(Integer.valueOf(12018), Integer.valueOf(58824));
          list.put(Integer.valueOf(12019), Integer.valueOf(39216));
          list.put(Integer.valueOf(12020), Integer.valueOf(39216));
          list.put(Integer.valueOf(12045), Integer.valueOf(39216));
          list.put(Integer.valueOf(12046), Integer.valueOf(39216));
          list.put(Integer.valueOf(12047), Integer.valueOf(39216));
          list.put(Integer.valueOf(12048), Integer.valueOf(39216));
          list.put(Integer.valueOf(12049), Integer.valueOf(39216));
          list.put(Integer.valueOf(12050), Integer.valueOf(39216));
          list.put(Integer.valueOf(12051), Integer.valueOf(19608));
          list.put(Integer.valueOf(12052), Integer.valueOf(19608));
          list.put(Integer.valueOf(12055), Integer.valueOf(39216));
          list.put(Integer.valueOf(12070), Integer.valueOf(19608));
          list.put(Integer.valueOf(12052), Integer.valueOf(58824));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(12005), Integer.valueOf(1153));
          list.put(Integer.valueOf(12006), Integer.valueOf(1153));
          list.put(Integer.valueOf(12009), Integer.valueOf(1153));
          list.put(Integer.valueOf(12010), Integer.valueOf(1153));
          list.put(Integer.valueOf(12013), Integer.valueOf(1153));
          list.put(Integer.valueOf(12015), Integer.valueOf(1153));
          list.put(Integer.valueOf(12016), Integer.valueOf(1153));
          list.put(Integer.valueOf(12017), Integer.valueOf(1153));
          list.put(Integer.valueOf(12018), Integer.valueOf(1153));
          list.put(Integer.valueOf(12019), Integer.valueOf(769));
          list.put(Integer.valueOf(12020), Integer.valueOf(769));
          list.put(Integer.valueOf(12045), Integer.valueOf(769));
          list.put(Integer.valueOf(12046), Integer.valueOf(769));
          list.put(Integer.valueOf(12047), Integer.valueOf(769));
          list.put(Integer.valueOf(12048), Integer.valueOf(769));
          list.put(Integer.valueOf(12049), Integer.valueOf(769));
          list.put(Integer.valueOf(12050), Integer.valueOf(769));
          list.put(Integer.valueOf(12051), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(384));
          list.put(Integer.valueOf(12055), Integer.valueOf(769));
          list.put(Integer.valueOf(12070), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(1153));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(12005), Integer.valueOf(1153));
          list.put(Integer.valueOf(12006), Integer.valueOf(1153));
          list.put(Integer.valueOf(12009), Integer.valueOf(1153));
          list.put(Integer.valueOf(12010), Integer.valueOf(1153));
          list.put(Integer.valueOf(12013), Integer.valueOf(1153));
          list.put(Integer.valueOf(12015), Integer.valueOf(1153));
          list.put(Integer.valueOf(12016), Integer.valueOf(1153));
          list.put(Integer.valueOf(12017), Integer.valueOf(1153));
          list.put(Integer.valueOf(12018), Integer.valueOf(1153));
          list.put(Integer.valueOf(12019), Integer.valueOf(769));
          list.put(Integer.valueOf(12020), Integer.valueOf(769));
          list.put(Integer.valueOf(12045), Integer.valueOf(769));
          list.put(Integer.valueOf(12046), Integer.valueOf(769));
          list.put(Integer.valueOf(12047), Integer.valueOf(769));
          list.put(Integer.valueOf(12048), Integer.valueOf(769));
          list.put(Integer.valueOf(12049), Integer.valueOf(769));
          list.put(Integer.valueOf(12050), Integer.valueOf(769));
          list.put(Integer.valueOf(12051), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(384));
          list.put(Integer.valueOf(12055), Integer.valueOf(769));
          list.put(Integer.valueOf(12070), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(1153));
        }
        break;
      case 1303:
        if (num == 1)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(58824));
          list.put(Integer.valueOf(12006), Integer.valueOf(58824));
          list.put(Integer.valueOf(12009), Integer.valueOf(58824));
          list.put(Integer.valueOf(12010), Integer.valueOf(58824));
          list.put(Integer.valueOf(12013), Integer.valueOf(58824));
          list.put(Integer.valueOf(12015), Integer.valueOf(58824));
          list.put(Integer.valueOf(12016), Integer.valueOf(58824));
          list.put(Integer.valueOf(12017), Integer.valueOf(58824));
          list.put(Integer.valueOf(12018), Integer.valueOf(58824));
          list.put(Integer.valueOf(12019), Integer.valueOf(39216));
          list.put(Integer.valueOf(12020), Integer.valueOf(39216));
          list.put(Integer.valueOf(12045), Integer.valueOf(39216));
          list.put(Integer.valueOf(12046), Integer.valueOf(39216));
          list.put(Integer.valueOf(12047), Integer.valueOf(39216));
          list.put(Integer.valueOf(12048), Integer.valueOf(39216));
          list.put(Integer.valueOf(12049), Integer.valueOf(39216));
          list.put(Integer.valueOf(12050), Integer.valueOf(39216));
          list.put(Integer.valueOf(12051), Integer.valueOf(19608));
          list.put(Integer.valueOf(12052), Integer.valueOf(19608));
          list.put(Integer.valueOf(12055), Integer.valueOf(39216));
          list.put(Integer.valueOf(12070), Integer.valueOf(19608));
          list.put(Integer.valueOf(12052), Integer.valueOf(58824));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(12005), Integer.valueOf(1153));
          list.put(Integer.valueOf(12006), Integer.valueOf(1153));
          list.put(Integer.valueOf(12009), Integer.valueOf(1153));
          list.put(Integer.valueOf(12010), Integer.valueOf(1153));
          list.put(Integer.valueOf(12013), Integer.valueOf(1153));
          list.put(Integer.valueOf(12015), Integer.valueOf(1153));
          list.put(Integer.valueOf(12016), Integer.valueOf(1153));
          list.put(Integer.valueOf(12017), Integer.valueOf(1153));
          list.put(Integer.valueOf(12018), Integer.valueOf(1153));
          list.put(Integer.valueOf(12019), Integer.valueOf(769));
          list.put(Integer.valueOf(12020), Integer.valueOf(769));
          list.put(Integer.valueOf(12045), Integer.valueOf(769));
          list.put(Integer.valueOf(12046), Integer.valueOf(769));
          list.put(Integer.valueOf(12047), Integer.valueOf(769));
          list.put(Integer.valueOf(12048), Integer.valueOf(769));
          list.put(Integer.valueOf(12049), Integer.valueOf(769));
          list.put(Integer.valueOf(12050), Integer.valueOf(769));
          list.put(Integer.valueOf(12051), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(384));
          list.put(Integer.valueOf(12055), Integer.valueOf(769));
          list.put(Integer.valueOf(12070), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(1153));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(12005), Integer.valueOf(1153));
          list.put(Integer.valueOf(12006), Integer.valueOf(1153));
          list.put(Integer.valueOf(12009), Integer.valueOf(1153));
          list.put(Integer.valueOf(12010), Integer.valueOf(1153));
          list.put(Integer.valueOf(12013), Integer.valueOf(1153));
          list.put(Integer.valueOf(12015), Integer.valueOf(1153));
          list.put(Integer.valueOf(12016), Integer.valueOf(1153));
          list.put(Integer.valueOf(12017), Integer.valueOf(1153));
          list.put(Integer.valueOf(12018), Integer.valueOf(1153));
          list.put(Integer.valueOf(12019), Integer.valueOf(769));
          list.put(Integer.valueOf(12020), Integer.valueOf(769));
          list.put(Integer.valueOf(12045), Integer.valueOf(769));
          list.put(Integer.valueOf(12046), Integer.valueOf(769));
          list.put(Integer.valueOf(12047), Integer.valueOf(769));
          list.put(Integer.valueOf(12048), Integer.valueOf(769));
          list.put(Integer.valueOf(12049), Integer.valueOf(769));
          list.put(Integer.valueOf(12050), Integer.valueOf(769));
          list.put(Integer.valueOf(12051), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(384));
          list.put(Integer.valueOf(12055), Integer.valueOf(769));
          list.put(Integer.valueOf(12070), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(1153));
        }
        break;
      case 1304:
        if (num == 1)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(63830));
          list.put(Integer.valueOf(12002), Integer.valueOf(63830));
          list.put(Integer.valueOf(12003), Integer.valueOf(63830));
          list.put(Integer.valueOf(12004), Integer.valueOf(63830));
          list.put(Integer.valueOf(12005), Integer.valueOf(63830));
          list.put(Integer.valueOf(12006), Integer.valueOf(63830));
          list.put(Integer.valueOf(12009), Integer.valueOf(63830));
          list.put(Integer.valueOf(12010), Integer.valueOf(63830));
          list.put(Integer.valueOf(12011), Integer.valueOf(42553));
          list.put(Integer.valueOf(12012), Integer.valueOf(42553));
          list.put(Integer.valueOf(12013), Integer.valueOf(63830));
          list.put(Integer.valueOf(12041), Integer.valueOf(42553));
          list.put(Integer.valueOf(12042), Integer.valueOf(42553));
          list.put(Integer.valueOf(12043), Integer.valueOf(42553));
          list.put(Integer.valueOf(12044), Integer.valueOf(42553));
          list.put(Integer.valueOf(12045), Integer.valueOf(42553));
          list.put(Integer.valueOf(12046), Integer.valueOf(42553));
          list.put(Integer.valueOf(12054), Integer.valueOf(42553));
          list.put(Integer.valueOf(12081), Integer.valueOf(42553));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(12001), Integer.valueOf(1252));
          list.put(Integer.valueOf(12002), Integer.valueOf(1252));
          list.put(Integer.valueOf(12003), Integer.valueOf(1252));
          list.put(Integer.valueOf(12004), Integer.valueOf(1252));
          list.put(Integer.valueOf(12005), Integer.valueOf(1252));
          list.put(Integer.valueOf(12006), Integer.valueOf(1252));
          list.put(Integer.valueOf(12009), Integer.valueOf(1252));
          list.put(Integer.valueOf(12010), Integer.valueOf(1252));
          list.put(Integer.valueOf(12011), Integer.valueOf(834));
          list.put(Integer.valueOf(12012), Integer.valueOf(834));
          list.put(Integer.valueOf(12013), Integer.valueOf(1252));
          list.put(Integer.valueOf(12041), Integer.valueOf(834));
          list.put(Integer.valueOf(12042), Integer.valueOf(834));
          list.put(Integer.valueOf(12043), Integer.valueOf(834));
          list.put(Integer.valueOf(12044), Integer.valueOf(834));
          list.put(Integer.valueOf(12045), Integer.valueOf(834));
          list.put(Integer.valueOf(12046), Integer.valueOf(834));
          list.put(Integer.valueOf(12054), Integer.valueOf(834));
          list.put(Integer.valueOf(12081), Integer.valueOf(834));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2011), Integer.valueOf(72622));
          list.put(Integer.valueOf(2012), Integer.valueOf(72622));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(12001), Integer.valueOf(1252));
          list.put(Integer.valueOf(12002), Integer.valueOf(1252));
          list.put(Integer.valueOf(12003), Integer.valueOf(1252));
          list.put(Integer.valueOf(12004), Integer.valueOf(1252));
          list.put(Integer.valueOf(12005), Integer.valueOf(1252));
          list.put(Integer.valueOf(12006), Integer.valueOf(1252));
          list.put(Integer.valueOf(12009), Integer.valueOf(1252));
          list.put(Integer.valueOf(12010), Integer.valueOf(1252));
          list.put(Integer.valueOf(12011), Integer.valueOf(834));
          list.put(Integer.valueOf(12012), Integer.valueOf(834));
          list.put(Integer.valueOf(12013), Integer.valueOf(1252));
          list.put(Integer.valueOf(12041), Integer.valueOf(834));
          list.put(Integer.valueOf(12042), Integer.valueOf(834));
          list.put(Integer.valueOf(12043), Integer.valueOf(834));
          list.put(Integer.valueOf(12044), Integer.valueOf(834));
          list.put(Integer.valueOf(12045), Integer.valueOf(834));
          list.put(Integer.valueOf(12046), Integer.valueOf(834));
          list.put(Integer.valueOf(12054), Integer.valueOf(834));
          list.put(Integer.valueOf(12081), Integer.valueOf(834));
        }
        break;
      case 1309:
        if (num == 1)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(63830));
          list.put(Integer.valueOf(12002), Integer.valueOf(63830));
          list.put(Integer.valueOf(12003), Integer.valueOf(63830));
          list.put(Integer.valueOf(12004), Integer.valueOf(63830));
          list.put(Integer.valueOf(12005), Integer.valueOf(63830));
          list.put(Integer.valueOf(12006), Integer.valueOf(63830));
          list.put(Integer.valueOf(12009), Integer.valueOf(63830));
          list.put(Integer.valueOf(12010), Integer.valueOf(63830));
          list.put(Integer.valueOf(12011), Integer.valueOf(42553));
          list.put(Integer.valueOf(12012), Integer.valueOf(42553));
          list.put(Integer.valueOf(12013), Integer.valueOf(63830));
          list.put(Integer.valueOf(12041), Integer.valueOf(42553));
          list.put(Integer.valueOf(12042), Integer.valueOf(42553));
          list.put(Integer.valueOf(12043), Integer.valueOf(42553));
          list.put(Integer.valueOf(12044), Integer.valueOf(42553));
          list.put(Integer.valueOf(12045), Integer.valueOf(42553));
          list.put(Integer.valueOf(12046), Integer.valueOf(42553));
          list.put(Integer.valueOf(12054), Integer.valueOf(42553));
          list.put(Integer.valueOf(12081), Integer.valueOf(42553));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2011), Integer.valueOf(72622));
          list.put(Integer.valueOf(2012), Integer.valueOf(72622));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(12001), Integer.valueOf(1252));
          list.put(Integer.valueOf(12002), Integer.valueOf(1252));
          list.put(Integer.valueOf(12003), Integer.valueOf(1252));
          list.put(Integer.valueOf(12004), Integer.valueOf(1252));
          list.put(Integer.valueOf(12005), Integer.valueOf(1252));
          list.put(Integer.valueOf(12006), Integer.valueOf(1252));
          list.put(Integer.valueOf(12009), Integer.valueOf(1252));
          list.put(Integer.valueOf(12010), Integer.valueOf(1252));
          list.put(Integer.valueOf(12011), Integer.valueOf(834));
          list.put(Integer.valueOf(12012), Integer.valueOf(834));
          list.put(Integer.valueOf(12013), Integer.valueOf(1252));
          list.put(Integer.valueOf(12041), Integer.valueOf(834));
          list.put(Integer.valueOf(12042), Integer.valueOf(834));
          list.put(Integer.valueOf(12043), Integer.valueOf(834));
          list.put(Integer.valueOf(12044), Integer.valueOf(834));
          list.put(Integer.valueOf(12045), Integer.valueOf(834));
          list.put(Integer.valueOf(12046), Integer.valueOf(834));
          list.put(Integer.valueOf(12054), Integer.valueOf(834));
          list.put(Integer.valueOf(12081), Integer.valueOf(834));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2011), Integer.valueOf(72622));
          list.put(Integer.valueOf(2012), Integer.valueOf(72622));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(12001), Integer.valueOf(1252));
          list.put(Integer.valueOf(12002), Integer.valueOf(1252));
          list.put(Integer.valueOf(12003), Integer.valueOf(1252));
          list.put(Integer.valueOf(12004), Integer.valueOf(1252));
          list.put(Integer.valueOf(12005), Integer.valueOf(1252));
          list.put(Integer.valueOf(12006), Integer.valueOf(1252));
          list.put(Integer.valueOf(12009), Integer.valueOf(1252));
          list.put(Integer.valueOf(12010), Integer.valueOf(1252));
          list.put(Integer.valueOf(12011), Integer.valueOf(834));
          list.put(Integer.valueOf(12012), Integer.valueOf(834));
          list.put(Integer.valueOf(12013), Integer.valueOf(1252));
          list.put(Integer.valueOf(12041), Integer.valueOf(834));
          list.put(Integer.valueOf(12042), Integer.valueOf(834));
          list.put(Integer.valueOf(12043), Integer.valueOf(834));
          list.put(Integer.valueOf(12044), Integer.valueOf(834));
          list.put(Integer.valueOf(12045), Integer.valueOf(834));
          list.put(Integer.valueOf(12046), Integer.valueOf(834));
          list.put(Integer.valueOf(12054), Integer.valueOf(834));
          list.put(Integer.valueOf(12081), Integer.valueOf(834));
        }
        break;
      case 1305:
        if (num == 1)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(58824));
          list.put(Integer.valueOf(12006), Integer.valueOf(58824));
          list.put(Integer.valueOf(12009), Integer.valueOf(58824));
          list.put(Integer.valueOf(12010), Integer.valueOf(58824));
          list.put(Integer.valueOf(12013), Integer.valueOf(58824));
          list.put(Integer.valueOf(12015), Integer.valueOf(58824));
          list.put(Integer.valueOf(12016), Integer.valueOf(58824));
          list.put(Integer.valueOf(12017), Integer.valueOf(58824));
          list.put(Integer.valueOf(12018), Integer.valueOf(58824));
          list.put(Integer.valueOf(12019), Integer.valueOf(39216));
          list.put(Integer.valueOf(12020), Integer.valueOf(39216));
          list.put(Integer.valueOf(12045), Integer.valueOf(39216));
          list.put(Integer.valueOf(12046), Integer.valueOf(39216));
          list.put(Integer.valueOf(12047), Integer.valueOf(39216));
          list.put(Integer.valueOf(12048), Integer.valueOf(39216));
          list.put(Integer.valueOf(12049), Integer.valueOf(39216));
          list.put(Integer.valueOf(12050), Integer.valueOf(39216));
          list.put(Integer.valueOf(12051), Integer.valueOf(19608));
          list.put(Integer.valueOf(12052), Integer.valueOf(19608));
          list.put(Integer.valueOf(12055), Integer.valueOf(39216));
          list.put(Integer.valueOf(12070), Integer.valueOf(19608));
          list.put(Integer.valueOf(12052), Integer.valueOf(58824));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(12005), Integer.valueOf(1153));
          list.put(Integer.valueOf(12006), Integer.valueOf(1153));
          list.put(Integer.valueOf(12009), Integer.valueOf(1153));
          list.put(Integer.valueOf(12010), Integer.valueOf(1153));
          list.put(Integer.valueOf(12013), Integer.valueOf(1153));
          list.put(Integer.valueOf(12015), Integer.valueOf(1153));
          list.put(Integer.valueOf(12016), Integer.valueOf(1153));
          list.put(Integer.valueOf(12017), Integer.valueOf(1153));
          list.put(Integer.valueOf(12018), Integer.valueOf(1153));
          list.put(Integer.valueOf(12019), Integer.valueOf(769));
          list.put(Integer.valueOf(12020), Integer.valueOf(769));
          list.put(Integer.valueOf(12045), Integer.valueOf(769));
          list.put(Integer.valueOf(12046), Integer.valueOf(769));
          list.put(Integer.valueOf(12047), Integer.valueOf(769));
          list.put(Integer.valueOf(12048), Integer.valueOf(769));
          list.put(Integer.valueOf(12049), Integer.valueOf(769));
          list.put(Integer.valueOf(12050), Integer.valueOf(769));
          list.put(Integer.valueOf(12051), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(384));
          list.put(Integer.valueOf(12055), Integer.valueOf(769));
          list.put(Integer.valueOf(12070), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(1153));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(12005), Integer.valueOf(1153));
          list.put(Integer.valueOf(12006), Integer.valueOf(1153));
          list.put(Integer.valueOf(12009), Integer.valueOf(1153));
          list.put(Integer.valueOf(12010), Integer.valueOf(1153));
          list.put(Integer.valueOf(12013), Integer.valueOf(1153));
          list.put(Integer.valueOf(12015), Integer.valueOf(1153));
          list.put(Integer.valueOf(12016), Integer.valueOf(1153));
          list.put(Integer.valueOf(12017), Integer.valueOf(1153));
          list.put(Integer.valueOf(12018), Integer.valueOf(1153));
          list.put(Integer.valueOf(12019), Integer.valueOf(769));
          list.put(Integer.valueOf(12020), Integer.valueOf(769));
          list.put(Integer.valueOf(12045), Integer.valueOf(769));
          list.put(Integer.valueOf(12046), Integer.valueOf(769));
          list.put(Integer.valueOf(12047), Integer.valueOf(769));
          list.put(Integer.valueOf(12048), Integer.valueOf(769));
          list.put(Integer.valueOf(12049), Integer.valueOf(769));
          list.put(Integer.valueOf(12050), Integer.valueOf(769));
          list.put(Integer.valueOf(12051), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(384));
          list.put(Integer.valueOf(12055), Integer.valueOf(769));
          list.put(Integer.valueOf(12070), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(1153));
        }
        break;
      case 1306:
        if (num == 1)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(63830));
          list.put(Integer.valueOf(12002), Integer.valueOf(63830));
          list.put(Integer.valueOf(12003), Integer.valueOf(63830));
          list.put(Integer.valueOf(12004), Integer.valueOf(63830));
          list.put(Integer.valueOf(12005), Integer.valueOf(63830));
          list.put(Integer.valueOf(12006), Integer.valueOf(63830));
          list.put(Integer.valueOf(12009), Integer.valueOf(63830));
          list.put(Integer.valueOf(12010), Integer.valueOf(63830));
          list.put(Integer.valueOf(12011), Integer.valueOf(42553));
          list.put(Integer.valueOf(12012), Integer.valueOf(42553));
          list.put(Integer.valueOf(12013), Integer.valueOf(63830));
          list.put(Integer.valueOf(12041), Integer.valueOf(42553));
          list.put(Integer.valueOf(12042), Integer.valueOf(42553));
          list.put(Integer.valueOf(12043), Integer.valueOf(42553));
          list.put(Integer.valueOf(12044), Integer.valueOf(42553));
          list.put(Integer.valueOf(12045), Integer.valueOf(42553));
          list.put(Integer.valueOf(12046), Integer.valueOf(42553));
          list.put(Integer.valueOf(12054), Integer.valueOf(42553));
          list.put(Integer.valueOf(12081), Integer.valueOf(42553));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2011), Integer.valueOf(72622));
          list.put(Integer.valueOf(2012), Integer.valueOf(72622));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(12001), Integer.valueOf(1252));
          list.put(Integer.valueOf(12002), Integer.valueOf(1252));
          list.put(Integer.valueOf(12003), Integer.valueOf(1252));
          list.put(Integer.valueOf(12004), Integer.valueOf(1252));
          list.put(Integer.valueOf(12005), Integer.valueOf(1252));
          list.put(Integer.valueOf(12006), Integer.valueOf(1252));
          list.put(Integer.valueOf(12009), Integer.valueOf(1252));
          list.put(Integer.valueOf(12010), Integer.valueOf(1252));
          list.put(Integer.valueOf(12011), Integer.valueOf(834));
          list.put(Integer.valueOf(12012), Integer.valueOf(834));
          list.put(Integer.valueOf(12013), Integer.valueOf(1252));
          list.put(Integer.valueOf(12041), Integer.valueOf(834));
          list.put(Integer.valueOf(12042), Integer.valueOf(834));
          list.put(Integer.valueOf(12043), Integer.valueOf(834));
          list.put(Integer.valueOf(12044), Integer.valueOf(834));
          list.put(Integer.valueOf(12045), Integer.valueOf(834));
          list.put(Integer.valueOf(12046), Integer.valueOf(834));
          list.put(Integer.valueOf(12054), Integer.valueOf(834));
          list.put(Integer.valueOf(12081), Integer.valueOf(834));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2011), Integer.valueOf(72622));
          list.put(Integer.valueOf(2012), Integer.valueOf(72622));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(12001), Integer.valueOf(1252));
          list.put(Integer.valueOf(12002), Integer.valueOf(1252));
          list.put(Integer.valueOf(12003), Integer.valueOf(1252));
          list.put(Integer.valueOf(12004), Integer.valueOf(1252));
          list.put(Integer.valueOf(12005), Integer.valueOf(1252));
          list.put(Integer.valueOf(12006), Integer.valueOf(1252));
          list.put(Integer.valueOf(12009), Integer.valueOf(1252));
          list.put(Integer.valueOf(12010), Integer.valueOf(1252));
          list.put(Integer.valueOf(12011), Integer.valueOf(834));
          list.put(Integer.valueOf(12012), Integer.valueOf(834));
          list.put(Integer.valueOf(12013), Integer.valueOf(1252));
          list.put(Integer.valueOf(12041), Integer.valueOf(834));
          list.put(Integer.valueOf(12042), Integer.valueOf(834));
          list.put(Integer.valueOf(12043), Integer.valueOf(834));
          list.put(Integer.valueOf(12044), Integer.valueOf(834));
          list.put(Integer.valueOf(12045), Integer.valueOf(834));
          list.put(Integer.valueOf(12046), Integer.valueOf(834));
          list.put(Integer.valueOf(12054), Integer.valueOf(834));
          list.put(Integer.valueOf(12081), Integer.valueOf(834));
        }
        break;
      case 1307:
        if (num == 1)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(58824));
          list.put(Integer.valueOf(12006), Integer.valueOf(58824));
          list.put(Integer.valueOf(12009), Integer.valueOf(58824));
          list.put(Integer.valueOf(12010), Integer.valueOf(58824));
          list.put(Integer.valueOf(12013), Integer.valueOf(58824));
          list.put(Integer.valueOf(12015), Integer.valueOf(58824));
          list.put(Integer.valueOf(12016), Integer.valueOf(58824));
          list.put(Integer.valueOf(12017), Integer.valueOf(58824));
          list.put(Integer.valueOf(12018), Integer.valueOf(58824));
          list.put(Integer.valueOf(12019), Integer.valueOf(39216));
          list.put(Integer.valueOf(12020), Integer.valueOf(39216));
          list.put(Integer.valueOf(12045), Integer.valueOf(39216));
          list.put(Integer.valueOf(12046), Integer.valueOf(39216));
          list.put(Integer.valueOf(12047), Integer.valueOf(39216));
          list.put(Integer.valueOf(12048), Integer.valueOf(39216));
          list.put(Integer.valueOf(12049), Integer.valueOf(39216));
          list.put(Integer.valueOf(12050), Integer.valueOf(39216));
          list.put(Integer.valueOf(12051), Integer.valueOf(19608));
          list.put(Integer.valueOf(12052), Integer.valueOf(19608));
          list.put(Integer.valueOf(12055), Integer.valueOf(39216));
          list.put(Integer.valueOf(12070), Integer.valueOf(19608));
          list.put(Integer.valueOf(12052), Integer.valueOf(58824));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(12005), Integer.valueOf(1153));
          list.put(Integer.valueOf(12006), Integer.valueOf(1153));
          list.put(Integer.valueOf(12009), Integer.valueOf(1153));
          list.put(Integer.valueOf(12010), Integer.valueOf(1153));
          list.put(Integer.valueOf(12013), Integer.valueOf(1153));
          list.put(Integer.valueOf(12015), Integer.valueOf(1153));
          list.put(Integer.valueOf(12016), Integer.valueOf(1153));
          list.put(Integer.valueOf(12017), Integer.valueOf(1153));
          list.put(Integer.valueOf(12018), Integer.valueOf(1153));
          list.put(Integer.valueOf(12019), Integer.valueOf(769));
          list.put(Integer.valueOf(12020), Integer.valueOf(769));
          list.put(Integer.valueOf(12045), Integer.valueOf(769));
          list.put(Integer.valueOf(12046), Integer.valueOf(769));
          list.put(Integer.valueOf(12047), Integer.valueOf(769));
          list.put(Integer.valueOf(12048), Integer.valueOf(769));
          list.put(Integer.valueOf(12049), Integer.valueOf(769));
          list.put(Integer.valueOf(12050), Integer.valueOf(769));
          list.put(Integer.valueOf(12051), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(384));
          list.put(Integer.valueOf(12055), Integer.valueOf(769));
          list.put(Integer.valueOf(12070), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(1153));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(2015), Integer.valueOf(72622));
          list.put(Integer.valueOf(2016), Integer.valueOf(72622));
          list.put(Integer.valueOf(12005), Integer.valueOf(1153));
          list.put(Integer.valueOf(12006), Integer.valueOf(1153));
          list.put(Integer.valueOf(12009), Integer.valueOf(1153));
          list.put(Integer.valueOf(12010), Integer.valueOf(1153));
          list.put(Integer.valueOf(12013), Integer.valueOf(1153));
          list.put(Integer.valueOf(12015), Integer.valueOf(1153));
          list.put(Integer.valueOf(12016), Integer.valueOf(1153));
          list.put(Integer.valueOf(12017), Integer.valueOf(1153));
          list.put(Integer.valueOf(12018), Integer.valueOf(1153));
          list.put(Integer.valueOf(12019), Integer.valueOf(769));
          list.put(Integer.valueOf(12020), Integer.valueOf(769));
          list.put(Integer.valueOf(12045), Integer.valueOf(769));
          list.put(Integer.valueOf(12046), Integer.valueOf(769));
          list.put(Integer.valueOf(12047), Integer.valueOf(769));
          list.put(Integer.valueOf(12048), Integer.valueOf(769));
          list.put(Integer.valueOf(12049), Integer.valueOf(769));
          list.put(Integer.valueOf(12050), Integer.valueOf(769));
          list.put(Integer.valueOf(12051), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(384));
          list.put(Integer.valueOf(12055), Integer.valueOf(769));
          list.put(Integer.valueOf(12070), Integer.valueOf(384));
          list.put(Integer.valueOf(12052), Integer.valueOf(1153));
        }
        break;
      case 1308:
        if (num == 1)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(63830));
          list.put(Integer.valueOf(12002), Integer.valueOf(63830));
          list.put(Integer.valueOf(12003), Integer.valueOf(63830));
          list.put(Integer.valueOf(12004), Integer.valueOf(63830));
          list.put(Integer.valueOf(12005), Integer.valueOf(63830));
          list.put(Integer.valueOf(12006), Integer.valueOf(63830));
          list.put(Integer.valueOf(12009), Integer.valueOf(63830));
          list.put(Integer.valueOf(12010), Integer.valueOf(63830));
          list.put(Integer.valueOf(12011), Integer.valueOf(42553));
          list.put(Integer.valueOf(12012), Integer.valueOf(42553));
          list.put(Integer.valueOf(12013), Integer.valueOf(63830));
          list.put(Integer.valueOf(12041), Integer.valueOf(42553));
          list.put(Integer.valueOf(12042), Integer.valueOf(42553));
          list.put(Integer.valueOf(12043), Integer.valueOf(42553));
          list.put(Integer.valueOf(12044), Integer.valueOf(42553));
          list.put(Integer.valueOf(12045), Integer.valueOf(42553));
          list.put(Integer.valueOf(12046), Integer.valueOf(42553));
          list.put(Integer.valueOf(12054), Integer.valueOf(42553));
          list.put(Integer.valueOf(12081), Integer.valueOf(42553));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2011), Integer.valueOf(72622));
          list.put(Integer.valueOf(2012), Integer.valueOf(72622));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(12001), Integer.valueOf(1252));
          list.put(Integer.valueOf(12002), Integer.valueOf(1252));
          list.put(Integer.valueOf(12003), Integer.valueOf(1252));
          list.put(Integer.valueOf(12004), Integer.valueOf(1252));
          list.put(Integer.valueOf(12005), Integer.valueOf(1252));
          list.put(Integer.valueOf(12006), Integer.valueOf(1252));
          list.put(Integer.valueOf(12009), Integer.valueOf(1252));
          list.put(Integer.valueOf(12010), Integer.valueOf(1252));
          list.put(Integer.valueOf(12011), Integer.valueOf(834));
          list.put(Integer.valueOf(12012), Integer.valueOf(834));
          list.put(Integer.valueOf(12013), Integer.valueOf(1252));
          list.put(Integer.valueOf(12041), Integer.valueOf(834));
          list.put(Integer.valueOf(12042), Integer.valueOf(834));
          list.put(Integer.valueOf(12043), Integer.valueOf(834));
          list.put(Integer.valueOf(12044), Integer.valueOf(834));
          list.put(Integer.valueOf(12045), Integer.valueOf(834));
          list.put(Integer.valueOf(12046), Integer.valueOf(834));
          list.put(Integer.valueOf(12054), Integer.valueOf(834));
          list.put(Integer.valueOf(12081), Integer.valueOf(834));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(2001), Integer.valueOf(72622));
          list.put(Integer.valueOf(2002), Integer.valueOf(72622));
          list.put(Integer.valueOf(2003), Integer.valueOf(72622));
          list.put(Integer.valueOf(2004), Integer.valueOf(72622));
          list.put(Integer.valueOf(2007), Integer.valueOf(108932));
          list.put(Integer.valueOf(2008), Integer.valueOf(108932));
          list.put(Integer.valueOf(2009), Integer.valueOf(108932));
          list.put(Integer.valueOf(2010), Integer.valueOf(108932));
          list.put(Integer.valueOf(2011), Integer.valueOf(72622));
          list.put(Integer.valueOf(2012), Integer.valueOf(72622));
          list.put(Integer.valueOf(2014), Integer.valueOf(108932));
          list.put(Integer.valueOf(12001), Integer.valueOf(1252));
          list.put(Integer.valueOf(12002), Integer.valueOf(1252));
          list.put(Integer.valueOf(12003), Integer.valueOf(1252));
          list.put(Integer.valueOf(12004), Integer.valueOf(1252));
          list.put(Integer.valueOf(12005), Integer.valueOf(1252));
          list.put(Integer.valueOf(12006), Integer.valueOf(1252));
          list.put(Integer.valueOf(12009), Integer.valueOf(1252));
          list.put(Integer.valueOf(12010), Integer.valueOf(1252));
          list.put(Integer.valueOf(12011), Integer.valueOf(834));
          list.put(Integer.valueOf(12012), Integer.valueOf(834));
          list.put(Integer.valueOf(12013), Integer.valueOf(1252));
          list.put(Integer.valueOf(12041), Integer.valueOf(834));
          list.put(Integer.valueOf(12042), Integer.valueOf(834));
          list.put(Integer.valueOf(12043), Integer.valueOf(834));
          list.put(Integer.valueOf(12044), Integer.valueOf(834));
          list.put(Integer.valueOf(12045), Integer.valueOf(834));
          list.put(Integer.valueOf(12046), Integer.valueOf(834));
          list.put(Integer.valueOf(12054), Integer.valueOf(834));
          list.put(Integer.valueOf(12081), Integer.valueOf(834));
        }
        break;
    }
    return list;
  }
  
  public static Map<Integer, Integer> getEpicOption(int type, int num)
  {
    Map<Integer, Integer> list = new HashMap<>();
    switch (type)
    {
      case 1300:
        if (num == 1)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(88235));
          list.put(Integer.valueOf(22046), Integer.valueOf(88235));
          list.put(Integer.valueOf(22051), Integer.valueOf(58824));
          list.put(Integer.valueOf(22052), Integer.valueOf(58824));
          list.put(Integer.valueOf(22055), Integer.valueOf(29412));
          list.put(Integer.valueOf(22057), Integer.valueOf(88235));
          list.put(Integer.valueOf(22058), Integer.valueOf(88235));
          list.put(Integer.valueOf(22059), Integer.valueOf(88235));
          list.put(Integer.valueOf(22060), Integer.valueOf(88235));
          list.put(Integer.valueOf(22070), Integer.valueOf(29412));
          list.put(Integer.valueOf(22087), Integer.valueOf(58824));
          list.put(Integer.valueOf(22201), Integer.valueOf(88235));
          list.put(Integer.valueOf(22206), Integer.valueOf(88235));
          list.put(Integer.valueOf(22291), Integer.valueOf(58824));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(56022));
          list.put(Integer.valueOf(12006), Integer.valueOf(56022));
          list.put(Integer.valueOf(12009), Integer.valueOf(56022));
          list.put(Integer.valueOf(12010), Integer.valueOf(56022));
          list.put(Integer.valueOf(12013), Integer.valueOf(56022));
          list.put(Integer.valueOf(12015), Integer.valueOf(56022));
          list.put(Integer.valueOf(12016), Integer.valueOf(56022));
          list.put(Integer.valueOf(12017), Integer.valueOf(56022));
          list.put(Integer.valueOf(12018), Integer.valueOf(56022));
          list.put(Integer.valueOf(12019), Integer.valueOf(37348));
          list.put(Integer.valueOf(12020), Integer.valueOf(37348));
          list.put(Integer.valueOf(12045), Integer.valueOf(37348));
          list.put(Integer.valueOf(12046), Integer.valueOf(37348));
          list.put(Integer.valueOf(12047), Integer.valueOf(37348));
          list.put(Integer.valueOf(12048), Integer.valueOf(37348));
          list.put(Integer.valueOf(12049), Integer.valueOf(37348));
          list.put(Integer.valueOf(12050), Integer.valueOf(37348));
          list.put(Integer.valueOf(12051), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(18674));
          list.put(Integer.valueOf(12055), Integer.valueOf(37348));
          list.put(Integer.valueOf(12070), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(56022));
          list.put(Integer.valueOf(22045), Integer.valueOf(4202));
          list.put(Integer.valueOf(22046), Integer.valueOf(4202));
          list.put(Integer.valueOf(22051), Integer.valueOf(2801));
          list.put(Integer.valueOf(22052), Integer.valueOf(2801));
          list.put(Integer.valueOf(22055), Integer.valueOf(1401));
          list.put(Integer.valueOf(22057), Integer.valueOf(4202));
          list.put(Integer.valueOf(22058), Integer.valueOf(4202));
          list.put(Integer.valueOf(22059), Integer.valueOf(4202));
          list.put(Integer.valueOf(22060), Integer.valueOf(4202));
          list.put(Integer.valueOf(22070), Integer.valueOf(1401));
          list.put(Integer.valueOf(22087), Integer.valueOf(2801));
          list.put(Integer.valueOf(22201), Integer.valueOf(4202));
          list.put(Integer.valueOf(22206), Integer.valueOf(4202));
          list.put(Integer.valueOf(22291), Integer.valueOf(2801));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(56022));
          list.put(Integer.valueOf(12006), Integer.valueOf(56022));
          list.put(Integer.valueOf(12009), Integer.valueOf(56022));
          list.put(Integer.valueOf(12010), Integer.valueOf(56022));
          list.put(Integer.valueOf(12013), Integer.valueOf(56022));
          list.put(Integer.valueOf(12015), Integer.valueOf(56022));
          list.put(Integer.valueOf(12016), Integer.valueOf(56022));
          list.put(Integer.valueOf(12017), Integer.valueOf(56022));
          list.put(Integer.valueOf(12018), Integer.valueOf(56022));
          list.put(Integer.valueOf(12019), Integer.valueOf(37348));
          list.put(Integer.valueOf(12020), Integer.valueOf(37348));
          list.put(Integer.valueOf(12045), Integer.valueOf(37348));
          list.put(Integer.valueOf(12046), Integer.valueOf(37348));
          list.put(Integer.valueOf(12047), Integer.valueOf(37348));
          list.put(Integer.valueOf(12048), Integer.valueOf(37348));
          list.put(Integer.valueOf(12049), Integer.valueOf(37348));
          list.put(Integer.valueOf(12050), Integer.valueOf(37348));
          list.put(Integer.valueOf(12051), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(18674));
          list.put(Integer.valueOf(12055), Integer.valueOf(37348));
          list.put(Integer.valueOf(12070), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(56022));
          list.put(Integer.valueOf(22045), Integer.valueOf(4202));
          list.put(Integer.valueOf(22046), Integer.valueOf(4202));
          list.put(Integer.valueOf(22051), Integer.valueOf(2801));
          list.put(Integer.valueOf(22052), Integer.valueOf(2801));
          list.put(Integer.valueOf(22055), Integer.valueOf(1401));
          list.put(Integer.valueOf(22057), Integer.valueOf(4202));
          list.put(Integer.valueOf(22058), Integer.valueOf(4202));
          list.put(Integer.valueOf(22059), Integer.valueOf(4202));
          list.put(Integer.valueOf(22060), Integer.valueOf(4202));
          list.put(Integer.valueOf(22070), Integer.valueOf(1401));
          list.put(Integer.valueOf(22087), Integer.valueOf(2801));
          list.put(Integer.valueOf(22201), Integer.valueOf(4202));
          list.put(Integer.valueOf(22206), Integer.valueOf(4202));
          list.put(Integer.valueOf(22291), Integer.valueOf(2801));
        }
        break;
      case 1301:
        if (num == 1)
        {
          list.put(Integer.valueOf(22001), Integer.valueOf(60000));
          list.put(Integer.valueOf(22002), Integer.valueOf(60000));
          list.put(Integer.valueOf(22003), Integer.valueOf(60000));
          list.put(Integer.valueOf(22004), Integer.valueOf(60000));
          list.put(Integer.valueOf(22005), Integer.valueOf(60000));
          list.put(Integer.valueOf(22006), Integer.valueOf(60000));
          list.put(Integer.valueOf(22009), Integer.valueOf(60000));
          list.put(Integer.valueOf(22010), Integer.valueOf(60000));
          list.put(Integer.valueOf(22011), Integer.valueOf(40000));
          list.put(Integer.valueOf(22012), Integer.valueOf(40000));
          list.put(Integer.valueOf(22013), Integer.valueOf(60000));
          list.put(Integer.valueOf(22041), Integer.valueOf(40000));
          list.put(Integer.valueOf(22042), Integer.valueOf(40000));
          list.put(Integer.valueOf(22043), Integer.valueOf(40000));
          list.put(Integer.valueOf(22044), Integer.valueOf(40000));
          list.put(Integer.valueOf(22045), Integer.valueOf(60000));
          list.put(Integer.valueOf(22046), Integer.valueOf(60000));
          list.put(Integer.valueOf(22054), Integer.valueOf(60000));
          list.put(Integer.valueOf(22086), Integer.valueOf(40000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(60790));
          list.put(Integer.valueOf(12002), Integer.valueOf(60790));
          list.put(Integer.valueOf(12003), Integer.valueOf(60790));
          list.put(Integer.valueOf(12004), Integer.valueOf(60790));
          list.put(Integer.valueOf(12005), Integer.valueOf(60790));
          list.put(Integer.valueOf(12006), Integer.valueOf(60790));
          list.put(Integer.valueOf(12009), Integer.valueOf(60790));
          list.put(Integer.valueOf(12010), Integer.valueOf(60790));
          list.put(Integer.valueOf(12011), Integer.valueOf(40527));
          list.put(Integer.valueOf(12012), Integer.valueOf(40527));
          list.put(Integer.valueOf(12013), Integer.valueOf(60790));
          list.put(Integer.valueOf(12041), Integer.valueOf(40527));
          list.put(Integer.valueOf(12042), Integer.valueOf(40527));
          list.put(Integer.valueOf(12043), Integer.valueOf(40527));
          list.put(Integer.valueOf(12044), Integer.valueOf(40527));
          list.put(Integer.valueOf(12045), Integer.valueOf(40527));
          list.put(Integer.valueOf(12046), Integer.valueOf(40527));
          list.put(Integer.valueOf(12054), Integer.valueOf(40527));
          list.put(Integer.valueOf(12081), Integer.valueOf(40527));
          list.put(Integer.valueOf(22001), Integer.valueOf(2857));
          list.put(Integer.valueOf(22002), Integer.valueOf(2857));
          list.put(Integer.valueOf(22003), Integer.valueOf(2857));
          list.put(Integer.valueOf(22004), Integer.valueOf(2857));
          list.put(Integer.valueOf(22005), Integer.valueOf(2857));
          list.put(Integer.valueOf(22006), Integer.valueOf(2857));
          list.put(Integer.valueOf(22009), Integer.valueOf(2857));
          list.put(Integer.valueOf(22010), Integer.valueOf(2857));
          list.put(Integer.valueOf(22011), Integer.valueOf(1905));
          list.put(Integer.valueOf(22012), Integer.valueOf(1905));
          list.put(Integer.valueOf(22013), Integer.valueOf(2857));
          list.put(Integer.valueOf(22041), Integer.valueOf(1905));
          list.put(Integer.valueOf(22042), Integer.valueOf(1905));
          list.put(Integer.valueOf(22043), Integer.valueOf(1905));
          list.put(Integer.valueOf(22044), Integer.valueOf(1905));
          list.put(Integer.valueOf(22045), Integer.valueOf(2857));
          list.put(Integer.valueOf(22046), Integer.valueOf(2857));
          list.put(Integer.valueOf(22054), Integer.valueOf(2857));
          list.put(Integer.valueOf(22086), Integer.valueOf(1905));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(60790));
          list.put(Integer.valueOf(12002), Integer.valueOf(60790));
          list.put(Integer.valueOf(12003), Integer.valueOf(60790));
          list.put(Integer.valueOf(12004), Integer.valueOf(60790));
          list.put(Integer.valueOf(12005), Integer.valueOf(60790));
          list.put(Integer.valueOf(12006), Integer.valueOf(60790));
          list.put(Integer.valueOf(12009), Integer.valueOf(60790));
          list.put(Integer.valueOf(12010), Integer.valueOf(60790));
          list.put(Integer.valueOf(12011), Integer.valueOf(40527));
          list.put(Integer.valueOf(12012), Integer.valueOf(40527));
          list.put(Integer.valueOf(12013), Integer.valueOf(60790));
          list.put(Integer.valueOf(12041), Integer.valueOf(40527));
          list.put(Integer.valueOf(12042), Integer.valueOf(40527));
          list.put(Integer.valueOf(12043), Integer.valueOf(40527));
          list.put(Integer.valueOf(12044), Integer.valueOf(40527));
          list.put(Integer.valueOf(12045), Integer.valueOf(40527));
          list.put(Integer.valueOf(12046), Integer.valueOf(40527));
          list.put(Integer.valueOf(12054), Integer.valueOf(40527));
          list.put(Integer.valueOf(12081), Integer.valueOf(40527));
          list.put(Integer.valueOf(22001), Integer.valueOf(2857));
          list.put(Integer.valueOf(22002), Integer.valueOf(2857));
          list.put(Integer.valueOf(22003), Integer.valueOf(2857));
          list.put(Integer.valueOf(22004), Integer.valueOf(2857));
          list.put(Integer.valueOf(22005), Integer.valueOf(2857));
          list.put(Integer.valueOf(22006), Integer.valueOf(2857));
          list.put(Integer.valueOf(22009), Integer.valueOf(2857));
          list.put(Integer.valueOf(22010), Integer.valueOf(2857));
          list.put(Integer.valueOf(22011), Integer.valueOf(1905));
          list.put(Integer.valueOf(22012), Integer.valueOf(1905));
          list.put(Integer.valueOf(22013), Integer.valueOf(2857));
          list.put(Integer.valueOf(22041), Integer.valueOf(1905));
          list.put(Integer.valueOf(22042), Integer.valueOf(1905));
          list.put(Integer.valueOf(22043), Integer.valueOf(1905));
          list.put(Integer.valueOf(22044), Integer.valueOf(1905));
          list.put(Integer.valueOf(22045), Integer.valueOf(2857));
          list.put(Integer.valueOf(22046), Integer.valueOf(2857));
          list.put(Integer.valueOf(22054), Integer.valueOf(2857));
          list.put(Integer.valueOf(22086), Integer.valueOf(1905));
        }
        break;
      case 1302:
        if (num == 1)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(88235));
          list.put(Integer.valueOf(22046), Integer.valueOf(88235));
          list.put(Integer.valueOf(22051), Integer.valueOf(58824));
          list.put(Integer.valueOf(22052), Integer.valueOf(58824));
          list.put(Integer.valueOf(22055), Integer.valueOf(29412));
          list.put(Integer.valueOf(22057), Integer.valueOf(88235));
          list.put(Integer.valueOf(22058), Integer.valueOf(88235));
          list.put(Integer.valueOf(22059), Integer.valueOf(88235));
          list.put(Integer.valueOf(22060), Integer.valueOf(88235));
          list.put(Integer.valueOf(22070), Integer.valueOf(29412));
          list.put(Integer.valueOf(22087), Integer.valueOf(58824));
          list.put(Integer.valueOf(22201), Integer.valueOf(88235));
          list.put(Integer.valueOf(22206), Integer.valueOf(88235));
          list.put(Integer.valueOf(22291), Integer.valueOf(58824));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(56022));
          list.put(Integer.valueOf(12006), Integer.valueOf(56022));
          list.put(Integer.valueOf(12009), Integer.valueOf(56022));
          list.put(Integer.valueOf(12010), Integer.valueOf(56022));
          list.put(Integer.valueOf(12013), Integer.valueOf(56022));
          list.put(Integer.valueOf(12015), Integer.valueOf(56022));
          list.put(Integer.valueOf(12016), Integer.valueOf(56022));
          list.put(Integer.valueOf(12017), Integer.valueOf(56022));
          list.put(Integer.valueOf(12018), Integer.valueOf(56022));
          list.put(Integer.valueOf(12019), Integer.valueOf(37348));
          list.put(Integer.valueOf(12020), Integer.valueOf(37348));
          list.put(Integer.valueOf(12045), Integer.valueOf(37348));
          list.put(Integer.valueOf(12046), Integer.valueOf(37348));
          list.put(Integer.valueOf(12047), Integer.valueOf(37348));
          list.put(Integer.valueOf(12048), Integer.valueOf(37348));
          list.put(Integer.valueOf(12049), Integer.valueOf(37348));
          list.put(Integer.valueOf(12050), Integer.valueOf(37348));
          list.put(Integer.valueOf(12051), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(18674));
          list.put(Integer.valueOf(12055), Integer.valueOf(37348));
          list.put(Integer.valueOf(12070), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(56022));
          list.put(Integer.valueOf(22045), Integer.valueOf(4202));
          list.put(Integer.valueOf(22046), Integer.valueOf(4202));
          list.put(Integer.valueOf(22051), Integer.valueOf(2801));
          list.put(Integer.valueOf(22052), Integer.valueOf(2801));
          list.put(Integer.valueOf(22055), Integer.valueOf(1401));
          list.put(Integer.valueOf(22057), Integer.valueOf(4202));
          list.put(Integer.valueOf(22058), Integer.valueOf(4202));
          list.put(Integer.valueOf(22059), Integer.valueOf(4202));
          list.put(Integer.valueOf(22060), Integer.valueOf(4202));
          list.put(Integer.valueOf(22070), Integer.valueOf(1401));
          list.put(Integer.valueOf(22087), Integer.valueOf(2801));
          list.put(Integer.valueOf(22201), Integer.valueOf(4202));
          list.put(Integer.valueOf(22206), Integer.valueOf(4202));
          list.put(Integer.valueOf(22291), Integer.valueOf(2801));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(56022));
          list.put(Integer.valueOf(12006), Integer.valueOf(56022));
          list.put(Integer.valueOf(12009), Integer.valueOf(56022));
          list.put(Integer.valueOf(12010), Integer.valueOf(56022));
          list.put(Integer.valueOf(12013), Integer.valueOf(56022));
          list.put(Integer.valueOf(12015), Integer.valueOf(56022));
          list.put(Integer.valueOf(12016), Integer.valueOf(56022));
          list.put(Integer.valueOf(12017), Integer.valueOf(56022));
          list.put(Integer.valueOf(12018), Integer.valueOf(56022));
          list.put(Integer.valueOf(12019), Integer.valueOf(37348));
          list.put(Integer.valueOf(12020), Integer.valueOf(37348));
          list.put(Integer.valueOf(12045), Integer.valueOf(37348));
          list.put(Integer.valueOf(12046), Integer.valueOf(37348));
          list.put(Integer.valueOf(12047), Integer.valueOf(37348));
          list.put(Integer.valueOf(12048), Integer.valueOf(37348));
          list.put(Integer.valueOf(12049), Integer.valueOf(37348));
          list.put(Integer.valueOf(12050), Integer.valueOf(37348));
          list.put(Integer.valueOf(12051), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(18674));
          list.put(Integer.valueOf(12055), Integer.valueOf(37348));
          list.put(Integer.valueOf(12070), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(56022));
          list.put(Integer.valueOf(22045), Integer.valueOf(4202));
          list.put(Integer.valueOf(22046), Integer.valueOf(4202));
          list.put(Integer.valueOf(22051), Integer.valueOf(2801));
          list.put(Integer.valueOf(22052), Integer.valueOf(2801));
          list.put(Integer.valueOf(22055), Integer.valueOf(1401));
          list.put(Integer.valueOf(22057), Integer.valueOf(4202));
          list.put(Integer.valueOf(22058), Integer.valueOf(4202));
          list.put(Integer.valueOf(22059), Integer.valueOf(4202));
          list.put(Integer.valueOf(22060), Integer.valueOf(4202));
          list.put(Integer.valueOf(22070), Integer.valueOf(1401));
          list.put(Integer.valueOf(22087), Integer.valueOf(2801));
          list.put(Integer.valueOf(22201), Integer.valueOf(4202));
          list.put(Integer.valueOf(22206), Integer.valueOf(4202));
          list.put(Integer.valueOf(22291), Integer.valueOf(2801));
        }
        break;
      case 1303:
        if (num == 1)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(88235));
          list.put(Integer.valueOf(22046), Integer.valueOf(88235));
          list.put(Integer.valueOf(22051), Integer.valueOf(58824));
          list.put(Integer.valueOf(22052), Integer.valueOf(58824));
          list.put(Integer.valueOf(22055), Integer.valueOf(29412));
          list.put(Integer.valueOf(22057), Integer.valueOf(88235));
          list.put(Integer.valueOf(22058), Integer.valueOf(88235));
          list.put(Integer.valueOf(22059), Integer.valueOf(88235));
          list.put(Integer.valueOf(22060), Integer.valueOf(88235));
          list.put(Integer.valueOf(22070), Integer.valueOf(29412));
          list.put(Integer.valueOf(22087), Integer.valueOf(58824));
          list.put(Integer.valueOf(22201), Integer.valueOf(88235));
          list.put(Integer.valueOf(22206), Integer.valueOf(88235));
          list.put(Integer.valueOf(22291), Integer.valueOf(58824));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(56022));
          list.put(Integer.valueOf(12006), Integer.valueOf(56022));
          list.put(Integer.valueOf(12009), Integer.valueOf(56022));
          list.put(Integer.valueOf(12010), Integer.valueOf(56022));
          list.put(Integer.valueOf(12013), Integer.valueOf(56022));
          list.put(Integer.valueOf(12015), Integer.valueOf(56022));
          list.put(Integer.valueOf(12016), Integer.valueOf(56022));
          list.put(Integer.valueOf(12017), Integer.valueOf(56022));
          list.put(Integer.valueOf(12018), Integer.valueOf(56022));
          list.put(Integer.valueOf(12019), Integer.valueOf(37348));
          list.put(Integer.valueOf(12020), Integer.valueOf(37348));
          list.put(Integer.valueOf(12045), Integer.valueOf(37348));
          list.put(Integer.valueOf(12046), Integer.valueOf(37348));
          list.put(Integer.valueOf(12047), Integer.valueOf(37348));
          list.put(Integer.valueOf(12048), Integer.valueOf(37348));
          list.put(Integer.valueOf(12049), Integer.valueOf(37348));
          list.put(Integer.valueOf(12050), Integer.valueOf(37348));
          list.put(Integer.valueOf(12051), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(18674));
          list.put(Integer.valueOf(12055), Integer.valueOf(37348));
          list.put(Integer.valueOf(12070), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(56022));
          list.put(Integer.valueOf(22045), Integer.valueOf(4202));
          list.put(Integer.valueOf(22046), Integer.valueOf(4202));
          list.put(Integer.valueOf(22051), Integer.valueOf(2801));
          list.put(Integer.valueOf(22052), Integer.valueOf(2801));
          list.put(Integer.valueOf(22055), Integer.valueOf(1401));
          list.put(Integer.valueOf(22057), Integer.valueOf(4202));
          list.put(Integer.valueOf(22058), Integer.valueOf(4202));
          list.put(Integer.valueOf(22059), Integer.valueOf(4202));
          list.put(Integer.valueOf(22060), Integer.valueOf(4202));
          list.put(Integer.valueOf(22070), Integer.valueOf(1401));
          list.put(Integer.valueOf(22087), Integer.valueOf(2801));
          list.put(Integer.valueOf(22201), Integer.valueOf(4202));
          list.put(Integer.valueOf(22206), Integer.valueOf(4202));
          list.put(Integer.valueOf(22291), Integer.valueOf(2801));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(56022));
          list.put(Integer.valueOf(12006), Integer.valueOf(56022));
          list.put(Integer.valueOf(12009), Integer.valueOf(56022));
          list.put(Integer.valueOf(12010), Integer.valueOf(56022));
          list.put(Integer.valueOf(12013), Integer.valueOf(56022));
          list.put(Integer.valueOf(12015), Integer.valueOf(56022));
          list.put(Integer.valueOf(12016), Integer.valueOf(56022));
          list.put(Integer.valueOf(12017), Integer.valueOf(56022));
          list.put(Integer.valueOf(12018), Integer.valueOf(56022));
          list.put(Integer.valueOf(12019), Integer.valueOf(37348));
          list.put(Integer.valueOf(12020), Integer.valueOf(37348));
          list.put(Integer.valueOf(12045), Integer.valueOf(37348));
          list.put(Integer.valueOf(12046), Integer.valueOf(37348));
          list.put(Integer.valueOf(12047), Integer.valueOf(37348));
          list.put(Integer.valueOf(12048), Integer.valueOf(37348));
          list.put(Integer.valueOf(12049), Integer.valueOf(37348));
          list.put(Integer.valueOf(12050), Integer.valueOf(37348));
          list.put(Integer.valueOf(12051), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(18674));
          list.put(Integer.valueOf(12055), Integer.valueOf(37348));
          list.put(Integer.valueOf(12070), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(56022));
          list.put(Integer.valueOf(22045), Integer.valueOf(4202));
          list.put(Integer.valueOf(22046), Integer.valueOf(4202));
          list.put(Integer.valueOf(22051), Integer.valueOf(2801));
          list.put(Integer.valueOf(22052), Integer.valueOf(2801));
          list.put(Integer.valueOf(22055), Integer.valueOf(1401));
          list.put(Integer.valueOf(22057), Integer.valueOf(4202));
          list.put(Integer.valueOf(22058), Integer.valueOf(4202));
          list.put(Integer.valueOf(22059), Integer.valueOf(4202));
          list.put(Integer.valueOf(22060), Integer.valueOf(4202));
          list.put(Integer.valueOf(20070), Integer.valueOf(1401));
          list.put(Integer.valueOf(22087), Integer.valueOf(2801));
          list.put(Integer.valueOf(22201), Integer.valueOf(4202));
          list.put(Integer.valueOf(22206), Integer.valueOf(4202));
          list.put(Integer.valueOf(22291), Integer.valueOf(2801));
        }
        break;
      case 1304:
        if (num == 1)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(60000));
          list.put(Integer.valueOf(20002), Integer.valueOf(60000));
          list.put(Integer.valueOf(20003), Integer.valueOf(60000));
          list.put(Integer.valueOf(20004), Integer.valueOf(60000));
          list.put(Integer.valueOf(20005), Integer.valueOf(60000));
          list.put(Integer.valueOf(20006), Integer.valueOf(60000));
          list.put(Integer.valueOf(22009), Integer.valueOf(60000));
          list.put(Integer.valueOf(22010), Integer.valueOf(60000));
          list.put(Integer.valueOf(22011), Integer.valueOf(40000));
          list.put(Integer.valueOf(22012), Integer.valueOf(40000));
          list.put(Integer.valueOf(22013), Integer.valueOf(60000));
          list.put(Integer.valueOf(22041), Integer.valueOf(40000));
          list.put(Integer.valueOf(22042), Integer.valueOf(40000));
          list.put(Integer.valueOf(22043), Integer.valueOf(40000));
          list.put(Integer.valueOf(22044), Integer.valueOf(40000));
          list.put(Integer.valueOf(22045), Integer.valueOf(60000));
          list.put(Integer.valueOf(22046), Integer.valueOf(60000));
          list.put(Integer.valueOf(22054), Integer.valueOf(60000));
          list.put(Integer.valueOf(22086), Integer.valueOf(40000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(60790));
          list.put(Integer.valueOf(12002), Integer.valueOf(60790));
          list.put(Integer.valueOf(12003), Integer.valueOf(60790));
          list.put(Integer.valueOf(12004), Integer.valueOf(60790));
          list.put(Integer.valueOf(12005), Integer.valueOf(60790));
          list.put(Integer.valueOf(12006), Integer.valueOf(60790));
          list.put(Integer.valueOf(12009), Integer.valueOf(60790));
          list.put(Integer.valueOf(12010), Integer.valueOf(60790));
          list.put(Integer.valueOf(12011), Integer.valueOf(40527));
          list.put(Integer.valueOf(12012), Integer.valueOf(40527));
          list.put(Integer.valueOf(12013), Integer.valueOf(60790));
          list.put(Integer.valueOf(12041), Integer.valueOf(40527));
          list.put(Integer.valueOf(12042), Integer.valueOf(40527));
          list.put(Integer.valueOf(12043), Integer.valueOf(40527));
          list.put(Integer.valueOf(12044), Integer.valueOf(40527));
          list.put(Integer.valueOf(12045), Integer.valueOf(40527));
          list.put(Integer.valueOf(12046), Integer.valueOf(40527));
          list.put(Integer.valueOf(12054), Integer.valueOf(40527));
          list.put(Integer.valueOf(12081), Integer.valueOf(40527));
          list.put(Integer.valueOf(20001), Integer.valueOf(2857));
          list.put(Integer.valueOf(20002), Integer.valueOf(2857));
          list.put(Integer.valueOf(20003), Integer.valueOf(2857));
          list.put(Integer.valueOf(20004), Integer.valueOf(2857));
          list.put(Integer.valueOf(20005), Integer.valueOf(2857));
          list.put(Integer.valueOf(20006), Integer.valueOf(2857));
          list.put(Integer.valueOf(22009), Integer.valueOf(2857));
          list.put(Integer.valueOf(22010), Integer.valueOf(2857));
          list.put(Integer.valueOf(22011), Integer.valueOf(1905));
          list.put(Integer.valueOf(22012), Integer.valueOf(1905));
          list.put(Integer.valueOf(22013), Integer.valueOf(2857));
          list.put(Integer.valueOf(22041), Integer.valueOf(1905));
          list.put(Integer.valueOf(22042), Integer.valueOf(1905));
          list.put(Integer.valueOf(22043), Integer.valueOf(1905));
          list.put(Integer.valueOf(22044), Integer.valueOf(1905));
          list.put(Integer.valueOf(22045), Integer.valueOf(2857));
          list.put(Integer.valueOf(22046), Integer.valueOf(2857));
          list.put(Integer.valueOf(22054), Integer.valueOf(2857));
          list.put(Integer.valueOf(22086), Integer.valueOf(1905));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(60790));
          list.put(Integer.valueOf(12002), Integer.valueOf(60790));
          list.put(Integer.valueOf(12003), Integer.valueOf(60790));
          list.put(Integer.valueOf(12004), Integer.valueOf(60790));
          list.put(Integer.valueOf(12005), Integer.valueOf(60790));
          list.put(Integer.valueOf(12006), Integer.valueOf(60790));
          list.put(Integer.valueOf(12009), Integer.valueOf(60790));
          list.put(Integer.valueOf(12010), Integer.valueOf(60790));
          list.put(Integer.valueOf(12011), Integer.valueOf(40527));
          list.put(Integer.valueOf(12012), Integer.valueOf(40527));
          list.put(Integer.valueOf(12013), Integer.valueOf(60790));
          list.put(Integer.valueOf(12041), Integer.valueOf(40527));
          list.put(Integer.valueOf(12042), Integer.valueOf(40527));
          list.put(Integer.valueOf(12043), Integer.valueOf(40527));
          list.put(Integer.valueOf(12044), Integer.valueOf(40527));
          list.put(Integer.valueOf(12045), Integer.valueOf(40527));
          list.put(Integer.valueOf(12046), Integer.valueOf(40527));
          list.put(Integer.valueOf(12054), Integer.valueOf(40527));
          list.put(Integer.valueOf(12081), Integer.valueOf(40527));
          list.put(Integer.valueOf(20001), Integer.valueOf(2857));
          list.put(Integer.valueOf(20002), Integer.valueOf(2857));
          list.put(Integer.valueOf(20003), Integer.valueOf(2857));
          list.put(Integer.valueOf(20004), Integer.valueOf(2857));
          list.put(Integer.valueOf(20005), Integer.valueOf(2857));
          list.put(Integer.valueOf(20006), Integer.valueOf(2857));
          list.put(Integer.valueOf(22009), Integer.valueOf(2857));
          list.put(Integer.valueOf(22010), Integer.valueOf(2857));
          list.put(Integer.valueOf(22011), Integer.valueOf(1905));
          list.put(Integer.valueOf(22012), Integer.valueOf(1905));
          list.put(Integer.valueOf(22013), Integer.valueOf(2857));
          list.put(Integer.valueOf(22041), Integer.valueOf(1905));
          list.put(Integer.valueOf(22042), Integer.valueOf(1905));
          list.put(Integer.valueOf(22043), Integer.valueOf(1905));
          list.put(Integer.valueOf(22044), Integer.valueOf(1905));
          list.put(Integer.valueOf(22045), Integer.valueOf(2857));
          list.put(Integer.valueOf(22046), Integer.valueOf(2857));
          list.put(Integer.valueOf(22054), Integer.valueOf(2857));
          list.put(Integer.valueOf(22086), Integer.valueOf(1905));
        }
        break;
      case 1309:
        if (num == 1)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(60000));
          list.put(Integer.valueOf(20002), Integer.valueOf(60000));
          list.put(Integer.valueOf(20003), Integer.valueOf(60000));
          list.put(Integer.valueOf(20004), Integer.valueOf(60000));
          list.put(Integer.valueOf(20005), Integer.valueOf(60000));
          list.put(Integer.valueOf(20006), Integer.valueOf(60000));
          list.put(Integer.valueOf(22009), Integer.valueOf(60000));
          list.put(Integer.valueOf(22010), Integer.valueOf(60000));
          list.put(Integer.valueOf(22011), Integer.valueOf(40000));
          list.put(Integer.valueOf(22012), Integer.valueOf(40000));
          list.put(Integer.valueOf(22013), Integer.valueOf(60000));
          list.put(Integer.valueOf(22041), Integer.valueOf(40000));
          list.put(Integer.valueOf(22042), Integer.valueOf(40000));
          list.put(Integer.valueOf(22043), Integer.valueOf(40000));
          list.put(Integer.valueOf(22044), Integer.valueOf(40000));
          list.put(Integer.valueOf(22045), Integer.valueOf(60000));
          list.put(Integer.valueOf(22046), Integer.valueOf(60000));
          list.put(Integer.valueOf(22054), Integer.valueOf(60000));
          list.put(Integer.valueOf(22086), Integer.valueOf(40000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(60790));
          list.put(Integer.valueOf(12002), Integer.valueOf(60790));
          list.put(Integer.valueOf(12003), Integer.valueOf(60790));
          list.put(Integer.valueOf(12004), Integer.valueOf(60790));
          list.put(Integer.valueOf(12005), Integer.valueOf(60790));
          list.put(Integer.valueOf(12006), Integer.valueOf(60790));
          list.put(Integer.valueOf(12009), Integer.valueOf(60790));
          list.put(Integer.valueOf(12010), Integer.valueOf(60790));
          list.put(Integer.valueOf(12011), Integer.valueOf(40527));
          list.put(Integer.valueOf(12012), Integer.valueOf(40527));
          list.put(Integer.valueOf(12013), Integer.valueOf(60790));
          list.put(Integer.valueOf(12041), Integer.valueOf(40527));
          list.put(Integer.valueOf(12042), Integer.valueOf(40527));
          list.put(Integer.valueOf(12043), Integer.valueOf(40527));
          list.put(Integer.valueOf(12044), Integer.valueOf(40527));
          list.put(Integer.valueOf(12045), Integer.valueOf(40527));
          list.put(Integer.valueOf(12046), Integer.valueOf(40527));
          list.put(Integer.valueOf(12054), Integer.valueOf(40527));
          list.put(Integer.valueOf(12081), Integer.valueOf(40527));
          list.put(Integer.valueOf(20001), Integer.valueOf(2857));
          list.put(Integer.valueOf(20002), Integer.valueOf(2857));
          list.put(Integer.valueOf(20003), Integer.valueOf(2857));
          list.put(Integer.valueOf(20004), Integer.valueOf(2857));
          list.put(Integer.valueOf(20005), Integer.valueOf(2857));
          list.put(Integer.valueOf(20006), Integer.valueOf(2857));
          list.put(Integer.valueOf(22009), Integer.valueOf(2857));
          list.put(Integer.valueOf(22010), Integer.valueOf(2857));
          list.put(Integer.valueOf(22011), Integer.valueOf(1905));
          list.put(Integer.valueOf(22012), Integer.valueOf(1905));
          list.put(Integer.valueOf(22013), Integer.valueOf(2857));
          list.put(Integer.valueOf(22041), Integer.valueOf(1905));
          list.put(Integer.valueOf(22042), Integer.valueOf(1905));
          list.put(Integer.valueOf(22043), Integer.valueOf(1905));
          list.put(Integer.valueOf(22044), Integer.valueOf(1905));
          list.put(Integer.valueOf(22045), Integer.valueOf(2857));
          list.put(Integer.valueOf(22046), Integer.valueOf(2857));
          list.put(Integer.valueOf(22054), Integer.valueOf(2857));
          list.put(Integer.valueOf(22086), Integer.valueOf(1905));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(60790));
          list.put(Integer.valueOf(12002), Integer.valueOf(60790));
          list.put(Integer.valueOf(12003), Integer.valueOf(60790));
          list.put(Integer.valueOf(12004), Integer.valueOf(60790));
          list.put(Integer.valueOf(12005), Integer.valueOf(60790));
          list.put(Integer.valueOf(12006), Integer.valueOf(60790));
          list.put(Integer.valueOf(12009), Integer.valueOf(60790));
          list.put(Integer.valueOf(12010), Integer.valueOf(60790));
          list.put(Integer.valueOf(12011), Integer.valueOf(40527));
          list.put(Integer.valueOf(12012), Integer.valueOf(40527));
          list.put(Integer.valueOf(12013), Integer.valueOf(60790));
          list.put(Integer.valueOf(12041), Integer.valueOf(40527));
          list.put(Integer.valueOf(12042), Integer.valueOf(40527));
          list.put(Integer.valueOf(12043), Integer.valueOf(40527));
          list.put(Integer.valueOf(12044), Integer.valueOf(40527));
          list.put(Integer.valueOf(12045), Integer.valueOf(40527));
          list.put(Integer.valueOf(12046), Integer.valueOf(40527));
          list.put(Integer.valueOf(12054), Integer.valueOf(40527));
          list.put(Integer.valueOf(12081), Integer.valueOf(40527));
          list.put(Integer.valueOf(20001), Integer.valueOf(2857));
          list.put(Integer.valueOf(20002), Integer.valueOf(2857));
          list.put(Integer.valueOf(20003), Integer.valueOf(2857));
          list.put(Integer.valueOf(20004), Integer.valueOf(2857));
          list.put(Integer.valueOf(20005), Integer.valueOf(2857));
          list.put(Integer.valueOf(20006), Integer.valueOf(2857));
          list.put(Integer.valueOf(22009), Integer.valueOf(2857));
          list.put(Integer.valueOf(22010), Integer.valueOf(2857));
          list.put(Integer.valueOf(22011), Integer.valueOf(1905));
          list.put(Integer.valueOf(22012), Integer.valueOf(1905));
          list.put(Integer.valueOf(22013), Integer.valueOf(2857));
          list.put(Integer.valueOf(22041), Integer.valueOf(1905));
          list.put(Integer.valueOf(22042), Integer.valueOf(1905));
          list.put(Integer.valueOf(22043), Integer.valueOf(1905));
          list.put(Integer.valueOf(22044), Integer.valueOf(1905));
          list.put(Integer.valueOf(22045), Integer.valueOf(2857));
          list.put(Integer.valueOf(22046), Integer.valueOf(2857));
          list.put(Integer.valueOf(22054), Integer.valueOf(2857));
          list.put(Integer.valueOf(22086), Integer.valueOf(1905));
        }
        break;
      case 1305:
        if (num == 1)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(88235));
          list.put(Integer.valueOf(22046), Integer.valueOf(88235));
          list.put(Integer.valueOf(22051), Integer.valueOf(58824));
          list.put(Integer.valueOf(22052), Integer.valueOf(58824));
          list.put(Integer.valueOf(22055), Integer.valueOf(29412));
          list.put(Integer.valueOf(22057), Integer.valueOf(88235));
          list.put(Integer.valueOf(22058), Integer.valueOf(88235));
          list.put(Integer.valueOf(22059), Integer.valueOf(88235));
          list.put(Integer.valueOf(22060), Integer.valueOf(88235));
          list.put(Integer.valueOf(22070), Integer.valueOf(29412));
          list.put(Integer.valueOf(22087), Integer.valueOf(58824));
          list.put(Integer.valueOf(22201), Integer.valueOf(88235));
          list.put(Integer.valueOf(22206), Integer.valueOf(88235));
          list.put(Integer.valueOf(22291), Integer.valueOf(58824));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(56022));
          list.put(Integer.valueOf(12006), Integer.valueOf(56022));
          list.put(Integer.valueOf(12009), Integer.valueOf(56022));
          list.put(Integer.valueOf(12010), Integer.valueOf(56022));
          list.put(Integer.valueOf(12013), Integer.valueOf(56022));
          list.put(Integer.valueOf(12015), Integer.valueOf(56022));
          list.put(Integer.valueOf(12016), Integer.valueOf(56022));
          list.put(Integer.valueOf(12017), Integer.valueOf(56022));
          list.put(Integer.valueOf(12018), Integer.valueOf(56022));
          list.put(Integer.valueOf(12019), Integer.valueOf(37348));
          list.put(Integer.valueOf(12020), Integer.valueOf(37348));
          list.put(Integer.valueOf(12045), Integer.valueOf(37348));
          list.put(Integer.valueOf(12046), Integer.valueOf(37348));
          list.put(Integer.valueOf(12047), Integer.valueOf(37348));
          list.put(Integer.valueOf(12048), Integer.valueOf(37348));
          list.put(Integer.valueOf(12049), Integer.valueOf(37348));
          list.put(Integer.valueOf(12050), Integer.valueOf(37348));
          list.put(Integer.valueOf(12051), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(18674));
          list.put(Integer.valueOf(12055), Integer.valueOf(37348));
          list.put(Integer.valueOf(12070), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(56022));
          list.put(Integer.valueOf(22045), Integer.valueOf(4202));
          list.put(Integer.valueOf(22046), Integer.valueOf(4202));
          list.put(Integer.valueOf(22051), Integer.valueOf(2801));
          list.put(Integer.valueOf(22052), Integer.valueOf(2801));
          list.put(Integer.valueOf(22055), Integer.valueOf(1401));
          list.put(Integer.valueOf(22057), Integer.valueOf(4202));
          list.put(Integer.valueOf(22058), Integer.valueOf(4202));
          list.put(Integer.valueOf(22059), Integer.valueOf(4202));
          list.put(Integer.valueOf(22060), Integer.valueOf(4202));
          list.put(Integer.valueOf(22070), Integer.valueOf(1401));
          list.put(Integer.valueOf(22087), Integer.valueOf(2801));
          list.put(Integer.valueOf(22201), Integer.valueOf(4202));
          list.put(Integer.valueOf(22206), Integer.valueOf(4202));
          list.put(Integer.valueOf(22291), Integer.valueOf(2801));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(56022));
          list.put(Integer.valueOf(12006), Integer.valueOf(56022));
          list.put(Integer.valueOf(12009), Integer.valueOf(56022));
          list.put(Integer.valueOf(12010), Integer.valueOf(56022));
          list.put(Integer.valueOf(12013), Integer.valueOf(56022));
          list.put(Integer.valueOf(12015), Integer.valueOf(56022));
          list.put(Integer.valueOf(12016), Integer.valueOf(56022));
          list.put(Integer.valueOf(12017), Integer.valueOf(56022));
          list.put(Integer.valueOf(12018), Integer.valueOf(56022));
          list.put(Integer.valueOf(12019), Integer.valueOf(37348));
          list.put(Integer.valueOf(12020), Integer.valueOf(37348));
          list.put(Integer.valueOf(12045), Integer.valueOf(37348));
          list.put(Integer.valueOf(12046), Integer.valueOf(37348));
          list.put(Integer.valueOf(12047), Integer.valueOf(37348));
          list.put(Integer.valueOf(12048), Integer.valueOf(37348));
          list.put(Integer.valueOf(12049), Integer.valueOf(37348));
          list.put(Integer.valueOf(12050), Integer.valueOf(37348));
          list.put(Integer.valueOf(12051), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(18674));
          list.put(Integer.valueOf(12055), Integer.valueOf(37348));
          list.put(Integer.valueOf(12070), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(56022));
          list.put(Integer.valueOf(22045), Integer.valueOf(4202));
          list.put(Integer.valueOf(22046), Integer.valueOf(4202));
          list.put(Integer.valueOf(22051), Integer.valueOf(2801));
          list.put(Integer.valueOf(22052), Integer.valueOf(2801));
          list.put(Integer.valueOf(22055), Integer.valueOf(1401));
          list.put(Integer.valueOf(22057), Integer.valueOf(4202));
          list.put(Integer.valueOf(22058), Integer.valueOf(4202));
          list.put(Integer.valueOf(22059), Integer.valueOf(4202));
          list.put(Integer.valueOf(22060), Integer.valueOf(4202));
          list.put(Integer.valueOf(22070), Integer.valueOf(1401));
          list.put(Integer.valueOf(22087), Integer.valueOf(2801));
          list.put(Integer.valueOf(22201), Integer.valueOf(4202));
          list.put(Integer.valueOf(22206), Integer.valueOf(4202));
          list.put(Integer.valueOf(22291), Integer.valueOf(2801));
        }
        break;
      case 1306:
        if (num == 1)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(60000));
          list.put(Integer.valueOf(20002), Integer.valueOf(60000));
          list.put(Integer.valueOf(20003), Integer.valueOf(60000));
          list.put(Integer.valueOf(20004), Integer.valueOf(60000));
          list.put(Integer.valueOf(20005), Integer.valueOf(60000));
          list.put(Integer.valueOf(20006), Integer.valueOf(60000));
          list.put(Integer.valueOf(22009), Integer.valueOf(60000));
          list.put(Integer.valueOf(22010), Integer.valueOf(60000));
          list.put(Integer.valueOf(22011), Integer.valueOf(40000));
          list.put(Integer.valueOf(22012), Integer.valueOf(40000));
          list.put(Integer.valueOf(22013), Integer.valueOf(60000));
          list.put(Integer.valueOf(22041), Integer.valueOf(40000));
          list.put(Integer.valueOf(22042), Integer.valueOf(40000));
          list.put(Integer.valueOf(22043), Integer.valueOf(40000));
          list.put(Integer.valueOf(22044), Integer.valueOf(40000));
          list.put(Integer.valueOf(22045), Integer.valueOf(60000));
          list.put(Integer.valueOf(22046), Integer.valueOf(60000));
          list.put(Integer.valueOf(22054), Integer.valueOf(60000));
          list.put(Integer.valueOf(22086), Integer.valueOf(40000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(60790));
          list.put(Integer.valueOf(12002), Integer.valueOf(60790));
          list.put(Integer.valueOf(12003), Integer.valueOf(60790));
          list.put(Integer.valueOf(12004), Integer.valueOf(60790));
          list.put(Integer.valueOf(12005), Integer.valueOf(60790));
          list.put(Integer.valueOf(12006), Integer.valueOf(60790));
          list.put(Integer.valueOf(12009), Integer.valueOf(60790));
          list.put(Integer.valueOf(12010), Integer.valueOf(60790));
          list.put(Integer.valueOf(12011), Integer.valueOf(40527));
          list.put(Integer.valueOf(12012), Integer.valueOf(40527));
          list.put(Integer.valueOf(12013), Integer.valueOf(60790));
          list.put(Integer.valueOf(12041), Integer.valueOf(40527));
          list.put(Integer.valueOf(12042), Integer.valueOf(40527));
          list.put(Integer.valueOf(12043), Integer.valueOf(40527));
          list.put(Integer.valueOf(12044), Integer.valueOf(40527));
          list.put(Integer.valueOf(12045), Integer.valueOf(40527));
          list.put(Integer.valueOf(12046), Integer.valueOf(40527));
          list.put(Integer.valueOf(12054), Integer.valueOf(40527));
          list.put(Integer.valueOf(12081), Integer.valueOf(40527));
          list.put(Integer.valueOf(20001), Integer.valueOf(2857));
          list.put(Integer.valueOf(20002), Integer.valueOf(2857));
          list.put(Integer.valueOf(20003), Integer.valueOf(2857));
          list.put(Integer.valueOf(20004), Integer.valueOf(2857));
          list.put(Integer.valueOf(20005), Integer.valueOf(2857));
          list.put(Integer.valueOf(20006), Integer.valueOf(2857));
          list.put(Integer.valueOf(22009), Integer.valueOf(2857));
          list.put(Integer.valueOf(22010), Integer.valueOf(2857));
          list.put(Integer.valueOf(22011), Integer.valueOf(1905));
          list.put(Integer.valueOf(22012), Integer.valueOf(1905));
          list.put(Integer.valueOf(22013), Integer.valueOf(2857));
          list.put(Integer.valueOf(22041), Integer.valueOf(1905));
          list.put(Integer.valueOf(22042), Integer.valueOf(1905));
          list.put(Integer.valueOf(22043), Integer.valueOf(1905));
          list.put(Integer.valueOf(22044), Integer.valueOf(1905));
          list.put(Integer.valueOf(22045), Integer.valueOf(2857));
          list.put(Integer.valueOf(22046), Integer.valueOf(2857));
          list.put(Integer.valueOf(22054), Integer.valueOf(2857));
          list.put(Integer.valueOf(22086), Integer.valueOf(1905));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(60790));
          list.put(Integer.valueOf(12002), Integer.valueOf(60790));
          list.put(Integer.valueOf(12003), Integer.valueOf(60790));
          list.put(Integer.valueOf(12004), Integer.valueOf(60790));
          list.put(Integer.valueOf(12005), Integer.valueOf(60790));
          list.put(Integer.valueOf(12006), Integer.valueOf(60790));
          list.put(Integer.valueOf(12009), Integer.valueOf(60790));
          list.put(Integer.valueOf(12010), Integer.valueOf(60790));
          list.put(Integer.valueOf(12011), Integer.valueOf(40527));
          list.put(Integer.valueOf(12012), Integer.valueOf(40527));
          list.put(Integer.valueOf(12013), Integer.valueOf(60790));
          list.put(Integer.valueOf(12041), Integer.valueOf(40527));
          list.put(Integer.valueOf(12042), Integer.valueOf(40527));
          list.put(Integer.valueOf(12043), Integer.valueOf(40527));
          list.put(Integer.valueOf(12044), Integer.valueOf(40527));
          list.put(Integer.valueOf(12045), Integer.valueOf(40527));
          list.put(Integer.valueOf(12046), Integer.valueOf(40527));
          list.put(Integer.valueOf(12054), Integer.valueOf(40527));
          list.put(Integer.valueOf(12081), Integer.valueOf(40527));
          list.put(Integer.valueOf(20001), Integer.valueOf(2857));
          list.put(Integer.valueOf(20002), Integer.valueOf(2857));
          list.put(Integer.valueOf(20003), Integer.valueOf(2857));
          list.put(Integer.valueOf(20004), Integer.valueOf(2857));
          list.put(Integer.valueOf(20005), Integer.valueOf(2857));
          list.put(Integer.valueOf(20006), Integer.valueOf(2857));
          list.put(Integer.valueOf(22009), Integer.valueOf(2857));
          list.put(Integer.valueOf(22010), Integer.valueOf(2857));
          list.put(Integer.valueOf(22011), Integer.valueOf(1905));
          list.put(Integer.valueOf(22012), Integer.valueOf(1905));
          list.put(Integer.valueOf(22013), Integer.valueOf(2857));
          list.put(Integer.valueOf(22041), Integer.valueOf(1905));
          list.put(Integer.valueOf(22042), Integer.valueOf(1905));
          list.put(Integer.valueOf(22043), Integer.valueOf(1905));
          list.put(Integer.valueOf(22044), Integer.valueOf(1905));
          list.put(Integer.valueOf(22045), Integer.valueOf(2857));
          list.put(Integer.valueOf(22046), Integer.valueOf(2857));
          list.put(Integer.valueOf(22054), Integer.valueOf(2857));
          list.put(Integer.valueOf(22086), Integer.valueOf(1905));
        }
        break;
      case 1307:
        if (num == 1)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(88235));
          list.put(Integer.valueOf(22046), Integer.valueOf(88235));
          list.put(Integer.valueOf(22051), Integer.valueOf(58824));
          list.put(Integer.valueOf(22052), Integer.valueOf(58824));
          list.put(Integer.valueOf(22055), Integer.valueOf(29412));
          list.put(Integer.valueOf(22057), Integer.valueOf(88235));
          list.put(Integer.valueOf(22058), Integer.valueOf(88235));
          list.put(Integer.valueOf(22059), Integer.valueOf(88235));
          list.put(Integer.valueOf(22060), Integer.valueOf(88235));
          list.put(Integer.valueOf(22070), Integer.valueOf(29412));
          list.put(Integer.valueOf(22087), Integer.valueOf(58824));
          list.put(Integer.valueOf(22201), Integer.valueOf(88235));
          list.put(Integer.valueOf(22206), Integer.valueOf(88235));
          list.put(Integer.valueOf(22291), Integer.valueOf(58824));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(56022));
          list.put(Integer.valueOf(12006), Integer.valueOf(56022));
          list.put(Integer.valueOf(12009), Integer.valueOf(56022));
          list.put(Integer.valueOf(12010), Integer.valueOf(56022));
          list.put(Integer.valueOf(12013), Integer.valueOf(56022));
          list.put(Integer.valueOf(12015), Integer.valueOf(56022));
          list.put(Integer.valueOf(12016), Integer.valueOf(56022));
          list.put(Integer.valueOf(12017), Integer.valueOf(56022));
          list.put(Integer.valueOf(12018), Integer.valueOf(56022));
          list.put(Integer.valueOf(12019), Integer.valueOf(37348));
          list.put(Integer.valueOf(12020), Integer.valueOf(37348));
          list.put(Integer.valueOf(12045), Integer.valueOf(37348));
          list.put(Integer.valueOf(12046), Integer.valueOf(37348));
          list.put(Integer.valueOf(12047), Integer.valueOf(37348));
          list.put(Integer.valueOf(12048), Integer.valueOf(37348));
          list.put(Integer.valueOf(12049), Integer.valueOf(37348));
          list.put(Integer.valueOf(12050), Integer.valueOf(37348));
          list.put(Integer.valueOf(12051), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(18674));
          list.put(Integer.valueOf(12055), Integer.valueOf(37348));
          list.put(Integer.valueOf(12070), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(56022));
          list.put(Integer.valueOf(22045), Integer.valueOf(4202));
          list.put(Integer.valueOf(22046), Integer.valueOf(4202));
          list.put(Integer.valueOf(22051), Integer.valueOf(2801));
          list.put(Integer.valueOf(22052), Integer.valueOf(2801));
          list.put(Integer.valueOf(22055), Integer.valueOf(1401));
          list.put(Integer.valueOf(22057), Integer.valueOf(4202));
          list.put(Integer.valueOf(22058), Integer.valueOf(4202));
          list.put(Integer.valueOf(22059), Integer.valueOf(4202));
          list.put(Integer.valueOf(22060), Integer.valueOf(4202));
          list.put(Integer.valueOf(22070), Integer.valueOf(1401));
          list.put(Integer.valueOf(22087), Integer.valueOf(2801));
          list.put(Integer.valueOf(22201), Integer.valueOf(4202));
          list.put(Integer.valueOf(22206), Integer.valueOf(4202));
          list.put(Integer.valueOf(22291), Integer.valueOf(2801));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(12005), Integer.valueOf(56022));
          list.put(Integer.valueOf(12006), Integer.valueOf(56022));
          list.put(Integer.valueOf(12009), Integer.valueOf(56022));
          list.put(Integer.valueOf(12010), Integer.valueOf(56022));
          list.put(Integer.valueOf(12013), Integer.valueOf(56022));
          list.put(Integer.valueOf(12015), Integer.valueOf(56022));
          list.put(Integer.valueOf(12016), Integer.valueOf(56022));
          list.put(Integer.valueOf(12017), Integer.valueOf(56022));
          list.put(Integer.valueOf(12018), Integer.valueOf(56022));
          list.put(Integer.valueOf(12019), Integer.valueOf(37348));
          list.put(Integer.valueOf(12020), Integer.valueOf(37348));
          list.put(Integer.valueOf(12045), Integer.valueOf(37348));
          list.put(Integer.valueOf(12046), Integer.valueOf(37348));
          list.put(Integer.valueOf(12047), Integer.valueOf(37348));
          list.put(Integer.valueOf(12048), Integer.valueOf(37348));
          list.put(Integer.valueOf(12049), Integer.valueOf(37348));
          list.put(Integer.valueOf(12050), Integer.valueOf(37348));
          list.put(Integer.valueOf(12051), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(18674));
          list.put(Integer.valueOf(12055), Integer.valueOf(37348));
          list.put(Integer.valueOf(12070), Integer.valueOf(18674));
          list.put(Integer.valueOf(12052), Integer.valueOf(56022));
          list.put(Integer.valueOf(22045), Integer.valueOf(4202));
          list.put(Integer.valueOf(22046), Integer.valueOf(4202));
          list.put(Integer.valueOf(22051), Integer.valueOf(2801));
          list.put(Integer.valueOf(22052), Integer.valueOf(2801));
          list.put(Integer.valueOf(22055), Integer.valueOf(1401));
          list.put(Integer.valueOf(22057), Integer.valueOf(4202));
          list.put(Integer.valueOf(22058), Integer.valueOf(4202));
          list.put(Integer.valueOf(22059), Integer.valueOf(4202));
          list.put(Integer.valueOf(22060), Integer.valueOf(4202));
          list.put(Integer.valueOf(22070), Integer.valueOf(1401));
          list.put(Integer.valueOf(22087), Integer.valueOf(2801));
          list.put(Integer.valueOf(22201), Integer.valueOf(4202));
          list.put(Integer.valueOf(22206), Integer.valueOf(4202));
          list.put(Integer.valueOf(22291), Integer.valueOf(2801));
        }
        break;
      case 1308:
        if (num == 1)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(60000));
          list.put(Integer.valueOf(20002), Integer.valueOf(60000));
          list.put(Integer.valueOf(20003), Integer.valueOf(60000));
          list.put(Integer.valueOf(20004), Integer.valueOf(60000));
          list.put(Integer.valueOf(20005), Integer.valueOf(60000));
          list.put(Integer.valueOf(20006), Integer.valueOf(60000));
          list.put(Integer.valueOf(22009), Integer.valueOf(60000));
          list.put(Integer.valueOf(22010), Integer.valueOf(60000));
          list.put(Integer.valueOf(22011), Integer.valueOf(40000));
          list.put(Integer.valueOf(22012), Integer.valueOf(40000));
          list.put(Integer.valueOf(22013), Integer.valueOf(60000));
          list.put(Integer.valueOf(22041), Integer.valueOf(40000));
          list.put(Integer.valueOf(22042), Integer.valueOf(40000));
          list.put(Integer.valueOf(22043), Integer.valueOf(40000));
          list.put(Integer.valueOf(22044), Integer.valueOf(40000));
          list.put(Integer.valueOf(22045), Integer.valueOf(60000));
          list.put(Integer.valueOf(22046), Integer.valueOf(60000));
          list.put(Integer.valueOf(22054), Integer.valueOf(60000));
          list.put(Integer.valueOf(22086), Integer.valueOf(40000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(60790));
          list.put(Integer.valueOf(12002), Integer.valueOf(60790));
          list.put(Integer.valueOf(12003), Integer.valueOf(60790));
          list.put(Integer.valueOf(12004), Integer.valueOf(60790));
          list.put(Integer.valueOf(12005), Integer.valueOf(60790));
          list.put(Integer.valueOf(12006), Integer.valueOf(60790));
          list.put(Integer.valueOf(12009), Integer.valueOf(60790));
          list.put(Integer.valueOf(12010), Integer.valueOf(60790));
          list.put(Integer.valueOf(12011), Integer.valueOf(40527));
          list.put(Integer.valueOf(12012), Integer.valueOf(40527));
          list.put(Integer.valueOf(12013), Integer.valueOf(60790));
          list.put(Integer.valueOf(12041), Integer.valueOf(40527));
          list.put(Integer.valueOf(12042), Integer.valueOf(40527));
          list.put(Integer.valueOf(12043), Integer.valueOf(40527));
          list.put(Integer.valueOf(12044), Integer.valueOf(40527));
          list.put(Integer.valueOf(12045), Integer.valueOf(40527));
          list.put(Integer.valueOf(12046), Integer.valueOf(40527));
          list.put(Integer.valueOf(12054), Integer.valueOf(40527));
          list.put(Integer.valueOf(12081), Integer.valueOf(40527));
          list.put(Integer.valueOf(20001), Integer.valueOf(2857));
          list.put(Integer.valueOf(20002), Integer.valueOf(2857));
          list.put(Integer.valueOf(20003), Integer.valueOf(2857));
          list.put(Integer.valueOf(20004), Integer.valueOf(2857));
          list.put(Integer.valueOf(20005), Integer.valueOf(2857));
          list.put(Integer.valueOf(20006), Integer.valueOf(2857));
          list.put(Integer.valueOf(22009), Integer.valueOf(2857));
          list.put(Integer.valueOf(22010), Integer.valueOf(2857));
          list.put(Integer.valueOf(22011), Integer.valueOf(1905));
          list.put(Integer.valueOf(22012), Integer.valueOf(1905));
          list.put(Integer.valueOf(22013), Integer.valueOf(2857));
          list.put(Integer.valueOf(22041), Integer.valueOf(1905));
          list.put(Integer.valueOf(22042), Integer.valueOf(1905));
          list.put(Integer.valueOf(22043), Integer.valueOf(1905));
          list.put(Integer.valueOf(22044), Integer.valueOf(1905));
          list.put(Integer.valueOf(22045), Integer.valueOf(2857));
          list.put(Integer.valueOf(22046), Integer.valueOf(2857));
          list.put(Integer.valueOf(22054), Integer.valueOf(2857));
          list.put(Integer.valueOf(22086), Integer.valueOf(1905));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(12001), Integer.valueOf(60790));
          list.put(Integer.valueOf(12002), Integer.valueOf(60790));
          list.put(Integer.valueOf(12003), Integer.valueOf(60790));
          list.put(Integer.valueOf(12004), Integer.valueOf(60790));
          list.put(Integer.valueOf(12005), Integer.valueOf(60790));
          list.put(Integer.valueOf(12006), Integer.valueOf(60790));
          list.put(Integer.valueOf(12009), Integer.valueOf(60790));
          list.put(Integer.valueOf(12010), Integer.valueOf(60790));
          list.put(Integer.valueOf(12011), Integer.valueOf(40527));
          list.put(Integer.valueOf(12012), Integer.valueOf(40527));
          list.put(Integer.valueOf(12013), Integer.valueOf(60790));
          list.put(Integer.valueOf(12041), Integer.valueOf(40527));
          list.put(Integer.valueOf(12042), Integer.valueOf(40527));
          list.put(Integer.valueOf(12043), Integer.valueOf(40527));
          list.put(Integer.valueOf(12044), Integer.valueOf(40527));
          list.put(Integer.valueOf(12045), Integer.valueOf(40527));
          list.put(Integer.valueOf(12046), Integer.valueOf(40527));
          list.put(Integer.valueOf(12054), Integer.valueOf(40527));
          list.put(Integer.valueOf(12081), Integer.valueOf(40527));
          list.put(Integer.valueOf(20001), Integer.valueOf(2857));
          list.put(Integer.valueOf(20002), Integer.valueOf(2857));
          list.put(Integer.valueOf(20003), Integer.valueOf(2857));
          list.put(Integer.valueOf(20004), Integer.valueOf(2857));
          list.put(Integer.valueOf(20005), Integer.valueOf(2857));
          list.put(Integer.valueOf(20006), Integer.valueOf(2857));
          list.put(Integer.valueOf(22009), Integer.valueOf(2857));
          list.put(Integer.valueOf(22010), Integer.valueOf(2857));
          list.put(Integer.valueOf(22011), Integer.valueOf(1905));
          list.put(Integer.valueOf(22012), Integer.valueOf(1905));
          list.put(Integer.valueOf(22013), Integer.valueOf(2857));
          list.put(Integer.valueOf(22041), Integer.valueOf(1905));
          list.put(Integer.valueOf(22042), Integer.valueOf(1905));
          list.put(Integer.valueOf(22043), Integer.valueOf(1905));
          list.put(Integer.valueOf(22044), Integer.valueOf(1905));
          list.put(Integer.valueOf(22045), Integer.valueOf(2857));
          list.put(Integer.valueOf(22046), Integer.valueOf(2857));
          list.put(Integer.valueOf(22054), Integer.valueOf(2857));
          list.put(Integer.valueOf(22086), Integer.valueOf(1905));
        }
        break;
    }
    return list;
  }
  
  public static Map<Integer, Integer> getUniqueOption(int type, int num)
  {
    Map<Integer, Integer> list = new HashMap<>();
    switch (type)
    {
      case 1300:
        if (num == 1)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(69767));
          list.put(Integer.valueOf(32046), Integer.valueOf(69767));
          list.put(Integer.valueOf(32051), Integer.valueOf(46512));
          list.put(Integer.valueOf(32053), Integer.valueOf(46512));
          list.put(Integer.valueOf(32057), Integer.valueOf(46512));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(23256));
          list.put(Integer.valueOf(32087), Integer.valueOf(46512));
          list.put(Integer.valueOf(32091), Integer.valueOf(46512));
          list.put(Integer.valueOf(32092), Integer.valueOf(46512));
          list.put(Integer.valueOf(32093), Integer.valueOf(46512));
          list.put(Integer.valueOf(32094), Integer.valueOf(46512));
          list.put(Integer.valueOf(32201), Integer.valueOf(69767));
          list.put(Integer.valueOf(32206), Integer.valueOf(69767));
          list.put(Integer.valueOf(32291), Integer.valueOf(23256));
          list.put(Integer.valueOf(32601), Integer.valueOf(23256));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(86505));
          list.put(Integer.valueOf(22046), Integer.valueOf(86505));
          list.put(Integer.valueOf(22051), Integer.valueOf(57670));
          list.put(Integer.valueOf(22052), Integer.valueOf(57670));
          list.put(Integer.valueOf(22055), Integer.valueOf(28835));
          list.put(Integer.valueOf(22057), Integer.valueOf(86505));
          list.put(Integer.valueOf(22058), Integer.valueOf(86505));
          list.put(Integer.valueOf(22059), Integer.valueOf(86505));
          list.put(Integer.valueOf(22060), Integer.valueOf(86505));
          list.put(Integer.valueOf(22070), Integer.valueOf(28835));
          list.put(Integer.valueOf(22087), Integer.valueOf(57670));
          list.put(Integer.valueOf(22201), Integer.valueOf(86505));
          list.put(Integer.valueOf(22206), Integer.valueOf(86505));
          list.put(Integer.valueOf(22291), Integer.valueOf(57670));
          list.put(Integer.valueOf(32045), Integer.valueOf(1368));
          list.put(Integer.valueOf(32046), Integer.valueOf(1368));
          list.put(Integer.valueOf(32051), Integer.valueOf(912));
          list.put(Integer.valueOf(32053), Integer.valueOf(912));
          list.put(Integer.valueOf(32057), Integer.valueOf(912));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(456));
          list.put(Integer.valueOf(32087), Integer.valueOf(912));
          list.put(Integer.valueOf(32091), Integer.valueOf(912));
          list.put(Integer.valueOf(32092), Integer.valueOf(912));
          list.put(Integer.valueOf(32093), Integer.valueOf(912));
          list.put(Integer.valueOf(32094), Integer.valueOf(912));
          list.put(Integer.valueOf(22401), Integer.valueOf(1368));
          list.put(Integer.valueOf(22406), Integer.valueOf(1368));
          list.put(Integer.valueOf(32291), Integer.valueOf(456));
          list.put(Integer.valueOf(32601), Integer.valueOf(456));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(86505));
          list.put(Integer.valueOf(22046), Integer.valueOf(86505));
          list.put(Integer.valueOf(22051), Integer.valueOf(57670));
          list.put(Integer.valueOf(22052), Integer.valueOf(57670));
          list.put(Integer.valueOf(22055), Integer.valueOf(28835));
          list.put(Integer.valueOf(22057), Integer.valueOf(86505));
          list.put(Integer.valueOf(22058), Integer.valueOf(86505));
          list.put(Integer.valueOf(22059), Integer.valueOf(86505));
          list.put(Integer.valueOf(22060), Integer.valueOf(86505));
          list.put(Integer.valueOf(22070), Integer.valueOf(28835));
          list.put(Integer.valueOf(22087), Integer.valueOf(57670));
          list.put(Integer.valueOf(22201), Integer.valueOf(86505));
          list.put(Integer.valueOf(22206), Integer.valueOf(86505));
          list.put(Integer.valueOf(22291), Integer.valueOf(57670));
          list.put(Integer.valueOf(32045), Integer.valueOf(1368));
          list.put(Integer.valueOf(32046), Integer.valueOf(1368));
          list.put(Integer.valueOf(32051), Integer.valueOf(912));
          list.put(Integer.valueOf(32053), Integer.valueOf(912));
          list.put(Integer.valueOf(32057), Integer.valueOf(912));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(456));
          list.put(Integer.valueOf(32087), Integer.valueOf(912));
          list.put(Integer.valueOf(32091), Integer.valueOf(912));
          list.put(Integer.valueOf(32092), Integer.valueOf(912));
          list.put(Integer.valueOf(32093), Integer.valueOf(912));
          list.put(Integer.valueOf(32094), Integer.valueOf(912));
          list.put(Integer.valueOf(22401), Integer.valueOf(1368));
          list.put(Integer.valueOf(22406), Integer.valueOf(1368));
          list.put(Integer.valueOf(32291), Integer.valueOf(456));
          list.put(Integer.valueOf(32601), Integer.valueOf(456));
        }
        break;
      case 1301:
        if (num == 1)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53571));
          list.put(Integer.valueOf(30002), Integer.valueOf(53571));
          list.put(Integer.valueOf(30003), Integer.valueOf(53571));
          list.put(Integer.valueOf(30004), Integer.valueOf(53571));
          list.put(Integer.valueOf(30005), Integer.valueOf(53571));
          list.put(Integer.valueOf(30006), Integer.valueOf(53571));
          list.put(Integer.valueOf(32011), Integer.valueOf(35714));
          list.put(Integer.valueOf(32012), Integer.valueOf(35714));
          list.put(Integer.valueOf(32014), Integer.valueOf(53571));
          list.put(Integer.valueOf(32041), Integer.valueOf(35714));
          list.put(Integer.valueOf(32042), Integer.valueOf(35714));
          list.put(Integer.valueOf(32043), Integer.valueOf(35714));
          list.put(Integer.valueOf(32044), Integer.valueOf(35714));
          list.put(Integer.valueOf(32045), Integer.valueOf(53571));
          list.put(Integer.valueOf(32046), Integer.valueOf(53571));
          list.put(Integer.valueOf(32055), Integer.valueOf(53571));
          list.put(Integer.valueOf(32086), Integer.valueOf(35714));
          list.put(Integer.valueOf(32091), Integer.valueOf(35714));
          list.put(Integer.valueOf(32092), Integer.valueOf(35714));
          list.put(Integer.valueOf(32093), Integer.valueOf(35714));
          list.put(Integer.valueOf(32094), Integer.valueOf(35714));
          list.put(Integer.valueOf(32111), Integer.valueOf(17857));
          list.put(Integer.valueOf(32551), Integer.valueOf(53571));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(58824));
          list.put(Integer.valueOf(20002), Integer.valueOf(58824));
          list.put(Integer.valueOf(20003), Integer.valueOf(58824));
          list.put(Integer.valueOf(20004), Integer.valueOf(58824));
          list.put(Integer.valueOf(20005), Integer.valueOf(58824));
          list.put(Integer.valueOf(20006), Integer.valueOf(58824));
          list.put(Integer.valueOf(22009), Integer.valueOf(58824));
          list.put(Integer.valueOf(22010), Integer.valueOf(58824));
          list.put(Integer.valueOf(22011), Integer.valueOf(39216));
          list.put(Integer.valueOf(22012), Integer.valueOf(39216));
          list.put(Integer.valueOf(22013), Integer.valueOf(58824));
          list.put(Integer.valueOf(22041), Integer.valueOf(39216));
          list.put(Integer.valueOf(22042), Integer.valueOf(39216));
          list.put(Integer.valueOf(22043), Integer.valueOf(39216));
          list.put(Integer.valueOf(22044), Integer.valueOf(39216));
          list.put(Integer.valueOf(22045), Integer.valueOf(58824));
          list.put(Integer.valueOf(22046), Integer.valueOf(58824));
          list.put(Integer.valueOf(22054), Integer.valueOf(58824));
          list.put(Integer.valueOf(22086), Integer.valueOf(39216));
          list.put(Integer.valueOf(30001), Integer.valueOf(1050));
          list.put(Integer.valueOf(30002), Integer.valueOf(1050));
          list.put(Integer.valueOf(30003), Integer.valueOf(1050));
          list.put(Integer.valueOf(30004), Integer.valueOf(1050));
          list.put(Integer.valueOf(30005), Integer.valueOf(1050));
          list.put(Integer.valueOf(30006), Integer.valueOf(1050));
          list.put(Integer.valueOf(32011), Integer.valueOf(700));
          list.put(Integer.valueOf(32012), Integer.valueOf(700));
          list.put(Integer.valueOf(32014), Integer.valueOf(1050));
          list.put(Integer.valueOf(32041), Integer.valueOf(700));
          list.put(Integer.valueOf(32042), Integer.valueOf(700));
          list.put(Integer.valueOf(32043), Integer.valueOf(700));
          list.put(Integer.valueOf(32044), Integer.valueOf(700));
          list.put(Integer.valueOf(32045), Integer.valueOf(1050));
          list.put(Integer.valueOf(32046), Integer.valueOf(1050));
          list.put(Integer.valueOf(32055), Integer.valueOf(1050));
          list.put(Integer.valueOf(32086), Integer.valueOf(700));
          list.put(Integer.valueOf(32091), Integer.valueOf(700));
          list.put(Integer.valueOf(32092), Integer.valueOf(700));
          list.put(Integer.valueOf(32093), Integer.valueOf(700));
          list.put(Integer.valueOf(32094), Integer.valueOf(700));
          list.put(Integer.valueOf(32111), Integer.valueOf(350));
          list.put(Integer.valueOf(32551), Integer.valueOf(1050));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(58824));
          list.put(Integer.valueOf(20002), Integer.valueOf(58824));
          list.put(Integer.valueOf(20003), Integer.valueOf(58824));
          list.put(Integer.valueOf(20004), Integer.valueOf(58824));
          list.put(Integer.valueOf(20005), Integer.valueOf(58824));
          list.put(Integer.valueOf(20006), Integer.valueOf(58824));
          list.put(Integer.valueOf(22009), Integer.valueOf(58824));
          list.put(Integer.valueOf(22010), Integer.valueOf(58824));
          list.put(Integer.valueOf(22011), Integer.valueOf(39216));
          list.put(Integer.valueOf(22012), Integer.valueOf(39216));
          list.put(Integer.valueOf(22013), Integer.valueOf(58824));
          list.put(Integer.valueOf(22041), Integer.valueOf(39216));
          list.put(Integer.valueOf(22042), Integer.valueOf(39216));
          list.put(Integer.valueOf(22043), Integer.valueOf(39216));
          list.put(Integer.valueOf(22044), Integer.valueOf(39216));
          list.put(Integer.valueOf(22045), Integer.valueOf(58824));
          list.put(Integer.valueOf(22046), Integer.valueOf(58824));
          list.put(Integer.valueOf(22054), Integer.valueOf(58824));
          list.put(Integer.valueOf(22086), Integer.valueOf(39216));
          list.put(Integer.valueOf(30001), Integer.valueOf(1050));
          list.put(Integer.valueOf(30002), Integer.valueOf(1050));
          list.put(Integer.valueOf(30003), Integer.valueOf(1050));
          list.put(Integer.valueOf(30004), Integer.valueOf(1050));
          list.put(Integer.valueOf(30005), Integer.valueOf(1050));
          list.put(Integer.valueOf(30006), Integer.valueOf(1050));
          list.put(Integer.valueOf(32011), Integer.valueOf(700));
          list.put(Integer.valueOf(32012), Integer.valueOf(700));
          list.put(Integer.valueOf(32014), Integer.valueOf(1050));
          list.put(Integer.valueOf(32041), Integer.valueOf(700));
          list.put(Integer.valueOf(32042), Integer.valueOf(700));
          list.put(Integer.valueOf(32043), Integer.valueOf(700));
          list.put(Integer.valueOf(32044), Integer.valueOf(700));
          list.put(Integer.valueOf(32045), Integer.valueOf(1050));
          list.put(Integer.valueOf(32046), Integer.valueOf(1050));
          list.put(Integer.valueOf(32055), Integer.valueOf(1050));
          list.put(Integer.valueOf(32086), Integer.valueOf(700));
          list.put(Integer.valueOf(32091), Integer.valueOf(700));
          list.put(Integer.valueOf(32092), Integer.valueOf(700));
          list.put(Integer.valueOf(32093), Integer.valueOf(700));
          list.put(Integer.valueOf(32094), Integer.valueOf(700));
          list.put(Integer.valueOf(32111), Integer.valueOf(350));
          list.put(Integer.valueOf(32551), Integer.valueOf(1050));
        }
        break;
      case 1302:
        if (num == 1)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(69767));
          list.put(Integer.valueOf(32046), Integer.valueOf(69767));
          list.put(Integer.valueOf(32051), Integer.valueOf(46512));
          list.put(Integer.valueOf(32053), Integer.valueOf(46512));
          list.put(Integer.valueOf(32057), Integer.valueOf(46512));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(23256));
          list.put(Integer.valueOf(32087), Integer.valueOf(46512));
          list.put(Integer.valueOf(32091), Integer.valueOf(46512));
          list.put(Integer.valueOf(32092), Integer.valueOf(46512));
          list.put(Integer.valueOf(32093), Integer.valueOf(46512));
          list.put(Integer.valueOf(32094), Integer.valueOf(46512));
          list.put(Integer.valueOf(32201), Integer.valueOf(69767));
          list.put(Integer.valueOf(32206), Integer.valueOf(69767));
          list.put(Integer.valueOf(32291), Integer.valueOf(23256));
          list.put(Integer.valueOf(32601), Integer.valueOf(23256));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(86505));
          list.put(Integer.valueOf(22046), Integer.valueOf(86505));
          list.put(Integer.valueOf(22051), Integer.valueOf(57670));
          list.put(Integer.valueOf(22052), Integer.valueOf(57670));
          list.put(Integer.valueOf(22055), Integer.valueOf(28835));
          list.put(Integer.valueOf(22057), Integer.valueOf(86505));
          list.put(Integer.valueOf(22058), Integer.valueOf(86505));
          list.put(Integer.valueOf(22059), Integer.valueOf(86505));
          list.put(Integer.valueOf(22060), Integer.valueOf(86505));
          list.put(Integer.valueOf(22070), Integer.valueOf(28835));
          list.put(Integer.valueOf(22087), Integer.valueOf(57670));
          list.put(Integer.valueOf(22201), Integer.valueOf(86505));
          list.put(Integer.valueOf(22206), Integer.valueOf(86505));
          list.put(Integer.valueOf(22291), Integer.valueOf(57670));
          list.put(Integer.valueOf(32045), Integer.valueOf(1368));
          list.put(Integer.valueOf(32046), Integer.valueOf(1368));
          list.put(Integer.valueOf(32051), Integer.valueOf(912));
          list.put(Integer.valueOf(32053), Integer.valueOf(912));
          list.put(Integer.valueOf(32057), Integer.valueOf(912));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(456));
          list.put(Integer.valueOf(32087), Integer.valueOf(912));
          list.put(Integer.valueOf(32091), Integer.valueOf(912));
          list.put(Integer.valueOf(32092), Integer.valueOf(912));
          list.put(Integer.valueOf(32093), Integer.valueOf(912));
          list.put(Integer.valueOf(32094), Integer.valueOf(912));
          list.put(Integer.valueOf(32201), Integer.valueOf(1368));
          list.put(Integer.valueOf(32206), Integer.valueOf(1368));
          list.put(Integer.valueOf(32291), Integer.valueOf(456));
          list.put(Integer.valueOf(32601), Integer.valueOf(456));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(86505));
          list.put(Integer.valueOf(22046), Integer.valueOf(86505));
          list.put(Integer.valueOf(22051), Integer.valueOf(57670));
          list.put(Integer.valueOf(22052), Integer.valueOf(57670));
          list.put(Integer.valueOf(22055), Integer.valueOf(28835));
          list.put(Integer.valueOf(22057), Integer.valueOf(86505));
          list.put(Integer.valueOf(22058), Integer.valueOf(86505));
          list.put(Integer.valueOf(22059), Integer.valueOf(86505));
          list.put(Integer.valueOf(22060), Integer.valueOf(86505));
          list.put(Integer.valueOf(22070), Integer.valueOf(28835));
          list.put(Integer.valueOf(22087), Integer.valueOf(57670));
          list.put(Integer.valueOf(22201), Integer.valueOf(86505));
          list.put(Integer.valueOf(22206), Integer.valueOf(86505));
          list.put(Integer.valueOf(22291), Integer.valueOf(57670));
          list.put(Integer.valueOf(32045), Integer.valueOf(1368));
          list.put(Integer.valueOf(32046), Integer.valueOf(1368));
          list.put(Integer.valueOf(32051), Integer.valueOf(912));
          list.put(Integer.valueOf(32053), Integer.valueOf(912));
          list.put(Integer.valueOf(32057), Integer.valueOf(912));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(456));
          list.put(Integer.valueOf(32087), Integer.valueOf(912));
          list.put(Integer.valueOf(32091), Integer.valueOf(912));
          list.put(Integer.valueOf(32092), Integer.valueOf(912));
          list.put(Integer.valueOf(32093), Integer.valueOf(912));
          list.put(Integer.valueOf(32094), Integer.valueOf(912));
          list.put(Integer.valueOf(32201), Integer.valueOf(1368));
          list.put(Integer.valueOf(32206), Integer.valueOf(1368));
          list.put(Integer.valueOf(32291), Integer.valueOf(456));
          list.put(Integer.valueOf(32601), Integer.valueOf(456));
        }
        break;
      case 1303:
        if (num == 1)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(69767));
          list.put(Integer.valueOf(32046), Integer.valueOf(69767));
          list.put(Integer.valueOf(32051), Integer.valueOf(46512));
          list.put(Integer.valueOf(32053), Integer.valueOf(46512));
          list.put(Integer.valueOf(32057), Integer.valueOf(46512));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(23256));
          list.put(Integer.valueOf(32087), Integer.valueOf(46512));
          list.put(Integer.valueOf(32091), Integer.valueOf(46512));
          list.put(Integer.valueOf(32092), Integer.valueOf(46512));
          list.put(Integer.valueOf(32093), Integer.valueOf(46512));
          list.put(Integer.valueOf(32094), Integer.valueOf(46512));
          list.put(Integer.valueOf(32201), Integer.valueOf(69767));
          list.put(Integer.valueOf(32206), Integer.valueOf(69767));
          list.put(Integer.valueOf(32291), Integer.valueOf(23256));
          list.put(Integer.valueOf(32601), Integer.valueOf(23256));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(86505));
          list.put(Integer.valueOf(22046), Integer.valueOf(86505));
          list.put(Integer.valueOf(22051), Integer.valueOf(57670));
          list.put(Integer.valueOf(22052), Integer.valueOf(57670));
          list.put(Integer.valueOf(22055), Integer.valueOf(28835));
          list.put(Integer.valueOf(22057), Integer.valueOf(86505));
          list.put(Integer.valueOf(22058), Integer.valueOf(86505));
          list.put(Integer.valueOf(22059), Integer.valueOf(86505));
          list.put(Integer.valueOf(22060), Integer.valueOf(86505));
          list.put(Integer.valueOf(22070), Integer.valueOf(28835));
          list.put(Integer.valueOf(22087), Integer.valueOf(57670));
          list.put(Integer.valueOf(22201), Integer.valueOf(86505));
          list.put(Integer.valueOf(22206), Integer.valueOf(86505));
          list.put(Integer.valueOf(22291), Integer.valueOf(57670));
          list.put(Integer.valueOf(32045), Integer.valueOf(1368));
          list.put(Integer.valueOf(32046), Integer.valueOf(1368));
          list.put(Integer.valueOf(32051), Integer.valueOf(912));
          list.put(Integer.valueOf(32053), Integer.valueOf(912));
          list.put(Integer.valueOf(32057), Integer.valueOf(912));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(456));
          list.put(Integer.valueOf(32087), Integer.valueOf(912));
          list.put(Integer.valueOf(32091), Integer.valueOf(912));
          list.put(Integer.valueOf(32092), Integer.valueOf(912));
          list.put(Integer.valueOf(32093), Integer.valueOf(912));
          list.put(Integer.valueOf(32094), Integer.valueOf(912));
          list.put(Integer.valueOf(32201), Integer.valueOf(1368));
          list.put(Integer.valueOf(32206), Integer.valueOf(1368));
          list.put(Integer.valueOf(32291), Integer.valueOf(456));
          list.put(Integer.valueOf(32601), Integer.valueOf(456));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(86505));
          list.put(Integer.valueOf(22046), Integer.valueOf(86505));
          list.put(Integer.valueOf(22051), Integer.valueOf(57670));
          list.put(Integer.valueOf(22052), Integer.valueOf(57670));
          list.put(Integer.valueOf(22055), Integer.valueOf(28835));
          list.put(Integer.valueOf(22057), Integer.valueOf(86505));
          list.put(Integer.valueOf(22058), Integer.valueOf(86505));
          list.put(Integer.valueOf(22059), Integer.valueOf(86505));
          list.put(Integer.valueOf(22060), Integer.valueOf(86505));
          list.put(Integer.valueOf(22070), Integer.valueOf(28835));
          list.put(Integer.valueOf(22087), Integer.valueOf(57670));
          list.put(Integer.valueOf(22201), Integer.valueOf(86505));
          list.put(Integer.valueOf(22206), Integer.valueOf(86505));
          list.put(Integer.valueOf(22291), Integer.valueOf(57670));
          list.put(Integer.valueOf(32045), Integer.valueOf(1368));
          list.put(Integer.valueOf(32046), Integer.valueOf(1368));
          list.put(Integer.valueOf(32051), Integer.valueOf(912));
          list.put(Integer.valueOf(32053), Integer.valueOf(912));
          list.put(Integer.valueOf(32057), Integer.valueOf(912));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(456));
          list.put(Integer.valueOf(32087), Integer.valueOf(912));
          list.put(Integer.valueOf(32091), Integer.valueOf(912));
          list.put(Integer.valueOf(32092), Integer.valueOf(912));
          list.put(Integer.valueOf(32093), Integer.valueOf(912));
          list.put(Integer.valueOf(32094), Integer.valueOf(912));
          list.put(Integer.valueOf(32201), Integer.valueOf(1368));
          list.put(Integer.valueOf(32206), Integer.valueOf(1368));
          list.put(Integer.valueOf(32291), Integer.valueOf(456));
          list.put(Integer.valueOf(32601), Integer.valueOf(456));
        }
        break;
      case 1304:
        if (num == 1)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53571));
          list.put(Integer.valueOf(30002), Integer.valueOf(53571));
          list.put(Integer.valueOf(30003), Integer.valueOf(53571));
          list.put(Integer.valueOf(30004), Integer.valueOf(53571));
          list.put(Integer.valueOf(30005), Integer.valueOf(53571));
          list.put(Integer.valueOf(30006), Integer.valueOf(53571));
          list.put(Integer.valueOf(32011), Integer.valueOf(35714));
          list.put(Integer.valueOf(32012), Integer.valueOf(35714));
          list.put(Integer.valueOf(32014), Integer.valueOf(53571));
          list.put(Integer.valueOf(32041), Integer.valueOf(35714));
          list.put(Integer.valueOf(32042), Integer.valueOf(35714));
          list.put(Integer.valueOf(32043), Integer.valueOf(35714));
          list.put(Integer.valueOf(32044), Integer.valueOf(35714));
          list.put(Integer.valueOf(32045), Integer.valueOf(53571));
          list.put(Integer.valueOf(32046), Integer.valueOf(53571));
          list.put(Integer.valueOf(32055), Integer.valueOf(53571));
          list.put(Integer.valueOf(32086), Integer.valueOf(35714));
          list.put(Integer.valueOf(32091), Integer.valueOf(35714));
          list.put(Integer.valueOf(32092), Integer.valueOf(35714));
          list.put(Integer.valueOf(32093), Integer.valueOf(35714));
          list.put(Integer.valueOf(32094), Integer.valueOf(35714));
          list.put(Integer.valueOf(32111), Integer.valueOf(17857));
          list.put(Integer.valueOf(32551), Integer.valueOf(53571));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(58824));
          list.put(Integer.valueOf(20002), Integer.valueOf(58824));
          list.put(Integer.valueOf(20003), Integer.valueOf(58824));
          list.put(Integer.valueOf(20004), Integer.valueOf(58824));
          list.put(Integer.valueOf(20005), Integer.valueOf(58824));
          list.put(Integer.valueOf(20006), Integer.valueOf(58824));
          list.put(Integer.valueOf(22009), Integer.valueOf(58824));
          list.put(Integer.valueOf(22010), Integer.valueOf(58824));
          list.put(Integer.valueOf(22011), Integer.valueOf(39216));
          list.put(Integer.valueOf(22012), Integer.valueOf(39216));
          list.put(Integer.valueOf(22013), Integer.valueOf(58824));
          list.put(Integer.valueOf(22041), Integer.valueOf(39216));
          list.put(Integer.valueOf(22042), Integer.valueOf(39216));
          list.put(Integer.valueOf(22043), Integer.valueOf(39216));
          list.put(Integer.valueOf(22044), Integer.valueOf(39216));
          list.put(Integer.valueOf(22045), Integer.valueOf(58824));
          list.put(Integer.valueOf(22046), Integer.valueOf(58824));
          list.put(Integer.valueOf(22054), Integer.valueOf(58824));
          list.put(Integer.valueOf(22086), Integer.valueOf(39216));
          list.put(Integer.valueOf(30001), Integer.valueOf(1050));
          list.put(Integer.valueOf(30002), Integer.valueOf(1050));
          list.put(Integer.valueOf(30003), Integer.valueOf(1050));
          list.put(Integer.valueOf(30004), Integer.valueOf(1050));
          list.put(Integer.valueOf(30005), Integer.valueOf(1050));
          list.put(Integer.valueOf(30006), Integer.valueOf(1050));
          list.put(Integer.valueOf(32011), Integer.valueOf(700));
          list.put(Integer.valueOf(32012), Integer.valueOf(700));
          list.put(Integer.valueOf(32014), Integer.valueOf(1050));
          list.put(Integer.valueOf(32041), Integer.valueOf(700));
          list.put(Integer.valueOf(32042), Integer.valueOf(700));
          list.put(Integer.valueOf(32043), Integer.valueOf(700));
          list.put(Integer.valueOf(32044), Integer.valueOf(700));
          list.put(Integer.valueOf(32045), Integer.valueOf(1050));
          list.put(Integer.valueOf(32046), Integer.valueOf(1050));
          list.put(Integer.valueOf(32055), Integer.valueOf(1050));
          list.put(Integer.valueOf(32086), Integer.valueOf(700));
          list.put(Integer.valueOf(32091), Integer.valueOf(700));
          list.put(Integer.valueOf(32092), Integer.valueOf(700));
          list.put(Integer.valueOf(32093), Integer.valueOf(700));
          list.put(Integer.valueOf(32094), Integer.valueOf(700));
          list.put(Integer.valueOf(32111), Integer.valueOf(350));
          list.put(Integer.valueOf(32551), Integer.valueOf(1050));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(58824));
          list.put(Integer.valueOf(20002), Integer.valueOf(58824));
          list.put(Integer.valueOf(20003), Integer.valueOf(58824));
          list.put(Integer.valueOf(20004), Integer.valueOf(58824));
          list.put(Integer.valueOf(20005), Integer.valueOf(58824));
          list.put(Integer.valueOf(20006), Integer.valueOf(58824));
          list.put(Integer.valueOf(22009), Integer.valueOf(58824));
          list.put(Integer.valueOf(22010), Integer.valueOf(58824));
          list.put(Integer.valueOf(22011), Integer.valueOf(39216));
          list.put(Integer.valueOf(22012), Integer.valueOf(39216));
          list.put(Integer.valueOf(22013), Integer.valueOf(58824));
          list.put(Integer.valueOf(22041), Integer.valueOf(39216));
          list.put(Integer.valueOf(22042), Integer.valueOf(39216));
          list.put(Integer.valueOf(22043), Integer.valueOf(39216));
          list.put(Integer.valueOf(22044), Integer.valueOf(39216));
          list.put(Integer.valueOf(22045), Integer.valueOf(58824));
          list.put(Integer.valueOf(22046), Integer.valueOf(58824));
          list.put(Integer.valueOf(22054), Integer.valueOf(58824));
          list.put(Integer.valueOf(22086), Integer.valueOf(39216));
          list.put(Integer.valueOf(30001), Integer.valueOf(1050));
          list.put(Integer.valueOf(30002), Integer.valueOf(1050));
          list.put(Integer.valueOf(30003), Integer.valueOf(1050));
          list.put(Integer.valueOf(30004), Integer.valueOf(1050));
          list.put(Integer.valueOf(30005), Integer.valueOf(1050));
          list.put(Integer.valueOf(30006), Integer.valueOf(1050));
          list.put(Integer.valueOf(32011), Integer.valueOf(700));
          list.put(Integer.valueOf(32012), Integer.valueOf(700));
          list.put(Integer.valueOf(32014), Integer.valueOf(1050));
          list.put(Integer.valueOf(32041), Integer.valueOf(700));
          list.put(Integer.valueOf(32042), Integer.valueOf(700));
          list.put(Integer.valueOf(32043), Integer.valueOf(700));
          list.put(Integer.valueOf(32044), Integer.valueOf(700));
          list.put(Integer.valueOf(32045), Integer.valueOf(1050));
          list.put(Integer.valueOf(32046), Integer.valueOf(1050));
          list.put(Integer.valueOf(32055), Integer.valueOf(1050));
          list.put(Integer.valueOf(32086), Integer.valueOf(700));
          list.put(Integer.valueOf(32091), Integer.valueOf(700));
          list.put(Integer.valueOf(32092), Integer.valueOf(700));
          list.put(Integer.valueOf(32093), Integer.valueOf(700));
          list.put(Integer.valueOf(32094), Integer.valueOf(700));
          list.put(Integer.valueOf(32111), Integer.valueOf(350));
          list.put(Integer.valueOf(32551), Integer.valueOf(1050));
        }
        break;
      case 1309:
        if (num == 1)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53571));
          list.put(Integer.valueOf(30002), Integer.valueOf(53571));
          list.put(Integer.valueOf(30003), Integer.valueOf(53571));
          list.put(Integer.valueOf(30004), Integer.valueOf(53571));
          list.put(Integer.valueOf(30005), Integer.valueOf(53571));
          list.put(Integer.valueOf(30006), Integer.valueOf(53571));
          list.put(Integer.valueOf(32011), Integer.valueOf(35714));
          list.put(Integer.valueOf(32012), Integer.valueOf(35714));
          list.put(Integer.valueOf(32014), Integer.valueOf(53571));
          list.put(Integer.valueOf(32041), Integer.valueOf(35714));
          list.put(Integer.valueOf(32042), Integer.valueOf(35714));
          list.put(Integer.valueOf(32043), Integer.valueOf(35714));
          list.put(Integer.valueOf(32044), Integer.valueOf(35714));
          list.put(Integer.valueOf(32045), Integer.valueOf(53571));
          list.put(Integer.valueOf(32046), Integer.valueOf(53571));
          list.put(Integer.valueOf(32055), Integer.valueOf(53571));
          list.put(Integer.valueOf(32086), Integer.valueOf(35714));
          list.put(Integer.valueOf(32091), Integer.valueOf(35714));
          list.put(Integer.valueOf(32092), Integer.valueOf(35714));
          list.put(Integer.valueOf(32093), Integer.valueOf(35714));
          list.put(Integer.valueOf(32094), Integer.valueOf(35714));
          list.put(Integer.valueOf(32111), Integer.valueOf(17857));
          list.put(Integer.valueOf(32551), Integer.valueOf(53571));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(58824));
          list.put(Integer.valueOf(20002), Integer.valueOf(58824));
          list.put(Integer.valueOf(20003), Integer.valueOf(58824));
          list.put(Integer.valueOf(20004), Integer.valueOf(58824));
          list.put(Integer.valueOf(20005), Integer.valueOf(58824));
          list.put(Integer.valueOf(20006), Integer.valueOf(58824));
          list.put(Integer.valueOf(22009), Integer.valueOf(58824));
          list.put(Integer.valueOf(22010), Integer.valueOf(58824));
          list.put(Integer.valueOf(22011), Integer.valueOf(39216));
          list.put(Integer.valueOf(22012), Integer.valueOf(39216));
          list.put(Integer.valueOf(22013), Integer.valueOf(58824));
          list.put(Integer.valueOf(22041), Integer.valueOf(39216));
          list.put(Integer.valueOf(22042), Integer.valueOf(39216));
          list.put(Integer.valueOf(22043), Integer.valueOf(39216));
          list.put(Integer.valueOf(22044), Integer.valueOf(39216));
          list.put(Integer.valueOf(22045), Integer.valueOf(58824));
          list.put(Integer.valueOf(22046), Integer.valueOf(58824));
          list.put(Integer.valueOf(22054), Integer.valueOf(58824));
          list.put(Integer.valueOf(22086), Integer.valueOf(39216));
          list.put(Integer.valueOf(30001), Integer.valueOf(1050));
          list.put(Integer.valueOf(30002), Integer.valueOf(1050));
          list.put(Integer.valueOf(30003), Integer.valueOf(1050));
          list.put(Integer.valueOf(30004), Integer.valueOf(1050));
          list.put(Integer.valueOf(30005), Integer.valueOf(1050));
          list.put(Integer.valueOf(30006), Integer.valueOf(1050));
          list.put(Integer.valueOf(32011), Integer.valueOf(700));
          list.put(Integer.valueOf(32012), Integer.valueOf(700));
          list.put(Integer.valueOf(32014), Integer.valueOf(1050));
          list.put(Integer.valueOf(32041), Integer.valueOf(700));
          list.put(Integer.valueOf(32042), Integer.valueOf(700));
          list.put(Integer.valueOf(32043), Integer.valueOf(700));
          list.put(Integer.valueOf(32044), Integer.valueOf(700));
          list.put(Integer.valueOf(32045), Integer.valueOf(1050));
          list.put(Integer.valueOf(32046), Integer.valueOf(1050));
          list.put(Integer.valueOf(32055), Integer.valueOf(1050));
          list.put(Integer.valueOf(32086), Integer.valueOf(700));
          list.put(Integer.valueOf(32091), Integer.valueOf(700));
          list.put(Integer.valueOf(32092), Integer.valueOf(700));
          list.put(Integer.valueOf(32093), Integer.valueOf(700));
          list.put(Integer.valueOf(32094), Integer.valueOf(700));
          list.put(Integer.valueOf(32111), Integer.valueOf(350));
          list.put(Integer.valueOf(32551), Integer.valueOf(1050));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(58824));
          list.put(Integer.valueOf(20002), Integer.valueOf(58824));
          list.put(Integer.valueOf(20003), Integer.valueOf(58824));
          list.put(Integer.valueOf(20004), Integer.valueOf(58824));
          list.put(Integer.valueOf(20005), Integer.valueOf(58824));
          list.put(Integer.valueOf(20006), Integer.valueOf(58824));
          list.put(Integer.valueOf(22009), Integer.valueOf(58824));
          list.put(Integer.valueOf(22010), Integer.valueOf(58824));
          list.put(Integer.valueOf(22011), Integer.valueOf(39216));
          list.put(Integer.valueOf(22012), Integer.valueOf(39216));
          list.put(Integer.valueOf(22013), Integer.valueOf(58824));
          list.put(Integer.valueOf(22041), Integer.valueOf(39216));
          list.put(Integer.valueOf(22042), Integer.valueOf(39216));
          list.put(Integer.valueOf(22043), Integer.valueOf(39216));
          list.put(Integer.valueOf(22044), Integer.valueOf(39216));
          list.put(Integer.valueOf(22045), Integer.valueOf(58824));
          list.put(Integer.valueOf(22046), Integer.valueOf(58824));
          list.put(Integer.valueOf(22054), Integer.valueOf(58824));
          list.put(Integer.valueOf(22086), Integer.valueOf(39216));
          list.put(Integer.valueOf(30001), Integer.valueOf(1050));
          list.put(Integer.valueOf(30002), Integer.valueOf(1050));
          list.put(Integer.valueOf(30003), Integer.valueOf(1050));
          list.put(Integer.valueOf(30004), Integer.valueOf(1050));
          list.put(Integer.valueOf(30005), Integer.valueOf(1050));
          list.put(Integer.valueOf(30006), Integer.valueOf(1050));
          list.put(Integer.valueOf(32011), Integer.valueOf(700));
          list.put(Integer.valueOf(32012), Integer.valueOf(700));
          list.put(Integer.valueOf(32014), Integer.valueOf(1050));
          list.put(Integer.valueOf(32041), Integer.valueOf(700));
          list.put(Integer.valueOf(32042), Integer.valueOf(700));
          list.put(Integer.valueOf(32043), Integer.valueOf(700));
          list.put(Integer.valueOf(32044), Integer.valueOf(700));
          list.put(Integer.valueOf(32045), Integer.valueOf(1050));
          list.put(Integer.valueOf(32046), Integer.valueOf(1050));
          list.put(Integer.valueOf(32055), Integer.valueOf(1050));
          list.put(Integer.valueOf(32086), Integer.valueOf(700));
          list.put(Integer.valueOf(32091), Integer.valueOf(700));
          list.put(Integer.valueOf(32092), Integer.valueOf(700));
          list.put(Integer.valueOf(32093), Integer.valueOf(700));
          list.put(Integer.valueOf(32094), Integer.valueOf(700));
          list.put(Integer.valueOf(32111), Integer.valueOf(350));
          list.put(Integer.valueOf(32551), Integer.valueOf(1050));
        }
        break;
      case 1305:
        if (num == 1)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(71429));
          list.put(Integer.valueOf(32046), Integer.valueOf(71429));
          list.put(Integer.valueOf(32051), Integer.valueOf(47619));
          list.put(Integer.valueOf(32053), Integer.valueOf(47619));
          list.put(Integer.valueOf(32057), Integer.valueOf(47619));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(23810));
          list.put(Integer.valueOf(32087), Integer.valueOf(47619));
          list.put(Integer.valueOf(32091), Integer.valueOf(47619));
          list.put(Integer.valueOf(32092), Integer.valueOf(47619));
          list.put(Integer.valueOf(32093), Integer.valueOf(47619));
          list.put(Integer.valueOf(32094), Integer.valueOf(47619));
          list.put(Integer.valueOf(32201), Integer.valueOf(71429));
          list.put(Integer.valueOf(32206), Integer.valueOf(71429));
          list.put(Integer.valueOf(32291), Integer.valueOf(23810));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(86505));
          list.put(Integer.valueOf(22046), Integer.valueOf(86505));
          list.put(Integer.valueOf(22051), Integer.valueOf(57670));
          list.put(Integer.valueOf(22052), Integer.valueOf(57670));
          list.put(Integer.valueOf(22055), Integer.valueOf(28835));
          list.put(Integer.valueOf(22057), Integer.valueOf(86505));
          list.put(Integer.valueOf(22058), Integer.valueOf(86505));
          list.put(Integer.valueOf(22059), Integer.valueOf(86505));
          list.put(Integer.valueOf(22060), Integer.valueOf(86505));
          list.put(Integer.valueOf(22070), Integer.valueOf(28835));
          list.put(Integer.valueOf(22087), Integer.valueOf(57670));
          list.put(Integer.valueOf(22201), Integer.valueOf(86505));
          list.put(Integer.valueOf(22206), Integer.valueOf(86505));
          list.put(Integer.valueOf(22291), Integer.valueOf(57670));
          list.put(Integer.valueOf(32045), Integer.valueOf(1401));
          list.put(Integer.valueOf(32046), Integer.valueOf(1401));
          list.put(Integer.valueOf(32051), Integer.valueOf(934));
          list.put(Integer.valueOf(32053), Integer.valueOf(934));
          list.put(Integer.valueOf(32057), Integer.valueOf(934));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(467));
          list.put(Integer.valueOf(32086), Integer.valueOf(934));
          list.put(Integer.valueOf(32091), Integer.valueOf(934));
          list.put(Integer.valueOf(32092), Integer.valueOf(934));
          list.put(Integer.valueOf(32093), Integer.valueOf(934));
          list.put(Integer.valueOf(32094), Integer.valueOf(934));
          list.put(Integer.valueOf(32201), Integer.valueOf(1401));
          list.put(Integer.valueOf(32206), Integer.valueOf(1401));
          list.put(Integer.valueOf(32291), Integer.valueOf(467));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(86505));
          list.put(Integer.valueOf(22046), Integer.valueOf(86505));
          list.put(Integer.valueOf(22051), Integer.valueOf(57670));
          list.put(Integer.valueOf(22052), Integer.valueOf(57670));
          list.put(Integer.valueOf(22055), Integer.valueOf(28835));
          list.put(Integer.valueOf(22057), Integer.valueOf(86505));
          list.put(Integer.valueOf(22058), Integer.valueOf(86505));
          list.put(Integer.valueOf(22059), Integer.valueOf(86505));
          list.put(Integer.valueOf(22060), Integer.valueOf(86505));
          list.put(Integer.valueOf(22070), Integer.valueOf(28835));
          list.put(Integer.valueOf(22087), Integer.valueOf(57670));
          list.put(Integer.valueOf(22201), Integer.valueOf(86505));
          list.put(Integer.valueOf(22206), Integer.valueOf(86505));
          list.put(Integer.valueOf(22291), Integer.valueOf(57670));
          list.put(Integer.valueOf(32045), Integer.valueOf(1401));
          list.put(Integer.valueOf(32046), Integer.valueOf(1401));
          list.put(Integer.valueOf(32051), Integer.valueOf(934));
          list.put(Integer.valueOf(32053), Integer.valueOf(934));
          list.put(Integer.valueOf(32057), Integer.valueOf(934));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(467));
          list.put(Integer.valueOf(32086), Integer.valueOf(934));
          list.put(Integer.valueOf(32091), Integer.valueOf(934));
          list.put(Integer.valueOf(32092), Integer.valueOf(934));
          list.put(Integer.valueOf(32093), Integer.valueOf(934));
          list.put(Integer.valueOf(32094), Integer.valueOf(934));
          list.put(Integer.valueOf(32201), Integer.valueOf(1401));
          list.put(Integer.valueOf(32206), Integer.valueOf(1401));
          list.put(Integer.valueOf(32291), Integer.valueOf(467));
        }
        break;
      case 1306:
        if (num == 1)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53571));
          list.put(Integer.valueOf(30002), Integer.valueOf(53571));
          list.put(Integer.valueOf(30003), Integer.valueOf(53571));
          list.put(Integer.valueOf(30004), Integer.valueOf(53571));
          list.put(Integer.valueOf(30005), Integer.valueOf(53571));
          list.put(Integer.valueOf(30006), Integer.valueOf(53571));
          list.put(Integer.valueOf(32011), Integer.valueOf(35714));
          list.put(Integer.valueOf(32012), Integer.valueOf(35714));
          list.put(Integer.valueOf(32014), Integer.valueOf(53571));
          list.put(Integer.valueOf(32041), Integer.valueOf(35714));
          list.put(Integer.valueOf(32042), Integer.valueOf(35714));
          list.put(Integer.valueOf(32043), Integer.valueOf(35714));
          list.put(Integer.valueOf(32044), Integer.valueOf(35714));
          list.put(Integer.valueOf(32045), Integer.valueOf(53571));
          list.put(Integer.valueOf(32046), Integer.valueOf(53571));
          list.put(Integer.valueOf(32055), Integer.valueOf(53571));
          list.put(Integer.valueOf(32086), Integer.valueOf(35714));
          list.put(Integer.valueOf(32091), Integer.valueOf(35714));
          list.put(Integer.valueOf(32092), Integer.valueOf(35714));
          list.put(Integer.valueOf(32093), Integer.valueOf(35714));
          list.put(Integer.valueOf(32094), Integer.valueOf(35714));
          list.put(Integer.valueOf(32111), Integer.valueOf(17857));
          list.put(Integer.valueOf(32551), Integer.valueOf(53571));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(58824));
          list.put(Integer.valueOf(20002), Integer.valueOf(58824));
          list.put(Integer.valueOf(20003), Integer.valueOf(58824));
          list.put(Integer.valueOf(20004), Integer.valueOf(58824));
          list.put(Integer.valueOf(20005), Integer.valueOf(58824));
          list.put(Integer.valueOf(20006), Integer.valueOf(58824));
          list.put(Integer.valueOf(22009), Integer.valueOf(58824));
          list.put(Integer.valueOf(22010), Integer.valueOf(58824));
          list.put(Integer.valueOf(22011), Integer.valueOf(39216));
          list.put(Integer.valueOf(22012), Integer.valueOf(39216));
          list.put(Integer.valueOf(22013), Integer.valueOf(58824));
          list.put(Integer.valueOf(22041), Integer.valueOf(39216));
          list.put(Integer.valueOf(22042), Integer.valueOf(39216));
          list.put(Integer.valueOf(22043), Integer.valueOf(39216));
          list.put(Integer.valueOf(22044), Integer.valueOf(39216));
          list.put(Integer.valueOf(22045), Integer.valueOf(58824));
          list.put(Integer.valueOf(22046), Integer.valueOf(58824));
          list.put(Integer.valueOf(22054), Integer.valueOf(58824));
          list.put(Integer.valueOf(22086), Integer.valueOf(39216));
          list.put(Integer.valueOf(30001), Integer.valueOf(1050));
          list.put(Integer.valueOf(30002), Integer.valueOf(1050));
          list.put(Integer.valueOf(30003), Integer.valueOf(1050));
          list.put(Integer.valueOf(30004), Integer.valueOf(1050));
          list.put(Integer.valueOf(30005), Integer.valueOf(1050));
          list.put(Integer.valueOf(30006), Integer.valueOf(1050));
          list.put(Integer.valueOf(32011), Integer.valueOf(700));
          list.put(Integer.valueOf(32012), Integer.valueOf(700));
          list.put(Integer.valueOf(32014), Integer.valueOf(1050));
          list.put(Integer.valueOf(32041), Integer.valueOf(700));
          list.put(Integer.valueOf(32042), Integer.valueOf(700));
          list.put(Integer.valueOf(32043), Integer.valueOf(700));
          list.put(Integer.valueOf(32044), Integer.valueOf(700));
          list.put(Integer.valueOf(32045), Integer.valueOf(1050));
          list.put(Integer.valueOf(32046), Integer.valueOf(1050));
          list.put(Integer.valueOf(32055), Integer.valueOf(1050));
          list.put(Integer.valueOf(32086), Integer.valueOf(700));
          list.put(Integer.valueOf(32091), Integer.valueOf(700));
          list.put(Integer.valueOf(32092), Integer.valueOf(700));
          list.put(Integer.valueOf(32093), Integer.valueOf(700));
          list.put(Integer.valueOf(32094), Integer.valueOf(700));
          list.put(Integer.valueOf(32111), Integer.valueOf(350));
          list.put(Integer.valueOf(32551), Integer.valueOf(1050));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(58824));
          list.put(Integer.valueOf(20002), Integer.valueOf(58824));
          list.put(Integer.valueOf(20003), Integer.valueOf(58824));
          list.put(Integer.valueOf(20004), Integer.valueOf(58824));
          list.put(Integer.valueOf(20005), Integer.valueOf(58824));
          list.put(Integer.valueOf(20006), Integer.valueOf(58824));
          list.put(Integer.valueOf(22009), Integer.valueOf(58824));
          list.put(Integer.valueOf(22010), Integer.valueOf(58824));
          list.put(Integer.valueOf(22011), Integer.valueOf(39216));
          list.put(Integer.valueOf(22012), Integer.valueOf(39216));
          list.put(Integer.valueOf(22013), Integer.valueOf(58824));
          list.put(Integer.valueOf(22041), Integer.valueOf(39216));
          list.put(Integer.valueOf(22042), Integer.valueOf(39216));
          list.put(Integer.valueOf(22043), Integer.valueOf(39216));
          list.put(Integer.valueOf(22044), Integer.valueOf(39216));
          list.put(Integer.valueOf(22045), Integer.valueOf(58824));
          list.put(Integer.valueOf(22046), Integer.valueOf(58824));
          list.put(Integer.valueOf(22054), Integer.valueOf(58824));
          list.put(Integer.valueOf(22086), Integer.valueOf(39216));
          list.put(Integer.valueOf(30001), Integer.valueOf(1050));
          list.put(Integer.valueOf(30002), Integer.valueOf(1050));
          list.put(Integer.valueOf(30003), Integer.valueOf(1050));
          list.put(Integer.valueOf(30004), Integer.valueOf(1050));
          list.put(Integer.valueOf(30005), Integer.valueOf(1050));
          list.put(Integer.valueOf(30006), Integer.valueOf(1050));
          list.put(Integer.valueOf(32011), Integer.valueOf(700));
          list.put(Integer.valueOf(32012), Integer.valueOf(700));
          list.put(Integer.valueOf(32014), Integer.valueOf(1050));
          list.put(Integer.valueOf(32041), Integer.valueOf(700));
          list.put(Integer.valueOf(32042), Integer.valueOf(700));
          list.put(Integer.valueOf(32043), Integer.valueOf(700));
          list.put(Integer.valueOf(32044), Integer.valueOf(700));
          list.put(Integer.valueOf(32045), Integer.valueOf(1050));
          list.put(Integer.valueOf(32046), Integer.valueOf(1050));
          list.put(Integer.valueOf(32055), Integer.valueOf(1050));
          list.put(Integer.valueOf(32086), Integer.valueOf(700));
          list.put(Integer.valueOf(32091), Integer.valueOf(700));
          list.put(Integer.valueOf(32092), Integer.valueOf(700));
          list.put(Integer.valueOf(32093), Integer.valueOf(700));
          list.put(Integer.valueOf(32094), Integer.valueOf(700));
          list.put(Integer.valueOf(32111), Integer.valueOf(350));
          list.put(Integer.valueOf(32551), Integer.valueOf(1050));
        }
        break;
      case 1307:
        if (num == 1)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(69767));
          list.put(Integer.valueOf(32046), Integer.valueOf(69767));
          list.put(Integer.valueOf(32051), Integer.valueOf(46512));
          list.put(Integer.valueOf(32053), Integer.valueOf(46512));
          list.put(Integer.valueOf(32057), Integer.valueOf(46512));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(23256));
          list.put(Integer.valueOf(32087), Integer.valueOf(46512));
          list.put(Integer.valueOf(32091), Integer.valueOf(46512));
          list.put(Integer.valueOf(32092), Integer.valueOf(46512));
          list.put(Integer.valueOf(32093), Integer.valueOf(46512));
          list.put(Integer.valueOf(32094), Integer.valueOf(46512));
          list.put(Integer.valueOf(32201), Integer.valueOf(69767));
          list.put(Integer.valueOf(32206), Integer.valueOf(69767));
          list.put(Integer.valueOf(32291), Integer.valueOf(23256));
          list.put(Integer.valueOf(32601), Integer.valueOf(23256));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(86505));
          list.put(Integer.valueOf(22046), Integer.valueOf(86505));
          list.put(Integer.valueOf(22051), Integer.valueOf(57670));
          list.put(Integer.valueOf(22052), Integer.valueOf(57670));
          list.put(Integer.valueOf(22055), Integer.valueOf(28835));
          list.put(Integer.valueOf(22057), Integer.valueOf(86505));
          list.put(Integer.valueOf(22058), Integer.valueOf(86505));
          list.put(Integer.valueOf(22059), Integer.valueOf(86505));
          list.put(Integer.valueOf(22060), Integer.valueOf(86505));
          list.put(Integer.valueOf(22070), Integer.valueOf(28835));
          list.put(Integer.valueOf(22087), Integer.valueOf(57670));
          list.put(Integer.valueOf(22201), Integer.valueOf(86505));
          list.put(Integer.valueOf(22206), Integer.valueOf(86505));
          list.put(Integer.valueOf(22291), Integer.valueOf(57670));
          list.put(Integer.valueOf(32045), Integer.valueOf(1368));
          list.put(Integer.valueOf(32046), Integer.valueOf(1368));
          list.put(Integer.valueOf(32051), Integer.valueOf(912));
          list.put(Integer.valueOf(32053), Integer.valueOf(912));
          list.put(Integer.valueOf(32057), Integer.valueOf(912));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(456));
          list.put(Integer.valueOf(32087), Integer.valueOf(912));
          list.put(Integer.valueOf(32091), Integer.valueOf(912));
          list.put(Integer.valueOf(32092), Integer.valueOf(912));
          list.put(Integer.valueOf(32093), Integer.valueOf(912));
          list.put(Integer.valueOf(32094), Integer.valueOf(912));
          list.put(Integer.valueOf(32201), Integer.valueOf(1368));
          list.put(Integer.valueOf(32206), Integer.valueOf(1368));
          list.put(Integer.valueOf(32291), Integer.valueOf(456));
          list.put(Integer.valueOf(32601), Integer.valueOf(456));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(22045), Integer.valueOf(86505));
          list.put(Integer.valueOf(22046), Integer.valueOf(86505));
          list.put(Integer.valueOf(22051), Integer.valueOf(57670));
          list.put(Integer.valueOf(22052), Integer.valueOf(57670));
          list.put(Integer.valueOf(22055), Integer.valueOf(28835));
          list.put(Integer.valueOf(22057), Integer.valueOf(86505));
          list.put(Integer.valueOf(22058), Integer.valueOf(86505));
          list.put(Integer.valueOf(22059), Integer.valueOf(86505));
          list.put(Integer.valueOf(22060), Integer.valueOf(86505));
          list.put(Integer.valueOf(22070), Integer.valueOf(28835));
          list.put(Integer.valueOf(22087), Integer.valueOf(57670));
          list.put(Integer.valueOf(22201), Integer.valueOf(86505));
          list.put(Integer.valueOf(22206), Integer.valueOf(86505));
          list.put(Integer.valueOf(22291), Integer.valueOf(57670));
          list.put(Integer.valueOf(32045), Integer.valueOf(1368));
          list.put(Integer.valueOf(32046), Integer.valueOf(1368));
          list.put(Integer.valueOf(32051), Integer.valueOf(912));
          list.put(Integer.valueOf(32053), Integer.valueOf(912));
          list.put(Integer.valueOf(32057), Integer.valueOf(912));
          list.put(Integer.valueOf(32059), Integer.valueOf(69767));
          list.put(Integer.valueOf(32060), Integer.valueOf(69767));
          list.put(Integer.valueOf(32061), Integer.valueOf(69767));
          list.put(Integer.valueOf(32062), Integer.valueOf(69767));
          list.put(Integer.valueOf(32070), Integer.valueOf(456));
          list.put(Integer.valueOf(32087), Integer.valueOf(912));
          list.put(Integer.valueOf(32091), Integer.valueOf(912));
          list.put(Integer.valueOf(32092), Integer.valueOf(912));
          list.put(Integer.valueOf(32093), Integer.valueOf(912));
          list.put(Integer.valueOf(32094), Integer.valueOf(912));
          list.put(Integer.valueOf(32201), Integer.valueOf(1368));
          list.put(Integer.valueOf(32206), Integer.valueOf(1368));
          list.put(Integer.valueOf(32291), Integer.valueOf(456));
          list.put(Integer.valueOf(32601), Integer.valueOf(456));
        }
        break;
      case 1308:
        if (num == 1)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53571));
          list.put(Integer.valueOf(30002), Integer.valueOf(53571));
          list.put(Integer.valueOf(30003), Integer.valueOf(53571));
          list.put(Integer.valueOf(30004), Integer.valueOf(53571));
          list.put(Integer.valueOf(30005), Integer.valueOf(53571));
          list.put(Integer.valueOf(30006), Integer.valueOf(53571));
          list.put(Integer.valueOf(32011), Integer.valueOf(35714));
          list.put(Integer.valueOf(32012), Integer.valueOf(35714));
          list.put(Integer.valueOf(32014), Integer.valueOf(53571));
          list.put(Integer.valueOf(32041), Integer.valueOf(35714));
          list.put(Integer.valueOf(32042), Integer.valueOf(35714));
          list.put(Integer.valueOf(32043), Integer.valueOf(35714));
          list.put(Integer.valueOf(32044), Integer.valueOf(35714));
          list.put(Integer.valueOf(32045), Integer.valueOf(53571));
          list.put(Integer.valueOf(32046), Integer.valueOf(53571));
          list.put(Integer.valueOf(32055), Integer.valueOf(53571));
          list.put(Integer.valueOf(32086), Integer.valueOf(35714));
          list.put(Integer.valueOf(32091), Integer.valueOf(35714));
          list.put(Integer.valueOf(32092), Integer.valueOf(35714));
          list.put(Integer.valueOf(32093), Integer.valueOf(35714));
          list.put(Integer.valueOf(32094), Integer.valueOf(35714));
          list.put(Integer.valueOf(32111), Integer.valueOf(17857));
          list.put(Integer.valueOf(32551), Integer.valueOf(53571));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(58824));
          list.put(Integer.valueOf(20002), Integer.valueOf(58824));
          list.put(Integer.valueOf(20003), Integer.valueOf(58824));
          list.put(Integer.valueOf(20004), Integer.valueOf(58824));
          list.put(Integer.valueOf(20005), Integer.valueOf(58824));
          list.put(Integer.valueOf(20006), Integer.valueOf(58824));
          list.put(Integer.valueOf(22009), Integer.valueOf(58824));
          list.put(Integer.valueOf(22010), Integer.valueOf(58824));
          list.put(Integer.valueOf(22011), Integer.valueOf(39216));
          list.put(Integer.valueOf(22012), Integer.valueOf(39216));
          list.put(Integer.valueOf(22013), Integer.valueOf(58824));
          list.put(Integer.valueOf(22041), Integer.valueOf(39216));
          list.put(Integer.valueOf(22042), Integer.valueOf(39216));
          list.put(Integer.valueOf(22043), Integer.valueOf(39216));
          list.put(Integer.valueOf(22044), Integer.valueOf(39216));
          list.put(Integer.valueOf(22045), Integer.valueOf(58824));
          list.put(Integer.valueOf(22046), Integer.valueOf(58824));
          list.put(Integer.valueOf(22054), Integer.valueOf(58824));
          list.put(Integer.valueOf(22086), Integer.valueOf(39216));
          list.put(Integer.valueOf(30001), Integer.valueOf(1050));
          list.put(Integer.valueOf(30002), Integer.valueOf(1050));
          list.put(Integer.valueOf(30003), Integer.valueOf(1050));
          list.put(Integer.valueOf(30004), Integer.valueOf(1050));
          list.put(Integer.valueOf(30005), Integer.valueOf(1050));
          list.put(Integer.valueOf(30006), Integer.valueOf(1050));
          list.put(Integer.valueOf(32011), Integer.valueOf(700));
          list.put(Integer.valueOf(32012), Integer.valueOf(700));
          list.put(Integer.valueOf(32014), Integer.valueOf(1050));
          list.put(Integer.valueOf(32041), Integer.valueOf(700));
          list.put(Integer.valueOf(32042), Integer.valueOf(700));
          list.put(Integer.valueOf(32043), Integer.valueOf(700));
          list.put(Integer.valueOf(32044), Integer.valueOf(700));
          list.put(Integer.valueOf(32045), Integer.valueOf(1050));
          list.put(Integer.valueOf(32046), Integer.valueOf(1050));
          list.put(Integer.valueOf(32055), Integer.valueOf(1050));
          list.put(Integer.valueOf(32086), Integer.valueOf(700));
          list.put(Integer.valueOf(32091), Integer.valueOf(700));
          list.put(Integer.valueOf(32092), Integer.valueOf(700));
          list.put(Integer.valueOf(32093), Integer.valueOf(700));
          list.put(Integer.valueOf(32094), Integer.valueOf(700));
          list.put(Integer.valueOf(32111), Integer.valueOf(350));
          list.put(Integer.valueOf(32551), Integer.valueOf(1050));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(20001), Integer.valueOf(58824));
          list.put(Integer.valueOf(20002), Integer.valueOf(58824));
          list.put(Integer.valueOf(20003), Integer.valueOf(58824));
          list.put(Integer.valueOf(20004), Integer.valueOf(58824));
          list.put(Integer.valueOf(20005), Integer.valueOf(58824));
          list.put(Integer.valueOf(20006), Integer.valueOf(58824));
          list.put(Integer.valueOf(22009), Integer.valueOf(58824));
          list.put(Integer.valueOf(22010), Integer.valueOf(58824));
          list.put(Integer.valueOf(22011), Integer.valueOf(39216));
          list.put(Integer.valueOf(22012), Integer.valueOf(39216));
          list.put(Integer.valueOf(22013), Integer.valueOf(58824));
          list.put(Integer.valueOf(22041), Integer.valueOf(39216));
          list.put(Integer.valueOf(22042), Integer.valueOf(39216));
          list.put(Integer.valueOf(22043), Integer.valueOf(39216));
          list.put(Integer.valueOf(22044), Integer.valueOf(39216));
          list.put(Integer.valueOf(22045), Integer.valueOf(58824));
          list.put(Integer.valueOf(22046), Integer.valueOf(58824));
          list.put(Integer.valueOf(22054), Integer.valueOf(58824));
          list.put(Integer.valueOf(22086), Integer.valueOf(39216));
          list.put(Integer.valueOf(30001), Integer.valueOf(1050));
          list.put(Integer.valueOf(30002), Integer.valueOf(1050));
          list.put(Integer.valueOf(30003), Integer.valueOf(1050));
          list.put(Integer.valueOf(30004), Integer.valueOf(1050));
          list.put(Integer.valueOf(30005), Integer.valueOf(1050));
          list.put(Integer.valueOf(30006), Integer.valueOf(1050));
          list.put(Integer.valueOf(32011), Integer.valueOf(700));
          list.put(Integer.valueOf(32012), Integer.valueOf(700));
          list.put(Integer.valueOf(32014), Integer.valueOf(1050));
          list.put(Integer.valueOf(32041), Integer.valueOf(700));
          list.put(Integer.valueOf(32042), Integer.valueOf(700));
          list.put(Integer.valueOf(32043), Integer.valueOf(700));
          list.put(Integer.valueOf(32044), Integer.valueOf(700));
          list.put(Integer.valueOf(32045), Integer.valueOf(1050));
          list.put(Integer.valueOf(32046), Integer.valueOf(1050));
          list.put(Integer.valueOf(32055), Integer.valueOf(1050));
          list.put(Integer.valueOf(32086), Integer.valueOf(700));
          list.put(Integer.valueOf(32091), Integer.valueOf(700));
          list.put(Integer.valueOf(32092), Integer.valueOf(700));
          list.put(Integer.valueOf(32093), Integer.valueOf(700));
          list.put(Integer.valueOf(32094), Integer.valueOf(700));
          list.put(Integer.valueOf(32111), Integer.valueOf(350));
          list.put(Integer.valueOf(32551), Integer.valueOf(1050));
        }
        break;
    }
    return list;
  }
  
  public static Map<Integer, Integer> getLegendaryOption(int type, int num)
  {
    Map<Integer, Integer> list = new HashMap<>();
    switch (type)
    {
      case 1300:
        if (num == 1)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(75000));
          list.put(Integer.valueOf(42046), Integer.valueOf(75000));
          list.put(Integer.valueOf(42051), Integer.valueOf(50000));
          list.put(Integer.valueOf(42053), Integer.valueOf(50000));
          list.put(Integer.valueOf(42057), Integer.valueOf(50000));
          list.put(Integer.valueOf(42063), Integer.valueOf(75000));
          list.put(Integer.valueOf(42064), Integer.valueOf(75000));
          list.put(Integer.valueOf(42065), Integer.valueOf(75000));
          list.put(Integer.valueOf(42066), Integer.valueOf(75000));
          list.put(Integer.valueOf(42070), Integer.valueOf(25000));
          list.put(Integer.valueOf(42087), Integer.valueOf(50000));
          list.put(Integer.valueOf(42091), Integer.valueOf(50000));
          list.put(Integer.valueOf(42092), Integer.valueOf(50000));
          list.put(Integer.valueOf(42093), Integer.valueOf(50000));
          list.put(Integer.valueOf(42094), Integer.valueOf(50000));
          list.put(Integer.valueOf(42095), Integer.valueOf(25000));
          list.put(Integer.valueOf(42096), Integer.valueOf(25000));
          list.put(Integer.valueOf(42801), Integer.valueOf(25000));
          list.put(Integer.valueOf(42292), Integer.valueOf(25000));
          list.put(Integer.valueOf(42602), Integer.valueOf(25000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(69420));
          list.put(Integer.valueOf(32046), Integer.valueOf(69420));
          list.put(Integer.valueOf(32051), Integer.valueOf(46280));
          list.put(Integer.valueOf(32053), Integer.valueOf(46280));
          list.put(Integer.valueOf(32057), Integer.valueOf(46280));
          list.put(Integer.valueOf(32059), Integer.valueOf(69420));
          list.put(Integer.valueOf(32060), Integer.valueOf(69420));
          list.put(Integer.valueOf(32061), Integer.valueOf(69420));
          list.put(Integer.valueOf(32062), Integer.valueOf(69420));
          list.put(Integer.valueOf(32070), Integer.valueOf(23140));
          list.put(Integer.valueOf(32087), Integer.valueOf(46280));
          list.put(Integer.valueOf(32091), Integer.valueOf(46280));
          list.put(Integer.valueOf(32092), Integer.valueOf(46280));
          list.put(Integer.valueOf(32093), Integer.valueOf(46280));
          list.put(Integer.valueOf(32094), Integer.valueOf(46280));
          list.put(Integer.valueOf(32201), Integer.valueOf(69420));
          list.put(Integer.valueOf(32206), Integer.valueOf(69420));
          list.put(Integer.valueOf(32291), Integer.valueOf(23140));
          list.put(Integer.valueOf(32601), Integer.valueOf(23140));
          list.put(Integer.valueOf(42045), Integer.valueOf(373));
          list.put(Integer.valueOf(42046), Integer.valueOf(373));
          list.put(Integer.valueOf(42051), Integer.valueOf(249));
          list.put(Integer.valueOf(42053), Integer.valueOf(249));
          list.put(Integer.valueOf(42057), Integer.valueOf(249));
          list.put(Integer.valueOf(42063), Integer.valueOf(373));
          list.put(Integer.valueOf(42064), Integer.valueOf(373));
          list.put(Integer.valueOf(42064), Integer.valueOf(373));
          list.put(Integer.valueOf(42064), Integer.valueOf(373));
          list.put(Integer.valueOf(42070), Integer.valueOf(124));
          list.put(Integer.valueOf(42087), Integer.valueOf(249));
          list.put(Integer.valueOf(42091), Integer.valueOf(249));
          list.put(Integer.valueOf(42092), Integer.valueOf(249));
          list.put(Integer.valueOf(42093), Integer.valueOf(249));
          list.put(Integer.valueOf(42094), Integer.valueOf(249));
          list.put(Integer.valueOf(42095), Integer.valueOf(124));
          list.put(Integer.valueOf(42096), Integer.valueOf(124));
          list.put(Integer.valueOf(42801), Integer.valueOf(124));
          list.put(Integer.valueOf(42292), Integer.valueOf(124));
          list.put(Integer.valueOf(42602), Integer.valueOf(124));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(69420));
          list.put(Integer.valueOf(32046), Integer.valueOf(69420));
          list.put(Integer.valueOf(32051), Integer.valueOf(46280));
          list.put(Integer.valueOf(32053), Integer.valueOf(46280));
          list.put(Integer.valueOf(32057), Integer.valueOf(46280));
          list.put(Integer.valueOf(32059), Integer.valueOf(69420));
          list.put(Integer.valueOf(32060), Integer.valueOf(69420));
          list.put(Integer.valueOf(32061), Integer.valueOf(69420));
          list.put(Integer.valueOf(32062), Integer.valueOf(69420));
          list.put(Integer.valueOf(32070), Integer.valueOf(23140));
          list.put(Integer.valueOf(32087), Integer.valueOf(46280));
          list.put(Integer.valueOf(32091), Integer.valueOf(46280));
          list.put(Integer.valueOf(32092), Integer.valueOf(46280));
          list.put(Integer.valueOf(32093), Integer.valueOf(46280));
          list.put(Integer.valueOf(32094), Integer.valueOf(46280));
          list.put(Integer.valueOf(32201), Integer.valueOf(69420));
          list.put(Integer.valueOf(32206), Integer.valueOf(69420));
          list.put(Integer.valueOf(32291), Integer.valueOf(23140));
          list.put(Integer.valueOf(32601), Integer.valueOf(23140));
          list.put(Integer.valueOf(42045), Integer.valueOf(373));
          list.put(Integer.valueOf(42046), Integer.valueOf(373));
          list.put(Integer.valueOf(42051), Integer.valueOf(249));
          list.put(Integer.valueOf(42053), Integer.valueOf(249));
          list.put(Integer.valueOf(42057), Integer.valueOf(249));
          list.put(Integer.valueOf(42063), Integer.valueOf(373));
          list.put(Integer.valueOf(42064), Integer.valueOf(373));
          list.put(Integer.valueOf(42064), Integer.valueOf(373));
          list.put(Integer.valueOf(42064), Integer.valueOf(373));
          list.put(Integer.valueOf(42070), Integer.valueOf(124));
          list.put(Integer.valueOf(42087), Integer.valueOf(249));
          list.put(Integer.valueOf(42091), Integer.valueOf(249));
          list.put(Integer.valueOf(42092), Integer.valueOf(249));
          list.put(Integer.valueOf(42093), Integer.valueOf(249));
          list.put(Integer.valueOf(42094), Integer.valueOf(249));
          list.put(Integer.valueOf(42095), Integer.valueOf(124));
          list.put(Integer.valueOf(42096), Integer.valueOf(124));
          list.put(Integer.valueOf(42801), Integer.valueOf(124));
          list.put(Integer.valueOf(42292), Integer.valueOf(124));
          list.put(Integer.valueOf(42602), Integer.valueOf(124));
        }
        break;
      case 1301:
        if (num == 1)
        {
          list.put(Integer.valueOf(40001), Integer.valueOf(44118));
          list.put(Integer.valueOf(40002), Integer.valueOf(44118));
          list.put(Integer.valueOf(40003), Integer.valueOf(44118));
          list.put(Integer.valueOf(40004), Integer.valueOf(44118));
          list.put(Integer.valueOf(40005), Integer.valueOf(44118));
          list.put(Integer.valueOf(40006), Integer.valueOf(44118));
          list.put(Integer.valueOf(42011), Integer.valueOf(29412));
          list.put(Integer.valueOf(42012), Integer.valueOf(29412));
          list.put(Integer.valueOf(42013), Integer.valueOf(44118));
          list.put(Integer.valueOf(42041), Integer.valueOf(29412));
          list.put(Integer.valueOf(42042), Integer.valueOf(29412));
          list.put(Integer.valueOf(42043), Integer.valueOf(29412));
          list.put(Integer.valueOf(42044), Integer.valueOf(29412));
          list.put(Integer.valueOf(42045), Integer.valueOf(44118));
          list.put(Integer.valueOf(42046), Integer.valueOf(44118));
          list.put(Integer.valueOf(42055), Integer.valueOf(44118));
          list.put(Integer.valueOf(42060), Integer.valueOf(14706));
          list.put(Integer.valueOf(42086), Integer.valueOf(29412));
          list.put(Integer.valueOf(42091), Integer.valueOf(29412));
          list.put(Integer.valueOf(42092), Integer.valueOf(29412));
          list.put(Integer.valueOf(42093), Integer.valueOf(29412));
          list.put(Integer.valueOf(42094), Integer.valueOf(29412));
          list.put(Integer.valueOf(42094), Integer.valueOf(14706));
          list.put(Integer.valueOf(42802), Integer.valueOf(14706));
          list.put(Integer.valueOf(42551), Integer.valueOf(44118));
          list.put(Integer.valueOf(42556), Integer.valueOf(44118));
          list.put(Integer.valueOf(42650), Integer.valueOf(44118));
          list.put(Integer.valueOf(42656), Integer.valueOf(44118));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53305));
          list.put(Integer.valueOf(30002), Integer.valueOf(53305));
          list.put(Integer.valueOf(30003), Integer.valueOf(53305));
          list.put(Integer.valueOf(30004), Integer.valueOf(53305));
          list.put(Integer.valueOf(30005), Integer.valueOf(53305));
          list.put(Integer.valueOf(30006), Integer.valueOf(53305));
          list.put(Integer.valueOf(32011), Integer.valueOf(35537));
          list.put(Integer.valueOf(32012), Integer.valueOf(35537));
          list.put(Integer.valueOf(32014), Integer.valueOf(53305));
          list.put(Integer.valueOf(32041), Integer.valueOf(35537));
          list.put(Integer.valueOf(32042), Integer.valueOf(35537));
          list.put(Integer.valueOf(32043), Integer.valueOf(35537));
          list.put(Integer.valueOf(32044), Integer.valueOf(35537));
          list.put(Integer.valueOf(32045), Integer.valueOf(53305));
          list.put(Integer.valueOf(32046), Integer.valueOf(53305));
          list.put(Integer.valueOf(32055), Integer.valueOf(35537));
          list.put(Integer.valueOf(32086), Integer.valueOf(35537));
          list.put(Integer.valueOf(32091), Integer.valueOf(35537));
          list.put(Integer.valueOf(32092), Integer.valueOf(35537));
          list.put(Integer.valueOf(32093), Integer.valueOf(35537));
          list.put(Integer.valueOf(32094), Integer.valueOf(35537));
          list.put(Integer.valueOf(32111), Integer.valueOf(17768));
          list.put(Integer.valueOf(32551), Integer.valueOf(53305));
          list.put(Integer.valueOf(40001), Integer.valueOf(219));
          list.put(Integer.valueOf(40002), Integer.valueOf(219));
          list.put(Integer.valueOf(40003), Integer.valueOf(219));
          list.put(Integer.valueOf(40004), Integer.valueOf(219));
          list.put(Integer.valueOf(40005), Integer.valueOf(219));
          list.put(Integer.valueOf(40006), Integer.valueOf(219));
          list.put(Integer.valueOf(42011), Integer.valueOf(146));
          list.put(Integer.valueOf(42012), Integer.valueOf(146));
          list.put(Integer.valueOf(42013), Integer.valueOf(219));
          list.put(Integer.valueOf(42041), Integer.valueOf(146));
          list.put(Integer.valueOf(42042), Integer.valueOf(146));
          list.put(Integer.valueOf(42043), Integer.valueOf(146));
          list.put(Integer.valueOf(42044), Integer.valueOf(146));
          list.put(Integer.valueOf(42045), Integer.valueOf(219));
          list.put(Integer.valueOf(42046), Integer.valueOf(219));
          list.put(Integer.valueOf(42055), Integer.valueOf(219));
          list.put(Integer.valueOf(42060), Integer.valueOf(73));
          list.put(Integer.valueOf(42086), Integer.valueOf(146));
          list.put(Integer.valueOf(42091), Integer.valueOf(146));
          list.put(Integer.valueOf(42092), Integer.valueOf(146));
          list.put(Integer.valueOf(42093), Integer.valueOf(146));
          list.put(Integer.valueOf(42094), Integer.valueOf(146));
          list.put(Integer.valueOf(42094), Integer.valueOf(73));
          list.put(Integer.valueOf(42802), Integer.valueOf(73));
          list.put(Integer.valueOf(42551), Integer.valueOf(219));
          list.put(Integer.valueOf(42556), Integer.valueOf(219));
          list.put(Integer.valueOf(42650), Integer.valueOf(219));
          list.put(Integer.valueOf(42656), Integer.valueOf(219));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53305));
          list.put(Integer.valueOf(30002), Integer.valueOf(53305));
          list.put(Integer.valueOf(30003), Integer.valueOf(53305));
          list.put(Integer.valueOf(30004), Integer.valueOf(53305));
          list.put(Integer.valueOf(30005), Integer.valueOf(53305));
          list.put(Integer.valueOf(30006), Integer.valueOf(53305));
          list.put(Integer.valueOf(32011), Integer.valueOf(35537));
          list.put(Integer.valueOf(32012), Integer.valueOf(35537));
          list.put(Integer.valueOf(32014), Integer.valueOf(53305));
          list.put(Integer.valueOf(32041), Integer.valueOf(35537));
          list.put(Integer.valueOf(32042), Integer.valueOf(35537));
          list.put(Integer.valueOf(32043), Integer.valueOf(35537));
          list.put(Integer.valueOf(32044), Integer.valueOf(35537));
          list.put(Integer.valueOf(32045), Integer.valueOf(53305));
          list.put(Integer.valueOf(32046), Integer.valueOf(53305));
          list.put(Integer.valueOf(32055), Integer.valueOf(35537));
          list.put(Integer.valueOf(32086), Integer.valueOf(35537));
          list.put(Integer.valueOf(32091), Integer.valueOf(35537));
          list.put(Integer.valueOf(32092), Integer.valueOf(35537));
          list.put(Integer.valueOf(32093), Integer.valueOf(35537));
          list.put(Integer.valueOf(32094), Integer.valueOf(35537));
          list.put(Integer.valueOf(32111), Integer.valueOf(17768));
          list.put(Integer.valueOf(32551), Integer.valueOf(53305));
          list.put(Integer.valueOf(40001), Integer.valueOf(219));
          list.put(Integer.valueOf(40002), Integer.valueOf(219));
          list.put(Integer.valueOf(40003), Integer.valueOf(219));
          list.put(Integer.valueOf(40004), Integer.valueOf(219));
          list.put(Integer.valueOf(40005), Integer.valueOf(219));
          list.put(Integer.valueOf(40006), Integer.valueOf(219));
          list.put(Integer.valueOf(42011), Integer.valueOf(146));
          list.put(Integer.valueOf(42012), Integer.valueOf(146));
          list.put(Integer.valueOf(42013), Integer.valueOf(219));
          list.put(Integer.valueOf(42041), Integer.valueOf(146));
          list.put(Integer.valueOf(42042), Integer.valueOf(146));
          list.put(Integer.valueOf(42043), Integer.valueOf(146));
          list.put(Integer.valueOf(42044), Integer.valueOf(146));
          list.put(Integer.valueOf(42045), Integer.valueOf(219));
          list.put(Integer.valueOf(42046), Integer.valueOf(219));
          list.put(Integer.valueOf(42055), Integer.valueOf(219));
          list.put(Integer.valueOf(42060), Integer.valueOf(73));
          list.put(Integer.valueOf(42086), Integer.valueOf(146));
          list.put(Integer.valueOf(42091), Integer.valueOf(146));
          list.put(Integer.valueOf(42092), Integer.valueOf(146));
          list.put(Integer.valueOf(42093), Integer.valueOf(146));
          list.put(Integer.valueOf(42094), Integer.valueOf(146));
          list.put(Integer.valueOf(42094), Integer.valueOf(73));
          list.put(Integer.valueOf(42802), Integer.valueOf(73));
          list.put(Integer.valueOf(42551), Integer.valueOf(219));
          list.put(Integer.valueOf(42556), Integer.valueOf(219));
          list.put(Integer.valueOf(42650), Integer.valueOf(219));
          list.put(Integer.valueOf(42656), Integer.valueOf(219));
        }
        break;
      case 1302:
        if (num == 1)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(71429));
          list.put(Integer.valueOf(42046), Integer.valueOf(71429));
          list.put(Integer.valueOf(42051), Integer.valueOf(47619));
          list.put(Integer.valueOf(42053), Integer.valueOf(47619));
          list.put(Integer.valueOf(42057), Integer.valueOf(47619));
          list.put(Integer.valueOf(42060), Integer.valueOf(23810));
          list.put(Integer.valueOf(42063), Integer.valueOf(71429));
          list.put(Integer.valueOf(42064), Integer.valueOf(71429));
          list.put(Integer.valueOf(42065), Integer.valueOf(71429));
          list.put(Integer.valueOf(42066), Integer.valueOf(71429));
          list.put(Integer.valueOf(42070), Integer.valueOf(23810));
          list.put(Integer.valueOf(42087), Integer.valueOf(47619));
          list.put(Integer.valueOf(42091), Integer.valueOf(47619));
          list.put(Integer.valueOf(42092), Integer.valueOf(47619));
          list.put(Integer.valueOf(42093), Integer.valueOf(47619));
          list.put(Integer.valueOf(42094), Integer.valueOf(47619));
          list.put(Integer.valueOf(42095), Integer.valueOf(23810));
          list.put(Integer.valueOf(42096), Integer.valueOf(23810));
          list.put(Integer.valueOf(42801), Integer.valueOf(23810));
          list.put(Integer.valueOf(42292), Integer.valueOf(23810));
          list.put(Integer.valueOf(42602), Integer.valueOf(23810));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(69420));
          list.put(Integer.valueOf(32046), Integer.valueOf(69420));
          list.put(Integer.valueOf(32051), Integer.valueOf(46280));
          list.put(Integer.valueOf(32053), Integer.valueOf(46280));
          list.put(Integer.valueOf(32057), Integer.valueOf(46280));
          list.put(Integer.valueOf(32059), Integer.valueOf(69420));
          list.put(Integer.valueOf(32060), Integer.valueOf(69420));
          list.put(Integer.valueOf(32061), Integer.valueOf(69420));
          list.put(Integer.valueOf(32062), Integer.valueOf(69420));
          list.put(Integer.valueOf(32070), Integer.valueOf(23140));
          list.put(Integer.valueOf(32086), Integer.valueOf(46280));
          list.put(Integer.valueOf(32091), Integer.valueOf(46280));
          list.put(Integer.valueOf(32092), Integer.valueOf(46280));
          list.put(Integer.valueOf(32093), Integer.valueOf(46280));
          list.put(Integer.valueOf(32094), Integer.valueOf(46280));
          list.put(Integer.valueOf(32201), Integer.valueOf(69420));
          list.put(Integer.valueOf(32206), Integer.valueOf(69420));
          list.put(Integer.valueOf(32291), Integer.valueOf(23140));
          list.put(Integer.valueOf(32601), Integer.valueOf(23140));
          list.put(Integer.valueOf(42045), Integer.valueOf(355));
          list.put(Integer.valueOf(42046), Integer.valueOf(355));
          list.put(Integer.valueOf(42051), Integer.valueOf(237));
          list.put(Integer.valueOf(42053), Integer.valueOf(237));
          list.put(Integer.valueOf(42057), Integer.valueOf(237));
          list.put(Integer.valueOf(42060), Integer.valueOf(118));
          list.put(Integer.valueOf(42063), Integer.valueOf(355));
          list.put(Integer.valueOf(42064), Integer.valueOf(355));
          list.put(Integer.valueOf(42065), Integer.valueOf(355));
          list.put(Integer.valueOf(42066), Integer.valueOf(355));
          list.put(Integer.valueOf(42070), Integer.valueOf(118));
          list.put(Integer.valueOf(42087), Integer.valueOf(237));
          list.put(Integer.valueOf(42091), Integer.valueOf(237));
          list.put(Integer.valueOf(42092), Integer.valueOf(237));
          list.put(Integer.valueOf(42093), Integer.valueOf(237));
          list.put(Integer.valueOf(42094), Integer.valueOf(237));
          list.put(Integer.valueOf(42095), Integer.valueOf(118));
          list.put(Integer.valueOf(42096), Integer.valueOf(118));
          list.put(Integer.valueOf(42801), Integer.valueOf(118));
          list.put(Integer.valueOf(42292), Integer.valueOf(118));
          list.put(Integer.valueOf(42602), Integer.valueOf(118));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(69420));
          list.put(Integer.valueOf(32046), Integer.valueOf(69420));
          list.put(Integer.valueOf(32051), Integer.valueOf(46280));
          list.put(Integer.valueOf(32053), Integer.valueOf(46280));
          list.put(Integer.valueOf(32057), Integer.valueOf(46280));
          list.put(Integer.valueOf(32059), Integer.valueOf(69420));
          list.put(Integer.valueOf(32060), Integer.valueOf(69420));
          list.put(Integer.valueOf(32061), Integer.valueOf(69420));
          list.put(Integer.valueOf(32062), Integer.valueOf(69420));
          list.put(Integer.valueOf(32070), Integer.valueOf(23140));
          list.put(Integer.valueOf(32086), Integer.valueOf(46280));
          list.put(Integer.valueOf(32091), Integer.valueOf(46280));
          list.put(Integer.valueOf(32092), Integer.valueOf(46280));
          list.put(Integer.valueOf(32093), Integer.valueOf(46280));
          list.put(Integer.valueOf(32094), Integer.valueOf(46280));
          list.put(Integer.valueOf(32201), Integer.valueOf(69420));
          list.put(Integer.valueOf(32206), Integer.valueOf(69420));
          list.put(Integer.valueOf(32291), Integer.valueOf(23140));
          list.put(Integer.valueOf(32601), Integer.valueOf(23140));
          list.put(Integer.valueOf(42045), Integer.valueOf(355));
          list.put(Integer.valueOf(42046), Integer.valueOf(355));
          list.put(Integer.valueOf(42051), Integer.valueOf(237));
          list.put(Integer.valueOf(42053), Integer.valueOf(237));
          list.put(Integer.valueOf(42057), Integer.valueOf(237));
          list.put(Integer.valueOf(42060), Integer.valueOf(118));
          list.put(Integer.valueOf(42063), Integer.valueOf(355));
          list.put(Integer.valueOf(42064), Integer.valueOf(355));
          list.put(Integer.valueOf(42065), Integer.valueOf(355));
          list.put(Integer.valueOf(42066), Integer.valueOf(355));
          list.put(Integer.valueOf(42070), Integer.valueOf(118));
          list.put(Integer.valueOf(42087), Integer.valueOf(237));
          list.put(Integer.valueOf(42091), Integer.valueOf(237));
          list.put(Integer.valueOf(42092), Integer.valueOf(237));
          list.put(Integer.valueOf(42093), Integer.valueOf(237));
          list.put(Integer.valueOf(42094), Integer.valueOf(237));
          list.put(Integer.valueOf(42095), Integer.valueOf(118));
          list.put(Integer.valueOf(42096), Integer.valueOf(118));
          list.put(Integer.valueOf(42801), Integer.valueOf(118));
          list.put(Integer.valueOf(42292), Integer.valueOf(118));
          list.put(Integer.valueOf(42602), Integer.valueOf(118));
        }
        break;
      case 1303:
        if (num == 1)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(71429));
          list.put(Integer.valueOf(42046), Integer.valueOf(71429));
          list.put(Integer.valueOf(42051), Integer.valueOf(47619));
          list.put(Integer.valueOf(42053), Integer.valueOf(47619));
          list.put(Integer.valueOf(42057), Integer.valueOf(47619));
          list.put(Integer.valueOf(42060), Integer.valueOf(23810));
          list.put(Integer.valueOf(42063), Integer.valueOf(71429));
          list.put(Integer.valueOf(42064), Integer.valueOf(71429));
          list.put(Integer.valueOf(42065), Integer.valueOf(71429));
          list.put(Integer.valueOf(42066), Integer.valueOf(71429));
          list.put(Integer.valueOf(42070), Integer.valueOf(23810));
          list.put(Integer.valueOf(42087), Integer.valueOf(47619));
          list.put(Integer.valueOf(42091), Integer.valueOf(47619));
          list.put(Integer.valueOf(42092), Integer.valueOf(47619));
          list.put(Integer.valueOf(42093), Integer.valueOf(47619));
          list.put(Integer.valueOf(42094), Integer.valueOf(47619));
          list.put(Integer.valueOf(42095), Integer.valueOf(23810));
          list.put(Integer.valueOf(42096), Integer.valueOf(23810));
          list.put(Integer.valueOf(42801), Integer.valueOf(23810));
          list.put(Integer.valueOf(42292), Integer.valueOf(23810));
          list.put(Integer.valueOf(42602), Integer.valueOf(23810));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(69420));
          list.put(Integer.valueOf(32046), Integer.valueOf(69420));
          list.put(Integer.valueOf(32051), Integer.valueOf(46280));
          list.put(Integer.valueOf(32053), Integer.valueOf(46280));
          list.put(Integer.valueOf(32057), Integer.valueOf(46280));
          list.put(Integer.valueOf(32059), Integer.valueOf(69420));
          list.put(Integer.valueOf(32060), Integer.valueOf(69420));
          list.put(Integer.valueOf(32061), Integer.valueOf(69420));
          list.put(Integer.valueOf(32062), Integer.valueOf(69420));
          list.put(Integer.valueOf(32070), Integer.valueOf(23140));
          list.put(Integer.valueOf(32087), Integer.valueOf(46280));
          list.put(Integer.valueOf(32091), Integer.valueOf(46280));
          list.put(Integer.valueOf(32092), Integer.valueOf(46280));
          list.put(Integer.valueOf(32093), Integer.valueOf(46280));
          list.put(Integer.valueOf(32094), Integer.valueOf(46280));
          list.put(Integer.valueOf(32201), Integer.valueOf(69420));
          list.put(Integer.valueOf(32206), Integer.valueOf(69420));
          list.put(Integer.valueOf(32291), Integer.valueOf(23140));
          list.put(Integer.valueOf(32601), Integer.valueOf(23140));
          list.put(Integer.valueOf(42045), Integer.valueOf(355));
          list.put(Integer.valueOf(42046), Integer.valueOf(355));
          list.put(Integer.valueOf(42051), Integer.valueOf(237));
          list.put(Integer.valueOf(42053), Integer.valueOf(237));
          list.put(Integer.valueOf(42057), Integer.valueOf(237));
          list.put(Integer.valueOf(42060), Integer.valueOf(118));
          list.put(Integer.valueOf(42063), Integer.valueOf(355));
          list.put(Integer.valueOf(42064), Integer.valueOf(355));
          list.put(Integer.valueOf(42065), Integer.valueOf(355));
          list.put(Integer.valueOf(42066), Integer.valueOf(355));
          list.put(Integer.valueOf(42070), Integer.valueOf(118));
          list.put(Integer.valueOf(42087), Integer.valueOf(237));
          list.put(Integer.valueOf(42091), Integer.valueOf(237));
          list.put(Integer.valueOf(42092), Integer.valueOf(237));
          list.put(Integer.valueOf(42093), Integer.valueOf(237));
          list.put(Integer.valueOf(42094), Integer.valueOf(237));
          list.put(Integer.valueOf(42095), Integer.valueOf(118));
          list.put(Integer.valueOf(42096), Integer.valueOf(118));
          list.put(Integer.valueOf(42801), Integer.valueOf(118));
          list.put(Integer.valueOf(42292), Integer.valueOf(118));
          list.put(Integer.valueOf(42602), Integer.valueOf(118));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(69420));
          list.put(Integer.valueOf(32046), Integer.valueOf(69420));
          list.put(Integer.valueOf(32051), Integer.valueOf(46280));
          list.put(Integer.valueOf(32053), Integer.valueOf(46280));
          list.put(Integer.valueOf(32057), Integer.valueOf(46280));
          list.put(Integer.valueOf(32059), Integer.valueOf(69420));
          list.put(Integer.valueOf(32060), Integer.valueOf(69420));
          list.put(Integer.valueOf(32061), Integer.valueOf(69420));
          list.put(Integer.valueOf(32062), Integer.valueOf(69420));
          list.put(Integer.valueOf(32070), Integer.valueOf(23140));
          list.put(Integer.valueOf(32087), Integer.valueOf(46280));
          list.put(Integer.valueOf(32091), Integer.valueOf(46280));
          list.put(Integer.valueOf(32092), Integer.valueOf(46280));
          list.put(Integer.valueOf(32093), Integer.valueOf(46280));
          list.put(Integer.valueOf(32094), Integer.valueOf(46280));
          list.put(Integer.valueOf(32201), Integer.valueOf(69420));
          list.put(Integer.valueOf(32206), Integer.valueOf(69420));
          list.put(Integer.valueOf(32291), Integer.valueOf(23140));
          list.put(Integer.valueOf(32601), Integer.valueOf(23140));
          list.put(Integer.valueOf(42045), Integer.valueOf(355));
          list.put(Integer.valueOf(42046), Integer.valueOf(355));
          list.put(Integer.valueOf(42051), Integer.valueOf(237));
          list.put(Integer.valueOf(42053), Integer.valueOf(237));
          list.put(Integer.valueOf(42057), Integer.valueOf(237));
          list.put(Integer.valueOf(42060), Integer.valueOf(118));
          list.put(Integer.valueOf(42063), Integer.valueOf(355));
          list.put(Integer.valueOf(42064), Integer.valueOf(355));
          list.put(Integer.valueOf(42065), Integer.valueOf(355));
          list.put(Integer.valueOf(42066), Integer.valueOf(355));
          list.put(Integer.valueOf(42070), Integer.valueOf(118));
          list.put(Integer.valueOf(42087), Integer.valueOf(237));
          list.put(Integer.valueOf(42091), Integer.valueOf(237));
          list.put(Integer.valueOf(42092), Integer.valueOf(237));
          list.put(Integer.valueOf(42093), Integer.valueOf(237));
          list.put(Integer.valueOf(42094), Integer.valueOf(237));
          list.put(Integer.valueOf(42095), Integer.valueOf(118));
          list.put(Integer.valueOf(42096), Integer.valueOf(118));
          list.put(Integer.valueOf(42801), Integer.valueOf(118));
          list.put(Integer.valueOf(42292), Integer.valueOf(118));
          list.put(Integer.valueOf(42602), Integer.valueOf(118));
        }
        break;
      case 1304:
        if (num == 1)
        {
          list.put(Integer.valueOf(40001), Integer.valueOf(46875));
          list.put(Integer.valueOf(40002), Integer.valueOf(46875));
          list.put(Integer.valueOf(40003), Integer.valueOf(46875));
          list.put(Integer.valueOf(40004), Integer.valueOf(46875));
          list.put(Integer.valueOf(40006), Integer.valueOf(46875));
          list.put(Integer.valueOf(40007), Integer.valueOf(46875));
          list.put(Integer.valueOf(42011), Integer.valueOf(31250));
          list.put(Integer.valueOf(42012), Integer.valueOf(31250));
          list.put(Integer.valueOf(42013), Integer.valueOf(46875));
          list.put(Integer.valueOf(42041), Integer.valueOf(31250));
          list.put(Integer.valueOf(42042), Integer.valueOf(31250));
          list.put(Integer.valueOf(42043), Integer.valueOf(31250));
          list.put(Integer.valueOf(42044), Integer.valueOf(31250));
          list.put(Integer.valueOf(42045), Integer.valueOf(46875));
          list.put(Integer.valueOf(42046), Integer.valueOf(46875));
          list.put(Integer.valueOf(42055), Integer.valueOf(46875));
          list.put(Integer.valueOf(42060), Integer.valueOf(15625));
          list.put(Integer.valueOf(42086), Integer.valueOf(31250));
          list.put(Integer.valueOf(42091), Integer.valueOf(31250));
          list.put(Integer.valueOf(42092), Integer.valueOf(31250));
          list.put(Integer.valueOf(42093), Integer.valueOf(31250));
          list.put(Integer.valueOf(42094), Integer.valueOf(31250));
          list.put(Integer.valueOf(42802), Integer.valueOf(15625));
          list.put(Integer.valueOf(42551), Integer.valueOf(46875));
          list.put(Integer.valueOf(42650), Integer.valueOf(46875));
          list.put(Integer.valueOf(42656), Integer.valueOf(46875));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53305));
          list.put(Integer.valueOf(30002), Integer.valueOf(53305));
          list.put(Integer.valueOf(30003), Integer.valueOf(53305));
          list.put(Integer.valueOf(30004), Integer.valueOf(53305));
          list.put(Integer.valueOf(30005), Integer.valueOf(53305));
          list.put(Integer.valueOf(30006), Integer.valueOf(53305));
          list.put(Integer.valueOf(32011), Integer.valueOf(35537));
          list.put(Integer.valueOf(32012), Integer.valueOf(35537));
          list.put(Integer.valueOf(32014), Integer.valueOf(53305));
          list.put(Integer.valueOf(32041), Integer.valueOf(35537));
          list.put(Integer.valueOf(32042), Integer.valueOf(35537));
          list.put(Integer.valueOf(32043), Integer.valueOf(35537));
          list.put(Integer.valueOf(32044), Integer.valueOf(35537));
          list.put(Integer.valueOf(32045), Integer.valueOf(53305));
          list.put(Integer.valueOf(32046), Integer.valueOf(53305));
          list.put(Integer.valueOf(32055), Integer.valueOf(35537));
          list.put(Integer.valueOf(32086), Integer.valueOf(35537));
          list.put(Integer.valueOf(32091), Integer.valueOf(35537));
          list.put(Integer.valueOf(32092), Integer.valueOf(35537));
          list.put(Integer.valueOf(32093), Integer.valueOf(35537));
          list.put(Integer.valueOf(32094), Integer.valueOf(35537));
          list.put(Integer.valueOf(32111), Integer.valueOf(17768));
          list.put(Integer.valueOf(32551), Integer.valueOf(53305));
          list.put(Integer.valueOf(40001), Integer.valueOf(233));
          list.put(Integer.valueOf(40002), Integer.valueOf(233));
          list.put(Integer.valueOf(40003), Integer.valueOf(233));
          list.put(Integer.valueOf(40004), Integer.valueOf(233));
          list.put(Integer.valueOf(40005), Integer.valueOf(233));
          list.put(Integer.valueOf(40006), Integer.valueOf(233));
          list.put(Integer.valueOf(42011), Integer.valueOf(155));
          list.put(Integer.valueOf(42012), Integer.valueOf(155));
          list.put(Integer.valueOf(42013), Integer.valueOf(233));
          list.put(Integer.valueOf(42041), Integer.valueOf(155));
          list.put(Integer.valueOf(42042), Integer.valueOf(155));
          list.put(Integer.valueOf(42043), Integer.valueOf(155));
          list.put(Integer.valueOf(42044), Integer.valueOf(155));
          list.put(Integer.valueOf(42045), Integer.valueOf(233));
          list.put(Integer.valueOf(42046), Integer.valueOf(233));
          list.put(Integer.valueOf(42055), Integer.valueOf(233));
          list.put(Integer.valueOf(42060), Integer.valueOf(78));
          list.put(Integer.valueOf(42086), Integer.valueOf(155));
          list.put(Integer.valueOf(42091), Integer.valueOf(155));
          list.put(Integer.valueOf(42092), Integer.valueOf(155));
          list.put(Integer.valueOf(42093), Integer.valueOf(155));
          list.put(Integer.valueOf(42094), Integer.valueOf(155));
          list.put(Integer.valueOf(42802), Integer.valueOf(78));
          list.put(Integer.valueOf(42551), Integer.valueOf(233));
          list.put(Integer.valueOf(42650), Integer.valueOf(233));
          list.put(Integer.valueOf(42656), Integer.valueOf(233));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53305));
          list.put(Integer.valueOf(30002), Integer.valueOf(53305));
          list.put(Integer.valueOf(30003), Integer.valueOf(53305));
          list.put(Integer.valueOf(30004), Integer.valueOf(53305));
          list.put(Integer.valueOf(30005), Integer.valueOf(53305));
          list.put(Integer.valueOf(30006), Integer.valueOf(53305));
          list.put(Integer.valueOf(32011), Integer.valueOf(35537));
          list.put(Integer.valueOf(32012), Integer.valueOf(35537));
          list.put(Integer.valueOf(32014), Integer.valueOf(53305));
          list.put(Integer.valueOf(32041), Integer.valueOf(35537));
          list.put(Integer.valueOf(32042), Integer.valueOf(35537));
          list.put(Integer.valueOf(32043), Integer.valueOf(35537));
          list.put(Integer.valueOf(32044), Integer.valueOf(35537));
          list.put(Integer.valueOf(32045), Integer.valueOf(53305));
          list.put(Integer.valueOf(32046), Integer.valueOf(53305));
          list.put(Integer.valueOf(32055), Integer.valueOf(35537));
          list.put(Integer.valueOf(32086), Integer.valueOf(35537));
          list.put(Integer.valueOf(32091), Integer.valueOf(35537));
          list.put(Integer.valueOf(32092), Integer.valueOf(35537));
          list.put(Integer.valueOf(32093), Integer.valueOf(35537));
          list.put(Integer.valueOf(32094), Integer.valueOf(35537));
          list.put(Integer.valueOf(32111), Integer.valueOf(17768));
          list.put(Integer.valueOf(32551), Integer.valueOf(53305));
          list.put(Integer.valueOf(40001), Integer.valueOf(233));
          list.put(Integer.valueOf(40002), Integer.valueOf(233));
          list.put(Integer.valueOf(40003), Integer.valueOf(233));
          list.put(Integer.valueOf(40004), Integer.valueOf(233));
          list.put(Integer.valueOf(40005), Integer.valueOf(233));
          list.put(Integer.valueOf(40006), Integer.valueOf(233));
          list.put(Integer.valueOf(42011), Integer.valueOf(155));
          list.put(Integer.valueOf(42012), Integer.valueOf(155));
          list.put(Integer.valueOf(42013), Integer.valueOf(233));
          list.put(Integer.valueOf(42041), Integer.valueOf(155));
          list.put(Integer.valueOf(42042), Integer.valueOf(155));
          list.put(Integer.valueOf(42043), Integer.valueOf(155));
          list.put(Integer.valueOf(42044), Integer.valueOf(155));
          list.put(Integer.valueOf(42045), Integer.valueOf(233));
          list.put(Integer.valueOf(42046), Integer.valueOf(233));
          list.put(Integer.valueOf(42055), Integer.valueOf(233));
          list.put(Integer.valueOf(42060), Integer.valueOf(78));
          list.put(Integer.valueOf(42086), Integer.valueOf(155));
          list.put(Integer.valueOf(42091), Integer.valueOf(155));
          list.put(Integer.valueOf(42092), Integer.valueOf(155));
          list.put(Integer.valueOf(42093), Integer.valueOf(155));
          list.put(Integer.valueOf(42094), Integer.valueOf(155));
          list.put(Integer.valueOf(42802), Integer.valueOf(78));
          list.put(Integer.valueOf(42551), Integer.valueOf(233));
          list.put(Integer.valueOf(42650), Integer.valueOf(233));
          list.put(Integer.valueOf(42656), Integer.valueOf(233));
        }
        break;
      case 1309:
        if (num == 1)
        {
          list.put(Integer.valueOf(40001), Integer.valueOf(46154));
          list.put(Integer.valueOf(40002), Integer.valueOf(46154));
          list.put(Integer.valueOf(40003), Integer.valueOf(46154));
          list.put(Integer.valueOf(40004), Integer.valueOf(46154));
          list.put(Integer.valueOf(40005), Integer.valueOf(46154));
          list.put(Integer.valueOf(40006), Integer.valueOf(46154));
          list.put(Integer.valueOf(42011), Integer.valueOf(30769));
          list.put(Integer.valueOf(42012), Integer.valueOf(30769));
          list.put(Integer.valueOf(42013), Integer.valueOf(46154));
          list.put(Integer.valueOf(42041), Integer.valueOf(30769));
          list.put(Integer.valueOf(42042), Integer.valueOf(30769));
          list.put(Integer.valueOf(42043), Integer.valueOf(30769));
          list.put(Integer.valueOf(42044), Integer.valueOf(30769));
          list.put(Integer.valueOf(42045), Integer.valueOf(45455));
          list.put(Integer.valueOf(42046), Integer.valueOf(46154));
          list.put(Integer.valueOf(42055), Integer.valueOf(46154));
          list.put(Integer.valueOf(42086), Integer.valueOf(30769));
          list.put(Integer.valueOf(42091), Integer.valueOf(30769));
          list.put(Integer.valueOf(42092), Integer.valueOf(30769));
          list.put(Integer.valueOf(42093), Integer.valueOf(30769));
          list.put(Integer.valueOf(42094), Integer.valueOf(30769));
          list.put(Integer.valueOf(42802), Integer.valueOf(15385));
          list.put(Integer.valueOf(42501), Integer.valueOf(46154));
          list.put(Integer.valueOf(42551), Integer.valueOf(46154));
          list.put(Integer.valueOf(42650), Integer.valueOf(46154));
          list.put(Integer.valueOf(42656), Integer.valueOf(46154));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53305));
          list.put(Integer.valueOf(30002), Integer.valueOf(53305));
          list.put(Integer.valueOf(30003), Integer.valueOf(53305));
          list.put(Integer.valueOf(30004), Integer.valueOf(53305));
          list.put(Integer.valueOf(30005), Integer.valueOf(53305));
          list.put(Integer.valueOf(30006), Integer.valueOf(53305));
          list.put(Integer.valueOf(32011), Integer.valueOf(35537));
          list.put(Integer.valueOf(32012), Integer.valueOf(35537));
          list.put(Integer.valueOf(32014), Integer.valueOf(53305));
          list.put(Integer.valueOf(32041), Integer.valueOf(35537));
          list.put(Integer.valueOf(32042), Integer.valueOf(35537));
          list.put(Integer.valueOf(32043), Integer.valueOf(35537));
          list.put(Integer.valueOf(32044), Integer.valueOf(35537));
          list.put(Integer.valueOf(32045), Integer.valueOf(53305));
          list.put(Integer.valueOf(32046), Integer.valueOf(53305));
          list.put(Integer.valueOf(32055), Integer.valueOf(35537));
          list.put(Integer.valueOf(32086), Integer.valueOf(35537));
          list.put(Integer.valueOf(32091), Integer.valueOf(35537));
          list.put(Integer.valueOf(32092), Integer.valueOf(35537));
          list.put(Integer.valueOf(32093), Integer.valueOf(35537));
          list.put(Integer.valueOf(32094), Integer.valueOf(35537));
          list.put(Integer.valueOf(32111), Integer.valueOf(17768));
          list.put(Integer.valueOf(32551), Integer.valueOf(53305));
          list.put(Integer.valueOf(40001), Integer.valueOf(230));
          list.put(Integer.valueOf(40002), Integer.valueOf(230));
          list.put(Integer.valueOf(40003), Integer.valueOf(230));
          list.put(Integer.valueOf(40004), Integer.valueOf(230));
          list.put(Integer.valueOf(40005), Integer.valueOf(230));
          list.put(Integer.valueOf(40006), Integer.valueOf(230));
          list.put(Integer.valueOf(42011), Integer.valueOf(153));
          list.put(Integer.valueOf(42012), Integer.valueOf(153));
          list.put(Integer.valueOf(42013), Integer.valueOf(230));
          list.put(Integer.valueOf(42041), Integer.valueOf(153));
          list.put(Integer.valueOf(42042), Integer.valueOf(153));
          list.put(Integer.valueOf(42043), Integer.valueOf(153));
          list.put(Integer.valueOf(42044), Integer.valueOf(153));
          list.put(Integer.valueOf(42045), Integer.valueOf(230));
          list.put(Integer.valueOf(42046), Integer.valueOf(230));
          list.put(Integer.valueOf(42055), Integer.valueOf(230));
          list.put(Integer.valueOf(42086), Integer.valueOf(153));
          list.put(Integer.valueOf(42091), Integer.valueOf(153));
          list.put(Integer.valueOf(42092), Integer.valueOf(153));
          list.put(Integer.valueOf(42093), Integer.valueOf(153));
          list.put(Integer.valueOf(42094), Integer.valueOf(153));
          list.put(Integer.valueOf(42802), Integer.valueOf(77));
          list.put(Integer.valueOf(42501), Integer.valueOf(230));
          list.put(Integer.valueOf(42551), Integer.valueOf(230));
          list.put(Integer.valueOf(42650), Integer.valueOf(230));
          list.put(Integer.valueOf(42656), Integer.valueOf(230));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53305));
          list.put(Integer.valueOf(30002), Integer.valueOf(53305));
          list.put(Integer.valueOf(30003), Integer.valueOf(53305));
          list.put(Integer.valueOf(30004), Integer.valueOf(53305));
          list.put(Integer.valueOf(30005), Integer.valueOf(53305));
          list.put(Integer.valueOf(30006), Integer.valueOf(53305));
          list.put(Integer.valueOf(32011), Integer.valueOf(35537));
          list.put(Integer.valueOf(32012), Integer.valueOf(35537));
          list.put(Integer.valueOf(32014), Integer.valueOf(53305));
          list.put(Integer.valueOf(32041), Integer.valueOf(35537));
          list.put(Integer.valueOf(32042), Integer.valueOf(35537));
          list.put(Integer.valueOf(32043), Integer.valueOf(35537));
          list.put(Integer.valueOf(32044), Integer.valueOf(35537));
          list.put(Integer.valueOf(32045), Integer.valueOf(53305));
          list.put(Integer.valueOf(32046), Integer.valueOf(53305));
          list.put(Integer.valueOf(32055), Integer.valueOf(35537));
          list.put(Integer.valueOf(32086), Integer.valueOf(35537));
          list.put(Integer.valueOf(32091), Integer.valueOf(35537));
          list.put(Integer.valueOf(32092), Integer.valueOf(35537));
          list.put(Integer.valueOf(32093), Integer.valueOf(35537));
          list.put(Integer.valueOf(32094), Integer.valueOf(35537));
          list.put(Integer.valueOf(32111), Integer.valueOf(17768));
          list.put(Integer.valueOf(32551), Integer.valueOf(53305));
          list.put(Integer.valueOf(40001), Integer.valueOf(230));
          list.put(Integer.valueOf(40002), Integer.valueOf(230));
          list.put(Integer.valueOf(40003), Integer.valueOf(230));
          list.put(Integer.valueOf(40004), Integer.valueOf(230));
          list.put(Integer.valueOf(40005), Integer.valueOf(230));
          list.put(Integer.valueOf(40006), Integer.valueOf(230));
          list.put(Integer.valueOf(42011), Integer.valueOf(153));
          list.put(Integer.valueOf(42012), Integer.valueOf(153));
          list.put(Integer.valueOf(42013), Integer.valueOf(230));
          list.put(Integer.valueOf(42041), Integer.valueOf(153));
          list.put(Integer.valueOf(42042), Integer.valueOf(153));
          list.put(Integer.valueOf(42043), Integer.valueOf(153));
          list.put(Integer.valueOf(42044), Integer.valueOf(153));
          list.put(Integer.valueOf(42045), Integer.valueOf(230));
          list.put(Integer.valueOf(42046), Integer.valueOf(230));
          list.put(Integer.valueOf(42055), Integer.valueOf(230));
          list.put(Integer.valueOf(42086), Integer.valueOf(153));
          list.put(Integer.valueOf(42091), Integer.valueOf(153));
          list.put(Integer.valueOf(42092), Integer.valueOf(153));
          list.put(Integer.valueOf(42093), Integer.valueOf(153));
          list.put(Integer.valueOf(42094), Integer.valueOf(153));
          list.put(Integer.valueOf(42802), Integer.valueOf(77));
          list.put(Integer.valueOf(42501), Integer.valueOf(230));
          list.put(Integer.valueOf(42551), Integer.valueOf(230));
          list.put(Integer.valueOf(42650), Integer.valueOf(230));
          list.put(Integer.valueOf(42656), Integer.valueOf(230));
        }
        break;
      case 1305:
        if (num == 1)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(76923));
          list.put(Integer.valueOf(42046), Integer.valueOf(76923));
          list.put(Integer.valueOf(42051), Integer.valueOf(51282));
          list.put(Integer.valueOf(42053), Integer.valueOf(51282));
          list.put(Integer.valueOf(42057), Integer.valueOf(51282));
          list.put(Integer.valueOf(42063), Integer.valueOf(76923));
          list.put(Integer.valueOf(42064), Integer.valueOf(76923));
          list.put(Integer.valueOf(42065), Integer.valueOf(76923));
          list.put(Integer.valueOf(42066), Integer.valueOf(76923));
          list.put(Integer.valueOf(42070), Integer.valueOf(25641));
          list.put(Integer.valueOf(42087), Integer.valueOf(51282));
          list.put(Integer.valueOf(42091), Integer.valueOf(51282));
          list.put(Integer.valueOf(42092), Integer.valueOf(51282));
          list.put(Integer.valueOf(42093), Integer.valueOf(51282));
          list.put(Integer.valueOf(42094), Integer.valueOf(51282));
          list.put(Integer.valueOf(42095), Integer.valueOf(25641));
          list.put(Integer.valueOf(42096), Integer.valueOf(25641));
          list.put(Integer.valueOf(42801), Integer.valueOf(25641));
          list.put(Integer.valueOf(42292), Integer.valueOf(25641));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(71073));
          list.put(Integer.valueOf(32046), Integer.valueOf(71073));
          list.put(Integer.valueOf(32051), Integer.valueOf(47382));
          list.put(Integer.valueOf(32053), Integer.valueOf(47382));
          list.put(Integer.valueOf(32057), Integer.valueOf(47382));
          list.put(Integer.valueOf(32059), Integer.valueOf(71073));
          list.put(Integer.valueOf(32060), Integer.valueOf(71073));
          list.put(Integer.valueOf(32061), Integer.valueOf(71073));
          list.put(Integer.valueOf(32062), Integer.valueOf(71073));
          list.put(Integer.valueOf(32070), Integer.valueOf(23691));
          list.put(Integer.valueOf(32087), Integer.valueOf(47382));
          list.put(Integer.valueOf(32091), Integer.valueOf(47382));
          list.put(Integer.valueOf(32092), Integer.valueOf(47382));
          list.put(Integer.valueOf(32093), Integer.valueOf(47382));
          list.put(Integer.valueOf(32094), Integer.valueOf(47382));
          list.put(Integer.valueOf(32201), Integer.valueOf(71073));
          list.put(Integer.valueOf(32206), Integer.valueOf(71073));
          list.put(Integer.valueOf(32291), Integer.valueOf(23691));
          list.put(Integer.valueOf(42045), Integer.valueOf(383));
          list.put(Integer.valueOf(42046), Integer.valueOf(383));
          list.put(Integer.valueOf(42051), Integer.valueOf(255));
          list.put(Integer.valueOf(42053), Integer.valueOf(255));
          list.put(Integer.valueOf(42057), Integer.valueOf(255));
          list.put(Integer.valueOf(42063), Integer.valueOf(383));
          list.put(Integer.valueOf(42064), Integer.valueOf(383));
          list.put(Integer.valueOf(42065), Integer.valueOf(383));
          list.put(Integer.valueOf(42066), Integer.valueOf(383));
          list.put(Integer.valueOf(42070), Integer.valueOf(128));
          list.put(Integer.valueOf(42087), Integer.valueOf(255));
          list.put(Integer.valueOf(42091), Integer.valueOf(255));
          list.put(Integer.valueOf(42092), Integer.valueOf(255));
          list.put(Integer.valueOf(42093), Integer.valueOf(255));
          list.put(Integer.valueOf(42094), Integer.valueOf(255));
          list.put(Integer.valueOf(42095), Integer.valueOf(128));
          list.put(Integer.valueOf(42096), Integer.valueOf(128));
          list.put(Integer.valueOf(42801), Integer.valueOf(128));
          list.put(Integer.valueOf(42292), Integer.valueOf(128));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(71073));
          list.put(Integer.valueOf(32046), Integer.valueOf(71073));
          list.put(Integer.valueOf(32051), Integer.valueOf(47382));
          list.put(Integer.valueOf(32053), Integer.valueOf(47382));
          list.put(Integer.valueOf(32057), Integer.valueOf(47382));
          list.put(Integer.valueOf(32059), Integer.valueOf(71073));
          list.put(Integer.valueOf(32060), Integer.valueOf(71073));
          list.put(Integer.valueOf(32061), Integer.valueOf(71073));
          list.put(Integer.valueOf(32062), Integer.valueOf(71073));
          list.put(Integer.valueOf(32070), Integer.valueOf(23691));
          list.put(Integer.valueOf(32087), Integer.valueOf(47382));
          list.put(Integer.valueOf(32091), Integer.valueOf(47382));
          list.put(Integer.valueOf(32092), Integer.valueOf(47382));
          list.put(Integer.valueOf(32093), Integer.valueOf(47382));
          list.put(Integer.valueOf(32094), Integer.valueOf(47382));
          list.put(Integer.valueOf(32201), Integer.valueOf(71073));
          list.put(Integer.valueOf(32206), Integer.valueOf(71073));
          list.put(Integer.valueOf(32291), Integer.valueOf(23691));
          list.put(Integer.valueOf(42045), Integer.valueOf(383));
          list.put(Integer.valueOf(42046), Integer.valueOf(383));
          list.put(Integer.valueOf(42051), Integer.valueOf(255));
          list.put(Integer.valueOf(42053), Integer.valueOf(255));
          list.put(Integer.valueOf(42057), Integer.valueOf(255));
          list.put(Integer.valueOf(42063), Integer.valueOf(383));
          list.put(Integer.valueOf(42064), Integer.valueOf(383));
          list.put(Integer.valueOf(42065), Integer.valueOf(383));
          list.put(Integer.valueOf(42066), Integer.valueOf(383));
          list.put(Integer.valueOf(42070), Integer.valueOf(128));
          list.put(Integer.valueOf(42087), Integer.valueOf(255));
          list.put(Integer.valueOf(42091), Integer.valueOf(255));
          list.put(Integer.valueOf(42092), Integer.valueOf(255));
          list.put(Integer.valueOf(42093), Integer.valueOf(255));
          list.put(Integer.valueOf(42094), Integer.valueOf(255));
          list.put(Integer.valueOf(42095), Integer.valueOf(128));
          list.put(Integer.valueOf(42096), Integer.valueOf(128));
          list.put(Integer.valueOf(42801), Integer.valueOf(128));
          list.put(Integer.valueOf(42292), Integer.valueOf(128));
        }
        break;
      case 1306:
        if (num == 1)
        {
          list.put(Integer.valueOf(40001), Integer.valueOf(45455));
          list.put(Integer.valueOf(40002), Integer.valueOf(45455));
          list.put(Integer.valueOf(40003), Integer.valueOf(45455));
          list.put(Integer.valueOf(40004), Integer.valueOf(45455));
          list.put(Integer.valueOf(40005), Integer.valueOf(45455));
          list.put(Integer.valueOf(40006), Integer.valueOf(45455));
          list.put(Integer.valueOf(42011), Integer.valueOf(30303));
          list.put(Integer.valueOf(42012), Integer.valueOf(30303));
          list.put(Integer.valueOf(42013), Integer.valueOf(46875));
          list.put(Integer.valueOf(42041), Integer.valueOf(30303));
          list.put(Integer.valueOf(42042), Integer.valueOf(30303));
          list.put(Integer.valueOf(42043), Integer.valueOf(30303));
          list.put(Integer.valueOf(42044), Integer.valueOf(30303));
          list.put(Integer.valueOf(42045), Integer.valueOf(45455));
          list.put(Integer.valueOf(42046), Integer.valueOf(45455));
          list.put(Integer.valueOf(42055), Integer.valueOf(45455));
          list.put(Integer.valueOf(42060), Integer.valueOf(15152));
          list.put(Integer.valueOf(42061), Integer.valueOf(15152));
          list.put(Integer.valueOf(42086), Integer.valueOf(30303));
          list.put(Integer.valueOf(42091), Integer.valueOf(30303));
          list.put(Integer.valueOf(42092), Integer.valueOf(30303));
          list.put(Integer.valueOf(42093), Integer.valueOf(30303));
          list.put(Integer.valueOf(42094), Integer.valueOf(30303));
          list.put(Integer.valueOf(42802), Integer.valueOf(15152));
          list.put(Integer.valueOf(42551), Integer.valueOf(45455));
          list.put(Integer.valueOf(42650), Integer.valueOf(45455));
          list.put(Integer.valueOf(42656), Integer.valueOf(45455));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53305));
          list.put(Integer.valueOf(30002), Integer.valueOf(53305));
          list.put(Integer.valueOf(30003), Integer.valueOf(53305));
          list.put(Integer.valueOf(30004), Integer.valueOf(53305));
          list.put(Integer.valueOf(30005), Integer.valueOf(53305));
          list.put(Integer.valueOf(30006), Integer.valueOf(53305));
          list.put(Integer.valueOf(32011), Integer.valueOf(35537));
          list.put(Integer.valueOf(32012), Integer.valueOf(35537));
          list.put(Integer.valueOf(32014), Integer.valueOf(53305));
          list.put(Integer.valueOf(32041), Integer.valueOf(35537));
          list.put(Integer.valueOf(32042), Integer.valueOf(35537));
          list.put(Integer.valueOf(32043), Integer.valueOf(35537));
          list.put(Integer.valueOf(32044), Integer.valueOf(35537));
          list.put(Integer.valueOf(32045), Integer.valueOf(53305));
          list.put(Integer.valueOf(32046), Integer.valueOf(53305));
          list.put(Integer.valueOf(32055), Integer.valueOf(35537));
          list.put(Integer.valueOf(32086), Integer.valueOf(35537));
          list.put(Integer.valueOf(32091), Integer.valueOf(35537));
          list.put(Integer.valueOf(32092), Integer.valueOf(35537));
          list.put(Integer.valueOf(32093), Integer.valueOf(35537));
          list.put(Integer.valueOf(32094), Integer.valueOf(35537));
          list.put(Integer.valueOf(32111), Integer.valueOf(17768));
          list.put(Integer.valueOf(32551), Integer.valueOf(53305));
          list.put(Integer.valueOf(40001), Integer.valueOf(226));
          list.put(Integer.valueOf(40002), Integer.valueOf(226));
          list.put(Integer.valueOf(40003), Integer.valueOf(226));
          list.put(Integer.valueOf(40004), Integer.valueOf(226));
          list.put(Integer.valueOf(40005), Integer.valueOf(226));
          list.put(Integer.valueOf(40006), Integer.valueOf(226));
          list.put(Integer.valueOf(42011), Integer.valueOf(151));
          list.put(Integer.valueOf(42012), Integer.valueOf(151));
          list.put(Integer.valueOf(42013), Integer.valueOf(226));
          list.put(Integer.valueOf(42041), Integer.valueOf(151));
          list.put(Integer.valueOf(42042), Integer.valueOf(151));
          list.put(Integer.valueOf(42043), Integer.valueOf(151));
          list.put(Integer.valueOf(42044), Integer.valueOf(151));
          list.put(Integer.valueOf(42045), Integer.valueOf(226));
          list.put(Integer.valueOf(42046), Integer.valueOf(226));
          list.put(Integer.valueOf(42055), Integer.valueOf(226));
          list.put(Integer.valueOf(42060), Integer.valueOf(75));
          list.put(Integer.valueOf(42061), Integer.valueOf(75));
          list.put(Integer.valueOf(42086), Integer.valueOf(151));
          list.put(Integer.valueOf(42091), Integer.valueOf(151));
          list.put(Integer.valueOf(42092), Integer.valueOf(151));
          list.put(Integer.valueOf(42093), Integer.valueOf(151));
          list.put(Integer.valueOf(42094), Integer.valueOf(151));
          list.put(Integer.valueOf(42802), Integer.valueOf(75));
          list.put(Integer.valueOf(42551), Integer.valueOf(226));
          list.put(Integer.valueOf(42650), Integer.valueOf(226));
          list.put(Integer.valueOf(42656), Integer.valueOf(226));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53305));
          list.put(Integer.valueOf(30002), Integer.valueOf(53305));
          list.put(Integer.valueOf(30003), Integer.valueOf(53305));
          list.put(Integer.valueOf(30004), Integer.valueOf(53305));
          list.put(Integer.valueOf(30005), Integer.valueOf(53305));
          list.put(Integer.valueOf(30006), Integer.valueOf(53305));
          list.put(Integer.valueOf(32011), Integer.valueOf(35537));
          list.put(Integer.valueOf(32012), Integer.valueOf(35537));
          list.put(Integer.valueOf(32014), Integer.valueOf(53305));
          list.put(Integer.valueOf(32041), Integer.valueOf(35537));
          list.put(Integer.valueOf(32042), Integer.valueOf(35537));
          list.put(Integer.valueOf(32043), Integer.valueOf(35537));
          list.put(Integer.valueOf(32044), Integer.valueOf(35537));
          list.put(Integer.valueOf(32045), Integer.valueOf(53305));
          list.put(Integer.valueOf(32046), Integer.valueOf(53305));
          list.put(Integer.valueOf(32055), Integer.valueOf(35537));
          list.put(Integer.valueOf(32086), Integer.valueOf(35537));
          list.put(Integer.valueOf(32091), Integer.valueOf(35537));
          list.put(Integer.valueOf(32092), Integer.valueOf(35537));
          list.put(Integer.valueOf(32093), Integer.valueOf(35537));
          list.put(Integer.valueOf(32094), Integer.valueOf(35537));
          list.put(Integer.valueOf(32111), Integer.valueOf(17768));
          list.put(Integer.valueOf(32551), Integer.valueOf(53305));
          list.put(Integer.valueOf(40001), Integer.valueOf(226));
          list.put(Integer.valueOf(40002), Integer.valueOf(226));
          list.put(Integer.valueOf(40003), Integer.valueOf(226));
          list.put(Integer.valueOf(40004), Integer.valueOf(226));
          list.put(Integer.valueOf(40005), Integer.valueOf(226));
          list.put(Integer.valueOf(40006), Integer.valueOf(226));
          list.put(Integer.valueOf(42011), Integer.valueOf(151));
          list.put(Integer.valueOf(42012), Integer.valueOf(151));
          list.put(Integer.valueOf(42013), Integer.valueOf(226));
          list.put(Integer.valueOf(42041), Integer.valueOf(151));
          list.put(Integer.valueOf(42042), Integer.valueOf(151));
          list.put(Integer.valueOf(42043), Integer.valueOf(151));
          list.put(Integer.valueOf(42044), Integer.valueOf(151));
          list.put(Integer.valueOf(42045), Integer.valueOf(226));
          list.put(Integer.valueOf(42046), Integer.valueOf(226));
          list.put(Integer.valueOf(42055), Integer.valueOf(226));
          list.put(Integer.valueOf(42060), Integer.valueOf(75));
          list.put(Integer.valueOf(42061), Integer.valueOf(75));
          list.put(Integer.valueOf(42086), Integer.valueOf(151));
          list.put(Integer.valueOf(42091), Integer.valueOf(151));
          list.put(Integer.valueOf(42092), Integer.valueOf(151));
          list.put(Integer.valueOf(42093), Integer.valueOf(151));
          list.put(Integer.valueOf(42094), Integer.valueOf(151));
          list.put(Integer.valueOf(42802), Integer.valueOf(75));
          list.put(Integer.valueOf(42551), Integer.valueOf(226));
          list.put(Integer.valueOf(42650), Integer.valueOf(226));
          list.put(Integer.valueOf(42656), Integer.valueOf(226));
        }
        break;
      case 1307:
        if (num == 1)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(71429));
          list.put(Integer.valueOf(42046), Integer.valueOf(71429));
          list.put(Integer.valueOf(42051), Integer.valueOf(47619));
          list.put(Integer.valueOf(42053), Integer.valueOf(47619));
          list.put(Integer.valueOf(42057), Integer.valueOf(47619));
          list.put(Integer.valueOf(42060), Integer.valueOf(23810));
          list.put(Integer.valueOf(42063), Integer.valueOf(71429));
          list.put(Integer.valueOf(42064), Integer.valueOf(71429));
          list.put(Integer.valueOf(42065), Integer.valueOf(71429));
          list.put(Integer.valueOf(42066), Integer.valueOf(71429));
          list.put(Integer.valueOf(42070), Integer.valueOf(23810));
          list.put(Integer.valueOf(42087), Integer.valueOf(47619));
          list.put(Integer.valueOf(42091), Integer.valueOf(47619));
          list.put(Integer.valueOf(42092), Integer.valueOf(47619));
          list.put(Integer.valueOf(42093), Integer.valueOf(47619));
          list.put(Integer.valueOf(42094), Integer.valueOf(47619));
          list.put(Integer.valueOf(42095), Integer.valueOf(23810));
          list.put(Integer.valueOf(42096), Integer.valueOf(23810));
          list.put(Integer.valueOf(42801), Integer.valueOf(23810));
          list.put(Integer.valueOf(42292), Integer.valueOf(23810));
          list.put(Integer.valueOf(42602), Integer.valueOf(23810));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(69420));
          list.put(Integer.valueOf(32046), Integer.valueOf(69420));
          list.put(Integer.valueOf(32051), Integer.valueOf(46280));
          list.put(Integer.valueOf(32053), Integer.valueOf(46280));
          list.put(Integer.valueOf(32057), Integer.valueOf(46280));
          list.put(Integer.valueOf(32059), Integer.valueOf(69420));
          list.put(Integer.valueOf(32060), Integer.valueOf(69420));
          list.put(Integer.valueOf(32061), Integer.valueOf(69420));
          list.put(Integer.valueOf(32062), Integer.valueOf(69420));
          list.put(Integer.valueOf(32070), Integer.valueOf(23140));
          list.put(Integer.valueOf(32087), Integer.valueOf(46280));
          list.put(Integer.valueOf(32091), Integer.valueOf(46280));
          list.put(Integer.valueOf(32092), Integer.valueOf(46280));
          list.put(Integer.valueOf(32093), Integer.valueOf(46280));
          list.put(Integer.valueOf(32094), Integer.valueOf(46280));
          list.put(Integer.valueOf(20401), Integer.valueOf(69420));
          list.put(Integer.valueOf(20402), Integer.valueOf(69420));
          list.put(Integer.valueOf(32291), Integer.valueOf(23140));
          list.put(Integer.valueOf(32601), Integer.valueOf(23140));
          list.put(Integer.valueOf(42045), Integer.valueOf(355));
          list.put(Integer.valueOf(42046), Integer.valueOf(355));
          list.put(Integer.valueOf(42051), Integer.valueOf(237));
          list.put(Integer.valueOf(42053), Integer.valueOf(237));
          list.put(Integer.valueOf(42057), Integer.valueOf(237));
          list.put(Integer.valueOf(42060), Integer.valueOf(118));
          list.put(Integer.valueOf(42063), Integer.valueOf(355));
          list.put(Integer.valueOf(42064), Integer.valueOf(355));
          list.put(Integer.valueOf(42065), Integer.valueOf(355));
          list.put(Integer.valueOf(42066), Integer.valueOf(355));
          list.put(Integer.valueOf(42070), Integer.valueOf(118));
          list.put(Integer.valueOf(42087), Integer.valueOf(237));
          list.put(Integer.valueOf(42091), Integer.valueOf(237));
          list.put(Integer.valueOf(42092), Integer.valueOf(237));
          list.put(Integer.valueOf(42093), Integer.valueOf(237));
          list.put(Integer.valueOf(42094), Integer.valueOf(237));
          list.put(Integer.valueOf(42095), Integer.valueOf(118));
          list.put(Integer.valueOf(42096), Integer.valueOf(118));
          list.put(Integer.valueOf(42801), Integer.valueOf(118));
          list.put(Integer.valueOf(42292), Integer.valueOf(118));
          list.put(Integer.valueOf(42602), Integer.valueOf(118));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(32045), Integer.valueOf(69420));
          list.put(Integer.valueOf(32046), Integer.valueOf(69420));
          list.put(Integer.valueOf(32051), Integer.valueOf(46280));
          list.put(Integer.valueOf(32053), Integer.valueOf(46280));
          list.put(Integer.valueOf(32057), Integer.valueOf(46280));
          list.put(Integer.valueOf(32059), Integer.valueOf(69420));
          list.put(Integer.valueOf(32060), Integer.valueOf(69420));
          list.put(Integer.valueOf(32061), Integer.valueOf(69420));
          list.put(Integer.valueOf(32062), Integer.valueOf(69420));
          list.put(Integer.valueOf(32070), Integer.valueOf(23140));
          list.put(Integer.valueOf(32087), Integer.valueOf(46280));
          list.put(Integer.valueOf(32091), Integer.valueOf(46280));
          list.put(Integer.valueOf(32092), Integer.valueOf(46280));
          list.put(Integer.valueOf(32093), Integer.valueOf(46280));
          list.put(Integer.valueOf(32094), Integer.valueOf(46280));
          list.put(Integer.valueOf(20401), Integer.valueOf(69420));
          list.put(Integer.valueOf(20402), Integer.valueOf(69420));
          list.put(Integer.valueOf(32291), Integer.valueOf(23140));
          list.put(Integer.valueOf(32601), Integer.valueOf(23140));
          list.put(Integer.valueOf(42045), Integer.valueOf(355));
          list.put(Integer.valueOf(42046), Integer.valueOf(355));
          list.put(Integer.valueOf(42051), Integer.valueOf(237));
          list.put(Integer.valueOf(42053), Integer.valueOf(237));
          list.put(Integer.valueOf(42057), Integer.valueOf(237));
          list.put(Integer.valueOf(42060), Integer.valueOf(118));
          list.put(Integer.valueOf(42063), Integer.valueOf(355));
          list.put(Integer.valueOf(42064), Integer.valueOf(355));
          list.put(Integer.valueOf(42065), Integer.valueOf(355));
          list.put(Integer.valueOf(42066), Integer.valueOf(355));
          list.put(Integer.valueOf(42070), Integer.valueOf(118));
          list.put(Integer.valueOf(42087), Integer.valueOf(237));
          list.put(Integer.valueOf(42091), Integer.valueOf(237));
          list.put(Integer.valueOf(42092), Integer.valueOf(237));
          list.put(Integer.valueOf(42093), Integer.valueOf(237));
          list.put(Integer.valueOf(42094), Integer.valueOf(237));
          list.put(Integer.valueOf(42095), Integer.valueOf(118));
          list.put(Integer.valueOf(42096), Integer.valueOf(118));
          list.put(Integer.valueOf(42801), Integer.valueOf(118));
          list.put(Integer.valueOf(42292), Integer.valueOf(118));
          list.put(Integer.valueOf(42602), Integer.valueOf(118));
        }
        break;
      case 1308:
        if (num == 1)
        {
          list.put(Integer.valueOf(40001), Integer.valueOf(46154));
          list.put(Integer.valueOf(40002), Integer.valueOf(48387));
          list.put(Integer.valueOf(40003), Integer.valueOf(48387));
          list.put(Integer.valueOf(40004), Integer.valueOf(48387));
          list.put(Integer.valueOf(40005), Integer.valueOf(48387));
          list.put(Integer.valueOf(40006), Integer.valueOf(48387));
          list.put(Integer.valueOf(42011), Integer.valueOf(32258));
          list.put(Integer.valueOf(42012), Integer.valueOf(32258));
          list.put(Integer.valueOf(42013), Integer.valueOf(48387));
          list.put(Integer.valueOf(42041), Integer.valueOf(32258));
          list.put(Integer.valueOf(42042), Integer.valueOf(32258));
          list.put(Integer.valueOf(42043), Integer.valueOf(32258));
          list.put(Integer.valueOf(42044), Integer.valueOf(32258));
          list.put(Integer.valueOf(42045), Integer.valueOf(45455));
          list.put(Integer.valueOf(42046), Integer.valueOf(48387));
          list.put(Integer.valueOf(42055), Integer.valueOf(48387));
          list.put(Integer.valueOf(42086), Integer.valueOf(32258));
          list.put(Integer.valueOf(42091), Integer.valueOf(32258));
          list.put(Integer.valueOf(42092), Integer.valueOf(32258));
          list.put(Integer.valueOf(42093), Integer.valueOf(32258));
          list.put(Integer.valueOf(42094), Integer.valueOf(32258));
          list.put(Integer.valueOf(42802), Integer.valueOf(16129));
          list.put(Integer.valueOf(42501), Integer.valueOf(48387));
          list.put(Integer.valueOf(42551), Integer.valueOf(48387));
          list.put(Integer.valueOf(42650), Integer.valueOf(48387));
          list.put(Integer.valueOf(42656), Integer.valueOf(48387));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53305));
          list.put(Integer.valueOf(30002), Integer.valueOf(53305));
          list.put(Integer.valueOf(30003), Integer.valueOf(53305));
          list.put(Integer.valueOf(30004), Integer.valueOf(53305));
          list.put(Integer.valueOf(30005), Integer.valueOf(53305));
          list.put(Integer.valueOf(30006), Integer.valueOf(53305));
          list.put(Integer.valueOf(32011), Integer.valueOf(35537));
          list.put(Integer.valueOf(32012), Integer.valueOf(35537));
          list.put(Integer.valueOf(32014), Integer.valueOf(53305));
          list.put(Integer.valueOf(32041), Integer.valueOf(35537));
          list.put(Integer.valueOf(32042), Integer.valueOf(35537));
          list.put(Integer.valueOf(32043), Integer.valueOf(35537));
          list.put(Integer.valueOf(32044), Integer.valueOf(35537));
          list.put(Integer.valueOf(32045), Integer.valueOf(53305));
          list.put(Integer.valueOf(32046), Integer.valueOf(53305));
          list.put(Integer.valueOf(32055), Integer.valueOf(35537));
          list.put(Integer.valueOf(32086), Integer.valueOf(35537));
          list.put(Integer.valueOf(32091), Integer.valueOf(35537));
          list.put(Integer.valueOf(32092), Integer.valueOf(35537));
          list.put(Integer.valueOf(32093), Integer.valueOf(35537));
          list.put(Integer.valueOf(32094), Integer.valueOf(35537));
          list.put(Integer.valueOf(32111), Integer.valueOf(17768));
          list.put(Integer.valueOf(32551), Integer.valueOf(53305));
          list.put(Integer.valueOf(40001), Integer.valueOf(241));
          list.put(Integer.valueOf(40002), Integer.valueOf(241));
          list.put(Integer.valueOf(40003), Integer.valueOf(241));
          list.put(Integer.valueOf(40004), Integer.valueOf(241));
          list.put(Integer.valueOf(40005), Integer.valueOf(241));
          list.put(Integer.valueOf(40006), Integer.valueOf(241));
          list.put(Integer.valueOf(42011), Integer.valueOf(160));
          list.put(Integer.valueOf(42012), Integer.valueOf(160));
          list.put(Integer.valueOf(42013), Integer.valueOf(241));
          list.put(Integer.valueOf(42041), Integer.valueOf(160));
          list.put(Integer.valueOf(42042), Integer.valueOf(160));
          list.put(Integer.valueOf(42043), Integer.valueOf(160));
          list.put(Integer.valueOf(42044), Integer.valueOf(160));
          list.put(Integer.valueOf(42045), Integer.valueOf(241));
          list.put(Integer.valueOf(42046), Integer.valueOf(241));
          list.put(Integer.valueOf(42055), Integer.valueOf(241));
          list.put(Integer.valueOf(42086), Integer.valueOf(160));
          list.put(Integer.valueOf(42091), Integer.valueOf(160));
          list.put(Integer.valueOf(42092), Integer.valueOf(160));
          list.put(Integer.valueOf(42093), Integer.valueOf(160));
          list.put(Integer.valueOf(42094), Integer.valueOf(160));
          list.put(Integer.valueOf(42802), Integer.valueOf(80));
          list.put(Integer.valueOf(42501), Integer.valueOf(241));
          list.put(Integer.valueOf(42551), Integer.valueOf(241));
          list.put(Integer.valueOf(42650), Integer.valueOf(241));
          list.put(Integer.valueOf(42656), Integer.valueOf(241));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(30001), Integer.valueOf(53305));
          list.put(Integer.valueOf(30002), Integer.valueOf(53305));
          list.put(Integer.valueOf(30003), Integer.valueOf(53305));
          list.put(Integer.valueOf(30004), Integer.valueOf(53305));
          list.put(Integer.valueOf(30005), Integer.valueOf(53305));
          list.put(Integer.valueOf(30006), Integer.valueOf(53305));
          list.put(Integer.valueOf(32011), Integer.valueOf(35537));
          list.put(Integer.valueOf(32012), Integer.valueOf(35537));
          list.put(Integer.valueOf(32014), Integer.valueOf(53305));
          list.put(Integer.valueOf(32041), Integer.valueOf(35537));
          list.put(Integer.valueOf(32042), Integer.valueOf(35537));
          list.put(Integer.valueOf(32043), Integer.valueOf(35537));
          list.put(Integer.valueOf(32044), Integer.valueOf(35537));
          list.put(Integer.valueOf(32045), Integer.valueOf(53305));
          list.put(Integer.valueOf(32046), Integer.valueOf(53305));
          list.put(Integer.valueOf(32055), Integer.valueOf(35537));
          list.put(Integer.valueOf(32086), Integer.valueOf(35537));
          list.put(Integer.valueOf(32091), Integer.valueOf(35537));
          list.put(Integer.valueOf(32092), Integer.valueOf(35537));
          list.put(Integer.valueOf(32093), Integer.valueOf(35537));
          list.put(Integer.valueOf(32094), Integer.valueOf(35537));
          list.put(Integer.valueOf(32111), Integer.valueOf(17768));
          list.put(Integer.valueOf(32551), Integer.valueOf(53305));
          list.put(Integer.valueOf(40001), Integer.valueOf(241));
          list.put(Integer.valueOf(40002), Integer.valueOf(241));
          list.put(Integer.valueOf(40003), Integer.valueOf(241));
          list.put(Integer.valueOf(40004), Integer.valueOf(241));
          list.put(Integer.valueOf(40005), Integer.valueOf(241));
          list.put(Integer.valueOf(40006), Integer.valueOf(241));
          list.put(Integer.valueOf(42011), Integer.valueOf(160));
          list.put(Integer.valueOf(42012), Integer.valueOf(160));
          list.put(Integer.valueOf(42013), Integer.valueOf(241));
          list.put(Integer.valueOf(42041), Integer.valueOf(160));
          list.put(Integer.valueOf(42042), Integer.valueOf(160));
          list.put(Integer.valueOf(42043), Integer.valueOf(160));
          list.put(Integer.valueOf(42044), Integer.valueOf(160));
          list.put(Integer.valueOf(42045), Integer.valueOf(241));
          list.put(Integer.valueOf(42046), Integer.valueOf(241));
          list.put(Integer.valueOf(42055), Integer.valueOf(241));
          list.put(Integer.valueOf(42086), Integer.valueOf(160));
          list.put(Integer.valueOf(42091), Integer.valueOf(160));
          list.put(Integer.valueOf(42092), Integer.valueOf(160));
          list.put(Integer.valueOf(42093), Integer.valueOf(160));
          list.put(Integer.valueOf(42094), Integer.valueOf(160));
          list.put(Integer.valueOf(42802), Integer.valueOf(80));
          list.put(Integer.valueOf(42501), Integer.valueOf(241));
          list.put(Integer.valueOf(42551), Integer.valueOf(241));
          list.put(Integer.valueOf(42650), Integer.valueOf(241));
          list.put(Integer.valueOf(42656), Integer.valueOf(241));
        }
        break;
    }
    return list;
  }
  
  public static Map<Integer, Integer> getUnlimitedLegendaryOption(int type, int num)
  {
    Map<Integer, Integer> list = new HashMap<>();
    switch (type)
    {
      case 1300:
        if (num == 1)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(133333));
          list.put(Integer.valueOf(42051), Integer.valueOf(133333));
          list.put(Integer.valueOf(42053), Integer.valueOf(133333));
          list.put(Integer.valueOf(42070), Integer.valueOf(133333));
          list.put(Integer.valueOf(42095), Integer.valueOf(133333));
          list.put(Integer.valueOf(42096), Integer.valueOf(133333));
          list.put(Integer.valueOf(42292), Integer.valueOf(100000));
          list.put(Integer.valueOf(42602), Integer.valueOf(100000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(133333));
          list.put(Integer.valueOf(42051), Integer.valueOf(133333));
          list.put(Integer.valueOf(42053), Integer.valueOf(133333));
          list.put(Integer.valueOf(42070), Integer.valueOf(133333));
          list.put(Integer.valueOf(42095), Integer.valueOf(133333));
          list.put(Integer.valueOf(42096), Integer.valueOf(133333));
          list.put(Integer.valueOf(42292), Integer.valueOf(100000));
          list.put(Integer.valueOf(42602), Integer.valueOf(100000));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(133333));
          list.put(Integer.valueOf(42051), Integer.valueOf(133333));
          list.put(Integer.valueOf(42053), Integer.valueOf(133333));
          list.put(Integer.valueOf(42070), Integer.valueOf(133333));
          list.put(Integer.valueOf(42095), Integer.valueOf(133333));
          list.put(Integer.valueOf(42096), Integer.valueOf(133333));
          list.put(Integer.valueOf(42292), Integer.valueOf(100000));
          list.put(Integer.valueOf(42602), Integer.valueOf(100000));
        }
        break;
      case 1301:
        if (num == 1)
        {
          list.put(Integer.valueOf(42041), Integer.valueOf(87500));
          list.put(Integer.valueOf(42042), Integer.valueOf(87500));
          list.put(Integer.valueOf(42043), Integer.valueOf(87500));
          list.put(Integer.valueOf(42044), Integer.valueOf(87500));
          list.put(Integer.valueOf(42045), Integer.valueOf(65000));
          list.put(Integer.valueOf(42060), Integer.valueOf(65000));
          list.put(Integer.valueOf(42086), Integer.valueOf(65000));
          list.put(Integer.valueOf(42091), Integer.valueOf(87500));
          list.put(Integer.valueOf(42092), Integer.valueOf(87500));
          list.put(Integer.valueOf(42093), Integer.valueOf(87500));
          list.put(Integer.valueOf(42094), Integer.valueOf(87500));
          list.put(Integer.valueOf(42556), Integer.valueOf(40000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(42041), Integer.valueOf(87500));
          list.put(Integer.valueOf(42042), Integer.valueOf(87500));
          list.put(Integer.valueOf(42043), Integer.valueOf(87500));
          list.put(Integer.valueOf(42044), Integer.valueOf(87500));
          list.put(Integer.valueOf(42045), Integer.valueOf(65000));
          list.put(Integer.valueOf(42060), Integer.valueOf(65000));
          list.put(Integer.valueOf(42086), Integer.valueOf(65000));
          list.put(Integer.valueOf(42091), Integer.valueOf(87500));
          list.put(Integer.valueOf(42092), Integer.valueOf(87500));
          list.put(Integer.valueOf(42093), Integer.valueOf(87500));
          list.put(Integer.valueOf(42094), Integer.valueOf(87500));
          list.put(Integer.valueOf(42556), Integer.valueOf(40000));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(42041), Integer.valueOf(87500));
          list.put(Integer.valueOf(42042), Integer.valueOf(87500));
          list.put(Integer.valueOf(42043), Integer.valueOf(87500));
          list.put(Integer.valueOf(42044), Integer.valueOf(87500));
          list.put(Integer.valueOf(42045), Integer.valueOf(65000));
          list.put(Integer.valueOf(42060), Integer.valueOf(65000));
          list.put(Integer.valueOf(42086), Integer.valueOf(65000));
          list.put(Integer.valueOf(42091), Integer.valueOf(87500));
          list.put(Integer.valueOf(42092), Integer.valueOf(87500));
          list.put(Integer.valueOf(42093), Integer.valueOf(87500));
          list.put(Integer.valueOf(42094), Integer.valueOf(87500));
          list.put(Integer.valueOf(42556), Integer.valueOf(40000));
        }
        break;
      case 1302:
        if (num == 1)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(120000));
          list.put(Integer.valueOf(42051), Integer.valueOf(120000));
          list.put(Integer.valueOf(42053), Integer.valueOf(120000));
          list.put(Integer.valueOf(42057), Integer.valueOf(80000));
          list.put(Integer.valueOf(42060), Integer.valueOf(80000));
          list.put(Integer.valueOf(42070), Integer.valueOf(80000));
          list.put(Integer.valueOf(42095), Integer.valueOf(120000));
          list.put(Integer.valueOf(42096), Integer.valueOf(120000));
          list.put(Integer.valueOf(42292), Integer.valueOf(80000));
          list.put(Integer.valueOf(42602), Integer.valueOf(80000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(120000));
          list.put(Integer.valueOf(42051), Integer.valueOf(120000));
          list.put(Integer.valueOf(42053), Integer.valueOf(120000));
          list.put(Integer.valueOf(42057), Integer.valueOf(80000));
          list.put(Integer.valueOf(42060), Integer.valueOf(80000));
          list.put(Integer.valueOf(42070), Integer.valueOf(80000));
          list.put(Integer.valueOf(42095), Integer.valueOf(120000));
          list.put(Integer.valueOf(42096), Integer.valueOf(120000));
          list.put(Integer.valueOf(42292), Integer.valueOf(80000));
          list.put(Integer.valueOf(42602), Integer.valueOf(80000));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(120000));
          list.put(Integer.valueOf(42051), Integer.valueOf(120000));
          list.put(Integer.valueOf(42053), Integer.valueOf(120000));
          list.put(Integer.valueOf(42057), Integer.valueOf(80000));
          list.put(Integer.valueOf(42060), Integer.valueOf(80000));
          list.put(Integer.valueOf(42070), Integer.valueOf(80000));
          list.put(Integer.valueOf(42095), Integer.valueOf(120000));
          list.put(Integer.valueOf(42096), Integer.valueOf(120000));
          list.put(Integer.valueOf(42292), Integer.valueOf(80000));
          list.put(Integer.valueOf(42602), Integer.valueOf(80000));
        }
        break;
      case 1303:
        if (num == 1)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(120000));
          list.put(Integer.valueOf(42051), Integer.valueOf(120000));
          list.put(Integer.valueOf(42053), Integer.valueOf(120000));
          list.put(Integer.valueOf(42057), Integer.valueOf(80000));
          list.put(Integer.valueOf(42060), Integer.valueOf(80000));
          list.put(Integer.valueOf(42070), Integer.valueOf(80000));
          list.put(Integer.valueOf(42095), Integer.valueOf(120000));
          list.put(Integer.valueOf(42096), Integer.valueOf(120000));
          list.put(Integer.valueOf(42292), Integer.valueOf(80000));
          list.put(Integer.valueOf(42602), Integer.valueOf(80000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(120000));
          list.put(Integer.valueOf(42051), Integer.valueOf(120000));
          list.put(Integer.valueOf(42053), Integer.valueOf(120000));
          list.put(Integer.valueOf(42057), Integer.valueOf(80000));
          list.put(Integer.valueOf(42060), Integer.valueOf(80000));
          list.put(Integer.valueOf(42070), Integer.valueOf(80000));
          list.put(Integer.valueOf(42095), Integer.valueOf(120000));
          list.put(Integer.valueOf(42096), Integer.valueOf(120000));
          list.put(Integer.valueOf(42292), Integer.valueOf(80000));
          list.put(Integer.valueOf(42602), Integer.valueOf(80000));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(120000));
          list.put(Integer.valueOf(42051), Integer.valueOf(120000));
          list.put(Integer.valueOf(42053), Integer.valueOf(120000));
          list.put(Integer.valueOf(42057), Integer.valueOf(80000));
          list.put(Integer.valueOf(42060), Integer.valueOf(80000));
          list.put(Integer.valueOf(42070), Integer.valueOf(80000));
          list.put(Integer.valueOf(42095), Integer.valueOf(120000));
          list.put(Integer.valueOf(42096), Integer.valueOf(120000));
          list.put(Integer.valueOf(42292), Integer.valueOf(80000));
          list.put(Integer.valueOf(42602), Integer.valueOf(80000));
        }
        break;
      case 1304:
        if (num == 1)
        {
          list.put(Integer.valueOf(42011), Integer.valueOf(56666));
          list.put(Integer.valueOf(42012), Integer.valueOf(56666));
          list.put(Integer.valueOf(42041), Integer.valueOf(88888));
          list.put(Integer.valueOf(42042), Integer.valueOf(88888));
          list.put(Integer.valueOf(42043), Integer.valueOf(88888));
          list.put(Integer.valueOf(42044), Integer.valueOf(88888));
          list.put(Integer.valueOf(42045), Integer.valueOf(88888));
          list.put(Integer.valueOf(42060), Integer.valueOf(56666));
          list.put(Integer.valueOf(42086), Integer.valueOf(30000));
          list.put(Integer.valueOf(42091), Integer.valueOf(88888));
          list.put(Integer.valueOf(42092), Integer.valueOf(88888));
          list.put(Integer.valueOf(42093), Integer.valueOf(88888));
          list.put(Integer.valueOf(42094), Integer.valueOf(88888));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(42011), Integer.valueOf(56666));
          list.put(Integer.valueOf(42012), Integer.valueOf(56666));
          list.put(Integer.valueOf(42041), Integer.valueOf(88888));
          list.put(Integer.valueOf(42042), Integer.valueOf(88888));
          list.put(Integer.valueOf(42043), Integer.valueOf(88888));
          list.put(Integer.valueOf(42044), Integer.valueOf(88888));
          list.put(Integer.valueOf(42045), Integer.valueOf(88888));
          list.put(Integer.valueOf(42060), Integer.valueOf(56666));
          list.put(Integer.valueOf(42086), Integer.valueOf(30000));
          list.put(Integer.valueOf(42091), Integer.valueOf(88888));
          list.put(Integer.valueOf(42092), Integer.valueOf(88888));
          list.put(Integer.valueOf(42093), Integer.valueOf(88888));
          list.put(Integer.valueOf(42094), Integer.valueOf(88888));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(42011), Integer.valueOf(56666));
          list.put(Integer.valueOf(42012), Integer.valueOf(56666));
          list.put(Integer.valueOf(42041), Integer.valueOf(88888));
          list.put(Integer.valueOf(42042), Integer.valueOf(88888));
          list.put(Integer.valueOf(42043), Integer.valueOf(88888));
          list.put(Integer.valueOf(42044), Integer.valueOf(88888));
          list.put(Integer.valueOf(42045), Integer.valueOf(88888));
          list.put(Integer.valueOf(42060), Integer.valueOf(56666));
          list.put(Integer.valueOf(42086), Integer.valueOf(30000));
          list.put(Integer.valueOf(42091), Integer.valueOf(88888));
          list.put(Integer.valueOf(42092), Integer.valueOf(88888));
          list.put(Integer.valueOf(42093), Integer.valueOf(88888));
          list.put(Integer.valueOf(42094), Integer.valueOf(88888));
        }
        break;
      case 1309:
        if (num == 1)
        {
          list.put(Integer.valueOf(42011), Integer.valueOf(62500));
          list.put(Integer.valueOf(42012), Integer.valueOf(62500));
          list.put(Integer.valueOf(42041), Integer.valueOf(75000));
          list.put(Integer.valueOf(42042), Integer.valueOf(75000));
          list.put(Integer.valueOf(42043), Integer.valueOf(75000));
          list.put(Integer.valueOf(42044), Integer.valueOf(75000));
          list.put(Integer.valueOf(42045), Integer.valueOf(62500));
          list.put(Integer.valueOf(42086), Integer.valueOf(62500));
          list.put(Integer.valueOf(42091), Integer.valueOf(75000));
          list.put(Integer.valueOf(42092), Integer.valueOf(75000));
          list.put(Integer.valueOf(42093), Integer.valueOf(75000));
          list.put(Integer.valueOf(42094), Integer.valueOf(75000));
          list.put(Integer.valueOf(42650), Integer.valueOf(75000));
          list.put(Integer.valueOf(42656), Integer.valueOf(75000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(42011), Integer.valueOf(62500));
          list.put(Integer.valueOf(42012), Integer.valueOf(62500));
          list.put(Integer.valueOf(42041), Integer.valueOf(75000));
          list.put(Integer.valueOf(42042), Integer.valueOf(75000));
          list.put(Integer.valueOf(42043), Integer.valueOf(75000));
          list.put(Integer.valueOf(42044), Integer.valueOf(75000));
          list.put(Integer.valueOf(42045), Integer.valueOf(62500));
          list.put(Integer.valueOf(42086), Integer.valueOf(62500));
          list.put(Integer.valueOf(42091), Integer.valueOf(75000));
          list.put(Integer.valueOf(42092), Integer.valueOf(75000));
          list.put(Integer.valueOf(42093), Integer.valueOf(75000));
          list.put(Integer.valueOf(42094), Integer.valueOf(75000));
          list.put(Integer.valueOf(42650), Integer.valueOf(75000));
          list.put(Integer.valueOf(42656), Integer.valueOf(75000));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(42011), Integer.valueOf(62500));
          list.put(Integer.valueOf(42012), Integer.valueOf(62500));
          list.put(Integer.valueOf(42041), Integer.valueOf(75000));
          list.put(Integer.valueOf(42042), Integer.valueOf(75000));
          list.put(Integer.valueOf(42043), Integer.valueOf(75000));
          list.put(Integer.valueOf(42044), Integer.valueOf(75000));
          list.put(Integer.valueOf(42045), Integer.valueOf(62500));
          list.put(Integer.valueOf(42086), Integer.valueOf(62500));
          list.put(Integer.valueOf(42091), Integer.valueOf(75000));
          list.put(Integer.valueOf(42092), Integer.valueOf(75000));
          list.put(Integer.valueOf(42093), Integer.valueOf(75000));
          list.put(Integer.valueOf(42094), Integer.valueOf(75000));
          list.put(Integer.valueOf(42650), Integer.valueOf(75000));
          list.put(Integer.valueOf(42656), Integer.valueOf(75000));
        }
        break;
      case 1305:
        if (num == 1)
        {
          list.put(Integer.valueOf(42046), Integer.valueOf(111111));
          list.put(Integer.valueOf(42051), Integer.valueOf(111111));
          list.put(Integer.valueOf(42053), Integer.valueOf(111111));
          list.put(Integer.valueOf(42057), Integer.valueOf(111111));
          list.put(Integer.valueOf(42070), Integer.valueOf(111111));
          list.put(Integer.valueOf(42087), Integer.valueOf(111111));
          list.put(Integer.valueOf(42095), Integer.valueOf(111111));
          list.put(Integer.valueOf(42096), Integer.valueOf(111111));
          list.put(Integer.valueOf(42292), Integer.valueOf(111111));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(42046), Integer.valueOf(111111));
          list.put(Integer.valueOf(42051), Integer.valueOf(111111));
          list.put(Integer.valueOf(42053), Integer.valueOf(111111));
          list.put(Integer.valueOf(42057), Integer.valueOf(111111));
          list.put(Integer.valueOf(42070), Integer.valueOf(111111));
          list.put(Integer.valueOf(42087), Integer.valueOf(111111));
          list.put(Integer.valueOf(42095), Integer.valueOf(111111));
          list.put(Integer.valueOf(42096), Integer.valueOf(111111));
          list.put(Integer.valueOf(42292), Integer.valueOf(111111));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(42046), Integer.valueOf(111111));
          list.put(Integer.valueOf(42051), Integer.valueOf(111111));
          list.put(Integer.valueOf(42053), Integer.valueOf(111111));
          list.put(Integer.valueOf(42057), Integer.valueOf(111111));
          list.put(Integer.valueOf(42070), Integer.valueOf(111111));
          list.put(Integer.valueOf(42087), Integer.valueOf(111111));
          list.put(Integer.valueOf(42095), Integer.valueOf(111111));
          list.put(Integer.valueOf(42096), Integer.valueOf(111111));
          list.put(Integer.valueOf(42292), Integer.valueOf(111111));
        }
        break;
      case 1306:
        if (num == 1)
        {
          list.put(Integer.valueOf(42011), Integer.valueOf(125000));
          list.put(Integer.valueOf(42012), Integer.valueOf(125000));
          list.put(Integer.valueOf(42041), Integer.valueOf(60000));
          list.put(Integer.valueOf(42042), Integer.valueOf(60000));
          list.put(Integer.valueOf(42043), Integer.valueOf(60000));
          list.put(Integer.valueOf(42044), Integer.valueOf(60000));
          list.put(Integer.valueOf(42045), Integer.valueOf(60000));
          list.put(Integer.valueOf(42060), Integer.valueOf(75000));
          list.put(Integer.valueOf(42061), Integer.valueOf(75000));
          list.put(Integer.valueOf(42086), Integer.valueOf(60000));
          list.put(Integer.valueOf(42091), Integer.valueOf(60000));
          list.put(Integer.valueOf(42092), Integer.valueOf(60000));
          list.put(Integer.valueOf(42093), Integer.valueOf(60000));
          list.put(Integer.valueOf(42094), Integer.valueOf(60000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(42011), Integer.valueOf(125000));
          list.put(Integer.valueOf(42012), Integer.valueOf(125000));
          list.put(Integer.valueOf(42041), Integer.valueOf(60000));
          list.put(Integer.valueOf(42042), Integer.valueOf(60000));
          list.put(Integer.valueOf(42043), Integer.valueOf(60000));
          list.put(Integer.valueOf(42044), Integer.valueOf(60000));
          list.put(Integer.valueOf(42045), Integer.valueOf(60000));
          list.put(Integer.valueOf(42060), Integer.valueOf(75000));
          list.put(Integer.valueOf(42061), Integer.valueOf(75000));
          list.put(Integer.valueOf(42086), Integer.valueOf(60000));
          list.put(Integer.valueOf(42091), Integer.valueOf(60000));
          list.put(Integer.valueOf(42092), Integer.valueOf(60000));
          list.put(Integer.valueOf(42093), Integer.valueOf(60000));
          list.put(Integer.valueOf(42094), Integer.valueOf(60000));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(42011), Integer.valueOf(125000));
          list.put(Integer.valueOf(42012), Integer.valueOf(125000));
          list.put(Integer.valueOf(42041), Integer.valueOf(60000));
          list.put(Integer.valueOf(42042), Integer.valueOf(60000));
          list.put(Integer.valueOf(42043), Integer.valueOf(60000));
          list.put(Integer.valueOf(42044), Integer.valueOf(60000));
          list.put(Integer.valueOf(42045), Integer.valueOf(60000));
          list.put(Integer.valueOf(42060), Integer.valueOf(75000));
          list.put(Integer.valueOf(42061), Integer.valueOf(75000));
          list.put(Integer.valueOf(42086), Integer.valueOf(60000));
          list.put(Integer.valueOf(42091), Integer.valueOf(60000));
          list.put(Integer.valueOf(42092), Integer.valueOf(60000));
          list.put(Integer.valueOf(42093), Integer.valueOf(60000));
          list.put(Integer.valueOf(42094), Integer.valueOf(60000));
        }
        break;
      case 1307:
        if (num == 1)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(120000));
          list.put(Integer.valueOf(42051), Integer.valueOf(120000));
          list.put(Integer.valueOf(42053), Integer.valueOf(120000));
          list.put(Integer.valueOf(42057), Integer.valueOf(80000));
          list.put(Integer.valueOf(42060), Integer.valueOf(80000));
          list.put(Integer.valueOf(42070), Integer.valueOf(80000));
          list.put(Integer.valueOf(42095), Integer.valueOf(120000));
          list.put(Integer.valueOf(42096), Integer.valueOf(120000));
          list.put(Integer.valueOf(42292), Integer.valueOf(80000));
          list.put(Integer.valueOf(42602), Integer.valueOf(80000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(120000));
          list.put(Integer.valueOf(42051), Integer.valueOf(120000));
          list.put(Integer.valueOf(42053), Integer.valueOf(120000));
          list.put(Integer.valueOf(42057), Integer.valueOf(80000));
          list.put(Integer.valueOf(42060), Integer.valueOf(80000));
          list.put(Integer.valueOf(42070), Integer.valueOf(80000));
          list.put(Integer.valueOf(42095), Integer.valueOf(120000));
          list.put(Integer.valueOf(42096), Integer.valueOf(120000));
          list.put(Integer.valueOf(42292), Integer.valueOf(80000));
          list.put(Integer.valueOf(42602), Integer.valueOf(80000));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(42045), Integer.valueOf(120000));
          list.put(Integer.valueOf(42051), Integer.valueOf(120000));
          list.put(Integer.valueOf(42053), Integer.valueOf(120000));
          list.put(Integer.valueOf(42057), Integer.valueOf(80000));
          list.put(Integer.valueOf(42060), Integer.valueOf(80000));
          list.put(Integer.valueOf(42070), Integer.valueOf(80000));
          list.put(Integer.valueOf(42095), Integer.valueOf(120000));
          list.put(Integer.valueOf(42096), Integer.valueOf(120000));
          list.put(Integer.valueOf(42292), Integer.valueOf(80000));
          list.put(Integer.valueOf(42602), Integer.valueOf(80000));
        }
        break;
      case 1308:
        if (num == 1)
        {
          list.put(Integer.valueOf(42011), Integer.valueOf(75000));
          list.put(Integer.valueOf(42012), Integer.valueOf(75000));
          list.put(Integer.valueOf(42041), Integer.valueOf(85000));
          list.put(Integer.valueOf(42042), Integer.valueOf(85000));
          list.put(Integer.valueOf(42043), Integer.valueOf(85000));
          list.put(Integer.valueOf(42044), Integer.valueOf(85000));
          list.put(Integer.valueOf(42045), Integer.valueOf(85000));
          list.put(Integer.valueOf(42086), Integer.valueOf(85000));
          list.put(Integer.valueOf(42091), Integer.valueOf(85000));
          list.put(Integer.valueOf(42092), Integer.valueOf(85000));
          list.put(Integer.valueOf(42093), Integer.valueOf(85000));
          list.put(Integer.valueOf(42094), Integer.valueOf(85000));
          break;
        }
        if (num == 2)
        {
          list.put(Integer.valueOf(42011), Integer.valueOf(75000));
          list.put(Integer.valueOf(42012), Integer.valueOf(75000));
          list.put(Integer.valueOf(42041), Integer.valueOf(85000));
          list.put(Integer.valueOf(42042), Integer.valueOf(85000));
          list.put(Integer.valueOf(42043), Integer.valueOf(85000));
          list.put(Integer.valueOf(42044), Integer.valueOf(85000));
          list.put(Integer.valueOf(42045), Integer.valueOf(85000));
          list.put(Integer.valueOf(42086), Integer.valueOf(85000));
          list.put(Integer.valueOf(42091), Integer.valueOf(85000));
          list.put(Integer.valueOf(42092), Integer.valueOf(85000));
          list.put(Integer.valueOf(42093), Integer.valueOf(85000));
          list.put(Integer.valueOf(42094), Integer.valueOf(85000));
          break;
        }
        if (num == 3)
        {
          list.put(Integer.valueOf(42011), Integer.valueOf(75000));
          list.put(Integer.valueOf(42012), Integer.valueOf(75000));
          list.put(Integer.valueOf(42041), Integer.valueOf(85000));
          list.put(Integer.valueOf(42042), Integer.valueOf(85000));
          list.put(Integer.valueOf(42043), Integer.valueOf(85000));
          list.put(Integer.valueOf(42044), Integer.valueOf(85000));
          list.put(Integer.valueOf(42045), Integer.valueOf(85000));
          list.put(Integer.valueOf(42086), Integer.valueOf(85000));
          list.put(Integer.valueOf(42091), Integer.valueOf(85000));
          list.put(Integer.valueOf(42092), Integer.valueOf(85000));
          list.put(Integer.valueOf(42093), Integer.valueOf(85000));
          list.put(Integer.valueOf(42094), Integer.valueOf(85000));
        }
        break;
    }
    return list;
  }
  
  public static int getWeightedRandom(Map<Integer, Integer> weights)
  {
    int potentialid = 0;
    double bestValue = Double.MAX_VALUE;
    for (Map.Entry<Integer, Integer> element : weights.entrySet())
    {
      double a = element.getValue().intValue();
      double r = a / 10000.0D;
      double value = -Math.log(Randomizer.nextDouble()) / r;
      if (value < bestValue)
      {
        bestValue = value;
        potentialid = element.getKey().intValue();
      }
    }
    return potentialid;
  }
}
