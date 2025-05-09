package org.example.user;

import org.example.cmd.*;
import org.example.task.Task;
import org.example.task.UrgentTask;

import java.util.Objects;

public class StudentUser extends User {
    private final long studentId;
    private static long nextID = 20000;

    public StudentUser(String username) {
        super(username);
        this.studentId = nextID++;
    }

    /**
     * Adds a task to the task manager.
     * @param task the task to be added
     */
    public void addTask(Task task) {
        if (task != null) {
            Command command = new AddTaskCommand(task, taskManager);
            command.redo();
            undoStack.push(command);
        } else {
            System.out.println("Invalid task");
        }
    }

    /**
     * Deletes a task from the task manager.
     * @param idx the index of the task to be deleted
     */
    public void deleteTask(int idx) {
        if (idx < 0 || idx > taskManager.getTasks().size()) {
            System.out.println("Invalid index: " + idx);
        } else {
            Command command = new DeleteTaskCommand(taskManager.getTasks().get(idx), taskManager);
            command.redo();
            undoStack.push(command);
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
            Command command = new MarkCompleteCommand(task);
            undoStack.push(command);
            System.out.println("Task marked as complete.");
        }
    }

    /**
     * Marks a task as incomplete.
     * @param idx the index of the task to be marked as incomplete
     */
    public void markIncomplete(int idx) {
        if (idx < 0 || idx > taskManager.getTasks().size()) {
            System.out.println("Invalid index: " + idx);
        } else {
            Task task = taskManager.getTasks().get(idx);
            Command command = new MarkIncompleteCommand(task);
            undoStack.push(command);
            System.out.println("Task marked as incomplete.");
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
     * Saves tasks to a file.
     */
    public void saveTasks() {
        this.saveTasks("src/main/resources/tasks.csv");
    }

    /**
     * Loads tasks from a file.
     */
    public void loadTasks() {
        this.loadTasks("src/main/resources/tasks.csv");
    }

    /**
     * Loads tasks from a specified file path.
     * @param filePath the path to the file from which tasks will be loaded
     */
    public void loadTasks(String filePath) {
        taskManager.loadFromFile(filePath);
        System.out.println("Task successfully loaded");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentUser that = (StudentUser) o;
        return studentId == that.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId);
    }

    @Override
    public String toString() {
        return super.toString() +
                "studentId=" + studentId;
    }
}
