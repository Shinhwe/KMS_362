package constants;

import java.util.ArrayList;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public class 權重算法
{
  public static 權重 計算權重 (ArrayList<權重> 權重List)
  {
    TreeMap<Integer, 權重> weightMap = new TreeMap();

    for (權重 item : 權重List)
    {
      Integer lastWeight = weightMap.size() == 0 ? 0 : weightMap.lastKey();
      weightMap.put(item.獲取權重() + lastWeight, item);
    }

    Random random = new Random();

    Integer randomWeight = random.nextInt(weightMap.lastKey());

    SortedMap<Integer, 權重> tailMap = weightMap.tailMap(randomWeight, false);

    return weightMap.get(tailMap.firstKey());
  }
}
