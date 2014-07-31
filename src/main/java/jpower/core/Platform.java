package jpower.core;

/**
 * Provides information about the Platform
 * that the JVM is running on.
 */
public class Platform
{

    /**
     * Holds the current Operating System for the current system.
     */
    private static final Platform current = new Platform(System.getProperty("os.name"));

    private final String name;

    private Platform(String name)
    {
        this.name = name.toLowerCase();
    }

    /**
     * Get the current Operating System
     */
    public static Platform getCurrent()
    {
        return current;
    }

    /**
     * Get the processor architecture of the CPU
     * @return processor architecture
     */
    public static String getProcessorArchitecture()
    {
        return System.getProperty("os.arch");
    }

    /**
     * Determines if the OS is Windows
     * @return true on Windows
     */
    public boolean isWindows()
    {
        return name.contains("win");
    }

    /**
     * Determines if the OS is Macintosh
     * @return true on Macintosh
     */
    public boolean isMacintosh()
    {
        return name.contains("mac");
    }

    /**
     * Determines if the OS is Unix-based
     * @return true on Unix
     */
    public boolean isUnix()
    {
        return name.contains("nix") || name.contains("nux") || name.contains("aix");
    }

    /**
     * Determines if the OS is Solaris-based
     * @return true on Solaris
     */
    public boolean isSolaris()
    {
        return name.contains("sunos");
    }

    /**
     * Determines if the OS is unknown
     * @return unknown OperatingSystem
     */
    public boolean isUnknown()
    {
        return !(isWindows() || isMacintosh() || isUnix() || isSolaris());
    }

}
