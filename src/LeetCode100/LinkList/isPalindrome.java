package LeetCode100.LinkList;

import java.util.ArrayList;
import java.util.List;

public class isPalindrome {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    class solution{
        public boolean isPalindrome(ListNode head){
            // 将值复制到数组中，java方法
            List<Integer> vals = new ArrayList<Integer>();
            ListNode currentNode = head;
            while(currentNode != null){
                vals.add(currentNode.val);
                currentNode = head.next;
            }
            int end = vals.size() - 1;
            // 使用头尾双指针判断是否回文
            for(int start = 0; start < end; start++){
                if(!vals.get(start).equals(vals.get(end))){
                    return false;
                }
            }
            return true;
        }
    }
}
