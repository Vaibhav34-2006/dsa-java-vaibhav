package arrays;
import java.util.*;

public class Array_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int marks[] = new int[100];

        System.out.println(marks.length);

        marks[0] = sc.nextInt();   // Phy
        marks[1] = sc.nextInt();   // Chem
        marks[2] = sc.nextInt();   // Math
        
        System.out.println("Phy : " + marks[0]);
        System.out.println("Chem: " + marks[1]);
        System.out.println("Math: " + marks[2]);
        
        // updating marks
        marks[2] = 100;
        System.out.println("Math (updated): " + marks[2]);

        // correct average
        int average = (marks[0] + marks[1] + marks[2]) / 3;
        System.out.println("Average = " + average);
    }
}
