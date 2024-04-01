package LeetCode100.LinkList;

public class getIntersectionNode {

     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 两个指针初始化指向两个链表的头节点
            ListNode pA = headA, pB = headB;
            while(pA != pB){
                pA = (pA != null) ? headB : pA.next;
                pB = (pB != null) ? headA : pB.next;
            }
            return pA;

            // 遍历两个链表

                // 如果pA到达链表末尾，则pA指向headB，否则继续向后移动

                // 如果pB到达链表末尾，则pB指向headA，否则继续向后移动


            // 返回相交节点， 如果没有相交则返回null， 此时pA和pB都是null


        }
    }
}
