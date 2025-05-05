public class Bully {

    public static void main(String[] args) throws Exception {
        // Creating Processes
        Process[] processes = new Process[5];
        for (int i = 0; i < processes.length; i++) {
            processes[i] = new Process(i);
        }

        // Assume Process 5 is the initial Coordinator.
        Process.coordinatorId = 4;
        System.out.println("Initial Coordinator is Process " + Process.coordinatorId);

        // Simulating Coordinator Failure.
        processes[4].isAlive = false;
        System.out.println("Process 4 (coordinator) has failed!");

        // start election from a lower process
        processes[0].startElection(processes);

        System.out.println("Final Coordinator is Process " + Process.coordinatorId);
    }
}

class Process {
    int id;
    boolean isAlive;
    static int coordinatorId = -1;

    Process(int id) {
        this.id = id;
        this.isAlive = true;
    }

    void startElection(Process[] processes) {
        System.out.println("Process Id " + id + " has started the election");
        boolean higherProcessRespond = false;

        for (int i = id + 1; i < processes.length; i++) {
            if (processes[i].isAlive) {
                System.out.println("Process " + id + " -> Process " + processes[i].id + " Are you alive?");
                higherProcessRespond = true;
                processes[i].startElection(processes);
                return;
            }
        }

        if (!higherProcessRespond) {
            coordinatorId = id;
            System.out.println("Process " + id + " becomes the new coordinator.");
        }
    }
}
