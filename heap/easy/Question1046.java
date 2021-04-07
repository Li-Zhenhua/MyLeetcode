package heap.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 有一堆石头，每块石头的重量都是正整数。

每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。

 */

class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
       PriorityQueue<Integer> pq = new PriorityQueue<>(n,new Comparator<Integer>(){
           @Override
           public int compare(Integer i1, Integer i2){
               return i2 - i1;
           }
       });
       for (int i = 0; i < n; i++) {
           pq.offer(stones[i]);
       }
       int x;
       int y;
       while (pq.size() > 1) {
            y = pq.poll();
            x = pq.poll();
            if (x < y) {
                pq.offer(y - x);
            }
       }
       return pq.size() == 0 ? 0 : pq.poll();

    }
}

public class Question1046 {
    
}
