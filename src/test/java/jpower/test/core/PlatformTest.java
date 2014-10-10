package jpower.test.core;

import jpower.core.Platform;
import org.junit.*;
import static org.junit.Assert.*;

public class PlatformTest
{

   @Test
   public void operatingSystemTest()
   {
      assertFalse(Platform.getCurrent().isUnknown());
   }

   @Test
   public void operatingSystemTest2()
   {
      int i = 0;
      if (Platform.getCurrent().isUnix()) i++;
      if (Platform.getCurrent().isWindows()) i++;
      if (Platform.getCurrent().isSolaris()) i++;
      if (Platform.getCurrent().isMacintosh()) i++;
      assertTrue(i == 1);
   }

   @Test
   public void architectureTest()
   {
      assertFalse(Platform.getProcessorArchitecture().equals(""));
   }

}
