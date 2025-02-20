package LeetCode100.BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/*
* 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

叶子节点 是指没有子节点的节点。
* */
public class binaryTreePaths {
    class Solution {
        LinkedList<String> path = new LinkedList<>();
        LinkedList<String> res = new LinkedList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            traverse(root);
            return res;
        }
        void traverse(TreeNode root){
            if(root == null) return;
            if(root.left == null && root.right == null){
                path.addLast(root.val+"");
                res.addLast(String.join("->",path));
                path.removeLast();
            }
            path.addLast(root.val+"");
            traverse(root.left);
            traverse(root.right);
            path.removeLast();
        }

    }
}
