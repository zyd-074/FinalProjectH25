package org.example;

import org.example.task.RegularTask;
import org.example.task.Task;
import org.example.task.UrgentTask;
import org.example.user.GuestUser;
import org.example.user.StudentUser;
import org.example.user.User;
import org.example.utils.TaskDisplay;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static boolean isRunning = true;
    public static User user;
    public static void main(String[] args) {
        System.out.println("Select your identity: \n1. Student\n2. Guest");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter your username:");
                String username = scanner.nextLine();
                user = new StudentUser(username);
                System.out.println("User created successfully.");
                System.out.println("Welcome, " + user.getUsername() + "!");
            }
            case 2 -> {
                System.out.print("Enter your username:");
                String username = scanner.nextLine();
                user = new GuestUser(username);
                System.out.println("User created successfully.");
                System.out.println("Welcome " + user.getUsername() + "!");
            }
            default -> {
                System.out.println("Invalid choice. Please select 1 or 2.");
                return;
            }
        }
        while (isRunning) {
            System.out.println("Select your action: ");
            if (user instanceof StudentUser studentUser) {
                displayStudentMenu();
                int action = scanner.nextInt();
                scanner.nextLine();
                switch (action) {
                    case 1 -> addTask();
                    case 2 -> removeTask();
                    case 3 -> {
                        System.out.print("Enter task index to mark as complete\n(if you're not sure, enter -1 and try \"View all Tasks\"): ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        if (index <= -1) {
                            return;
                        } else if (index >= studentUser.getTaskManager().getTasks().size()) {
                            System.out.println("Invalid index: " + index);
                        } else {
                            studentUser.markComplete(index);
                        }
                    }
                    case 4 -> TaskDisplay.viewTasks(user.getTaskManager().getTasks());
                    case 5 -> {
                        System.out.println("Sort by:\n1. Deadline\n2. Priority");
                        int sortChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (sortChoice) {
                            case 1 -> studentUser.sortByDeadline();
                            case 2 -> studentUser.sortByPriority();
                            default -> {
                                System.out.println("Invalid choice.");
                                return;
                            }
                        }
                        System.out.println("Tasks sorted successfully.");
                    }
                    case 6 -> {
                        System.out.print("Enter file path to load tasks or leave blank for default path: ");
                        String filePath = scanner.nextLine();
                        if (filePath.isEmpty()) {
                            studentUser.loadTasks();
                        } else {
                            studentUser.loadTasks(filePath);
                        }
                    }
                    case 7 -> {
                        System.out.print("Enter file path to save tasks or leave blank for default path: ");
                        String filePath = scanner.nextLine();
                        if (filePath.isEmpty()) {
                            studentUser.saveTasks();
                        } else {
                            studentUser.saveTasks(filePath);
                        }
                    }
                    case 8 -> user.undo();
                    case 9 -> user.redo();
                    case 0 -> isRunning = false;
                    default -> System.out.println("Invalid choice. Please select a valid action.");
                }
            } else {
                GuestUser guestUser = (GuestUser) user;
                displayGuestMenu();
                int action = scanner.nextInt();
                scanner.nextLine();
                switch (action) {
                    case 1 -> {
                        System.out.print("Enter file path to load tasks or leave blank for default path: ");
                        String filePath = scanner.nextLine();
                        if (filePath.isEmpty()) {
                            guestUser.loadTasks("src/main/resources/tasks.csv");
                        } else {
                            guestUser.loadTasks(filePath);
                        }
                    }
                    case 2 -> TaskDisplay.viewTasks(user.getTaskManager().getTasks());
                    case 3 -> guestUser.sortByDeadline();
                    case 4 -> guestUser.sortByPriority();
                    case 0 -> isRunning = false;
                    default -> System.out.println("Invalid choice. Please select a valid action.");
                }
            }
        }
    }
    public static void displayStudentMenu() {
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. Mark Task Complete");
        System.out.println("4. View All Tasks");
        System.out.println("5. Sort Tasks");
        System.out.println("6. Load Tasks from File");
        System.out.println("7. Save Tasks to File");
        System.out.println("8. Undo");
        System.out.println("9. Redo");
        System.out.println("0. Exit");
    }
    public static void displayGuestMenu() {
        System.out.println("1. Load Tasks from File");
        System.out.println("2. View All Tasks");
        System.out.println("3. Sort Tasks by Deadline");
        System.out.println("4. Sort Tasks by Priority");
        System.out.println("0. Exit");
    }

    public static void addTask() {
        StudentUser studentUser = (StudentUser) user;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is is urgent? (yes/no)");
        String isUrgent = scanner.nextLine();
        while (!isUrgent.equalsIgnoreCase("yes") && !isUrgent.equalsIgnoreCase("no")) {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            isUrgent = scanner.nextLine();
        }
        switch (isUrgent) {
            case "yes" -> {
                System.out.print("Enter task name: ");
                String taskName = scanner.nextLine();
                System.out.print("Enter task due date (yyyy-mm-dd): ");
                String dueDate = scanner.nextLine();
                while (!dateIsValid(dueDate)) {
                    System.out.print("Invalid date format. Please enter a valid date (yyyy-mm-dd): ");
                    dueDate = scanner.nextLine();
                }
                LocalDate date = LocalDate.parse(dueDate);
                while (date.isBefore(LocalDate.now())) {
                    System.out.print("Due date cannot be in the past. Please enter a valid date (yyyy-mm-dd): ");
                    dueDate = scanner.nextLine();
                    date = LocalDate.parse(dueDate);
                }
                System.out.println("Enter the priority level (LOW, MEDIUM or HIGH)");
                String priorityLevel = scanner.nextLine();
                while (!priorityLevel.equalsIgnoreCase("LOW")
                        && !priorityLevel.equalsIgnoreCase("MEDIUM")
                        && !priorityLevel.equalsIgnoreCase("HIGH")) {
                    System.out.println("Invalid priority level. Please enter LOW, MEDIUM or HIGH:");
                    priorityLevel = scanner.nextLine();
                }
                UrgentTask.Priority priority = UrgentTask.Priority.valueOf(priorityLevel.toUpperCase());
                Task task = new UrgentTask(taskName, date, priority);
                studentUser.addTask(task);
                System.out.println("Task added successfully.");
            }
            case "no" -> {
                System.out.print("Enter task name: ");
                String taskName = scanner.nextLine();
                Task task = new RegularTask(taskName);
                studentUser.addTask(task);
                System.out.println("Task added successfully.");
            }
            default -> System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }

    public static void removeTask() {
        StudentUser studentUser = (StudentUser) user;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter task index to remove\n(if you're not sure, enter -1 and try \"View all Tasks\"): ");
        int index = scanner.nextInt();
        if (index >= studentUser.getTaskManager().getTasks().size()) {
            System.out.println("Invalid index: " + index);
        } else {
            studentUser.deleteTask(index);
        }
    }

    public static boolean dateIsValid(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}