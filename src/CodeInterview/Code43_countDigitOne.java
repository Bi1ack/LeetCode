package CodeInterview;

import sun.text.resources.FormatData;

import java.time.LocalDate;
import java.util.Date;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-07 09:31
 **/
public class Code43_countDigitOne {

    public static int count(int n) {
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (String.valueOf(i).contains("1")) {
                ans += countOne(i);
            }
        }
        return ans;
    }

    private static int countOne(int i) {
        int ans = 0;
        while (i != 0) {
            int tmp;
            tmp = i % 10;
            if (tmp == 1)
                ans++;
            i /= 10;
        }
        return ans;
    }

    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        int m = s.length();
        if (m == 1) return n > 0 ? 1 : 0;
        // 计算第 i 位前缀代表的数值，和后缀代表的数值
        // 例如 abcde 则有 ps[2] = ab; ss[2] = de
        int[] ps = new int[m], ss = new int[m];
        ss[0] = Integer.parseInt(s.substring(1));
        for (int i = 1; i < m - 1; i++) {
            ps[i] = Integer.parseInt(s.substring(0, i));
            ss[i] = Integer.parseInt(s.substring(i + 1));
        }
        ps[m - 1] = Integer.parseInt(s.substring(0, m - 1));
        // 分情况讨论
        int ans = 0;
        for (int i = 0; i < m; i++) {
            // x 为当前位数值，len 为当前位后面长度为多少
            int x = s.charAt(i) - '0', len = m - i - 1;
            int prefix = ps[i], suffix = ss[i];
            int tot = 0;
            tot += prefix * Math.pow(10, len);
            if (x == 0) {
            } else if (x == 1) {
                tot += suffix + 1;
            } else {
                tot += Math.pow(10, len);
            }
            ans += tot;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 1234;
        long start = System.currentTimeMillis();
        Date date = new Date(start);
        System.out.println(date);
        System.out.println(count(n));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
