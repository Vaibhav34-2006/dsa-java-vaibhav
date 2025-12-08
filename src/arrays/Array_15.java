package arrays;
import java.util.*;

public class Array_15 {

    public static void main(String[] args) {

        // Create a 3x3 matrix
        int matrix[][] = new int[3][3];

        Scanner sc = new Scanner(System.in);

        // Input values in the matrix
        for (int i = 0; i < matrix.length; i++) {           
            for (int j = 0; j < matrix[0].length; j++) {    
                matrix[i][j] = sc.nextInt();                
            }
        }

        // Print matrix in proper grid (row-column) format
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {           
            for (int j = 0; j < matrix[0].length; j++) {    
                System.out.print(matrix[i][j] + " ");       // Print in same line
            }
            System.out.println();   // Move to next row
        }

    }

}
