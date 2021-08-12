package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个仅包含 0 和 1 、
 * 大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */

 //卧槽，看了题解才知道这道题就是84题的扩展,学会了84题其实就会85题
 //按行扫描，每一行都做一次底层，每次都执行找柱状图的最大面积
class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int rows = matrix.length;
        if(rows == 0) return 0;
        int colomns = matrix[0].length;
        
        

        int ans = 0;
        int[] height = new int[colomns+2]; //增加两个哨兵节点
        colomns = colomns + 2; //更新列数
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            //从新数组的第二列开始，第一个和最后一个是哨兵节点
            for (int j = 1; j < colomns-1; j++) {
                if(matrix[i][j-1] == '1'){
                    height[j]++;
                }else{
                    //某一层为‘0’那么就要将柱子高度重新置为0
                    height[j] = 0;
                }
            }

            stack.push(0); //栈存放每个柱子的索引
            for (int j = 1; j < colomns; j++) {
                while(height[j] < height[stack.peek()]){
                    int h = height[stack.pop()];
                    while(height[stack.peek()] == h) stack.pop();
                    ans = Math.max(ans, h*(j-stack.peek()-1));
                }
                stack.push(j);
            }

        }
        return ans;
    }
}

public class Q85 {
    
}
