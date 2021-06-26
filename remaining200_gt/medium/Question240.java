package remaining200_gt.medium;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的
 * 一个目标值 target 。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
 */

 //最简单想法，直接找，由于这个矩阵只是行、列分别有序，所以分别二分
 //对角线
/*class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < len; i++) {
            //因为对角元素左边、上边和左上边一定更小，不需要再找
            boolean rowFinded = binarySearch(matrix, target, i, true);
            if(rowFinded){
                return true;
            }
            boolean columnFinded = binarySearch(matrix, target, i, false);
            if(columnFinded){
                return true;
            }
        }
        
        return false;
    }

    public boolean binarySearch(int[][] matrix, int target, int start, boolean horizen){
        int left = start;
        int right = horizen ? matrix[0].length-1 : matrix.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(horizen){
                //二分查找一行
                if(matrix[start][mid] == target){
                    return true;
                }else if(matrix[start][mid] < target){
                    left = mid + 1;
                }else{
                    right = mid-1;
                }
            }else{
                //二分查找一列
                if(matrix[mid][start] == target){
                    return true;
                }else if(matrix[mid][start] < target){
                    left = mid + 1;
                }else{
                    right = mid-1;
                }
            }
        }
        return false;
    }
}*/

//优化搜索空间，分成左上、左下、右上、右下四个子矩阵
//只需要递归搜索左下、右上矩阵，二分
/*class Solution {
    private int[][] matrix;
    private int target;

    private boolean searchRec(int left, int up, int right, int down) {
        // this submatrix has no height or no width.
        if (left > right || up > down) {
            return false;
        // `target` is already larger than the largest element or smaller
        // than the smallest element in this submatrix.
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }

        int mid = left + (right-left)/2;

        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }

        return searchRec(left, row, mid-1, down) || searchRec(mid+1, up, right, row-1);
    }

    public boolean searchMatrix(int[][] mat, int targ) {
        // cache input values in object to avoid passing them unnecessarily
        // to `searchRec`
        matrix = mat;
        target = targ;

        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRec(0, 0, matrix[0].length-1, matrix.length-1);
    }
}*/

//另一个更巧妙的方法，因为只有左下和右上部分的值是无法直接在上述
//二分方法中比较大小的，故选取一个指向最左下角元素的指针
//当前值大于目标值则row-1，小于目标值则column+1
//这样指针会从左下不断往右上走，直到超出边界
//本质上看其实相当于将左下矩阵变成空矩阵，遍历右上矩阵
//所以按理来说也能从右上到左下类似实现
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        /*int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }*/
        int row = 0;
        int col = matrix[0].length-1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }

        return false;
    }
}

public class Question240 {
    
}
