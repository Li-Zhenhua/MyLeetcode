package remaining200_gt.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，
你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，
返回你为了学完所有课程所安排的学习顺序。

可能会有多个正确的顺序，你只要返回一种就可以了。
如果不可能完成所有课程，返回一个空数组。
 */

//对比207题来看

class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    int[] visited;
    boolean valid = true;
    //List<Integer> courseList = new ArrayList<>();
    int[] courseList;
    int index = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        courseList = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            //为了防止使用栈，这里将指向相对于207题反转
            //从而实现了从栈到队列的变化
            //官方题解好像是模拟栈，index初始值设置为len-1

            //这里是加入每一门课程修之前需要修的前导课程
            edges.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if(visited[i] == 0){
                dfs(i);
            }
        }
        if(valid){
            return courseList;
        }else{
            return new int[0];
        }
    }

    public void dfs(int i){
        visited[i] = 1;
        for(int x : edges.get(i)){
            if(visited[x] == 0){
                dfs(x);
                if(!valid){
                    return;
                }
            }else if(visited[x] == 1){
                valid = false;
                return;
            }
        }
        visited[i] = 2;
        courseList[index] = i;
        index++;
    }
}

//bfs算法，入度为0的节点依次入队列，
//最终将所有入度都能够变为0的节点入队，
//如果入队的节点个数等于全部节点个数，则
//队列顺序也就是结果顺序
/*class Solution {
    // 存储有向图
    List<List<Integer>> edges;
    // 存储每个节点的入度
    int[] indeg;
    // 存储答案
    int[] result;
    // 答案下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // 将所有入度为 0 的节点放入队列中
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 从队首取出一个节点
            int u = queue.poll();
            // 放入答案中
            result[index++] = u;
            for (int v: edges.get(u)) {
                --indeg[v];
                // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}*/

public class Question210 {
    
}
