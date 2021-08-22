package 每日一题;

/**
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：

nums[0] = 0
nums[1] = 1
当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
返回生成数组 nums 中的 最大 值。
 */

 //其实就是一个递推，说是动态规划也可以？
 class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int maxNum = 0;
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            if(i % 2 == 0){
                nums[i] = nums[i/2];
            } else {
                //int index = i/2;
                nums[i] = nums[i/2] + nums[i/2+1];
            }
            if(nums[i] > maxNum){
                maxNum = nums[i];
            }
        }
        return maxNum;
    }
}

public class _8_23_Q1646 {
    
}
