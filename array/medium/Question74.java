package array.medium;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。
 * 该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

 */

 //二分查找
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i;
        int row = matrix.length;
        int column = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[row-1][column-1])
            return false;

         for(i = 0; i < row; i++){
            if(target <= matrix[i][column-1]) break;
        } 

        int left = 0, right = column-1;
        int mid;
        while(left <= right){
            mid = left + (right - left) /2; //防止溢出
            if(matrix[i][mid] == target) return true;
            else if(matrix[i][mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}

//另一个更好的方法
//直接按行视为拼接成一个长数组，进行一次的二分查找即可
/*class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}*/


public class Question74 {
    
}
