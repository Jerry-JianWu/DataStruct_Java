package LeetCode100.OrdArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nSum {
    class Solution{
        public List<List<Integer>> twoSum(int[] nums, int target){
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            int lo = 0, hi = nums.length - 1;
            while(lo < hi){
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if(sum == target){
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while(lo < hi && left == nums[lo]) lo++;
                    while(lo < hi && right == nums[hi]) hi--;
                }else if(sum < target){
                    while(lo < hi && left == nums[lo]) lo++;
                }else if(sum > target){
                    while(lo < hi && right == nums[hi]) hi--;
                }
            }
            return res;
        }
    }
}
