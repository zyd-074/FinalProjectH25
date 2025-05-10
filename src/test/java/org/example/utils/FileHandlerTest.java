package org.example.utils;

import org.example.TaskManager;
import org.example.task.RegularTask;
import org.example.task.UrgentTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

class FileHandlerTest {

    @Test
    void saveTasks() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(new RegularTask("Test Task"));
        taskManager.addTask(new RegularTask("Test Task 2"));
        taskManager.addTask(new RegularTask("Test Task 3"));
        taskManager.addTask(new UrgentTask("Test Task 4", LocalDate.of(2025, 5, 10), UrgentTask.Priority.HIGH));

        String filePath = "src/main/resources/test_tasks.csv";
        FileHandler.saveTasks(taskManager.getTasks(), filePath);
        File fileTest = new File(filePath);
        Assertions.assertTrue(fileTest.exists());
        try (Scanner scanner = new Scanner(fileTest)){
            String line = scanner.nextLine();
            Assertions.assertEquals("regular,Test Task," + LocalDate.now() + ",false,0", line);
            line = scanner.nextLine();
            Assertions.assertEquals("regular,Test Task 2," + LocalDate.now() + ",false,0", line);
            line = scanner.nextLine();
            Assertions.assertEquals("regular,Test Task 3," + LocalDate.now() + ",false,0", line);
            line = scanner.nextLine();
            Assertions.assertEquals("urgent,Test Task 4," + LocalDate.now() + ",false," +
                    LocalDate.of(2025, 5, 10) + ",HIGH", line);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void loadTasks() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(new RegularTask("Test Task"));
        taskManager.addTask(new RegularTask("Test Task 2"));
        taskManager.addTask(new RegularTask("Test Task 3"));
        taskManager.addTask(new UrgentTask("Test Task 4", LocalDate.of(2025, 5, 10), UrgentTask.Priority.HIGH));

        String filePath = "src/main/resources/test_tasks.csv";
        FileHandler.loadTasks(filePath);

        Assertions.assertEquals(FileHandler.loadTasks(filePath), taskManager.getTasks());
    }
}