package org.example.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TaskTest {

    @Test
    void markComplete() {
        Task task = new RegularTask("Test Task");
        task.markComplete();
        assertTrue(task.isCompleted());
    }

    @Test
    void markIncomplete() {
        Task task = new RegularTask("Test Task");
        task.markComplete();
        assertTrue(task.isCompleted());
        task.markIncomplete();
        assertFalse(task.isCompleted());
    }
}