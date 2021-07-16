package 每日一题;

/**
 * 统计一个数字在排序数组中出现的次数。
 */

 //或者二分，详见34题
class Solution {
    public int search(int[] nums, int target) {
        int count = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] < target) continue;
            else if(nums[i] > target) break;
            else{
                count++;
            }
        }
        return count;
    }
}

public class _7_16_剑指Q53 {
    
}
