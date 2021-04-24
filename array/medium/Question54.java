package array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，
 * 请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int boundaryXLeft = 0;
        int boundaryXRight = matrix[0].length-1;
        int boundaryYUp = 0;
        int boundaryYDown = matrix.length-1;
        //int i = 0;
        
        while(boundaryXLeft <= boundaryXRight && boundaryYUp <= boundaryYDown){
            for (int j = boundaryXLeft; j <= boundaryXRight; j++) {
                ans.add(matrix[boundaryYUp][j]);
            }
            for (int j = boundaryYUp+1; j <= boundaryYDown; j++) {
                ans.add(matrix[j][boundaryXRight]);
            }
            //下面的if判断是为了防止非方阵的时候长边来回计算两次
            if(boundaryYUp != boundaryYDown){
                for (int j = boundaryXRight-1; j >= boundaryXLeft; j--) {
                    ans.add(matrix[boundaryYDown][j]);
                }
            }
            if(boundaryXLeft != boundaryXRight){
                for (int j = boundaryYDown-1; j > boundaryYUp; j--) {
                    ans.add(matrix[j][boundaryXLeft]);
                }
            } 
            
            boundaryXLeft++;
            boundaryXRight--;
            boundaryYDown--;
            boundaryYUp++;
        }
        return ans;
    }
}

public class Question54 {
    
}
