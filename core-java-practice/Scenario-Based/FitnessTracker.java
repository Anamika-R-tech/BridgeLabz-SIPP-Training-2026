// Maya, a fitness coach, wants to record the BMI of her clients.
// ●              Ask for height and weight.
// ●              Use formula BMI = weight / (height * height)
// ●              Print category using if-else: Underweight, Normal, Overweight.
 
// Use clear variable names and comments to maintain code hygiene.

import java.util.Scanner;
public class FitnessTracker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Weight (kg): ");
        double weight = sc.nextDouble();

        System.out.print("Enter Height (cm): ");
        double heightCm = sc.nextDouble();

        double heightMeter = heightCm / 100;

        double bmi = weight / (heightMeter * heightMeter);

        System.out.println("BMI = " + bmi);

        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal Weight");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }

        sc.close();
    }
}