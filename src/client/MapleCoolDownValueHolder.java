package client;

public class MapleCoolDownValueHolder
{
  public int skillId;
  
  public long startTime;
  
  public long cooldownTimeMS;
  
  public MapleCoolDownValueHolder(int skillId, long startTime, long cooldownTimeMS)
  {
    this.skillId = skillId;
    this.startTime = startTime;
    this.cooldownTimeMS = cooldownTimeMS;
  }
}
