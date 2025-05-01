package org.example;

import org.example.cmd.FileHandler;
import org.example.task.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager{
    private final List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (task == null) {
            return;
        }
        tasks.add(task);
    }

    public boolean removeTask(int idx) {
        if (idx < 0 || idx >= tasks.size()) {
            System.out.println("Invalid index");
            return false;
        }
        tasks.remove(idx);
        return true;
    }

    public boolean markTaskComplete(int idx) {
        if (idx < 0 || idx >= tasks.size()) {
            System.out.println("Invalid index");
            return false;
        }
        tasks.get(idx).markComplete();
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

    public boolean sortTasks(Comparator<Task> comparator) {
        if (comparator == null) {
            System.out.println("Invalid comparator");
            return false;
        }
        tasks.sort(comparator);
        System.out.println("Tasks sorted successfully.");
        return true;
    }

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

    public boolean saveToFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            System.out.println("Invalid file path");
            return false;
        }
        FileHandler.saveTasks(filePath);
        System.out.println("Tasks saved to file: " + filePath);
        return true;
    }

    public boolean loadFromFile(String filePath) {
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
}
