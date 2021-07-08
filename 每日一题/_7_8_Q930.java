package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。

子数组 是数组的一段连续部分。

提示：

1 <= nums.length <= 3 * 104
nums[i] 不是 0 就是 1
0 <= goal <= nums.length
 */

 //暴力解法
/*class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int temp = goal - nums[i];
            if(temp == 0){
                ans++;
            }
            for(int j = i+1; j < nums.length; j++){
                temp -= nums[j];
                if(temp == 0){
                    ans++;
                }else if(temp < 0){
                    break;
                }
            }
        }
        return ans;
    }
}*/

//这种求一连续的子数组可以想到用前缀和
//再用一个map
/*class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }
}*/

//滑动窗口法
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int ret = 0;
        while (right < n) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ret += left2 - left1;
            right++;
        }
        return ret;
    }
}

public class _7_8_Q930 {
    
}
