package LeetCode100.doublePointer;

public class maxArea {
    public int maxArea(int[] height){
        int left = 0, right = height.length - 1;
        int maxarea = 0;
        while(left<right){
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;
            maxarea = Math.max(maxarea, currentArea);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxarea;
    }
}
