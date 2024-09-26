package sortMethod;

import java.util.Scanner;

public class mergeSort {
    public static void mergeSort(int[] arr ,int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2 ;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }

    }

    // 合并两个已排序的子数组
    public static void merge(int[] arr, int left, int mid, int right) {
        // 找出两个子数组的大小
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 创建两个临时数组
        int[] L = new int[n1];
        int[] R = new int[n2];

        // 把数据复制到临时数组
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        // 归并临时数组

        int i = 0, j = 0; // 初始化两个子数组的索引
        int k = left;      // 初始合并后的数组的索引

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // 复制左边剩余的元素
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // 复制右边剩余的元素
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    // 主函数，ACM 输入输出格式
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入：数组大小 n 和数组元素
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 调用归并排序
        mergeSort(arr, 0, n - 1);

        // 输出排序后的数组
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(" ");  // 每个数字之间用空格分隔
            }
        }
        System.out.println();  // 输出结束，换行
    }
}
