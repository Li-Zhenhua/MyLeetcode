package array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。
 * 返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //ans.add(list);
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int index){
        if(index == nums.length){
            //这里不能直接add(list)
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        dfs(nums, index+1);
        list.remove(list.size()-1);

        //不要当前位置的元素时
        dfs(nums, index+1);
    }
}

public class Question78 {
    
}
