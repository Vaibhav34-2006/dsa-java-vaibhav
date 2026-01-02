package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph_14 {

    // ---------- EDGE CLASS ----------
    // This class represents an edge in the graph
    // src  -> source vertex
    // dest -> destination vertex
    // wt   -> weight of the edge
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // ---------- PAIR CLASS ----------
    // This class is used in PriorityQueue
    // n    -> current node
    // path -> distance from source to this node
    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        // PriorityQueue will sort Pair objects
        // based on smallest path value (min-heap)
        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    // ---------- CREATE GRAPH ----------
    // Creates the weighted directed graph
    public static void createGraph(ArrayList<Edge>[] graph) {

        // Initialize ArrayList for each vertex
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges (src, dest, weight)
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        graph[3].add(new Edge(3, 5, 1));
    }

    // ---------- DIJKSTRA ALGORITHM ----------
    // Finds shortest distance from source to all vertices
    public static void dijkstra(ArrayList<Edge>[] graph, int src) {

        // dist[i] stores shortest distance from src to i
        int dist[] = new int[graph.length];

        // Initialize distances
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE; // infinity
            }
        }

        // visited array to mark processed vertices
        boolean vis[] = new boolean[graph.length];

        // PriorityQueue for selecting minimum distance node
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Add source node with distance 0
        pq.add(new Pair(src, 0));

        // Loop until all reachable vertices are processed
        while (!pq.isEmpty()) {

            // Remove node with smallest distance
            Pair curr = pq.remove();

            // If node is not visited
            if (!vis[curr.n]) {

                // Mark current node as visited
                vis[curr.n] = true;

                // Traverse all neighbors of current node
                for (int i = 0; i < graph[curr.n].size(); i++) {

                    Edge e = graph[curr.n].get(i);

                    int u = e.src;   // source of edge
                    int v = e.dest;  // destination of edge
                    int wt = e.wt;   // weight of edge

                    // Relaxation step
                    // If shorter path to v is found via u
                    if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + wt < dist[v]) {

                        dist[v] = dist[u] + wt;

                        // Add updated distance to PQ
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // Print shortest distances from source
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        int V = 6; // number of vertices

        // Graph represented as adjacency list
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Create graph
        createGraph(graph);

        int src = 0; // source vertex

        // Run Dijkstra algorithm
        dijkstra(graph, src);
    }
}
