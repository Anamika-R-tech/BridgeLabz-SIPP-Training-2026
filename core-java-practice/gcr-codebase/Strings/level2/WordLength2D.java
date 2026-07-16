import java.util.Scanner;

public class WordLength2D {

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

    public static String[] splitText(String text) {

        int length = findLength(text);

        int wordCount = 1;

        for (int i = 0; i < length; i++) {

            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];

        int start = 0;
        int index = 0;

        for (int i = 0; i <= length; i++) {

            if (i == length || text.charAt(i) == ' ') {

                String word = "";

                for (int j = start; j < i; j++) {
                    word = word + text.charAt(j);
                }

                words[index] = word;

                index++;

                start = i + 1;
            }
        }

        return words;
    }

    public static String[][] getWordLength(String[] words) {

        String[][] data = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {

            data[i][0] = words[i];

            int length = findLength(words[i]);

            data[i][1] = String.valueOf(length);
        }

        return data;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text");
        String text = sc.nextLine();

        String[] words = splitText(text);

        String[][] result = getWordLength(words);

        System.out.println("\nWord\tLength");

        for (int i = 0; i < result.length; i++) {

            System.out.println(result[i][0] + "\t" +
                    Integer.parseInt(result[i][1]));
        }
    }
}