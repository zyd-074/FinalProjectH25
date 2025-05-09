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
        manager.removeTask(task);
    }

    /**
     * Adds the task to the TaskManager.
     */
    @Override
    public void redo() {
        manager.addTask(task);
    }
}
