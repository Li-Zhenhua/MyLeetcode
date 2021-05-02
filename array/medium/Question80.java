package array.medium;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
 * 使每个元素 最多出现两次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 
并在使用 O(1) 额外空间的条件下完成。

 */

/*class Solution {
    public int removeDuplicates(int[] nums) {
        //参照第26题思想，这里最多可以有两个重复值
        //则填充的时候可以相差两个位置
        if(nums.length < 3) return nums.length;
        int curr = 2, index = 0;
        while(curr < nums.length){
            if(nums[curr] > nums[index]){
                nums[index+2] = nums[curr];
                index++;
                //curr++;
            }
            curr++;
        }
        return index+2;
    }
}*/

//看到一个简化空间复杂度思路：运用增强型for循环替代curr指针
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        /*int index = 0;
         for (int num : Arrays.copyOfRange(nums, 2, nums.length)) {
            if(num > nums[index]){
                nums[index+2] = num;
                index++;
            }
        } 
        return index+2;
        */

        //或者这样也很好，不用调用copyofrange函数，时间复杂度也有一定保证
        int index = 0;
        for (int num : nums) {
            if(index < 2 || num > nums[index-2]){
                nums[index] = num;
                index++;
            }
        }
        return index;
    }
}

public class Question80 {
    
}
