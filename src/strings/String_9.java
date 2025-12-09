package strings;

public class String_9 {

    public static void main(String[] args) {

        String str = "Hello World";

        // substring(start, end)
        // start = inclusive (includes index 0 → 'H')
        // end = exclusive (does NOT include index 5 → space)
        System.out.println(str.substring(0, 5)); // Output: Hello
    }
}
