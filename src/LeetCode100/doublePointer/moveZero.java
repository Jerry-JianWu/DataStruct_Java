package LeetCode100.doublePointer;


/*
283. 移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。
*/

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
