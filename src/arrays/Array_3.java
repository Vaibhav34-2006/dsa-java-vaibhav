package arrays;

public class Array_3 {

    // Method to update array and primitive value
    public static void update(int marks[], int nonchangable) {

        // Changing primitive value (will NOT affect original)
        nonchangable = 10;

        // Increasing each element of array by 1 (WILL affect original)
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static void main(String[] args) {

        // Array (objects) → passed by reference-like behavior
        int marks[] = {99, 83, 89};

        // Primitive → passed by value
        int nonchangable = 5;

        // Calling update method
        update(marks, nonchangable);

        // Prints original primitive (not changed)
        System.out.println(nonchangable);   // Output: 5

        // Printing updated array (values changed)
        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]);   // Output: 100, 84, 90
        }

        System.out.println();
    }
}
