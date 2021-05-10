package array.medium;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 
[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
如果不存在符合条件的子数组，返回 0 。

 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0, len = Integer.MAX_VALUE;
        while(right < nums.length){
            //sum小于target则移动右指针
            if(sum < target){
                sum += nums[right];
                right++;
                continue;
            }else{
                //sum不小于target则移动左指针
                //并记录相应的子数组长度
                len = Math.min(len, right-left);
                sum -= nums[left];
                left++;
            }
        }
        //不存在符合条件子数组时
        if(left == 0 && sum < target) return 0;

        //最后因为right=nums.lenght了，此时循环已退出
        //但sum仍可能大于等于target，故还有最后一轮对left操作
        while(sum >= target){
            len = Math.min(len, right-left);
            sum -= nums[left];
            left++;
        }
        return len;
    }
}

public class Question209 {
    
}
