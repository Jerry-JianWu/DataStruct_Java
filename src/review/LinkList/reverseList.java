package review.LinkList;

import LeetCode100.LinkList.ListNode;

import java.util.List;

public class reverseList {
    class Solution {
        public ListNode reverseList(ListNode head) {
            // 前一个节点
            ListNode prev = null;
            // 当前节点
            ListNode curr = head;
            while (curr != null) {
                // 暂存当前节点的下一个节点
                ListNode nextTemp = curr.next;
                // 将当前节点指向前一个节点，实现反转
                curr.next = prev;
                // 前一个节点前进
                prev = curr;
                // 当前节点前进
                curr = nextTemp;
            }
            // prev成为新的头节点
            return prev;

        }
    }

    class Solution2 {
        public ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode newHead = reverseList2(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
