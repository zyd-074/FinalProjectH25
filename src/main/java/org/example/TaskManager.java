package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class TaskManager{
    private List<Task> tasks;
    private Stack<Task> undoStack;
    private Stack<Task> redoStack;

    public boolean addTask(Task task) {
        //Todo
    }

    public boolean removeTask(int idx) {
        //Todo
    }

    public boolean modifyTask(int idx) {
        //Todo
    }

    public List<Task> searchTask(List<Task> tasks, String keyword) {
        //Todo
    }

    public void viewTasks() {
        //Todo
    }

    public void saveToFile(String filePath) {
        //Todo
    }

    public void loadFromFile(String filePath) {
        //todo
    }

    public void sortTasks(Comparator<Task> comparator) {
        //Todo
    }

    public boolean markTaskComplete(int idx) {
        //Todo
    }

    public static class PriorityComparator implements Comparator<Task>{
        @Override
        public int compare(Task o1, Task o2) {
            return 0;
            //Todo
        }
    }

    public static class DueDateComparator implements Comparator<Task>{

        @Override
        public int compare(Task o1, Task o2) {
            return 0;
            //Todo
        }
    }
}
