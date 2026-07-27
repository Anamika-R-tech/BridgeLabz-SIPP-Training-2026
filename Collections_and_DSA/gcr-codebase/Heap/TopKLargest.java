import java.util.*;

public class TopKLargest {

    public static List<Integer> topKLargest(int[] arr, int k) {
        if (k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int value : arr) {
            if (minHeap.size() < k) {
                minHeap.offer(value);
            } else if (value > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(value);
            }
        }

        List<Integer> answer = new ArrayList<>(minHeap);

        // Optional: arrange answer from largest to smallest
        answer.sort(Collections.reverseOrder());

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 8, 20, 15};

        System.out.println(topKLargest(arr, 3));
    }
}