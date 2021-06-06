package remaining1_100.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，
 * 返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 
 * 提示：

1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同
 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // if(nums.length == 1){
        //     list.add(nums[0]);
        //     ans.add(new ArrayList<>(list));
        //     return ans;
        // }
        
        //flag数组记录是否被使用过
        boolean[] flag = new boolean[nums.length];
        dfs(nums, flag, 0);
        return ans;
    }

    public void dfs(int[] nums, boolean[] flag, int index){
        if(index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(flag[i]) continue;
            flag[i] = true;
            list.add(nums[i]);
            dfs(nums, flag, index+1);
            flag[i] = false;
            list.remove(list.size()-1);
        }
    }
}

public class Question46 {
    
}
