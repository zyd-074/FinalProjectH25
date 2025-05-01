package org.example.task;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RegularTask extends Task implements Comparable<Task> {
    private final long timePassed;

    public RegularTask(String title) {
        super(title);
        this.timePassed = ChronoUnit.DAYS.between(this.createdDate, LocalDate.now());
    }

    @Override
    public int compareTo(Task o) throws ClassCastException {
        if (o instanceof RegularTask otherTask) {
            return Long.compare(this.timePassed, otherTask.timePassed);
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                "timePassed=" + timePassed;
    }

    public long getTimePassed() {
        return timePassed;
    }
}
