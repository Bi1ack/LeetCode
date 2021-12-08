package Algorithm;

/**
 * @program: LeetCode
 * @description: 思路很简单，细节是魔鬼
 * @author: zr
 * @date: 2021-11-22 09:49
 **/
public class BinarySearch {

    // https://www.cnblogs.com/kyoner/p/11080078.html
    // 查找是否有target
    public static int binarySearch (int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        // 搜索的是[0, arr.length - 1]左闭右闭区间
        while (left <= right) { // 这里什么时候需要等于，什么时候不需要
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                left = mid + 1; // left = mid?
            } else {
                right = mid - 1; // right = mid?
            }
        }
        return -1;
    }

    // 寻找target的左边界
    public static int leftBinarySearch (int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int ans = -1;
        // 搜索的是[0, arr.length - 1]左闭右闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                right = mid - 1;
                ans = mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // 寻找target的右边界
    public static int rightBinarySearch (int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int ans = -1;
        // 搜索的是[0, arr.length - 1]左闭右闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                left = mid + 1;
                ans = mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // LC34
    // 在有序数组中查找target的第一个和最后一个位置
    // 把寻找左右边界综合到一个方法
    public static int[] findLeftRight(int[] arr, int target) {
        int left = leftAndRightBinarySearch(arr, target, false);
        int right = leftAndRightBinarySearch(arr, target, true);
        return new int[]{left, right};
    }

    public static int leftAndRightBinarySearch (int[] arr, int target, boolean flag) {
        int left = 0, right = arr.length - 1;
        int ans = -1;
        // 搜索的是[0, arr.length - 1]左闭右闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                if (flag) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                ans = mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,4,4,4,4,5,5,5,6,7,8,8,9};
        int target = 11;
        int index = binarySearch(arr, target);
        int leftIndex = leftBinarySearch(arr, target);
        int rightIndex = rightBinarySearch(arr, target);
        int[] boundry = findLeftRight(arr, target);
        System.out.print(leftIndex);
        System.out.println();
        System.out.println(rightIndex);
        System.out.println(boundry[0]);
        System.out.println(boundry[1]);
    }

}
