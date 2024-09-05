package LeetCode100.BinaryTree;

public class numTrees {
    class Solution {
        public int numTrees(int n) {
            int[] memo = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                memo[i] = -1;
            }
            return countTrees(n, memo);
        }

        private int countTrees(int n, int[] memo) {
            if (n == 0 || n == 1) {
                return 1;
            }
            if (memo[n] != -1) {
                return memo[n];
            }
            int result = 0;
            for (int i = 1; i <= n; i++) {
                // 左子树有i-1个节点，右子树有n-i个节点
                int leftTrees = countTrees(i - 1, memo);
                int rightTrees = countTrees(n - i, memo);
                result += leftTrees * rightTrees;
            }
            memo[n] = result;
            return result;
        }
    }
}
