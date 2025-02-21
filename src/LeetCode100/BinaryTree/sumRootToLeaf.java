package LeetCode100.BinaryTree;

public class sumRootToLeaf {
    class Solution{
        public int sumRootToLeaf(TreeNode root){
            traverse(root);
            return res;
        }
        int path = 0;
        int res = 0;
        void traverse(TreeNode root){
            if(root == null) return;
            if(root.left == null && root.right == null){
                res += path << 1 | root.val;
                return;
            }
            path = path << 1 | root.val;
            traverse(root.left);
            traverse(root.right);
            path = path >> 1;
        }
    }
}
