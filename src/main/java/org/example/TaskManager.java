package org.example;

import org.example.task.Task;
import org.example.utils.FileHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager{
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the task list.
     * @param task the task to be added
     */
    public void addTask(Task task) {
        if (task == null) {
            return;
        }
        this.tasks.add(task);
    }

    /**
     * Removes a task from the task list.
     * @param task the task to be removed
     */
    public void removeTask(Task task) {
        if (task == null || !this.tasks.contains(task)) {
            System.out.println("Task not found");
            return;
        }
        tasks.remove(task);
        System.out.println("Task removed successfully.");
    }

    /**
     * Marks a task as complete.
     *
     * @param task the task to be marked as complete
     */
    public void markTaskComplete(Task task) {
        if (task == null || !this.tasks.contains(task)) {
            System.out.println("Task not found");
            return;
        }
        task.markComplete();
        System.out.println("Task marked as complete.");
    }

    public void markTaskIncomplete(Task task) {
        if (task == null || !this.tasks.contains(task)) {
            System.out.println("Task not found");
            return;
        }
        task.markIncomplete();
        System.out.println("Task marked as incomplete.");
    }

    /**
     * Sorts the tasks in the task list using the provided comparator.
     * @param comparator the comparator to be used for sorting
     */
    public void sortTasks(Comparator<Task> comparator) {
        if (comparator == null) {
            System.out.println("Invalid comparator");
            return;
        }
        this.tasks.sort(comparator);
        System.out.println("Tasks sorted successfully.");
    }

    /**
     * Searches for tasks containing the specified keyword in their title.
     * @param keyword the keyword to search for
     * @return a list of tasks containing the keyword
     */
    public List<Task> searchTasks(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return new ArrayList<>(this.tasks);
        }

        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(task);
            }
        }
        return result;
    }

    /**
     * Saves the tasks to a file.
     * @param filePath the path to the file where tasks will be saved
     */
    public void saveToFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            FileHandler.saveTasks(tasks);
        }
        FileHandler.saveTasks(tasks, filePath);
        System.out.println("Tasks saved to file: " + filePath);
    }

    /**
     * Loads tasks from a file.
     * @param filePath the path to the file from which tasks will be loaded
     */
    public void loadFromFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            this.tasks = FileHandler.loadTasks();
        }
        this.tasks = FileHandler.loadTasks(filePath);
        System.out.println("Tasks loaded from file: " + filePath);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
