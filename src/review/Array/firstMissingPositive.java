package review.Array;

public class firstMissingPositive {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            // 创建一个answer数组记录答案，先记录左乘积，在利用变量记录右乘积，两个乘积都是除自身以外的左右乘积先后两次分别从左从右遍历
            int[] answer = new int[nums.length];
            answer[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                answer[i] = answer[i - 1] * nums[i - 1];
            }
            int r = 1;
            for (int i = nums.length - 1; i >= 0; i--){
                answer[i] = r * answer[i];
                r = r * nums[i];
            }
            return answer;

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        firstMissingPositive outer = new firstMissingPositive();
        Solution solution = outer.new Solution();
        int[] result = solution.productExceptSelf(nums);

        System.out.println("Result:");
        for (int value : result) {
            System.out.print(value + " ");
        }
        }
    }

