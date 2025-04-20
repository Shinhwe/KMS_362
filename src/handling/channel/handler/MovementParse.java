// 
// Decompiled by Procyon v0.5.36
// 

package handling.channel.handler;

import client.MapleCharacter;
import server.maps.AnimatedMapleMapObject;
import server.movement.*;
import tools.data.LittleEndianAccessor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MovementParse
{
  public static List<LifeMovementFragment> parseMovement (final LittleEndianAccessor lea, final int kind)
  {
    return parseMovement(lea, kind, null);
  }

  public static List<LifeMovementFragment> parseMovement (final LittleEndianAccessor rh, final int kind, MapleCharacter chr)
  {
    final List<LifeMovementFragment> res = new ArrayList<LifeMovementFragment>();
    final short numCommands = rh.readShort();
    // rh.readByte();
    for (byte i = 0; i < numCommands; i++)
    {
      final byte command = rh.readByte();
      short nAttr = 0;
      switch (command)
      {
        case 0:
        case 8:
        case 15:
        case 19:
        case 69:
        case 70:
        case 71:
        case 72:
        case 73:
        case 74:
        case 91:
        case 105:
        {
          final short xpos = rh.readShort();
          final short ypos = rh.readShort();
          final short xwobble = rh.readShort();
          final short ywobble = rh.readShort();
          final short fh = rh.readShort();
          if (command == 15 || command == 17)
          {
            nAttr = rh.readShort();
          }
          final short xoffset = rh.readShort();
          final short yoffset = rh.readShort();
          final short v307 = rh.readShort();

          final byte newstate = rh.readByte();
          final short duration = rh.readShort();
          final byte unk = rh.readByte();
          final AbsoluteLifeMovement alm = new AbsoluteLifeMovement(command, new Point(xpos, ypos), duration, newstate, fh, unk);
          alm.setV307(v307);
          alm.setnAttr(nAttr);
          alm.setPixelsPerSecond(new Point(xwobble, ywobble));
          alm.setOffset(new Point(xoffset, yoffset));
          res.add(alm);
          break;
        }
        case 1:
        case 2:
        case 18:
        case 21:
        case 22:
        case 24:
        case 60:
        case 62:
        case 63:
        case 64:
        case 65:
        case 66:
        case 67:
        case 96:
        {
          Point v307 = null;
          final short xmod = rh.readShort();
          final short ymod = rh.readShort();
          if (command == 21 || command == 22)
          {
            nAttr = rh.readShort();
          }

          if (command == 60)
          {
            v307 = rh.readPos();
          }

          final byte newstate = rh.readByte();
          final short duration = rh.readShort();
          final byte unk = rh.readByte();
          final RelativeLifeMovement rlm = new RelativeLifeMovement(command, new Point(xmod, ymod), duration, newstate, unk);
          rlm.setAttr(nAttr);
          rlm.setV307(v307);
          res.add(rlm);

          break;
        }
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 9:
        case 10:
        case 11:
        case 13:
        case 26:
        case 27:
        case 52:
        case 53:
        case 54:
        case 80:
        case 81:
        case 82:
        case 84:
        case 86:
        {
          final short xpos = rh.readShort();
          final short ypos = rh.readShort();
          final short fh = rh.readShort();
          final int now = rh.readInt();
          final byte newstate = rh.readByte();
          final short duration = rh.readShort();
          final byte unk = rh.readByte();

          final ChairMovement cm = new ChairMovement(command, new Point(xpos, ypos), duration, newstate, fh, unk);
          cm.setUnk(now);
          res.add(cm);
          break;
        }
        case 12:
        {
          res.add(new ChangeEquipSpecialAwesome(command, rh.readByte()));
          break;
        }
        case 14:
        case 16:
        {
          final short xpos = rh.readShort();
          final short ypos = rh.readShort();
          /*-------*/
          nAttr = rh.readShort();
          final byte newstate = rh.readByte();
          final short duration = rh.readShort();
          final byte unk = rh.readByte();
          final SunknownMovement sum = new SunknownMovement(command, new Point(xpos, ypos), duration, newstate, unk);
          sum.setAttr(nAttr);
          res.add(sum);
          break;
        }
        case 23:
        case 99:
        case 100:
        {
          final short xpos = rh.readShort();
          final short ypos = rh.readShort();
          final short xoffset = rh.readShort();
          final short yoffset = rh.readShort();
          final byte newstate = rh.readByte();
          final short duration = rh.readShort();
          final byte unk = rh.readByte();
          final TunknownMovement tum = new TunknownMovement(command, new Point(xpos, ypos), duration, newstate, unk);
          tum.setOffset(new Point(xoffset, yoffset));
          res.add(tum);
          break;
        }
        case 28:
        {
          final int nnow = rh.readInt();
          final byte newstate = rh.readByte();
          final short duration = rh.readShort();
          final byte force = rh.readByte();
          final UnknownMovement3 um = new UnknownMovement3(command, new Point(0, 0), duration, newstate, (short) 0, (byte) force);
          um.setUnow(nnow);
          res.add(um);
          break;
        }
        case 29:
        case 41:
        {
          final int nnow = rh.readInt();
          final byte newstate = rh.readByte();
          final short duration = rh.readShort();
          final byte force = rh.readByte();
          final UnknownMovement3 um = new UnknownMovement3(command, new Point(0, 0), duration, newstate, (short) 0, (byte) force);
          um.setUnow(nnow);
          res.add(um);
          break;
        }
        case 30:
        case 31:
        case 32:
        case 33:
        case 34:
        case 35:
        case 36:
        case 37:
        case 38:
        case 39:
        case 40:
        case 42:
        case 43:
        case 44:
        case 45:
        case 46:
        case 47:
        case 48:
        case 50:
        case 51:
        case 55:
        case 57:
        case 58:
        case 59:
        case 61:
        case 75:
        case 76:
        case 78:
        case 83:
        case 85:
        case 87:
        case 88:
        case 89:
        case 90:
        case 92:
        case 93:
        case 94:
        case 95:
        case 97:
        case 98:
        case 101:
        case 102:
        case 103:
        case 104:
        {
          final byte newstate = rh.readByte();
          final short duration = rh.readShort();
          final byte unk = rh.readByte();
          final AranMovement am = new AranMovement(command, new Point(0, 0), duration, newstate, unk);
          res.add(am);
          break;
        }
        case 49:
        { // 342
          final short xpos = rh.readShort();
          final short ypos = rh.readShort();
          final short xwobble = rh.readShort();
          final short ywobble = rh.readShort();
          final short xoffset = rh.readShort();
          final byte newstate = rh.readByte();
          final short duration = rh.readShort();
          final byte unk = rh.readByte();
          final UnknownMovement2 um = new UnknownMovement2(command, new Point(xpos, ypos), duration, newstate, unk);
          um.setPixelsPerSecond(new Point(xwobble, ywobble));
          um.setXOffset(xoffset);
          res.add(um);
          break;
        }
        case 56:
        case 68:
        {
          final short xpos = rh.readShort();
          final short ypos = rh.readShort();
          final short xwobble = rh.readShort();
          final short ywobble = rh.readShort();
          final short fh = rh.readShort();
          final byte newstate = rh.readByte();
          final short duration = rh.readShort();
          final byte unk = rh.readByte();
          final UnknownMovement um = new UnknownMovement(command, new Point(xpos, ypos), duration, newstate, fh, unk);
          um.setPixelsPerSecond(new Point(xwobble, ywobble));
          res.add(um);
          break;
        }
        default:
        {
          if (command == 78 || command == 80)
          {
            final short xpos = rh.readShort();
            final short ypos = rh.readShort();
            final short xwobble = rh.readShort();
            final short ywobble = rh.readShort();
            final short fh = rh.readShort();
            final short xoffset = rh.readShort();
            final short yoffset = rh.readShort();
            final UnknownMovement4 alm = new UnknownMovement4(command, new Point(xpos, ypos), 0, 0, fh, (byte) 0);
            alm.setPixelsPerSecond(new Point(xwobble, ywobble));
            alm.setOffset(new Point(xoffset, yoffset));
            res.add(alm);
          }
          else
          {
            final byte newstate = rh.readByte();
            final short duration = rh.readShort();
            final byte unk = rh.readByte();
            final AranMovement um = new AranMovement(command, new Point(0, 0), newstate, duration, unk);
            res.add(um);
          }
          break;
        }
      }
    }

    if (kind != 2)
    {
      rh.skip(10); // 1.2.391 Changed.
    }

    if (numCommands != res.size())
    {
      return null; // Probably hack
    }

    return res;
  }

  public static void updatePosition (final List<LifeMovementFragment> movement, final AnimatedMapleMapObject target, final int yoffset)
  {
    if (movement == null)
    {
      return;
    }
    for (final LifeMovementFragment move : movement)
    {
      if (move instanceof LifeMovement)
      {
        if (move instanceof AbsoluteLifeMovement)
        {
          final Point position2;
          final Point position = position2 = move.getPosition();
          position2.y += yoffset;
          target.setPosition(position);
        }
        target.setStance(((LifeMovement) move).getNewstate());
      }
    }
  }
}
