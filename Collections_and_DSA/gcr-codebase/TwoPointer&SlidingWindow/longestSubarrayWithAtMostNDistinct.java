import java.util.HashMap;
import java.util.Map;
public class longestSubarrayWithAtMostNDistinct {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int n = 2;
        int result = longestSubarray(arr, n);
        System.out.println("Length of the longest subarray with at most " + n + " distinct integers: " + result);
    }

    public static int longestSubarray(int[] arr, int n) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;

        while (right < arr.length) {
            countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);

            while (countMap.size() > n) {
                countMap.put(arr[left], countMap.get(arr[left]) - 1);
                if (countMap.get(arr[left]) == 0) {
                    countMap.remove(arr[left]);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}   
