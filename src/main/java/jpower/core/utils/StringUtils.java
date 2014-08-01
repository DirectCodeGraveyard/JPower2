package jpower.core.utils;

public class StringUtils
{

    public static boolean isNullOrEmpty(String target)
    {
        return (target == null || target.equals(""));
    }
    
    public static boolean isEmpty(String target)
    {
        return (target.equals(""));
    }

}
