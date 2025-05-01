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

    /**
     * Adds a task to the task manager.
     * @param task the task to be added
     * @return true if the task was added successfully, false otherwise
     */
    public boolean addTask(Task task) {
        if (task != null){
            taskManager.addTask(task);
            return true;
        } else {
            System.out.println("Invalid task");
            return false;
        }
    }

    /**
     * Deletes a task from the task manager.
     * @param idx the index of the task to be deleted
     * @return true if the task was deleted successfully, false otherwise
     */
    public boolean deleteTask(int idx) {
        if (idx < 0 || idx > taskManager.getTasks().size()) {
            System.out.println("Invalid index: " + idx);
            return false;
        } else {
            taskManager.getTasks().remove(idx);
            System.out.println("Task successfully removed.");
            return true;
        }
    }

    /**
     * Marks a task as complete.
     * @param idx the index of the task to be marked as complete
     */
    public void markComplete(int idx) {
        if (idx < 0 || idx > taskManager.getTasks().size()) {
            System.out.println("Invalid index: " + idx);
        } else {
            Task task = taskManager.getTasks().get(idx);
            task.markComplete();
            System.out.println("Task marked as complete.");
        }
    }

    /**
     * Sorts tasks by deadline or priority.
     */
    public void sortByDeadline() {
        taskManager.sortTasks(new UrgentTask.TaskDueDateComparator());
    }

    /**
     * Sorts tasks by priority.
     */
    public void sortByPriority() {
        taskManager.sortTasks(new UrgentTask.TaskPriorityComparator());
    }

    /**
     * Saves tasks to a file.
     * @param filePath the path to the file where tasks will be saved
     */
    public void saveTasks(String filePath) {
        taskManager.saveToFile(filePath);
    }

    /**
     * Loads tasks from a file.
     * @param filePath the path to the file from which tasks will be loaded
     */
    public void loadTasks(String filePath) {
        taskManager.loadFromFile(filePath);
        System.out.println("Task successfully loaded");
    }

    /**
     * Displays all tasks in the task manager.
     */
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
