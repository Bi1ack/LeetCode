package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-08 10:18
 **/
public class LC452_MinimumNumberOfArrows {

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            // 直接相减可能溢出！
            if (a[0] == b[0]) return a[1] > b[1]? 1:-1;
            return a[0] > b[0] ? 1 : -1;
        });
        int ans = 0;
        int left = points[0][0], right = points[0][1];
        for (int i = 0; i < points.length; ++i) {
            while (i < points.length-1 && right >= points[i + 1][0]) {
                left = Math.max(points[i + 1][0], left);
                right = Math.min(points[i + 1][1], right);
                i++;
            }
            ans++;
            if (i < points.length-1) {
                left = points[i + 1][0];
                right = points[i + 1][1];
            } else {
                break;
            }
        }
        return ans;
    }

    public static int findMinArrowShots_(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] arr = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        int res = findMinArrowShots_(arr);
    }
}
