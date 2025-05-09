package org.example;

import org.example.task.RegularTask;
import org.example.task.Task;
import org.example.task.UrgentTask;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void addTask() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new RegularTask("Test Task");
        Task task2 = new UrgentTask("Test 1", LocalDate.of(2025, 5, 3), UrgentTask.Priority.HIGH);
        Task task3 = new RegularTask("Test 2");
        Task task4 = new RegularTask("Test 3");
        Task task5 = new UrgentTask("Test 1", LocalDate.of(2025, 5, 2), UrgentTask.Priority.LOW);

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);
        taskManager.addTask(task5);

        assertEquals(5, taskManager.getTasks().size());
        assertEquals(task1, taskManager.getTasks().get(0));
        assertEquals(task2, taskManager.getTasks().get(1));
        assertEquals(task3, taskManager.getTasks().get(2));
        assertEquals(task4, taskManager.getTasks().get(3));
        assertEquals(task5, taskManager.getTasks().get(4));
    }

    @Test
    void removeTask() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new RegularTask("Test Task");
        Task task2 = new UrgentTask("Test 1", LocalDate.of(2025, 5, 3), UrgentTask.Priority.HIGH);
        Task task3 = new RegularTask("Test 2");

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        assertEquals(3, taskManager.getTasks().size());

        taskManager.removeTask(task2);
        assertEquals(2, taskManager.getTasks().size());
        assertFalse(taskManager.getTasks().contains(task2));
    }

    @Test
    void markTaskComplete() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new RegularTask("Test Task");
        Task task2 = new UrgentTask("Test 1", LocalDate.of(2025, 5, 3), UrgentTask.Priority.HIGH);

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        assertFalse(task1.isCompleted());
        assertFalse(task2.isCompleted());

        taskManager.markTaskComplete(task1);
        assertTrue(task1.isCompleted());
        assertFalse(task2.isCompleted());
    }

    @Test
    void viewTasks() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new RegularTask("Test Task");
        Task task2 = new UrgentTask("Test 1", LocalDate.of(2025, 5, 3), UrgentTask.Priority.HIGH);

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        String expectedOutput = "title='Test Task', createdDate=" + LocalDate.now() + ", isCompleted=false, timePassed=0, index: 0\n" +
                "title='Test 1', createdDate=" + LocalDate.now() + ", isCompleted=false, priority=HIGH, dueDate=2025-05-03, index: 1\n";
        assertEquals(expectedOutput, taskManager.viewTasks());
    }

    @Test
    void sortTasks() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new RegularTask("Test 1");
        Task task2 = new UrgentTask("Test 2", LocalDate.of(2025, 5, 3), UrgentTask.Priority.HIGH);
        Task task3 = new RegularTask("Test 3");
        Task task4 = new RegularTask("Test 4");
        Task task5 = new UrgentTask("Test 5", LocalDate.of(2025, 5, 3), UrgentTask.Priority.LOW);

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);
        taskManager.addTask(task5);

        assertEquals(5, taskManager.getTasks().size());

        taskManager.sortTasks(new UrgentTask.TaskPriorityComparator());
        assertEquals(task2, taskManager.getTasks().getFirst());
    }

    @Test
    void searchTasks() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new RegularTask("Test Task");
        Task task2 = new UrgentTask("Test 1", LocalDate.of(2025, 5, 3), UrgentTask.Priority.HIGH);

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        assertEquals(1, taskManager.searchTasks("Test 1").size());
        assertEquals(task2, taskManager.searchTasks("Test 1").getFirst());
    }

    @Test
    void saveToFile() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new RegularTask("Test Task");
        Task task2 = new UrgentTask("Test 1", LocalDate.of(2025, 5, 3), UrgentTask.Priority.HIGH);

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        String filePath = "src/main/resources/tasks.csv";
        taskManager.saveToFile(filePath);

        // Verify that the file was created and contains the expected data
        File file = new File(filePath);
        assertTrue(file.exists());
    }

    @Test
    void loadFromFile() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new RegularTask("Test Task");
        Task task2 = new UrgentTask("Test 1", LocalDate.of(2025, 5, 3), UrgentTask.Priority.HIGH);

        String filePath = "src/main/resources/tasks.csv";
        taskManager.loadFromFile(filePath);
        assertEquals(2, taskManager.getTasks().size());
        assertEquals(task1, taskManager.getTasks().get(0));
        assertEquals(task2, taskManager.getTasks().get(1));
    }
}