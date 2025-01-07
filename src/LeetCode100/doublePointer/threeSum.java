package LeetCode100.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
15. 三数之和
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
请你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
*/
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = twoSum(nums, i + 1, 0 - nums[i]);
            for(List<Integer> tuple: tuples){
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while(i<n-1 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int lo = start, hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum == target) {
                res.add(new ArrayList<>(Arrays.asList(left, right)));
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            } else if (sum < target) {
                while (lo < hi && nums[lo] == left) lo++;
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }
}
