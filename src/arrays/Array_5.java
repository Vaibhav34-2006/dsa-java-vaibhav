package arrays;

public class Array_5 {

    public static int getlargest(int numbers[]) {

        int largest = Integer.MIN_VALUE;   // smallest possible integer
        int smallest = Integer.MAX_VALUE;  // largest possible integer

        for (int i = 0; i < numbers.length; i++) {

            // check for largest
            if (largest < numbers[i]) {
                largest = numbers[i];
            }

            // check for smallest
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }

        return largest;  // returning only largest
    }

    public static void main(String[] args) {

        int numbers[] = {1, 2, 6, 3, 5};

        System.out.println(getlargest(numbers));  // prints largest number
    }
}
