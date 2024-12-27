package LeetCode100.OrdArray;

import java.util.HashMap;

public class findMaxLength {
    class Solution {
        public int findMaxLength(int[] nums) {
            HashMap<Integer, Integer> prefixSumIndex = new HashMap<>();
            prefixSumIndex.put(0, -1);
            int maxLength = 0;
            int prefixSum = 0;
            for (int i = 0; i < nums.length; i++) {
                prefixSum += nums[i] == 0 ? -1 : 1;
                if(prefixSumIndex.containsKey(prefixSum)){
                    maxLength = Math.max(maxLength, i - prefixSumIndex.get(prefixSum));
                }else{
                    prefixSumIndex.put(prefixSum, i);
                }
            }
            return maxLength;

        }
    }
}
