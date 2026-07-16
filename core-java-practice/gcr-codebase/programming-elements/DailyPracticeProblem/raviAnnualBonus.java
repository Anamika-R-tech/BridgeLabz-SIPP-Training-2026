/* Ravi just joined a coding guild. Store his name, age, rank, salary, and
membership fee (float) using correct data types. Compute his
annual bonus (12% of salary), cast it to int, and print a formatted
welcome card.*/

import java.util.*;

public class raviAnnualBonus {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int age = sc.nextInt();
        int rank = sc.nextInt();
        int salary = sc.nextInt();
        float membershipFee = sc.nextFloat();

        int annualBonus =(12*salary)/100;
        System.out.print(name+", Your annual Bonus is " +annualBonus+".");

    }
}
