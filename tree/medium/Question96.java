package tree.medium;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 
 * 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */

 //离谱，95题是II，96题是I
//还是懵了orz
//题解思路：
//假设 n 个节点存在二叉排序树的个数是 G (n)，
//令 f(i) 为以 i 为根的二叉搜索树的个数
//则G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
//当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
//f(i)=G(i−1)∗G(n−i)
 class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}

public class Question96 {
    
}
