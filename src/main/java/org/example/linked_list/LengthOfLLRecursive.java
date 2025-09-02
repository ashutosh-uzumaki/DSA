package org.example.linked_list;

public class LengthOfLLRecursive {
    public int getCount(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + getCount(head.next);  // count this node + rest
    }
}
