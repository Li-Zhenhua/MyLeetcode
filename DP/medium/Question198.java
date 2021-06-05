package DP.medium;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，
计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */

/*class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //测试集条件给定n>=1
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        //dp[i]表示到i号房屋时最多能偷窃的金额
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0] + nums[2];
        for (int i = 3; i < n; i++) {
            //第i个位置一定能由i-2和i-3位置表示
            //其实最终是归根到由第0位和第1位表示
            dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
        }
        return Math.max(dp[n-2], dp[n-1]);
    }
}*/

//一般动态规划思路
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        // int[] dp = new int[length];
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);
        // for (int i = 2; i < length; i++) {
        //     //dp[i] = dp[i-1]时表示第i家不抢
        //     dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        // }
        // return dp[length - 1];

        //优化空间
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}

public class Question198 {
    
}
