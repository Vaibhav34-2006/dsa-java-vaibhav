package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_5 {

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

    // ---------- BFS UTILITY ----------
    // Time Complexity: O(V + E)
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) {

        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Source is hardcoded as 0 (as shown in image)
        q.add(0); // source = 0

        // BFS traversal
        while (!q.isEmpty()) {

            int curr = q.remove();

            // Visit current node if not visited
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;

                // Add all neighbors of curr
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // ---------- BFS ----------
    // Handles disconnected graph
    public static void bfs(ArrayList<Edge>[] graph) {

        boolean vis[] = new boolean[graph.length];

        // Call bfsUtil for every vertex
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
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

        bfs(graph);
    }
}
