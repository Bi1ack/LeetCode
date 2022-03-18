package Hot;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-18 09:27
 **/
public class LC239_SlidingWindowMaximum {


    public static int[] sliding(int[] nums, int k) {
        // 延迟删除
        // 记录元素的值和下标
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if(b[0] != a[0]) return b[0] - a[0];
            else return b[1] - a[1];
        });
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; ++i) {
            maxHeap.add(new int[]{nums[i], i});
        }
        ans[0] = maxHeap.peek()[0];
        for (int i = k; i < nums.length; ++i) {
            // 每次删除元素， 重新构造堆耗时
            // 记录 index 下表， 如果堆顶元素不在窗口中则删除，否则继续向右滑动窗口
            maxHeap.add(new int[]{nums[i], i});
            while (maxHeap.peek()[1] < i - k + 1) {
                maxHeap.poll();
            }
            ans[i - k + 1] = maxHeap.peek()[0];
        }
        return ans;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 单调队列
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; ++i) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        ans[0] = nums[queue.getFirst()];
        for (int i = k; i < n; ++i) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            while (queue.getFirst() < i - k + 1) {
                queue.removeFirst();
            }
            ans[i - k + 1] = nums[queue.getFirst()];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7,2,4,9,3,12};
        int k = 4;
        int[] ans = maxSlidingWindow(nums, k);
//        int[] ans = sliding(nums, k);
        for (int a : ans) {
            System.out.println(a);
        }
    }

}
