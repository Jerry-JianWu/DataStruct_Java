import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        // 逐步求解前i个字符串的最长公共前缀
        String prefix = strings[0];
        System.out.println(prefix); // 第一个字符串的最长公共前缀就是它本身

        for (int i = 1; i < n; i++) {
            prefix = longestCommonPrefix(prefix, strings[i]);
            if (prefix.isEmpty()) {
                System.out.println("-1");
            } else {
                System.out.println(prefix);
            }
        }

        scanner.close();
    }

    // 方法：计算两个字符串的最长公共前缀
    private static String longestCommonPrefix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }
}
