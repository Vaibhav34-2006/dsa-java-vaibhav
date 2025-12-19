package linkedlist;

public class Linkedlist_18 {

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
    public Node head;
    public Node tail;

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

    // ZigZag function
    public void zigZag() {

        // STEP 1: Find mid using slow-fast
        Node slow = head;
        Node fast = head.next;

        // fast moves 2 steps, slow moves 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is mid
        Node mid = slow;

        // STEP 2: Reverse second half
        Node curr = mid.next;
        mid.next = null;        // break list into two halves
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;   // store next
            curr.next = prev;   // reverse link
            prev = curr;        // move prev
            curr = next;        // move curr
        }

        // STEP 3: Zig-Zag merge
        Node left = head;   // first half
        Node right = prev;  // reversed second half

        Node nextL, nextR;

        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;

            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        Linkedlist_18 ll = new Linkedlist_18();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        // 1 -> 2 -> 3 -> 4 -> 5

        ll.print();

        ll.zigZag();

        ll.print();   // 1 -> 5 -> 2 -> 4 -> 3 -> null
    }
}
