package jpower.core;

import jpower.core.utils.ThreadUtils;

import java.util.ArrayList;
import java.util.List;

public class WorkerPool
{

    private final List<Worker> workers = new ArrayList<>();
    private final int size;

    public WorkerPool()
    {
        this(50);
    }

    public WorkerPool(int size)
    {
        this.size = size;
    }

    public boolean submit(Task task)
    {
        Worker worker = pullWorker();
        if (worker != null)
        {
            worker.addTask(task);
            return true;
        }
        return false;
    }

    private Worker pullWorker()
    {
        if (workers.isEmpty())
        {
            Worker worker = new Worker();
            workers.add(worker);
            return worker;
        }
        for (Worker w : workers)
        {
            if (!w.isWorking())
            {
                return w;
            }
        }
        return newWorker();
    }

    private Worker newWorker()
    {
        if (workers.size() == size)
        {
            return null;
        }
        Worker worker = new Worker();
        worker.start();
        workers.add(worker);
        return worker;
    }

    public List<Worker> getWorkers()
    {
        return workers;
    }

    public void stopWorkers()
    {
        Iterable<Worker> temp = new ArrayList<>(workers);
        temp.forEach(worker -> {
            worker.stop();
            new ConditionalExecutor(() -> ThreadUtils.sleep(1)).until(worker::isWorking);
            workers.remove(worker);
        });
    }

    public int getWorkerCount()
    {
        return workers.size();
    }

    public void waitForAll()
    {
        workers.forEach(Worker::waitFor);
    }

}
