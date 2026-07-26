import java.util.*;

public class AllDeliveryRoutes {

    public static List<List<Integer>> findAllRoutes(
            Map<Integer, List<Integer>> roads,
            int source,
            int destination) {

        List<List<Integer>> allRoutes = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        dfs(
                roads,
                source,
                destination,
                currentPath,
                visited,
                allRoutes
        );

        return allRoutes;
    }

    private static void dfs(
            Map<Integer, List<Integer>> roads,
            int current,
            int destination,
            List<Integer> currentPath,
            Set<Integer> visited,
            List<List<Integer>> allRoutes) {

        currentPath.add(current);
        visited.add(current);

        if (current == destination) {
            allRoutes.add(new ArrayList<>(currentPath));
        } else {
            for (int next :
                    roads.getOrDefault(current, Collections.emptyList())) {

                if (!visited.contains(next)) {
                    dfs(
                            roads,
                            next,
                            destination,
                            currentPath,
                            visited,
                            allRoutes
                    );
                }
            }
        }

        // Backtracking
        currentPath.remove(currentPath.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> roads = new HashMap<>();

        roads.put(0, Arrays.asList(1, 2));
        roads.put(1, Arrays.asList(2, 3));
        roads.put(2, Collections.singletonList(3));
        roads.put(3, Collections.emptyList());

        List<List<Integer>> routes = findAllRoutes(roads, 0, 3);

        for (List<Integer> route : routes) {
            System.out.println(route);
        }
    }
}