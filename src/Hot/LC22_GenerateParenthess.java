package Hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 括号匹配
 * @author: Ray
 * @date: 2022-03-08 09:13
 **/
public class LC22_GenerateParenthess {
    public List<String> generate(int n) {
        // 递归回溯
        List<String> ans = new ArrayList<>();

        backtrack(ans, n, new StringBuffer(), 0, 0);

        return ans;
    }

    void backtrack(List<String> ans, int n, StringBuffer s, int l, int r) {
        if (s.length() == 2 * n) {
            ans.add(s.toString());
        } else {
            if (l < n) {
                s.append('(');
                backtrack(ans, n, s, l + 1, r);
                s.deleteCharAt(s.length() - 1);
            }

            if (r < l) {
                s.append(')');
                backtrack(ans, n, s, l, r + 1);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LC22_GenerateParenthess test = new LC22_GenerateParenthess();
        System.out.println(test.generate(3));
    }

}
