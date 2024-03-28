package LeetCode100.Hash;

import com.sun.javafx.scene.control.skin.AccordionSkin;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    //这段代码首先使用一个 HashSet 存储所有不重复的元素，然后遍历这个集合，
//尝试找到每个可能的序列的起点，//并向上扩展序列以计算长度，最后返回找到的最长序列的长度。
//由于每个元素最多被访问两次（一次是加入 HashSet，一次是在找序列时），
//因此整个算法的时间复杂度为 O(n)。
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }
            int longestStreak = 0;
            for (int num : numSet) {
                if (!numSet.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (numSet.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
    }
}
