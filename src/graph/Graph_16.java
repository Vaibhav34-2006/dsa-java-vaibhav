package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph_16 {

    // ---------- EDGE CLASS ----------
    // Represents an edge in an undirected weighted graph
    static class Edge {
        int src;   // source vertex
        int dest;  // destination vertex
        int wt;    // weight of edge

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // ---------- PAIR CLASS ----------
    // Used inside PriorityQueue for Prim's Algorithm
    // v    -> vertex
    // cost -> edge weight to reach this vertex
    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        // Min-heap based on cost
        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    // ---------- CREATE GRAPH ----------
    // Creates an undirected weighted graph
    public static void createGraph(ArrayList<Edge>[] graph) {

        // Initialize adjacency list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected edges (add both directions)
        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 0, 10));

        graph[0].add(new Edge(0, 2, 15));
        graph[2].add(new Edge(2, 0, 15));

        graph[0].add(new Edge(0, 3, 30));
        graph[3].add(new Edge(3, 0, 30));

        graph[1].add(new Edge(1, 3, 40));
        graph[3].add(new Edge(3, 1, 40));

        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 2, 50));
    }

    // ---------- PRIM'S ALGORITHM ----------
    // Finds Minimum Spanning Tree (MST) cost
    public static void prims(ArrayList<Edge>[] graph) {

        // visited array to track included vertices
        boolean vis[] = new boolean[graph.length];

        // PriorityQueue to pick minimum cost edge
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Start from vertex 0 with cost 0
        pq.add(new Pair(0, 0));

        int finalCost = 0; // total minimum cost of MST

        // Process until all vertices are included
        while (!pq.isEmpty()) {

            // Get minimum cost edge
            Pair curr = pq.remove();

            // If vertex is not already included in MST
            if (!vis[curr.v]) {

                // Include vertex
                vis[curr.v] = true;

                // Add edge cost to final MST cost
                finalCost += curr.cost;

                // Add all adjacent edges to PQ
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        // Print final MST cost
        System.out.println("final(min) cost of MST = " + finalCost);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        int V = 4; // number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Create graph
        createGraph(graph);

        // Run Prim's Algorithm
        prims(graph);
    }
}
