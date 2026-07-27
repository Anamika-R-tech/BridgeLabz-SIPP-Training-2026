import java.util.*;

public class OnCallPermutations {

    public static List<List<String>> generateSchedules(
            String[] engineers) {

        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[engineers.length];

        backtrack(
                engineers,
                used,
                new ArrayList<>(),
                result
        );

        return result;
    }

    private static void backtrack(
            String[] engineers,
            boolean[] used,
            List<String> currentSchedule,
            List<List<String>> result) {

        if (currentSchedule.size() == engineers.length) {
            result.add(new ArrayList<>(currentSchedule));
            return;
        }

        for (int i = 0; i < engineers.length; i++) {

            if (used[i]) {
                continue;
            }

            used[i] = true;
            currentSchedule.add(engineers[i]);

            backtrack(
                    engineers,
                    used,
                    currentSchedule,
                    result
            );

            currentSchedule.remove(currentSchedule.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String[] engineers = {"Aman", "Riya", "Karan"};

        List<List<String>> schedules =
                generateSchedules(engineers);

        for (List<String> schedule : schedules) {
            System.out.println(schedule);
        }
    }
}