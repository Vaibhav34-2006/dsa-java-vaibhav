package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_11 {

    // ---------- EDGE CLASS ----------
    // Represents an undirected edge
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // ---------- CREATE GRAPH ----------
    public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Graph from image (NOT bipartite)
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    // ---------- IS BIPARTITE ----------
    // Uses BFS + coloring technique
    public static boolean isBipartite(ArrayList<Edge>[] graph) {

        // Color array
        // -1 : no color
        //  0 : yellow
        //  1 : blue
        int col[] = new int[graph.length];

        // Initialize all vertices as uncolored
        for (int i = 0; i < col.length; i++) {
            col[i] = -1; // no color
        }

        Queue<Integer> q = new LinkedList<>();

        // Handle disconnected graph
        for (int i = 0; i < graph.length; i++) {

            // Start BFS if node is uncolored
            if (col[i] == -1) {

                q.add(i);
                col[i] = 0; // start with yellow

                while (!q.isEmpty()) {

                    int curr = q.remove();

                    // Traverse neighbors
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        // If neighbor not colored
                        if (col[e.dest] == -1) {
                            int nextCol = (col[curr] == 0) ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        // If neighbor has same color → NOT bipartite
                        else if (col[e.dest] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true; // graph is bipartite
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        /*
              0 ------ 2
              |        |
              |        |
              1        4
               \      /
                 3

              Output: FALSE
        */

        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(isBipartite(graph));
    }
}
