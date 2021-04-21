package array.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * (candidates中可以有重复元素)

但candidates 中的每个位置的数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 

 */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(candidates, ans, stack, target, 0);
        return ans;
    }

    public void dfs(int[] candidates, List<List<Integer>> ans,
     Deque<Integer> stack, int target, int begin){
        if(target == 0){
            ans.add(new ArrayList<>(stack));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {

            //防止上次pop出的元素又被push进去，造成重复
            if(i > begin && candidates[i] == candidates[i-1]) continue;

            int temp = target - candidates[i];
            if(temp < 0) return;

            stack.push(candidates[i]);
            dfs(candidates, ans, stack, temp, i+1);
            stack.pop();
        }
    }
}

public class Question40 {
    
}
