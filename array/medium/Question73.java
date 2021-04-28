package array.mediun;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，
 * 则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。

进阶：

一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个仅使用常量空间的解决方案吗？

 */

 //空间复杂度O(m+n)
/*class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //标记原始矩阵哪一行有0
        boolean[] flagRow = new boolean[m];
        //标记原始矩阵哪一列有0
        boolean[] flagColumn = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    flagRow[i] = true;
                    flagColumn[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(flagRow[i] == true || flagColumn[j] == true){
                    matrix[i][j]=0;
                }
            }
        }
    }
}*/

//优化后常数空间复杂度
/**
 * 关键思想: 用matrix第一行和第一列记录该行该列是否有0,作为标志位

但是对于第一行,和第一列要设置一个标志位,
为了防止自己这一行(一列)也有0的情况

 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        // 原始第一列是否有零
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        // 原始第一行是否有零
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        //利用除了一行一列之外的元素重置第一行第一列，
        //即设置O(m+n)方法的标记数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        //反过来，利用第一行第一列元素重置其余元素
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //原始第一列中的0元素所在的列置零
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        //原始第一行中的0元素所在的行置零
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}


public class Question73 {
    
}
