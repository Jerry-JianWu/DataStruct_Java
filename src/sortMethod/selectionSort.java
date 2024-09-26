package sortMethod;

import java.util.Scanner;

public class selectionSort {
    public static void swap(int[] arr, int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex =  i;
            for (int j = i + 1; j < n; j++) {
                if(arr[j] < minIndex){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
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

        // 调用选择排序
        selectionSort(arr);

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
