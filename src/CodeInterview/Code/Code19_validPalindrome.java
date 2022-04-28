package CodeInterview.Code;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-27 15:20
 **/
public class Code19_validPalindrome {

    static boolean isDelete = false;
    public static boolean validPalindrome(String s) {

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (!isDelete) isDelete = true;
                else return false;
                return validPalindrome(s.substring(left, right)) ||
                        validPalindrome(s.substring(left + 1, right + 1));
            }
            ++left;
            --right;
        }
        return true;
    }
    /*-------------------------------------------------*/
    public boolean validPalindrome_(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                ++low;
                --high;
            } else {
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(validPalindrome(s));
    }
}
