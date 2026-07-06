import java.util.*;

public class SelectionSortExamScores {
    public static void main(String[] args) {

        int[] scores = {88, 45, 72, 99, 61};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(scores));

        // Selection Sort
        for (int i = 0; i < scores.length - 1; i++) {

            int minIndex = i;

            // Find minimum element
            for (int j = i + 1; j < scores.length; j++) {

                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap
            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(scores));
    }
}