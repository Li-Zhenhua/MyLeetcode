package string.medium;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */

 //第一反应是动态规划
/*class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int maxLen = 1;
        // boolean[][] dp = new boolean[n][n]; //dp[i][j]表示s[i]到s[j]是否是回文
        // for (int i = 0; i < n; i++) {
        //     dp[i][i] = true;
        // }
        // //因为根据转移方程，右上依赖于左下的
        // for (int i = n-1; i >= 0; i--) {
        //     for (int j = i+1; j < n; j++) {
        //         //if(i+1 > j-1) continue;
        //         if(j-i == 1){
        //             dp[i][j] = (s.charAt(i) == s.charAt(j));
        //         }else{
        //             dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
        //         }
                
        //         if(dp[i][j] && (j-i+1 > maxLen)){
        //             maxLen = j-i+1;
        //             left = i;
        //             right = j;
        //         }
        //     }
        // } 

        //优化空间，其实只要矩阵右上三角就行
        //可以只需要存一列，迭代覆盖就行
        //这里写着写着发现有点变化，上面按行这里按列
        boolean[] dp = new boolean[n];
        //其中第一列可以不用再计算，直接从第二列开始
        //第二列开始迭代
        for (int j = 1; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if(j-i <= 1){
                    dp[i] = (s.charAt(i) == s.charAt(j));
                }else{
                    dp[i] = dp[i+1] && (s.charAt(i) == s.charAt(j));
                }

                if(dp[i] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1); //含左不含右
    }
}*/

//看了题解思路后写的中心扩散法
//由于存在奇数的字符串和偶数的字符串，
//所以我们需要从某一个字符开始扩展，或者从两个字符之间开始扩展
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int lenMax = 1;
        int left = 0, right = 0;
        for (int i = 1; i < n-1; i++) {
            int len1 = expand(s, i, i);//返回值一定是奇数
            int len2 = expand(s, i, i+1);//返回值一定是偶数
            int lenTemp = Math.max(len1, len2);
            if(lenTemp > lenMax){
                lenMax = lenTemp;
                left = i - (lenTemp-1)/2;
                right = i + (lenTemp/2);
            }
        }
        return s.substring(left, right+1);
    }

    public int expand(String s, int left, int right){
        int n = s.length();
        int len = 1;
        while(left >=0 && right < n && s.charAt(left) == s.charAt(right)){
            len = right - left +1;
            left--;
            right++;
        }
        return len;
    }
}

//Manacher's Algorithm 马拉车算法
//复杂度为O(n) 的Manacher 算法。然而本算法十分复杂，一般不作为面试内容。
/*public String preProcess(String s) {
    int n = s.length();
    if (n == 0) {
        return "^$";
    }
    String ret = "^";
    for (int i = 0; i < n; i++)
        ret += "#" + s.charAt(i);
    ret += "#$";
    return ret;
}

// 马拉车算法
public String longestPalindrome2(String s) {
    String T = preProcess(s);
    int n = T.length();
    int[] P = new int[n];
    int C = 0, R = 0;
    for (int i = 1; i < n - 1; i++) {
        int i_mirror = 2 * C - i;
        if (R > i) {
            P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
        } else {
            P[i] = 0;// 等于 R 的情况
        }

        // 碰到之前讲的三种情况时候，需要利用中心扩展法
        while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
            P[i]++;
        }

        // 判断是否需要更新 R
        if (i + P[i] > R) {
            C = i;
            R = i + P[i];
        }

    }

    // 找出 P 的最大值
    int maxLen = 0;
    int centerIndex = 0;
    for (int i = 1; i < n - 1; i++) {
        if (P[i] > maxLen) {
            maxLen = P[i];
            centerIndex = i;
        }
    }
    int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
    return s.substring(start, start + maxLen);
}*/


public class Question5 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestPalindrome("aaaa");
    }
}
