package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）

二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。

译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。

提示：

n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i（即，不存在自环）
graph[i] 中的所有元素 互不相同
保证输入为 有向无环图（DAG）
 */

 //第一想到的当然是直接的dfs，看数据量应该可以过
 //过不了那就得用memo
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        temp.add(0);
        dfs(graph, 0, graph.length-1);
        return ans;
    }

    public void dfs(int[][] graph, int k, int n){
        if(k == n){
            ans.add(new ArrayList<>(temp));
            //temp.clear();
            return;
        }
        for (int point : graph[k]) {
            temp.add(point);
            dfs(graph, point, n);
            temp.remove(temp.size()-1);
        }
    }
}

public class _8_25_Q797 {
    
}
