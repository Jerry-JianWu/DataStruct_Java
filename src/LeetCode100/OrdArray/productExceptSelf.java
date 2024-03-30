package LeetCode100.OrdArray;

public class productExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            // 1.首先计算左乘积，再输出数组answer中计算每个位置左边所有元素的乘积，从左边里累乘
            int n = nums.length;
            int[] answer  = new int[n];
            answer[0] = 1;
            for(int i = 1;i < n; i ++){
                answer[i] = nums[i - 1] * answer[i-1];
            }
            // 2.计算右乘积并与左乘积相乘：用一个变量从右到左的累乘结果，从右到左遍历answer，相乘并更新r
            int r = 1;
            for(int i = n - 1 ; i >= 0 ; i--){
                answer[i] = r * answer[i];
                r = r * nums[i];
            }

            return answer;

        }
    }
}
