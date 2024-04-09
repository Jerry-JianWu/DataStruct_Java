package review.LinkList;

import LeetCode100.LinkList.ListNode;

public class hasCycle2 {
    class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head;
            boolean hasCycle = false;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    hasCycle = true;
                    break;
                }
            }
            if (hasCycle) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            } else {
                return null;
            }
        }
    }
}
