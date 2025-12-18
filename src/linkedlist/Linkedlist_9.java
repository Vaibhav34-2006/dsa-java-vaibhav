package linkedlist;

public class Linkedlist_9 {

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
    public static int size;

    // Add node at start
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {          // empty list
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add node at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {          // empty list
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Print linked list
    public void print() {

        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Add node at given index
    public void add(int idx, int data) {

        // add at start
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        // move to index-1 position
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove first node
    public int removeFirst() {

        if (size == 0) {                 // empty list
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {                 // single node
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;             // store value
        head = head.next;                // move head
        size--;
        return val;
    }

    // Remove last node
    public int removeLast() {

        if (size == 0) {                 // empty list
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {                 // single node
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // find node before tail
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = tail.data;             // store tail value
        prev.next = null;                // remove last node
        tail = prev;                     // update tail
        size--;
        return val;
    }

    public static void main(String[] args) {
        Linkedlist_9 ll = new Linkedlist_9();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(2, 9);

        ll.print();                      // 2 -> 1 -> 9 -> 3 -> 4 -> null
        System.out.println(ll.size);     // 5

        System.out.println(ll.removeFirst()); // removes 2
        ll.print();                      // 1 -> 9 -> 3 -> 4 -> null

        System.out.println(ll.removeLast());  // removes 4
        ll.print();                      // 1 -> 9 -> 3 -> null
    }
}
