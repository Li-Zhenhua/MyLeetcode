package 每日一题;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

请你找出符合题意的 最短 子数组，并输出它的长度。
 */

//两次遍历找到左右边界
/*class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        //int minNum = Integer.MAX_VALUE, maxNum = Integer.MIN_VALUE;
        int left = 0, right = n-1;
        boolean isLeftIncrease = true, isRightDecrease = true;
        for (int i = 0; i < n-1; i++) {
            if(nums[i] <= nums[i+1]){
                if(isLeftIncrease) left = i;
                continue;
            }

            isLeftIncrease = false;
            while(left >= 0 && nums[left] > nums[i+1]){
                left--;
            }
        }

        for (int i = n-1; i > 0; i--) {
            if(nums[i-1] <= nums[i]){
                if(isRightDecrease) right = i;
                continue;
            }

            isRightDecrease = false;
            while(right < n && nums[right] < nums[i-1]){
                right++;
            }
        }

        return right > left ? right - left - 1 : 0;
    }
}*/

//官方答案就简便多了orz， 一次遍历从两头开始找值
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            //这样就相当于找到了最后一次降序的位置，即right
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            //找到最后第一次降序的位置，即left
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}

public class _8_3_Q581 {
    
}
