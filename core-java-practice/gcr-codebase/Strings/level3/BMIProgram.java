import java.util.Scanner;

public class BMIProgram {

    public static String[] calculateBMI(double weight, double heightCm) {

        double heightMeter = heightCm / 100;

        double bmi = weight / (heightMeter * heightMeter);

        String status;

        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{
                String.valueOf(bmi),
                status
        };
    }

    public static String[][] getBMIReport(double[][] data) {

        String[][] result = new String[10][4];

        for (int i = 0; i < 10; i++) {

            double weight = data[i][0];
            double height = data[i][1];

            String[] bmiData = calculateBMI(weight, height);

            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = bmiData[0];
            result[i][3] = bmiData[1];
        }

        return result;
    }

    public static void display(String[][] result) {

        System.out.println("\nHeight\tWeight\tBMI\tStatus");

        for (int i = 0; i < result.length; i++) {

            System.out.println(
                    result[i][0] + "\t" +
                    result[i][1] + "\t" +
                    result[i][2] + "\t" +
                    result[i][3]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] personData = new double[10][2];

        for (int i = 0; i < 10; i++) {

            System.out.println("Enter weight of person " + (i + 1));
            personData[i][0] = sc.nextDouble();

            System.out.println("Enter height(cm) of person " + (i + 1));
            personData[i][1] = sc.nextDouble();
        }

        String[][] result = getBMIReport(personData);

        display(result);
    }
}