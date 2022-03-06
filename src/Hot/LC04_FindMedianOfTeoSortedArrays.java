package Hot;

/**
 * @program: LeetCode
 * @description: 寻找两个有序数组的中位数。 （也可以改为第k个数）
 * @author: zr
 * @date: 2022-03-06 13:47
 **/
public class LC04_FindMedianOfTeoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int tol = n1 + n2;
        if (tol % 2 == 0) {
            return (getMedian(nums1, 0, nums2, 0, tol / 2) + getMedian(nums1, 0, nums2, 0, tol / 2 + 1)) / 2;
        } else {
            return getMedian(nums1, 0, nums2, 0, tol / 2 + 1);
        }
    }

    private double getMedian(int[] nums1, int i, int[] nums2, int j, int k) {
        // 寻找第 k 小的数
        if (nums1.length - i > nums2.length - j) return getMedian(nums2, j, nums1, i, k);
        if (nums1.length <= i) return nums2[j + k - 1];
        if (k == 1) {
             return Math.min(nums1[i], nums2[j]);
        } else {
            int index1 = Math.min(i + k / 2 - 1, nums1.length - 1);
            int index2 = j + k - k / 2 - 1;

            if (nums1[index1] <= nums2[index2]) {
                return getMedian(nums1, index1 + 1, nums2, j, k - (index1 - i + 1));
            } else {
                return getMedian(nums1, i, nums2, index2 + 1, k - (index2 - j + 1));
            }

        }
    }

    public static void main(String[] args) {
        LC04_FindMedianOfTeoSortedArrays test = new LC04_FindMedianOfTeoSortedArrays();
        int[] nums1 = {0};
        int[] nums2 = {};
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }
}
