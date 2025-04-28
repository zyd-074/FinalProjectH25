package org.example.task;

import java.time.Duration;
import java.time.LocalDate;

public class RegularTask extends Task implements Comparable<Task> {
    private final Duration timePassed;

    public RegularTask(String title) {
        super(title);
        this.timePassed = Duration.between(this.createdDate, LocalDate.now());
    }

    @Override
    public int compareTo(Task o) throws ClassCastException {
        if (o instanceof RegularTask) {
            return this.timePassed.compareTo(((RegularTask) o).timePassed);
        } else {
            throw new ClassCastException();
        }
    }

    public Duration getTimePassed() {
        return Duration.between(this.createdDate, LocalDate.now());
    }
}
