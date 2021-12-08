package String;

/**
 * @program: LeetCode
 * @description: ···
 * @author: zr
 * @date: 2021-11-18 21:38
 **/
public class LC696_CountBinarySubstrings {

    // woshicaibi
    public static int countBinarySubstrings(String s) {
        int n = s.length();
        int res = 0;
        int pre = 0;
        int i = 0;
        while(i < s.length()) {
            int cur = 0;
            char c = s.charAt(i);
            while (i < s.length() && s.charAt(i) == c) {
                cur++;
                i++;
            }
            res += Math.min(pre, cur);
            pre = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "10101";
        int res = countBinarySubstrings(s);
        System.out.print(res);
    }

}
