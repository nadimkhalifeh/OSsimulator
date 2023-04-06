package ca.concordia.coen346.server;

public class PID {
    private int id;
    private boolean available;

    //PID object, constructed with the ID and boolean available to indicate whether the process ID is in use.
    public PID(int i, boolean t) {
        id = i;
        available = t;
    }

    public PID(int i) {
        id = i;
    }

    //getter for process PID
    public int getID() {
        return id;
    }

    //getter for availability status
    boolean isAvailable() {
        if (available == true) {
            return true;
        }
        return false;
    }

    //sets availability
    void setAvailable(boolean b) {
        available = b;

    }

}
