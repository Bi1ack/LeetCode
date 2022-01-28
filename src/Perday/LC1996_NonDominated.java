package Perday;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2022-01-28 16:41
 **/
public class LC1996_NonDominated {
    public static int nonDominated(int[][] properties) {
        int n = properties.length;
        boolean[] isDominated = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (isDominated[i]) continue;
            for (int j = i + 1; j < n; ++j) {
                if (isDominated[j]) continue;
                if (properties[i][0] < properties[j][0] && properties[i][1] < properties[j][1] && !isDominated[i]) {
                    ans++;
                    isDominated[i] = true;
                }
                if(properties[i][0] > properties[j][0] && properties[i][1] > properties[j][1] && !isDominated[j]) {
                    ans++;
                    isDominated[j] = true;
                }
            }
        }
        return ans;
    }

    public static int numberOfWeakCharacters(int[][] arr) {
        int ans = 0;
        int n = arr.length;
        // b - a 降序 -- a - b 升序
        Arrays.sort(arr, (a, b) -> {
                if (a[0] != b[0]) return b[0] - a[0];
                return a[1] - b[1];
        });
        int max = 0; // defence
        for (int[] a : arr) {
            if (a[1] < max) {
                ans++;
            } else {
                max = a[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] p = new int[][]{{7,7},{1,2},{9,7},{7,3},{3,10},{9,8},{8,10},{4,3},{1,5},{1,5}};
        System.out.println(numberOfWeakCharacters(p));
    }
}
