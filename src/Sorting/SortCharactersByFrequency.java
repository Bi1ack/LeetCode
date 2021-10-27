package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zr
 * @date 2021.10.27
 */
public class SortCharactersByFrequency {
    public static String frequencySort_Heap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        return s;
    }

    //桶排序
    public static String frequencySort_Bucket(String s){
        int[][] ca = new int[128][2];
        for (int i = 0; i < 128; i++) {
            ca[i][0] = i;
        }
        char[] ch = s.toCharArray();
        for (char c : ch) ca[c][1]++;
        Arrays.sort(ca, new caComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            char c = (char) ca[i][0];
            int k = ca[i][1];
            while(k-- > 0) sb.append(c);
        }
        return sb.toString();
    }

    public static class caComparator implements Comparator<int[]> {
        // 返回负数时，第一个参数排前面
        // 返回正数时，第二个参数排前面
        @Override
        public int compare(int[] a, int[] b) {
            if (a[1] != b[1]) return b[1] - a[1];
            return a[0] - b[0];
        }
    }

    public static class descend implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        String s = "tree";
        s = frequencySort_Bucket(s);
        System.out.print(s);
        Integer[] arr = {1,4,2,1,5,2,6,213,6,12,5,123};
        Arrays.sort(arr, new descend());
        for (int a : arr) System.out.print(a + " ");
    }
}
