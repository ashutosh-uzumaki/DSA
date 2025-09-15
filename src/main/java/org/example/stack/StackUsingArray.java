package org.example.stack;

public class StackUsingArray {
    class MyStack {
        int top = -1;
        int[] arr = new int[1000];

        public void push(int x) {
            // code here
            arr[++top] = x;

        }

        public int pop() {
            if(top == -1){
                return top;
            }
            int popVal = arr[top];
            top--;
            return popVal;
            // code here
        }
    }

}
