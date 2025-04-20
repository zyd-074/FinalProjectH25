package org.example;

import java.util.Date;

public class UrgentTask extends Task {
    private Date dueDate;
    private Priority priority;

    public static enum Priority {
        UNDER24H, UNDER7DAYS, UNDER1MONTH
    }
}
