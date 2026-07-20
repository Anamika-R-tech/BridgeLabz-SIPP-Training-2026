import java.util.*;

public class MostFrequentError {

    public static int mostFrequentErrorCode(int[] codes) {
        Map<Integer, Integer> frequency = new HashMap<>();

        int bestCode = codes[0];
        int bestCount = 0;

        for (int code : codes) {
            int count = frequency.getOrDefault(code, 0) + 1;
            frequency.put(code, count);

            if (count > bestCount) {
                bestCount = count;
                bestCode = code;
            }
        }

        return bestCode;
    }

    public static void main(String[] args) {
        int[] codes = {404, 500, 404, 403, 404, 500};

        System.out.println(mostFrequentErrorCode(codes));
    }
}