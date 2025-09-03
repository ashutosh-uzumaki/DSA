package org.example.linked_list;

public class PalindromLL {
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middle(head);
        ListNode second = reverse(mid);

        while(head != null && second != null){
            if(head.val != second.val){
                return false;
            }
            head = head.next;
            second = second.next;
        }

        return true;
    }
}
