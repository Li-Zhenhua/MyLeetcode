package 每日一题;

import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数

进阶：

1、如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
    这种情况，我们可以考虑建一个 0 到 100 的数组，记录传入的 num 出现的次数，
并记录一个总次数，遍历数组即可很快找到中位数，因为数组大小只有 100，这个过程非常快。
（上面思想也就是计数排序）

2、如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
    这种情况，跟上面类似，建一个 0 到 102 的数组，0 号位置表示 -1，
1号位置表示 0，...，102号位置表示 101，小于 0 的数出现的次数记录到 0 号位，
大于 100 的数出现的次数记录到 102 号位置，查找中位数的逻辑跟上面一样，
遍历一下数组即可。

 */

 //维护两个优先队列，分别为左半边最大堆以及右半边最小堆
 //左半边最大堆
class MedianFinder {

    PriorityQueue<Integer> leftPart;
    PriorityQueue<Integer> rightPart;
    /** initialize your data structure here. */
    public MedianFinder() {
        leftPart = new PriorityQueue<>((a,b) -> b-a);
        rightPart = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        //当左半最大堆为空或者num小于等于leftPart的顶端值
        if(leftPart.size() == 0 || num <= leftPart.peek()){
            leftPart.offer(num);
            //左边堆的个数比右边多2个时要将左边最大的数放到右边
            if(leftPart.size() > rightPart.size() + 1){
                rightPart.offer(leftPart.poll());
            }
        } else {
            rightPart.offer(num);
            //右边堆的个数比左边多时要将右边最小的数放到左边
            if(rightPart.size() > leftPart.size()){
                leftPart.offer(rightPart.poll());
            }
        }
    }
    
    public double findMedian() {
        if(leftPart.size() == rightPart.size()){
            return (double)(leftPart.peek() + rightPart.peek()) / 2;
        } else {
            return (double)leftPart.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

public class _8_27_Q295 {
    
}
