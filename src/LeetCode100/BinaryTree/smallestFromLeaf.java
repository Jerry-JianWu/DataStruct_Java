package LeetCode100.BinaryTree;

public class smallestFromLeaf {
    class Solution{
        public String smallestFromLeaf(TreeNode root){
            traverse(root);
            return res;
        }
        StringBuilder path = new StringBuilder();
        String res;
        void traverse(TreeNode root){
            if(root == null) return;
            if(root.left == null && root.right == null){
                path.append((char)('a'+root.val));
                path.reverse();
                String s = path.toString();
                if(res == null || res.compareTo(s)>0){
                    res = s;
                }
                path.reverse();
                path.deleteCharAt(path.length() - 1);
            }
            path.append((char)('a'+root.val));
            traverse(root.left);
            traverse(root.right);
            path.deleteCharAt(path.length()-1);
        }
    }
}
