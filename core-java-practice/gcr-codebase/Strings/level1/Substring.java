import java.util.Scanner;

public class Substring {

    public static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    public static boolean compareStrings(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {

            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text");
        String text = sc.next();

        System.out.println("Enter start index");
        int start = sc.nextInt();

        System.out.println("Enter end index");
        int end = sc.nextInt();

        String userSubstring = createSubstring(text, start, end);

        String builtInSubstring = text.substring(start, end);

        boolean result = compareStrings(userSubstring, builtInSubstring);

        System.out.println("User Substring = " + userSubstring);
        System.out.println("Built-in Substring = " + builtInSubstring);
        System.out.println("Both are same = " + result);
    }
}