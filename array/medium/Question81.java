package array.medium;

/**
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）
上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
（下标 从 0 开始 计数）。例如， 
[0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。

给你 旋转后 的数组 nums 和一个整数 target ，
请你编写一个函数来判断给定的目标值是否存在于数组中。
如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。

 */

 //跟33题一样，直接写的话也可以通过，但是就离谱
 //测试集太拉胯，这种方法的效率竟然还可以
/*class Solution {
    public boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(target == nums[i]) return true;
            //else if(nums[i] > target) return false;
        }
        return false;
    }
}*/

//感动！！！理解后自己写的竟然能有100，98.99
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            //int mid = (int)Math.ceil((left + right) / 2);
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;

            //注意边界条件的找寻确定
            //寻找有序的一侧然后再判断target是否在里面
            if(nums[mid] > nums[left]){
                if(target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }   
            } else if(nums[mid] < nums[left]){
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                } 
            } else {
                if(nums[mid] == nums[right]){
                //此时无法区分左右区间哪个是有序的
                //故可以考虑将左右边界都减一
                //这一步思路是真没想到orz
                right--;
                left++;
                }else{
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}

public class Question81 {
    
}
