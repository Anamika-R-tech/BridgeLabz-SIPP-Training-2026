import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(
            String[] strings
    ) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strings) {
            char[] characters = word.toCharArray();
            Arrays.sort(characters);

            String key = new String(characters);

            groups.computeIfAbsent(
                    key,
                    value -> new ArrayList<>()
            ).add(word);
        }

        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        String[] words = {
                "eat", "tea", "tan",
                "ate", "nat", "bat"
        };

        System.out.println(groupAnagrams(words));
    }
}