package LeetCode100.LinkList;

import java.util.List;

public class reverseList_iteration {

     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

     //1.迭代法
 class Solution {
     public ListNode reverseList(ListNode head) {
         // 前一个节点
         ListNode prev = null;
         // 当前节点
         ListNode curr = head;
         while(curr != null){
             ListNode nextTemp = curr.next;
             curr.next= prev;
             prev = curr;
             curr = nextTemp;
         }
         return prev;

             // 暂存当前节点的下一个节点
              // 将当前节点指向前一个节点，实现反转
              // 前一个节点前进
              // 当前节点前进

          // prev成为新的头节点
     }
 }


}
