package array.medium;

/**
 * 峰值元素是指其值大于左右相邻值的元素。

给你一个输入数组 nums，找到峰值元素并返回其索引。
数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞ 。

 */

 //直接线性扫描一遍的方法
/*class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] < nums[i+1]) continue;
            else if(nums[i] == nums[i+1]){
                i++;
                continue;
            }else{
                return i;
            }
        }
        return 0;
    }
}*/

//官方简单点的线性扫描写法
/*public class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
}*/

//二分法
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[mid+1]){
                right = mid; //因为此时mid有可能是峰值，不能将其排除在查找范围外
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}


public class Question162 {
    
}
