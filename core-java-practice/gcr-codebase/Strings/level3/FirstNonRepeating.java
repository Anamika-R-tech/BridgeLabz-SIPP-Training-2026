import java.util.Scanner;

public class FirstNonRepeating {

    public static char firstNonRepeating(String text) {

        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            frequency[ch]++;
        }

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text");
        String text = sc.nextLine();

        char result = firstNonRepeating(text);

        if (result != '0') {
            System.out.println("First Non-Repeating Character = " + result);
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }
}