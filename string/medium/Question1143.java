package string.medium;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。

该题即为比较热的最长公共子序列
 */

 //动态规划法
 //dp[i][j]表示text1的前i个字符串和text2的前j个字符串的最长公共子序列长度
 //还有一题经典的最长上升子序列第300题，这两题多练练
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        //int ans = 0;
        for (int i = 1; i <= len1; i++) {
            char c1 = text1.charAt(i-1);
            for (int j = 1; j <= len2; j++) {
                char c2 = text2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}

public class Question1143 {
    
}
