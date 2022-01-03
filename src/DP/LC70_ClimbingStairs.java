package DP;

public class LC70_ClimbingStairs {
    public static int climb (int n) {
        if (n < 2) return 1;
        int ans = 0;
        // 状态转移方程
        // dp[i] 只与 dp[i - 1] 与 dp[i - 2] 有关
        // f(x) = f(x - 1) + f(x - 2)
        // 特别的， 有 f(0) = 1, f(1) = 1
        int p1 = 1, p2 = 1;
        for (int i = 2; i <= n; ++i) {
            ans = p1 + p2;
            p2 = p1;
            p1 = ans;
        }
        return ans;
    }

    // 1 1 2 3 5 8
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climb(n));
    }
}
