package 每日一题;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

请返回 nums 的动态和。

 */

class Solution {
    public int[] runningSum(int[] nums) {
        int n =nums.length;
        //int[] ans = new int[n];
        //ans[0] = nums[0];
        for(int i = 1; i< n; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}

public class _8_28_Q1480 {
    
}
