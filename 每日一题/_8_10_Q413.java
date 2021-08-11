package 每日一题;

/**
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。

例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。

子数组 是数组中的一个连续序列。
 */

 //第一反应是滑动窗口
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        int left = 0;
        int ans = 0;
        while(left < n - 2){
            int right = left+2;
            int interval = nums[left+1] - nums[left];
            while(right < n && nums[right] - nums[right-1] == interval){
                right++;
            }
            //因为这里right等于是有效右边界的数的右边位置，故需要再多减1
            int upLimit = right - left - 2;
            //等差数列求和公式，例如有连续的5个数构成等差数列
            //那么子数组为等差数组的个数为1+2+3 = 6
            ans += (upLimit*(upLimit+1)/2);

            //注意这里因为是上一组数的有效右边界的数的右边位置
            //下一组连续的子序列的开头有可能是上一组数的有效右边界的数
            //故需要减1
            left = right-1;
        }
        return ans;

    }
}

public class _8_10_Q413 {
    
}
