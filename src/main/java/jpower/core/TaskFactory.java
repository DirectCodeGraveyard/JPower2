package jpower.core;

public class TaskFactory implements Factory<Task>
{

    private final Task original;

    public TaskFactory(Task original)
    {
        this.original = original;
    }

    @Override
    public Task create()
    {
        return original::execute;
    }

}
