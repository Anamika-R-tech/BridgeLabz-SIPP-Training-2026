import java.util.*;

public class SmartParkingSlotManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> vehicles = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Vehicle Enter");
            System.out.println("2. Vehicle Exit");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Display Parked Vehicles");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle number: ");
                    String vehicleNo = sc.nextLine();

                    if (vehicles.contains(vehicleNo)) {
                        System.out.println("Vehicle already parked.");
                    } else {
                        vehicles.add(vehicleNo);
                        System.out.println("Vehicle parked successfully.");
                    }
                    break;

                case 2:
                    System.out.print("Enter vehicle number to exit: ");
                    String exitNo = sc.nextLine();

                    if (vehicles.remove(exitNo)) {
                        System.out.println("Vehicle removed successfully.");
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter vehicle number to search: ");
                    String searchNo = sc.nextLine();

                    if (vehicles.contains(searchNo)) {
                        System.out.println("Vehicle is currently parked.");
                    } else {
                        System.out.println("Vehicle is not parked.");
                    }
                    break;

                case 4:
                    System.out.println("Parked Vehicles:");
                    for (String v : vehicles) {
                        System.out.println(v);
                    }
                    System.out.println("Total occupied slots: " + vehicles.size());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}