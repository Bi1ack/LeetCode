package Perday;


public class NumberComplement {
    /**
     * @author zr
     * @date 2021.10.18
     * @test
     */

    public static int findComplement(int num) {
        int high = 0;
        int tmp = num;
        while (tmp != 1) {
            tmp = tmp >> 1;
            high++;
        }
        while (high != 0) {
            tmp = 1 + (tmp << 1);
            high--;
        }
        return num ^ tmp;
    }

    public int findComplement1(int num) {
        int mask = num;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;
        return (mask ^ num);
    }

    public static void main(String[] args) {
        int a = 17;
        int res = findComplement(a);
        System.out.print(res);
    }
}
