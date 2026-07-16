import java.util.Scanner;

public class SmallestNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter Second Number: ");
        int number2 = sc.nextInt();

        System.out.print("Enter Third Number: ");
        int number3 = sc.nextInt();

        boolean result = (number1 < number2 && number1 < number3);

        System.out.println("Is the first number the smallest? " + result);
    }
}