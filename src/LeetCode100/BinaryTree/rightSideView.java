package LeetCode100.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideView {
    class Solution{
        public List<Integer> rightSideView(TreeNode root){
            List<Integer> result = new ArrayList<>();
            if(root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                int levelSize = queue.size();
                for(int i = 0; i < levelSize; i++){
                    TreeNode node = queue.poll();
                    // 如果是当前层的最后一个节点， 加入结果列表
                    if(i == levelSize - 1){
                        result.add(node.val);
                    }
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }
            }
            return result;

        }
    }

    class Solution2{
        public List<Integer> rightSideView(TreeNode root){
            // 层序遍历先从右边遍历
            List<Integer> res = new LinkedList<>();
            if(root == null) return res;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int size = q.size();
                TreeNode rightNode = q.peek();
                for (int i = 0; i < size; i++) {
                    TreeNode currentNode = q.poll();
                    if(currentNode.right != null) q.offer(currentNode.right);
                    if(currentNode.left != null) q.offer(currentNode.left);

                }
                res.add(rightNode.val);
            }
            return res;
        }
    }

    class Solution3{

        List<Integer> res = new ArrayList<>();
        int depth = 0;
        public List<Integer> rightSideView_DFS(TreeNode root){
            // dfs先遍历右子树
            traverse(root);
            return res;
        }
        void traverse(TreeNode root){
            if(root == null) return ;
            depth++;
            if(res.size() < depth){
                res.add(root.val) ;
            }
            traverse(root.right);
            traverse(root.left);
            depth--;
        }
    }
}
