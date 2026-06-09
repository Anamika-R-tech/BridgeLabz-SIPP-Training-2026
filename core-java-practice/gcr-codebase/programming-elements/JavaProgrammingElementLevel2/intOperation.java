import java.util.*;

public class intOperation {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int op1 =  a + b *c;
        int op2 = a * b + c;
        int op3 = c + a / b;
        int op4 = a % b + c;

        System.out.print("The value of op 1 is "+op1+" op 2 is "+op2+ " op3 is "+ op3+ " and op4 is "+op4+".");
    }
}
