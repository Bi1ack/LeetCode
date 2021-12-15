package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 根据身高重建队列
 * @author: zr
 * @date: 2021-12-08 16:51
 **/
public class LC406_QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        // example:
        // 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        // 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        // 按身高降序排列， 同一身高， 按前面有多少更高的人升序排列
        // 按排序之后的顺序插入， 每次插入之前的序列中都是更高的人， 只需要按照前面有多少人插入对应的位置即可
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[res.size()][]);
    }
}
