package constants;

import java.util.*;

public class 潛能權重算法
{
  public static 潛能權重 計算潛能權重 (ArrayList<潛能權重> 權重List)
  {
    TreeMap<Integer, 潛能權重> weightMap = new TreeMap();

    for (潛能權重 item : 權重List)
    {
      Integer lastWeight = weightMap.size() == 0 ? 0 : weightMap.lastKey();
      weightMap.put(item.獲取權重() + lastWeight, item);
    }

    Random random = new Random();

    Integer randomWeight = random.nextInt(weightMap.lastKey());

    SortedMap<Integer, 潛能權重> tailMap = weightMap.tailMap(randomWeight, false);

    return weightMap.get(tailMap.firstKey());
  }
}
