package hot100;

import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。
 */

 //第一反应是优先队列,超时了orz
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // int[] ans = new int[n-k+1];
        // PriorityQueue<Integer> pQueue = new PriorityQueue<>(
        //     (a,b) -> b-a
        // );
        // for (int i = 0; i < k; i++) {
        //     pQueue.offer(nums[i]);
        // }
        // ans[0] = pQueue.peek();
        // for (int i = k; i < n; i++) {
        //     pQueue.remove(nums[i-k]);
        //     pQueue.offer(nums[i]);
        //     ans[i-k+1] = pQueue.peek();
        // }
        // return ans;
        int maxNum = Integer.MIN_VALUE;
        int secondMaxNum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if(nums[i] > maxNum){
                secondMaxNum = maxNum;
                maxNum = nums[i];
            }else if(nums[i] > secondMaxNum){
                secondMaxNum = nums[i];
            }
        }
    }
}

public class Q239 {
    
}
