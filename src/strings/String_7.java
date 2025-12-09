package strings;

public class String_7 {

    // Function to find the shortest distance from origin (0,0)
    // after following the given path
    public static float getShortestPath(String path) {

        int x = 0; // horizontal movement (East +, West -)
        int y = 0; // vertical movement (North +, South -)

        // Traverse each direction in the path string
        for (int i = 0; i < path.length(); i++) {

            char dir = path.charAt(i); // current direction

            // South -> decrease y
            if (dir == 'S') {
                y--;

            // North -> increase y
            } else if (dir == 'N') {
                y++;

            // West -> decrease x
            } else if (dir == 'W') {
                x--;

            // East -> increase x
            } else if (dir == 'E') {
                x++;
            }
        }

        // x^2 and y^2
        int x2 = x * x;
        int y2 = y * y;

        // Distance formula: sqrt(x^2 + y^2)
        return (float) Math.sqrt(x2 + y2);
    }

    public static void main(String[] args) {

        String path = "WEENSNNNSEEW";

        // Call function with correct method name
        System.out.println(getShortestPath(path));
    }
}
