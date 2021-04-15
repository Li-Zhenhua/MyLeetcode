package remaining200_gt.easy;


/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int findNonZero;
        int temp;
        for (int insert = 0; insert < nums.length; insert++) {
            if(nums[insert] != 0 || insert == nums.length) continue;
            findNonZero = insert + 1;
            if(findNonZero == nums.length) return;
            while(nums[findNonZero] == 0){
                findNonZero++;
                if(findNonZero == nums.length) return;
            }
            temp = nums[insert];
            nums[insert] = nums[findNonZero];
            nums[findNonZero] = temp;
        }    
    }
}

//上述双指针不够精简，下面是官方双指针
/*1、左指针左边均为非零数；2、右指针左边直到左指针处均为零。*/

/*class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}*/


public class Question283 {
    
}
