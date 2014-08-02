package jpower.core.utils;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Common List utilities
 */
public class ListUtils
{

    /**
     * Create a list that has T type
     * @param single List type
     * @return list
     */
    public static <T> List<T> singleton(T single)
    {
        return Collections.singletonList(single);
    }

    /**
     * Join a List into a String by the line separator
     * @param lines List of strings
     * @return joined string
     */
    public static String toString(List<String> lines)
    {
        return join(lines, System.lineSeparator());
    }

    /**
     * Join a List into a String by specified separator
     * @param inputs List of strings
     * @param joinBy Separator
     * @return joined string
     */
    public static String join(List<String> inputs, String joinBy)
    {
        StringBuilder builder = new StringBuilder();
        forEach(inputs, (input, i) -> {
            if (i != 0)
            {
                builder.append(input);
            }
            builder.append(input);
        });
        return builder.toString();
    }

    /**
     * Check if an Array's contents are equal to a List's contents
     * @param array Array specified
     * @param list List specified
     * @return true if items in array and list are equal
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean equals(@NotNull T[] array, @NotNull List<T> list)
    {
        T[] listArray = (T[]) list.toArray();
        return Arrays.equals(array, listArray);
    }

    /**
     * TODO: Document this
     */
    public static <T> void forEach(List<T> that, BiConsumer<T, Integer> consumer)
    {
        for (int i = 0; i < that.size(); i++)
        {
            consumer.accept(that.get(i), i);
        }
    }

    /**
     * Convert List to Set
     * @param list List to convert
     * @return converted Set
     */
    public static <T> Set<T> toSet(List<T> list)
    {
        return Collections.unmodifiableSet(new HashSet<>(list));
    }

    /**
     * TODO: Document this
     */
    public static <T, R> List<R> collect(List<T> input, Function<T, R> function)
    {
        List<R> newStuff = new ArrayList<>();
        input.forEach(entry -> newStuff.add(function.apply(entry)));
        return newStuff;
    }

}
