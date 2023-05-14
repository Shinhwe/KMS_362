package server.maps;

import client.MapleCharacter;
import client.MapleClient;
import server.MaplePortal;
import tools.packet.CField;
import tools.packet.CWvsContext;

import java.awt.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MapleDoor extends MapleMapObject
{
  private final WeakReference<MapleCharacter> owner;
  
  private final MapleMap town;
  
  private final MaplePortal townPortal;
  
  private final MapleMap target;
  
  private final int skillId;
  
  private final int ownerId;
  
  private final Point targetPosition;
  
  public MapleDoor(MapleCharacter owner, Point targetPosition, int skillId)
  {
    this.owner = new WeakReference<>(owner);
    this.ownerId = owner.getId();
    this.target = owner.getMap();
    this.targetPosition = targetPosition;
    setPosition(this.targetPosition);
    this.town = this.target.getReturnMap();
    this.townPortal = getFreePortal();
    this.skillId = skillId;
  }
  
  public MapleDoor(MapleDoor origDoor)
  {
    this.owner = new WeakReference<>(origDoor.owner.get());
    this.town = origDoor.town;
    this.townPortal = origDoor.townPortal;
    this.target = origDoor.target;
    this.targetPosition = new Point(origDoor.targetPosition);
    this.skillId = origDoor.skillId;
    this.ownerId = origDoor.ownerId;
    setPosition(this.townPortal.getPosition());
  }
  
  public final int getSkill()
  {
    return this.skillId;
  }
  
  public final int getOwnerId()
  {
    return this.ownerId;
  }
  
  private final MaplePortal getFreePortal()
  {
    List<MaplePortal> freePortals = new ArrayList<>();
    for (MaplePortal port : this.town.getPortals())
    {
      if (port.getType() == 6)
      {
        freePortals.add(port);
      }
    }
    Collections.sort(freePortals, new Comparator<MaplePortal>()
    {
      public int compare(MaplePortal o1, MaplePortal o2)
      {
        if (o1.getId() < o2.getId())
        {
          return -1;
        }
        if (o1.getId() == o2.getId())
        {
          return 0;
        }
        return 1;
      }
    });
    for (MapleMapObject obj : this.town.getAllDoorsThreadsafe())
    {
      MapleDoor door = (MapleDoor) obj;
      if (door.getOwner() != null && door.getOwner().getParty() != null && getOwner() != null && getOwner().getParty() != null && getOwner().getParty().getId() == door.getOwner().getParty().getId())
      {
        return null;
      }
      freePortals.remove(door.getTownPortal());
    }
    if (freePortals.size() <= 0)
    {
      return null;
    }
    return freePortals.iterator().next();
  }
  
  public final void sendSpawnData(MapleClient client)
  {
    if (getOwner() == null || this.target == null || client.getPlayer() == null)
    {
      return;
    }
    if (this.target.getId() == client.getPlayer().getMapId() || getOwnerId() == client.getPlayer().getId() || (getOwner() != null && getOwner().getParty() != null && client.getPlayer().getParty() != null && getOwner().getParty().getId() == client.getPlayer().getParty().getId()))
    {
      client.getSession().writeAndFlush(CField.spawnDoor(getOwnerId(), (this.target.getId() == client.getPlayer().getMapId()) ? this.targetPosition : this.townPortal.getPosition(), true));
      if (getOwner() != null && getOwner().getParty() != null && client.getPlayer().getParty() != null && (getOwnerId() == client.getPlayer().getId() || getOwner().getParty().getId() == client.getPlayer().getParty().getId()))
      {
        client.getSession().writeAndFlush(CWvsContext.PartyPacket.partyPortal(this.town.getId(), this.target.getId(), this.skillId, (this.target.getId() == client.getPlayer().getMapId()) ? this.targetPosition : this.townPortal.getPosition(), true));
      }
      client.getSession().writeAndFlush(CWvsContext.spawnPortal(this.town.getId(), this.target.getId(), this.skillId, (this.target.getId() == client.getPlayer().getMapId()) ? this.targetPosition : this.townPortal.getPosition()));
    }
  }
  
  public final void sendDestroyData(MapleClient client)
  {
    if (client.getPlayer() == null || getOwner() == null || this.target == null)
    {
      return;
    }
    if (this.target.getId() == client.getPlayer().getMapId() || getOwnerId() == client.getPlayer().getId() || (getOwner() != null && getOwner().getParty() != null && client.getPlayer().getParty() != null && getOwner().getParty().getId() == client.getPlayer().getParty().getId()))
    {
      client.getSession().writeAndFlush(CField.removeDoor(getOwnerId(), false));
      if (getOwner() != null && getOwner().getParty() != null && client.getPlayer().getParty() != null && (getOwnerId() == client.getPlayer().getId() || getOwner().getParty().getId() == client.getPlayer().getParty().getId()))
      {
        client.getSession().writeAndFlush(CWvsContext.PartyPacket.partyPortal(999999999, 999999999, 0, new Point(-1, -1), false));
      }
      client.getSession().writeAndFlush(CWvsContext.spawnPortal(999999999, 999999999, 0, null));
    }
  }
  
  public final void warp(MapleCharacter chr, boolean toTown)
  {
    if (chr.getId() == getOwnerId() || (getOwner() != null && getOwner().getParty() != null && chr.getParty() != null && getOwner().getParty().getId() == chr.getParty().getId()))
    {
      if (!toTown)
      {
        chr.changeMap(this.target, this.target.findClosestPortal(this.targetPosition));
      }
      else
      {
        chr.changeMap(this.town, this.townPortal);
      }
    }
    else
    {
      chr.getClient().getSession().writeAndFlush(CWvsContext.enableActions(chr));
    }
  }
  
  public final MapleCharacter getOwner()
  {
    return this.owner.get();
  }
  
  public final MapleMap getTown()
  {
    return this.town;
  }
  
  public final MaplePortal getTownPortal()
  {
    return this.townPortal;
  }
  
  public final MapleMap getTarget()
  {
    return this.target;
  }
  
  public final Point getTargetPosition()
  {
    return this.targetPosition;
  }
  
  public final MapleMapObjectType getType()
  {
    return MapleMapObjectType.DOOR;
  }
}
