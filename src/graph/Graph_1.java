package graph;

import java.util.ArrayList;

public class Graph_1 {

    // ---------- EDGE CLASS ----------
    // This class represents an edge in the graph
    static class Edge {
        int src;   // source vertex
        int dest;  // destination vertex
        int wt;    // weight of edge

        // Constructor
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void main(String[] args) {

        // Number of vertices
        int V = 5;

        // Creating adjacency list
        // Array of ArrayList of Edge
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Initialize each index with an empty ArrayList
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // --------- ADDING EDGES ---------

        // 0 vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));

        // --------- PRINT NEIGHBORS OF VERTEX 2 ---------
        System.out.println("Neighbors of vertex 2:");
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println("2 -> " + e.dest + " (weight = " + e.wt + ")");
        }
    }
}
