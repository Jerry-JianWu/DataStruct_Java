package LeetCode100.BinaryTree;

public class lowestCommonAncestor {
    class Solution{
        public TreeNode lowsetCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
            if(root == null || root == p || root == q){
                return root;
            }
            TreeNode left = lowsetCommonAncestor(root.left, p ,q);
            TreeNode right = lowsetCommonAncestor(root. right, p, q);

            if(left != null && right != null){
                return root;
            }
            return left != null ? left : right;
        }
    }
}
