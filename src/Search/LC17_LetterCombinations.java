package Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-18 10:23
 **/
public class LC17_LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) return combinations;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(combinations, digits, 0, new StringBuffer(), map);

        return combinations;
    }

    public static void backtrack(List<String> combinations, String digits, int index, StringBuffer combination, Map<Character, String> map){
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            String letters = map.get(digits.charAt(index));
            for (int i = 0; i < letters.length(); ++i) {
                combination.append(letters.charAt(i));
                backtrack(combinations, digits, index + 1, combination, map);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        for (String s : res) {
            System.out.print(s + " ");
        }
    }

}
