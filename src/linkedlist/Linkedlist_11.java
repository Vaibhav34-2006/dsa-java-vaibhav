package linkedlist;

public class Linkedlist_11 {

    // Node of linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head, Tail and size
    public static Node head;
    public static Node tail;
    public static int size;

    // Add at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
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

    // Recursive search helper
    public int helper(Node head, int key) {

        // base case
        if (head == null) {
            return -1;
        }

        // key found
        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);

        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    // Recursive search
    public int recSearch(int key) {
        return helper(head, key);
    }

    public static void main(String[] args) {
        Linkedlist_11 ll = new Linkedlist_11();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.print();                    // 2 -> 1 -> 3 -> 4 -> 5 -> null
        System.out.println(ll.size);   // 5

        System.out.println(ll.recSearch(3));  // 2
        System.out.println(ll.recSearch(10)); // -1
    }
}
