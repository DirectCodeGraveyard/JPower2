package jpower.test.core;

import jpower.core.Alphabet;
import org.junit.*;
import static org.junit.Assert.*;

public class AlphabetTest
{

    @Test
    public void lowercaseTest()
    {
        for (char c : Alphabet.lowercase())
        {
            assertTrue(Character.isLowerCase(c));
        }
    }

    @Test
    public void uppercaseTest()
    {
        for (char c : Alphabet.uppercase())
        {
            assertTrue(Character.isUpperCase(c));
        }
    }

}
