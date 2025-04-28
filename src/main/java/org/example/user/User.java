package org.example.user;

import org.example.cmd.Command;

import java.util.Stack;

public abstract class User {
    protected String username;
    protected Stack<Command> undoStack = new Stack<Command>();
    protected Stack<Command> redoStack = new Stack<Command>();

    public User(String username) {
        this.username = username;
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public abstract void displayAllTasks();
}
