package CodeInterview.Code;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-20 11:05
 **/
public class Code03_countBits {

    public static int[] countCBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; ++i) {
            int tmp = i;
            while(tmp != 0) {
                tmp &= (tmp - 1);
                ans[i]++;
            }
        }
        return ans;
    }

    public static int[] count(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;

        // int[] bits = new int[n + 1];
        // for (int i = 1; i <= n; i++) {
        //     bits[i] = bits[i >> 1] + (i & 1);
        // }
        // return bits;
        //
        // int[] bits = new int[n + 1];
        // for (int i = 1; i <= n; i++) {
        //     bits[i] = bits[i & (i - 1)] + 1;
        // }
        // return bits;
    }

    public static void main(String[] args) {
        while(true) {
            int n;
            Random random = new Random();
            n = random.nextInt(100000);
            int[] res1 = count(n);
            int[] res2 = countCBits(n);
            if(!Arrays.equals(res1, res2))
                break;
        }
    }
}
