package review.LinkList;

import LeetCode100.LinkList.ListNode;

public class getIntersectionNode {
    class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 两个指针初始化指向两个链表的头节点
            ListNode pA = headA, pB = headB;
            while(pA != pB){
                pA = (pA == null) ? headB : pA.next;
                pB = (pB == null) ? headA : pB.next;
            }
            return pA;
        }
    }
}
