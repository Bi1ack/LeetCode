package Array;

/**
 * @program: LeetCode
 * @description: 移动数组中的0到最后
 * @author: zr
 * @date: 2021-11-20 10:48
 **/
public class LC283_MoveZeros {

    // 要求不改变其他元素的相对顺序，且不使用额外的空间
    public void moveZeros(int[] arr) {
//        int p = 0;
//        for (int i = 0; i < arr.length && p < arr.length; ++i) {
//            if (arr[i] == 0 && arr[p] != 0) {
//                swap(arr, i, p++);
//            } else if(arr[i] == 0 && arr[p] == 0) {
//                while (arr[p] == 0) ++p;
//                swap(arr, i, p++);
//            }
//        }

        int n = arr.length, left = 0, right = 0;
        while (right < n) {
            if (arr[right] != 0) {
                swap(arr, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
