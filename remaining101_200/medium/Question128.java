package remaining101_200.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，
 * 找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 

进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 */

//最简单想法，先排序后找，时间复杂度O（nlogn）
/*class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int count = 1;
        int maxNum = count;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] + 1 == nums[i+1]){
                count++;
            }else if(nums[i] == nums[i+1]){
                continue;
            }else{
                maxNum = Math.max(count,maxNum);
                count = 1;
            }
        }
        maxNum = Math.max(maxNum,count);
        return maxNum;
    }
}*/

//用一个set，先判断set中每个数的前导的一个数是否存在
//若存在，则跳过；若不存在，开始统计以该数开头的连续数的个数
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxCount = 1;
        for (Integer integer : set) {
            if(set.contains(integer-1)) continue;
            int count = 1;
            while(set.contains(integer+1)){
                count++;
                integer++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}

//还有一个map方法，其实也类似于set
/*class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
        int res = 0;
        for(int num:nums){
            if(!map.containsKey(num)){
                int left = map.get(num-1)==null?0:map.get(num-1);
                int right = map.get(num+1)==null?0:map.get(num+1);
                int cur = 1+left+right;
                if(cur>res){
                    res = cur;
                }
                map.put(num,cur);
                map.put(num-left,cur);
                map.put(num+right,cur);
            }
        }
        return res;
    }
}*/
public class Question128 {
    
}
