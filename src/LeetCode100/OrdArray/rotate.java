package LeetCode100.OrdArray;

public class rotate {
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            // 反转整个数组
            reverse(nums, 0, n - 1);
            // 反转前k个
            reverse(nums, 0, k - 1);
            // 反转剩下的
            reverse(nums, k, n - 1);
        }
        // 交换头尾
        private void reverse(int[] nums, int start, int end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
