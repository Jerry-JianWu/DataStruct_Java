package LeetCode100.BinaryTree;

public class maxDepth {
    class Solution{
        public int maxDepth(TreeNode root){
            if(root == null){
                return 0;
            }else{
                int maxLeftDepth = maxDepth(root.left);
                int maxRightDepth = maxDepth(root.right);
                return Math.max(maxLeftDepth, maxRightDepth) + 1;
            }
        }
    }
}
