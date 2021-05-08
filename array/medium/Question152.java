package array.medium;

/**
 * 给你一个整数数组 nums ，
 * 请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 */

class Solution {
    public int maxProduct(int[] nums) {
        //负数不用考虑那么多判断条件，直接全部都用同一个流程就行
        //以后也别想那么多判断条件，有判断反而有时运行得还更慢
        int maxProduct = 1;
        int minProduct = 1;//这里根据后面需要乘积故设成1比较好
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0){
                //有负数时最大值->最小值,最小值->最大值
                int temp = maxProduct;
                maxProduct = Math.max(minProduct * nums[i], nums[i]);
                minProduct = Math.min(temp*nums[i], nums[i]); 
            }else{
                maxProduct = Math.max(maxProduct*nums[i], nums[i]);
                minProduct = Math.min(minProduct*nums[i], nums[i]);
            }
            //记录连乘到每个位置处的最大值
            ans = Math.max(ans, maxProduct);
        }
        return ans;
    }
}

//官方直接用取三个数的最大值的办法
//fmax(i)=max{fmax(i-1)*nums[i],fmin*nums[i],nums[i]}
//fmin(i)=min{fmin(i-1)*nums[i],fmax*nums[i],nums[i]}
//这样其实考虑得就更少，都可以不用判断条件
/*class Solution {
    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}*/

public class Question152 {
    
}
