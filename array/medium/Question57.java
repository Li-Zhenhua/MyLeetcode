package array.medium;

import java.util.Arrays;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，
你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */

 /**
  * 考虑过程要清楚明了一点，其实就可以分成下面的步骤：
  * 1、首先将新区间左边且相离的区间加入结果集
  （遍历时，如果当前区间的结束位置小于新区间的开始位置，
  说明当前区间在新区间的左边且相离）；

    2、接着判断当前区间是否与新区间重叠，重叠的话就进行合并，
    直到遍历到当前区间在新区间的右边且相离，
    将最终合并后的新区间加入结果集；

    3、最后将新区间右边且相离的区间加入结果集。

  */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if(n == 0) return new int[][]{newInterval};
        int[][] ans = new int[n+1][2];
        int index = 0;
        boolean flag = false;
        int minNum = newInterval[0];
        int maxNum = newInterval[1];
        for (int i = 0; i < n; i++) {
            //有合并区间段的左侧区间
            if(intervals[i][0] > maxNum){
                if(flag == false){
                    //插入新区间
                    int[] temp = new int[]{minNum,maxNum};
                    ans[index++] = temp;
                    flag = true;
                }
                ans[index++] = intervals[i];
            } else if(intervals[i][1] < minNum){
                //合并区间段的右侧区间
                ans[index++] = intervals[i];
            } else {
                //合并区间段
                minNum = Math.min(intervals[i][0], minNum);
                maxNum = Math.max(intervals[i][1], maxNum);
                //ans[index++] = new int[]{minNum,maxNum};
            } 
        }
        //新加入的区间为最大的区间时
        if(flag == false){
            ans[index++] = new int[]{minNum,maxNum};
        }
        return Arrays.copyOf(ans, index);
    }
}

public class Question57 {
    
}
