import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DailyExpenseLogger {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // true = append mode
            FileWriter fw = new FileWriter("expenses.txt", true);

            System.out.print("Enter expense category: ");
            String category = sc.nextLine();

            System.out.print("Enter amount: ");
            int amount = sc.nextInt();

            fw.write(category + " - " + amount);
            fw.write("\n");

            fw.close();

            System.out.println("Expense saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while writing file.");
        }

        sc.close();
    }
}