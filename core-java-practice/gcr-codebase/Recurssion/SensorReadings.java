public class SensorReadings {

    public static boolean isIncreasing(int[] arr, int index) {

        // Base case
        if (index == arr.length - 1) {
            return true;
        }

        // If current >= next → false
        if (arr[index] >= arr[index + 1]) {
            return false;
        }

        // Recursive call
        return isIncreasing(arr, index + 1);
    }

    public static void main(String[] args) {

        int[] arr1 = {12, 15, 18, 22, 30};
        int[] arr2 = {12, 15, 14, 22};

        System.out.println(isIncreasing(arr1, 0));
        System.out.println(isIncreasing(arr2, 0));
    }
}