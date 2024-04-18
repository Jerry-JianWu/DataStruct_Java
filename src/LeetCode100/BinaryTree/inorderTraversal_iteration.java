package LeetCode100.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal_iteration {
    class Solution{
        public List<Integer> inorderTraversal_iteration(TreeNode root){
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode current = root;

            while(current != null || !stack.isEmpty()){
                while(current != null){
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }

            return result;
        }
    }
}
