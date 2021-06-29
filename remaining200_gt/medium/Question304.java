package remaining200_gt.medium;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，
 * 该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)
 * 
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 */

 //二维前缀和
/*class NumMatrix {

    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        sumMatrix = new int[rows][columns];
        sumMatrix[0][0] = matrix[0][0];
        //第一列
        for (int i = 1; i < rows; i++) {
            sumMatrix[i][0] = sumMatrix[i-1][0] + matrix[i][0];
        }
        for (int i = 1; i < columns; i++) {
            sumMatrix[0][i] = sumMatrix[0][i-1] + matrix[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                sumMatrix[i][j] = matrix[i][j] + sumMatrix[i-1][j] 
                + sumMatrix[i][j-1] - sumMatrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = sumMatrix[row2][col2];
        if(row1 > 0 && col1 > 0){
            ans += sumMatrix[row1-1][col1-1];
        }


        if(row1 > 0){
            ans -= sumMatrix[row1-1][col2];
        }

        if(col1 > 0){
            ans -= sumMatrix[row2][col1-1];
        }
        return ans;
    }
}*/

//别人简化了上面的判断过程的办法
class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = n == 0 ? 0 : matrix[0].length;
        // 与「一维前缀和」一样，前缀和数组下标从 1 开始，因此设定矩阵形状为 [n + 1][m + 1]（模板部分）
        sum = new int[n + 1][m + 1];
        // 预处理除前缀和数组（模板部分）
        //这部分就使得下面不需要额外判断某一边处于0边界的情况
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int x1, int y1, int x2, int y2) {
        // 求某一段区域和 [i, j] 的模板是 sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];（模板部分）
        // 但由于我们源数组下标从 0 开始，因此要在模板的基础上进行 + 1
        x1++; y1++; x2++; y2++;
        return sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

public class Question304 {
    
}
