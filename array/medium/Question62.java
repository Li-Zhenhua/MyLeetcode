package array.medium;

/**
 * 
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。
机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？
 */

 //动态规划，找到转移方程即可
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        //最右侧一列
        for (int i = 0; i < m-1; i++) {
            dp[i][n-1] = 1;
        }
        //最底侧一行
        for (int i = 0; i < n-1; i++) {
            dp[m-1][i] = 1;
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}

//优化空间复杂度
/*class Solution {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        //每一次以一行为基准，反向计算
        //每轮外循环就相当于将向下的走的可能路径数加起来
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                //将向右的走的可能路径数加起来
                //注意，这里是反着来的，0序号对应最右侧
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }
}*/


//官方组合数法，震惊我一秒钟
/**
 * 从左上角到右下角的过程中，我们需要移动 m+n-2次，
 * 其中有 m-1次向下移动，n-1次向右移动。因此路径的总数，
 * 就等于从 m+n-2次移动中选择 m-1次向下移动的方案数，
 * 即组合数C
 */

/*class Solution {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}*/

public class Question62 {
    
}
