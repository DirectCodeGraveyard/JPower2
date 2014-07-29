package jpower.core;

public interface Service
{

    public boolean start();

    public boolean stop();

    default boolean restart()
    {
        return stop() && start();
    }

}
