package array.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 

 */

 //不会orz 学习了
 //回溯 + 剪枝,其实就是dfs搜索变形感觉
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null) return new ArrayList<>();
        // int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(candidates, stack, ans, target, 0);
        return ans;
    }

    public void dfs(int[] candidates, Deque<Integer> stack, 
    List<List<Integer>> ans, int target, int begin){
        if(target == 0){
            ans.add(new ArrayList<>(stack));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if(target < candidates[i]){
                return;
            } else {
                stack.push(candidates[i]);
                dfs(candidates, stack, ans, target-candidates[i], i);
                stack.pop();
            }
        }
    }
}

public class Question39 {
    
}
