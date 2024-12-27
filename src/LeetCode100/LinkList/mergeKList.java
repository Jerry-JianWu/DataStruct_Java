package LeetCode100.LinkList;

import java.util.PriorityQueue;

public class mergeKList {
    class Solution{
        public ListNode mergeKLists(ListNode[] lists){
            if( lists == null || lists.length == 0) return null;
            return mergeKLists(lists, 0, lists.length - 1);
        }

        private ListNode mergeKLists(ListNode[] lists, int start, int end){
            if (start == end) return lists[start];
            int mid = start + ((end - start) >> 1);
            ListNode l1 = mergeKLists(lists, start, mid);
            ListNode l2 = mergeKLists(lists, mid + 1, end);
            return mergeTwoLists(l1, l2);
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2){
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while(l1 !=null && l2 != null){
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
