package leetcode;

public class Leetcode_9 {

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

    // Function to reverse a linked list
    public static ListNode reverseList(ListNode head) {

        // prev will become the new head after reversal
        ListNode prev = null;

        // curr is used to move through the list
        ListNode curr = head;

        // Traverse the list
        while (curr != null) {

            // Save next node before changing the link
            ListNode nextNode = curr.next;

            // Reverse the current node's pointer
            curr.next = prev;

            // Move pointers forward
            prev = curr;
            curr = nextNode;
        }

        // prev is the new head
        return prev;
    }

    public static void main(String[] args) {

        // Create list: 1 -> 2 -> 3 -> 4
        ListNode head =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4))));

        // Reverse the list
        head = reverseList(head);

        // Print reversed list
        System.out.print("Reversed List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
