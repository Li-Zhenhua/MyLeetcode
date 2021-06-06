package remaining1_100.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */

 //对比46题，相当于进行了剪枝
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        //set要在每一层都是一个独立的集合，记录数字在对应层数是否被使用过
        //Set<Integer> set = new HashSet<>();
        boolean[] flag = new boolean[nums.length];
        dfs(nums, 0, new HashSet<>(), flag);
        return ans;
    }

    public void dfs(int[] nums, int index, Set<Integer> set, boolean[] flag){
        if(index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(flag[i] || set.contains(nums[i])) continue;
            set.add(nums[i]);
            flag[i] = true;
            list.add(nums[i]);
            dfs(nums, index+1, new HashSet<>(),flag);
            flag[i] = false;
            list.remove(list.size()-1);
        }
    }
}

//官方答案，排序后用前后两个数值判断是否相等来代替set集合
/*class Solution {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}*/

public class Question47 {
    
}
