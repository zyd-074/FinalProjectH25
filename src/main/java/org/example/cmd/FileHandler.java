package org.example.cmd;

import org.example.task.RegularTask;
import org.example.task.Task;
import org.example.TaskManager;
import org.example.task.UrgentTask;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    static String filePath = "src/main/resources/tasks.csv";

    /**
     * Saves tasks to a file to the default path.
     * @param tasks the list of tasks to be saved
     */
    public static void saveTasks(List<Task> tasks) {
        saveTasks(tasks, filePath);
    }
    /**
     * Saves tasks to a file to a specific path.
     * @param tasks the list of tasks to be saved
     * @param filePath the path to the file where tasks will be saved
     */
    public static void saveTasks(List<Task> tasks, String filePath) {
        //Reinitialize the file
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Write
        for (Task task : tasks) {
            if (task instanceof RegularTask regularTask) {
                try (FileWriter fileWriter = new FileWriter(filePath, true)) {
                    fileWriter.write("regular" +
                            "," + regularTask.getTitle() +
                            "," + regularTask.getCreatedDate() +
                            "," + regularTask.isCompleted() +
                            "," + regularTask.getTimePassed() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (task instanceof UrgentTask urgentTask) {
                try (FileWriter fileWriter = new FileWriter(filePath, true)) {
                    fileWriter.write("urgent" +
                            "," + urgentTask.getTitle() +
                            "," + urgentTask.getCreatedDate() +
                            "," + urgentTask.isCompleted() +
                            "," + urgentTask.getDueDate() +
                            "," + urgentTask.getPriority() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * Loads tasks from default path.
     */
    public static List<Task> loadTasks() {
        return loadTasks(filePath);
    }

    /**
     * Loads tasks from specific path.
     */
    public static List<Task> loadTasks(String filePath) {
        File file = new File(filePath);
        TaskManager taskManager = new TaskManager();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals("regular")) {
                    Task task = new RegularTask(parts[1], LocalDate.parse(parts[2]));
                    task.setCreatedDate(LocalDate.parse(parts[2]));
                    task.setCompleted(Boolean.parseBoolean(parts[3]));
                    taskManager.addTask(task);
                } else if (parts[0].equals("urgent")) {
                    Task task = new UrgentTask(parts[1], LocalDate.parse(parts[4]), UrgentTask.Priority.valueOf(parts[5]));
                    task.setCreatedDate(LocalDate.parse(parts[2]));
                    task.setCompleted(Boolean.parseBoolean(parts[3]));
                    taskManager.addTask(task);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (Exception e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return taskManager.getTasks();
    }
}
