package review.LinkList;

import LeetCode100.LinkList.ListNode;

import java.util.List;

public class hasCycle1 {
    class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;

        }
    }
}
