package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。

给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。

题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。

返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。

提示：

nums.length == n
adjacentPairs.length == n - 1
adjacentPairs[i].length == 2
2 <= n <= 105
-105 <= nums[i], ui, vi <= 105
题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums
 */

 //map存储邻接值，先找到一个只有唯一邻接值的元素作为数组开头
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            int tempKey1 = adjacentPairs[i][0];
            int tempKey2 = adjacentPairs[i][1];
            List<Integer> list1 = null;
            List<Integer> list2 = null;
            if(!map.containsKey(tempKey1)){
                list1 = new ArrayList<>();
            }else{
                list1 = map.get(tempKey1);
            }
            list1.add(tempKey2);
            map.put(tempKey1, list1);
            if(!map.containsKey(tempKey2)){
                list2 = new ArrayList<>();
            }else{
                list2 = map.get(tempKey2);
            }
            list2.add(tempKey1);
            map.put(tempKey2, list2);  
        }

        int n = adjacentPairs.length+1;
        int[] ans = new int[n];
        for (Integer key : map.keySet()) {
            if(map.get(key).size() == 1){
                ans[0] = key;
                ans[1] = map.get(key).get(0);
                break;
            }
        }
        
        List<Integer> findNum = null;
        for (int i = 2; i < ans.length; i++) {
            findNum = map.get(ans[i-1]);
            ans[i] = findNum.get(0) == ans[i-2] ? findNum.get(1) : findNum.get(0);
        }
        return ans;
    }
}

public class _7_25_Q1743 {
    
}
