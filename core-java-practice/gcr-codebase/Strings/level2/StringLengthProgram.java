import java.util.Scanner;

public class StringLengthProgram {

    public static int findLength(String text) {

        int count = 0;

        try {

            while (true) {

                text.charAt(count);
                count++;
            }

        } catch (Exception e) {

        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string");
        String text = sc.next();

        int userLength = findLength(text);

        int builtInLength = text.length();

        System.out.println("Length using user-defined method = " + userLength);
        System.out.println("Length using built-in method = " + builtInLength);
    }
}