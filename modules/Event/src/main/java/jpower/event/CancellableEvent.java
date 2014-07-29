package jpower.event;

/**
 * A class for events that are cancellable
 */
public abstract class CancellableEvent implements Cancellable
{

    private boolean cancelled;

    @Override
    public void setCancelled(boolean cancel)
    {
        cancelled = cancel;
    }

    @Override
    public boolean isCancelled()
    {
        return cancelled;
    }

}
