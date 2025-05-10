package org.example.task;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class UrgentTask extends Task {
    private Priority priority;
    private LocalDate dueDate;

    public UrgentTask(String title, LocalDate dueDate, Priority priority) {
        super(title);
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public enum Priority {
        HIGH, MEDIUM, LOW
    }

    /**
     * Compares two tasks based on their priority.
     */
    public static class TaskPriorityComparator implements Comparator<Task> {
        @Override
        public int compare(Task o1, Task o2) {
            if (o1 instanceof UrgentTask && o2 instanceof UrgentTask) {
                return ((UrgentTask) o1).priority.compareTo(((UrgentTask) o2).priority);
            } else if (o1 instanceof UrgentTask) {
                return -1;
            } else if (o2 instanceof UrgentTask) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Compares two tasks based on their due date.
     */
    public static class TaskDueDateComparator implements Comparator<Task> {
        @Override
        public int compare(Task o1, Task o2) {
            if (o1 instanceof UrgentTask && o2 instanceof UrgentTask) {
                return ((UrgentTask) o1).dueDate.compareTo(((UrgentTask) o2).dueDate);
            } else if (o1 instanceof UrgentTask) {
                return -1;
            } else if (o2 instanceof UrgentTask) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Priority: " + priority +
                " | Due Date: " + dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrgentTask that = (UrgentTask) o;
        return priority == that.priority && Objects.equals(dueDate, that.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority, dueDate, title);
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
