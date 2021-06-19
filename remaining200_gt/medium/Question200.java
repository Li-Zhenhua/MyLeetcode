package remaining200_gt.medium;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，
 * 请你计算网格中岛屿的数量。

岛屿总是被水包围，
并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

 
 */

 //就是dfs，没法用一次扫描就完成
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int high = grid.length, len = grid[0].length;
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < len; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int column){
        int rows = grid.length, columns = grid[0].length;
        if(row < 0 || row == rows || column < 0 || column ==columns
            || grid[row][column] == '0'){
            return;
        }
        //将对应点的‘1’设置成‘0’，表示已经计过数
        grid[row][column] = '0';

        /* if(grid[row-1][column] == '1'){
            dfs(grid, row-1, column);
        }
        if(grid[row+1][column] == '1'){
            dfs(grid, row+1, column);
        }
        if(grid[row][column-1] == '1'){
            dfs(grid, row, column-1);
        }
        if(grid[row][column+1] == '1'){
            dfs(grid, row, column+1);
        } */
        dfs(grid, row-1, column);
        dfs(grid, row+1, column);
        dfs(grid, row, column-1);
        dfs(grid, row, column+1);
    }
}

public class Question200 {
    
}
