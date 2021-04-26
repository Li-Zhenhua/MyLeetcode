package array.medium;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, right = n-1;
        int up = 0, down = n-1;
        int num = 1;
        while(left < right && up < down){
            //一圈一圈来
            for (int i = left; i <= right; i++) {
                ans[up][i] = num++;
            }

            for (int i = up+1; i <= down; i++) {
                ans[i][right] = num++;
            }

            for (int i = right-1; i >= left; i--) {
                ans[down][i] = num++;
            }

            for (int i = down-1; i > up; i--) {
                ans[i][left] = num++;
            }
            left++;
            right--;
            up++;
            down--;      
        }
        if(n % 2 == 1){
            ans[n/2][n/2] = num;
        }
        return ans;
    }
}

public class Question59 {
    
}
