package org.example.user;

import org.example.task.UrgentTask;

import java.util.Objects;

public class GuestUser extends User {
    private final long guestId;
    private static long nextID = 10001;
    public GuestUser(String username) {
        super(username);
        this.guestId = nextID++;
    }

    /**
     * Sorts the tasks by their deadline.
     */
    public void sortByDeadline() {
        this.taskManager.getTasks().sort(new UrgentTask.TaskDueDateComparator());
    }

    /**
     * Sorts the tasks by their priority.
     */
    public void sortByPriority() {
        this.taskManager.getTasks().sort(new UrgentTask.TaskPriorityComparator());
    }

    /**
     * Loads tasks to a file.
     * @param filePath the path to the file from which tasks will be loaded
     */
    public void loadTasks(String filePath) {
        taskManager.loadFromFile(filePath);
        System.out.println("Task successfully loaded");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GuestUser guestUser = (GuestUser) o;
        return guestId == guestUser.guestId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), guestId);
    }

    @Override
    public String toString() {
        return super.toString() +
                "guestId=" + guestId;
    }
}
