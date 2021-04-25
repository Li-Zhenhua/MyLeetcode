package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，
 * 其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，
 * 该数组需恰好覆盖输入中的所有区间。

 */

class Solution {
    public int[][] merge(int[][] intervals) {
        //二维数组按行排序
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int pre = list.get(list.size()-1)[1];
            if(pre < intervals[i][0]){
                list.add(intervals[i]);
            } else {
                int maxRight = Math.max(pre, intervals[i][1]);
                list.get(list.size()-1)[1] = maxRight;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

public class Question56 {
    
}
