package tools;

public class FlameTester
{
  public class Main
  {
    public static void main (String[] args)
    {
      long flame = 10241201051L;

      int flameOption1 = (int) (flame % 1000L / 10L);

      int flameValue1 = (int) (flame % 10L / 1L);

      int flameOption2 = (int) (flame % 1000000L / 10000L);

      int flameValue2 = (int) (flame % 10000L / 1000L);

      int flameOption3 = (int) (flame % 1000000000L / 10000000L);

      int flameValue3 = (int) (int) (flame % 10000000L / 1000000L);

      int flameOption4 = (int) (flame % 1000000000000L / 10000000000L);

      int flameValue4 = (int) (int) (flame % 10000000000L / 1000000000L);

      int[] flameOptionList = new int[] { flameOption1, flameOption2, flameOption3, flameOption4 };

      int[] flameValueList = new int[] { flameValue1, flameValue2, flameValue3, flameValue4 };

      System.out.println(flameOption1);

      System.out.println(flameOption2);

      System.out.println(flameOption3);

      System.out.println(flameOption4);

      System.out.println(flameValue1);

      System.out.println(flameValue2);

      System.out.println(flameValue3);

      System.out.println(flameValue4);
    }
  }

}
