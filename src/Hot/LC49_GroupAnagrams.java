package Hot;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 具有相同字符的放到一组
 * @author: Ray
 * @date: 2022-03-10 17:15
 **/
public class LC49_GroupAnagrams {
    public static List<List<String>> group (String[] s) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] isAdd = new boolean[s.length];
        for (int i = 0; i < s.length; ++i) {
            if (isAdd[i]) continue;
            List<String> list = new ArrayList<>();
            list.add(s[i]);
            isAdd[i] = true;
            for (int j = i + 1; j < s.length; j++) {
                if (isSame(s[i], s[j])) {
                    list.add(s[j]);
                    isAdd[j] = true;
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static boolean isSame(String s1, String s2){
        int[] cnt = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            cnt[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); ++i) {
            cnt[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }


    public static void main(String[] args) {
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(s));
    }

}
