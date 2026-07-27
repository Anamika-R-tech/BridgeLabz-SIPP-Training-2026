import java.util.*;

public class NetworkSegments {

    public static int countComponents(
            Map<Integer, List<Integer>> network,
            int numberOfServers) {

        Set<Integer> visited = new HashSet<>();
        int components = 0;

        for (int server = 0; server < numberOfServers; server++) {
            if (!visited.contains(server)) {
                components++;
                dfs(network, server, visited);
            }
        }

        return components;
    }

    private static void dfs(
            Map<Integer, List<Integer>> network,
            int server,
            Set<Integer> visited) {

        visited.add(server);

        for (int neighbor :
                network.getOrDefault(server, Collections.emptyList())) {

            if (!visited.contains(neighbor)) {
                dfs(network, neighbor, visited);
            }
        }
    }

    public static boolean isFullyConnected(
            Map<Integer, List<Integer>> network,
            int numberOfServers) {

        return countComponents(network, numberOfServers) == 1;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> network = new HashMap<>();

        network.put(0, Collections.singletonList(1));
        network.put(1, Collections.singletonList(0));

        network.put(2, Collections.singletonList(3));
        network.put(3, Collections.singletonList(2));

        int components = countComponents(network, 4);

        System.out.println("Segments: " + components);
        System.out.println(
                "Fully connected: " + isFullyConnected(network, 4)
        );
    }
}