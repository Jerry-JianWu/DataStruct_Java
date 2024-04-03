package LeetCode100.LinkList;

public class addTwoNumbers {

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

    // 要考虑进位，数字长度不相等的情况
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 创建哨兵节点（其实就是一个头节点）
            ListNode dummy = new ListNode(0);
            // 创建当前节点
            ListNode curr = dummy;
            // 进位
            int carry = 0;
            // 进入循环，注意循环条件
            while(l1 != null || l2 !=null){
                // 对每一位进行相加, 同时要保证是同位相加做三位运算符判断
                int x = (l1 != null) ? l1.val : 0;
                int y = (l2 != null) ? l2.val : 0;
                // 获取进位数
                int sum = x + y + carry;
                carry = sum/10;
                // new新的节点为对10取余的结果， 移动三个指针curr, l1, l2
                curr.next = new ListNode(sum%10);
                curr = curr.next;
                if(l1 != null) l1 = l1.next;
                if(l2 != null) l2 = l2.next;
            }
            // 如果最大位的两个数相加还需要新建一个节点以保证进位准确
            if(carry > 0)  curr.next = new ListNode(carry);
            //返回哨兵节点的下一个节点，即新链表的头dummy.next
            return dummy.next;
        }
    }
}
