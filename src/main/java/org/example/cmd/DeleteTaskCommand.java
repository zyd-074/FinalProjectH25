package org.example.cmd;

import org.example.TaskManager;
import org.example.task.Task;

public class DeleteTaskCommand implements Command {
    private Task task;
    private TaskManager manager;

    public DeleteTaskCommand(Task task, TaskManager manager) {
        this.task = task;
        this.manager = manager;
    }

    /**
     * Adds the task to the TaskManager.
     */
    @Override
    public void undo() {
        //todo
    }

    /**
     * Removes the task to the TaskManager.
     */
    @Override
    public void redo() {
        //todo
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskManager getManager() {
        return manager;
    }

    public void setManager(TaskManager manager) {
        this.manager = manager;
    }
}
