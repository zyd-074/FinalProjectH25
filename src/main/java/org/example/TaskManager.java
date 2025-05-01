package org.example;

import org.example.cmd.FileHandler;
import org.example.task.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager{
    private static List<Task> tasks = new ArrayList<>();

    public static void addTask(Task task) {
        if (task == null) {
            return;
        }
        tasks.add(task);
    }

    public static void clearTasks() {
        tasks.clear();
    }

    public static void removeTask(Task task) {
        if (task == null || !tasks.contains(task)) {
            System.out.println("Task not found");
            return;
        }
        tasks.remove(task);
        System.out.println("Task removed successfully.");
    }

    public static boolean markTaskComplete(Task task) {
        if (task == null || !tasks.contains(task)) {
            System.out.println("Task not found");
            return false;
        }
        task.markComplete();
        System.out.println("Task marked as complete.");
        return true;
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task + "\n");
        }
    }

    public static boolean sortTasks(Comparator<Task> comparator) {
        if (comparator == null) {
            System.out.println("Invalid comparator");
            return false;
        }
        tasks.sort(comparator);
        System.out.println("Tasks sorted successfully.");
        return true;
    }

    public static List<Task> searchTasks(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return new ArrayList<>(tasks);
        }

        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(task);
            }
        }
        return result;
    }

    public static boolean saveToFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            System.out.println("Invalid file path");
            return false;
        }
        FileHandler.saveTasks(filePath);
        System.out.println("Tasks saved to file: " + filePath);
        return true;
    }

    public static boolean loadFromFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            System.out.println("Invalid file path");
            return false;
        }
        FileHandler.loadTasks(filePath);
        System.out.println("Tasks loaded from file: " + filePath);
        return true;
    }

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void setTasks(List<Task> tasks) {
        TaskManager.tasks = tasks;
    }
}
