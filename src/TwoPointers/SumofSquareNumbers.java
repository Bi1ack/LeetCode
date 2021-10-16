package TwoPointers;

import java.util.Scanner;

public class SumofSquareNumbers {
    /*
    @date: 2021/10/16
    @633 Sum of Square Numbers
     */

    public static boolean judgeSquareSum(int c) {
        long p = 0;
        double t = Math.sqrt(c);
        long q = (long) t;
        while(p <= q) {
            if ((p * p + q * q) > c) {
                q--;
            } else if ((p * p + q * q) < c) {
                p++;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int num = 2147483600;
        boolean res;
        res = judgeSquareSum(num);
        System.out.print(res);
    }
}
