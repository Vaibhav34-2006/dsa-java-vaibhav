package graph;

import java.util.ArrayList;
import java.util.Stack;

public class Graph_10 {

    // ---------- EDGE CLASS ----------
    // Represents a directed edge
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
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // ---------- TOPOLOGICAL SORT ----------
    public static void topSort(ArrayList<Edge>[] graph) {

        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        // Call DFS-based topSort for all vertices
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s); // modified DFS
            }
        }

        // Print topological order
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    // ---------- TOPO SORT UTILITY ----------
    public static void topSortUtil(
            ArrayList<Edge>[] graph,
            int curr,
            boolean vis[],
            Stack<Integer> s
    ) {

        // Mark current node visited
        vis[curr] = true;

        // Visit all neighbors first
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }

        // Push current node after visiting neighbors
        s.push(curr);
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        topSort(graph);
    }
}
