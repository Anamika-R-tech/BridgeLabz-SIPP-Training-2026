import java.util.*;

public class VendingMachineChange {

    public static List<List<Integer>> makeChange(
            int[] coins,
            int target) {

        Arrays.sort(coins);

        List<List<Integer>> result = new ArrayList<>();

        backtrack(
                coins,
                target,
                0,
                0,
                new ArrayList<>(),
                result
        );

        return result;
    }

    private static void backtrack(
            int[] coins,
            int target,
            int start,
            int currentSum,
            List<Integer> path,
            List<List<Integer>> result) {

        if (currentSum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < coins.length; i++) {

            if (currentSum + coins[i] > target) {
                break;
            }

            path.add(coins[i]);

            // Use i again because the same coin can be reused
            backtrack(
                    coins,
                    target,
                    i,
                    currentSum + coins[i],
                    path,
                    result
            );

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target = 5;

        List<List<Integer>> combinations =
                makeChange(coins, target);

        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}