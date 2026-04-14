package design_ds;

import java.util.*;

public class BinaryTree <T>{
    private static class Node<T>{
        T data;
        Node<T> left;
        Node<T> right;
        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> root;
    private int size = 0;

    public void add(T val){
        if(val == null) throw new IllegalArgumentException("Value cannot be null");
        Node<T> newNode = new Node<>(val);
        if(root == null){
            root = newNode;
            size++;
            return;
        }

        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<T> curr = queue.poll();
            if(curr.left == null){
                curr.left = newNode;
                size++;
                return;
            }
            queue.offer(curr.left);
            if(curr.right == null){
                curr.right = newNode;
                size++;
                return;
            }
            queue.offer(curr.right);
        }
    }
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
