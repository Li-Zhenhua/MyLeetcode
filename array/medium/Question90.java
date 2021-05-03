package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，
 * 请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //排序是为了保证后面的while循环能达到预期效果
        Arrays.sort(nums);
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int index){
        if(index == nums.length){
            //list.add(nums[index]);
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        dfs(nums, index+1);
        list.remove(list.size()-1);

        //去除同一级的重复元素
        while(index < nums.length-1 && nums[index+1] == nums[index]){
            index++;
        } 

        //不要当前index指向的元素
        dfs(nums, index+1);
        
    }
}

public class Question90 {
    
}
