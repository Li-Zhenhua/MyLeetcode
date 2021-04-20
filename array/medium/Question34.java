package array.medium;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

 */

 //排序好的就二分查找
/*class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null) return new int[]{-1,-1};
        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[]{-1,-1};
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){

                int start = mid, stop = mid;
                while(nums[start] == target){
                    if(start == 0){
                        --start;
                        break;
                    } 
                    else{
                        --start;
                    }
                }
                ans[0] =start+1;
                while(nums[stop] == target){
                    if(stop == nums.length-1){
                        ++stop;
                        break;
                    } else{
                        ++stop;
                    }
                }
                ans[1] =stop-1;
                return ans;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return ans;
    }
}*/

//这些二分法要十分注意边界取等号的情况
//如果全程用二分方法则如下：
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null) return new int[]{-1,-1};
        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[]{-1,-1};
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                ans[0] = binarySearchLeft(nums,left,mid,target);
                ans[1] = binarySearchRight(nums,mid,right,target);
                return ans;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    public int binarySearchLeft(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] < target){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return left;
    }

    public int binarySearchRight(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] > target){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return right;
    }
}

public class Question34 {
    
}
