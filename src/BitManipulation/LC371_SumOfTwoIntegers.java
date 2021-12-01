package BitManipulation;

/**
 * @program: LeetCode
 * @description: 两数之和， 不使用 +，-
 * @author: zr
 * @date: 2021-12-01 10:22
 **/
public class LC371_SumOfTwoIntegers {

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;

        // return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
