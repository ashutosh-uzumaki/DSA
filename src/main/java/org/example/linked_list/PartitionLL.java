package org.example.linked_list;

public class PartitionLL {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLessThan = new ListNode(-1);
        ListNode tailLessThan = dummyLessThan;

        ListNode dummyGreaterThan = new ListNode(-1);
        ListNode tailGreaterThan = dummyGreaterThan;

        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                tailLessThan.next = temp;
                tailLessThan = temp;
            }else{
                tailGreaterThan.next = temp;
                tailGreaterThan = temp;
            }
            temp = temp.next;
        }

        if(dummyLessThan.next == null){
            return dummyGreaterThan.next;
        }

        if(dummyGreaterThan.next == null){
            return dummyLessThan.next;
        }

        tailLessThan.next = dummyGreaterThan.next;
        tailGreaterThan.next = null;

        return dummyLessThan.next;
    }
}
