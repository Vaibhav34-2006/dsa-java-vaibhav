package linkedlist;

public class Linkedlist_5 {

    // Node of linked list
    public static class Node {
        int data;      // value stored
        Node next;     // address of next node

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

        // if list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // link new node to head
        newNode.next = head;
        head = newNode;
    }

    // Add node at end
    public void addLast(int data) {
        Node newNode = new Node(data);

        // if list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // link new node after tail
        tail.next = newNode;
        tail = newNode;
    }

    // Print linked list
    public void print() {

        // if list is empty
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;

        // traverse till end
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Linkedlist_5 ll = new Linkedlist_5();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);

        ll.print();   // print linked list
    }
}
