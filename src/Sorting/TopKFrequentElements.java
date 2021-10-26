package Sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zr
 * @date 2021.10.25
 * @describe Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements {
    public static int[] topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int t = nums.getOrDefault(arr[i], 0);
            nums.put(arr[i],  t + 1);
        }
        int[] unique = new int[k];
//        int[] frequence = new int[nums.size()];
        int heapSize = 0;
        for (Map.Entry<Integer, Integer> entry : nums.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (heapSize < k - 1) {
                unique[heapSize++] = num;
            } else if (heapSize == k - 1){
                unique[heapSize] = num;
                //heapify(nums, unique, 0 , k);
                for (int i = 0; i < k; i++) {
                    heapInsert(nums, unique, i);
                }
                heapSize++;
            } else {
                if (nums.get(unique[0]) < count) {
                    unique[0] = num;
                    heapify(nums, unique, 0, k);
                }
            }
        }

        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            res[j] = unique[j];
        }
        return res;
    }

    public static void heapInsert(Map<Integer, Integer> nums, int[] arr, int index) {
        int par = (index - 1) / 2;
        while (par >= 0 && nums.get(arr[index]) < nums.get(arr[par])) {
            swap(arr, index, par);
            index = par;
            par = (index - 1) / 2;
        }
    }

    public static void heapify(Map<Integer, Integer> nums, int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int min;
            min = heapSize > left + 1 && nums.get(arr[left]) > nums.get(arr[left + 1]) ? left + 1 : left;
            min = nums.get(arr[min]) < nums.get(arr[index]) ? min : index;
            if (min == index) {
                break;
            } else {
                swap(arr, index, min);
                index = min;
                left = 2 * index + 1;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,0,1,4,9,7,-3,1,-4,-8,4,-7,-3,3,2,-3,9,5,-4,0};
        int k = 6;
        int[] res = new int[k];
        res = topKFrequent(arr, k);
        for (int r : res) System.out.println(r);
    }
}
