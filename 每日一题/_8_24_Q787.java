package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。

现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。

提示：

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
航班没有重复，且不存在自环
0 <= src, dst, k < n
src != dst
通过次数33,821
 */

 //第一想法就是dfs,超时了orz
 //如果要用，需要一个备忘录memo
/*class Solution {

    int minPrice = Integer.MAX_VALUE;
    Map<Integer,List<int[]>> map = new HashMap<>();
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        for (int[] flight : flights) {
            List<int[]> temp =  map.getOrDefault(flight[0], new ArrayList<>());
            temp.add(new int[]{flight[1],flight[2]});
            map.put(flight[0], temp);
        }

        dfs(src, dst, k, 0, 0);
        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }

    public void dfs(int src, int dst, int k, int len, int priceTotal){ 
        if(k+1 < len) return;
        
        if(src == dst){
            if(priceTotal < minPrice){
                minPrice = priceTotal;
            }
            return;
        }

        List<int[]> next = map.getOrDefault(src,null);
        if(next != null){
            for (int[] is : next) {
                dfs(is[0], dst, k, len+1, priceTotal+is[1]);
            }
        }
        
    }
}*/

//第二想法是动态规划
//dp[src][j]表示经过j步从src到dst点所需要的价格
//注意由于可能出现加法，导致最大值的设置不能是intege.max_value
//转移方程还是反应了好一阵orz
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[n][k+2];
        final int INF = 10000 * 100 + 1;
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], INF);
        }
        

        //初始值dp[dst][0] = 0;
        dp[dst][0] = 0;
        for (int j = 1; j <= k+1; j++) {
            for (int[] flight : flights) {
                dp[flight[0]][j] = Math.min(dp[flight[0]][j], flight[2] + dp[flight[1]][j-1]);
            }
        }

        int ans = INF;
        for (int i = 0; i <= k+1; i++) {
            if(dp[src][i] < ans){
                ans = dp[src][i];
            }
        }
        return ans == INF ? -1 : ans;
    }
}

//题解的BFS+剪枝方法
/*class Solution {

    int INF = 1000007;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return bfs(n, flights, src, dst, k);
    }

    private int bfs(int n, int[][] flights, int src, int dst, int k) {
        // 整理题目给定的flights，转换成每个节点的子节点有哪些
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            g[flight[0]].add(new int[] {flight[1], flight[2]});
        }

        // 表示src到i到最小价格
        int[] ans = new int[n];
        Arrays.fill(ans, INF);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, 0});
        // 退出条件加上 k 的限制
        while (!queue.isEmpty() && k + 1 > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] path : g[poll[0]]) {
                    int distance = poll[1] + path[1];
                    // 剪枝1，小于 i 之前记录的最小值，且小于 dst 之前记录的最小值
                    if (distance < ans[path[0]] && distance < ans[dst]) {
                        ans[path[0]] = distance;
                        // 剪枝2，到 dst 了就不用继续往下了
                        if (path[0] != dst) {
                            queue.offer(new int[] {path[0], distance});
                        }
                    }
                }
            }
            k--;
        }

        return ans[dst] >= INF ? -1 : ans[dst];
    }
}*/

public class _8_24_Q787 {
    
}
