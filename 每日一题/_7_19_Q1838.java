package 每日一题;

import java.util.Arrays;

/**
 * 元素的 频数 是该元素在一个数组中出现的次数。

给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。

执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 */

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        //注意由于大元素相加可能导致溢出，故需要用long
        long[] sum = new long[n+1];
        //sum[0] = nums[0];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        int left = 0;
        int maxCount = 1;
        for (int r = 1; r <= n;) {
            if(left == r){
                r++;
                continue;
            }
            long temp = sum[r] - sum[left];
            int len = r - left;
            if(temp + k >= len*nums[r-1]){
                maxCount = Math.max(maxCount, len);
                r++;
                continue;
            }else{

                left++;
            }

        }
        return maxCount;
        
    }
}

public class _7_19_Q1838 {
    
}
