// Design a polling booth system.
// ●              Take age input.
// ●              Use if to check if eligible (>=18).
// ●              Record vote (1, 2, or 3 for candidates).
// ●              Loop for multiple voters, exit on special code.

import java.util.Scanner;
public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int candidate1Votes = 0;
        int candidate2Votes = 0;
        int candidate3Votes = 0;

        while (true) {
            System.out.print("Enter age (or -1 to exit): ");
            int age = sc.nextInt();

            if (age == -1) {
                break;
            }

            if (age < 18) {
                System.out.println("Not eligible to vote.");
                continue;
            }

            System.out.print("Enter vote (1 for Candidate A, 2 for Candidate B, 3 for Candidate C): ");
            int vote = sc.nextInt();

            switch (vote) {
                case 1:
                    candidate1Votes++;
                    break;
                case 2:
                    candidate2Votes++;
                    break;
                case 3:
                    candidate3Votes++;
                    break;
                default:
                    System.out.println("Invalid vote. Please try again.");
            }
        }

        System.out.println("Voting Results:");
        System.out.println("Candidate A: " + candidate1Votes + " votes");
        System.out.println("Candidate B: " + candidate2Votes + " votes");
        System.out.println("Candidate C: " + candidate3Votes + " votes");

        sc.close();
    }
}











