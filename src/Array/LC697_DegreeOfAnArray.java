package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 等于数组的度的最短子数组
 * @author: zr
 * @date: 2021-11-23 16:26
 **/
public class LC697_DegreeOfAnArray {

    public int find(int[] arr) {
        // 出现次数， 第一次出现位置， 最后一次出现位置
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        int maxDegree = 0;
        for (int i = 0; i < arr.length; ++i) {
            int c = count.getOrDefault(arr[i], 0) + 1;
            maxDegree = Math.max(maxDegree, c);
            count.put(arr[i], c);
            if(!first.containsKey(arr[i])) {
                first.put(arr[i], i);
            } else {
                last.put(arr[i], i);
            }
        }
        // 所有数都只出现1次
        if (last.isEmpty()) return 1;
        int minLength = arr.length;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if(entry.getValue() == maxDegree) {
                minLength = Math.min(minLength, last.get(entry.getKey()) - first.get(entry.getKey()) + 1);
            }
        }
        return minLength;
    }

    // 思路相同，代码优化
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) { // 找出现次数最多的
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) { // 出现次数等于max，找其中最短的子数组
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }
}
