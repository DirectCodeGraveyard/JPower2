package jpower.core.math;

import java.math.BigInteger;

/**
 * A collection of math utilities, could be separated into
 * multiple different classes for math subjects.
 */
public class PowerMath
{

    /**
     * Calculate a fibonacci sequence to the nth number
     * @param amount amount of digits to calculate
     * @return array of BigIntegers
     */
    public static BigInteger[] fibonacci(int amount)
    {
        BigInteger[] digits = new BigInteger[amount];
        BigInteger last = new BigInteger("0");
        BigInteger current = new BigInteger("1");
        for (int i = 0; i < amount; i++)
        {
            digits[i] = last;
            current = last.add(current);
            last = current.subtract(last);
        }
        return digits;
    }

    /**
     * Calculate the factorial of a number
     * Example: 5! = 5 * 4 * 3 * 2 * 1
     * @param number factorial index
     * @return factorial
     */
    public static int factorial(int number)
    {
        return number == 1 ? 1 : number + factorial(number - 1);
    }

    /**
     * Retrieve the smallest number from an array
     * @param numbers input numbers
     * @return smallest number
     */
    public static int getSmallest(int... numbers)
    {
        int smallest = numbers[0];
        for (int i : numbers)
        {
            if (i < smallest)
            {
                smallest = i;
            }
        }
        return smallest;
    }

    /**
     * Retrieve the largest number from an array
     * @param numbers input numbers
     * @return largest numbers
     */
    public static int getLargest(int... numbers)
    {
        int largest = numbers[0];
        for (int i : numbers)
        {
            if (i > largest)
            {
                largest = i;
            }
        }
        return largest;
    }

}
