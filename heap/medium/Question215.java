package heap.medium;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */

 //小顶堆，控制大小为k
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //默认的就是小顶堆，否则要用comparator
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int num : nums) {
           if(pQueue.size() < k){
               pQueue.offer(num);
           }else{
               if(pQueue.peek() < num){
                   pQueue.poll();
                   pQueue.offer(num);
               }
           }
        }
        return pQueue.peek();
    }
}

public class Question215 {
    
}
