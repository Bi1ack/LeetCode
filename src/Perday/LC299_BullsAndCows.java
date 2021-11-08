package Perday;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 猜数字
 * @author: zr
 * @date: 2021-11-08 09:46
 **/
public class LC299_BullsAndCows {
    public String getHint(String secret, String guess) {
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int res1 = 0, res2 = 0;
        int[] key = new int[10];
        int[] value = new int[10];
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                res1++;
            } else{
                key[(s[i] - '0')]++;
                value[(g[i] - '0')]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            res2 += Math.min(key[i], value[i]);
        }
        // return res1 + "A" + res2 + "B";
        //下面的更快
        return new StringBuilder().append(res1).append("A").append(res2).append("B").toString();
    }
}
