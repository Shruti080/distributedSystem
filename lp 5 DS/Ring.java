import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ring {
    static int coordinatorId = -1;

    public static void main(String[] args) throws Exception {
        // Creating Processes
        Process[] processes = new Process[5];
        for (int i = 0; i < processes.length; i++) {
            processes[i] = new Process(i);
        }

        // Assume Process 5 is the initial Coordinator.
        coordinatorId = 4;
        System.out.println("Initial Coordinator is Process " + coordinatorId);

        // Simulate failure of coordinator.
        processes[coordinatorId].isAlive = false;

        // Start election from a lower process
        int initiator = 1;
        System.out.println("Process " + initiator + " has started an election");

        List<Integer> electionList = new ArrayList<>();
        int current = initiator;

        // election token passes through all the processes in the ring
        do {
            if (processes[current].isAlive) {
                electionList.add(processes[current].id);
                System.out.println("Process " + current + " added to the election list.");
            }
            current = (current + 1) % processes.length;
        } while (current != initiator);

        // Determine the new coordinator
        coordinatorId = Collections.max(electionList);

        // Announce the new coordinator
        System.out.println("New Coordinator is Process " + coordinatorId);
        System.out.println("Announcement being sent around the ring...");

        current = initiator;
        do {
            if (processes[current].isAlive) {
                System.out.println("Process " + current + " acknowledges new coordinator: Process " + coordinatorId);
            }
            current = (current + 1) % processes.length;
        } while (current != initiator);
    }
}

class Process {
    int id;
    boolean isAlive;

    Process(int id) {
        this.id = id;
        this.isAlive = true;
    }
}
