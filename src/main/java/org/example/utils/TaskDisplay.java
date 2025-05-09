package org.example.utils;

import org.example.task.Task;

import java.util.List;

public class TaskDisplay {
    /**
     * Displays all tasks in the task list.
     */
    public static void viewTasks(List<Task> tasks) {
        String result = "";
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        }
        for (int i = 0; i < tasks.size(); i++) {
            result += (tasks.get(i) + ", index: " + i + "\n");
        }
        System.out.println(result);
    }
}
