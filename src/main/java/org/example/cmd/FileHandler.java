package org.example.cmd;

import org.example.task.RegularTask;
import org.example.task.Task;
import org.example.TaskManager;
import org.example.task.UrgentTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class FileHandler {
    /**
     * Saves the tasks to a file.
     * @param filePath the path to the file
     */
    public static void saveTasks(String filePath) {
//        for (Task task : TaskManager.getTasks()) {
//            if (task instanceof RegularTask regularTask) {
//                try (FileWriter fileWriter = new FileWriter(filePath)) {
//                    fileWriter.write("regular" +
//                            "," + regularTask.getTitle() +
//                            "," + regularTask.getCreatedDate() +
//                            "," + regularTask.isCompleted() +
//                            "," + regularTask.getTimePassed() + "\n");
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if (task instanceof UrgentTask urgentTask) {
//                try (FileWriter fileWriter = new FileWriter(filePath)) {
//                    fileWriter.write("urgent" +
//                            "," + urgentTask.getTitle() +
//                            "," + urgentTask.getCreatedDate() +
//                            "," + urgentTask.isCompleted() +
//                            "," + urgentTask.getDueDate() +
//                            "," + urgentTask.getPriority() + "\n");
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
    }
    /**
     * Loads tasks from a file.
     * @param filePath the path to the file
     */
    public static void loadTasks(String filePath) {
        File file = new File(filePath);
//        taskManager.clearTasks();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals("regular")) {
                    Task task = new RegularTask(parts[1]);
                    task.setCreatedDate(LocalDate.parse(parts[2]));
                    task.setCompleted(Boolean.parseBoolean(parts[3]));
//                    TaskManager.addTask(task);
                } else if (parts[0].equals("urgent")) {
                    Task task = new UrgentTask(parts[1], (parts[4]));
                    task.setCreatedDate(LocalDate.parse(parts[2]));
                    task.setCompleted(Boolean.parseBoolean(parts[3]));
                    ((UrgentTask) task).setPriority(UrgentTask.Priority.valueOf(parts[5]));
//                    taskManager.addTask(task);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (Exception e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}
