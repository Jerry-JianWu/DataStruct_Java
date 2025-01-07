package LeetCode100.doublePointer;
/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

思路：
每个柱子能接的雨水量取决于其左右两边的最大高度中较小的一个减去当前柱子的高度。
使用双指针来维护当前左右两侧的最大高度，避免额外空间的动态规划表。
*/
public class trap {
    public int trap(int[] height){
        // 数组长度小于3不可能储水
        if(height == null || height.length < 3){
            return 0;
        }
        // 定义左右指针和辅助变量
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trapperWater = 0;

        //
        while(left < right){
            // 确定较小一侧来计算可能的储水量
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    // 当前高度大于最大高度，不能储水，更新高度
                    leftMax = height[left];
                }else{
                    // 当前高度小于左侧高度，可以储水，储水量为左侧高度-当前高度
                    trapperWater += leftMax - height[left];
                }
                left++;
            }else{
                // 右侧同理
                if(height[right] >= rightMax){
                    // 更新右侧最大高度
                    rightMax = height[right];
                }else{
                    trapperWater += rightMax - height[right];
                }
                right--;
            }
        }
        return trapperWater;
    }
}
