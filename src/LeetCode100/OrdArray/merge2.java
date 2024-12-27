package LeetCode100.OrdArray;

public class merge2 {
    class Solution{
        public void merge(int[] nums1, int m, int[] nums2, int n){
            int i = m - 1, j = n - 1;
            int p = nums1.length;
            while(i >= 0 && j >= 0){
                if(nums1[i] > nums2[j]){
                    nums1[p] = nums1[i];
                    i--;
                }else{
                    nums1[p] = nums2[j];
                    j--;
                }
                p--;
            }
            // 若nums1已经结束，要检查nums2中元素是否已经全部放入nums1中，因为nums1遍历已经结束，所以nums1中元素位置的都已放入准确的位置
            // 所以直接将nums2中的元素按照p指针复制进nums1即可
            while(j>=0){
                nums1[p] = nums2[j];
                p--;
                j--;
            }

        }
    }
}
