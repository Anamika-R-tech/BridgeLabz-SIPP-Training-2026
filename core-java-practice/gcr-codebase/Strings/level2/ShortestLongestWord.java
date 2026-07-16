import java.util.Scanner;

public class ShortestLongestWord {

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

            data[i][1] = String.valueOf(findLength(words[i]));
        }

        return data;
    }

    public static int[] shortestLongest(String[][] data) {

        int shortest = Integer.parseInt(data[0][1]);
        int longest = Integer.parseInt(data[0][1]);

        int shortIndex = 0;
        int longIndex = 0;

        for (int i = 1; i < data.length; i++) {

            int length = Integer.parseInt(data[i][1]);

            if (length < shortest) {

                shortest = length;
                shortIndex = i;
            }

            if (length > longest) {

                longest = length;
                longIndex = i;
            }
        }

        return new int[]{shortIndex, longIndex};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text");
        String text = sc.nextLine();

        String[] words = splitText(text);

        String[][] data = getWordLength(words);

        int[] indexes = shortestLongest(data);

        System.out.println("Shortest Word = " +
                data[indexes[0]][0]);

        System.out.println("Longest Word = " +
                data[indexes[1]][0]);
    }
}