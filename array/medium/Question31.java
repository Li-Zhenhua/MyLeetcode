package array.medium;

import jdk.javadoc.internal.tool.resources.javadoc;
import jdk.javadoc.internal.tool.resources.javadoc_zh_CN;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中
 * 下一个更大的排列。
 * 关键是“下一个”，就类似下一个页码

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须 原地 修改，只允许使用额外常数空间。

 */

 //看了思路才知道怎么做
 //第一个交换点后的序列一定是一个逆序列
 //第一个交换点的值要尽可能接近另一个交换点的值，且小于另一个交换点的值
 //交换后也是一个逆序列，再倒序即可
class Solution {
    public void nextPermutation(int[] nums) {
        int firstIndex = nums.length -1;
        int secondIndex = nums.length -1;
        for (int i = nums.length-1; i >0 ; i--) {
            if(nums[i] <= nums[i-1]){
                if(i == 1){
                    //当整个序列为逆序列时
                    reverse(nums,0,nums.length-1);
                    return;
                } 
                continue;
            } 
            else{
                //找到了不为逆序的第一个元素位置
                firstIndex = i-1;
                break;
            }
        }

        for (int j = nums.length-1; j >0 ; j--) {
            if(nums[j] <= nums[firstIndex]) continue;
            else{
                secondIndex = j;
                break;
            }
        }
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;

        //翻转后续序列
        firstIndex++;
        secondIndex = nums.length-1;
        reverse(nums, firstIndex, secondIndex);
        /* while(firstIndex<secondIndex){
            temp = nums[firstIndex];
            nums[firstIndex] = nums[secondIndex];
            nums[secondIndex] = temp;
            firstIndex++;
            secondIndex--;
        } */
    }

    public void reverse(int nums[], int firstIndex , int secondIndex){
        int temp;
        while(firstIndex<secondIndex){
            temp = nums[firstIndex];
            nums[firstIndex] = nums[secondIndex];
            nums[secondIndex] = temp;
            firstIndex++;
            secondIndex--;
        }
    }
}

public class Question31 {
    
}
