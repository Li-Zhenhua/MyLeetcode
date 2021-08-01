package hot100;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
 */

 //感觉应该是找最长公共子序列长度，然后减
 //好像不太对
 //看了题解思路后发现其实确实跟上面想法很像
 //只不过动态规划的时候dp[i][j]表示的是
 //word1的前i个字符串转换成word2的前j个字符串所需要的步数
 /*
 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；

当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1

其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        //边界，第一列
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }
        //第一行
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i-1] + 1;
        }

        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j-1);
                if(c1 == c2) {
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}

public class Q72 {
    
}
