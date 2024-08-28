package LeetCode100.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class buildTreeInPo {
    class Solution {
        private Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inOrder, int[] postOrder) {
            for (int i = 0; i < inOrder.length; i++) {
                map.put(inOrder[i], i);
            }
            return build(inOrder, 0, inOrder.length - 1,
                    postOrder, 0, postOrder.length - 1);
        }

        private TreeNode build(int[] inOrder, int inStart, int inEnd,
                               int[] postOrder, int postStart, int postEnd) {
            if (inStart > inEnd || postStart > postEnd) {
                return null;
            }
            // 后续遍历的最后一个节点是root节点
            int rootVal = postOrder[postEnd];
            // 获取root在中序遍历中的索引
            int index = map.get(rootVal);
            // 左子树的节点个数
            int leftSize = index - inStart;
            TreeNode root = new TreeNode(rootVal);

            // 递归构造左右子树
            root.left = build(inOrder, inStart, inEnd - 1,
                    postOrder, postStart, postStart + leftSize - 1);

            root.right = build(inOrder, index + 1, inEnd,
                    postOrder, postStart + leftSize, postEnd - 1);

            return root;
        }
    }
}
