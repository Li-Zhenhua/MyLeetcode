package 每日一题;

/**
 * 泰波那契序列 Tn 定义如下： 

T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2

给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 */

 
//难得有一天有这么简单的题
//动态规划
class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int prev1 = 0, prev2 = 1, prev3 = 1;
        int curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = prev1 + prev2 + prev3;
            prev1 = prev2;
            prev2 = prev3;
            prev3 = curr;
        }
        return curr;
    }
}

public class _8_8_Q1137 {
    
}
