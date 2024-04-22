package LeetCode100.BinaryTree;

public class diameterOfBinaryTree {
    class Solution{
        private int maxDiameter = 0;
        public int diameterOfBinaryTree(TreeNode root){
            maxDepth(root);
            return maxDiameter;
        }

        private int maxDepth(TreeNode root){
            if(root == null) return 0;
            int maxLeftDepth = maxDepth(root.left);
            int maxRightDepth = maxDepth(root.right);
            maxDiameter = Math.max(maxDiameter, maxLeftDepth + maxRightDepth);
            return Math.max(maxLeftDepth, maxRightDepth) + 1;
        }
    }
}
