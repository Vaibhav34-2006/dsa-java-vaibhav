package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_12 {

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
    // Builds the directed graph shown in the image
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // ---------- CALCULATE INDEGREE ----------
    // Computes indegree of each vertex
    public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]) {

        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++; // increase indegree of destination
            }
        }
    }

    // ---------- TOPOLOGICAL SORT (BFS) ----------
    public static void topSort(ArrayList<Edge>[] graph) {

        int indeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        // Step 1: calculate indegree
        calcIndeg(graph, indeg);

        // Step 2: add vertices with indegree 0 to queue
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        // Step 3: BFS
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            // Reduce indegree of neighbors
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                // If indegree becomes 0, add to queue
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        topSort(graph);
    }
}
