public class UsernameValidator {

    public static boolean isValid(String s, int index) {

        // Base case
        if (index == s.length()) {
            return true;
        }

        char ch = s.charAt(index);

        // Check lowercase letter
        if (ch < 'a' || ch > 'z') {
            return false;
        }

        return isValid(s, index + 1);
    }

    public static void main(String[] args) {

        System.out.println(isValid("abcdxyz", 0));
        System.out.println(isValid("abcD123", 0));
    }
}