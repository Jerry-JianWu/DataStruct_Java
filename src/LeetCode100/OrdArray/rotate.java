package LeetCode100.OrdArray;

public class rotate {
    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int n = nums.length;
            k = k % n;
            if (k == 0) {
                return;
            }
            // 反转整个数组
            reverse(nums, 0, n - 1);
            // 反转前k个
            reverse(nums, 0, k - 1);
            // 反转剩下的
            reverse(nums, k, n - 1);
        }

        // 交换头尾
        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}