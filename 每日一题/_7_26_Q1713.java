package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
给你一个数组 target ，包含若干 互不相同 的整数，以及另一个整数数组 arr ，arr 可能 包含重复元素。

每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加 3 得到 [1,4,3,1,2] 。你可以在数组最开始或最后面添加整数。

请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。

一个数组的 子序列 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的子序列（加粗元素），但 [2,4,2] 不是子序列。
 */

 //就是找两个数组的最大公共子序列
 //但是由于长度较长，故需要进行转换
 //由于target互不相同，可以转换成找最长递增子序列，即以坐标为
class Solution {
    public int minOperations(int[] target, int[] arr) {
        //用map记录每个元素对应的坐标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }

        //在arr中寻找在map中出现过的元素
        //List<Integer> list = new ArrayList<>();
        int[] indexArr = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                indexArr[idx++] = map.get(arr[i]);
            }
        }

        //最长递增子序列算法
        int maxLen = LIS(indexArr,idx);
        return target.length - maxLen;
    }

    //动规 + 二分求解
    public int LIS(int[] arr, int len){
        if(len == 0) return 0;
        int[] dp = new int[len];
        dp[0] = arr[0];
        int ans = 1;
        for (int num : arr) {
            int left = 0, right = ans;
            while(left < right){
                int mid = (left + right) >> 1; //这样移位一般是不会溢出的
                if(dp[mid] < num){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            dp[left] = num;
            if(right == ans) ans++;
        }
        return ans;
    }
}

public class _7_26_Q1713 {
    
}
