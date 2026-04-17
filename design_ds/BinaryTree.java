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

    public boolean delete(T val){
        Node<T> target = null;
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<T> curr = queue.poll();
            if(val.equals(curr.data)){
                target = curr;
                break;
            }

            if(curr.left != null)queue.offer(curr.left);
            if(curr.right != null)queue.offer(curr.right);
        }

        if(target == null) return false;
        Node<T> parent = null;
        Node<T> lastNode = root;
        queue.clear();
        queue.offer(root);
        while(!queue.isEmpty()){
            lastNode = queue.poll();
            if(lastNode.left != null){
                queue.offer(lastNode.left);
                parent = lastNode;
            }
            if(lastNode.right != null){
                queue.offer(lastNode.right);
                parent = lastNode;
            }
        }

        if(target == root && target.left != null && target.right != null){
            root = null;
            size -= 1;
            return true;
        }

        if(target == lastNode){
            if(parent.right == lastNode) parent.right = null;
            else if(parent.left == lastNode) parent.left = null;
            size -= 1;
            return true;
        }

        target.data = lastNode.data;
        if(parent.right == lastNode) parent.right = null;
        else if(parent.left == lastNode) parent.left = null;
        size -= 1;
        return true;
    }
}
