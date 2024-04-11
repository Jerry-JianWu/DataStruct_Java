package LeetCode100.LinkList;

public class reverseKGroup {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null || k == 1) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy, prev = dummy, next = dummy;
            int count = 0;
            // get list.length
            while(cur.next != null){
                cur = cur.next;
                count++;
            }
            // 遍历列表，每次处理k个节点
            while(count >= k){
                cur = prev.next;
                next = cur.next;
                for(int i = 1; i < k; i++){
                    cur.next = next.next;
                    next.next = prev.next;
                    prev.next = next;
                    next = cur.next;
                }
                prev = cur;
                count -= k;
            }
            return dummy.next;
        }
    }
}
