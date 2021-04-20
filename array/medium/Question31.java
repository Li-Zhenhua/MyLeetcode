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

//即我们需要将一个左边的「较小数」与一个右边的「较大数」交换
//同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。

 //所以第一个交换点后的序列一定是一个逆序列
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


//官方答案更简洁
/*class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}*/

public class Question31 {
    
}
