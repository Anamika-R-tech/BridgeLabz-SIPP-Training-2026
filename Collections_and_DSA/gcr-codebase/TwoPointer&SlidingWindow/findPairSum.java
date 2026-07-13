import java.util.HashMap;
import java.util.Map;
public class findPairSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 9;
        boolean result = hasPairWithSum(arr, target);
        System.out.println("Pair with sum " + target + " exists: " + result);
    }

    public static boolean hasPairWithSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                return true; 
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return false; 
    }
}