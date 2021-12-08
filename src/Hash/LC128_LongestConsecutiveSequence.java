package Hash;

import java.util.HashMap;
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

    // O(n)
    // 1.
    // See if n - 1 and n + 1 exist in the map, and if so, it means there
    // is an existing sequence next to n. Variables left and right will be
    // the length of those two sequences, while 0 means there is no sequence
    // and n will be the boundary point later. Store (left + right + 1) as
    // the associated value to key n into the map.
    // 2.
    // Use left and right to locate the other end of the sequences to the
    // left and right of n respectively, and replace the value with the new length.
    public int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }

}
