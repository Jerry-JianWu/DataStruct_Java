package LeetCode100.BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {
    class Solution{
        public List<Integer> inorderTraversal(TreeNode root){
           // if (root == null) return null;
            List<Integer> result = new ArrayList<>();
            inorder(root, result);
            return result;
        }
        private void inorder(TreeNode node, List<Integer> result){
            if(node != null){
                inorder(node.left, result);
                result.add(node.val);
                inorder(node.right, result);
            }
        }
    }
}
