package LeetCode100.dynamic;

import java.util.Arrays;

public class minDistance {
    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    class Solution_memo {
        int[][] memo;

        public int minDistance(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            memo = new int[m][n];
            for (int[] row : memo) {
                Arrays.fill(memo, -1);
            }
            return dp(s1, m - 1, s2, n - 1);
        }

        int dp(String s1, int i, String s2, int j) {
            if (i == -1) return j + 1;
            if (j == -1) return i + 1;
            // memo 存在
            if (memo[i][j] != -1) {
                return memo[i - 1][j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                memo[i][j] = dp(s1, i - 1, s2, j - 1);
            } else {
                memo[i][j] = min(dp(s1, i - 1, s2, j) + 1,
                        dp(s1, i, s2, j - 1) + 1,
                        dp(s1, i - 1, s2, j - 1) + 1);
            }
            return memo[i][j];
        }
    }

    class Solution_dp {
        public int minDistance(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            // base case
            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = min(dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1,
                                dp[i - 1][j - 1] + 1);
                    }
                }
            }
            return dp[m][n];

        }
    }
}
