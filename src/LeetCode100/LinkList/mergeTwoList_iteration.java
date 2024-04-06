package LeetCode100.LinkList;

public class mergeTwoList_iteration {
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            // 添加哨兵节点，它的next指向新链表头部
            ListNode tail = dummy;
            // 比较两个链表头部值，将较小的节点接在新链表的后面，然后移动较小节点所在的链表指针
            while(list1 != null && list2 != null){
                if(list1.val < list2.val){
                    tail.next = list1;
                    list1 = list1.next;
                }else {
                    tail.next = list2;
                    list2 = list2.next;
                }
                tail = tail.next;
            }
            // 如果有一个链表为空，将另一个链表的剩余部分接上
            tail.next = (list1 != null) ? list1 : list2;
            return dummy.next;
        }
    }
}
