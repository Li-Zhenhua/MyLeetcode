package remaining1_100.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */

//与46、47一起看，前两者是排列

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, 0, k);
        return ans;
    }

    public void dfs(int start, int n, int index, int k){
        if(index == k){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(i+1, n, index+1, k);
            list.remove(index);
        }
    }
}

public class Question77 {
    
}
