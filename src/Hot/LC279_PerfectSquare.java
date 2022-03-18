package Hot;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-18 11:00
 **/
public class LC279_PerfectSquare {

    public static int numSquares(int n) {
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[1] = 1;
//        dp[0] = 0;
//        for (int i = 2; i <= n; ++i) {
//            for (int j = 1; j * j <= i; ++j) {
//                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
//            }
//        }
//        return dp[n];

        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

    public static void main(String[] args) {
        int n = 1120;
        System.out.println(numSquares(n));
    }

}
