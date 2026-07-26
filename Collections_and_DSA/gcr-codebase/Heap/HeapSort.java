import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, n);
        }

        // Move maximum elements to the end
        for (int end = n - 1; end > 0; end--) {
            swap(arr, 0, end);

            // Restore heap only in the unsorted section
            siftDown(arr, 0, end);
        }
    }

    private static void siftDown(int[] arr, int index, int size) {
        while (true) {
            int largest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < size && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < size && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest == index) {
                break;
            }

            swap(arr, index, largest);
            index = largest;
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}