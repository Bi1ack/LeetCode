package CodeInterview.Code;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-05-06 10:56
 **/
public class Code37_aster {

    public static int[] asteroidCollision(int[] asteroids) {
        boolean[] isBoom = new boolean[asteroids.length];
        for (int i = 0; i < asteroids.length; ++i) {
            if (asteroids[i] < 0) {
                int j = i - 1;
                while (j >= 0) {
                    if (isBoom[j] || asteroids[j] < 0) {
                        --j;
                        continue;
                    }
                    if (Math.abs(asteroids[j]) == Math.abs(asteroids[i])) {
                        isBoom[i] = true;
                        isBoom[j] = true;
                        break;
                    } else if (Math.abs(asteroids[j]) > Math.abs(asteroids[i])) {
                        isBoom[i] = true;
                        break;
                    } else {
                        isBoom[j] = true;
                        --j;
                    }
                }
            }
        }
        int[] ans = new int[asteroids.length];
        int cnt = 0;
        for (int i = 0; i < asteroids.length; ++i) {
            if (!isBoom[i]) ans[cnt++] = asteroids[i];
        }
        return Arrays.copyOf(ans, cnt);
    }

    public int[] asteroidCollision_(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int ast: asteroids) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {-3,1};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }
}
