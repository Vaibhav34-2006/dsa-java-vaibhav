package graph;

import java.util.ArrayList;

public class Graph_8 {

    // ---------- EDGE CLASS ----------
    // Represents a directed edge in the graph
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // ---------- CREATE GRAPH ----------
    // Builds a directed graph
    public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Directed edges
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0)); // creates cycle
    }

    // ---------- IS CYCLE ----------
    // Checks cycle in entire directed graph
    public static boolean isCycle(ArrayList<Edge>[] graph) {

        boolean vis[] = new boolean[graph.length];     // visited array
        boolean stack[] = new boolean[graph.length];  // recursion stack

        // Check cycle from every unvisited vertex
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    // ---------- CYCLE UTILITY (DFS) ----------
    public static boolean isCycleUtil(
            ArrayList<Edge>[] graph,
            int curr,
            boolean vis[],
            boolean stack[]
    ) {

        // Mark current node visited
        vis[curr] = true;

        // Add current node to recursion stack
        stack[curr] = true;

        // Traverse neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // If neighbor is already in recursion stack → cycle
            if (stack[e.dest]) {
                return true;
            }

            // If neighbor not visited, recurse
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        // Remove current node from recursion stack
        stack[curr] = false;

        return false;
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(isCycle(graph));
    }
}
