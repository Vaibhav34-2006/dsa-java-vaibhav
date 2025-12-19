package linkedlist;

public class Linkedlist_15 {

    // Node of linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head and Tail of linked list
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

    // Detect cycle using Floyd’s Algorithm
    public static boolean isCycle() {

        Node slow = head;
        Node fast = head;

        // slow moves 1 step, fast moves 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // cycle found
            if (slow == fast) {
                return true;
            }
        }

        return false; // no cycle
    }

    public static void main(String[] args) {
        Linkedlist_15 ll = new Linkedlist_15();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        ll.print();              // 1 -> 2 -> 3 -> 4 -> null
        System.out.println(isCycle()); // false

        // create cycle
        tail.next = head;

        System.out.println(isCycle()); // true
    }
}
