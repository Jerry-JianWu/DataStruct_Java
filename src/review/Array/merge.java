package review.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) {
                return intervals;
            }
            // 使用lambda表达式对区间起始元素排序
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            // 结果列表动态存储结果
            List<int[]> result = new ArrayList<>();
            // 存第一个区间
            int[] currentInterval = intervals[0];
            // 加进列表
            result.add(currentInterval);
            for (int[] interval : intervals) {
                int currentEnd = currentInterval[1];
                int nextBegin = interval[0];
                int nextEnd = interval[1];
                if (currentEnd >= nextBegin) {
                    // 合并区间
                    currentInterval[1] = Math.max(currentEnd, nextEnd);
                } else {
                    // 不重叠，将当前区间添加到结果，并更新currentInterval
                    currentInterval = interval;
                    result.add(currentInterval);

                }
            }
            return result.toArray(new int[result.size()][]);
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        merge outer = new merge();
        Solution solution = outer.new Solution();
        intervals = solution.merge(intervals);
        for(int[] interval : intervals){
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
    }
}
