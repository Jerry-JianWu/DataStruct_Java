package LeetCode100.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int _val) {
        val = _val;
        left = null;
        right = null;
        next = null;
    }
}

public class connect {
    // 利用BFS实现
    /*class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node prev = null;
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    if (prev != null) {
                        prev.next = node;  // 将该层的前一个节点指向当前节点
                    }
                    prev = node;
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);

                }
            }
            return root;
        }
    }*/
    class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            // 连接同父节点的两个子节点
            if (root.left != null && root.right != null) {
                root.left.next = root.right;
            }
            // 连接跨父节点的子树
            if (root.next != null && root.right != null) {
                root.right.next = root.next.left;
            }
            // 递归处理
            connect(root.left);
            connect(root.right);
            return root;
        }
    }
}
