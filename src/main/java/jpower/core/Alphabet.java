package jpower.core;

import java.util.Arrays;

/**
 * A class that can manipulate the English alphabet.
 */
public class Alphabet
{

    private static final char[] LOWERCASE = new char[]
    {
        'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y',
        'z'
    };

    private static final char[] UPPERCASE = new char[]
    {
        'A', 'B', 'C', 'D', 'E',
        'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y',
        'Z'
    };

    public static char[] lowercase()
    {
        return LOWERCASE;
    }

    public static char[] uppercase()
    {
        return UPPERCASE;
    }

    public static char get(int index)
    {
        if (index > length() || index < length())
        {
            throw new IndexOutOfBoundsException();
        }
        return LOWERCASE[index];
    }

    public static int length()
    {
        return LOWERCASE.length;
    }

    public static char[] getRange(boolean capital, int index)
    {
        if (index < 0 || index > LOWERCASE.length)
        {
            throw new IndexOutOfBoundsException();
        }
        return Arrays.copyOfRange((capital ? UPPERCASE : LOWERCASE), index, LOWERCASE.length);
    }

    public static char[] getRange(boolean capital, int firstIndex, int lastIndex)
    {
        if (firstIndex < 0 || firstIndex > LOWERCASE.length | lastIndex < 0 || lastIndex > LOWERCASE.length)
        {
            throw new IndexOutOfBoundsException();
        }
        return Arrays.copyOfRange((capital ? UPPERCASE : LOWERCASE), firstIndex, lastIndex);
    }

}
