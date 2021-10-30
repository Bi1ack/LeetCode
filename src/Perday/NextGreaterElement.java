package Perday;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zr
 * @date 2021.10.26
 */
public class NextGreaterElement {
    //双指针 O(mn)
    public static int[] nextGreaterElement(int[] arr1, int[] arr2){
        int p = 0, q = 0;
        int[] res = new int[arr1.length];
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            while (arr1[p] != arr2[q]) q++;
            while (++q < arr2.length && arr1[p] > arr2[q]);
            if (q < arr2.length) {
                res[count++] = arr2[q];
            } else {
                res[count++] = -1;
            }
            p++;
            q = 0;
        }
        return res;
    }

    //单调栈 + 哈希表 O(m + n)
    public static int[] nextGreaterElement_(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = arr2.length - 1; i >= 0; --i) {
            int num = arr2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; ++i) {
            res[i] = map.get(arr1[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{2,4,3,7,1};
        int[] arr2 = new int[]{1,2,3,4,5,6,7};
        int[] res;
        res = nextGreaterElement_(arr1, arr2);
        for (int a : res) System.out.print(a + " ");
    }
}
