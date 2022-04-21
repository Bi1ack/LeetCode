package CodeInterview.Code;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j]
 * 不包含相同字符时，它们长度的乘积的最大值。
 * @author: Ray
 * @date: 2022-04-21 10:37
 **/
public class Code05_maxProduct {

    public int maxProduct(String[] words) {
        int length = words.length;
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

}
