package 每日一题;

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。

子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */

 //字符串问题一般都是动态规划之类的
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n == 1) return 1;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        //dp[i][j] = dp[i+1][j-1] + 2 -> if s[i] = s[j]
        //dp[i][j] = max(dp[i+1][j],dp[i][j-1]) -> else
        //因为只需要取矩阵的右上部分，故当i>j时，dp[i][j] = 0
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}

public class _8_12_Q516 {
    
}
