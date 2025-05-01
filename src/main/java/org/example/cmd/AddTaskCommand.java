package org.example.cmd;

import org.example.TaskManager;
import org.example.task.Task;

public class AddTaskCommand implements Command {
    private Task task;
    private TaskManager manager;

    public AddTaskCommand(Task task, TaskManager manager) {
        this.task = task;
        this.manager = manager;
    }

    /**
     * Removes the task to the TaskManager.
     */
    @Override
    public void undo() {
        TaskManager.removeTask(task);
    }

    /**
     * Adds the task to the TaskManager.
     */
    @Override
    public void redo() {
        TaskManager.addTask(task);
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
