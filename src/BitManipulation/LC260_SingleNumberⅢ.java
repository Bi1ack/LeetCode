package BitManipulation;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: LeetCode
 * @description: ···
 * @author: zr
 * @date: 2021-11-29 17:09
 **/
public class LC260_SingleNumberⅢ {

    // 位运算
    //  x & -x -> 找到最低位的1
    public static int[] singleNumber(int[] arr) {
        if (arr.length == 2) return arr;
        int num1 = 0;
        // 得到两个不同的数的异或结果
        for (int n : arr) {
            num1 ^= n;
        }
        // 找到最低不同位
        int bit = 1;
        while ((num1 & bit) == 0) {
            bit <<= 1;
        }
        int a = 0, b = 0;
        for (int n : arr) {
            // 元素分组，相同的元素一定分在一组
            if ((n & bit) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 4, 4, 3};
        System.out.print(Arrays.toString(singleNumber(arr)));
    }
}
