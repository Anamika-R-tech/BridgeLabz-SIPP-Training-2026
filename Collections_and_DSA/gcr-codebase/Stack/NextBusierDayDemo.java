import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextBusierDayDemo {

    public static int[] nextBusierDay(int[] visitors) {
        if (visitors == null) {
            return new int[0];
        }

        int n = visitors.length;

        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        // Stores indices whose next greater value
        // has not yet been found.
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currentIndex = 0;
             currentIndex < n;
             currentIndex++) {

            while (!stack.isEmpty() &&
                   visitors[currentIndex] >
                   visitors[stack.peek()]) {

                int previousIndex = stack.pop();

                answer[previousIndex] =
                    visitors[currentIndex];
            }

            stack.push(currentIndex);
        }

        return answer;
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] visitors = {
            100, 120, 90, 110, 150, 80
        };

        System.out.println("Daily visitor counts:");
        printArray(visitors);

        int[] result = nextBusierDay(visitors);

        System.out.println("Next greater visitor count:");
        printArray(result);
    }
}