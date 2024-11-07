// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // 读取输入的01字符串
        int length = input.length();
        int index = 0; // 当前处理到的字符串位置
        int step = 1; // 当前要读取的字符数，初始为1
        List<Integer> numbers = new ArrayList<>(); // 存储解析出来的数字

        while (index + step <= length) {
            String substring = input.substring(index, index + step);
            int number = Integer.parseInt(substring, 2); // 将二进制字符串转换为十进制数字
            numbers.add(number);
            index += step; // 移动索引位置
            step++; // 增加要读取的字符数
            if (step > 10) {
                step = 1; // 当step超过10时，重置为1
            }
        }

        // 输出结果
        System.out.println(numbers.size());
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i != numbers.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}