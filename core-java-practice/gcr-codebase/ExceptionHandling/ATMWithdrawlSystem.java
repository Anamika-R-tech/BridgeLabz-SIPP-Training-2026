import java.util.Scanner;

public class ATMWithdrawlSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the amount to withdraw: ");

        double amount = sc.nextDouble();

        double balance = 5000;

        try {

            if(amount > balance) {
                throw new Exception("Insufficient Balance");
            }

            balance = balance - amount;

            System.out.println("Remaining balance: " + balance);

        } catch(Exception e) {

            System.out.println(e.getMessage());
        }
    }
}