package leetcode;

public class Leetcode_7 {

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

        // prev will become the new head at the end
        ListNode prev = null;

        // curr is used to traverse the list
        ListNode curr = head;

        // Loop until we reach end of list
        while (curr != null) {

            // Store next node before changing the link
            ListNode nextNode = curr.next;

            // Reverse the link so it points backward
            curr.next = prev;

            // Move both pointers one step forward
            prev = curr;
            curr = nextNode;
        }

        // prev is the new head of reversed list
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
