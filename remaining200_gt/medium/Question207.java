package remaining200_gt.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 你这个学期必须选修 numCourses 门课程，
 * 记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 
先修课程按数组 prerequisites 给出，
其中 prerequisites[i] = [ai, bi] ，
表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；
否则，返回 false 。
 */

 //注意每一门课程的先修课程可能不止一门！！！
 //拓扑排序，可以用dfs和bfs
//对比210题来看
class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        //加入每一门课程修完后可以修的后续课程
        for (int i = 0; i < prerequisites.length; i++) {
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int i){
        visited[i] = 1; //表示包含改节点的一条链正在被搜索
        for (int x : edges.get(i)) {
            if(visited[x] == 0){
                dfs(x);
                //每次dfs搜索完，都需要判断是否已经存在环
                if(!valid){
                    return;
                }
            }else if(visited[x] == 1){
                //此时表示该节点在一条链中被dfs搜索到了两次
                //也就是形成了一个环
                valid = false;
                return;
            }
            //其他情况就是visited[x] = 2
            //此时表示搜索到的节点之前搜索过，不会形成环
            //故这里不用再添加一个else判断
        }
        visited[i] = 2; //表示以该节点为头的链搜索完后没有环
    }
}
public class Question207 {
    
}
