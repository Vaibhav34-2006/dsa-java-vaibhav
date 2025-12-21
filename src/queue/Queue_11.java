package queue;

import java.util.Deque;
import java.util.LinkedList;

public class Queue_11 {

    // Stack implementation using Deque
    static class Stack {

        // Deque used as stack
        Deque<Integer> deque = new LinkedList<>();

        // Push element onto stack
        public void push(int data) {
            deque.addLast(data);
        }

        // Pop element from stack
        public int pop() {
            return deque.removeLast();
        }

        // Peek top element
        public int peek() {
            return deque.getLast();
        }

        // Check if stack is empty
        public boolean isEmpty() {
            return deque.isEmpty();
        }
    }

    public static void main(String[] args) {

        Stack s = new Stack();

        // Push elements
        s.push(1);
        s.push(2);
        s.push(3);

        // Print stack elements in LIFO order
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
