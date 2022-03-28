package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-28 10:24
 **/
public class Code15_hammingWeight {

    public int hammingWeight(int n) {
        // 二进制中 1 的个数
        // 获取一个整数的最右的1 ： x & (-x)
        // 删除一个整数的最右的1 ： x & (x - 1)
        int ans = 0;
        while (n != 0) {
            ans++;
            n = n & (n - 1);
        }
        return ans;
    }

}
