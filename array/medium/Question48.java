package array.medium;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。
 * 请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。
请不要 使用另一个矩阵来旋转图像。

 */

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //int[] temp = new int[n];
        //temp = matrix[0];
        int skip;
        int temp;
        //对角元素
        for (int i = 0; i < n/2; i++) {
            skip = n - 1 - 2*i;
            temp = matrix[i][i];
            matrix[i][i] = matrix[i+skip][i];
            matrix[i+skip][i] = matrix[i+skip][i+skip];
            matrix[i+skip][i+skip] = matrix[i][i+skip];
            matrix[i][i+skip] = temp;
        }
        //非对角其他元素，分组
        for (int i = 0; i < n/2; i++) {
            for (int j = i+1; j < n -1 - i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }

    }
}

public class Question48 {
    
}
