package LeetCode100.OrdArray;

public class pivotIndex {
    class Solution{
        public int pivotIndex(int[] nums){
            int n = nums.length;
            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            for (int i = 1; i <=n ; i++) {
                preSum[i] = preSum[i-1] + nums[i-1];
            }
            for (int i = 1; i < preSum.length ; i++) {
                int leftSum = preSum[i - 1] - preSum[0];
                int rightSum = preSum[n]  - preSum[i];
                if(leftSum == rightSum)
                    return i-1;
            }
            return -1;
        }
    }
}
