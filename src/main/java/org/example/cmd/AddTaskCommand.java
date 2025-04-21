package org.example.cmd;

import org.example.TaskManager;
import org.example.task.Task;

public class AddTaskCommand implements Command {
    private Task task;
    private TaskManager manager;

    @Override
    public void undo() {
        //Todo
    }

    @Override
    public void redo() {
        //Todo
    }
}
