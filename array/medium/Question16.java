package array.medium;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 */


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int first=0;first<nums.length;first++) {
            int second = first+1, third = nums.length - 1;
            while(second < third) {
                int sum = nums[second] + nums[third] + nums[first];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    third--;
                else if(sum < target)
                    second++;
                else
                    return ans;
            }
        }
        return ans;
    }
}


public class Question16 {
    
}
