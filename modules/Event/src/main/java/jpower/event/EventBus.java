package jpower.event;

import jpower.core.Wrapper;

import java.util.List;
import java.util.ArrayList;

/**
 * Implementation of the core EventBus
 */
public class EventBus implements IEventBus
{

    /**
     * Registered handlers
     */
    protected final List<RegisteredHandler> handlers;

    public EventBus()
    {
        handlers = new ArrayList<>();
    }

    @Override
    public void register(final Object object)
    {
        handlers.add(new RegisteredHandler(object).setAnnotationType(EventHandler.class).registerMethods());
    }

    @Override
    public boolean unregister(final Object object)
    {
        for (RegisteredHandler rh : handlers)
        {
            if (rh.getObject() == object)
            {
                handlers.remove(rh);
                return true;
            }
        }
        return false;
    }

    @Override
    public void post(final Object event)
    {
        Wrapper<Boolean> didRun = new Wrapper<>(false);
        handlers.forEach(handler -> {
            if (handler.executeEvent(event))
            {
                didRun.set(true);
            }
        });
        if (!DeadEvent.class.isAssignableFrom(event.getClass()) && !didRun.get())
        {
            post(new DeadEvent(event));
        }
    }

}
