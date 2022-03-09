package Hot;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-08 22:27
 **/
public class LC32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int ans = 0;
        for (int j = 0; j < s.length(); ++j) {
            if (s.charAt(j) == '(') {
                stack.push(j);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    ans = Math.max(ans, j - stack.peek());
                } else {
                    stack.push(j);
                }
            }
        }
        return ans;
    }

    public int longestValidParentheses_(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


}
