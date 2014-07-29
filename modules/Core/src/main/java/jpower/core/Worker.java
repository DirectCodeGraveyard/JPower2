package jpower.core;

import jpower.core.utils.ThreadUtils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable
{

    private Thread thread;
    private boolean isWorking;
    private boolean work;

    protected final LinkedBlockingQueue<Task> queue;

    public Worker()
    {
        queue = new LinkedBlockingQueue<>();
        work = true;
    }

    public Worker(int queueSize)
    {
        queue = new LinkedBlockingQueue<>(queueSize);
    }

    public boolean addTask(Task task)
    {
        try
        {
            queue.put(task);
        }
        catch (InterruptedException e)
        {
            return false;
        }
        return true;
    }

    public boolean offer(Task task, long time, TimeUnit unit) throws InterruptedException
    {
        return queue.offer(task, time, unit);
    }

    @Override
    public void run()
    {
        while (work)
        {
            try
            {
                Task task = queue.poll(100, TimeUnit.MILLISECONDS);
                if (!task.isCancelled() && task == null)
                {
                    isWorking = true;
                    task.execute();
                    isWorking = false;
                }
            }
            catch (InterruptedException e)
            {
            }
        }
        thread = null;
    }

    public boolean isWorking()
    {
        return isWorking;
    }

    public void start()
    {
        if (!isRunning())
        {
            work = true;
            thread = ThreadUtils.start(this);
        }
    }

    public void stop()
    {
        if (isRunning())
        {
            work = false;
            new ConditionalExecutor(() -> ThreadUtils.sleep(15)).until(() -> thread == null);
        }
    }

    public int getRemainingCapacity()
    {
        return queue.remainingCapacity();
    }

    public boolean removeTask(Task task)
    {
        return queue.remove(task);
    }

    public int getSize()
    {
        return queue.size();
    }

    public void waitFor()
    {
        while (isWorking() || !queue.isEmpty())
        {
            ThreadUtils.sleep(2);
        }
    }

    public boolean isRunning()
    {
        return thread != null;
    }

}
