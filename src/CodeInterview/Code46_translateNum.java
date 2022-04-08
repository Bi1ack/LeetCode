package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-08 09:39
 **/
public class Code46_translateNum {

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (s.charAt(0) == '1') {
            dp[1] = 2;
        } else if(s.charAt(0) == '2' && s.charAt(1) < '6') {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < s.length(); ++i) {
            if ((s.charAt(i - 1) == '2' && s.charAt(i) < '6') || s.charAt(i - 1) == '1') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

    public int translateNum_(int num) {
        String s = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < s.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = s.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

    public int translateNum__(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }

}
