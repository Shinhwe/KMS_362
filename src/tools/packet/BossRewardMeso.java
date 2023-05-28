/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.packet;

import com.alibaba.fastjson2.JSON;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


public class BossRewardMeso
{
  private static ArrayList<BossRewardMesoItem> bossRewardMesoList = new ArrayList<>();

  private static HashMap<Integer, BossRewardMesoItem> bossRewardMesoMap = new HashMap<>();


  public static void Load ()
  {
    try
    {
      FileInputStream fileInputStream = new FileInputStream("Properties/BossRewardMeso.properties");
      InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
      Properties setting = new Properties();
      setting.load(inputStreamReader);
      inputStreamReader.close();
      fileInputStream.close();
      bossRewardMesoList.clear();
      String jsonString = setting.getProperty("meso");
      List<BossRewardMesoItem> list = JSON.parseArray(jsonString, BossRewardMesoItem.class).stream().toList();
      bossRewardMesoList.addAll(list);

      for (BossRewardMesoItem bossRewardMesoItem : bossRewardMesoList)
      {
        bossRewardMesoMap.put(bossRewardMesoItem.bossId, bossRewardMesoItem);
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }


  public static ArrayList<BossRewardMesoItem> getBossRewardMesoList ()
  {
    return bossRewardMesoList;
  }

  public static BossRewardMesoItem getBossRewardMesoItem (int bossId)
  {
    if (bossRewardMesoMap.containsKey(Integer.valueOf(bossId)))
    {
      return bossRewardMesoMap.get(Integer.valueOf(bossId));
    }
    return null;
  }

}
