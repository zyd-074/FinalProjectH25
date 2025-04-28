package org.example.task;

import org.example.cmd.Command;
import org.example.cmd.MarkCompleteCommand;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {
    protected String title;
    protected LocalDate createdDate;
    protected boolean isCompleted;

    public Task(String title) {
        this.title = title;
        this.createdDate = LocalDate.now();
        this.isCompleted = false;
    }

    public void markComplete() {
        this.isCompleted = true;
        //Todo: add command to undo Stack
    }
}
