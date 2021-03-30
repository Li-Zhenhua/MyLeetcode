package math.easy;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n <= 0 ||n % 2 != 0) return false;
        while( n > 0){
            if( n == 1) return true;
            if( n % 2 != 0) return false;
            n /= 2;
        }
        return false;
    }
}

public class Question231 {
    
}
