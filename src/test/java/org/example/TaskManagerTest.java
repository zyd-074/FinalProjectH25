package org.example;

import org.example.task.RegularTask;
import org.example.task.Task;
import org.example.task.UrgentTask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void addTask() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new RegularTask("Test Task");
        Task task2 = new UrgentTask("Test 1", "2025/05/03");
        Task task3 = new RegularTask("Test 2");
        Task task4 = new RegularTask("Test 3");
        Task task5 = new UrgentTask("Test 1", "2025/05/02");

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);
        taskManager.addTask(task5);

        assertEquals(5, taskManager.getTasks().size());
    }

    @Test
    void clearTasks() {
    }

    @Test
    void removeTask() {
    }

    @Test
    void markTaskComplete() {
    }

    @Test
    void viewTasks() {
    }

    @Test
    void sortTasks() {
    }

    @Test
    void searchTasks() {
    }

    @Test
    void saveToFile() {
    }

    @Test
    void loadFromFile() {
    }
}