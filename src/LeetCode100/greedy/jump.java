package LeetCode100.greedy;

public class jump {
    class Solution {
        public int jump(int[] nums) {
            if (nums == null || nums.length == 1) {
                return 0;
            }
            int n = nums.length;
            int jumps = 0, currentEnd = 0, farthest = 0;
            for (int i = 0; i < n - 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
                if (i == currentEnd) {
                    jumps++;
                    currentEnd = farthest;
                    if (currentEnd >= n - 1) {
                        break;
                    }
                }

            }
            return jumps;
        }

    }

    public static void main(String[] args) {
        jump jump = new jump();
        Solution solution = jump.new Solution();

        int[] nums = {2, 3, 0, 1, 4};
        int result = solution.jump(nums);
        System.out.println("Minimum jumps to reach the end: " + result);
    }

}


