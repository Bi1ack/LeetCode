package BitManipulation;

/**
 * @program: LeetCode
 * @description: 汉明距离
 * @author: zr
 * @date: 2021-11-29 16:28
 **/
public class LC461_HammingDistance {

    public static int hamming(int x, int y) {
        int tmp = x ^ y;
        int res = 0;
        while (tmp != 0) {
            res += tmp & 1;
            tmp = tmp >> 1;
        }
        return res;

        // 内置计数器
        // return Integer.bitCount(x ^ y);
        // bitCount 源码
//        public static int bitCount(int c) {
//          i = i - ((i >>> 1) & 0x55555555);
//          i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
//          i = (i + (i >>> 4)) & 0x0f0f0f0f;
//          i = i + (i >>> 8);
//          i = i + (i >>> 16);
//          return i & 0x3f;
//        }
    }

    // Brian Kernighan算法
    // 每个数 x 和 x - 1 与运算， 相当于把最右的1给删掉
    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }

    // 掩码
    //
    public static void main(String[] args) {
        int x = 31;
        int y = 16;
        int res = hamming(x,y);
        System.out.println(res);
    }
}
