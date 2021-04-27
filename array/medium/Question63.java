package array.medium;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。
机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //最后到达的位被障碍物占领，那么就不可能到达
        if(obstacleGrid[m-1][n-1] == 1) return 0;

        //只有一行
        if(m==1){
            while(--n >=0){
                if(obstacleGrid[0][n] == 1) return 0;
            }
            return 1;
        }

        //只有一列
        if(n==1){
            while(--m >=0){
                if(obstacleGrid[m][0] == 1) return 0;
            }
            return 1;
        }

        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        boolean flag = false;
        for (int i = m-2; i >= 0; i--) {
            if(flag == false && obstacleGrid[i][n-1] == 0){
                dp[i][n-1] = 1;
            }else if (obstacleGrid[i][n-1] == 1){
                flag = true;
            }
        }

        flag = false;
        for (int i = n-2; i >= 0; i--) {
            if(flag == false && obstacleGrid[m-1][i] == 0){
                dp[m-1][i] = 1;
            }else if (obstacleGrid[m-1][i] == 1){
                flag = true;
            }
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}

//简化空间复杂度


public class Question63 {
    
}
