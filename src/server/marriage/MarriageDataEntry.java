package server.marriage;

import client.inventory.Item;

import java.util.ArrayList;
import java.util.List;

public class MarriageDataEntry
{
  private final int marriageId;
  
  private boolean newData;
  
  private int groomId;
  
  private int brideId;
  
  private String groomName;
  
  private String brideName;
  
  private boolean groomWhisCheck = false;
  
  private boolean brideWhisCheck = false;
  
  private int status;
  
  private int weddingStatus;
  
  private List<String> groomWishList;
  
  private List<String> brideWishList;
  
  private List<Item> groomWeddingPresents;
  
  private List<Item> brideWeddingPresents;
  
  private List<Integer> reservedPeople;
  
  private List<Integer> enteredPeople;
  
  private MarriageTicketType ticketType;
  
  private long EngagementTime;
  
  private long MakeReservationTime;
  
  private long RequestDivorceTimeGroom;
  
  private long RequestDivorceTimeBride;
  
  public MarriageDataEntry(int id, boolean newData)
  {
    this.marriageId = id;
    this.newData = newData;
    this.weddingStatus = 0;
    this.ticketType = null;
    this.MakeReservationTime = 0L;
    this.RequestDivorceTimeBride = 0L;
    this.RequestDivorceTimeGroom = 0L;
  }
  
  public int getMarriageId()
  {
    return this.marriageId;
  }
  
  public int getGroomId()
  {
    return this.groomId;
  }
  
  public void setGroomId(int in)
  {
    this.groomId = in;
  }
  
  public int getBrideId()
  {
    return this.brideId;
  }
  
  public void setBrideId(int in)
  {
    this.brideId = in;
  }
  
  public String getGroomName()
  {
    return this.groomName;
  }
  
  public void setGroomName(String str)
  {
    this.groomName = str;
  }
  
  public String getBrideName()
  {
    return this.brideName;
  }
  
  public void setBrideName(String str)
  {
    this.brideName = str;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setStatus(int stat)
  {
    this.status = stat;
  }
  
  public boolean isNewData()
  {
    return this.newData;
  }
  
  public void setNewData(boolean l)
  {
    this.newData = l;
  }
  
  public int getWeddingStatus()
  {
    return this.weddingStatus;
  }
  
  public void setWeddingStatus(int g)
  {
    this.weddingStatus = g;
  }
  
  public List<String> getGroomWishList()
  {
    if (this.groomWishList == null)
    {
      this.groomWishList = new ArrayList<>();
    }
    return this.groomWishList;
  }
  
  public List<String> getBrideWishList()
  {
    if (this.brideWishList == null)
    {
      this.brideWishList = new ArrayList<>();
    }
    return this.brideWishList;
  }
  
  public List<Item> getGroomPresentList()
  {
    if (this.groomWeddingPresents == null)
    {
      this.groomWeddingPresents = new ArrayList<>();
    }
    return this.groomWeddingPresents;
  }
  
  public List<Item> getBridePresentList()
  {
    if (this.brideWeddingPresents == null)
    {
      this.brideWeddingPresents = new ArrayList<>();
    }
    return this.brideWeddingPresents;
  }
  
  public List<Integer> getReservedPeopleList()
  {
    if (this.reservedPeople == null)
    {
      this.reservedPeople = new ArrayList<>();
    }
    return this.reservedPeople;
  }
  
  public List<Integer> getEnteredPeopleList()
  {
    if (this.enteredPeople == null)
    {
      this.enteredPeople = new ArrayList<>();
    }
    return this.enteredPeople;
  }
  
  public MarriageTicketType getTicketType()
  {
    return this.ticketType;
  }
  
  public void setTicketType(MarriageTicketType type)
  {
    this.ticketType = type;
  }
  
  public long getEngagementTime()
  {
    return this.EngagementTime;
  }
  
  public void setEngagementTime(long time)
  {
    this.EngagementTime = time;
  }
  
  public long getMakeReservationTime()
  {
    return this.MakeReservationTime;
  }
  
  public void setMakeReservationTime(long time)
  {
    this.MakeReservationTime = time;
  }
  
  public long getDivorceTimeGroom()
  {
    return this.RequestDivorceTimeGroom;
  }
  
  public void setDivorceTimeGroom(long time)
  {
    this.RequestDivorceTimeGroom = time;
  }
  
  public long getDivorceTimeBride()
  {
    return this.RequestDivorceTimeBride;
  }
  
  public void setDivorceTimeBride(long time)
  {
    this.RequestDivorceTimeBride = time;
  }
  
  public int getPartnerId(int id)
  {
    if (id == getGroomId())
    {
      return getBrideId();
    }
    if (id == getBrideId())
    {
      return getGroomId();
    }
    return -1;
  }
  
  public boolean getBWhisCheck()
  {
    return this.brideWhisCheck;
  }
  
  public void setBWhisCheck(boolean a)
  {
    if (this.brideWishList != null && this.brideWishList.size() > 0)
    {
      this.brideWhisCheck = true;
      return;
    }
    this.brideWhisCheck = a;
  }
  
  public boolean getGWhisCheck()
  {
    return this.groomWhisCheck;
  }
  
  public void setGWhisCheck(boolean a)
  {
    if (this.groomWishList != null && this.groomWishList.size() > 0)
    {
      this.groomWhisCheck = true;
      return;
    }
    this.groomWhisCheck = a;
  }
}
