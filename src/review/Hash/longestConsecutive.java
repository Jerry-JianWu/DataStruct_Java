package review.Hash;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    class Solution {
        public int longestConsecutive(int[] nums) {
           // 因为数组元素不重复，所以利用hashset存储不重复元素
            Set<Integer> numSet = new HashSet<>();
            // 遍历数组元素存入hashset
            for(int num : nums){
                numSet.add(num);
            }
            int longestStreak = 0;
            // 进入循环判断是否存在向上的数，同时设置longestStreak，currentStreak，currenNum变量
            for(int num : numSet){

                int currentStreak = 1;
                int currentNum = num;
                while(numSet.contains(currentNum + 1)){
                    currentStreak += 1;
                    currentNum += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
            return longestStreak;
        }
    }
}
