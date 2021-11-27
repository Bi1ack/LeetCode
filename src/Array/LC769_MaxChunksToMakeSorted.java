package Array;

/**
 * @program: LeetCode
 * @description: 最多能完成排序的块
 * @author: zr
 * @date: 2021-11-27 16:39
 **/
public class LC769_MaxChunksToMakeSorted {

    public static int maxChunks(int[] arr) {
        int max = 0, res = 0;
        for (int i = 0; i <  arr.length; ++i) {
            max = arr[i];
            if (max > i) {
                while (i < max) {
                    ++i;
                    max = Math.max(max, arr[i]);
                }
            }
            res++;
        }
        return res;

//        if (arr == null) return 0;
//        int ret = 0;
//        int right = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            right = Math.max(right, arr[i]);
//            if (right == i) ret++;
//        }
//        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,1,3,7,6,5,4};
        int res = maxChunks(arr);
        System.out.print(res);
    }
}
