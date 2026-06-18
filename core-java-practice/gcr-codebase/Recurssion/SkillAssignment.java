import java.util.*;

public class SkillAssignment {

    public static void findTeams(int[] arr,
                                 int target,
                                 int index,
                                 List<Integer> current,
                                 int sum) {

        // Found valid team
        if (sum == target) {
            System.out.println(current);
            return;
        }

        // Out of bounds or exceeded target
        if (index == arr.length || sum > target) {
            return;
        }

        // Include current element
        current.add(arr[index]);

        findTeams(arr,
                  target,
                  index + 1,
                  current,
                  sum + arr[index]);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude current element
        findTeams(arr,
                  target,
                  index + 1,
                  current,
                  sum);
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 7};
        int target = 10;

        findTeams(arr,
                  target,
                  0,
                  new ArrayList<>(),
                  0);
    }
}