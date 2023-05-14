package client;

import tools.Pair;

import java.util.List;

public class RandomSkillEntry
{
  private final int skillid;
  
  private final int prob;
  
  private final List<Pair<Integer, Integer>> skillList;
  
  public RandomSkillEntry(int skillid, int prob, List<Pair<Integer, Integer>> skillList)
  {
    this.skillid = skillid;
    this.prob = prob;
    this.skillList = skillList;
  }
  
  public int getSkillId()
  {
    return this.skillid;
  }
  
  public int getProb()
  {
    return this.prob;
  }
  
  public List<Pair<Integer, Integer>> getSkillList()
  {
    return this.skillList;
  }
}
