package 每日一题;

import java.util.Arrays;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。

h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。

例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 */

class Solution {
    public int hIndex(int[] citations) {
        //反过来遍历的思路看Question274.java
        //二分法思路看Question275.java
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            //当前位置后面有n-i-1篇论文
            //在该判定条件成立的情况下，n-i一定会不大于citations[i-1]
            //故可以直接返回n-i
            if(citations[i] > n-i-1){
                return n-i;
            }
        }
        return 0;
    }
}

public class _7_11_Q274 {
    
}
