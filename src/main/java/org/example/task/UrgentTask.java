package org.example.task;

import java.time.LocalDate;
import java.util.Comparator;

public class UrgentTask extends Task {
    private Priority priority;
    private LocalDate dueDate;

    public static enum Priority {
        UNDER24H, UNDER7DAYS, UNDER1MONTH
    }

    public class TaskPriorityComparator implements Comparator<Task> {

        @Override
        public int compare(Task o1, Task o2) {
            return 0;
            //Todo
        }
    }
}
