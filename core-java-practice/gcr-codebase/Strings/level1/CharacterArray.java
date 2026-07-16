import java.util.Scanner;

public class CharacterArray {

    public static char[] getCharacters(String text) {

        char[] arr = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i);
        }

        return arr;
    }

    public static boolean compareArrays(char[] arr1, char[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {

            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text");
        String text = sc.next();

        char[] userArray = getCharacters(text);

        char[] builtInArray = text.toCharArray();

        boolean result = compareArrays(userArray, builtInArray);

        System.out.println("Arrays are same = " + result);
    }
}