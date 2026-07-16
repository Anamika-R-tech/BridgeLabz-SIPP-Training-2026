import java.util.Scanner;

public class BMI2D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of persons");
        int n = sc.nextInt();

        double[][] personData = new double[n][3];

        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Enter weight");
            personData[i][0] = sc.nextDouble();

            System.out.println("Enter height");
            personData[i][1] = sc.nextDouble();
        }

        for (int i = 0; i < n; i++) {

            double weight = personData[i][0];
            double height = personData[i][1];

            personData[i][2] = weight / (height * height);

            double bmi = personData[i][2];

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        for (int i = 0; i < n; i++) {

            System.out.println("\nPerson " + (i + 1));
            System.out.println("Weight = " + personData[i][0]);
            System.out.println("Height = " + personData[i][1]);
            System.out.println("BMI = " + personData[i][2]);
            System.out.println("Status = " + weightStatus[i]);
        }
    }
}