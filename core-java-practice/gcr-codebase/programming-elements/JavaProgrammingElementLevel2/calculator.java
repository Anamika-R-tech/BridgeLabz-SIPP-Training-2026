import java.util.*;
public class calculator {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num1= sc.nextInt();
        int num2= sc.nextInt();
        int sum= num1 + num2;
        int difference = num1 - num2;
        int product = num1*num2;
        double division =  num1 / num2;
        System.out.println("The sum of "+num1 +" and "+ num2 + " is " +sum+ " difference is "+difference+" product is "+ product+ " and division is "+division );
    }
}