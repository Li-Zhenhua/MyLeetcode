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
        for (int i = 0; i < n/2; i++) {
            int temp = matrix[i][i];
            
        }

    }
}

public class Question48 {
    
}
