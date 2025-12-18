package linkedlist;

public class Linkedlist_14 {

    // Node of linked list
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

    // Find middle of linked list (slow-fast)
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // +1 step
            fast = fast.next.next;     // +2 steps
        }

        return slow;                   // slow is mid
    }

    // Check palindrome
    public boolean checkPalindrome() {

        // empty or single node
        if (head == null || head.next == null) {
            return true;
        }

        // step 1: find mid
        Node midNode = findMid(head);

        // step 2: reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // step 3: compare left & right halves
        Node right = prev;   // head of reversed half
        Node left = head;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Linkedlist_14 ll = new Linkedlist_14();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);

        ll.print();                       // 1 -> 2 -> 2 -> 1 -> null
        System.out.println(ll.checkPalindrome()); // true
    }
}
