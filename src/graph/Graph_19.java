package graph;

import java.util.*;

public class Graph_19 {

    // ---------- EDGE CLASS ----------
    // Represents an edge in the graph
    static class Edge implements Comparable<Edge> {
        int src;   // source vertex
        int dest;  // destination vertex
        int wt;    // weight of edge

        // Constructor
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        // Used for sorting edges by weight (ascending)
        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    // ---------- CREATE GRAPH ----------
    // Adds all edges to edge list
    static void createGraph(ArrayList<Edge> edges) {

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    // ---------- DSU VARIABLES ----------
    static int n = 4;              // number of vertices
    static int par[] = new int[n]; // parent array
    static int rank[] = new int[n];// rank array

    // ---------- INITIALIZE DSU ----------
    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i; // every node is its own parent initially
        }
    }

    // ---------- FIND FUNCTION ----------
    // Finds parent with path compression
    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    // ---------- UNION FUNCTION ----------
    // Union by rank
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

    // ---------- KRUSKAL'S MST ----------
    public static void kruskalsMST(ArrayList<Edge> edges, int V) {

        // Initialize DSU
        init();

        // Sort edges by weight
        Collections.sort(edges);

        int mstCost = 0; // total cost of MST
        int count = 0;   // number of edges added to MST

        // Process edges until MST has V-1 edges
        for (int i = 0; count < V - 1; i++) {

            Edge e = edges.get(i);
            // e contains (src, dest, wt)

            int parA = find(e.src);   // parent of source
            int parB = find(e.dest);  // parent of destination

            // If adding edge doesn't form cycle
            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }

        // Print MST cost
        System.out.println(mstCost);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();

        createGraph(edges);
        kruskalsMST(edges, V);
    }
}
