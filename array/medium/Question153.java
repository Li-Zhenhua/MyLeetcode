package array.medium;

import java.util.Arrays;

/**已知一个长度为 n 的数组，预先按照升序排列，
 * 经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果
为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。

给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，
并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
*/

class Solution {
    public int findMin(int[] nums) {
        //有点作弊的办法，其实时间复杂度还挺大
        /*Arrays.sort(nums);
        return nums[0];*/

        //直接遍历
        /*for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] < nums[i+1]) continue;
            else{
                return nums[i+1];
            }
        }
        return nums[0];*/

        //二分查找
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            //因为mid在left<right时一定不会等于right，故这里用right进行比较更好
            if(nums[mid] < nums[right]){
                right = mid;//不能减1是因为有可能nums[mid]值就是最小的
            }else{
                left = mid + 1;
            }
        }
        return nums[left];
    }
}

public class Question153 {
    
}
