package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_2 {

    // ---------- EDGE CLASS ----------
    // This class stores information about an edge
    static class Edge {
        int src;   // source vertex
        int dest;  // destination vertex
        int wt;    // weight of the edge

        // Constructor to initialize edge
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // ---------- CREATE GRAPH ----------
    // This function creates the graph using adjacency list
    public static void createGraph(ArrayList<Edge>[] graph) {

        // Initialize each index with an empty ArrayList
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges (Undirected Graph)

        // Vertex 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // Vertex 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // Vertex 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // Vertex 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // Vertex 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));

        // Vertex 5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 6, 1));

        // Vertex 6
        graph[6].add(new Edge(6, 5, 1));
    }

    // ---------- BFS FUNCTION ----------
    // Breadth First Search traversal of graph
    public static void bfs(ArrayList<Edge>[] graph) {

        // Queue is used in BFS
        Queue<Integer> q = new LinkedList<>();

        // Visited array to track visited vertices
        boolean vis[] = new boolean[graph.length];

        // Start BFS from source vertex 0
        q.add(0);

        // Continue until queue becomes empty
        while (!q.isEmpty()) {

            // Remove element from queue
            int curr = q.remove();

            // If current vertex is not visited
            if (!vis[curr]) {

                // Visit the vertex
                System.out.print(curr + " ");
                vis[curr] = true;

                // Add all neighbors of current vertex to queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
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

        // Number of vertices
        int V = 7;

        // Create adjacency list array
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Build the graph
        createGraph(graph);

        // Perform BFS traversal
        System.out.println("BFS Traversal:");
        bfs(graph);
    }
}
