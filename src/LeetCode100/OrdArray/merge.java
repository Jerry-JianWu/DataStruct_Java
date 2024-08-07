package LeetCode100.OrdArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge {
    class Solution {
        public int[][] merge(int[][] intervals) {
            // 判断区间
            if (intervals[0].length <= 1) {
                return intervals;
            }
            // 使用lambda表达式排序
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            // 创建一个结果列表存储
            List<int[]> result = new ArrayList<>();
            // 将第一个区间添加到结果列表中
            int[] currentInterval = intervals[0];
            result.add(currentInterval);
            // 进入循环，设置当前结束区间点， 下一个区间起始点与结束点
            for (int[] interval : intervals) {
                int currentEnd = currentInterval[1];
                int nextBegin = interval[0];
                int nextEnd = interval[1];
                // 如果重叠合并区间，仔细想想合并的操作应该是怎样的，应是当前区间的结束点等于 当前结束点与下一起始点的最大值
                if (currentEnd >= nextBegin) {
                    currentInterval[1] = Math.max(currentEnd, nextEnd);
                } else {// 如果不合并 添加区间到结果列表中
                    currentInterval = interval;
                    result.add(currentInterval);
                }
            }
            // 将结果列表转换为数组返回
            return result.toArray(new int[result.size()][]);
        }
    }
}