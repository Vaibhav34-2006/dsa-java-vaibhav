package graph;

public class Graph_21 {

    // ---------- DSU VARIABLES ----------
    static int n = 7;              // total elements (0 to 6)
    static int par[] = new int[n]; // parent array
    static int rank[] = new int[n];// rank array

    // ---------- INIT FUNCTION ----------
    // Initializes parent of each node to itself
    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    // ---------- FIND FUNCTION ----------
    // Finds representative (leader) of set
    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return find(par[x]); // recursive find
    }

    // ---------- UNION FUNCTION ----------
    // Merges two sets using rank
    public static void union(int a, int b) {

        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    // ---------- DRIVER CODE ----------
    public static void main(String[] args) {

        init(); // initialize DSU

        // Perform unions
        union(1, 3);
        System.out.println(find(3)); // prints leader of 3

        union(2, 4);
        union(3, 6);
        union(1, 4);

        System.out.println(find(3)); // leader after unions
        System.out.println(find(4)); // leader after unions

        union(1, 6); // final union
    }
}
