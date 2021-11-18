package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 是否是回文数
 * @author: zr
 * @date: 2021-11-18 21:34
 **/
public class LC9_PalindromeNumber {


    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x = x / 10;
        }
        for (int i = 0; i < list.size() / 2; ++i) {
            if (list.get(i) != list.get(list.size() - i - 1)) return false;
        }
        return true;
    }

    // 不使用额外空间
    public boolean isPalindrome1(int x) {
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right / 10;
    }

}
