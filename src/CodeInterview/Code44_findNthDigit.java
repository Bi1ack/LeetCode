package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-07 10:27
 **/
public class Code44_findNthDigit {


    public static int findNthDigit(int n) {
        if (n < 10) return n;
        int bits = 0;
        int num = 0;
        int i = 0;
        while (true) {
            if (num % Math.pow(10, bits) == 0) {
                bits++;
            }
            if (i + bits <= n) {
                i += bits;
                num++;
            } else {
                break;
            }
        }

        int len = bits - n + i;
        int ans = -1;
        while (len != 0) {
            ans = num % 10;
            num /= 10;
            len--;
        }
        return ans;
    }

    public static int findNthDigit_(int n) {
        int digit = 1;
        long start = 1;
        long count = 10;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + n / digit; // 2.
        return Long.toString(num).charAt(n % digit) - '0'; // 3.
    }


    public static void main(String[] args) {
        int n = 20;
        System.out.println(findNthDigit_(n));
    }
}
