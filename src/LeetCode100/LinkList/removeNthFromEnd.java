package LeetCode100.LinkList;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 构建链表 [1,2,3,4,5]
        int[] vals ={1, 2 ,3 ,4 ,5};
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(int val: vals){
            tail.next = new ListNode(val);
            tail = tail.next;
        }

        // 打印原始链表
        System.out.println("Original List:");
        solution.printList(dummy.next);

        // 移除倒数第2个节点
        ListNode newHead = solution.removeNthFromEnd(dummy.next, 3);

        // 打印结果链表
        System.out.println("After Removing:");
        solution.printList(newHead);
    }
}
