package LeetCode100.dynamic;

import java.util.Arrays;

public class coinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            // 定义 dp 数组，dp[i] 表示凑成金额 i 所需的最少硬币数量
            int[] dp = new int[amount + 1];
            // 初始化 dp 数组，所有值初始为一个不可能的高值
            Arrays.fill(dp, amount + 1);
            // 凑成金额 0 不需要硬币
            dp[0] = 0;
            // 动态规划计算 dp 数组
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin >= 0) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            // 如果 dp[amount] 还是初始值，说明无法凑成金额
            return (dp[amount] == amount + 1) ? -1 : dp[amount];
        }
    }
}
