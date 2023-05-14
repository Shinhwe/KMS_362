package server.quest;

import server.RandomRewards;
import server.Randomizer;

class QuestItem
{
  private final int itemid;
  
  private final int count;
  
  private final int period;
  
  private final int gender;
  
  private final int job;
  
  private final int jobEx;
  
  private final int prop;
  
  public QuestItem(int itemid, int count, int period, int gender, int job, int jobEx, int prop)
  {
    if (RandomRewards.getTenPercent().contains(Integer.valueOf(itemid)))
    {
      count += Randomizer.nextInt(3);
    }
    this.itemid = itemid;
    this.count = count;
    this.period = period;
    this.gender = gender;
    this.job = job;
    this.jobEx = jobEx;
    this.prop = prop;
  }
  
  public int getItemId()
  {
    return this.itemid;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public int getPeriod()
  {
    return this.period;
  }
  
  public int getGender()
  {
    return this.gender;
  }
  
  public int getJob()
  {
    return this.job;
  }
  
  public int getJobEx()
  {
    return this.jobEx;
  }
  
  public int getProp()
  {
    return this.prop;
  }
}
