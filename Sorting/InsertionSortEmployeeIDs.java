import java.util.*;

public class InsertionSortEmployeeIDs {
    public static void main(String[] args) {

        int[] employeeIds = {104, 101, 109, 102, 107};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(employeeIds));

        // Insertion Sort
        for (int i = 1; i < employeeIds.length; i++) {

            int current = employeeIds[i];
            int j = i - 1;

            // Shift elements greater than current
            while (j >= 0 && employeeIds[j] > current) {

                employeeIds[j + 1] = employeeIds[j];
                j--;
            }

            // Insert current element
            employeeIds[j + 1] = current;
        }

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(employeeIds));
    }
}