package hard_question;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 */

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;
        int left = 0, right = n-1;
        int layer = 1;
        int total = 0;
        while(true){
            while(left <= right &&height[left] < layer){
                left++;
            }
            if(left > right) break;
            while(height[right] < layer){
                right--;
            }
            //当前总面积 = 上一层的面积加上当前layer层的面积
            total += right-left+1;
            layer++;
        }
        int pillarTotal = 0;
        for (int i = 0; i < n; i++) {
            pillarTotal += height[i];
        }
        return Math.max(total-pillarTotal, 0);
    }
}

public class Question42 {
    
}
