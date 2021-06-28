package remaining200_gt.medium;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。

h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 */

 //对比看274题，274题就是O（n）做法
 /*class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(citations[n-1] == 0) return 0; // 全0的时候的情况
        int left = 0, right = n-1;
        while(left < right){
            int mid = left + (right-left+1)/2; //中点向上取整是防止下面的left出现死循环
            if(citations[n-mid-1] > mid){
                left = mid; //注意这里与一般的二分有点不同
            }else{
                right = mid - 1;
            }
        }
        return left+1; //因为这个对应的是i下标
    }
}*/

//官方二分法，简单多了orz，感觉想复杂了
class Solution {
    public int hIndex(int[] citations) {
      int idx = 0, n = citations.length;
      int pivot, left = 0, right = n - 1;
      while (left <= right) {
        pivot = left + (right - left) / 2;
        if (citations[pivot] == n - pivot) return n - pivot;
        else if (citations[pivot] < n - pivot) left = pivot + 1;
        else right = pivot - 1;
      }
      return n - left;
    }
}

public class Question275 {
    
}
