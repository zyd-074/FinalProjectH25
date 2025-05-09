package org.example.cmd;

import org.example.task.Task;

public class MarkIncompleteCommand implements Command {
    private Task task;

    public MarkIncompleteCommand(Task task) {
        this.task = task;
        task.markIncomplete();
    }

    /**
     * Marks the task as completed.
     */
    @Override
    public void undo() {
        task.markComplete();
    }

    /**
     * Marks the task as not completed.
     */
    @Override
    public void redo() {
        task.markIncomplete();
    }
}
