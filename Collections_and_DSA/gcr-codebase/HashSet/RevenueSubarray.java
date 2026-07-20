import java.util.*;

public class RevenueSubarray {

    public static int subarraySumEqualsK(
            int[] revenueChanges,
            int k
    ) {
        Map<Integer, Integer> prefixCount = new HashMap<>();

        prefixCount.put(0, 1);

        int runningSum = 0;
        int answer = 0;

        for (int change : revenueChanges) {
            runningSum += change;

            int requiredPrefix = runningSum - k;

            answer += prefixCount.getOrDefault(
                    requiredPrefix,
                    0
            );

            prefixCount.put(
                    runningSum,
                    prefixCount.getOrDefault(runningSum, 0) + 1
            );
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] revenue = {1, -1, 0};

        System.out.println(subarraySumEqualsK(revenue, 0));
    }
}