package CodeInterview.Code;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-27 15:00
 **/
public class Code18_isPalindrome {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                ++i;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                --j;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }
}
