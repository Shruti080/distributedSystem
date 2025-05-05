import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MathServer {
    public static void main(String[] args) {
        try {
            CalculatorImpl obj = new CalculatorImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalcService", obj);
            System.out.println("Math Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
