package Array;

/**
 * @program: LeetCode
 * @description: 寻找重复数
 * @author: zr
 * @date: 2021-11-22 19:41
 **/
public class LC287_FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        // 修改数组，不使用额外空间
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
            if (nums[i] != i + 1) return nums[i];
        }
        return -1;
    }

    public static int find(int[] arr) {
        if (arr.length <= 1) return -1;
        // 不修改数组，不使用额外空间
        // Floyd判圈法
        int slow = arr[0], fast = arr[arr[0]];
        while (fast != slow) {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        slow = 0;
        while (slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    public static int findBinarySearch(int[] arr) {
        // 二分查找 O(nlogn) O(1)
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            // count[i]为小于等于i的元素个数
            int count = 0;
            int mid = left + (right - left)/2;
            for (int n : arr) {
                if (n <= mid) count++;
            }
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,3,5};
        int res = findBinarySearch(arr);
        System.out.print(res);
    }

}
