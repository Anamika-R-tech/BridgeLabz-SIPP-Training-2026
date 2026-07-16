import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Month: ");
        int m = sc.nextInt();

        System.out.print("Enter Day: ");
        int d = sc.nextInt();

        System.out.print("Enter Year: ");
        int y = sc.nextInt();

        int y0 = y - (14 - m) / 12;

        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;

        int m0 = m + 12 * ((14 - m) / 12) - 2;

        int day = (d + x + (31 * m0) / 12) % 7;

        System.out.println("Day of Week = " + day);

        System.out.println("0 = Sunday");
        System.out.println("1 = Monday");
        System.out.println("2 = Tuesday");
        System.out.println("3 = Wednesday");
        System.out.println("4 = Thursday");
        System.out.println("5 = Friday");
        System.out.println("6 = Saturday");
    }
}