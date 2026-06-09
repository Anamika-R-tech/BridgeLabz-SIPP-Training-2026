import java.util.*;
public class findDistance {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int feet = sc.nextInt();
        double yard = feet/3;
        double miles = yard/1760;

        System.out.println("The distance in yard is "+ yard+ " and miles is "+miles);
        
    }
}