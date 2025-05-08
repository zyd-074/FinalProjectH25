package org.example.user;

import org.example.TaskManager;
import org.example.cmd.Command;

import java.util.Objects;
import java.util.Stack;

public abstract class User{
    protected String username;
    protected Stack<Command> undoStack;
    protected Stack<Command> redoStack;
    protected TaskManager taskManager;

    public User(String username) {
        this.username = username;
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
        this.taskManager = new TaskManager();
    }

    public abstract void displayAllTasks();

    /**
     * Adds a command to the undo stack and push the redo stack.
     */
    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        } else {
            System.out.println("No commands to undo.");
        }
    }

    /**
     * Adds a command to the redo stack and push the undo stack.
     */
    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.redo();
            undoStack.push(command);
        } else {
            System.out.println("No commands to redo.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(undoStack, user.undoStack) && Objects.equals(redoStack, user.redoStack) && Objects.equals(taskManager, user.taskManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, undoStack, redoStack, taskManager);
    }

    @Override
    public String toString() {
        return "username='" + username + '\'' +
                ", undoStack=" + undoStack +
                ", redoStack=" + redoStack +
                ", taskManager=" + taskManager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Stack<Command> getUndoStack() {
        return undoStack;
    }

    public void setUndoStack(Stack<Command> undoStack) {
        this.undoStack = undoStack;
    }

    public Stack<Command> getRedoStack() {
        return redoStack;
    }

    public void setRedoStack(Stack<Command> redoStack) {
        this.redoStack = redoStack;
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    public void setTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }
}
