package client;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class LoginCryptoLegacy
{
  private static final Random rand = new Random();
  
  private static final char[] iota64 = new char[64];
  
  static
  {
    int i = 0;
    iota64[i++] = '.';
    iota64[i++] = '/';
    char c;
    for (c = 'A'; c <= 'Z'; c = (char) (c + 1))
    {
      iota64[i++] = c;
    }
    for (c = 'a'; c <= 'z'; c = (char) (c + 1))
    {
      iota64[i++] = c;
    }
    for (c = '0'; c <= '9'; c = (char) (c + 1))
    {
      iota64[i++] = c;
    }
  }
  
  public static final String hashPassword(String password)
  {
    byte[] randomBytes = new byte[6];
    rand.setSeed(System.currentTimeMillis());
    rand.nextBytes(randomBytes);
    return myCrypt(password, genSalt(randomBytes));
  }
  
  public static final boolean checkPassword(String password, String hash)
  {
    return myCrypt(password, hash).equals(hash);
  }
  
  public static final boolean isLegacyPassword(String hash)
  {
    return hash.startsWith("$H$");
  }
  
  private static final String myCrypt(String password, String seed) throws RuntimeException
  {
    String out = null;
    int count = 8;
    if (!seed.startsWith("$H$"))
    {
      byte[] randomBytes = new byte[6];
      rand.nextBytes(randomBytes);
      seed = genSalt(randomBytes);
    }
    String salt = seed.substring(4, 12);
    if (salt.length() != 8)
    {
      throw new RuntimeException("Error hashing password - Invalid seed.");
    }
    try
    {
      MessageDigest digester = MessageDigest.getInstance("SHA-1");
      digester.update((salt + password).getBytes(StandardCharsets.ISO_8859_1), 0, (salt + password).length());
      byte[] sha1Hash = digester.digest();
      while (true)
      {
        byte[] CombinedBytes = new byte[sha1Hash.length + password.length()];
        System.arraycopy(sha1Hash, 0, CombinedBytes, 0, sha1Hash.length);
        System.arraycopy(password.getBytes(StandardCharsets.ISO_8859_1), 0, CombinedBytes, sha1Hash.length, (password.getBytes(StandardCharsets.ISO_8859_1)).length);
        digester.update(CombinedBytes, 0, CombinedBytes.length);
        sha1Hash = digester.digest();
        if (--count <= 0)
        {
          out = seed.substring(0, 12);
          out = out + encode64(sha1Hash);
        }
        else
        {
          continue;
        }
        if (out == null)
        {
          throw new RuntimeException("Error hashing password - out = null");
        }
        return out;
      }
    }
    catch (NoSuchAlgorithmException Ex)
    {
      System.err.println("Error hashing password." + Ex);
    }
    if (out == null)
    {
      throw new RuntimeException("Error hashing password - out = null");
    }
    return out;
  }
  
  private static final String genSalt(byte[] arrayOfByte)
  {
    String Salt = "$H$" + iota64[30] +
        encode64(arrayOfByte);
    return Salt;
  }
  
  private static final String convertToHex(byte[] data)
  {
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < data.length; )
    {
      int halfbyte = data[i] >>> 4 & 0xF;
      int two_halfs = 0;
      while (true)
      {
        if (0 <= halfbyte && halfbyte <= 9)
        {
          buf.append((char) (48 + halfbyte));
        }
        else
        {
          buf.append((char) (97 + halfbyte - 10));
        }
        halfbyte = data[i] & 0xF;
        if (two_halfs++ >= 1)
        {
          i++;
        }
      }
    }
    return buf.toString();
  }
  
  public static final String encodeSHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    MessageDigest md = MessageDigest.getInstance("SHA-1");
    md.update(text.getBytes(StandardCharsets.ISO_8859_1), 0, text.length());
    return convertToHex(md.digest());
  }
  
  private static final String encode64(byte[] Input)
  {
    int iLen = Input.length;
    int oDataLen = (iLen * 4 + 2) / 3;
    int oLen = (iLen + 2) / 3 * 4;
    char[] out = new char[oLen];
    int ip = 0;
    int op = 0;
    while (ip < iLen)
    {
      int i0 = Input[ip++] & 0xFF;
      int i1 = (ip < iLen) ? (Input[ip++] & 0xFF) : 0;
      int i2 = (ip < iLen) ? (Input[ip++] & 0xFF) : 0;
      int o0 = i0 >>> 2;
      int o1 = (i0 & 0x3) << 4 | i1 >>> 4;
      int o2 = (i1 & 0xF) << 2 | i2 >>> 6;
      int o3 = i2 & 0x3F;
      out[op++] = iota64[o0];
      out[op++] = iota64[o1];
      out[op] = (op < oDataLen) ? iota64[o2] : '=';
      op++;
      out[op] = (op < oDataLen) ? iota64[o3] : '=';
      op++;
    }
    return new String(out);
  }
}
