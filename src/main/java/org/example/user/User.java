package org.example.user;

import org.example.TaskManager;
import org.example.cmd.Command;

import java.util.Stack;

public abstract class User{
    protected String username;
    protected Stack<Command> undoStack = new Stack<Command>();
    protected Stack<Command> redoStack = new Stack<Command>();
    protected TaskManager taskManager = new TaskManager();

    public User(String username) {
        this.username = username;
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
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
}
