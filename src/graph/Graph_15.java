package graph;

import java.util.ArrayList;

public class Graph_15 {

    // ---------- EDGE CLASS ----------
    // Represents a weighted directed edge
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

    // ---------- CREATE GRAPH ----------
    // Creates the graph using adjacency list
    public static void createGraph(ArrayList<Edge>[] graph) {

        // Initialize adjacency list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges (src, dest, weight)
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));
    }

    // ---------- BELLMAN FORD ALGORITHM ----------
    // Finds shortest paths from source to all vertices
    // Works even with negative weight edges
    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {

        // dist[i] -> shortest distance from src to i
        int dist[] = new int[graph.length];

        // Step 1: Initialize distances
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE; // infinity
            }
        }

        int V = graph.length; // number of vertices

        // Step 2: Relax all edges (V-1) times
        for (int i = 0; i < V - 1; i++) {

            // Traverse all vertices
            for (int j = 0; j < graph.length; j++) {

                // Traverse all edges from vertex j
                for (int k = 0; k < graph[j].size(); k++) {

                    Edge e = graph[j].get(k);

                    int u = e.src;   // source
                    int v = e.dest;  // destination
                    int wt = e.wt;   // weight

                    // Relaxation condition
                    // If shorter path to v is found via u
                    if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + wt < dist[v]) {

                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Step 3: Print shortest distances
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        int V = 5; // number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Create graph
        createGraph(graph);

        // Source vertex
        int src = 0;

        // Run Bellman-Ford algorithm
        bellmanFord(graph, src);
    }
}
