import java.util.*;
public class areaOfTriangle {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int height = sc.nextInt();

        double areaCM = (base*height)/2;
        double areaInch = (areaCM/2.54);

        System.out.println("The area in cm is "+areaCM+" and in inch is "+areaInch);

    }
}