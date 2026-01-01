package graph;

import java.util.ArrayList;

public class Graph_4 {

    // ---------- EDGE CLASS ----------
    // Represents an edge in the graph
    static class Edge {
        int src;    // source vertex
        int dest;   // destination vertex
        int wt;     // weight (not used here)

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // ---------- CREATE GRAPH ----------
    // Builds the graph using adjacency list
    public static void createGraph(ArrayList<Edge>[] graph) {

        // Initialize adjacency list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected graph edges
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    // ---------- HAS PATH FUNCTION ----------
    // Returns true if there is a path from src to dest
    public static boolean hasPath(
            ArrayList<Edge>[] graph,
            int src,
            int dest,
            boolean vis[]
    ) {

        // Base case: if source equals destination
        if (src == dest) {
            return true;
        }

        // Mark current node as visited
        vis[src] = true;

        // Traverse all neighbors of src
        for (int i = 0; i < graph[src].size(); i++) {

            // Get edge
            Edge e = graph[src].get(i);

            // If neighbor is not visited
            if (!vis[e.dest]) {

                // Recursive DFS call
                if (hasPath(graph, e.dest, dest, vis)) {
                    return true; // path found
                }
            }
        }

        // No path found
        return false;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        /*
              1 --- 3
             /       | \
            0        |  5 --- 6
             \       |
              2 --- 4
        */

        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Build graph
        createGraph(graph);

        // Check path from 0 to 5
        System.out.println(
                hasPath(graph, 0, 5, new boolean[V])
        );
    }
}
