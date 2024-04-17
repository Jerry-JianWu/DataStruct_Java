package LeetCode100.LinkList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sortList {
    /*
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null) return null;
            List<Integer> vals = new ArrayList<>();
            ListNode current = head;
            while(current != null){
                vals.add(current.val);
                current = current.next;
            }
            Collections.sort(vals);
            ListNode newHead = new ListNode(vals.get(0));
            current = newHead;
            for(int i =1 ; i< vals.size(); i++){
                current.next = new ListNode(vals.get(i));
                current = current.next;
            }
            return newHead;
        }
    }
    */
    class Solution{
        public ListNode sortList(ListNode head){
            if (head == null || head.next == null){
                return head;
            }
            // 使用快慢指针找到中点
            ListNode slow = head, fast =head, prev = null;
            while( fast != null && fast.next != null){
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            // 断开链表，进行分割
            prev.next = null;

            // 递归地对左右两部分链表进行排序
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(slow);
            // 合并两个已排序的链表
            return merge(l1, l2);
        }
        private ListNode merge(ListNode l1, ListNode l2){
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while( l1 != null && l2 != null){
                if(l1.val < l2.val){
                    tail.next = l1;
                    l1 = l1.next;
                }else{
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;

            }
            tail.next = (l1 != null) ? l1 : l2;
            return dummy.next;
        }
    }
}
