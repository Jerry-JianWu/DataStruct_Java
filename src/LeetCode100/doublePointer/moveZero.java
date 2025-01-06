package LeetCode100.doublePointer;

public class moveZero {
    public void moveZeros(int[] nums) {
        int slow = 0, fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
