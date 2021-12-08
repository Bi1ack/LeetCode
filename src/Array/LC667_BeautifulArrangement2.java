package Array;

/**
 * @program: LeetCode
 * @description: 相邻的元素差正好有k个不同的整数
 * @author: zr
 * @date: 2021-11-23 15:13
 **/
public class LC667_BeautifulArrangement2 {

    public int[] constructArray(int n, int k) {
        // 思路
        // 让前 k + 1 个数构造k种不同的差值， [1, k];
        // 那么， 后 n - k - 1个数的差值都为 1， 属于[1, k];
        // 第 k + 1 和 k + 2 个数之间的差值 k/2 + 1， 也属于[1, k];
        // 故，此时， 数值中共有 k 中不同的差值
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1, interval = k; i < k + 1; ++i, --interval) {
            res[i] = i % 2 == 1? res[i - 1] + interval : res[i - 1] - interval;
        }
        for (int i = k + 1; i < n; ++i) {
            res[i] = i + 1;
        }
        return res;
    }
}
