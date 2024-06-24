package client;

import java.io.Serializable;

public class SkillEntry implements Serializable
{
  private static final long serialVersionUID = 9179541993413738569L;
  
  public int skillevel;
  
  public int masterlevel;
  
  public long expiration;
  
  public SkillEntry(int skillevel, int masterlevel, long expiration)
  {
    this.skillevel = skillevel;
    this.masterlevel = masterlevel;
    this.expiration = expiration;
  }
}
