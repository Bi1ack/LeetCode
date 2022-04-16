package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-13 11:11
 **/
public class Code58_reverseWords {

    public static String reverseString(String s) {
        String[] strs = s.trim().split("\\s+");
        for(int i = 0; i < strs.length / 2; ++i) {
            String sTmp = strs[i];
            strs[i] = strs[strs.length - i - 1];
            strs[strs.length - i - 1] = sTmp;
        }
        StringBuffer sb = new StringBuffer();
        for(String s1 : strs) {
            sb.append(s1).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String reverseLeftWords(String s, int n) {
        if (n % s.length() == 0) return s;
        int len = s.length();
        n = n % len;
        StringBuffer sb = new StringBuffer();
        s = s + s;
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i + n));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "lrloseumgh";
        System.out.println(3 % 4);
        System.out.println(reverseLeftWords(s, 116));
    }
}
