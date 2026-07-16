import java.util.Scanner;

public class FrequencyUsingUnique {

    public static char[] uniqueCharacters(String text) {

        char[] temp = new char[text.length()];

        int index = 0;

        for (int i = 0; i < text.length(); i++) {

            boolean isUnique = true;

            for (int j = 0; j < i; j++) {

                if (text.charAt(i) == text.charAt(j)) {

                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {

                temp[index] = text.charAt(i);

                index++;
            }
        }

        char[] result = new char[index];

        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static String[][] frequency(String text) {

        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            frequency[ch]++;
        }

        char[] unique = uniqueCharacters(text);

        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {

            result[i][0] = String.valueOf(unique[i]);

            result[i][1] =
                    String.valueOf(frequency[unique[i]]);
        }

        return result;
    }

    public static void display(String[][] result) {

        System.out.println("\nCharacter\tFrequency");

        for (int i = 0; i < result.length; i++) {

            System.out.println(
                    result[i][0] + "\t\t" +
                    result[i][1]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text");
        String text = sc.nextLine();

        String[][] result = frequency(text);

        display(result);
    }
}