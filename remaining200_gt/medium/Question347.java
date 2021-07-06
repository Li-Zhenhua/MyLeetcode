package remaining200_gt.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，
 * 请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 
 * 1 <= nums.length <= 10^5
k 的取值范围是 [1, 数组中不相同的元素的个数]
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 */

 //想法一：map并排序
/*class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        //map排序
        Collections.sort(list,(a,b)->{
            if(a.getValue() == b.getValue()){
                return a.getKey() - b.getKey();
            }
            return b.getValue() - a.getValue();
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }
}*/

//手动排序方式，不用sort函数
/*class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];    // 结果数组
        Map<Integer, Integer> map = new HashMap();
        // 统计数组中各元素出现的次数
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }

        int maxTimes = 0;    // 出现最多的元素的出现次数
        // 找出出现次数最多的元素出现的次数
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > maxTimes){
                maxTimes = entry.getValue();
            }
        }

        // 按出现次数从大到小添加到结果数组
        while(k > 0){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() == maxTimes){
                    res[k - 1] = entry.getKey();
                    k--;
                }
            }
            maxTimes--;
        }

        return res;
    }
}*/

//方法二：map并维护一个大小为k的最小堆
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        //最小堆内是要存放索引才比较合适
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->{
            return map.get(a)-map.get(b);
        });

        for (Integer key : map.keySet()) {
            if(priorityQueue.size() < k){
                priorityQueue.add(key);
            }else{
                if(map.get(key) > map.get(priorityQueue.peek())){
                    priorityQueue.poll();
                    priorityQueue.add(key);
                }
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll();
        }
        return ans;
    }
}

public class Question347 {
    
}
