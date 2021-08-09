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
/*class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a,b)->a[0]-b[0]); 
        for (int i = 0; i < m; i++) {
            //第三个元素index代表的是对应的primes[i]所构成的丑数序列的索引位置
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
}*/

/**
k指针法。其实就是上面方法的进一步简化
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] p = new int[primes.length];   // 对应primes[i]的指针位置
        int[] ans = new int[n]; //丑数序列
        ans[0] = 1;
        int curr = 1;   
        while (curr < n){
            int next = Integer.MAX_VALUE;  
            for (int i=0; i<primes.length; ++i){
                int tmp = primes[i]*ans[p[i]];
                if (tmp > ans[curr-1] && tmp < next){ 
                    next = tmp;
                }
            }
            ans[curr] = next;
            ++curr;
            // 如果primes[i]对应指针p[i]能够使得得到的值与上述结果相等，则对应指针索引+1
            for (int i=0; i<primes.length; ++i){    
                if (next == primes[i]*ans[p[i]]) ++p[i];
            }
        }
        return ans[n-1];
    }
}

public class _8_9_Q313 {
    
}
