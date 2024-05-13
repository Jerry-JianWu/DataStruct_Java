package LeetCode100.BinaryTree;

import java.util.Stack;

public class flatten {
    class Solution{
        public void flatten(TreeNode root){
            TreeNode current = root;
            while(current != null){
                if(current.left != null){
                    // 找到左子树的最右节点
                    TreeNode rightmost = current.left;
                    while(rightmost.right != null){
                        rightmost = rightmost.right;
                    }
                    // 将原右子树接到左子树的最右节点
                    rightmost.right = current.right;

                    // 将左子树移到右子树
                    current.right = current.left;
                    current.left = null;
                }
                // 移动到下一个节点
                current = current.right;
            }
        }
    }

    class Solution2{
        public void flatten(TreeNode root){
            if(root == null) return;
            // 展开左右子树
            flatten(root.left);
            flatten(root.right);
            // 保存右子树
            TreeNode temp = root.right;

            // 将展开的左子树放到右边
            root.right = root.left;
            root.left = null; // 将左子树置空

            // 找到现在右子树（原左子树）的末端
            TreeNode current = root;
            while(current.right != null){
                current = current.right;
            }
            // 将原来的右子树接到末端
            current.right = temp;
        }
    }

    class Solution3{
        public void flatten(TreeNode root){
            if(root == null) return;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while(!stack.isEmpty()){
                TreeNode currentNode = stack.pop();
                if(currentNode.right != null){
                    stack.push(currentNode.right);
                }
                if(currentNode.left != null){
                    stack.push(currentNode.left);
                }

                if(!stack.isEmpty()){
                    currentNode.right = stack.peek();

                }
                currentNode.left = null;

            }

        }
    }
}
