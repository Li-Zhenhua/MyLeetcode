package 每日一题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。

请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。

如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。

军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 */

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            //其实也可以用二分
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 0) break;
                count++;
            }
            list.add(new int[]{count,i});
        }
        Collections.sort(list, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            else{
                return a[1] - b[1];
            }
        });
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i)[1];
        }
        return ans;
    }
}

public class _8_1_Q1337 {
    
}
