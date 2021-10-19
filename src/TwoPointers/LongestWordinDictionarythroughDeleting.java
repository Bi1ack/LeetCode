package TwoPointers;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {
    /**
     * @author zr
     * @date 2021.10.19
     */

    public static String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary); //字典排序
        int n = dictionary.size();
        int max = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (isFindWord(s, dictionary.get(i))) {
                if (dictionary.get(i).length() > max) {
                    max = dictionary.get(i).length();
                    index = i;
                }

            }
        }
        if (index >= 0){
            return dictionary.get(index);
        } else {
            return "";
        }

    }

    public static boolean isFindWord(String s1, String s2) {
        int p = 0, q = 0;
        while (p < s1.length() && q < s2.length()) {
            if (s1.charAt(p) == s2.charAt(q)) {
                p++;
                q++;
            } else {
                p++;
            }
        }
        return q == s2.length();
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = new LinkedList<>();
        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("c");
        String res = findLongestWord(s,dictionary);
        System.out.print(res);
    }
}
