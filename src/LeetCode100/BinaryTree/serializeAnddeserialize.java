package LeetCode100.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class serializeAnddeserialize {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeHepler(root, sb);
            return sb.toString();
        }
        private void serializeHepler(TreeNode node, StringBuilder sb){
            if(node == null){
                sb.append("#,");
                return ;
            }
            sb.append(node.val).append(",");
            serializeHepler(node.left, sb);
            serializeHepler(node.right, sb);
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> nodes = new LinkedList<>();
            for(String s : data.split(",")){
                nodes.offer(s);
            }
            return desrializeHelper(nodes);
        }
        private TreeNode desrializeHelper(Queue<String> nodes){
            String value = nodes.poll();
            if(value.equals("#")){
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(value));
            node.left = desrializeHelper(nodes);
            node.right = desrializeHelper(nodes);
            return node;
        }
    }
}
