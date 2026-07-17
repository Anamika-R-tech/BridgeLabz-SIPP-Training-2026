import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class SlidingWindowMaximum {

    public static int[] maxThroughputWindow(int[] readings, int k) {
        if (readings == null || readings.length == 0) {
            return new int[0];
        }

        if (k <= 0 || k > readings.length) {
            throw new IllegalArgumentException("Invalid window size");
        }

        int n = readings.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices that are outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller or equal values from the back
            while (!deque.isEmpty()
                    && readings[deque.peekLast()] <= readings[i]) {
                deque.pollLast();
            }

            // Store the current index
            deque.offerLast(i);

            // Start recording answers after the first full window
            if (i >= k - 1) {
                result[i - k + 1] = readings[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] readings = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] answer = maxThroughputWindow(readings, k);

        System.out.println(Arrays.toString(answer));
    }
}