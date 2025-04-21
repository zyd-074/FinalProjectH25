package org.example;

import org.example.task.Task;

import java.util.Comparator;
import java.util.List;

public class TaskManager{
    private List<Task> tasks;

    public boolean addTask(Task task) {
        //Todo
    }

    public boolean removeTask(int idx) {
        //Todo
    }

    public boolean markTaskComplete(int idx) {
        //Todo
    }

    public void viewTasks() {
        //Todo
    }

    public void sortTasks(Comparator<Task> comparator) {
        //Todo
    }

    public List<Task> searchTasks(String keyword) {
        //Todo
    }

    public void saveToFile(String filePath) {
        //Todo
    }

    public void loadFromFile(String filePath) {
        //todo
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
