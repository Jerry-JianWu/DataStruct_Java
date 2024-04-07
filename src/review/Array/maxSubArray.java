package review.Array;

public class maxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0)
                return 0;
            int maxSoFar = 0, maxEndingHere = 0;
            for (int i = 0; i < nums.length; i++) {
                maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
                maxSoFar = Math.max(maxSoFar, maxEndingHere);
            }
            return maxSoFar;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubArray outer = new maxSubArray();
        Solution solution = outer.new Solution();
        int result = solution.maxSubArray(nums);

        System.out.println("Result:");

    }
}
