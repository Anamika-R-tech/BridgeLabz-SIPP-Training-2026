import java.util.Arrays;

public class BuildMinHeap {

    public static void buildHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, n);
        }
    }

    private static void siftDown(int[] arr, int index, int size) {
        while (true) {
            int smallest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < size && arr[left] < arr[smallest]) {
                smallest = left;
            }

            if (right < size && arr[right] < arr[smallest]) {
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            int temp = arr[index];
            arr[index] = arr[smallest];
            arr[smallest] = temp;

            index = smallest;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 7, 1, 3};

        buildHeap(arr);

        System.out.println(Arrays.toString(arr));
    }
}