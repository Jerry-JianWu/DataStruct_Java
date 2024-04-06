package LeetCode100.LinkList;

public class hasCycle2 {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            // 快慢指针先判断有无环，有环则将一个指针指到头节点重新遍历，相遇即为第一个进入环的节点
            ListNode slow = head, fast = head;
            boolean hasCycle = false;
            while(fast != null && fast.next == null){
                slow = slow.next;
                fast = fast.next.next;
               if(slow == fast){
                   hasCycle = true;
                   break;
               }
            }
            if(hasCycle){
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;

                }
                return fast;
            }else {
                return null;
            }

        }
    }


}
