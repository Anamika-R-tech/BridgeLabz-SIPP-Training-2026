import java.util.*;

public class BubbleSortStudentMarks {
    public static void main(String[] args) {

        int[] marks = {78, 45, 90, 62, 55};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(marks));

        // Bubble Sort
        for (int i = 0; i < marks.length - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < marks.length - i - 1; j++) {

                if (marks[j] > marks[j + 1]) {

                    // Swap
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swapping happens, array is already sorted
            if (!swapped) {
                break;
            }
        }

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(marks));
    }
}