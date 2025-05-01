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
        task.setCompleted(false);
    }

    @Override
    public void redo() {
        task.markComplete();
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
