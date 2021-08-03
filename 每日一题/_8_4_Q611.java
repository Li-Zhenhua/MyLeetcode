package 每日一题;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * 
 * 注意:

数组长度不超过1000。
数组里整数的范围为 [0, 1000]。
 */

//其实就是两个较小的边之和大于第三边即可
 //因为数据量较小，其实可以用暴力解
/*class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int num1 = nums[i];
            for(int j = i+1; j < nums.length; j++){
                int num2 = nums[j];
                for(int k = j+1; k < nums.length; k++){
                    if(num1 + num2 > nums[k]){
                        count++;
                    }else{
                        break;
                    }
                }
            }
        }
        return count;
    }
}*/

//此时肯定会想到双指针优化一个循环
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length-1; i > 1; i--){
            int numMax = nums[i];
            int left = 0, right = i-1;
            while(left != right){
                if(nums[left] + nums[right] > numMax){
                    //因为此时必然也有nums[left+ii] + nums[right] > numMax
                    //其中left+ii < right
                    count += right - left; 
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return count;
    }
}

public class _8_4_Q611 {
    
}
