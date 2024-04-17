package LeetCode100.LinkList;

import java.util.PriorityQueue;

public class mergeKList {
    /*class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0){
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
            ListNode dummy = new ListNode(0), tail = dummy;
            // 将每个链表的头节点添加到优先队列中
            for(ListNode node : lists){
                if(node != null){
                    queue.add(node);
                }
            }
            // 队列不为空时将节点弹出加入链表尾部，并将该节点的下一个节点添加到队列中，优先队列的最小堆特性自动排列
            while(!queue.isEmpty()){
                ListNode minNode = queue.poll();
                tail.next = minNode;
                tail = tail.next;
                if(minNode.next != null){
                    queue.add(minNode.next);
                }
            }

            return dummy.next;
        }
    }*/
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
