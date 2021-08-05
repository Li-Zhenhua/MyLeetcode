package 每日一题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。

对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。

返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。

该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 */


 //找环，在环上的点都不是安全点，三状态标记法+dfs
 //其实这好像也类似是垃圾回收的算法
/*class Solution {
    int[] flag;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        flag = new int[n];
        for(int i = 0; i < n; i++){
            if(dfs(graph,i)){
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean dfs(int[][] graph, int index){
        if(flag[index] == 1) return false;
        else if(flag[index] == 2) return true;

        flag[index] = 1;
        for(int temp : graph[index]){
            if(!dfs(graph,temp)){
                return false;
            }
        }
        flag[index] = 2;
        return true;
    }
}*/


//另一种解答，拓扑排序，环上的点入度一定不可能减为0，所以拓扑排序后的序列一定不含有环上的节点
//BFS方式进行解，就是先将入度为0的所有节点加入队列，然后依次遍历队列节点的所有出度
//即遍历所有由队中节点 x 直接指向的节点 y，对 y 做入度减一操作
//当y入度减为0的时候，即可入队列
//（当 y 的入度为 0，说明有向图中在 y 前面的所有的节点均被添加到拓扑序中，
//此时 y 可以作为拓扑序的某个片段的首部被添加，而不是违反拓扑序的定义）

//由于本题性质，可以运用反向图，即将【入度】替换为【出度】，出度为0的节点是安全点
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // 反图，邻接表存储
        List<List<Integer>> new_graph = new ArrayList<List<Integer>>();
        // 节点入度
        int[] Indeg = new int[n];


        for(int i = 0; i < n; i++) {
            new_graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                new_graph.get(graph[i][j]).add(i);
            }
            // 原数组记录的节点出度，在反图中就是入度
            Indeg[i] = graph[i].length;
        }

        // 拓扑排序
        Queue<Integer> q = new LinkedList<Integer>();

        // 首先将入度为 0 的点存入队列
        for(int i = 0; i < n; i++) {
            if(Indeg[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            // 每次弹出队头元素
            int cur = q.poll();
            for(int x : new_graph.get(cur)) {
                // 将以其为起点的有向边删除，更新终点入度
                Indeg[x]--;
                if(Indeg[x] == 0) q.offer(x);
            }
        }

        // 最终入度（原图中出度）为 0 的所有点均为安全点
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            if(Indeg[i] == 0) ret.add(i);
        }
        return ret;
    }
}

public class _8_5_Q802 {
    
}
