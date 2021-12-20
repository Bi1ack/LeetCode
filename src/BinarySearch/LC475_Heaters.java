package BinarySearch;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-20 10:22
 **/
public class LC475_Heaters {

    public static int findRadius(int[] houses, int[] heaters) {
        // 双指针
        // 思路： 找到每间房到热水器最短的距离，取其中的最大值即可
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = -1;
        for (int i = 0, j = 0; i < houses.length; ++i) {
            while (j < heaters.length && houses[i] >= heaters[j]) j++;
            int dist;
            if (j == 0) dist = heaters[j] - houses[i];
            else if (j == heaters.length) dist = houses[i] - heaters[j - 1];
            else dist = Math.min(heaters[j] - houses[i], houses[i] - heaters[j - 1]);
            ans = Math.max(dist, ans);
        }
        return ans;
    }

    public static int findRadius_(int[] houses, int[] heaters) {
        // 二分
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = -1;
        return ans;
    }


    public static void main(String[] args) {
        int[] houses = new int[]{1,2,3,4};
        int[] heaters = new int[]{1,4};
        System.out.println(findRadius(houses, heaters));
        Random random = new Random();
        System.out.print(random.nextInt(314));
    }
}
