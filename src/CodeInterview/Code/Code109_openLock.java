package CodeInterview.Code;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Code109_openLock {

    public static int openLock(String[] deadends, String target) {
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        int ans = 0;
        Set<String> set = new HashSet<>();
        for (String d : deadends) {
            set.add(d);
        }
        Set<String> set1 = new HashSet<>();
        set1.add("0000");
        while (!queue.isEmpty()) {
            ++ans;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String sb = queue.poll();
                for (int j = 0; j < 4; ++j) {
                    int t = sb.charAt(j) - '0';
                    String s1 = sb.substring(0, j) + (t + 1) % 10 + sb.substring(j + 1, 4);
                    if (s1.equals(target)) return ans;
                    if (set.contains(s1)) continue;
                    if (!set1.contains(s1)) {
                        set1.add(s1);
                        queue.offer(s1);
                    }
                }
                for (int j = 0; j < 4; ++j) {
                    int t = sb.charAt(j) - '0';
                    String s1 = sb.substring(0, j) + (t + 9) % 10 + sb.substring(j + 1, 4);
                    if (s1.equals(target)) return ans;
                    if (set.contains(s1)) continue;
                    if (!set1.contains(s1)) {
                        set1.add(s1);
                        queue.offer(s1);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.print(openLock(deadends, target));
    }
}
