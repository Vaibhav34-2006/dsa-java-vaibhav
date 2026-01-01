package graph;

import java.util.ArrayList;

public class Graph_6 {

    // ---------- EDGE CLASS ----------
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

    // ---------- DFS ----------
    // Handles disconnected graph
    public static void dfs(ArrayList<Edge>[] graph) {

        boolean vis[] = new boolean[graph.length];

        // Call dfsUtil for every vertex
        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }

    // ---------- DFS UTILITY ----------
    // Time Complexity: O(V + E)
    public static void dfsUtil(
            ArrayList<Edge>[] graph,
            int curr,
            boolean vis[]
    ) {

        // Visit current node
        System.out.print(curr + " ");
        vis[curr] = true;

        // Traverse neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    // ---------- CREATE GRAPH ----------
    public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));

        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        dfs(graph);
    }
}
