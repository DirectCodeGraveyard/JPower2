package jpower.core;

import java.util.Arrays;

/**
 * A class that can manipulate the English alphabet.
 */
public class Alphabet
{

    private static char[] ALPHABET = 
    {
        'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y',
        'z'
    };

    private static char[] UPPERCASE;

    static
    {
        for (int i = 0; i < ALPHABET.length; i++)
        {
            UPPERCASE[i] = Character.toUpperCase(ALPHABET[i]);
        }
    }

    public static char[] lowercase()
    {
        return ALPHABET;
    }

    public static char[] uppercase()
    {
        return UPPERCASE;
    }

    public static char get(int index)
    {
        return ALPHABET[index];
    }

    public static int length()
    {
        return ALPHABET.length;
    }

    public static char[] getRange(boolean capital, int index)
    {
        if (index < 0 || index > ALPHABET.length)
        {
            throw new IndexOutOfBoundsException();
        }
        return Arrays.copyOfRange((capital ? UPPERCASE : ALPHABET), index, ALPHABET.length);
    }

    public static char[] getRange(boolean capital, int firstIndex, int lastIndex)
    {
        if (firstIndex < 0 || firstIndex > ALPHABET.length | lastIndex < 0 || lastIndex > ALPHABET.length)
        {
            throw new IndexOutOfBoundsException();
        }
        return Arrays.copyOfRange((capital ? UPPERCASE : ALPHABET), firstIndex, lastIndex);
    }

}
