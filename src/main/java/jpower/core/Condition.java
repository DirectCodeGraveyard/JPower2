package jpower.core;

/**
 * Represents any true/false statement
 */
public interface Condition
{

    public boolean check();

    public default boolean inverted()
    {
        return !check();
    }

}
