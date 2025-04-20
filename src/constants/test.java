package constants;

import java.nio.charset.StandardCharsets;

public class test
{
  public static void main(String[] args)
  {
    // String str = "나무의 정령";
    // System.out.println(str.getBytes(StandardCharsets.UTF_8).length);
    //
    // int i = 12345;
    //
    // // int byte1 = i % 256; // 提取低8位
    // // int byte2 = (i / 256) % 256; // 提取次低8位
    // // int byte3 = (i / (256 * 256)) % 256; // 提取再次低8位
    // // int byte4 = (i / (256 * 256 * 256)) % 256; // 提取最高8位
    //
    // int byte1 = i & 0xFF; // 提取低8位
    // int byte2 = i >>> 8 & 0xFF; // 提取次低8位
    // int byte3 = i >>> 16 & 0xFF; // 提取再次低8位
    // int byte4 = i >>> 24 & 0xFF; // 提取最高8位
    //
    // System.out.println((byte) byte1);
    // System.out.println((byte) byte2);
    // System.out.println((byte) byte3);
    // System.out.println((byte) byte4);
    
    for(double i = 10.0D; i < 600.0D; i+= 10.0D)
    {
      System.out.print("i = " + i +" p =");
      System.out.println(Math.min(500000 + 500000  * (i / 500), 1000000));
    }
  }
}
