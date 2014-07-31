package jpower.event;

/**
 * Interface for representing an Event Bus
 */
public interface IEventBus
{

    /**
     * Register an Event handler
     * @param handler handler to register
     */
    public void register(final Object handler);

    /**
     * Unregister an Event handler
     * @param handler handler to unregister
     * @return true if the handler was unregistered
     */
    public boolean unregister(final Object handler);

    /**
     * Post an Event
     * @param event event to post
     */
    public void post(final Object event);

}
