package Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 最长连续序列
 * @author: zr
 * @date: 2021-11-16 21:59
 **/
public class LC128_LongestConsecutiveSequence {

    // O(n)复杂度实现
    public int longestCS(int[] arr) {
        if (arr.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }
        int res = 1;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int num = x;
                int length = 1;
                while (set.contains(num + 1)) {
                    ++num;
                    ++length;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }

}
