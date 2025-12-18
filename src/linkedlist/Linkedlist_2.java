package linkedlist;

/*
 * This class demonstrates creation of a Linked List
 * with head and tail references.
 */
public class Linkedlist_2 {

    /*
     * Node class
     * Represents a single element of the linked list
     */
    public static class Node {
        int data;      // Stores data
        Node next;     // Reference to next node

        /*
         * Constructor to initialize node
         */
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the linked list
    public static Node head;

    // Tail of the linked list
    public static Node tail;

    /*
     * Main method
     */
    public static void main(String[] args) {

        // Creating first node
        head = new Node(1);

        // Creating second node and linking it
        head.next = new Node(2);

        // Setting tail to last node
        tail = head.next;

        // Linked list created: 1 -> 2 -> null
    }
}
