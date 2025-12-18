package linkedlist;

public class Linkedlist_12 {

    // Node structure
    public static class Node {
        int data;      // data of node
        Node next;     // next node reference

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head, tail and size
    public static Node head;
    public static Node tail;
    public static int size;

    // Add node at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {          // if list is empty
            head = tail = newNode;
            return;
        }

        newNode.next = head;         // connect new node to head
        head = newNode;              // update head
    }

    // Add node at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {          // if list is empty
            head = tail = newNode;
            return;
        }

        tail.next = newNode;         // connect after tail
        tail = newNode;              // update tail
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

    // Helper function for recursive search
    public int helper(Node head, int key) {

        // base case
        if (head == null) {
            return -1;
        }

        // if key found
        if (head.data == key) {
            return 0;
        }

        // recursive call on next node
        int idx = helper(head.next, key);

        if (idx == -1) {
            return -1;
        }

        // add 1 while returning
        return idx + 1;
    }

    // Recursive search
    public int recSearch(int key) {
        return helper(head, key);
    }

    // Reverse linked list (iterative)
    public void reverse() {

        Node prev = null;            // previous node
        Node curr = tail = head;     // current node starts from head
        Node next;

        while (curr != null) {
            next = curr.next;        // save next node
            curr.next = prev;        // reverse link
            prev = curr;             // move prev forward
            curr = next;             // move curr forward
        }

        head = prev;                 // update head
    }

    public static void main(String[] args) {
        Linkedlist_12 ll = new Linkedlist_12();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.print();                  // 2 -> 1 -> 3 -> 4 -> 5 -> null

        ll.reverse();
        ll.print();                  // 5 -> 4 -> 3 -> 1 -> 2 -> null

        System.out.println(ll.recSearch(3)); // index of 3
    }
}
