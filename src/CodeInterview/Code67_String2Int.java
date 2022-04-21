package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-16 10:56
 **/
public class Code67_String2Int {

    public static int strToInt(String s) {
        s = s.trim();
        if (s.charAt(0) != '-' && s.charAt(0) != '+'
                && s.charAt(0) > '9' && s.charAt(0) < '0') {
            return 0;
        }
        int sign = 0;
        long ans = 0L;
        for (int i = 0; i < s.length(); ++i) {
            if(i == 0) {
                if(s.charAt(i) == '-') {
                    sign = 1;
                    continue;
                } else if(s.charAt(i) == '+'){
                    sign = 2;
                    continue;
                }
            }
            if (s.charAt(i) > '9' || s.charAt(i) < '0')
                return sign == 1? -(int)ans : (int)ans;
            ans = (ans * 10 + (s.charAt(i) - '0'));
            if(ans > Integer.MAX_VALUE) {
                return sign == 1? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return sign == 1? -(int)ans : (int)ans;
    }

    public static int strToInt_(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > bndry || res == bndry && c[j] > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }




    public static void main(String[] args) {
        System.out.println(strToInt_("-2147483648"));
    }
}
