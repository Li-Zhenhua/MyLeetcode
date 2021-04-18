package array.medium;

/**
 * 
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */

class Solution {
    public int maxArea(int[] height) {
        int head = 0;
        int back = height.length-1;
        int ans = 0; int temp;
        //两指针未相遇
        while(head != back){
            //因为要找两个柱子之间容纳水最多
            //可以想到要使两个柱子尽可能大且尽可能相隔得远
            //两柱子间的水容量取决于短的那根，故只需要移动短的
            if(height[head] > height[back]){
                temp = (back - head) * height[back];
                if(temp > ans){
                    ans = temp;
                }    
                back--;
            } else {
                temp = (back - head) * height[head];
                if(temp > ans){
                    ans = temp;
                }
                head++;
            }
        }
        return ans;
    }
}

public class Question11 {
    
}
