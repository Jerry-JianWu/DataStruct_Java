package LeetCode100.LinkList;

public class swapPairs {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            while(prev.next != null && prev.next.next != null){
                ListNode first = prev.next;
                ListNode second = prev.next.next;

                // exchange;
                first.next = second.next;
                second.next = first;
                prev.next = second;
                prev = first;
            }
            return dummy.next;

        }
    }
}
