package hot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。

请你重新构造并返回输入数组 people 所表示的队列。
返回的队列应该格式化为数组 queue ，
其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性
（queue[0] 是排在队列前面的人）。
 */

 //首先先按身高降序、ki升序排列
 //然后更改位置不对的人的位置即可，用链表可以快速实现插入删除节点
 //核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            else return b[0] - a[0];
        });

        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            //先安排高的，这样矮的直接插入就行
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[people.length][2]);
    }
}

public class Q406 {
    
}
