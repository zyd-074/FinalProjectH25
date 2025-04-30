package org.example.user;

import org.example.cmd.FileHandler;
import org.example.task.Task;
import org.example.task.UrgentTask;

import java.util.List;

public class GuestUser extends User {
    private final long guestId;
    private static long nextID = 10001;
    public GuestUser(String username, long guestId) {
        super(username);
        this.guestId = nextID++;
    }

    public void sortByDeadline(List<Task> tasks) {
        tasks.sort(new UrgentTask.TaskDueDateComparator());
    }
    public void sortByPriority(List<Task> tasks) {
        tasks.sort(new UrgentTask.TaskPriorityComparator());
    }

    @Override
    public void displayAllTasks() {
        this.taskManager.viewTasks();
    }

    public boolean loadTasks(String filePath) {
        FileHandler.loadTasks(filePath);
        System.out.println("Task successfully loaded");
        return true;
    }
}
