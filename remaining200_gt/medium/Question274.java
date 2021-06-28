package remaining200_gt.medium;

import java.util.Arrays;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。

h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。

例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 */

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        //int ans = 0;
        for(int i = n-1; i >= 0; i--){
            //画个二维坐标也可以看出来
            if(citations[i] < n-i){ //即篇数大于每篇至少的引用数时，退出循环
                return n-i-1; //上一个篇数即为h指数
            }
        }
        return n;
    }
}

public class Question274 {
    
}
