package hot100;

import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。
 */

 //第一反应是优先队列,超时了orz
 //额后面发现remove这个问题其实不需要，只需要将出了窗口区域的最大值弹出即可
 //即最大堆的大小不需要维护在k,前面的较小的数不影响
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        //int[]第一位记录值，第二位记录索引
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            else return b[0] - a[0];
        });
        for (int i = 0; i < k; i++) {
            pQueue.offer(new int[]{nums[i],i});
        }
        ans[0] = pQueue.peek()[0];
        for (int i = k; i < n; i++) {
            //pQueue.remove(nums[i-k]);
            pQueue.offer(new int[]{nums[i],i});
            //弹出处于窗口之前的元素
            while(pQueue.peek()[1] <= i - k){
                pQueue.poll();
            }
            ans[i-k+1] = pQueue.peek()[0];
        }
        return ans;
        // int[] maxNum = new int[]{Integer.MIN_VALUE,-1};
        // int[] secondMaxNum = new int[]{Integer.MIN_VALUE,-1};
        // for (int i = 0; i < n; i++) {




        //     if(nums[i] > maxNum[0]){
        //         //secondMaxNum = maxNum;
        //         maxNum[0] = nums[i];
        //         maxNum[1] = i;
        //         continue;
        //     }
        //     if(nums[i] > secondMaxNum[0]){
        //         secondMaxNum[0] = nums[i];
        //         secondMaxNum[1] = i;
        //         continue;
        //     }


        // }
    }
}

//看了题解之后发现单调栈做法好像更好orz

public class Q239 {
    
}
