// Ravi runs a café. Each customer orders different coffee types with quantities. Write a program that:
// ●              Asks for coffee type (switch)
// ●              Calculates total bill (price * quantity)
// ●              Adds GST using arithmetic operators
 
// Use while to continue for the next customer and break when "exit" is typed.

import java.util.*;
public class CoffeeChronicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String coffeeType;
        double price = 0.0;
        double totalBill = 0.0;
        double gstRate = 0.18; // 18% GST

        while (true) {
            System.out.print("Enter coffee type (or type 'exit' to finish): ");
            coffeeType = sc.nextLine();

            if (coffeeType.equalsIgnoreCase("exit")) {
                break;
            }

            switch (coffeeType.toLowerCase()) {
                case "espresso":
                    price = 2.50;
                    break;
                case "latte":
                    price = 3.50;
                    break;
                case "cappuccino":
                    price = 3.00;
                    break;
                case "americano":
                    price = 2.00;
                    break;
                default:
                    System.out.println("Invalid coffee type. Please try again.");
                    continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            totalBill += price * quantity;
        }

        double gstAmount = totalBill * gstRate;
        double finalAmount = totalBill + gstAmount;

        System.out.printf("Total Bill: $%.2f\n", totalBill);
        System.out.printf("GST (18%%): $%.2f\n", gstAmount);
        System.out.printf("Final Amount: $%.2f\n", finalAmount);

        sc.close();
    }
}