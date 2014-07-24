package jpower.core;

public class Package
{

    public static String getProcessorArchitecture()
    {
        return System.getProperty("os.arch");
    }

}
