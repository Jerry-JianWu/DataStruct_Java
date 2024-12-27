package LeetCode100.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class generateTrees {
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new ArrayList<>();
            return build(1, n);
        }

        private List<TreeNode> build(int start, int end) {
            List<TreeNode> buildTrees = new ArrayList<>();
            if (start > end) {
                buildTrees.add(null);
                return buildTrees;
            }
            for (int i = start; i <= end; i++) {
                // 递归生成左子树
                List<TreeNode> leftTrees = build(start, i - 1);
                // 递归生成右子树
                List<TreeNode> rightTrees = build(i + 1, end);
                // 将左右子节点与根节点i组合在一起
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode currentNode = new TreeNode(i);
                        currentNode.left = left;
                        currentNode.right = right;
                        buildTrees.add(currentNode);
                    }
                }

            }
            return buildTrees;
        }
    }
}
