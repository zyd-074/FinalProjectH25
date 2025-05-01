package org.example.user;

import org.example.task.Task;

public class StudentUser extends User {
    private long studentId;
    private static long nextID = 20000;

    public StudentUser(String username, long studentId) {
        super(username);
        this.studentId = nextID++;
    }

    public boolean addTask(Task task) {
        if (task != null){
            this.taskManager.addTask(task);
            return true;
        } else {
            System.out.println("Invalid task");
            return false;
        }
    }
    public boolean deleteTask(int idx) {
        if (idx < 0 || idx > this.taskManager.getTasks().size()) {
            System.out.println("Invalid index: " + idx);
            return false;
        } else {
            this.taskManager.getTasks().remove(idx);
            System.out.println("Task successfully removed.");
            return true;
        }
    }
    public void markComplete(int idx) {
        //Todo
    }
    public void sortByDeadline() {
        //Todo
    }
    public void sortByPriority() {
        //Todo
    }
    public void saveTasks(String filePath) {
        //Todo
    }
    public void loadTasks(String filePath) {
        //Todo
    }

    @Override
    public void displayAllTasks() {

    }
}
