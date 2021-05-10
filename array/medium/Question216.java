package array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。
 * 组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。

 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
       dfs(k, n, 0, 1);  
       return ans;   
    }

    public void dfs(int k, int n, int index, int start){
        if(index == k){
            if(n == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = start; i < 10; i++) {
            list.add(i);
            dfs(k, n-i, index+1,i+1);
            list.remove(list.size()-1);
        }
    }
}

public class Question216 {
    
}
