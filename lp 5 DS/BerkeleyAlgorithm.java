import java.util.*;

public class BerkeleyAlgorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Set server time
        System.out.print("Enter Server Time: ");
        int serverTime = sc.nextInt();

        // Get number of clients
        System.out.print("Enter number of clients: ");
        int n = sc.nextInt();

        int[] clientTimes = new int[n];
        int[] timeDiffs = new int[n];
        int totalDiff = 0;

        // Read client times
        for (int i = 0; i < n; i++) {
            System.out.print("Enter time for Client " + (i + 1) + ": ");
            clientTimes[i] = sc.nextInt();
            timeDiffs[i] = clientTimes[i] - serverTime;
            totalDiff += timeDiffs[i];
        }

        // Include server's own time difference (which is 0)
        int avgDiff = totalDiff / (n + 1);

        System.out.println("\nAverage Time Difference (including server): " + avgDiff);

        // Adjust server time
        serverTime += avgDiff;
        System.out.println("Updated Server Time: " + serverTime);

        // Adjust client times
        System.out.println("\nAdjusted Client Times:");
        for (int i = 0; i < n; i++) {
            int adjustment = avgDiff - timeDiffs[i];
            clientTimes[i] += adjustment;
            System.out.println("Client " + (i + 1) + " new time: " + clientTimes[i] + " (adjusted by " + adjustment + ")");
        }

        sc.close();
    }
}
