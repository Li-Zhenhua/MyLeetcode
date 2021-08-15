package 每日一题;

/**
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。

给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 */

 //想到用动态规划了，但是没想到竟然是用三维数组的dp
 //dp[i][j][k] 表示经过i次移动之后，能够移动到坐标（j，k）的个数
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1000000007;
        int[][][] dp = new int[maxMove+1][m][n];
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int ans = 0;
        dp[0][startRow][startColumn] = 1;
        for (int i = 1; i <= maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int preCount = dp[i-1][j][k];
                    //获取用i-1步到达（j，k）的路径个数
                    if(preCount != 0){
                        for (int[] direction : directions) {
                            int nextJ = j + direction[0];
                            int nextK = k + direction[1];
                            //因为direction保证一次只可能在下面这四个中满足一个条件成立
                            //所以不用分开判断分开加
                            if(nextJ < 0 || nextJ >= m || nextK  < 0 || nextK >= n){
                                ans = (ans + preCount) % MOD;
                                continue;
                            }
                            //更新dp[i][nextJ][nextK]，注意也要mod
                            dp[i][nextJ][nextK] = (dp[i][nextJ][nextK] + preCount) % MOD;
                        }
                    }
                }
            }
        }
        return ans;
    }
}

public class _8_15_Q576 {
    
}
