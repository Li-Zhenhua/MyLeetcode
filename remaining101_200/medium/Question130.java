package remaining101_200.medium;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 解释：
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */

class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        if(rows <= 2 || columns <= 2) return;
        //暂时只想到两轮搜索，第一轮先找到所有与边界的'O'相邻的'O'，dfs
        if(rows <= 2 || columns <= 2) return;
        for (int i = 0; i < rows; i++) {
            //第一列和最后一列，即左右边界
            dfs(board, i, 0);
            dfs(board, i, columns-1);
        }
        for (int i = 1; i < columns-1; i++) {
            //上下边界
            dfs(board, 0, i);
            dfs(board, rows-1, i);
        }

        //第二轮将未标记过的'O'改成'X'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(board[i][j] == 'Y'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int column){
        int m = board.length, n = board[0].length;
        if(row < 0 || row >= m || column < 0 || column >= n){
            return;
        }
        if(board[row][column] == 'O'){
            board[row][column] = 'Y';
            dfs(board, row+1, column);
            dfs(board, row-1, column);
            dfs(board, row, column+1);
            dfs(board, row, column-1);
        }
    }
}

public class Question130 {
    
}
