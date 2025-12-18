package linkedlist;

/*
 * This class implements a basic Singly Linked List
 * with an addFirst() method.
 */
public class Linkedlist_3 {

    /*
     * Node class
     * Represents a single element (node) of the linked list.
     */
    public static class Node {
        int data;      // Stores the value of the node
        Node next;     // Reference to the next node

        /*
         * Constructor to initialize a node with given data
         */
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the linked list (first node)
    public static Node head;

    // Tail of the linked list (last node)
    public static Node tail;

    /*
     * addFirst()
     * -----------
     * Inserts a new node at the beginning of the linked list.
     *
     * @param data → value to be inserted
     */
    public void addFirst(int data) {

        // Step 1: Create a new node
        Node newNode = new Node(data);

        // Step 2: If list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Step 3: Link new node to current head
        newNode.next = head;

        // Step 4: Update head
        head = newNode;
    }

    /*
     * Used to test linked list operations
     */
    public static void main(String[] args) {

        Linkedlist_3 ll = new Linkedlist_3();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);

        // Final Linked List:
        // 3 -> 2 -> 1 -> null
    }
}
