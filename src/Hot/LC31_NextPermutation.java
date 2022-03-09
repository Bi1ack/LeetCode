package Hot;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-08 14:18
 **/
public class LC31_NextPermutation {
    public static void nextPermutation(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> stack1 = new LinkedList<>();
        int n = arr.length;
        stack.push(arr[n - 1]);
        int i = n - 2;
        while (i >= 0 && !stack.isEmpty()) {
            if (arr[i] >= stack.peek()) {
                stack.push(arr[i]);
                --i;
            } else {
                break;
            }
        }
        if (i < 0) {
            Arrays.sort(arr);
            return;
        }
        while (!stack.isEmpty()) {
            stack1.push(stack.poll());
            if (stack.isEmpty() || arr[i] > stack.peek()) {
                int tmp = arr[i];
                arr[i++] = stack1.poll();
                stack1.push(tmp);
                while (!stack.isEmpty()) {
                    stack1.push(stack.poll());
                }
            }
        }
        while (!stack1.isEmpty()) {
            arr[i++] = stack1.poll();
        }
    }

    public static void nextPermutation_(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        // 从后往前找到第一个下降的数的位置 i
        while (i >= 0) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
            --i;
        }
        if (i < 0) {
            Arrays.sort(arr);
            return;
        }
        int nextMax = Integer.MAX_VALUE;
        int j = n - 1;
        while (j > i) {
            if (arr[j] > arr[i] && arr[j] < nextMax) {
                nextMax = arr[j];
                break;
            }
            --j;
        }
        swap(arr, i, j);
        reverse(arr, i);
    }

    public void nextPermutation__(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] arr, int i) {
        // 从位置 i 开始后面的数据逆序
        int k = arr.length - 1;
        for (int j = i + 1; j < k; j++) {
            swap(arr, j, k--);
        }
    }




    public static void main(String[] args) {
        int[] arr = {5,2,2};
        nextPermutation(arr);
    }

}
