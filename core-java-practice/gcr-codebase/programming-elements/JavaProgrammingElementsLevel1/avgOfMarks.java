import java.util.*;
public class averageOfMarks {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int maths=sc.nextInt();
    int physics=sc.nextInt();
    int chemistry=sc.nextInt();
    double AverageOfMarks=(maths+physics+chemistry)/3;
    System.out.println("Sam’s average mark in PCM is "+AverageOfMarks);
    }
}