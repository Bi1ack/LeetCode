package BinarySearch;

/**
 * @program: LeetCode
 * @description: 有序数组中的单个元素
 * @author: zr
 * @date: 2021-12-03 16:00
 **/
public class LC540_SingleElement {

    public int singleNonDuplicate(int[] nums) {
        // 异或 O(n)
//        int ans = 0;
//        for (int n : nums) ans ^= n;
//        return ans;
        // 二分 O(log n)
         int left = 0, right = nums.length - 1;
         int n = nums.length - 1;
         while (left < right) {
             int mid = left + (right - left) / 2;
             if (nums[mid] == nums[mid - 1]) {
                 if ((n - mid) % 2 == 0) {
                     right = mid - 2;
                 } else {
                     left = mid + 1;
                 }
             } else if (nums[mid] == nums[mid + 1]) {
                 if ((n - mid - 1) % 2 == 0) {
                     right = mid - 1;
                 } else {
                     left = mid + 2;
                 }
             } else {
                 return nums[mid];
             }
         }
         return nums[left];
    }

    // 二分优化 O(log n/2)
    // 仅对偶索引查找, 成对出现的元素一定有 nums[n] == nums[n + 1]， 其中n是偶索引
    public int singleNonDuplicate_(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
