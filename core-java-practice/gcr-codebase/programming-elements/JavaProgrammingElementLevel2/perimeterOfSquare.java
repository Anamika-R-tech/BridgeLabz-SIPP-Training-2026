import java.util.*;
public class perimeterOfSquare {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int length= sc.nextInt();
        int perimeter = length*4;
        System.out.print("The perimeter of a square is " + perimeter);
    }
}