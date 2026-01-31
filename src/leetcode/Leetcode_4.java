package leetcode;

public class Leetcode_4 {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Function to remove duplicates from sorted linked list
    public static ListNode deleteDuplicates(ListNode head) {

        // If list is empty, return directly
        if (head == null) return head;

        // Start from head
        ListNode current = head;

        // Traverse while next node exists
        while (current.next != null) {

            // If current value equals next value -> duplicate
            if (current.val == current.next.val) {

                // Skip the next node
                current.next = current.next.next;

            } else {

                // Move forward only when values are different
                current = current.next;
            }
        }

        // Return updated head
        return head;
    }

    public static void main(String[] args) {

        // Create sorted list: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(3)))));

        // Remove duplicates
        head = deleteDuplicates(head);

        // Print final list
        System.out.print("Updated List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
