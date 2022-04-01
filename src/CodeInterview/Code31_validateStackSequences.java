package CodeInterview;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-01 10:56
 **/
public class Code31_validateStackSequences {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length <= 2) return true;
        Deque<Integer> stack = new ArrayDeque<>();
        int p = 0;
        for (int i = 0; i < popped.length; ) {
            while (stack.isEmpty() || (p < pushed.length && stack.peek() != popped[i])) {
                stack.push(pushed[p++]);
            }
            while (!stack.isEmpty()) {
                if (i < popped.length && stack.peek() == popped[i]) {
                    stack.pop();
                    ++i;
                } else if (i == popped.length || p == pushed.length) {
                    return false;
                } else {
                    break;
                }
            }
        }
        return true;
    }

    public boolean validateStackSequences_(int[] pushed, int[] popped) {
        int N = pushed.length;
        Deque<Integer> stack = new ArrayDeque();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;
    }

    public static void main(String[] args) {
        int[] pushed = {2,1,3,0,4,5,6,7,8,9,12};
//        int[] popped = {1,3,0,2};
        int[] popped = pushed.clone();
        ArrayUtils.shuffle(popped);
        System.out.println(Arrays.toString(popped));
        System.out.println(validateStackSequences(pushed, popped));
    }
}

class ArrayUtils {

    private static Random rand = new Random();

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void shuffle(int[] arr) {
        int length = arr.length;
        for (int i = length; i > 0; i--) {
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }
    }
}