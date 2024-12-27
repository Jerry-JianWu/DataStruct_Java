package sortMethod;

import java.util.Scanner;
public class quickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 进行分区操作，返回基准元素的位置
            int pivotIndex = partitionAsFirst(arr, low, high);

            // 递归排序基准左侧部分
            quickSort(arr, low, pivotIndex - 1);

            // 递归排序基准右侧部分
            quickSort(arr, pivotIndex + 1, high);
        }

    }

    public static int partitionAsLast(int[] arr, int low, int high) {
        // 选择最后一个元素作为基准元素
        int pivot = arr[high];

        // i 表示小于基准的区域的边界，初始化为 low - 1
        int i = low - 1;

        // 遍历数组，将小于基准的元素放在 i 的左边
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;  // 扩大小于基准的区域
                swap(arr, i, j);  // 交换 arr[i] 和 arr[j]
            }
        }

        // 将基准元素放到正确的位置，即 i + 1
        swap(arr, i + 1, high);

        return i + 1;  // 返回基准元素的位置
    }

    public static int partitionAsFirst(int[] arr, int low, int high) {
        // 选择第一个元素作为基准元素
        int pivot = arr[low];

        int i = low + 1; // i 表示比基准元素大的元素的起始位置
        int j = high;    // j 表示比基准元素小的区域

        while (true) {
            // 从左往右找到第一个大于基准元素的元素
            while (i <= high && arr[i] <= pivot) {
                i++;
            }

            // 从右往左找到第一个小于基准元素的元素
            while (j >= low && arr[j] > pivot) {
                j--;
            }

            if (i >= j) { // 如果 i 和 j 相遇或交错，分区结束
                break;
            }

            // 交换 i 和 j
            swap(arr, i, j);
        }

        // 最后将基准元素交换到 j 的位置
        swap(arr, low, j);

        return j;  // 返回基准元素的新位置
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入：数组大小 n 和数组元素
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 调用快速排序
        quickSort(arr, 0, n - 1);

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
