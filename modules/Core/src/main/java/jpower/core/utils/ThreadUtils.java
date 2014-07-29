package jpower.core.utils;

public class ThreadUtils
{

    public static void sleep(long time)
    {
        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {
        }
    }

    public static Thread start(Runnable action)
    {
        Thread thread = new Thread(action);
        thread.start();
        return thread;
    }

    public static Thread startDaemon(Runnable action)
    {
        Thread thread = new Thread(action);
        thread.setDaemon(true);
        thread.start();
        return thread;
    }

}
