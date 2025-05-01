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

    /**
     * Sorts the tasks by their deadline.
     * @param tasks the list of tasks to be sorted
     */
    public void sortByDeadline(List<Task> tasks) {
        tasks.sort(new UrgentTask.TaskDueDateComparator());
    }

    /**
     * Sorts the tasks by their priority.
     * @param tasks the list of tasks to be sorted
     */
    public void sortByPriority(List<Task> tasks) {
        tasks.sort(new UrgentTask.TaskPriorityComparator());
    }

    /**
     * Displays all tasks in the task manager.
     */
    @Override
    public void displayAllTasks() {
        this.taskManager.viewTasks();
    }

    /**
     * Loads tasks to a file.
     * @param filePath the path to the file from which tasks will be loaded
     */
    public void loadTasks(String filePath) {
        taskManager.loadFromFile(filePath);
        System.out.println("Task successfully loaded");
    }
}
