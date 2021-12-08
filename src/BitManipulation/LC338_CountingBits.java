package BitManipulation;

/**
 * @program: LeetCode
 * @description: 比特位计数
 * @author: zr
 * @date: 2021-12-01 16:46
 **/
public class LC338_CountingBits {

    // O(nlogn)
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        while (n != 0) {
            res[n] = count(n);
            --n;
        }
        res[0] = 0;
        return res;
    }

    public int count(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            ++res;
        }
        return res;
    }

    // DP O(n)
    public int[] countBits_Dp(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

}
