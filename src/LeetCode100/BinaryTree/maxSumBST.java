package LeetCode100.BinaryTree;

public class maxSumBST {
    class Solution {
        int maxSum = 0;

        public int maxSumBST(TreeNode root) {
            findMaxMinSum(root);
            return maxSum;
        }

        // 是否为BST，子树最小值，子树最大值，键值和
        int[] findMaxMinSum(TreeNode node) {
            if (node == null) {
                return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
            }
            int[] left = findMaxMinSum(node.left);
            int[] right = findMaxMinSum(node.right);

            if (left[0] == 1 && right[0] == 1 && node.val > left[2] && node.val < right[1]) {
                // 当前子树为bst
                int sum = node.val + left[3] + right[3];
                // 要返回四个值
                maxSum = Math.max(maxSum, sum);
                int minVal = Math.min(node.val, left[1]);
                int maxVal = Math.max(node.val, right[2]);
                return new int[]{1, minVal, maxVal, sum};
            } else {
                return new int[]{0, 0, 0, 0};
            }
        }
    }
}
