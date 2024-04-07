package review.Array;


public class rotate {
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            // 反转整个数组
            reverse(nums, 0, n - 1);
            // 反转前k个数组
            reverse(nums, 0, k - 1);
            // 反转剩余n-k个
            reverse(nums, k, n - 1);
        }
        // 交换头尾
        private void reverse(int[] nums, int start, int end){
            while(start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate outer = new rotate();
        Solution solution = outer.new Solution();
        solution.rotate(nums, k);
        for(int num : nums){
            System.out.println(num + " ");
        }
    }
}
