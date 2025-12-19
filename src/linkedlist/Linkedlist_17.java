package linkedlist;

public class Linkedlist_17 {

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

    // Add node at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
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

    // Merge sort function
    public Node mergeSort(Node head) {

        // base case: empty or single node
        // == is used to CHECK equality, not assignment
        if (head == null || head.next == null) {
            return head;
        }

        // find middle node
        Node mid = getMid(head);

        // split list into two halves
        Node rightHead = mid.next;
        mid.next = null;

        // recursive merge sort
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge sorted halves
        return merge(newLeft, newRight);
    }

    // Find middle using slow-fast
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        /*
         * while condition explanation:
         * fast != null && fast.next != null
         *
         * && means BOTH conditions must be true
         * If any one is false → loop stops
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps
        }

        return slow; // mid node
    }

    // Merge two sorted linked lists
    private Node merge(Node head1, Node head2) {

        // dummy node
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        /*
         * while (head1 != null && head2 != null)
         * && means BOTH lists must have nodes
         */
        while (head1 != null && head2 != null) {

            // == is comparison, not assignment
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // if nodes left in first list
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        // if nodes left in second list
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public static void main(String[] args) {
        Linkedlist_17 ll = new Linkedlist_17();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        // List: 5 -> 4 -> 3 -> 2 -> 1

        ll.print();

        ll.head = ll.mergeSort(ll.head);

        ll.print(); // 1 -> 2 -> 3 -> 4 -> 5 -> null
    }
}
