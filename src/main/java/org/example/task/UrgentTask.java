package org.example.task;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

public class UrgentTask extends Task {
    private Priority priority;
    private LocalDate dueDate;

    public UrgentTask(String title, LocalDate dueDate) {
        super(title);
        this.dueDate = dueDate;
        this.priority = determinePriority(dueDate);
    }

    /**
     * Determines the priority of the task based on its due date.
     * @param dueDate the due date of the task
     * @return the priority of the task
     */
    private Priority determinePriority(LocalDate dueDate) {
        LocalDate now = LocalDate.now();
        if (dueDate.isBefore(now.plusDays(1))) {
            return Priority.UNDER24H;
        } else if (dueDate.isBefore(now.plusDays(7))) {
            return Priority.UNDER7DAYS;
        } else if (dueDate.isBefore(now.plusMonths(1))) {
            return Priority.UNDER1MONTH;
        } else {
            return Priority.OVER1MONTH;
        }
    }

    public static enum Priority {
        UNDER24H, UNDER7DAYS, UNDER1MONTH, OVER1MONTH
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
        return super.toString() + ", " +
                "priority=" + priority +
                ", dueDate=" + dueDate;
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
        return determinePriority(this.dueDate);
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
