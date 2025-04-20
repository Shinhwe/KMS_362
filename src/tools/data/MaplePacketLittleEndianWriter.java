package tools.data;

import tools.HexTool;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MaplePacketLittleEndianWriter
{
  private static final Charset ASCII = StandardCharsets.UTF_8;
  private final ByteArrayOutputStream baos;
  private final byte[] bytes = new byte[8];
  private int byteCount = 0;

  public MaplePacketLittleEndianWriter ()
  {
    this(32);
  }

  public MaplePacketLittleEndianWriter (int size)
  {
    this.baos = new ByteArrayOutputStream(size);
  }

  public final byte[] getPacket ()
  {
    return this.baos.toByteArray();
  }

  public final String toString ()
  {
    return HexTool.toString(this.baos.toByteArray());
  }

  public final void writeZeroBytes (int i)
  {
    for (int x = 0; x < i; x++)
    {
      this.baos.write(0);
    }
  }

  public final void writeBit (int b, int bit)
  {
    for (int i = 0; i < bit; i++)
    {
      this.bytes[this.byteCount] = (byte) (b >>> i & 0xFF & 0x1);
      this.byteCount++;
      if (this.byteCount == 8)
      {
        byte data = 0;
        for (int a = 0; a < 8; a++)
        {
          data = (byte) (data + (this.bytes[a] << a));
        }
        this.baos.write(data);
        this.byteCount = 0;
      }
    }
  }

  public final void write (byte[] b)
  {
    try
    {
      this.baos.write(b);
    }
    catch (IOException e)
    {
      System.out.println("Error writing int: " + e.getMessage());
    }
  }

  public final void write (boolean b)
  {
    this.baos.write(b ? 1 : 0);
  }

  public void write (byte b)
  {
    this.baos.write(b);
  }

  public void write (int i)
  {
    final byte[] bytes = ByteBuffer.allocate(Byte.BYTES).order(ByteOrder.LITTLE_ENDIAN).put((byte) i).array();
    try
    {
      this.baos.write(bytes);
    }
    catch (IOException e)
    {
      System.out.println("Error writing int: " + e.getMessage());
    }
  }

  public final void writeShort (int i)
  {
    final byte[] bytes = ByteBuffer.allocate(Short.BYTES).order(ByteOrder.LITTLE_ENDIAN).putShort((short) i).array();
    try
    {
      this.baos.write(bytes);
    }
    catch (IOException e)
    {
      System.out.println("Error writing int: " + e.getMessage());
    }
  }

  public final void writeInt (int i)
  {
    final byte[] bytes = ByteBuffer.allocate(Integer.BYTES).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array();
    try
    {
      this.baos.write(bytes);
    }
    catch (IOException e)
    {
      System.out.println("Error writing int: " + e.getMessage());
    }
  }

  public void writeInt (long i)
  {
    final byte[] bytes = ByteBuffer.allocate(Integer.BYTES).order(ByteOrder.LITTLE_ENDIAN).putInt((int) i).array();
    try
    {
      this.baos.write(bytes);
    }
    catch (IOException e)
    {
      System.out.println("Error writing int: " + e.getMessage());
    }
  }

  public final void writeAsciiString (String s)
  {
    write(s.getBytes(ASCII));
  }

  public final void writeAsciiString (String s, int max)
  {
    // if (s.length() > 3)
    // {
    //   s = s.substring(0, 3);
    // }
    // write(s.getBytes(ASCII));
    // for (int i = (s.getBytes(ASCII)).length; i < 13; i++)
    // {
    //   write(0);
    // }

    while ((s.getBytes(ASCII)).length > max)
    {
      s = s.substring(0, s.length() - 1);
    }
    write(s.getBytes(ASCII));
    for (int i = (s.getBytes(ASCII)).length; i < max; i++)
    {
      write(0);
    }
  }

  public final void writeMapleAsciiString (String s)
  {
    writeShort((short) (s.getBytes(ASCII)).length);
    writeAsciiString(s);
  }

  public final void writePos (Point s)
  {
    writeShort(s.x);
    writeShort(s.y);
  }

  public void writePosInt (Point s)
  {
    writeInt(s.x);
    writeInt(s.y);
  }

  public final void writeNRect (Rectangle s)
  {
    writeInt(s.x);
    writeInt(s.y);
    writeInt(s.width);
    writeInt(s.height);
  }

  public final void writeRect (Rectangle s)
  {
    writeInt(s.x);
    writeInt(s.y);
    writeInt(s.x + s.width);
    writeInt(s.y + s.height);
  }

  public final void writeMapleAsciiString2 (String s)
  {
    writeShort((short) (s.getBytes(StandardCharsets.UTF_8)).length);
    write(s.getBytes(StandardCharsets.UTF_8));
  }

  public final void writeLong (long l)
  {
    final byte[] bytes = ByteBuffer.allocate(Long.BYTES).order(ByteOrder.LITTLE_ENDIAN).putLong(l).array();
    try
    {
      this.baos.write(bytes);
    }
    catch (IOException e)
    {
      System.out.println("Error writing int: " + e.getMessage());
    }
  }

  public final void writeReversedLong (long l)
  {
    this.baos.write((byte) (int) (l >>> 32L & 0xFFL));
    this.baos.write((byte) (int) (l >>> 40L & 0xFFL));
    this.baos.write((byte) (int) (l >>> 48L & 0xFFL));
    this.baos.write((byte) (int) (l >>> 56L & 0xFFL));
    this.baos.write((byte) (int) (l & 0xFFL));
    this.baos.write((byte) (int) (l >>> 8L & 0xFFL));
    this.baos.write((byte) (int) (l >>> 16L & 0xFFL));
    this.baos.write((byte) (int) (l >>> 24L & 0xFFL));
  }

  public final void writeDouble (double d)
  {
    writeLong(Double.doubleToLongBits(d));
  }
}
