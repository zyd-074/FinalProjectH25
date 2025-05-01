package org.example.cmd;

import org.example.task.RegularTask;
import org.example.task.Task;
import org.example.TaskManager;
import org.example.task.UrgentTask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    static File file = new File("src/main/resources/tasks.csv");

    public static void saveTasks(String filePath) {
        for (Task task : TaskManager.getTasks()) {
            if (task instanceof RegularTask regularTask) {
                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write("regular" +
                            "," + regularTask.getTitle() +
                            "," + regularTask.getCreatedDate() +
                            "," + regularTask.isCompleted() +
                            "," + regularTask.getTimePassed() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (task instanceof UrgentTask urgentTask) {
                try (FileWriter fileWriter = new FileWriter(file)) {
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
    public static void loadTasks(String filePath) {
        //Todo
    }
}
