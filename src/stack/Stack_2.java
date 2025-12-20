package stack;

public class Stack_2 {

    // Node class represents each element in the stack
    static class Node {
        int data;        // Value of the node
        Node next;       // Reference to next node

        // Constructor to initialize node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the stack (top element)
    static Node head = null;

    // Check whether stack is empty
    public static boolean isEmpty() {
        return head == null;
    }

    // PUSH operation
    // Adds element at the top of stack
    public static void push(int data) {
        Node newNode = new Node(data);

        // If stack is empty, new node becomes head
        if (isEmpty()) {
            head = newNode;
            return;
        }

        // Link new node to current head
        newNode.next = head;

        // Update head to new node
        head = newNode;
    }

    // POP operation
    // Removes and returns top element
    public static int pop() {
        if (isEmpty()) {
            return -1; // Stack underflow
        }

        int top = head.data;  // Store top value
        head = head.next;     // Move head to next node
        return top;
    }

    // PEEK operation
    // Returns top element without removing it
    public static int peek() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public static void main(String[] args) {

        // Push elements into stack
        push(10);
        push(20);
        push(30);

        // Pop elements until stack is empty
        while (!isEmpty()) {
            System.out.println(peek());
            pop();
        }
    }
}
