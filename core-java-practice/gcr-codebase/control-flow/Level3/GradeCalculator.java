import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Physics Marks: ");
        int physics = sc.nextInt();

        System.out.print("Enter Chemistry Marks: ");
        int chemistry = sc.nextInt();

        System.out.print("Enter Maths Marks: ");
        int maths = sc.nextInt();

        double percentage = (physics + chemistry + maths) / 3.0;

        System.out.println("Percentage = " + percentage);

        if (percentage >= 90) {
            System.out.println("Grade: A+");
            System.out.println("Remarks: Excellent");
        } else if (percentage >= 75) {
            System.out.println("Grade: A");
            System.out.println("Remarks: Very Good");
        } else if (percentage >= 60) {
            System.out.println("Grade: B");
            System.out.println("Remarks: Good");
        } else if (percentage >= 40) {
            System.out.println("Grade: C");
            System.out.println("Remarks: Average");
        } else {
            System.out.println("Grade: F");
            System.out.println("Remarks: Fail");
        }
    }
}