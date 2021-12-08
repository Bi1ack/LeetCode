package BinarySearch;

/**
 * @program: LeetCode
 * @description: 寻找比目标字母更大的最小字母
 * @author: zr
 * @date: 2021-12-03 16:08
 **/
public class LC744_FindSmallestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return letters[low % letters.length];
    }
}
