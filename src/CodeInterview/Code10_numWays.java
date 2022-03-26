package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-26 10:22
 **/
public class Code10_numWays {

    public int numWays(int n) {
        int p = 1, q = 1;
        int cur = 0;
        for (int i = 2; i <= n; ++i) {
            cur = (p + q) % 1000000007;
            p = q;
            q = cur;
        }
        return cur;
    }

}
