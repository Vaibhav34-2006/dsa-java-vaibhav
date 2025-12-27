package heaps;

import java.util.PriorityQueue;

public class Heap_2 {

    // ---------- STUDENT CLASS ----------
    // Comparable is used to define priority
    static class Student implements Comparable<Student> {

        String name;
        int rank;

        // Constructor
        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        // Lower rank = higher priority (Min Heap)
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        // PriorityQueue of Student objects
        PriorityQueue<Student> pq = new PriorityQueue<>();

        // Adding students (O(log n))
        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 12));

        // Removing students based on rank priority
        while (!pq.isEmpty()) {

            // peek() → O(1)
            System.out.println(
                pq.peek().name + " -> " + pq.peek().rank
            );

            // remove() → O(log n)
            pq.remove();
        }
    }
}
