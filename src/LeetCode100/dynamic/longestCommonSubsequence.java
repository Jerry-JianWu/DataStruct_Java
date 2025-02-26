package LeetCode100.dynamic;

import java.util.Arrays;

public class longestCommonSubsequence {
    class Solution_dp {
        // dp[i][j] 是用来保存从字符串起始位置到某一位置的最长公共子序列。
        // dp[i][j]：这里的 i 和 j 是字符串的前缀范围，
        // 表示从 text1 和 text2 各自的起始位置到第 i-1 和 j-1 个字符的最长公共子序列。
        // 例如，dp[2][3] 表示 text1[0..1] 和 text2[0..2] 的公共子序列。
        public int longestCommonSubsequence(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }

    class Solution_memo {
        // memo[i][j] 是用来保存从某个位置到字符串结尾的最长公共子序列。
        // memo[i][j]：这里的 i 和 j 是从字符串的某个位置到末尾的范围，
        // 表示从 text1 的第 i 个字符到最后一个字符，和 text2 的第 j 个字符到最后一个字符的最长公共子序列。
        // 例如，memo[1][2] 表示从 text1[1..] 和 text2[2..] 的公共子序列。
        int[][] memo;

        public int longestCommonSubsequence(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            memo = new int[m][n];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dp(s1, 0, s2, 0);
        }

        int dp(String s1, int i, String s2, int j) {
            if (s1.length() == i || s2.length() == j) {
                return 0;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                memo[i][j] = dp(s1, i + 1, s2, j + 1);
            } else {
                memo[i][j] = Math.max(dp(s1, i, s2, j + 1), dp(s1, i + 1, s2, j));
            }
            return memo[i][j];
        }
    }
}
