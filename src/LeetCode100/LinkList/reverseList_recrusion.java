package LeetCode100.LinkList;

public class reverseList_recrusion {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution{
        public ListNode reverseList(ListNode head){
            // 递归终止条件：当前节点为空，或者下一个节点为空
            if(head == null || head.next == null) return null;
            // 递归反转子链表
            ListNode newHead = reverseList(head.next);
            // 将当前节点的下一个节点的next指向当前节点
            head.next.next = head;
            // 将当前节点的next置空
            head.next = null;
            // newHead为反转链表的头
            return newHead;
        }
    }
}
