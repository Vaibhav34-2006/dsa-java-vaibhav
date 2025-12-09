package strings;

public class String_8 {

    public static void main(String[] args) {

        String s1 = "tony";                 // String literal (String Pool)
        String s2 = "tony";                 // Points to same object in Pool
        String s3 = new String("tony");     // New object in Heap

        // == compares memory address (reference)
        if (s1 == s2) {
            System.out.println("s1 == s2 : Strings are equal");
        } else {
            System.out.println("s1 == s2 : Strings are not equal");
        }

        // == compares memory address → false for s1 & s3
        if (s1 == s3) {
            System.out.println("s1 == s3 : Strings are equal");
        } else {
            System.out.println("s1 == s3 : Strings are not equal");
        }

        // equals() compares content → true because both contain "tony"
        if (s1.equals(s3)) {
            System.out.println("s1.equals(s3) : Strings are equal");
        } else {
            System.out.println("s1.equals(s3) : Strings are not equal");
        }
    }
}
