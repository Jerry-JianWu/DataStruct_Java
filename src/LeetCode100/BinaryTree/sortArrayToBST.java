package LeetCode100.BinaryTree;

public class sortArrayToBST {
    class Solution{

        public TreeNode sortArrayBST(int[] nums){
            if (nums == null || nums.length == 0){
                return null;
            }
            return constructBSTRecursive(nums, 0, nums.length - 1);
        }
        private TreeNode constructBSTRecursive(int[] nums, int left, int right){
            if (left > right){
                return null;
            }
            int mid = left + ((right - left) >> 1);
            TreeNode node = new TreeNode(nums[mid]);
            node.left = constructBSTRecursive(nums, left, mid - 1);
            node.right = constructBSTRecursive(nums, mid + 1, right);
            return node;
        }
    }
}
