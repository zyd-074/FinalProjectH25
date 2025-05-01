package org.example.user;

import org.example.TaskManager;
import org.example.cmd.FileHandler;
import org.example.task.Task;
import org.example.task.UrgentTask;

public class StudentUser extends User {
    private long studentId;
    private static long nextID = 20000;

    public StudentUser(String username, long studentId) {
        super(username);
        this.studentId = nextID++;
    }

    public boolean addTask(Task task) {
        if (task != null){
            TaskManager.addTask(task);
            return true;
        } else {
            System.out.println("Invalid task");
            return false;
        }
    }
    public boolean deleteTask(int idx) {
        if (idx < 0 || idx > TaskManager.getTasks().size()) {
            System.out.println("Invalid index: " + idx);
            return false;
        } else {
            TaskManager.getTasks().remove(idx);
            System.out.println("Task successfully removed.");
            return true;
        }
    }
    public void markComplete(int idx) {
        if (idx < 0 || idx > TaskManager.getTasks().size()) {
            System.out.println("Invalid index: " + idx);
        } else {
            Task task = TaskManager.getTasks().get(idx);
            task.markComplete();
            System.out.println("Task marked as complete.");
        }
    }
    public void sortByDeadline() {
        TaskManager.sortTasks(new UrgentTask.TaskDueDateComparator());
    }
    public void sortByPriority() {
        TaskManager.sortTasks(new UrgentTask.TaskPriorityComparator());
    }
    public void saveTasks(String filePath) {
        FileHandler.saveTasks(filePath);
    }
    public void loadTasks(String filePath) {
        FileHandler.loadTasks(filePath);
        System.out.println("Task successfully loaded");
    }

    @Override
    public void displayAllTasks() {
        this.taskManager.viewTasks();
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
}
