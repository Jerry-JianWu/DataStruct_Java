package LeetCode100.doublePointer;
/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

思路：
每个柱子能接的雨水量取决于其左右两边的最大高度中较小的一个减去当前柱子的高度。
使用双指针来维护当前左右两侧的最大高度，避免额外空间的动态规划表。

每一步的思路都是计算当前柱子能接多少雨水，而当前柱子能接多少雨水取决于左右两侧最小柱高。
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

    public int trap_2(int[] height){
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // 同样的储水量由左右两侧较矮的柱子决定，如果左最高小于右最高，
            // 说明只能以左最高为最大高度储水，储水量就是 左侧最高-当前柱高
            // 反之右侧较矮则以右侧为储水标准， 储水量是 右侧最高-当前柱高
            if(leftMax < rightMax){
                res += leftMax - height[left];
                left++;
            }else{
                res += rightMax -height[right];
                right--;
            }
        }
        return res;
    }
    public int trap_dp(int[] height){
        if(height.length == 0) return 0;
        int n = height.length;
        int res = 0;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        l_max[0] = height[0];
        r_max[n-1] = height[n-1];
        for(int i = 1; i < n; i++){
            l_max[i] = Math.max(height[i], l_max[i-1]);
        }
        for(int j = n-2; j >=0; j--){
            r_max[j] = Math.max(height[j], r_max[j+1]);
        }
        for(int i = 1; i < n-1 ;i++){
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }
}
