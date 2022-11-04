package JavaBasic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-04 16:23
 **/
public class test {

    public static boolean test (String s, String t) {
        if (s.length() > t.length()) return false;
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = start; j < t.length(); ++j) {
                while (j < t.length() && s.charAt(i) != t.charAt(j)) ++j;
                if (j == t.length()) return false;
                start = ++j;
                break;
            }
        }
        if (start >= t.length()) return false;
        return true;
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int empty = 0;
        int ans = 0;
        while (numBottles != 0) {
            ans += numBottles;
            empty = (empty + numBottles);
            numBottles = empty / numExchange;
            empty = empty % numExchange;
        }
        return ans;
    }

    public static class descend implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; ++i){
            int k = i;
            for (int j = i; j - k < groupSize - 1; ++j, ++i) {
                if (hand[j] + 1 != hand[j + 1])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> sites = new HashMap<>();

        // 往 HashMap 添加一些元素
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");

        // 返回所有value值组成的视图
        for(String value: sites.values()) {
            // 输出每一个value
            System.out.print(value + " ");
        }
    }

}
