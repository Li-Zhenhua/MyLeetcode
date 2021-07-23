package 每日一题;

/**
 * 
给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。

如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。

已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。

提示：

1 <= ranges.length <= 50
1 <= starti <= endi <= 50
1 <= left <= right <= 50
 */



class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] flag = new boolean[51];
        for (int i = 0; i < ranges.length; i++) {
            int indexLeft = ranges[i][0];
            int indexRight = ranges[i][1];
            for (int j = indexLeft; j <= indexRight; j++) {
                flag[j] = true;
            }

        }
        for (int i = left; i <= right; i++) {
            if(!flag[i]){
                return false;
            }
        }
        return true;
    }
}

public class _7_23_Q1893 {
    
}
