package array.medium;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，
 * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。
 */

 //一般的dp
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        for (int i = 1; i < m; i++) {
            dp[m-i-1][n-1] = dp[m-i][n-1]+grid[m-i-1][n-1];
        }
        for (int i = 1; i < n; i++) {
            dp[m-1][n-i-1] = dp[m-1][n-i]+grid[m-1][n-i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[m-i-1][n-j-1] = Math.min(dp[m-i-1][n-j], dp[m-i][n-j-1]) + grid[m-i-1][n-j-1];
            }
        }
        return dp[0][0];
    }
}
//优化后

public class Question64 {
    
}

    