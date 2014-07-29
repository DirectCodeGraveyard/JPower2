package jpower.core;

/**
 * Utility class that allows you to allow users to
 * easily build an instance of the specified object.
 * @param <T> object type
 */
public interface Factory<T>
{

    /**
     * Build an instance of our object.
     */
    T create();

}
