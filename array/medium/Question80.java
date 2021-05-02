package array.medium;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
 * 使每个元素 最多出现两次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 
并在使用 O(1) 额外空间的条件下完成。

 */

class Solution {
    public int removeDuplicates(int[] nums) {
        //参照第26题思想，这里最多可以有两个重复值
        //则比较的两者可以相差两个位置
        if(nums.length < 3) return nums.length;
        int curr = 2, pre = 0;
        
    }
}

public class Question80 {
    
}
