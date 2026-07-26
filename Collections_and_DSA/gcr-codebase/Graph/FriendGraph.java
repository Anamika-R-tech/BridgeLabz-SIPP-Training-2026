import java.util.*;

public class FriendGraph {

    private final Map<Integer, Set<Integer>> friendGraph = new HashMap<>();

    public void addFriendship(int user1, int user2) {
        friendGraph
                .computeIfAbsent(user1, key -> new HashSet<>())
                .add(user2);

        friendGraph
                .computeIfAbsent(user2, key -> new HashSet<>())
                .add(user1);
    }

    public boolean isFriend(int user1, int user2) {
        return friendGraph
                .getOrDefault(user1, Collections.emptySet())
                .contains(user2);
    }

    public static void main(String[] args) {
        FriendGraph graph = new FriendGraph();

        graph.addFriendship(1, 2);
        graph.addFriendship(1, 3);
        graph.addFriendship(2, 4);

        System.out.println(graph.isFriend(1, 3)); // true
        System.out.println(graph.isFriend(1, 4)); // false
    }
}