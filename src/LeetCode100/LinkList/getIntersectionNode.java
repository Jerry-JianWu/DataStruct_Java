package LeetCode100.LinkList;

public class getIntersectionNode {
    class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 两个指针初始化指向两个链表的头节点

            ListNode pA = headA, pB = headB;
            // 遍历两个链表
            while(pA != pB){
                // 如果pA到达链表末尾，则pA指向headB，否则继续向后移动
                pA = (pA == null) ? headB : pA.next;
                // 如果pB到达链表末尾，则pB指向headA，否则继续向后移动
                pB = (pB == null) ? headA : pB.next;
            }
            // 返回相交节点， 如果没有相交则返回null， 此时pA和pB都是null
            return pA;
        }
    }
}
