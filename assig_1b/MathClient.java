import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class MathClient {
    public static void main(String[] args) {
        try {
            // Connect to registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator stub = (Calculator) registry.lookup("CalcService");

            // Take user input
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            // Call remote method
            int result = stub.add(num1, num2);

            // Display result
            System.out.println("Sum from server: " + result);
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
