package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。
 * 每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */

 //单调栈的应用，可以设置前后哨兵减少一些判断
 //注意与一般单调栈不同，这里是存放索引值
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;
        if(n == 1) return heights[0];

        int[] newHeight = new int[n+2];
        System.arraycopy(heights, 0, newHeight, 1, n);
        n += 2; // 更新数组长度

        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        //前置哨兵节点
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while(newHeight[i] < newHeight[stack.peek()]){
                int tempHeight = newHeight[stack.pop()];
                //当左边的数等于当前的数的时候，可以合并求解，即直接从栈弹出
                while(newHeight[stack.peek()] == tempHeight) stack.pop();
                int tempLength = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, tempHeight * tempLength);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

public class Q84 {
    
}
