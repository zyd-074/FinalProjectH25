package org.example;

import org.example.cmd.FileHandler;
import org.example.task.Task;

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
     * Clears all tasks from the task list.
     */
    public void clearTasks() {
        this.tasks.clear();
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
     * @param task the task to be marked as complete
     * @return true if the task was marked as complete, false otherwise
     */
    public boolean markTaskComplete(Task task) {
        if (task == null || !this.tasks.contains(task)) {
            System.out.println("Task not found");
            return false;
        }
        task.markComplete();
        System.out.println("Task marked as complete.");
        return true;
    }

    /**
     * Displays all tasks in the task list.
     */
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task + "\n");
        }
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
     * @return true if the tasks were saved successfully, false otherwise
     */
    public static boolean saveToFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            System.out.println("Invalid file path");
            return false;
        }
        FileHandler.saveTasks(filePath);
        System.out.println("Tasks saved to file: " + filePath);
        return true;
    }

    /**
     * Loads tasks from a file.
     * @param filePath the path to the file from which tasks will be loaded
     * @return true if the tasks were loaded successfully, false otherwise
     */
    public static boolean loadFromFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            System.out.println("Invalid file path");
            return false;
        }
        FileHandler.loadTasks(filePath);
        System.out.println("Tasks loaded from file: " + filePath);
        return true;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
