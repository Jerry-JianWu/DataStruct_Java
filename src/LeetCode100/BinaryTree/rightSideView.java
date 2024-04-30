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
}
