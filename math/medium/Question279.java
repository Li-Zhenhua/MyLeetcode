package math.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
 * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；
换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，
而 3 和 11 不是。
 */

 //这题感觉是一种经典背包问题/硬币问题
 //贪心算法
/*class Solution {
    Set<Integer> set = new HashSet<>();
    public int numSquares(int n) {
        int m = (int) Math.sqrt(n);
        for (int i = 0; i < m; i++) {
            set.add((i+1)*(i+1));
        }

        //贪心，总个数从小到大进行查找
        for (int i = 1; i <= n; i++) {
            if(findFactor(n, i)) return i;
        }
        return 0;

    }

    public boolean findFactor(int n, int count){
        if(count == 1){
            return set.contains(n);
        }


        for (Integer integer : set) {
            if(findFactor(n-integer, count-1)) return true;
        }
        return false;
    }
}*/

//相关问题标准常用的动态规划法，这个得记忆感觉
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是全部用1相加，个数总和为对应的i
            for (int j = 1; i - j * j >= 0; j++) { 
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }
}



//数学方法，简直降维打击
//每个自然数都可以表示为四个整数平方和
// n=(4^k)(8m+7)时，只能分解成4数平方和
//枚举验证是否能够分解成两数平方和
/*class Solution {

    //验证是否为平方数
    protected boolean isSquare(int n) {
      int sq = (int) Math.sqrt(n);
      return n == sq * sq;
    }
  
    public int numSquares(int n) {
      // four-square and three-square theorems.
      while (n % 4 == 0)
        n /= 4;
      if (n % 8 == 7)
        return 4;
  
      if (this.isSquare(n))
        return 1;
      // enumeration to check if the number can be decomposed into sum of two squares.
      for (int i = 1; i * i <= n; ++i) {
        if (this.isSquare(n - i * i))
          return 2;
      }
      // bottom case of three-square theorem.
      return 3;
    }
}*/

public class Question279 {
    
}
