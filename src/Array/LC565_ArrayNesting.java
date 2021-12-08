package Array;

/**
 * @program: LeetCode
 * @description: 嵌套数组
 * @author: zr
 * @date: 2021-11-24 10:43
 **/
public class LC565_ArrayNesting {

    // 注意：
    // 嵌套数组形成一个闭环，不管从哪个元素访问都会回到自身，而不会访问到另外的数
    // 因此， 为了避免重复访问一些元素，可以将访问过的元素做标记
    // 用一个额外的visited数组，空间O(n)
    // 修改原数组 O(1)
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; nums[j] != -1; ) {
                cnt++;
                int t = nums[j];
                nums[j] = -1; // 标记该位置已经被访问
                j = t;

            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
