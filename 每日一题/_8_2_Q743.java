package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 有 n 个网络节点，标记为 1 到 n。

给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。

现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 */

 //Dijkstra最短路径算法，不会orz
 /*class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //之所以 inf 设置为 INT_MAX / 2，是因为在更新最短距离的时候，
        //要有两个距离相加，为了防止溢出 int 型，所以除以 2
        //即更新距离时的这一语句：Math.min(dist[y], dist[x] + g[x][y]);
        final int INF = Integer.MAX_VALUE / 2;

        // 邻接矩阵存储边信息
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            // 边序号从 0 开始
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        // 从源点到某点的距离数组
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        // 由于从 k 开始，所以该点距离设为 0，也即源点
        dist[k - 1] = 0;

        // 节点是否被更新数组
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; ++i) {
            // 在还未确定最短路的点中，寻找距离最小的点
            int x = -1;
            for (int y = 0; y < n; ++y) {
                //这里其实第一轮找到的x就是k-1
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }

            // 用该点更新所有其他点的距离
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        // 找到距离最远的点
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}*/

//小根堆优化
//使用一个小根堆来寻找「未确定节点」中与起点距离最近的点。
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            //用于存储从i到其他点的距离信息
            g[i] = new ArrayList<int[]>();
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x].add(new int[]{y, t[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        pq.offer(new int[]{0, k - 1});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int time = p[0], x = p[1];
            //这里表示已有的源点到x的距离小于从某个点到x的距离，故可以直接跳过
            if (dist[x] < time) {
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0], d = dist[x] + e[1];
                if (d < dist[y]) {
                    dist[y] = d;
                    pq.offer(new int[]{d, y});
                }
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}

public class _8_2_Q743 {
    
}
