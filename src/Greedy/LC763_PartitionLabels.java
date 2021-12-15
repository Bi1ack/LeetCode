package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: zr
 * @date: 2021-12-15 11:02
 **/
public class LC763_PartitionLabels {

    public static List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            arr[ch - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int end = arr[ch -'a'];
            int start = i;
            for (int j = start; j < end; ++j) {
                ++i;
                if (arr[s.charAt(j) - 'a'] > end){
                    end = arr[s.charAt(j) - 'a'];
                }
            }
            res.add(end - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "eccbbbbdec";
        partitionLabels(s);
    }

}
