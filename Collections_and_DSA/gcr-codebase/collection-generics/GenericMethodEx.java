class Utility {
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];

        for (T element : arr) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return max;
    }
}

public class GenericMethodEx {
    public static void main(String[] args) {
        Integer[] nums = {10, 40, 20, 90, 50};
        String[] names = {"Aman", "Zoya", "Rahul"};

        System.out.println("Max number: " + Utility.findMax(nums));
        System.out.println("Max name: " + Utility.findMax(names));
    }
}