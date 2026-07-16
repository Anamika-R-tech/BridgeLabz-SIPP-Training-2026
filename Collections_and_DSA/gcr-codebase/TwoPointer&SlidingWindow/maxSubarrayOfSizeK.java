public class maxSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        int maxSum = findMaxSumSubarray(arr, k);
        System.out.println("Maximum sum of subarray of size " + k + " is: " + maxSum);
    }

    public static int findMaxSumSubarray(int[] arr, int k) {
        if (arr.length < k) {
            throw new IllegalArgumentException("Array length must be greater than or equal to k");
        }

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}