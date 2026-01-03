package graph;

import java.util.*;

public class Graph_17 {

    // -------- EDGE CLASS --------
    // Stores one directed edge (flight)
    static class Edge {
        int src;   // source city
        int dest;  // destination city
        int wt;    // flight cost

        Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    // -------- INFO CLASS --------
    // Used inside BFS queue
    static class Info {
        int v;       // current city
        int cost;    // cost till now
        int stops;   // number of stops till now

        Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    // -------- CREATE GRAPH --------
    // Converts flights[][] into adjacency list
    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {

        // Initialize each index with empty list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges using flights data
        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    // -------- CHEAPEST FLIGHT --------
    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {

        // Graph creation
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        // Distance array
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // BFS queue
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        // BFS traversal
        while (!q.isEmpty()) {

            Info curr = q.remove();

            // If stops exceed k, stop processing
            if (curr.stops > k) {
                break;
            }

            // Traverse all adjacent edges
            for (int i = 0; i < graph[curr.v].size(); i++) {

                Edge e = graph[curr.v].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // Relaxation condition
                if (curr.cost + wt < dist[v] && curr.stops <= k) {

                    // Update minimum distance
                    dist[v] = curr.cost + wt;

                    // Add next city to queue
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        // If destination unreachable
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        int n = 4;
        int flights[][] = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };

        int src = 0;
        int dest = 3;
        int k = 1;

        int ans = cheapestFlight(n, flights, src, dest, k);
        System.out.println(ans);
    }
}
