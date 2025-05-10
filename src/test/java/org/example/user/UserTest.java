package org.example.user;

import org.example.task.RegularTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void undo() {
        StudentUser user = new StudentUser("Test User");
        user.addTask(new RegularTask("Test Task1"));
        user.addTask(new RegularTask("Test Task2"));
        user.deleteTask(0);

        Assertions.assertEquals(user.undoStack.size(), 3);
        user.undo();
        Assertions.assertEquals(user.undoStack.size(), 2);
        Assertions.assertEquals(user.taskManager.getTasks().size(), 2);
    }

    @Test
    void redo() {
        StudentUser user = new StudentUser("Test User");
        user.addTask(new RegularTask("Test Task1"));
        user.addTask(new RegularTask("Test Task2"));
        user.deleteTask(0);

        Assertions.assertEquals(0, user.redoStack.size());
        user.undo();
        Assertions.assertEquals(1, user.redoStack.size());
        Assertions.assertEquals(user.taskManager.getTasks().size(), 2);
        user.redo();
        Assertions.assertEquals(0, user.redoStack.size());
        Assertions.assertEquals(user.taskManager.getTasks().size(), 1);
    }
}