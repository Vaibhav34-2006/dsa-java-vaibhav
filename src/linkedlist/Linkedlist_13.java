package linkedlist;

public class Linkedlist_13 {

    // Node structure
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head and Tail
    public static Node head;
    public static Node tail;

    // Add node at end
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Print linked list
    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Delete Nth node from end
    public void deleteNthFromEnd(int n) {

        // Step 1: calculate size
        int sz = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        // Step 2: if first node needs to be deleted
        if (n == sz) {
            head = head.next;
            return;
        }

        // Step 3: find node before the target
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;

        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        // Step 4: delete node
        prev.next = prev.next.next;
    }

    public static void main(String[] args) {
        Linkedlist_13 ll = new Linkedlist_13();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.print();                 // 1 -> 2 -> 3 -> 4 -> 5 -> null

        ll.deleteNthFromEnd(2);     // delete 2nd node from end

        ll.print();                 // 1 -> 2 -> 3 -> 5 -> null
    }
}
