package Perday;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zr
 * @date 2021.11.1
 */
public class DistributeCandies {
    public int distributeCandies(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int a : arr) set.add(a);
        return Math.min(set.size(), (arr.length / 2));
    }
}
