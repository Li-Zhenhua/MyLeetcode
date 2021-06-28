package remaining200_gt.medium;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，
删除（或不删除）数组中的元素而不改变其余元素的顺序。
例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        //动态规划
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 1;
        int maxLen = 1;
        for(int i = n-2; i >= 0; i--){
            int num_i = nums[i];
            int maxPartLen = 0;
            for(int j = i+1; j < n; j++){
                if(nums[j] > num_i){
                    maxPartLen = Math.max(maxPartLen,dp[j]);
                }
            }
            //当前位置到末尾的最长子序列dp[i]
            //等于所有之后nums[j] > nums[i]的元素的位置
            //到末尾的最长子序列dp[j](j > i)中的最大值max(dp[j]) + 1
            dp[i] = maxPartLen+1; 

            //最大值注意不是dp[0],而是所有dp中最大的那个
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}

public class Question300 {
    
}
