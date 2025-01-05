package LeetCode100.Hash;

import java.util.*;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            // 字符串转换为字符数组，然后排序
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            // 将排序后的字符数组转换为字符串，将字符串的值作为键存储
            String key = String.copyValueOf(charArray);
            // 若存在排序后的字符串键，则将当前字符串添加到键对应的值中
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            // 若不存在排序后的字符串键，则创建键值对，键为排序后的字符串，值为当前字符串
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());

    }

}
