package math.medium;

/**
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。

每个矩形由其 左下 顶点和 右上 顶点坐标表示：

第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 */

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2-ax1)*(ay2-ay1);
        int area2 = (bx2-bx1)*(by2-by1);
        int overX1 = Math.max(ax1, bx1);
        int overX2 = Math.min(ax2, bx2);
        int overY1 = Math.max(ay1, by1);
        int overY2 = Math.min(ay2, by2);
        //无重叠时
        if(overX1 >= overX2 || overY1 >= overY2){
            return area1 + area2;
        }

        //有重叠时
        int overArea = (overX2-overX1)*(overY2-overY1);
        return area1+area2-overArea;
    }
}

public class Question223 {
    
}
