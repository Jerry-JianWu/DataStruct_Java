package LeetCode100.OrdArray;

import java.util.HashMap;
import java.util.Map;

public class minWindow {

    public String minWindow(String s, String t) {
        Map<Character, Integer> targetFreq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();

        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, start = 0, matchCount = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            right++;
            if (targetFreq.containsKey(rightChar)) {
                windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);
                if (windowFreq.get(rightChar).equals(targetFreq.get(rightChar))) {
                    matchCount++;
                }
            }

            while (matchCount == targetFreq.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                char leftChar = s.charAt(left);
                left++;
                if (targetFreq.containsKey(leftChar)) {
                    if (targetFreq.get(leftChar).equals(windowFreq.get(leftChar))) {
                        matchCount--;
                    }
                }
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
