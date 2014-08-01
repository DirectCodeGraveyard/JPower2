package jpower.test.core.utils;

import jpower.core.utils.StringUtils;

import org.junit.*;
import static org.junit.Assert.*;

public class StringUtilsTest
{

    @Test
    public void testIsNullOrEmpty()
    {
        assertTrue(StringUtils.isNullOrEmpty(""));
        assertTrue(StringUtils.isNullOrEmpty(null));
        assertFalse(StringUtils.isNullOrEmpty("Test"));
    }

}
