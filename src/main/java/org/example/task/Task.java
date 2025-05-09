package org.example.task;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Task {
    protected String title;
    protected LocalDate createdDate;
    protected boolean isCompleted;

    public Task(String title) {
        this.title = title;
        this.createdDate = LocalDate.now();
        this.isCompleted = false;
    }

    /**
     * Marks the task as completed.
     */
    public void markComplete() {
        this.isCompleted = true;
    }

    public void markIncomplete() {
        this.isCompleted = false;
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isCompleted == task.isCompleted && Objects.equals(title, task.title) && Objects.equals(createdDate, task.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, createdDate, isCompleted);
    }
}
