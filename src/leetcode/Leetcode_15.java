package leetcode;

public class Leetcode_15 {

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

    // Function to add two numbers represented by linked lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to help build the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        // Loop until both lists end and no carry is left
        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            // Add value from first list if present
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add value from second list if present
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Create a new node with digit value
            current.next = new ListNode(sum % 10);

            // Update carry
            carry = sum / 10;

            // Move current pointer
            current = current.next;
        }

        // Return the result list (skip dummy node)
        return dummy.next;
    }

    public static void main(String[] args) {

        // Create first number: 342 -> 2 -> 4 -> 3
        ListNode l1 =
                new ListNode(2,
                        new ListNode(4,
                                new ListNode(3)));

        // Create second number: 465 -> 5 -> 6 -> 4
        ListNode l2 =
                new ListNode(5,
                        new ListNode(6,
                                new ListNode(4)));

        // Add the two numbers
        ListNode result = addTwoNumbers(l1, l2);

        // Print result list
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}//That represents 807, which is 342 + 465.