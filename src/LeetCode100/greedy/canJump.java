package LeetCode100.greedy;

public class canJump {
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 1){
                return true;
            }
            int maxReach = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > maxReach) {
                    return false;
                }
                maxReach = Math.max(maxReach, i + nums[i]);
                if (maxReach >= nums.length - 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
