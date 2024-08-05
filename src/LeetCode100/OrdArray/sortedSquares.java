package LeetCode100.OrdArray;

public class sortedSquares {
    class Solution{
        public int[] sortedSquares(int[] nums){
            int n = nums.length;
            int i = 0, j = n - 1;
            int p = n - 1;
            int[] res = new int[n];
            while(i<=j){
                if(Math.abs(nums[i]) > Math.abs(nums[j])){
                    res[p] = nums[i] * nums[i];
                    i++;
                }else{
                    res[p] = nums[j] * nums[j];
                    j--;
                }
                p--;
            }
            return  res;
        }
    }
}
