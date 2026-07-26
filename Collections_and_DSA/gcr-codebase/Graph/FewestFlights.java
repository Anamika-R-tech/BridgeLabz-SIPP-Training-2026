import java.util.*;

public class FewestFlights {

    public static List<Integer> findShortestPath(
            Map<Integer, List<Integer>> routes,
            int origin,
            int destination) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();

        queue.offer(origin);
        visited.add(origin);
        parent.put(origin, null);

        while (!queue.isEmpty()) {
            int city = queue.poll();

            if (city == destination) {
                break;
            }

            for (int nextCity :
                    routes.getOrDefault(city, Collections.emptyList())) {

                if (!visited.contains(nextCity)) {
                    visited.add(nextCity);
                    parent.put(nextCity, city);
                    queue.offer(nextCity);
                }
            }
        }

        if (!visited.contains(destination)) {
            return Collections.emptyList();
        }

        LinkedList<Integer> path = new LinkedList<>();
        Integer current = destination;

        while (current != null) {
            path.addFirst(current);
            current = parent.get(current);
        }

        return path;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> routes = new HashMap<>();

        routes.put(0, Arrays.asList(1, 2));
        routes.put(1, Arrays.asList(0, 3));
        routes.put(2, Arrays.asList(0, 3));
        routes.put(3, Arrays.asList(1, 2, 4));
        routes.put(4, Collections.singletonList(3));

        List<Integer> path = findShortestPath(routes, 0, 4);

        System.out.println(path);
    }
}