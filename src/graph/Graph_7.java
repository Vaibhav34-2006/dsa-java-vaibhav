package graph;

import java.util.ArrayList;

public class Graph_7 {

    // ---------- EDGE CLASS ----------
    // Represents an edge in the graph
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

    // ---------- CREATE GRAPH ----------
    // Builds an undirected graph
    public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));
    }

    // ---------- DETECT CYCLE ----------
    // Checks cycle in entire graph (handles disconnected graph)
    public static boolean detectCycle(ArrayList<Edge>[] graph) {

        boolean vis[] = new boolean[graph.length];

        // Check cycle for every unvisited vertex
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // ---------- DFS UTILITY FOR CYCLE DETECTION ----------
    // curr -> current vertex
    // par  -> parent vertex
    public static boolean detectCycleUtil(
            ArrayList<Edge>[] graph,
            boolean vis[],
            int curr,
            int par
    ) {

        // Mark current node as visited
        vis[curr] = true;

        // Traverse neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // Case 3: neighbor not visited
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            // Case 1: neighbor visited and not parent → cycle exists
            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
            // Case 2: visited neighbor is parent → ignore
        }

        return false;
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        /*
              0 -------- 3
              |          |
              |          |
              1          4
              |
              |
              2
        */

        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(detectCycle(graph));
    }
}
