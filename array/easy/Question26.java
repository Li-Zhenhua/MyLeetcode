package array.easy;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
 * 使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 
 * 并在使用 O(1) 额外空间的条件下完成。
 * 不需要考虑数组中超出新长度后面的元素。
 */

 //0ms,但是空间大？为什么呢
 //有毒，再次运行内存小点，时间1ms
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > nums[index]){               
                nums[++index] = nums[i];
            }
            
        }
        return index+1;
    }
}

public class Question26 {
    
}
