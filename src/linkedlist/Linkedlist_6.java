package linkedlist;

public class Linkedlist_6 {

    // Node of linked list
    public static class Node {
        int data;      // value stored
        Node next;     // reference to next node

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head = first node, Tail = last node
    public static Node head;
    public static Node tail;

    // Add node at start
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {      // empty list
            head = tail = newNode;
            return;
        }

        newNode.next = head;     // link new node to head
        head = newNode;          // update head
    }

    // Add node at end
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {      // empty list
            head = tail = newNode;
            return;
        }

        tail.next = newNode;     // link after tail
        tail = newNode;          // update tail
    }

    // Print linked list
    public void print() {

        if (head == null) {      // empty list
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {   // traverse list
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Add node at given index
    public void add(int idx, int data) {

        // if adding at start
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        // move temp to (idx - 1) position
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // insert new node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        Linkedlist_6 ll = new Linkedlist_6();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(2, 9);

        ll.print();   // output: 2 -> 1 -> 9 -> 3 -> 4 -> null
    }
}
