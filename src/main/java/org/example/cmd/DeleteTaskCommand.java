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

    @Override
    public void undo() {
        TaskManager.addTask(task);
    }

    @Override
    public void redo() {
        TaskManager.removeTask(task);
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
