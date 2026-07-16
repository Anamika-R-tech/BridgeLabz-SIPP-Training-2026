import java.util.*;

public class EventEntryVerificationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> participants = new HashSet<>();

        while (true) {
            System.out.println("\n1. Register Participant");
            System.out.println("2. Display Participants");
            System.out.println("3. Show Total Attendees");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter email ID: ");
                    String email = sc.nextLine();

                    if (participants.add(email)) {
                        System.out.println("Registration successful.");
                    } else {
                        System.out.println("Duplicate registration rejected.");
                    }
                    break;

                case 2:
                    System.out.println("Unique Registered Participants:");
                    for (String p : participants) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.println("Total eligible attendees: " + participants.size());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}