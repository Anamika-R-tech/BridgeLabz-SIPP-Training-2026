import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBracketDemo {

    public static boolean isValidConfig(String config) {
        if (config == null) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < config.length(); i++) {
            char current = config.charAt(i);

            if (current == '(' ||
                current == '[' ||
                current == '{') {

                stack.push(current);
            } else {
                // A closing bracket cannot appear when the stack is empty.
                if (stack.isEmpty()) {
                    return false;
                }

                char openingBracket = stack.pop();

                if (!isMatchingPair(openingBracket, current)) {
                    return false;
                }
            }
        }

        // Stack must be empty because every opening bracket
        // must have a closing bracket.
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(
        char opening,
        char closing
    ) {
        return (opening == '(' && closing == ')') ||
               (opening == '[' && closing == ']') ||
               (opening == '{' && closing == '}');
    }

    public static void main(String[] args) {
        String config1 = "{[()]}";
        String config2 = "{[(])}";
        String config3 = "((()))";
        String config4 = "([)";
        String config5 = "";
        String config6 = "(((";

        System.out.println(
            config1 + " is valid: " + isValidConfig(config1)
        );

        System.out.println(
            config2 + " is valid: " + isValidConfig(config2)
        );

        System.out.println(
            config3 + " is valid: " + isValidConfig(config3)
        );

        System.out.println(
            config4 + " is valid: " + isValidConfig(config4)
        );

        System.out.println(
            "Empty string is valid: " + isValidConfig(config5)
        );

        System.out.println(
            config6 + " is valid: " + isValidConfig(config6)
        );
    }
}
