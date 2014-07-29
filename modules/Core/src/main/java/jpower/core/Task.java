package jpower.core;

import jpower.core.internal.CancelStateTracker;

public interface Task extends Runnable
{

    public default void run()
    {
        execute();
    }

    public void execute();
    
    public default boolean isCancelled()
    {
        return CancelStateTracker.isCancelled(this);
    }

    public default void cancel()
    {
        CancelStateTracker.setCancelled(this, true);
    }

    public default void activate()
    {
        CancelStateTracker.setCancelled(this, false);
    }

}
