package TwoPointers;


public class ValidPalindrome2 {
    /**
     * @Author zr
     * @Date 2021.10.18
     */

    public static boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                ++low;
                --high;
            } else {
                return isvalidPalindrome(s, low, high - 1) || isvalidPalindrome(s, low + 1, high);
            }
        }
        return true;
    }

    public static boolean isvalidPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "acxcybycxcxa";
        boolean res = validPalindrome(s);
        System.out.print(res);
    }
}
