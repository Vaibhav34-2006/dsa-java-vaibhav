package linkedlist;

/*
 * This class demonstrates the basic structure of a Linked List in Java.
 * It contains an inner Node class which represents each element of the linked list.
 */
public class Linkedlist_1 {

    /*
     * Node class
     * Each node has:
     * 1. data  → stores the value of the node
     * 2. next  → reference to the next node in the list
     */
    public class node {
        int data;     // Stores the value of the node
        node next;    // Points to the next node

        /*
         * Constructor to initialize a node
         * @param data → value to be stored in the node
         */
        public node(int data) {
            this.data = data;   // Assign data to node
            this.next = null;   // Initially, next is null
        }
    }

    public static void main(String[] args) {
        // Code for creating and using linked list will be added later
    }

}
