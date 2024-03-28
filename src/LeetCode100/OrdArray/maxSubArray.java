package LeetCode100.OrdArray;

public class maxSubArray {
    // 动态规划，遍历数组的同时，计算当前位置的最大子序列和
    class Solution {
        public int maxSubArray(int[] nums) {
            // 先做判断
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // maxSoFar 记录遍历到目前为止可以获得最大子序列和， maxEndingHere记录包含当前遍历到的元素的子序列最大和
            int maxSoFar = nums[0], maxEndingHere = nums[0];
            // 遍历数组，对于每个元素，更新maxEndingHere;若maxEndingHere加上当前元素值比当前元素值小，将maxEndingHere更新位当前元素值
            for (int i = 1; i < nums.length; i++) {
                // maxEndingHere + nums[i] 与 nums[i]比较取大者;
                maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
                // 更新maxSoFar 为 maxSoFar和maxEndingHere中最大者
                maxSoFar = Math.max(maxSoFar, maxEndingHere);

            }
            return maxSoFar;
        }
    }
}
