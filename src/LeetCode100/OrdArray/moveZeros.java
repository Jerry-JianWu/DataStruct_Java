package LeetCode100.OrdArray;

public class moveZeros {
    class Solution{
        public void moveZeros(int[] nums){
            int slow = 0, fast = 0;
            while(fast < nums.length){
                if(nums[fast] != 0){
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            for(;slow<nums.length;slow++){
                nums[slow]=0;
            }

        }
    }

    class Solution2{
        public void moveZeros(int[] nums){
            int slow = nums.length-1, fast = nums.length-1;
            while(fast >= 0){
                if(nums[fast] != 0){
                    nums[slow] = nums[fast];
                    slow--;
                }
                fast--;
            }
            for(;slow>=0;slow--){
                nums[slow] = 0;
            }
        }

    }

    public static void main(String[] args) {

    }
}
