package LeetCode100.BinaryTree;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class kthSmallest {

    class Solution{
        private int count = 0;
        private int result = 0;
        public int kthSmallest(TreeNode root, int k){
            inorder(root, k);

            return result;
        }
        private void inorder(TreeNode node, int k ){
            if(node == null) return ;
            inorder(node.left, k);

            count++;
            if(count == k){
                result = node.val;
                return;
            }
            inorder(node.right, k);
        }
    }

    class Solution2{
        public int kthSmallest(TreeNode root, int k){
            Stack<TreeNode> stack = new Stack<>();
            while(true){
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if( --k == 0) return root.val;
                root = root.right;
            }
        }
    }
}
