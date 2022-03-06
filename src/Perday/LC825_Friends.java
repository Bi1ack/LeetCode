package Perday;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-27 11:21
 **/
public class LC825_Friends {

    // 排序 + 双指针
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0, ans = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                ++left;
            }
            while (right + 1 < n && ages[right + 1] <= age) {
                ++right;
            }
            ans += right - left;
        }
        return ans;
    }
    
    // 桶排序
    // TODO: 2021/12/27  
}
