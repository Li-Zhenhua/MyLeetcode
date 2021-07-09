package 每日一题;

/**
 * 数组中占比超过一半的元素称之为主要元素。
 * 给你一个 整数 数组，找出其中的主要元素。
 * 若没有，返回 -1 。
 * 请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。

 
 */

 //做过类似的题，摩尔投票法
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                candidate = nums[i];
                count++;
            }else if(nums[i] == candidate){
                count++;
            }else{
                count--;
            }
        }
        if(count == 0){
            return -1;
        }
        //因为不确定是否有人票数过一半，故要重新扫描一遍
        //以确定得到的candidate是否是票数过一半的
        count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate){
                count++;
            }
        }
        return count > nums.length/2 ? candidate : -1;
    }
}

public class _7_9_面试题17_10 {
    
}
