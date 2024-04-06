package review.Hash;

import java.util.*;

public class groupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
           // 创建hashmap存储结果，键为排序后的字符数组，值为原始字符串
            Map<String, List<String>> map = new HashMap<>();
            // 进入循环判断，创建一个字符数组存储排序后的字符串，获取字符数组的值作为键查询是否在map中
            for(String s : strs){
                char[] charArray = s.toCharArray();
                Arrays.sort(charArray);
                String key = String.valueOf(charArray);
                // 如果不存在则压入map;
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(s);
            }
            return new ArrayList<>(map.values());
        }
    }
}
