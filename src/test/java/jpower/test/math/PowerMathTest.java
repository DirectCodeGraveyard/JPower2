package jpower.test.math;

import jpower.math.PowerMath;
import org.junit.*;
import static org.junit.Assert.*;

public class PowerMathTest
{

   @Test
   public void minTest()
   {
      int min = PowerMath.min(5, 6, 7, 8, 9);
      assertTrue(min == 5);
   }

   @Test
   public void maxTest()
   {
      int max = PowerMath.max(5, 6, 7, 8, 9);
      assertTrue(max == 9);
   }

   @Test
   public void meanTest()
   {
      int mean = PowerMath.mean(1, 2, 3, 4, 5);
      assertTrue(mean == 3);
   }

}
