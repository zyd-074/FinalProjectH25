package org.example;

import java.time.LocalDate;

public abstract class Task implements Comparable<Task>, Displayable {
    protected String description;
    protected LocalDate dueDate;
    protected boolean isCompleted;
    protected String category;

    public void markComplete() {
        //Todo
    }

    public int compareTo(Task task) {
        //Todo
    }

    public String displayInfo() {
        //Todo
    }
}
