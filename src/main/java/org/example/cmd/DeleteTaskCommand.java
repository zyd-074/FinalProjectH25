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
        manager.addTask(task);
    }

    /**
     * Removes the task to the TaskManager.
     */
    @Override
    public void redo() {
        manager.removeTask(task);
    }
}
