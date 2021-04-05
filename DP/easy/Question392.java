package DP.easy;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）
字符而不改变剩余字符相对位置形成的新字符串。
（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

 */

 //只会依次判断，不太会DP orz
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.equals("")) return true;
        if(t.equals("")) return false;
        int index1 = 0;
        int index2 = 0;
        int m = s.length(); int n = t.length();
        while(index2 < n){
            if(s.charAt(index1) == t.charAt(index2)){
                index1++;
                index2++;
                if(index1 == m) return true;
            } else {
                index2++;
            }
        }
        return false;
    }
}

 //官方dp法，暂时有点懵
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}

public class Question392 {
    
}
