package CodeInterview;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 打印字符串的所有排序 /Hot/LC31
 * @author: Ray
 * @date: 2022-04-06 15:07
 **/
public class Code38_permutation {

    public static String[] permutation(String s) {

        //Set<String> ans = new HashSet<>();
        List<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        boolean[] isVisited = new boolean[s.length()];
        backtrack(ans, s, sb, isVisited);
        return ans.toArray(new String[0]);
    }

    private static void backtrack(List<String> ans, String s, StringBuffer sb, boolean[] isVisited) {
        if (sb.length() == s.length()) {
            ans.add(sb.toString());
            return ;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                sb.append(s.charAt(i));
                backtrack(ans, s, sb, isVisited);
                isVisited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    static List<String> rec;
    static boolean[] vis;

    public static String[] permutation_(String s) {
        int n = s.length();
        rec = new ArrayList<String>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backtrack(arr, 0, n, perm);
        int size = rec.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i);
        }
        return recArr;
    }

    public static void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            // 剪枝 对于连续的重复字符，每次只选第一个没被选择的
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }


    public static void main(String[] args) {
        String s = "aab";
        String[] res = permutation_(s);
        System.out.println(Arrays.toString(res));
    }
}
