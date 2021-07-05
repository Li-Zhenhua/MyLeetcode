package remaining200_gt.medium;

/**
 * 给定一个正整数 n，将其拆分为[至少]两个正整数的和，
 * 并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */

 //动态规划
 //令 k 是拆分出的第一个正整数，则剩下的部分是 n-k，
 //n−k 可以不继续拆分，或者继续拆分成至少两个正整数的和
class Solution {
    public int integerBreak(int n) {
        //dp[i]就表示整数i[拆分后]的最大乘积,不拆分就是它自己本身
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j < i; j++) {
                temp = Math.max(temp, Math.max(j*dp[i-j], j*(i-j)));
            }
            dp[i] = temp;
        }
        return dp[n];
    }
}

//数学方法
//经证明，将n拆分成n/x项，则乘积f(x)=x^(n/x),当x=e时极大值，整数时x=3极大
//则应尽可能多拆分出来更多项的3
//均分是根据几何平均数<=算数平均数
public int integerBreak(int n) {
    int p = n % 3, q = n / 3, r = p + (2 * p + 1) % 5;
    return n <= 3 ? n - 1 : (int)(Math.pow(3, q - (p & 1)) * r);
}

public class Question343 {
    
}
