package LeetCode100.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class pathSum {
    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            // Map to store the cumulative sum and its frequency
            Map<Long, Integer> prefixSumCount = new HashMap<>();
            // Initialize with 0 sum having one count
            prefixSumCount.put(0L, 1);

            // Helper function to calculate path sums
            return dfs(root, prefixSumCount, 0L, targetSum);
        }

        private int dfs(TreeNode node, Map<Long, Integer> prefixSumCount, long currentSum, int targetSum) {
            if (node == null) {
                return 0;
            }

            // Update the current sum
            currentSum += node.val;

            // Calculate the number of valid paths ending at the current node
            int numPathsToCurr = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

            // Update the prefix sum count map
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

            // Recursively search in the left and right subtrees
            int result = numPathsToCurr
                    + dfs(node.left, prefixSumCount, currentSum, targetSum)
                    + dfs(node.right, prefixSumCount, currentSum, targetSum);

            // Restore the map, as the recursion goes from bottom to top
            prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

            return result;
        }
    }
}
