package org.example.cmd;

import org.example.task.Task;

public class MarkCompleteCommand implements Command {
    private Task task;

    public MarkCompleteCommand(Task task) {
        this.task = task;
        task.markComplete();

    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
