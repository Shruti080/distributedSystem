import java.util.*;

public class TokenRing{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no of nodes you want in ring: ");
        int n = sc.nextInt();

        System.out.println("Ring formed as below: ");
        for(int i=0; i<n; i++){
            System.out.print(i+ " ");
        }
        System.out.println("0");

        int choice = 0;

        do{
            System.out.print("Enter sender node: ");
            int sender = sc.nextInt();

            System.out.print("Enter receiver node: ");
            int receiver = sc.nextInt();

            System.out.print("Enter data to pass: ");
            int data = sc.nextInt();

            int token = 0;
            System.out.println("Token passing: ");

            for(int i=token; i<sender; i++){
                System.out.print(" "+ i + "->");
            }
            System.out.println(" "+sender);
            System.out.println("Sender: "+sender+" sending data: "+data);

            for(int i=sender; i!=receiver; i++){
                System.out.println("Data: "+data+" forwarder by: "+i);
            }
            System.out.println("Receiver: "+receiver+" received a data: "+data);

            token = sender;

            System.out.println("Do you want to sende data again? if yes press 1 if no press 0");
            choice = sc.nextInt();


        }while(choice == 1);
    }
}