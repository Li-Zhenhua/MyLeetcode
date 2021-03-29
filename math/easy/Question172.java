package math.easy;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 */

 //有点难，没想到
class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        while (n > 0) {//其实本质就是计算因子5的个数，因为因子2的个数一定是多于5的，两者取其少的那个
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;       
    }    
}

public class Question172 {
    
}
