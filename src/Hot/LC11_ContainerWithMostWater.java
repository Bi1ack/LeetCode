package Hot;

/**
 * @program: LeetCode
 * @description: 盛最多水的容器
 * @author: Ray
 * @date: 2022-03-07 09:28
 **/
public class LC11_ContainerWithMostWater {

    public int maxArea (int[] arr) {
        int left = 0, right = arr.length - 1;
        int ans = 0;
        while (left < right) {
            ans = Math.max(ans, (right- left) * Math.min(arr[left], arr[right]));
            if (arr[left] > arr[right]) {
                --right;
                continue;
            }
            ++left;
        }
        return ans;
    }
}
