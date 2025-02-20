// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取事件总数
        Queue<Integer> queue = new LinkedList<>(); // 创建队列，存储顾客的估计服务时间
        int totalTime = 0; // 估计服务时间总和

        for (int i = 0; i < n; i++) {
            int opt = scanner.nextInt(); // 读取事件类型

            if (opt == 1) {
                int x = scanner.nextInt(); // 读取新顾客的估计服务时间
                // 输出当前排队人数和估计服务时间总和
                System.out.println(queue.size() + " " + totalTime);
                // 将新顾客加入队列尾端
                queue.offer(x);
                // 更新估计服务时间总和
                totalTime += x;
            } else if (opt == 2) {
                // 从队列首端移除一位顾客
                int servedCustomer = queue.poll();
                // 更新估计服务时间总和
                totalTime -= servedCustomer;
            }
        }
        scanner.close();
    }
}