package 每日一题;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。

给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。

题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 */

/*class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        //小顶堆找第k次出现的，即为第k个顺序的元素
        PriorityQueue<Long> pQueue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pQueue.offer(1l);
        long temp;
        for (int i = 0; i < n-1; i++) {
            temp = pQueue.poll();
            for (int prime : primes) {
                //注意这里可能会溢出！！！！
                long addNum = temp * prime;
                if(!set.contains(addNum)){
                    set.add(addNum);
                    pQueue.offer(addNum);
                }
            }
        }
        temp = pQueue.poll();
        return (int) temp;
    }
}*/

//上面方法效率很低
//改用存放primes数组的m个元素指针的信息到优先队列
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a,b)->a[0]-b[0]); 
        for (int i = 0; i < m; i++) {
            pQueue.add(new int[]{primes[i], i, 0});
        }
        int[] ans = new int[n];
        ans[0] = 1;
        for (int j = 1; j < n; ) {
            int[] poll = pQueue.poll();
            int val = poll[0], i = poll[1], idx = poll[2];
            //出现重复元素时
            if (val != ans[j - 1]) ans[j++] = val;
            pQueue.add(new int[]{ans[idx + 1] * primes[i], i, idx + 1});
        }
        return ans[n - 1];
    }
}

public class _8_9_Q313 {
    
}
