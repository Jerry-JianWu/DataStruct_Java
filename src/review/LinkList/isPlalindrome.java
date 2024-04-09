package review.LinkList;

import LeetCode100.LinkList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class isPlalindrome {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            List<Integer> vals = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                vals.add(cur.val);
                cur = cur.next;
            }
            int start = 0, end = vals.size() - 1;
            while (start < end) {
                if (!vals.get(start).equals(vals.get(end))) {
                    return false;
                }
                start++;
                end--;
            }
            return true;

        }
    }
}
