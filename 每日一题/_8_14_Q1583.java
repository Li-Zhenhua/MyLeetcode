package 每日一题;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。

对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。

所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对。

但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：

x 与 u 的亲近程度胜过 x 与 y，且
u 与 x 的亲近程度胜过 u 与 v
返回 不开心的朋友的数目 。
 */

 /*大致思路如下：
1、遍历 x，找到与 x 配对的朋友 y。
2、找到 y 在 x 的朋友列表中的亲近程度下标，记为preXYIndex。
3、x 的朋友列表中的下标从 0 到 preXYIndex−1 的朋友都是可能的 u。遍历每个可能的 u，找到与 u 配对的 v。
4、如果 u 和 v 的亲近度下标大于 u 和 x 的亲近度下标，即 preMap[u][v] > preMap[u][x]，则 x 是不开心的朋友（下标越大越不亲近）。
 */


class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int ans = 0;
        //本来想用map，想想可以用数组替代
        int[] pairMap = new int[n];
        int[][] preMap = new int[n][n];

        for (int i = 0; i < n/2; i++) {
            pairMap[pairs[i][0]] = pairs[i][1];
            pairMap[pairs[i][1]] = pairs[i][0];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                //记录下标，这里可以不用排除premap[i][i]
                //是因为后面preferences[x][j]的j是从0开始的索引
                //premap[i][i]默认为0，不影响，因为一定会有一个其他的元素索引指向0
                preMap[i][preferences[i][j]] = j; 
            }
        }

        for (int x = 0; x < n; x++) {
            int y = pairMap[x];
            int preXYIndex = preMap[x][y];
            //小于XY亲近程度的索引对应的friend都有可能是u
            for (int j = 0; j < preXYIndex; j++) {
                int u = preferences[x][j];
                int v = pairMap[u];
                if(preMap[u][v] > preMap[u][x]){
                    //索引小则越亲近,存在一个u则该对应的x就是不开心的
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}

public class _8_14_Q1583 {
    
}
