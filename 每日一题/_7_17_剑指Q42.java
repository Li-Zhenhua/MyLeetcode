package 每日一题;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

与 Question 53 相同
 */

 //动态规划
class Solution {
    public int maxSubArray(int[] nums) {
        int prev = nums[0];
        int curr;
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            curr = prev > 0 ? nums[i] + prev : nums[i];
            max = curr > max ? curr : max;
            prev = curr;
        }
        return max;
    }
}

public class _7_17_剑指Q42 {
    
}
