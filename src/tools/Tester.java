package tools;

import constants.權重;
import constants.權重算法;

import java.util.ArrayList;
import java.util.HashMap;

public class Tester
{

  public static void main (String[] args)
  {
    // long flame = 10241201051L;
    //
    // int flameOption1 = (int) (flame % 1000L / 10L);
    //
    // int flameValue1 = (int) (flame % 10L / 1L);
    //
    // int flameOption2 = (int) (flame % 1000000L / 10000L);
    //
    // int flameValue2 = (int) (flame % 10000L / 1000L);
    //
    // int flameOption3 = (int) (flame % 1000000000L / 10000000L);
    //
    // int flameValue3 = (int) (int) (flame % 10000000L / 1000000L);
    //
    // int flameOption4 = (int) (flame % 1000000000000L / 10000000000L);
    //
    // int flameValue4 = (int) (int) (flame % 10000000000L / 1000000000L);
    //
    // int[] flameOptionList = new int[] { flameOption1, flameOption2, flameOption3, flameOption4 };
    //
    // int[] flameValueList = new int[] { flameValue1, flameValue2, flameValue3, flameValue4 };
    //
    // System.out.println(flameOption1);
    //
    // System.out.println(flameOption2);
    //
    // System.out.println(flameOption3);
    //
    // System.out.println(flameOption4);
    //
    // System.out.println(flameValue1);
    //
    // System.out.println(flameValue2);
    //
    // System.out.println(flameValue3);
    //
    // System.out.println(flameValue4);

    HashMap<Integer, ArrayList<權重>> 頭盔潛能權重Map = new HashMap<>();

    ArrayList<權重> 等級1潛能權重 = new ArrayList<>();

    等級1潛能權重.add(new 權重(10001, 600));
    等級1潛能權重.add(new 權重(10002, 600));
    等級1潛能權重.add(new 權重(10003, 600));
    等級1潛能權重.add(new 權重(10004, 600));
    等級1潛能權重.add(new 權重(10005, 1000));
    等級1潛能權重.add(new 權重(10006, 1000));
    等級1潛能權重.add(new 權重(10013, 800));
    等級1潛能權重.add(new 權重(10041, 600));
    等級1潛能權重.add(new 權重(10042, 600));
    等級1潛能權重.add(new 權重(10043, 600));
    等級1潛能權重.add(new 權重(10044, 600));
    等級1潛能權重.add(new 權重(10045, 600));
    等級1潛能權重.add(new 權重(10046, 600));
    等級1潛能權重.add(new 權重(10053, 800));
    等級1潛能權重.add(new 權重(10081, 400));

    ArrayList<權重> 等級2潛能權重 = new ArrayList<>();

    等級2潛能權重.add(new 權重(20041, 1190));
    等級2潛能權重.add(new 權重(20042, 1190));
    等級2潛能權重.add(new 權重(20043, 1190));
    等級2潛能權重.add(new 權重(20044, 1190));
    等級2潛能權重.add(new 權重(20045, 1667));
    等級2潛能權重.add(new 權重(20046, 1667));
    等級2潛能權重.add(new 權重(20053, 1429));
    等級2潛能權重.add(new 權重(20086, 476));

    ArrayList<權重> 等級3潛能權重 = new ArrayList<>();

    等級3潛能權重.add(new 權重(31002, 635));
    等級3潛能權重.add(new 權重(30041, 794));
    等級3潛能權重.add(new 權重(30042, 794));
    等級3潛能權重.add(new 權重(30043, 794));
    等級3潛能權重.add(new 權重(30044, 794));
    等級3潛能權重.add(new 權重(30045, 952));
    等級3潛能權重.add(new 權重(30046, 952));
    等級3潛能權重.add(new 權重(30053, 1587));
    等級3潛能權重.add(new 權重(30086, 635));
    等級3潛能權重.add(new 權重(30356, 635));
    等級3潛能權重.add(new 權重(30357, 635));
    等級3潛能權重.add(new 權重(30551, 794));
    等級3潛能權重.add(new 權重(30106, 1234));
    等級3潛能權重.add(new 權重(30107, 1234));

    ArrayList<權重> 等級4潛能權重 = new ArrayList<>();

    等級4潛能權重.add(new 權重(40556, 566));
    等級4潛能權重.add(new 權重(40557, 377));
    等級4潛能權重.add(new 權重(41006, 566));
    等級4潛能權重.add(new 權重(40041, 755));
    等級4潛能權重.add(new 權重(40042, 755));
    等級4潛能權重.add(new 權重(40043, 755));
    等級4潛能權重.add(new 權重(40044, 755));
    等級4潛能權重.add(new 權重(40045, 755));
    等級4潛能權重.add(new 權重(40046, 755));
    等級4潛能權重.add(new 權重(40053, 1887));
    等級4潛能權重.add(new 權重(40086, 566));
    等級4潛能權重.add(new 權重(40356, 755));
    等級4潛能權重.add(new 權重(40357, 755));
    等級4潛能權重.add(new 權重(40106, 1234));
    等級4潛能權重.add(new 權重(40107, 1234));


    頭盔潛能權重Map.put(1, 等級1潛能權重);

    頭盔潛能權重Map.put(2, 等級2潛能權重);

    頭盔潛能權重Map.put(3, 等級3潛能權重);

    頭盔潛能權重Map.put(4, 等級4潛能權重);


    final int NUM_TESTS = 1000000;


    HashMap<Integer, Integer> 權重算法結果 = new HashMap<>();

    for (int i = 1; i <= NUM_TESTS; i++)
    {
      權重 計算結果 = 權重算法.計算權重(頭盔潛能權重Map.get(4));

      int 潛能Id = 計算結果.獲取值();

      if (權重算法結果.containsKey(潛能Id) == false)
      {
        權重算法結果.put(潛能Id, 0);
      }
      int 當前id出現次數 = 權重算法結果.get(潛能Id);
      權重算法結果.put(潛能Id, 當前id出現次數 + 1);
    }

    權重算法結果.keySet().forEach(key ->
    {
      System.out.println("潛能Id  " + key + " 出現了 " + 權重算法結果.get(key) + " 次");
    });

  }

}
