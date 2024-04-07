package review.Array;

public class firstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                // while循环是因为交换后，新换到i位置的元素也可能不在正确的位置
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    // 将nums[i]放到正确的位置上，即数值x应该放在索引x-1的位置
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
            // 再次遍历，找到第一个位置不正确的元素
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            // 前n个都正确则返回n+1
            return n + 1;
        }
    }

}

