package LeetCode100.OrdArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    class Solution{
        public List<List<Integer>> threeSum(int[] nums, int target){
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0; i < n ; i++){
                List<List<Integer>> tuples = twoSum(nums, i + 1, target - nums[i]);
                for(List<Integer> tuple : tuples){
                    tuple.add(nums[i]);
                    res.add(tuple);
                }
                while(i < n - 1 && nums[i] == nums[i+1]) i++;
            }
            return res;

        }

        public List<List<Integer>> twoSum(int[] nums,int start, int target){
            int lo = start, hi = nums.length - 1;
            List<List<Integer>> res = new ArrayList<>();
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) lo++;

                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) hi--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (lo < hi && nums[lo] == left) lo++;
                    while (lo < hi && nums[hi] == right) hi--;
                }
            }
            return res;
        }
    }
}
