package jpower.core;

public class Platform
{

    public static String getProcessorArchitecture()
    {
        return System.getProperty("os.arch");
    }

}
