import java.util.Arrays;
import java.util.Scanner;

class SpyAgencyMessageDecoder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Secret Message: ");
        String secretMessage = sc.nextLine();

        String reversedMessage = "";
        for (int i = secretMessage.length() - 1; i >= 0; i--) {
            reversedMessage += secretMessage.charAt(i);
        }
        System.out.println("Reversed Message: " + reversedMessage);

        if (secretMessage.equalsIgnoreCase(reversedMessage)) {
            System.out.println("Message is a Palindrome");
        } else {
            System.out.println("Message is NOT a Palindrome");
        }

        int vowelCount = 0;
        int consonantCount = 0;
        String lowerCaseMessage = secretMessage.toLowerCase();

        for (int i = 0; i < lowerCaseMessage.length(); i++) {
            char ch = lowerCaseMessage.charAt(i);
            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        System.out.println("Vowels     : " + vowelCount);
        System.out.println("Consonants : " + consonantCount);

        System.out.print("\nEnter First Intercept: ");
        String firstIntercept = sc.next();
        System.out.print("Enter Second Intercept: ");
        String secondIntercept = sc.next();
        sc.nextLine(); 

        char[] firstArray = firstIntercept.toLowerCase().toCharArray();
        char[] secondArray = secondIntercept.toLowerCase().toCharArray();

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        if (Arrays.equals(firstArray, secondArray)) {
            System.out.println("Intercepts are Anagrams");
        } else {
            System.out.println("Intercepts are NOT Anagrams");
        }

        System.out.print("\nEnter Surveillance Log: ");
        String surveillanceLog = sc.next();
        char firstUniqueCharacter = '\0';

        for (int i = 0; i < surveillanceLog.length(); i++) {
            boolean repeated = false;
            for (int j = 0; j < surveillanceLog.length(); j++) {
                if (i != j && surveillanceLog.charAt(i) == surveillanceLog.charAt(j)) {
                    repeated = true;
                    break;
                }
            }

            if (!repeated) {
                firstUniqueCharacter = surveillanceLog.charAt(i);
                break;
            }
        }

        if (firstUniqueCharacter != '\0') {
            System.out.println("First Non-Repeating Character: " + firstUniqueCharacter);
        } else {
            System.out.println("No Non-Repeating Character Found");
        }

        sc.close();
    }
}