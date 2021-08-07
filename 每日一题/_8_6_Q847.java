package 每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。

给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。

返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 */

//BFS+状态压缩，状态压缩即通常是用一串01数字（二进制数）来表示各个点的状态，想流水灯的状态一样
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1<<n]; //用于记录每个节点的某个状态是否出现过
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1<<i, 0}); //将每个节点都当做起始节点
            visited[i][1<<i] = true;
        }

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int index = temp[0], mask = temp[1], len = temp[2];
            if(mask == (1<<n)-1){
                return len;
            }

            for (int i : graph[index]) {
                int maskNext = mask | (1<<i);
                if(!visited[i][maskNext]){
                    queue.offer(new int[]{i,maskNext,len+1});
                    visited[i][maskNext] = true;
                }
            }
        }
        return 0;

    }
}

