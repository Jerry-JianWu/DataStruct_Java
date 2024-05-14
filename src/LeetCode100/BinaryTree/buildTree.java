package LeetCode100.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class buildTree {
    class Solution{
        private Map<Integer, Integer> inorderIndexMap;
        public TreeNode buildTree(int[] preorder, int[] inorder){
            if(preorder == null || inorder == null || preorder.length != inorder.length){
                return null;
            }
            inorderIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);

            }
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

        }
        private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
            if(preStart > preEnd || inStart > inEnd){
                return null;
            }

            // 根节点的值是前序遍历的第一个元素
            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);

            // 在中序遍历中找到根节点的位置
            int midIdx = inorderIndexMap.get(rootVal);


            // 计算左子树的节点数量
            int leftTreeSize = midIdx - inStart;

            // 递归构建左子树和右子树
            root.left = buildTree(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, midIdx - 1);
            root.right = buildTree(preorder, preStart + leftTreeSize +1, preEnd, inorder, midIdx + 1, inEnd);

            return root;
        }
    }
}
