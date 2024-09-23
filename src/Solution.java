import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read inputs
        long alpha = scanner.nextLong(); // α red bricks
        long b = scanner.nextLong();     // b blue bricks
        long c = scanner.nextLong();     // c green bricks
        long x = scanner.nextLong();     // x red bricks can make 1 blue brick
        long y = scanner.nextLong();     // y blue bricks can make 1 green brick

        // Binary search to find the maximum number of sets
        long low = 0;
        long high = alpha + b + c; // Upper limit for the number of sets
        long maxSets = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (canAchieve(mid, alpha, b, c, x, y)) {
                maxSets = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(maxSets);
        scanner.close();
    }

    // Function to check if 'mid' sets can be formed
    private static boolean canAchieve(long mid, long alpha, long b, long c, long x, long y) {
        if (mid > alpha) {
            return false;
        }

        // Calculate extra blue bricks from red bricks
        long extraRedBricks = alpha - mid;
        long extraBlue = extraRedBricks / x;

        long totalBlue = b + extraBlue;
        if (totalBlue < mid) {
            return false;
        }

        // Calculate extra green bricks from blue bricks
        long blueBricksNeededForSets = mid;
        long blueBricksAvailableForGreen = totalBlue - blueBricksNeededForSets;
        long extraGreen = blueBricksAvailableForGreen / y;

        long totalGreen = c + extraGreen;
        if (totalGreen < mid) {
            return false;
        }

        return true;
    }
}
