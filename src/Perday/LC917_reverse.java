package Perday;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2022-02-23 09:51
 **/
public class LC917_reverse {
    public static String reverseOnlyLetters(String s) {
        // 双指针 String不可变
        StringBuffer sb = new StringBuffer(s);
        int i = 0, j = sb.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetter(sb.charAt(i))) ++i;
            while (i < j && !Character.isLetter(sb.charAt(j))) --j;
            char ctmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, ctmp);
            ++i;
            --j;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(reverseOnlyLetters(s));
    }
}
