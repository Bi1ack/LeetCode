package TwoPointers;


public class MergeSortedArray {
    /**
     * @author zr
     * @date 2021.10.18
     */

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1;
        while (p >= 0 && q >= 0) {
            if (nums1[p] > nums2[q]) {
                nums1[p + q + 1] = nums1[p];
                p--;
            } else {
                nums1[p + q + 1] = nums2[q];
                q--;
            }
        }
        while (q >= 0) {
            nums1[q] = nums2[q];
            q--;
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] a = {0};
        int[] b = {1};
        int[] nums = merge(a, 0, b, 1);
        for (int i : nums) System.out.print(i);
    }
}

