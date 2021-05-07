package array.medium;

import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。

每一步只能移动到下一行中相邻的结点上。
相邻的结点 在这里指的是 下标 与 上一层结点下标 相同
或者等于 上一层结点下标 + 1 的两个结点。
也就是说，如果正位于当前行的下标 i ，
那么下一步可以移动到下一行的下标 i 或 i + 1 。

 */

class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int depth = triangle.size();
        int maxLen = depth;
        //int maxLen = triangle.get(triangle.size()-1).size();
        int[] dp = new int[maxLen];

        //初始化dp数组
        for (int i = 0; i < maxLen; i++) {
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }
        for (int i = depth-2; i >= 0; i--) {
            /* for (int j = i; j >= 0; j--) {
                //这样会在更新时覆盖导致后面数据出错
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            } */

            //得这样正着来，由Math.min(dp[j], dp[j+1])也可以看出
            //正着来更新dp[i]的值，此后不会再用到，故才是正确的
            for (int j = 0; j <= i; j++) {
                //这样会在更新时覆盖导致后面数据出错
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}

public class Question120 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        List<List<Integer>> triangle = 
    }
    

}
