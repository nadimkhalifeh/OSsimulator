package ca.concordia.coen346.server;

public class PIDManager {
    private PID pid;
    private static final int PIDmap_size = 10;

    private static PID[] PIDmap;

    //constructor for PID manager
    public PIDManager() {
        this.PIDmap = new PID[PIDmap_size];
    }

    public PID getPID() {
        return pid;
    }

    //getter for array containing PIDs
    public PID[] getPIDmap() {
        return PIDmap;
    }

    //Initializes array for storing PIDs
    public void allocateMap() throws Exception {

        for (int i = 0; i < PIDmap.length; i++) {
            PIDmap[i] = new PID(i, true);
        }

    }

    //Assigns available PIDs to processes
    public int allocatePid() throws Exception {
        for (int i = 0; i < PIDmap.length; i++) {
            if (PIDmap[i].isAvailable()) {
                PIDmap[i].setAvailable(false);
                return PIDmap[i].getID();
            }


        }
        throw new Exception("No Available PIDS");  //if there is no available pidsit will exit allocatePID without returning
    }

    //sets PID status to available, called in terminate process method in pOperation
    void releasePid(int pid) {
        if (pid < 0 || pid > PIDmap_size - 1) throw new IllegalArgumentException("Invalid ID");
        else
            PIDmap[pid].setAvailable(true);
    }
}
