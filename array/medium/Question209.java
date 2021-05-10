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

//看别人的写法，思路和自己是一样的，只不过不用判断那么多
/*class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            //这里先对start进行移动可以防止后面
            //end=n退出循环时还未移动start的尴尬
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}*/

public class Question209 {
    
}
