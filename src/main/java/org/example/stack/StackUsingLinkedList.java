package org.example.stack;

public class StackUsingLinkedList {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    class MyStack {
        Node top = null;
        // Function to push an integer into the stack.
        void push(int a) {
            // Add your code here
            Node newNode = new Node(a);
            newNode.next = top;
            top = newNode;
        }

        // Function to remove an item from top of the stack.
        int pop() {
            // Add your code here
            if(top == null){
                return -1;
            }

            Node temp = top;
            int val = temp.data;
            top = top.next;
            return val;
        }
    }
}
