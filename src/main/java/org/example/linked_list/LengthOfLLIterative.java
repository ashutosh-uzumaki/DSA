package org.example.linked_list;

public class LengthOfLLIterative {
    public int getCount(Node head) {
        // code here
        int count = 0;
        Node temp = head;
        while(temp != null){
            count += 1;
            temp = temp.next;
        }
        return count;
    }
}
