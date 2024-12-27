package LeetCode100.BinaryTree;



public class convertBST {
    class Solution{
        public TreeNode convertBST(TreeNode root){
            traverse(root);
            return root;
        }
        private int sum;
        private void traverse(TreeNode root){
            if(root == null){
                return;
            }
            traverse(root.right);
            sum += root.val;
            root.val = sum;
            traverse(root.left);
        }
    }
}
