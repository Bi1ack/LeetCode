package Greedy;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 买卖股票的最佳时机
 * @author: zr
 * @date: 2021-12-09 15:50
 **/
public class LC121_BestTimeToBuyAndSellStock {

    public int max(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - min);
            }
        }
        return ans;
    }
}
