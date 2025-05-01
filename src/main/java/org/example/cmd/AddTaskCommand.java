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

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
