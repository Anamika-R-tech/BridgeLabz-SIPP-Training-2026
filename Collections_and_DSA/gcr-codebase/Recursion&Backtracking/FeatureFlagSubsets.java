import java.util.*;

public class FeatureFlagSubsets {

    public static List<List<String>> generateFlagCombinations(String[] flags) {
        List<List<String>> result = new ArrayList<>();

        backtrack(flags, 0, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(
            String[] flags,
            int index,
            List<String> current,
            List<List<String>> result) {

        if (index == flags.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Enable the current flag
        current.add(flags[index]);
        backtrack(flags, index + 1, current, result);

        // Undo the choice
        current.remove(current.size() - 1);

        // Choice 2: Disable the current flag
        backtrack(flags, index + 1, current, result);
    }

    public static void main(String[] args) {
        String[] flags = {
                "Dark Mode",
                "New Checkout",
                "Beta Search"
        };

        List<List<String>> combinations =
                generateFlagCombinations(flags);

        for (List<String> combination : combinations) {
            System.out.println(combination);
        }
    }
}