package graph;

import java.util.*;

public class Graph_18{

    // -------- EDGE CLASS --------
    // Represents an edge to a destination city with cost
    static class Edge implements Comparable<Edge> {
        int dest;   // destination city
        int cost;   // cost to connect

        // Constructor
        public Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        // Comparator for PriorityQueue
        // Sort edges by cost (ascending)
        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }

    // -------- CONNECT CITIES (PRIM'S ALGORITHM) --------
    public static int connectCities(int cities[][]) {

        // Min-heap based on edge cost
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Visited array to track included cities
        boolean vis[] = new boolean[cities.length];

        // Start from city 0 with cost 0
        pq.add(new Edge(0, 0));

        int finalCost = 0;

        // Process until all reachable cities are covered
        while (!pq.isEmpty()) {

            // Get minimum cost edge
            Edge curr = pq.remove();

            // If city not visited
            if (!vis[curr.dest]) {

                // Mark city as visited
                vis[curr.dest] = true;

                // Add cost to final answer
                finalCost += curr.cost;

                // Explore all neighbors
                for (int i = 0; i < cities[curr.dest].length; i++) {

                    // If edge exists (non-zero cost)
                    if (cities[curr.dest][i] != 0) {

                        // Add edge to priority queue
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        // Total minimum cost to connect all cities
        return finalCost;
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        int cities[][] = {
            {0, 1, 2, 3, 4},
            {1, 0, 5, 0, 7},
            {2, 5, 0, 6, 0},
            {3, 0, 6, 0, 0},
            {4, 7, 0, 0, 0}
        };

        // Print minimum cost
        System.out.println(connectCities(cities));
    }
}
