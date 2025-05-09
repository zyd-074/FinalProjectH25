package org.example.task;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class RegularTask extends Task implements Comparable<Task> {
    private long timePassed;

    public RegularTask(String title) {
        super(title);
        this.timePassed = ChronoUnit.DAYS.between(this.createdDate, LocalDate.now());
    }
    public RegularTask(String title, LocalDate createdDate) {
        super(title);
        this.timePassed = ChronoUnit.DAYS.between(createdDate, LocalDate.now());
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
        return ChronoUnit.DAYS.between(this.createdDate, LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RegularTask that = (RegularTask) o;
        return timePassed == that.timePassed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timePassed);
    }
}
