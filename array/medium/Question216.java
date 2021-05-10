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


//官方的枚举法+位运算
//原序列中有 9个数，每个数都有两种状态，
//「被选择到子集中」和「不被选择到子集中」，
//所以状态的总数为 2^9

//我觉得这种方法挺难想的，还不如就像上面直接递归法
/*class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int mask = 0; mask < (1 << 9); ++mask) {
            if (check(mask, k, n)) {
                ans.add(new ArrayList<Integer>(temp));
            }
        }
        return ans;
    }

    public boolean check(int mask, int k, int n) {
        temp.clear();
        for (int i = 0; i < 9; ++i) {
            if (((1 << i) & mask) != 0) {
                temp.add(i + 1);
            }
        }
        if (temp.size() != k) {
            return false;
        }
        int sum = 0;
        for (int num : temp) {
            sum += num;
        }
        return sum == n;
    }
}*/



public class Question216 {
    
}
