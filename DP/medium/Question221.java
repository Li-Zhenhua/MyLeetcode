package DP.medium;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，
 * 找到只包含 '1' 的最大正方形，并返回其面积。
 */

/*class Solution {
    public int maximalSquare(char[][] matrix) {
        //m行n列
        int m = matrix.length, n = matrix[0].length;
        //dp[i][j]为左上角元素
        int[][] dp = new int[m][n];
        //这个是最大边长
        int max = 0;
        //边界条件
        for (int i = 0; i < n; i++) {
            dp[m-1][i] = matrix[m-1][i]-'0';
            max = Math.max(max, dp[m-1][i]);
        }
        for (int i = 0; i < m-1; i++) {
            dp[i][n-1] = matrix[i][n-1]-'0';
            max = Math.max(max, dp[i][n-1]);
        }

        //构造dp数组并记录最大值
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                //因为初始化的时候就是默认等于0，其实这里可以不用判断这个
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1]))+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}*/

//官方的写法，该方法认为dp[i][j]为右下角元素
class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}

//或者预处理添加一列一行
/*public int maximalSquare(char[][] matrix) {
    // base condition
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

    int height = matrix.length;
    int width = matrix[0].length;
    int maxSide = 0;

    // 相当于已经预处理新增第一行、第一列均为0
    int[][] dp = new int[height + 1][width + 1];

    for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
            if (matrix[row][col] == '1') {
                dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;
                maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
            }
        }
    }
    return maxSide * maxSide;
}*/

public class Question221 {
    
}
