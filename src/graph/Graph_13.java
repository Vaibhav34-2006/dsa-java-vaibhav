package graph;

import java.util.ArrayList;

public class Graph_13 {

    // ---------- EDGE CLASS ----------
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

        // initialize arraylist for each vertex
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph edges (directed)
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 5));
    }

    // ---------- PRINT ALL PATHS ----------
    public static void printAllPath(ArrayList<Edge>[] graph,
                                    int src,
                                    int dest,
                                    String path) {

        // base case: when source becomes destination
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        // explore all neighbours
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            // recursive call with next node
            printAllPath(graph, e.dest, dest, path + src + " ");
        }
    }

    // ---------- MAIN FUNCTION ----------
    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        int src = 5;
        int dest = 1;

        printAllPath(graph, src, dest, "");
    }
}
