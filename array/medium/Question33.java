package array.medium;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上
进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], 
nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，
如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。


 */

 //测试集问题，这个方法竟然效率挺高
/*class Solution {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) return i;
        }
        return -1;
    }
}*/

//正常情况的二分法
//将数组从中间分开成左右两部分的时候，一定有一部分的数组是有序的。
class Solution{
    public int search(int[] nums, int target){
        int left = 0; int right = nums.length-1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;

            //表示有序部分在左侧,注意等号!!!!
            //一定要考虑好边界条件，因为是向下取整，故左边要等号
            if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }else{
                //有序部分在右侧
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[(left + right)/2] == target ? (left + right)/2 : -1;
    }
}

public class Question33 {
    
}
