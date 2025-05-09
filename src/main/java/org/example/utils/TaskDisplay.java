package org.example.utils;

import org.example.Main;
import org.example.task.Task;

import java.util.List;
import java.util.Scanner;

public class TaskDisplay {
    /**
     * Displays all tasks in the task list.
     */
    public static void viewTasks(List<Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        System.out.println("Select your operation: \n1. View all tasks\n2. Search for tasks");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1 -> {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                }
                for (int i = 0; i < tasks.size(); i++) {
                    result += (tasks.get(i) + ", index: " + i + "\n");
                }
            }
            case 2-> {
                System.out.print("Enter the keyword to search for:");
                String keyword = scanner.nextLine();
                List<Task> searchTasks =  Main.user.getTaskManager().searchTasks(keyword);
                for (int i = 0; i < searchTasks.size(); i++) {
                    result += (searchTasks.get(i) + ", index: " + i + "\n");
                }
            }
        }
        System.out.println(result);
    }
}
