package array.medium;

/**
 * 
给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标。
 */

/*class Solution {
    public boolean canJump(int[] nums) {
        int currDistance = 0;
        int nextDistance = 0;
        for (int i = 0; i < nums.length-1; i++) {
            nextDistance = Math.max(nextDistance, nums[i]+i);
            if(i == currDistance){
                if(nextDistance >= nums.length-1) return true;
                //当已到达最远距离且下一步的最远距离为0时，则不能继续走下去
                else if(currDistance == nextDistance) return false;
                currDistance = nextDistance;  
            }
        }
        return true;
    }
}*/

//更精简的写法思路
class Solution {
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(k >=nums.length) return true;
            if(i > k) return false;
            k = Math.max(k, nums[i]+i);
        }
        return true;
    }
}


public class Question55 {
    
}
