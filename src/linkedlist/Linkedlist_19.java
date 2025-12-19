package linkedlist;

public class Linkedlist_19 {

    // Node of doubly linked list
    public static class Node {
        int data;
        Node prev;   // previous node
        Node next;   // next node

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head and Tail
    public static Node head;
    public static Node tail;
    public static int size;

    // Add node at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {           // empty list
            head = tail = newNode;
            return;
        }

        newNode.next = head;          // link new node to head
        head.prev = newNode;
        head = newNode;               // update head
    }

    // Add node at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {           // empty list
            head = tail = newNode;
            return;
        }

        tail.next = newNode;          // link after tail
        newNode.prev = tail;
        tail = newNode;               // update tail
    }

    // Remove first node
    public int removeFirst() {

        if (head == null) {           // empty list
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        int val = head.data;

        if (head == tail) {           // single node
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

        if (head == null) {           // empty list
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        int val = tail.data;

        if (head == tail) {           // single node
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return val;
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
        Linkedlist_19 dll = new Linkedlist_19();

        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(3);
        dll.addLast(4);

        dll.print();            // 1 <-> 2 <-> 3 <-> 4 <-> null

        dll.removeFirst();      
        dll.print();            // 2 <-> 3 <-> 4 <-> null

        dll.removeLast();
        dll.print();            // 2 <-> 3 <-> null
    }
}
