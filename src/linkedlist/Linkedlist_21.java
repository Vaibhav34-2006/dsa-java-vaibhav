package linkedlist;

public class Linkedlist_21 {

    // Node of circular linked list
    static class Node {
        int data;
        Node next;
    }

    // Add node to empty list
    static Node addToEmpty(Node last, int data) {

        // if list is not empty, return last
        if (last != null) {
            return last;
        }

        Node newNode = new Node();
        newNode.data = data;

        // circular link
        last = newNode;
        newNode.next = last;

        return last;
    }

    // Add node at beginning
    static Node addFront(Node last, int data) {

        // if list is empty
        if (last == null) {
            return addToEmpty(last, data);
        }

        Node newNode = new Node();
        newNode.data = data;

        newNode.next = last.next;  // point to first node
        last.next = newNode;       // last points to new node

        return last;
    }

    // Add node at end
    static Node addEnd(Node last, int data) {

        // if list is empty
        if (last == null) {
            return addToEmpty(last, data);
        }

        Node newNode = new Node();
        newNode.data = data;

        newNode.next = last.next;  // point to first
        last.next = newNode;       // old last points to new
        last = newNode;            // update last

        return last;
    }

    // Add node after a given value
    static Node addAfter(Node last, int data, int item) {

        if (last == null) {
            return null;
        }

        Node p = last.next;

        do {
            if (p.data == item) {
                Node newNode = new Node();
                newNode.data = data;

                newNode.next = p.next;
                p.next = newNode;

                // if added after last, update last
                if (p == last) {
                    last = newNode;
                }

                return last;
            }
            p = p.next;
        } while (p != last.next);

        System.out.println(item + " not present in the list");
        return last;
    }

    // Delete a node by value
    static Node deleteNode(Node last, int key) {

        // empty list
        if (last == null) {
            return null;
        }

        // only one node
        if (last.data == key && last.next == last) {
            return null;
        }

        Node temp = last;

        // if last node is to be deleted
        if (last.data == key) {
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp;
            return last;
        }

        // search for node to delete
        while (temp.next != last && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next.data == key) {
            temp.next = temp.next.next;
        }

        return last;
    }

    // Traverse circular linked list
    static void traverse(Node last) {

        if (last == null) {
            System.out.println("List is empty");
            return;
        }

        Node p = last.next;

        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != last.next);

        System.out.println();
    }

    public static void main(String[] args) {

        Node last = null;

        last = addToEmpty(last, 6);
        last = addEnd(last, 8);
        last = addFront(last, 2);
        last = addAfter(last, 10, 2);

        traverse(last);      // 2 10 6 8

        last = deleteNode(last, 8);
        traverse(last);      // 2 10 6
    }
}
