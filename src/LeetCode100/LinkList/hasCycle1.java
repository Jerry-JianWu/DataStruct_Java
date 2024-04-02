package LeetCode100.LinkList;

public class hasCycle1 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 快慢指针法
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head.next == null) return false;
            // 快指针比满指针多走一步，相遇则有环不相遇则无环，且快指针并且快指针下个是null则无环
            ListNode slow = head, fast = head;
                // 如果快慢指针相遇则存在环
            while(fast != null && fast.next == null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast){
                    return true;
                }
            }
            // 退出循环说明没有环
            return false;
        }
    }
}
