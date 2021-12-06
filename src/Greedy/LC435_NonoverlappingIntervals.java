package Greedy;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 不重叠的区间个数
 * @author: zr
 * @date: 2021-12-06 10:48
 **/
public class LC435_NonoverlappingIntervals {

    public static int eraseOverlap(int[][] intervals) {
        int ans = 1;
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < right) {
                continue;
            }
            ans++;
            right = intervals[i][1];

        }
        return intervals.length - ans;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2}, {2,3}};
        System.out.print(eraseOverlap(arr));
    }
}
