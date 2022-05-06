package CodeInterview.Code;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-05-06 10:06
 **/
public class Code36_evalRPN {

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; ++i) {
            if (tokens[i].length() > 1 || (tokens[i].compareTo("0") >= 0 && tokens[i].compareTo("9") <= 0)) {
                stack.push(Integer.parseInt(tokens[i]));
                continue;
            }

            int tmp = 0;
            if (tokens[i].equals("+")) {
                tmp = stack.pop() + stack.pop();
            } else if (tokens[i].equals("-")) {
                int t1 = stack.pop();
                tmp = stack.pop() - t1;
            } else if (tokens[i].equals("*")) {
                tmp = stack.pop() * stack.pop();
            } else {
                int t2 = stack.pop();
                tmp = stack.pop() / t2;
            }
            stack.push(tmp);

        }

        return stack.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        List<String> list = Arrays.asList(tokens);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(Arrays.toString(Arrays.copyOf(tokens, 3)));
        System.out.println(evalRPN(tokens));
    }
}
