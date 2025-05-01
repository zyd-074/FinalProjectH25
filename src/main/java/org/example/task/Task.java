package org.example.task;

import java.time.LocalDate;

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

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", createdDate=" + createdDate +
                ", isCompleted=" + isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
