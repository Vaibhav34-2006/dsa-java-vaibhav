package linkedlist;

public class Linkedlist_20 {

    // Node of doubly linked list
    public static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
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

        if (head == null) { // empty list
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add node at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) { // empty list
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Remove first node
    public int removeFirst() {

        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        int val = head.data;

        if (head == tail) { // single node
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return val;
    }

    // Remove last node
    public int removeLast() {

        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        int val = tail.data;

        if (head == tail) { // single node
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return val;
    }

    // Reverse doubly linked list (POINTER BASED)
    public void reverse() {

        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {

            next = curr.next;   // store next

            // swap links
            curr.next = prev;
            curr.prev = next;

            // move forward
            prev = curr;
            curr = next;
        }

        // update head
        head = prev;
    }

    // Print doubly linked list
    public void print() {

        if (head == null) {
            System.out.println("DLL is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Linkedlist_20 dll = new Linkedlist_20();

        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(3);
        dll.addLast(4);

        dll.print();          // 1 <-> 2 <-> 3 <-> 4 <-> null

        dll.reverse();
        dll.print();          // 4 <-> 3 <-> 2 <-> 1 <-> null

        dll.removeFirst();
        dll.print();          // 3 <-> 2 <-> 1 <-> null

        dll.removeLast();
        dll.print();          // 3 <-> 2 <-> null
    }
}
