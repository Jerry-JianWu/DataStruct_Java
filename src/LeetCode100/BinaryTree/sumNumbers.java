package LeetCode100.BinaryTree;
/*给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
每条从根节点到叶节点的路径都代表一个数字：

例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
计算从根节点到叶节点生成的 所有数字之和 。

叶节点 是指没有子节点的节点。*/
public class sumNumbers {
    StringBuilder path = new StringBuilder();
    int res = 0;
    class Solution{
        public int sumNumbers(TreeNode root){
            traverse(root);
            return res;
        }
        void traverse(TreeNode root){
            if(root == null) return;
            path.append(root.val);
            if(root.left == null && root.right == null){
                res += Integer.parseInt(path.toString());
            }
            traverse(root.left);
            traverse(root.right);
            // 返回上级节点所以要删除最后一个节点
            path.deleteCharAt(path.length() - 1);

        }
    }
}
