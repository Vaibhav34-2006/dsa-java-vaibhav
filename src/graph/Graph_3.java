package graph;

import java.util.ArrayList;

public class Graph_3 {

    // ---------- EDGE CLASS ----------
    // Represents an edge in the graph
    static class Edge {
        int src;    // source vertex
        int dest;   // destination vertex
        int wt;     // weight (not used in DFS)

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // ---------- CREATE GRAPH ----------
    // Builds the adjacency list representation
    public static void createGraph(ArrayList<Edge>[] graph) {

        // Initialize adjacency list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges (Undirected Graph)

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

    // ---------- DFS FUNCTION ----------
    // Depth First Search (Recursive)
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {

        // Visit current node
        System.out.print(curr + " ");
        vis[curr] = true;

        // Traverse all neighbors of current node
        for (int i = 0; i < graph[curr].size(); i++) {

            // Get edge
            Edge e = graph[curr].get(i);

            // If neighbor is not visited
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis); // recursive DFS call
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

        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Create graph
        createGraph(graph);

        // DFS starting from vertex 0
        System.out.println("DFS Traversal:");
        dfs(graph, 0, new boolean[V]);
    }
}
