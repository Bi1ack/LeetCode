package CodeInterview;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-07 14:41
 **/
public class Code45_minNumber {

    public static String minNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            arr[i] = nums[i];
        }
        // 返回负数时，第一个参数排前面
        // 返回正数时，第二个参数排前面
        Arrays.sort(arr, (a, b) ->
            compare(String.valueOf(a), String.valueOf(b))
        );
        StringBuffer sb = new StringBuffer();
        for (Integer n : arr) {
            sb.append(n);
        }
        return sb.toString();
    }

    private static int compare(String a, String b) {
        if (a.equals(b)) return 0;
        int bit = 0;
        while (bit < a.length() || bit < b.length()) {
            char ai = bit < a.length() ? a.charAt(bit) : a.charAt(0);
            char bi = bit < b.length() ? b.charAt(bit) : b.charAt(0);
            if (ai - bi > 0) {
                return 1;
            } else if (ai - bi < 0) {
                return -1;
            } else if (bit >= a.length()) {
                for (int i = 0; i < a.length(); ++i) {
                    if (a.charAt(i) > b.charAt(bit)) {
                        return 1;
                    } else if (a.charAt(i) < b.charAt(bit)) {
                        return -1;
                    }
                }
            } else if (bit >= b.length()) {
                for (int i = 0; i < b.length(); ++i) {
                    if (b.charAt(i) > a.charAt(bit)) {
                        return -1;
                    } else if (b.charAt(i) < a.charAt(bit)) {
                        return 1;
                    }
                }
            }
            bit++;
        }
        return 0;
    }

    public String minNumber_(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }


    public static void main(String[] args) {
        int[] nums = {824,8247};
        System.out.println(minNumber(nums));
    }
}
