package strings;

public class String_10 {

    public static void main(String[] args) {

        String fruits[] = {"apple", "mango", "banana"};

        String largest = fruits[0]; // assume first fruit is largest

        // Loop through the array starting from index 1
        for (int i = 1; i < fruits.length; i++) {

            // compareTo() returns:
            // > 0 if largest > fruits[i]
            // < 0 if largest < fruits[i]
            // = 0 if equal
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i]; // update largest
            }
        }

        System.out.println(largest); // prints mango
    }
}
