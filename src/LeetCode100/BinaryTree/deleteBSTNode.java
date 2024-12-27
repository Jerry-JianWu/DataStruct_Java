package LeetCode100.BinaryTree;

public class deleteBSTNode {
    class Solution{
        public TreeNode deleteNode(TreeNode root, int key){
            if(root == null) return null;
            // 查找需要删除的节点
            if(key < root.val){
                // 往左子树搜索
                root.left = deleteNode(root.left, key);
            }else if(key > root.val){
                // 往右子树搜索
                root.right = deleteNode(root.right, key);
            }else{
                // 找到节点
                if(root.left == null && root.right == null){
                    // 叶子节点直接删除
                    return null;
                }else if(root.left == null){
                    // 只有右子树，将右子树返回
                    return root.right;
                }else if(root.right == null){
                    // 只有左子树，将左子树返回
                    return  root.left;
                }else{
                    // 左右子树都有，找到右子树中最小节点替换该节点
                    TreeNode minNode = findMin(root.right);
                    root.val = minNode.val;
                    // 对该节点的右子树进行删除（就是删除刚才替换的节点）
                    root.right = deleteNode(root.right, minNode.val);
                }

            }
            return root;
        }
        private TreeNode findMin(TreeNode node){
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
    }
}
