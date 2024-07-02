package LeetCode100.greedy;

import java.util.ArrayList;
import java.util.List;

public class partitionaLabels {
    class Solution{
        public List<Integer> partitionLabels(String s){
            List<Integer> result = new ArrayList<>();
            int[] end = new int[128];
            char[] str = s.toCharArray();
            for (int i = 0; i < str.length; i++) {
                end[str[i]] = i;
            }
            int left = 0, right = 0;
            while(left<str.length){
                right = end[str[left]];
                for (int i = left + 1; i < right; i++) {
                    right = Math.max(right, end[str[i]]);
                }
                result.add(right - left + 1);
                left = right + 1;
            }
            return result;
        }
    }
}
