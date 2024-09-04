package LeetCode100.BinaryTree;

public class insertBST {
    class Solution{
        public TreeNode insertBST(TreeNode root, int val){
            if(root == null) return new TreeNode(val);
            if(val > root.val){
                root.right = insertBST(root.right,val);
            }
            if(val < root.val){
                root.left = insertBST(root.left, val);
            }
            return root;
        }
    }
}
