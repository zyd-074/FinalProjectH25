package org.example.task;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class UrgentTask extends Task {
    private final Priority priority;
    private LocalDate dueDate;

    public UrgentTask(String title, LocalDate dueDate) {
        super(title);
        this.priority = determinePriority(dueDate);
        this.dueDate = dueDate;
    }

    private Priority determinePriority(LocalDate dueDate) {
        LocalDate now = LocalDate.now();
        if (dueDate.isBefore(now.plusDays(1))) {
            return Priority.UNDER24H;
        } else if (dueDate.isBefore(now.plusDays(7))) {
            return Priority.UNDER7DAYS;
        } else if (dueDate.isBefore(now.plusMonths(1))) {
            return Priority.UNDER1MONTH;
        } else {
            return null; // No priority
        }
    }

    public static enum Priority {
        UNDER24H, UNDER7DAYS, UNDER1MONTH
    }



    public static class TaskPriorityComparator implements Comparator<Task> {
        @Override
        public int compare(Task o1, Task o2) {
            try {
                if (o1 instanceof UrgentTask && o2 instanceof UrgentTask) {
                    return ((UrgentTask) o1).priority.compareTo(((UrgentTask) o2).priority);
                } else {
                    throw new ClassCastException();
                }
            } catch (ClassCastException e) {
                System.out.println("Cannot compare tasks of different types.");
                return 0;
            }
        }
    }

    public static class TaskDueDateComparator implements Comparator<Task> {
        @Override
        public int compare(Task o1, Task o2) {
            try {
                if (o1 instanceof UrgentTask && o2 instanceof UrgentTask) {
                    return ((UrgentTask) o1).dueDate.compareTo(((UrgentTask) o2).dueDate);
                } else {
                    throw new ClassCastException();
                }
            } catch (ClassCastException e) {
                System.out.println("Cannot compare tasks of different types.");
                return 0;
            }
        }
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
        return Objects.hash(priority, dueDate);
    }

    @Override
    public String toString() {
        return "UrgentTask{" +
                "priority=" + priority +
                ", dueDate=" + dueDate +
                "} " + super.toString();
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
}
