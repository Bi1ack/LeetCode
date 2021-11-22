package Array;

/**
 * @program: LeetCode
 * @description: 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，
 * 导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合丢失了一个数字并且有一个数字重复。
 * @author: zr
 * @date: 2021-11-22 17:15
 **/
public class LC645_SetMismatch {
    // 排序之后遍历 O(nlogn)
    // 略

    // 数组哈希 O(n) O(n)
    public int[] findErrorNums_hash(int[] nums) {
        int a = -1,b = -1;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (arr[nums[i] - 1] == 0) {
                arr[nums[i] - 1] = 1;
            } else {
                a = nums[i];
            }
        }
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0) b = i + 1;
        }
        return new int[]{a, b};
    }

    // 桶排序, 交换数组元素
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        // 把元素放到该放的位置上
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        int a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                a = nums[i];
                b = i == 0 ? 1 : nums[i - 1] + 1;
            }
        }
        return new int[]{a, b};
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
