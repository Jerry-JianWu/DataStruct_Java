package LeetCode100.OrdArray;

public class firstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            // 原地哈希：首先，遍历数组，对于每个元素，尝试将其放到正确的位置上。即，当nums[i]不在其正确的位置上（nums[i] != i + 1），
            // 并且它应该被放置的位置不超出数组范围，同时避免将相同的元素重复放置到同一个位置上（即当nums[nums[i] - 1] != nums[i]时），交换元素。
            // 然后，再次遍历调整后的数组，第一个不在正确位置上的元素的下标+1，就是缺失的最小正整数。
            // 如果所有元素都在正确的位置上，那么缺失的最小正整数就是n+1（n是数组的长度）。
                int n = nums.length;

                for(int i = 0; i < n; i++){
                    // while循环是因为交换后，新换到i位置的元素也可能不在正确的位置
                    while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1]!=nums[i]){
                        // 将nums[i]放到正确的位置上，即数值x应该放在索引x-1的位置
                        int temp = nums[nums[i] -1];
                        nums[nums[i] - 1] = nums[i];
                        nums[i] = temp;
                    }
                }
            // 再次遍历，找到第一个位置不正确的元素
            for(int i = 0 ; i < n; i++){
                if(nums[i] != i + 1){
                    return i + 1;
                }
            }
            // 前n个都正确则返回n+1
            return n + 1;
        }
    }
}
