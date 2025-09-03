package org.example.linked_list;

public class IntersectionOfTwoLL {
    public int getCount(ListNode head){
        int count = 0;
        ListNode curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }

        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getCount(headA);
        int sizeB = getCount(headB);

        ListNode currA = headA;
        ListNode currB = headB;

        for(int i=0; i<(sizeA - sizeB); i++){
            currA = currA.next;
        }

        for(int i=0; i<(sizeB - sizeA); i++){
            currB = currB.next;
        }

        while(currA != currB){
            currA = currA.next;
            currB = currB.next;
        }

        return currA;

    }
}
