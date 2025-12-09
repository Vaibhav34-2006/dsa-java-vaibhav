package strings;

public class String_5 {

    // Function to print each letter of a string
    public static void printsletters(String str) {

        // Loop through all characters of the string
        for (int i = 0; i < str.length(); i++) {

            // Print character at index i
            System.out.println(str.charAt(i) + "");
        }

        System.out.println(); // Blank line after printing all characters
    }

    public static void main(String[] args) {

        // Creating first name
        String firstname = "Vaibhav";

        // Creating last name
        String lastname = "Mali";

        // Joining first name + last name
        // NOTE: Adding "" doesn't add space → use " " instead
        String fullname = firstname + " " + lastname;

        // Calling function to print each character
        printsletters(fullname);
    }
}
