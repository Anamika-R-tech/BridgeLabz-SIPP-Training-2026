import java.util.HashMap;
import java.util.Map;
public class findTriplets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 9;
        boolean result = hasTripletWithSum(arr, target);
        System.out.println("Triplet with sum " + target + " exists: " + result);
    }

    public static boolean hasTripletWithSum(int[] arr, int target) {
        for (int i = 0; i < arr.length - 2; i++) {
            int currentTarget = target - arr[i];
            if (hasPairWithSum(arr, i + 1, currentTarget)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasPairWithSum(int[] arr, int startIndex, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = startIndex; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return true; 
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return false; 
    }
}