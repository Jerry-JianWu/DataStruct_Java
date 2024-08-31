package LeetCode100.BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findDuplicatedSubtrees {
    class Solution{

        private Map<String, Integer> subtreeCountMap = new HashMap<>();
        private List<TreeNode> result = new ArrayList<>();
        public List<TreeNode> findDuplicatedSubtrees(TreeNode root){
            serialize(root);
            return result;

        }
        private String serialize(TreeNode node){
            if(node == null) return "#";

            String serial = node.val + "," + serialize(node.left) + "," + serialize(node.right);

            int count = subtreeCountMap.getOrDefault(serial, 0);
            if(count == 1){
                result.add(node);
            }
            subtreeCountMap.put(serial, count+1);
            return serial;
        }
    }
}
