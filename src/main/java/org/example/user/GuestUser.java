package org.example.user;

public class GuestUser extends User {
    private long guestId;

    public GuestUser(String username, long guestId) {
        super(username);
        this.guestId = guestId;
    }

    public void sortByDeadline() {
        //Todo
    }
    public void sortByPriority() {
        //Todo
    }

    @Override
    public void displayAllTasks() {
        //Todo
    }

    public void loadTasks(String filePath) {
        //Todo
    }
}
