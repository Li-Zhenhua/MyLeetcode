package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：答案中不可以包含重复的四元组。

 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
            if(first > 0 && nums[first] == nums[first - 1]) continue;

            for (int second = first+1; second < n; second++) {
                if(second > first+1 && nums[second] == nums[second - 1]) continue;

                int fourth = n -1;
                int findNum = target - nums[first] - nums[second];
                for (int third = second+1; third < n; third++) {
                    if(third > second+1 && nums[third] == nums[third-1]) continue;

                    while(third < fourth && nums[third] + nums[fourth] > findNum){
                        fourth--;
                    }

                    if(third == fourth) break;
                    if(nums[third] + nums[fourth] == findNum){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[fourth]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
}

public class Question18 {
    
}
