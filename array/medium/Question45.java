package array.medium;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 */

//贪心算法，，两步内能覆盖的最大范围
class Solution {
    public int jump(int[] nums) {
        //int n = nums.length;
        int curDistance = 0;
        int nextDistance = 0;
        int count = 0;
        //倒数第二个数必然能在一步内到达最后一个数，故在初始时直接设置count为1
        for (int i = 0; i < nums.length-1; i++) {
            nextDistance = Math.max(nums[i]+i, nextDistance);
            if(i == curDistance){
                //找到两步内覆盖的最大范围
                curDistance = nextDistance;
                count++;
            }
        }
        return count;
    }
}

public class Question45 {
    
}
