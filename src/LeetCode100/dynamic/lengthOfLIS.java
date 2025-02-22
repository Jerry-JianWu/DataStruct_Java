package LeetCode100.dynamic;

import java.util.Arrays;

public class lengthOfLIS {
    // 动态规划思路，dp数组的定义是dp[i]为以nums[i]这个数字结尾的最长严格递增子序列的 长度
    class Solution1{
        public int lengthOfLIS(int[] nums){
            int n = nums.length;
            int[] dp = new int[n];
            int maxLen = 1;
            Arrays.fill(dp, 1);
            for (int i = 1; i < n; i++) {
                for(int j = 0; j < i; j++){
                    if(nums[j] < nums[i]){
                        //既然是递增子序列，我们只要找到前面那些结尾比 num[i] 小的子序列，
                        // 然后把 nums[i] 接到这些子序列末尾，就可以形成一个新的递增子序列，而且这个新的子序列长度加一。
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
                maxLen = Math.max(dp[i], maxLen);
            }
            return maxLen;
        }
    }
}
