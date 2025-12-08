package arrays;
import java.util.*;

public class Array_16 {

    // Function to search an element in the matrix
    public static boolean search(int matrix[][], int key) {

        for (int i = 0; i < matrix.length; i++) {           
            for (int j = 0; j < matrix[0].length; j++) {  

                // Correct way: matrix[i][j]
                if (matrix[i][j] == key) {
                    System.out.println("Found at cell (" + i + ", " + j + ")");
                    return true;
                }
            }
        }

        System.out.println("Not Found");
        return false;
    }


    public static void main(String[] args) {

        int matrix[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);

        // Input values
        for (int i = 0; i < matrix.length; i++) {           
            for (int j = 0; j < matrix[0].length; j++) {    
                matrix[i][j] = sc.nextInt();                
            }
        }

        // Print matrix
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {           
            for (int j = 0; j < matrix[0].length; j++) {    
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Ask user key
        System.out.print("Enter number to search: ");
        int key = sc.nextInt();

        // Call search function
        search(matrix, key);
    }

}
