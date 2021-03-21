package array.easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 */


 //动态规划，完全忘完orz,看了思路才做出来
class Solution {
    public int maxSubArray(int[] nums) {
        int sumMaxNMinusOne = nums[0];
        int maxSum = sumMaxNMinusOne;
        for (int i = 1; i < nums.length; i++) {
            //if(i == 0) continue;
            sumMaxNMinusOne = Math.max(sumMaxNMinusOne + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sumMaxNMinusOne);
        }
        return maxSum;
    }
}


public class Question53 {
    
}
