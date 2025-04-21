package org.example.task;

import java.time.LocalDate;

public abstract class Task implements Comparable<Task> {
    protected String title;
    protected LocalDate createdDate;
    protected boolean isCompleted;

    public Task(String title, LocalDate createdDate, boolean isCompleted) {
        this.title = title;
        this.createdDate = createdDate;
        this.isCompleted = isCompleted;
    }

    public void markComplete() {
        //Todo
    }

    public int compareTo(Task task) {
        //Todo
    }
}
