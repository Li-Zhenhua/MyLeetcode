package contest._6_27;

import java.util.ArrayDeque;
import java.util.Deque;

//直接依次旋转就行，就是刚开始那个下标搞得有点晕
/*class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int left = 0;
        int right = grid.length - 1;
        int top = 0;
        int down = grid[0].length - 1;


        while(left < right && top < down){
            //每一层的需要旋转次数
            int circle = k % ((right + down - left - top) * 2 );
            while(circle > 0){
                //直接模拟旋转，一次次转，这样来说相比下面的方法就慢了点
                int temp = grid[left][top];
                for(int j = top;j < down;)
                    grid[left][j++] = grid[left][j];
                for(int i = left;i < right;)
                    grid[i++][down] = grid[i][down];

                for(int j = down;j > top;j--){
                    grid[right][j] = grid[right][j - 1];
                }
                for(int i = right;i > left;i--){
                    grid[i][top] = grid[i - 1][top];
                }
                grid[left + 1][top] = temp;
                circle--;
            }
            
            top++;
            left++;
            right--;
            down--;
        }
        
        return grid;
    }  
}*/

//题解的一种写法
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        // 矩阵尺寸
        int m = grid.length, n = grid[0].length;
        // 计算一共有多少层
        int layerNumber = Math.min(m, n) / 2;
        // 逐层处理
        for (int i = 0; i < layerNumber; ++i) {
            // 计算出来当前层需要多大的数组来存放, 计算方法是当前层最大尺寸 - 内部下一层尺寸.
            int[] data = new int[(m - 2 * i) * (n - 2 * i) - (m - (i + 1) * 2) * (n - (i + 1) * 2)];
            int idx = 0;
            // 从左往右
            for (int offset = i; offset < n - i - 1; ++offset)
                data[idx++] = grid[i][offset];
            // 从上往下
            for (int offset = i; offset < m - i - 1; ++offset)
                data[idx++] = grid[offset][n - i - 1];
            // 从右往左
            for (int offset = n - i - 1; offset > i; --offset)
                data[idx++] = grid[m - i - 1][offset];
            // 从下往上
            for (int offset = m - i - 1; offset > i; --offset)
                data[idx++] = grid[offset][i];
            // 把旋转完的放回去
            Integer[] ret = rotateVector(data, k);
            idx = 0;
            // 从左往右
            for (int offset = i; offset < n - i - 1; ++offset)
                grid[i][offset] = ret[idx++];
            // 从上往下
            for (int offset = i; offset < m - i - 1; ++offset)
                grid[offset][n - i - 1] = ret[idx++];
            // 从右往左
            for (int offset = n - i - 1; offset > i; --offset)
                grid[m - i - 1][offset] = ret[idx++];
            // 从下往上
            for (int offset = m - i - 1; offset > i; --offset)
                grid[offset][i] = ret[idx++];
        }
        return grid;
    }

    private Integer[] rotateVector(int[] vector, int offset) {
        // 取余, 否则会有无用功, 超时
        offset = offset % vector.length;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int item : vector) deque.add(item);
        // 旋转操作
        while (offset-- > 0) {
            //旋转其实就是将队首元素移到队尾了，所以要用双向链表模拟
            deque.addLast(deque.pollFirst());
        }
        //这里的new Integer[0]是将object数组转换成integer
        //其中0好像说是没有什么实际意义，主要是前面的类型重要
        return deque.toArray(new Integer[0]);
    }
}

public class Q2 {
    
}
