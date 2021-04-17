package DP.easy;

/**
 * 斐波那契数
 */


 //一般用dp数组的动态规划
/*class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n ==1) return 1;

        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
}*/

//优化空间复杂度,即状态压缩
class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n ==1) return 1;
        int fib1 = 0;
        int fib2 = 1;
        int ans =  0;
        for (int i = 2; i < n+1; i++) {
            ans = fib1 + fib2;
            fib1 = fib2;
            fib2 = ans;
        }
        return ans;
    }
}

public class Question509 {
    
}
