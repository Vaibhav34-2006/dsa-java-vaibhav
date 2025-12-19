package linkedlist;

public class Linkedlist_16 {

    // Node of linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of linked list
    public static Node head;

    // Detect cycle using Floyd’s algorithm
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            if (slow == fast) {
                return true;           // cycle found
            }
        }
        return false;                  // no cycle
    }

    // Remove cycle from linked list
    public static void removeCycle() {

        // Step 1: detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        // if no cycle, return
        if (cycle == false) {
            return;
        }

        // Step 2: find meeting point
        slow = head;
        Node prev = null;   // node before fast

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: remove cycle
        prev.next = null;
    }

    public static void main(String[] args) {

        // Creating linked list with cycle
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;   // cycle here: 1 -> 2 -> 3 -> 2

        System.out.println(isCycle()); // true

        removeCycle();                // remove cycle

        System.out.println(isCycle()); // false
    }
}
